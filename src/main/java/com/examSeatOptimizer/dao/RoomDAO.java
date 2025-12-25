package com.examSeatOptimizer.dao;

import java.sql.*;
import com.examSeatOptimizer.model.Room;

public class RoomDAO {

    public void save(Room r){
        try{
            PreparedStatement ps = DBConnection.getConnection()
                    .prepareStatement("INSERT INTO room(room_no,capacity) VALUES(?,?)");
            ps.setString(1, r.getRoomNo());
            ps.setInt(2, r.getCapacity());
            ps.executeUpdate();
        }catch(Exception e){ e.printStackTrace(); }
    }
}
