package com.collectionslearn;
import java.util.Set;
import java.util.LinkedHashSet;

public class learnlinkedHashSet {
    public static void main(String[] args) {
        Set<Integer> set=new LinkedHashSet<>();
        set.add(100);
        set.add(200);
        set.add(1);
        System.out.println(set);
    }
}
//same as HashSet