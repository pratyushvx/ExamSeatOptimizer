package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import com.examSeatOptimizer.dao.AdminDAO;
import com.examSeatOptimizer.model.Admin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest r,HttpServletResponse s)
            throws IOException {
        System.out.println("➡️ Login GET");
        s.sendRedirect("login.html");
    }

    protected void doPost(HttpServletRequest r,HttpServletResponse s)
            throws IOException {

        System.out.println("➡️ Login POST");

        Admin a = new AdminDAO().login(
                r.getParameter("email"),
                r.getParameter("password")
        );

        if(a!=null)
            s.sendRedirect("start.html");
        else
            s.sendRedirect("login");
    }
}
