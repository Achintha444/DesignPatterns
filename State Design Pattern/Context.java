// This is the abstract super class, which is extends by the State sub classes, sometimes we can use interfaces as well for this.
// This class has the abstract goNext(), ehich over rides by the sub classes accordingly.
// More info , refer the website given in the readme.
abstract class State{

    public abstract void goNext(Fan fan);

}

/* In here we have simulated a fan with two states named Hign and Low, the given two classes are them.*/
class Low extends State{

    public void goNext(Fan fan){
        fan.setCurrentState(new High());
        System.out.println("State set to High!");
    }

}

class High extends State{

    public void goNext(Fan fan){
        fan.setCurrentState(new Low());
        System.out.println("State set to Low!");
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

    public void goNext(){
        this.currentState.goNext(this);
    }

}

//This is just a temporary class which I have used to simualte the process
public class Context{
    public static void main(String args[]){

        Fan fan = new Fan(new Low());
        fan.goNext();
        fan.goNext();

    }
}