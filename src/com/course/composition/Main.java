package com.course.composition;

public class Main {
    public static void main(String[] args){
        Dimensions dimensions=new Dimensions(20,20,5);
        Resolution resolution=new Resolution(2540,1440);
        Case theCase=new Case("220B","Dell","240",dimensions);
        Monitor theMonitor=new Monitor("27inch beast","Acer",27,resolution);
        Motherboard theMotherboard=new Motherboard("BJ-200","Asuss",4,6,"v2.44");
        PC thePc=new PC(theCase,theMonitor,theMotherboard);
        thePc.getMonitor().drawPixelAt(1500,1220,"red");
        thePc.getMotherboard().loadProgram("windows 1.2");
        thePc.getCase().pressPowerButton();
    }
}
