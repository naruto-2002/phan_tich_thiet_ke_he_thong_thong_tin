package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.dao.ThanhVienDAO198;
import com.example.de_9_qlstdm.model.ThanhVien198;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/dang-ky", "/trang-dang-ky"})
public class DangKy198 extends HttpServlet {
    ThanhVienDAO198 thanhVienDAO = new ThanhVienDAO198();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/trang-dang-ky":
                showTrangDangKy(request, response);
                break;
            default:
                System.out.println("Invalid");

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/dang-ky":
                dangKy(request, response);
                break;

            default:
                System.out.println("Invalid");

        }
    }

    private void showTrangDangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./trang_dang_ky/index.jsp").forward(request, response);
    }
    private void dangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("member-name");
        String mgayThangNamSinh = request.getParameter("date-of-birth");
        String diaChi = request.getParameter("address");
        String sdt = request.getParameter("phone-number");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("password");

        ThanhVien198 thanhVien = new ThanhVien198(ten, mgayThangNamSinh, diaChi, sdt, email, matKhau, 1);
        thanhVienDAO.insertThanhVien(thanhVien);

        response.sendRedirect("./trang-dang-nhap");
    }



    public void destroy() {
    }
}