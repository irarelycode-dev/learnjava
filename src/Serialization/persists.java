package Serialization;
import java.io.*;

class Student implements Serializable {
    int roll;
    String name;
    public Student(int rollNo,String studentName){
        roll=rollNo;
        name=studentName;
    }
}

public class persists {
    public static void main(String[] args) {
        try{
            Student s1=new Student(11,"vignesh");
            FileOutputStream fout=new FileOutputStream("f.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            out.close();
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
