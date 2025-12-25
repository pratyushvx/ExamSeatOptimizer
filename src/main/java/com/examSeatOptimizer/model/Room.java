package com.examSeatOptimizer.model;

public class Room {
    private String roomNo;
    private int capacity;

    public Room(String r){
        roomNo = r;
        capacity = 24;   // fixed classroom size (8 rows × 3 benches)
    }

    public String getRoomNo(){ return roomNo; }
    public int getCapacity(){ return capacity; }
}
