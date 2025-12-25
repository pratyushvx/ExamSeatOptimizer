package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import com.examSeatOptimizer.dao.StudentDAO;
import com.examSeatOptimizer.model.Student;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest r,HttpServletResponse s) throws IOException{
        s.sendRedirect("student.html");
    }

    protected void doPost(HttpServletRequest r,HttpServletResponse s) throws IOException{
        Student st = new Student(
                r.getParameter("name"),
                r.getParameter("rollno"),
                r.getParameter("department")
        );
        new StudentDAO().save(st);
        s.sendRedirect("index.jsp");
    }
}
