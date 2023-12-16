package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.dao.HoaDonMuaDAO198;
import com.example.de_9_qlstdm.dao.MatHangDAO198;
import com.example.de_9_qlstdm.dao.MatHangMuaDAO198;
import com.example.de_9_qlstdm.dao.ThanhVienDAO198;
import com.example.de_9_qlstdm.model.HoaDonMua198;
import com.example.de_9_qlstdm.model.MatHangMua198;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/chi-tiet-hoa-don-mua")
public class ChiTietHoaDonMua198 extends HttpServlet {
    private HoaDonMuaDAO198 hoaDonMuaDAO = new HoaDonMuaDAO198();
    private ThanhVienDAO198 thanhVienDAO = new ThanhVienDAO198();
    private MatHangMuaDAO198 matHangMuaDAO = new MatHangMuaDAO198();
    private MatHangDAO198 matHangDAO = new MatHangDAO198();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/chi-tiet-hoa-don-mua":
                showTrangChiTietHoaDonMua(request, response);
                break;
            default:
                System.out.println("Invalid");

        }
    }

    private void showTrangChiTietHoaDonMua(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hdmId_raw = request.getParameter("hdmId");
        int hdmId, khId, nvkId, nvghId;
        try {
            hdmId = Integer.parseInt(hdmId_raw);
            HoaDonMua198 hdm = hoaDonMuaDAO.selectHoaDonMuaByID(hdmId);
            khId = hdm.getKh().getId();
            nvkId = hdm.getNvk().getId();
            nvghId = hdm.getNvgh().getId();

            hdm.setKh(thanhVienDAO.selectThanhVienByID(khId));
            hdm.setNvk(thanhVienDAO.selectThanhVienByID(nvkId));
            hdm.setNvgh(thanhVienDAO.selectThanhVienByID(nvghId));


            List<MatHangMua198> lmhm = matHangMuaDAO.selectMatHangMuaByHoaDonMuaID(hdmId);
            for (MatHangMua198 mhm: lmhm) {
                int mhId = mhm.getMh().getId();
                mhm.setMh(matHangDAO.selectMatHangByID(mhId));
            }
            hdm.setLmhm(lmhm);

            request.setAttribute("hdm", hdm);

            request.getRequestDispatcher("./trang_chi_tiet_hoa_don_mua/index.jsp").forward(request, response);
        }catch (Exception ex) {

        }
    }

    public void destroy() {
    }
}