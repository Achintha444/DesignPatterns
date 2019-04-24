import java.util.ArrayList;

// This is the abstract super class, which is extends by the State sub classes, sometimes we can use interfaces as well for this.
// This class has the abstract goNext(), ehich over rides by the sub classes accordingly.
// More info , refer the website given in the readme.
abstract class State{

    public abstract void execute();

}

/* In here we have simulated a fan with two states named Hign and Low, the given two classes are them.*/
class Low extends State{

    public void execute(){
        System.out.println("Fan is in Low mode!");
    }

}

class Medium extends State{

    public void execute(){
        System.out.println("Fan is in Medium mode!");
    }
}


class High extends State{

    public void execute(){
        System.out.println("Fan is in High mode!");
    }

}

// This is the fan class which uses the states.

class Fan{

    private State currentState;

    public Fan(State state){
        this.currentState = state;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Memento saveCurrentState(){
        return new Memento(this.currentState);
    }

    public void execute(){
        this.currentState.execute();
    }

}

class Memento{
    private State state;
    
    public Memento(State state){
        this.state=state;
    }

    public State getState(){
        return this.state;
    }

}

//This is just a temporary class which I have used to simualte the process
public class ContextMemento{
    public static void main(String args[]){
        ArrayList<Memento> history = new ArrayList<>();
        Fan fan = new Fan(new Low());
        history.add(0,fan.saveCurrentState());
        fan.execute();

        fan.setCurrentState(new Medium());
        fan.execute();
        System.out.println("a");
        history.add(0,fan.saveCurrentState());
        
        fan.setCurrentState(new High());
        fan.execute();
        fan.setCurrentState(history.get(0).getState()); //retreve the prevoius state

        fan.execute(); //exeute in the previous state mode

    }
}