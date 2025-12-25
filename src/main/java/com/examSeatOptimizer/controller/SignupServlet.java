package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import com.examSeatOptimizer.dao.AdminDAO;
import com.examSeatOptimizer.model.Admin;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    protected void doGet(HttpServletRequest r,HttpServletResponse s)
            throws IOException {
        System.out.println("➡️ Signup GET");
        s.sendRedirect("signup.html");
    }

    protected void doPost(HttpServletRequest r,HttpServletResponse s)
            throws IOException {

        System.out.println("➡️ Signup POST");

        Admin a = new Admin(
                r.getParameter("name"),
                r.getParameter("email"),
                r.getParameter("password")
        );

        if(new AdminDAO().register(a))
            s.sendRedirect("login");
        else
            s.sendRedirect("signup");
    }
}
