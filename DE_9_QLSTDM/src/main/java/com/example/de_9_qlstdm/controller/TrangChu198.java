package com.example.de_9_qlstdm.controller;

import com.example.de_9_qlstdm.model.ThanhVien198;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/trang-chu"})
public class TrangChu198 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/trang-chu":
                showTrangChu(request, response);
                break;
            default:
                System.out.println("Invalid");

        }
    }

    private void showTrangChu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./trang_chu/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}