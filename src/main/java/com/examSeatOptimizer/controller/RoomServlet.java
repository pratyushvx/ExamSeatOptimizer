package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.examSeatOptimizer.dao.DBConnection;
import com.examSeatOptimizer.dao.RoomDAO;
import com.examSeatOptimizer.model.Room;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {

    // Load room.html page
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.sendRedirect("room.html");
    }

    // Save total rooms
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int totalRooms = Integer.parseInt(req.getParameter("total_rooms"));

        try {
            Connection con = DBConnection.getConnection();

            // STEP 1: clear previous rooms
            con.prepareStatement("DELETE FROM room").executeUpdate();

            // STEP 2: recreate rooms
            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO room(room_no,capacity) VALUES(?,24)");

            for(int i=1;i<=totalRooms;i++){
                ps.setString(1, "R" + (100+i));
                ps.executeUpdate();
            }
        } catch(Exception e){ e.printStackTrace(); }

        res.sendRedirect("start.html");
    }
}
