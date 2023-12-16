package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.dao.HoaDonMuaDAO198;
import com.example.de_9_qlstdm.dao.ThanhVienDAO198;
import com.example.de_9_qlstdm.model.HoaDonMua198;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/danh-sach-hoa-don-mua"})
public class DanhSachHoaDonMua198 extends HttpServlet {

    private HoaDonMuaDAO198 hoaDonMuaDAO = new HoaDonMuaDAO198();
    private ThanhVienDAO198 thanhVienDAO = new ThanhVienDAO198();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/danh-sach-hoa-don-mua":
                showDanhSachHoaDonNhap(request, response);
                break;
            default:
                System.out.println("Invalid");
        }
    }

    private void showDanhSachHoaDonNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HoaDonMua198> lhdm = hoaDonMuaDAO.selectAll();

        for(HoaDonMua198 hdm: lhdm) {
            int khId = hdm.getKh().getId();
            hdm.setKh(thanhVienDAO.selectThanhVienByID(khId));
        }

        request.setAttribute("lhdm", lhdm);
        request.getRequestDispatcher("./danh_sach_hoa_don_mua/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}