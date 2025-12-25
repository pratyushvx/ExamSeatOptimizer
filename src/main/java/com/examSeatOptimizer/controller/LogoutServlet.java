package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        // Destroy session
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }

        // Redirect to login page
        res.sendRedirect(req.getContextPath() + "/login");
    }
}
