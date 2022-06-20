package com.company;
import static java.lang.System.out;

/*
* method overloading cannot be chnaged with changing the return type
* */
public class MethodOverloading {
    static void tellJoke(){
        out.println("New word"+"Plagiarism");
    }
    static void change(int[] array){
        array[0]=10;
        out.println("array value has been changed");
    }
    static void foo(){
        out.println("Good morning bro");
    }
    static void foo(String name){
        out.println("Good morning bro:"+name.toString());
    }
    static void foo(String name,String surname){
        out.println("Good morning bro:"+name.toString()+" "+surname.toString());
    }
    static void foo(String name,String surname,String nickname){
        out.println(name.toString()+surname.toString()+nickname.toString());
    }
    public static void main(String[] args){
        tellJoke();
        int[] marks={12,1,3,14,1,5};
        int x=45;
        change(marks);
        out.println("marks object"+marks[0]);
        foo();
        foo(new String("vignesh"));
        foo(new String("vignesh"),new String("pugazhendhi"));
        foo(new String("vignesh"),new String("pugazhendhi"),new String("vikki"));
    }
}
