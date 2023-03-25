package com.datastructures.dp;

import java.util.*;

public class GridTraveller {

    static Map<String,Integer> hm=new HashMap<>();
    static int waysToTravel(int x,int y){
        if(x==0 || y==0) return 0;
        if(x==1 && y==1) return 1;
        String key=x+","+y;
        String reversedKey=new StringBuilder(key).reverse().toString();
        if(hm.containsKey(key)) return hm.get(key);
        int ways=waysToTravel(x-1,y)+waysToTravel(x,y-1);
        hm.put(key,ways);
        hm.put(reversedKey,ways);
        return ways;
    }
    public static void main(String[] args) {
        System.out.println(waysToTravel(3,4)==waysToTravel(4,3));
        Date t1=new Date();
        System.out.println(waysToTravel(500,500));
        Date t2=new Date();
        System.out.println(t2.getTime()-t1.getTime());
    }
}
