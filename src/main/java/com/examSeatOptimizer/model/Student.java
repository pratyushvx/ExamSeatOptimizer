package com.examSeatOptimizer.model;

public class Student {
    private int id;
    private String name,rollno,department;

    public Student(String n,String r,String d){
        name=n; rollno=r; department=d;
    }

    public String getName(){return name;}
    public String getRollno(){return rollno;}
    public String getDepartment(){return department;}
}
