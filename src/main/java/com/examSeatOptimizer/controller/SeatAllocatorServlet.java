package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.examSeatOptimizer.dao.DBConnection;
import com.examSeatOptimizer.algorithm.GraphColoringAllocator;

@WebServlet("/allocate")
public class SeatAllocatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletResponse res)
            throws IOException {

        try{
            Connection con = DBConnection.getConnection();
            con.prepareStatement("DELETE FROM allocation").executeUpdate();

            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT id,department FROM student ORDER BY department");

            Map<String, Queue<Integer>> base = new LinkedHashMap<>();
            while(rs.next()){
                base.putIfAbsent(rs.getString(2), new LinkedList<>());
                base.get(rs.getString(2)).add(rs.getInt(1));
            }

            ResultSet rooms = con.createStatement().executeQuery("SELECT id FROM room");
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO allocation(student_id,room_id,seat_no) VALUES(?,?,?)");

            GraphColoringAllocator algo = new GraphColoringAllocator();

            while(rooms.next()){
                int rid = rooms.getInt(1);

                Map<String,Queue<Integer>> map = new LinkedHashMap<>();
                base.forEach((k,v)->map.put(k,new LinkedList<>(v)));

                int[][] grid = algo.generateLayout(map);
                int seat=1;

                for(int r=0;r<8;r++)
                    for(int c=0;c<3;c++){
                        ps.setInt(1,grid[r][c]);
                        ps.setInt(2,rid);
                        ps.setInt(3,seat++);
                        ps.executeUpdate();
                    }
            }

        }catch(Exception e){e.printStackTrace();}

        res.sendRedirect("view");
    }
}