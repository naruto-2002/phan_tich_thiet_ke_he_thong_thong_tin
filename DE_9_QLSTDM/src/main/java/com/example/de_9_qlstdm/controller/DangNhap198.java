package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.dao.ThanhVienDAO198;
import com.example.de_9_qlstdm.model.ThanhVien198;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/dang-nhap", "/trang-dang-nhap"})
public class DangNhap198 extends HttpServlet {
    ThanhVienDAO198 thanhVienDAO = new ThanhVienDAO198();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/trang-dang-nhap":
                showTrangDangNhap(request, response);
                break;

            default:
                System.out.println("Invalid");

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/dang-nhap":
                dangNhap(request, response);
                break;

            default:
                System.out.println("Invalid");

        }
    }

    private void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String matKhau = request.getParameter("password");

        ThanhVien198 tv = thanhVienDAO.selectThanhVienByEmailAndMatKhau(email, matKhau);
        Gson gson = new Gson();
        String json = gson.toJson(tv);

        HttpSession session = request.getSession();
        session.setAttribute("thanhVien", json);
        // Đặt thời gian sống của phiên là 30 phút (1800 giây)
        session.setMaxInactiveInterval(1800);

        response.sendRedirect("./trang-chu");
    }

    private void showTrangDangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./trang_dang_nhap/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}