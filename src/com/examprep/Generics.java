package com.examprep;

import static java.lang.System.*;

class Pair<String,Integer>{
    String str;
    Integer t;

    public Pair(){}
    public Pair(String str,Integer t){
        this.str=str;
        this.t=t;
    }
    String getString(){
        return str;
    }
    int returnInteger(){
        return (int) t;
    }
}

public class Generics {
    public static void main(String[] args) {
        Pair<String,Integer> o=new Pair<>("vignesh",10);
        out.println(o.getString());
        out.print(o.returnInteger());
    }
}
