package com.company;
import static java.lang.System.out;

interface Camera{
    void takeSnap();
    private void greet(){
        out.println("private methods in interfaces can be used along with default methods if needed");
    }
   default void record4KVideo(){
       out.println("recording in 4k");
   }
}
interface Wifi{
    String[] getNetworks();
    void connectToNetwork(String network);
}
class MyCellPhone{
    void callNumber(int phoneNumber){
        out.println("calling number: "+phoneNumber);
    }
    void pickCall(){
        out.println("connecting call...");
    }
}

class MySmartphone extends MyCellPhone implements Wifi,Camera{
    public void takeSnap(){
        out.println("taking snap");
    }
    public void recordMethod(){
        out.println("recording....");
    }
    public String[] getNetworks(){
        return new String[]{new String("idea")};
    }
    public void connectToNetwork(String network){
        out.println("coonecting to network");
    }
    public void record4KVideo(){
        out.println("recording 4K video functionality changed");
    }
}

public class DefaultMethods {
    public static void main(String[] args) {
        MySmartphone smartphone=new MySmartphone();
        String[] networks=smartphone.getNetworks();
        for(String network:networks){
            out.println(network);
        }
    }
}
//default methods was introduced java 8 and allows us to make interface backward compatible while updating an interface
