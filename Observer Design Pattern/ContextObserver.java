import java.util.ArrayList;

//This is the Observable abstract class.
//Sometimes Observable is implemented as an interface
//For more information about Observable design pattern please refer to the web link I have given in the link

abstract class Observable{

    private ArrayList<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }   

    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void notifyObservers(int tempState){
        for (Observer observer : observers) {
            observer.update(tempState);
        }
    }
}

//This is the Observer interface, which has the update()
interface Observer{
    public void update(int tempState);
}

class ConcreteObserverable extends Observable{
    private int tempState;

    public ConcreteObserverable(int tempState){
        this.tempState = tempState;
    }

    public void setTempState(int tempState){
        this.tempState = tempState;
        this.notifyObservers(tempState);
    }

}

class ConcreteObserver1 implements Observer{
    public void update(int tempState){
        System.out.println("The current state of the ConcretaObservable is "+tempState+" by CO1");
    }
}

class ConcreteObserver2 implements Observer{
    public void update(int tempState){
        System.out.println("The current state of the ConcretaObservable is "+tempState+" by CO2");
    }
}

public class ContextObserver{
    public static void main(String[] args) {
        ConcreteObserverable observerable = new ConcreteObserverable(1);
        ConcreteObserver1 observer1 = new ConcreteObserver1();
        ConcreteObserver2 observer2 = new ConcreteObserver2();
        observerable.attach(observer1);
        observerable.attach(observer2);
        observerable.setTempState(2);
        observerable.setTempState(3);
    }
}