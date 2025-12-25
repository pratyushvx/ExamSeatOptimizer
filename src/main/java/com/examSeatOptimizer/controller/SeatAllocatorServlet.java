package com.examSeatOptimizer.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.examSeatOptimizer.dao.DBConnection;

@WebServlet("/allocate")
public class SeatAllocatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletResponse res)
            throws IOException {

        try {
            Connection con = DBConnection.getConnection();
            con.prepareStatement("DELETE FROM allocation").executeUpdate();

            // Step 1: Fetch students
            PreparedStatement ps =
                    con.prepareStatement("SELECT id,department FROM student");
            ResultSet rs = ps.executeQuery();

            // Step 2: Group by department
            Map<String, Queue<Integer>> map = new LinkedHashMap<>();
            while(rs.next()){
                String dept = rs.getString("department");
                int id = rs.getInt("id");
                map.putIfAbsent(dept, new LinkedList<>());
                map.get(dept).add(id);
            }

            // Step 3: Fetch rooms
            PreparedStatement psRoom =
                    con.prepareStatement("SELECT id,capacity FROM room");
            ResultSet rooms = psRoom.executeQuery();

            PreparedStatement insert =
                    con.prepareStatement(
                            "INSERT INTO allocation(student_id,room_id,seat_no) VALUES(?,?,?)");

            // Step 4: Round-robin allocation
            while(rooms.next()){
                int roomId = rooms.getInt("id");
                int cap = rooms.getInt("capacity");
                int seat = 1;

                while(seat <= cap && !map.isEmpty()){
                    Iterator<Map.Entry<String,Queue<Integer>>> it = map.entrySet().iterator();
                    while(it.hasNext() && seat <= cap){
                        Queue<Integer> q = it.next().getValue();
                        if(q.isEmpty()){
                            it.remove();
                            continue;
                        }
                        int sid = q.poll();
                        insert.setInt(1,sid);
                        insert.setInt(2,roomId);
                        insert.setInt(3,seat++);
                        insert.executeUpdate();
                    }
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
