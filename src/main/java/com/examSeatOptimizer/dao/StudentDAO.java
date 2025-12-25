package com.examSeatOptimizer.dao;
import java.sql.*;
import com.examSeatOptimizer.model.Student;

public class StudentDAO {

    public void save(Student s){
        try{
            PreparedStatement ps=DBConnection.getConnection()
                    .prepareStatement("INSERT INTO student(name,rollno,department) VALUES(?,?,?)");
            ps.setString(1,s.getName());
            ps.setString(2,s.getRollno());
            ps.setString(3,s.getDepartment());
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }
}
