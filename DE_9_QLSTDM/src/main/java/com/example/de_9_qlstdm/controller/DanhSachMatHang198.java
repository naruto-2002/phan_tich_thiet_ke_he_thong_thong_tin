package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.dao.MatHangDAO198;
import com.example.de_9_qlstdm.model.MatHang198;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/danh-sach-mat-hang", "/xem-chi-tiet"})
public class DanhSachMatHang198 extends HttpServlet {
    MatHangDAO198 matHangDAO = new MatHangDAO198();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/danh-sach-mat-hang":
                showDanhSachMatHangByTen(request, response);
                break;

            default:
                System.out.println("Invalid");

        }
    }

    private void showDanhSachMatHangByTen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("search-value");
        List<MatHang198> lmh;
        if(ten == null) {
            lmh = matHangDAO.selectAll();
        }else {
            lmh = matHangDAO.selectMatHangByTen(ten);
        }
        request.setAttribute("lmh", lmh);
        request.getRequestDispatcher("./danh_sach_mat_hang/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}