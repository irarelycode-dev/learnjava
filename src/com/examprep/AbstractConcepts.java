package com.examprep;

import java.util.*;

abstract class Shape{
    abstract void draw(AbstractConcepts c);
}

class Circle extends Shape{
    public void draw(AbstractConcepts c){
        System.out.println("Circle");
    }
}

class Rectangle extends Shape{
    public void draw(AbstractConcepts c){
        System.out.println("rectangle");
    }
}

public class AbstractConcepts {
    public void draw(List<Circle> list){
        for(Circle c:list) c.draw(this);
    }
    public static void main(String[] args) {
        List<Circle> list= new LinkedList<>();
        list.add(new Circle());
        list.add(new Circle());
        list.add(new Circle());
        new AbstractConcepts().draw(list);
    }
}
