//The interface is the Product which the factory is going to produce
//The next three classes are the sub classes of the given product class
//note that their constructor is protected
//For information about the Fctory Method design pattern refer to the link I have given in the link

interface Shape{
    public abstract String getType();
}

class Square implements Shape{
    private String type;

    protected Square() {
        this.type = "Square";
    }

    public String getType() {
        return this.type;
    }
        
}

class Rectangle implements Shape{
    private String type;

    protected Rectangle() {
        this.type = "Rectangle";
    }

    public String getType() {
        return this.type;
    }
        
}

class Circle implements Shape{
    private String type;

    protected Circle() {
        this.type = "Circle";
    }

    public String getType() {
        return this.type;
    }
        
}

//This is the abstract factory
//In here we have to use clever packaging
//The most good packaging would be keep the Shape interface and the abstract factory in a one package and a package for each shape for the shape class and the shape factory


abstract class Factory{
    public Shape getShape(){
        Shape shape = this.createShape();
        return shape;
    }
    protected abstract Shape createShape(); //note that this is protected 
}

class SquareFactory extends Factory{
    protected Shape createShape(){
        return new Square();
    }
}

class RectangleFactory extends Factory{
    protected Shape createShape(){
        return new Rectangle();
    }
}

class CircleFactory extends Factory{
    protected Shape createShape(){
        return new Circle();
    }
}

//This is a class just to simulate the process
public class ContextFactoryMethod{
    public static void main(String args[]){
        SquareFactory sFactory = new SquareFactory();
        RectangleFactory rFactory = new RectangleFactory();
        CircleFactory cFactory = new CircleFactory();

        Shape square = sFactory.getShape();
        System.out.println(square.getType());
                       
        Shape rectangle = rFactory.getShape();
        System.out.println(rectangle.getType());

        Shape circle = cFactory.getShape();
        System.out.println(circle.getType());
    }
}