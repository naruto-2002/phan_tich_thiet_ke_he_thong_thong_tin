package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.dao.HoaDonMuaDAO198;
import com.example.de_9_qlstdm.dao.MatHangDAO198;
import com.example.de_9_qlstdm.dao.MatHangMuaDAO198;
import com.example.de_9_qlstdm.dao.ThanhVienDAO198;
import com.example.de_9_qlstdm.model.HoaDonMua198;
import com.example.de_9_qlstdm.model.MatHangMua198;
import com.example.de_9_qlstdm.model.ThanhVien198;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/trang-duyet-don", "/xac-nhan-duyet-don"})
public class DuyetDon198 extends HttpServlet {
    private HoaDonMuaDAO198 hoaDonMuaDAO = new HoaDonMuaDAO198();
    private ThanhVienDAO198 thanhVienDAO = new ThanhVienDAO198();
    private MatHangMuaDAO198 matHangMuaDAO = new MatHangMuaDAO198();
    private MatHangDAO198 matHangDAO = new MatHangDAO198();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/trang-duyet-don":
                showTrangDuyetDon(request, response);
                break;
            case "/xac-nhan-duyet-don":
                xacNhanDuyetDon(request, response);
                break;
            default:
                System.out.println("Invalid");
        }
    }

    private void showTrangDuyetDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hdmId_raw = request.getParameter("hdmId");
        String nvkId_raw = request.getParameter("nvkId");
        int hdmId, khId, nvkId;
        try {
            hdmId = Integer.parseInt(hdmId_raw);
            nvkId = Integer.parseInt(nvkId_raw);

            HoaDonMua198 hdm = hoaDonMuaDAO.selectHoaDonMuaByID(hdmId);

            int _hdmId = hdm.getId();
            List<MatHangMua198> lmhm = matHangMuaDAO.selectMatHangMuaByHoaDonMuaID(_hdmId);
            for (MatHangMua198 mhm: lmhm) {
                int mhId = mhm.getMh().getId();
                mhm.setMh(matHangDAO.selectMatHangByID(mhId));
            }

            hdm.setKh(thanhVienDAO.selectThanhVienByID(hdm.getKh().getId()));
            hdm.setNvk(thanhVienDAO.selectThanhVienByID(nvkId));
            hdm.setLmhm(lmhm);

            List<ThanhVien198> lnvgh = thanhVienDAO.selectThanhVienByVaiTro(3);

            request.setAttribute("hdm", hdm);
            request.setAttribute("lnvgh", lnvgh);

            request.getRequestDispatcher("./trang_duyet_don/index.jsp").forward(request, response);
        }catch (Exception ex) {

        }
    }

    private void xacNhanDuyetDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hdmId_raw = request.getParameter("hdmId");
        String nvkId_raw = request.getParameter("nvkId");
        String nvghId_raw = request.getParameter("nvghId");

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngayDuyet = currentDate.format(formatter);

        String ngayGiao = request.getParameter("ngayGiao");


        int hdmId, nvkId, nvghId;
        try {
            hdmId = Integer.parseInt(hdmId_raw);
            nvkId = Integer.parseInt(nvkId_raw);
            nvghId = Integer.parseInt(nvghId_raw);
//            Cập nhật hóa đơn
            hoaDonMuaDAO.updateHoaDonMua(hdmId, nvkId, nvghId, ngayDuyet, ngayGiao);

            List<MatHangMua198> lmhm = matHangMuaDAO.selectMatHangMuaByHoaDonMuaID(hdmId);
            for (MatHangMua198 mhm: lmhm) {
                int mhId = mhm.getMh().getId();
                mhm.setMh(matHangDAO.selectMatHangByID(mhId));
                int soLuong = mhm.getMh().getSoLuong() - mhm.getSoLuong();
//                Câp nhât số lượng mặt hàng sau khi đã duyệt đơn
                matHangDAO.updateSoLuong(mhId, soLuong);
            }

           response.sendRedirect("./danh-sach-hoa-don-mua");
        }catch (Exception ex) {

        }
    }

    public void destroy() {
    }
}