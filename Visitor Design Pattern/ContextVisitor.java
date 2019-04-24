interface Visitor{
    public abstract void visit(Item1 item1);
    public abstract void visit(Item2 item2);
    public abstract void visit(Item3 item3);
}

interface Visitable{
    public abstract void accept(Visitor visitor);
}

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