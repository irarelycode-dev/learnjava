package com.collectionslearn;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class LearnArrayLt {
    public static void main(String[] args) {
        java.util.List<Integer> al=new java.util.ArrayList<>();
        java.util.List<Integer> al2=new java.util.ArrayList<>();
        al.add(20);
        al.add(21);
        al.add(20);
        al.add(21);
        al2.add(32);
        al2.add(12);
        al2.add(34);
        System.out.println(al);
        al.addAll(al2);
        al.removeAll(al2);
        System.out.println(al);
        al.remove(new Integer(32));
        System.out.println(al);
        al.removeIf(elem -> elem>30);
        Object[] array= al.toArray();
        System.out.println(al.get(1));
        for(Object elem:array){
            System.out.println((Integer) elem);
        }
        for (Integer integer : al) {
            System.out.println(integer);
        }
    }
}
