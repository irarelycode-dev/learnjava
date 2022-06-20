package com.datastructures;

public class Fib_dynamic {
    Long fib(Long n,java.util.HashMap<Long,Long> hm){
        if(hm.containsKey(n)){
            return hm.get(n);
        }
        if(n<=2) return Long.valueOf(1);
        Long sum=fib(n-1,hm)+fib(n-2,hm);
        hm.put(n,sum);
        return sum;
    }
    public static void main(String[] args) {
        Fib_dynamic object=new Fib_dynamic();
        System.out.println(object.fib(Long.valueOf(134),new java.util.HashMap<Long,Long>()));
    }
}
