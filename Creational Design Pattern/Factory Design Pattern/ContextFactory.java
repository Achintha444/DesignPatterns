interface Shape{
    public abstract String getType();
}

class Square implements Shape{
    private String type;

    public Square() {
        this.type = "Square";
    }

    public String getType() {
        return this.type;
    }
        
}

class Rectangle implements Shape{
    private String type;

    public Rectangle() {
        this.type = "Rectangle";
    }

    public String getType() {
        return this.type;
    }
        
}

class Circle implements Shape{
    private String type;

    public Circle() {
        this.type = "Circle";
    }

    public String getType() {
        return this.type;
    }
        
}

class Factory{
    public Shape getShape(String type){
        if(type.equalsIgnoreCase("square")) return new Square();
        else if(type.equalsIgnoreCase("rectangle")) return new Rectangle();
        else if(type.equalsIgnoreCase("circle")) return new Circle();
        else return null;
    }
}

public class ContextFactory{
    public static void main(String[] args) {
        Factory factory = new Factory();

        Square square = (Square) factory.getShape("Square");
        System.out.println(square.getType());

        Rectangle rectangle = (Rectangle) factory.getShape("Rectangle");
        System.out.println(rectangle.getType());

        Circle circle = (Circle) factory.getShape("Circle");
        System.out.println(circle.getType());
    }
}