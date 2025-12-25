package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.examSeatOptimizer.dao.DBConnection;

@WebServlet("/view")
public class ViewSeatsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        StringBuilder html = new StringBuilder();

        html.append("<html><head><title>Seating Chart</title></head>");
        html.append("<body style='background:#0f172a;color:white;font-family:Segoe UI;'>");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement roomPS =
                    con.prepareStatement("SELECT id,room_no FROM room");
            ResultSet rooms = roomPS.executeQuery();

            PreparedStatement seatPS =
                    con.prepareStatement(
                            "SELECT student.rollno,student.department,allocation.seat_no "+
                                    "FROM allocation JOIN student ON allocation.student_id=student.id "+
                                    "WHERE allocation.room_id=? ORDER BY allocation.seat_no");

            while (rooms.next()) {
                int roomId = rooms.getInt("id");
                String roomNo = rooms.getString("room_no");

                html.append("<h2>🏫 Room : ").append(roomNo).append("</h2>");
                html.append("<div style='display:grid;grid-template-columns:repeat(6,1fr);gap:10px;'>");

                seatPS.setInt(1, roomId);
                ResultSet seats = seatPS.executeQuery();

                while (seats.next()) {
                    html.append("<div style='padding:10px;border-radius:6px;background:#1e293b;text-align:center;'>");
                    html.append("<b>").append(seats.getString("rollno")).append("</b><br>");
                    html.append("<span style='color:#a78bfa;'>").append(seats.getString("department")).append("</span>");
                    html.append("</div>");
                }
                html.append("</div><hr style='margin:30px 0;'>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        html.append("</body></html>");
        res.getWriter().print(html.toString());
    }
}
