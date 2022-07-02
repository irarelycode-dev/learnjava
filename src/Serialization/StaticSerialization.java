package Serialization;

import java.io.*;

public class StaticSerialization implements Serializable {
    int id;
    String name;
    static String company="SSS IT PVT LTD";
    public StaticSerialization(int id,String name){
        this.id=id;
        this.name=name;
    }
    public static void main(String[] args) throws IOException {
        try{
            FileOutputStream fout=new FileOutputStream("f4.txt");
            ObjectOutputStream oout=new ObjectOutputStream(fout);
            StaticSerialization ss=new StaticSerialization(2,"vignesh");
            oout.writeObject(ss);
            oout.flush();
            oout.close();
            System.out.println("success");
        }catch (Exception e){
            System.out.println("failed serializing");
            System.out.println(e);
        }

        //deserializing the object
        try{
            FileInputStream fis=new FileInputStream("f4.txt");
            StaticSerialization ss=(StaticSerialization) new ObjectInputStream(fis).readObject();
            System.out.println(ss.id+" "+ss.name+" ");
            fis.close();
        }catch(Exception e){
            System.out.println("failed serializing");
            System.out.println(e);
        }

    }
}
