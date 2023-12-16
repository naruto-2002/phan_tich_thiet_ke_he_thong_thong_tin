package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.dao.MatHangDAO198;
import com.example.de_9_qlstdm.model.MatHang198;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/trang-xem-chi-tiet-mat-hang")
public class XemChiTietMatHang198 extends HttpServlet {
    MatHangDAO198 matHangDAO = new MatHangDAO198();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/trang-xem-chi-tiet-mat-hang":
                showTrangXemChiTietMatHang(request, response);
                break;
            default:
                System.out.println("Invalid");

        }
    }

    private void showTrangXemChiTietMatHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(_id);
            MatHang198 mh = matHangDAO.selectMatHangByID(id);
            request.setAttribute("matHang", mh);
            request.getRequestDispatcher("./trang_chi_tiet_mat_hang/index.jsp").forward(request, response);
        }catch (Exception ex) {

        }
    }

    public void destroy() {
    }
}