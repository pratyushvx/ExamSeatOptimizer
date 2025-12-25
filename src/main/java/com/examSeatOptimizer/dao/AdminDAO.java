package com.examSeatOptimizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.examSeatOptimizer.model.Admin;

public class AdminDAO {

    public boolean register(Admin a){
        try{
            Connection con= com.examSeatOptimizer.dao.DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "INSERT INTO admin(name,email,password) VALUES(?,?,?)");
            ps.setString(1,a.getName());
            ps.setString(2,a.getEmail());
            ps.setString(3,a.getPassword());
            ps.executeUpdate();
            return true;
        }catch(Exception e){e.printStackTrace();}
        return false;
    }

    public Admin login(String email,String pass){
        try{
            Connection con= com.examSeatOptimizer.dao.DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "SELECT * FROM admin WHERE email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,pass);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Admin a = new Admin(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                a.setId(rs.getInt("id"));
                return a;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
