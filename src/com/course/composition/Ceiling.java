package com.course.composition;

public class Ceiling {
    private int height;
    private String paintedColor;
    public Ceiling(String color,int h){
        paintedColor=color;
        height=h;
    }
    public String getColor(){
        return paintedColor;
    }
    public int getHeight(){
        return height;
    }
}
