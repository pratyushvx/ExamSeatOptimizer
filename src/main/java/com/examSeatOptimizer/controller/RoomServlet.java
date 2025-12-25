package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import com.examSeatOptimizer.dao.RoomDAO;
import com.examSeatOptimizer.model.Room;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest r,HttpServletResponse s) throws IOException{
        s.sendRedirect("room.html");
    }

    protected void doPost(HttpServletRequest r,HttpServletResponse s) throws IOException{
        Room rm = new Room(
                r.getParameter("room_no"),
                Integer.parseInt(r.getParameter("capacity"))
        );
        new RoomDAO().save(rm);
        s.sendRedirect("index.jsp");
    }
}
