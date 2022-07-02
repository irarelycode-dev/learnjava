package Serialization;
import java.io.*;

class Person implements Serializable{
    int id;
    String name;
    public Person(int id,String name){
        this.id=id;
        this.name=name;
    }
}

class Students extends Person{
    String course;
    int fee;
    public Students(int fee,String course,String name,int id){
        super(id,name);
        this.fee=fee;
        this.course=course;
    }
}

public class Inheritance {
    public static void main(String[] args) {
        try{
            Students s1=new Students(2000,"engineering","vignesh",1111);
            FileOutputStream fout=new FileOutputStream("f2.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            out.close();
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            ObjectInputStream oin=new ObjectInputStream(new FileInputStream("f2.txt"));
            Students s1=(Students)oin.readObject();
            System.out.println(s1.name+" "+s1.id+" "+s1.fee+" "+s1.course);
            oin.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


//if a class implements serializable interface, all of its subclasses will be serializable