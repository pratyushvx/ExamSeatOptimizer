package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.*;
import com.examSeatOptimizer.dao.DBConnection;

@WebServlet("/view")
public class ViewSeatsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletResponse res)
            throws IOException, ServletException {

        req.getRequestDispatcher("view.html").forward(req,res);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse res)
            throws IOException {

        res.setContentType("application/json");
        StringBuilder json = new StringBuilder("[");

        try{
            Connection con = DBConnection.getConnection();
            ResultSet rooms = con.createStatement()
                    .executeQuery("SELECT id,room_no FROM room");

            while(rooms.next()){
                int roomId = rooms.getInt("id");
                json.append("{\"room\":\"").append(rooms.getString("room_no"))
                        .append("\",\"seats\":[");

                ResultSet seats = con.createStatement().executeQuery(
                        "SELECT student.rollno,student.department FROM allocation "+
                                "JOIN student ON allocation.student_id=student.id "+
                                "WHERE allocation.room_id="+roomId+" ORDER BY seat_no");

                while(seats.next()){
                    json.append("{\"roll\":\"").append(seats.getString(1))
                            .append("\",\"dept\":\"").append(seats.getString(2))
                            .append("\"},");
                }
                if(json.charAt(json.length()-1)==',') json.deleteCharAt(json.length()-1);
                json.append("]},");
            }
            if(json.charAt(json.length()-1)==',') json.deleteCharAt(json.length()-1);

        }catch(Exception e){e.printStackTrace();}

        json.append("]");
        res.getWriter().print(json.toString());
    }
}
