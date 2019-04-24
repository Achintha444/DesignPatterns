//This is the Visitor interface 
//For more information about the Visitor design pattern please refer to the web link I have given in the references
interface Visitor{
    public abstract void visit(Item1 item1);
    public abstract void visit(Item2 item2);
    public abstract void visit(Item3 item3);
}

//This is the visitable interface
interface Visitable{
    public abstract void accept(Visitor visitor);
}

//the next three classes are the sub classes which extends the Vistable interface
class Item1 implements Visitable{
    private int itemPrice;

    public Item1(int itemPrice){
        this.itemPrice = itemPrice;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    public int getItemPrice(){
        return this.itemPrice;
    }
}

class Item2 implements Visitable{
    private int itemPrice;

    public Item2(int itemPrice){
        this.itemPrice = itemPrice;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    public int getItemPrice(){
        return this.itemPrice;
    }
}

class Item3 implements Visitable{
    private int itemPrice;

    public Item3(int itemPrice){
        this.itemPrice = itemPrice;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    public int getItemPrice(){
        return this.itemPrice;
    }
}

//This is the concrete visitor who implemnts the vistor interface
class ConcreteVisitor implements Visitor{
    public void visit(Item1 item1){
        System.out.println("The item price of item1 is "+item1.getItemPrice());
    }

    public void visit(Item2 item2){
        System.out.println("The item price of item1 is "+item2.getItemPrice());
    }

    public void visit(Item3 item3){
        System.out.println("The item price of item1 is "+item3.getItemPrice());
    }

}

//This is just a simple class writtern to simulate the process
public class ContextVisitor{
    public static void main(String[] args) {
        ConcreteVisitor visitor = new ConcreteVisitor();
        Item1 item1 = new Item1(100);
        Item2 item2 = new Item2(200);
        Item3 item3 = new Item3(300);
        item1.accept(visitor);
        item2.accept(visitor);
        item3.accept(visitor);
    }
}