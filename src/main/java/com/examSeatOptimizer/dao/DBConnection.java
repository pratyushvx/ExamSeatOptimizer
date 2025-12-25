package com.examSeatOptimizer.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/examseatdb",
                    "root",
                    "cusat123"
            );
            System.out.println("DB Connected");
            return conn;

        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
