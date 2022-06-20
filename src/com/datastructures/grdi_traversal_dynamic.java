package com.datastructures;

public class grdi_traversal_dynamic {
    int gridTraversal(int m,int n,java.util.HashMap<String,Integer> hm){
        String key=m+","+n;
        if(hm.containsKey(key)) return hm.get(key);
        if(m==1 || n==1) return 1;
        if(m==0 || n==0) return 0;
        int ways=gridTraversal(m-1,n,hm)+gridTraversal(m,n-1,hm);
        hm.put(key,ways);
        return hm.get(key);
    }
    public static void main(String[] args) {
        grdi_traversal_dynamic object=new grdi_traversal_dynamic();
        System.out.println( object.gridTraversal(100,2,new java.util.HashMap<String,Integer>()));
    }
}

