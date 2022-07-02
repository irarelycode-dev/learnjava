package Serialization;

import java.io.*;
import java.io.FileOutputStream;

class Address {
    String addressLine;
    String city;
    String state;
    public Address(String addressLine,String city,String state){
        this.addressLine=addressLine;
        this.city=city;
        this.state=state;
    }
}

public class Aggregation implements Serializable {
    int id;
    String name;
    Address address;
    public Aggregation(int id,String name){
        this.id=id;
        this.name=name;
        this.address=null;
    }
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oout=null;
        try{
            Aggregation object=new Aggregation(1,"vignesh");
            FileOutputStream fout=new FileOutputStream("f3.txt");
            oout=new ObjectOutputStream(fout);
            oout.writeObject(object);
            oout.flush();
            oout.close();
            System.out.println("success");
        }catch (Exception e){
            System.out.println(e);
            oout.flush();
            oout.close();
        }
    }
}


//a class having a reference of another class which is not serializable is not serializable
//all objects within an object must be serializable