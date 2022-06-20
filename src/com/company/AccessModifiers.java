package com.company;

import static java.lang.System.out;

class Cylinder {
    private int radius;
    private int height;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        Cylinder myCylinder=new Cylinder();
        myCylinder.setHeight(10);
        out.print(myCylinder.getHeight());
        out.print(myCylinder.getRadius());
    }
}
