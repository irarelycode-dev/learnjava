package designpatterns.factory;

public interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing rectangle...");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing square...");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing circle...");
    }
}