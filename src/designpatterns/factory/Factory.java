package designpatterns.factory;

public class Factory {
    public Shape getShape(String shape) {
        shape = shape.toLowerCase();
        switch (shape) {
            case "rectangle" -> {
                return new Rectangle();
            }
            case "square" -> {
                return new Square();
            }
            case "circle" -> {
                return new Circle();
            }
            default -> {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Shape shape = factory.getShape("circle");
        shape.draw();
    }
}
