package com.examSeatOptimizer.algorithm;

import java.util.*;

public class GraphColoringAllocator {

    public int[][] generateLayout(Map<String, Queue<Integer>> deptMap){

        int[][] seat = new int[8][3];
        String[][] dept = new String[8][3];

        for(int r=0;r<8;r++){
            Set<String> usedRow = new HashSet<>();

            for(int c=0;c<3;c++){
                String pick=null;

                for(String d:deptMap.keySet()){
                    if(deptMap.get(d).isEmpty()) continue;
                    if(!usedRow.contains(d) &&
                            (r==0 || !d.equals(dept[r-1][c]))){
                        pick=d; break;
                    }
                }

                if(pick==null){
                    for(String d:deptMap.keySet()){
                        if(!deptMap.get(d).isEmpty()){
                            pick=d; break;
                        }
                    }
                }

                if(pick!=null){
                    seat[r][c]=deptMap.get(pick).poll();
                    dept[r][c]=pick;
                    usedRow.add(pick);
                }
            }
        }
        return seat;
    }
}
