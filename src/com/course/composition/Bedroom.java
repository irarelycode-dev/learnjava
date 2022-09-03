package com.course.composition;

public class Bedroom {
    private String name;
    private Walls wall1,wall2,wall3,wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;
    public Bedroom(String n,Walls w1,Walls w2,Walls w3,Walls w4,Ceiling ceil,Bed b,Lamp l){
        name=n;
        wall1=w1;
        wall2=w2;
        wall3=w3;
        wall4=w4;
        ceiling=ceil;
        bed=b;
        lamp=l;
    }
    public Lamp getLamp(){
        return lamp;
    }
    public Bed getBed(){
        return bed;
    }
    public void makeBed(){
        getBed().makeBed();
    }
}
