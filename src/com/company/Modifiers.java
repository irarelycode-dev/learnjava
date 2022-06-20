package com.company;
import static java.lang.System.out;

//access modifiers
//private,default,public,protected
//specifies coonditions for any property/method to be accessed

class MyEmployee{
    private int id;
    private String name;
    public void setName(String n){
        this.name=n;
    }
    public String getname(){
        return this.name;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getId(){
        return this.id;
    }
}

public class Modifiers {
    public static void main(String[] args) {
        MyEmployee vignesh=new MyEmployee();
        vignesh.setName(new String("vignesh"));
        out.print(vignesh.getname());
    }
}
