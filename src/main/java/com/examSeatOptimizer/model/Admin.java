package com.examSeatOptimizer.model;

public class Admin {
    private int id;
    private String name;
    private String email;
    private String password;

    public Admin(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }
    public Admin(){}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public void setId(int id){this.id=id;}
}
