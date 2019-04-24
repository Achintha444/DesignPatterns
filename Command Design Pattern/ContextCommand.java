import java.util.LinkedList;
import java.util.Queue;

abstract class Order{
    public abstract void execute(Cook cook);
}

class SoupOrder extends Order{
    public void execute(Cook cook){
        cook.cookSoup();
    }
}

class RiceOrder extends Order{
    public void execute(Cook cook){
        cook.cookRice();
    }
}

class Cook{
    public void cookSoup(){
        System.out.println("Cooking Soup");
    }

    public void cookRice(){
        System.out.println("Cooking Rice");
    }

}

class Waiter{

    private Queue<Order>orders;

    public Waiter(){
        this.orders = new LinkedList();
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void executeOrder(Cook cook){
        this.orders.remove().execute(cook);
    }
    
}

class Client{

    public void placeSoupOrder(Waiter waiter){
        waiter.addOrder(new SoupOrder());
    }

    public void placeRiceOrder(Waiter waiter){
        waiter.addOrder(new RiceOrder());
    }

}

public class ContextCommand{
    public static void main(String[] args) {
        Client client = new Client();
        Waiter waiter = new Waiter();
        Cook cook = new Cook();
        client.placeRiceOrder(waiter);
        client.placeRiceOrder(waiter);
        client.placeSoupOrder(waiter);
        waiter.executeOrder(cook);
        waiter.executeOrder(cook);
    }
}