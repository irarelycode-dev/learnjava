package com.company;
import static java.lang.System.out;

class MyEmployees{
    private int id;
    private String name;
    public MyEmployees(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(){
        return this.id;
    }
    public String getName() {
        return this.name;
    }
}

public class Constructors {
    public static void main(String[] args) {
        MyEmployees vignesh=new MyEmployees(1,new String("vignesh"));
        MyEmployees developer=new MyEmployees(2,new String("vikki vignesh"));
        out.println(vignesh.getName());
        out.println("developer details:"+developer.getName()+developer.getId());
    }
}
