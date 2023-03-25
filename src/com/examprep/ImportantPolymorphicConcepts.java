package com.examprep;

//concept 3

interface GFGF{
    void myMethod();
    void getInfo();
}
abstract class Geeks implements GFGF{
    void getData(){
        System.out.println("GFG");
    }
}

class Testing extends Geeks{
    public void myMethod(){
        System.out.println("geeksForGeeks");
    }
    public void getInfo(){
        System.out.println("Geeks");
    }

//    public static void main(String[] args) {
//        Geeks o=new Testing();
//        o.myMethod();
//    }
}



//concept 1

class Test{
    void method(){
        System.out.println("geeks for geeks");
    }
}

class Derived21 extends Test{
    void method(){
        System.out.println("GFG");
    }
//    public static void main(String[] args) {
//        //Derived21 o=new Test();//This will give compilation error
//        //Derived21 o=(Derived21)new Test();//this will give run-time error
//    }
}



//concept 2
class GFG{
    protected void getData(){
        System.out.println("Inside gfg");
    }
}

class GeeksForGeeks extends GFG{
    protected void getData(){
        System.out.println("Inside geeksforgeeks");
    }
}

public class ImportantPolymorphicConcepts {
    public static void main(String[] args) {
        GFG o=new GeeksForGeeks();
        o.getData();
    }
}

//At compile time, o will check GFG class if method getData() is present
//At run-time,o will be binded to an instance of type GeeksForGeeks

