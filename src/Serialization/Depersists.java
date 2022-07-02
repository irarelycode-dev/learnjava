package Serialization;
import java.io.*;

public class Depersists {
    public static void main(String[] args) {
        try{
            ObjectInputStream fin=new ObjectInputStream(new FileInputStream("f.txt"));
            Student s=(Student)fin.readObject();
            System.out.println(s.name+" "+s.roll);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
