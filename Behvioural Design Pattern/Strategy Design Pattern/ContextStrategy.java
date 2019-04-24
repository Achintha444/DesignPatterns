// This is the simulation of Strategy design pattern.
// The first class is the abstract super class Strategy, which we will be extends by the Strategy sub classes.
// The method in the Stratrgy class is the execute().
// To get a good idea about this design pattern please refer to the link I have given in the readme

abstract class Stratgey{
    public abstract void execute();
}

//This simulation has a robo who can run slow and run fast.
//The following classes are runSlow and runFast which are the subclasses of Stratgey.

class runSlow extends Stratgey{
    public void execute(){
        System.out.println("Go SLOW!");
    }
}

class runFast extends Stratgey{
    public void execute(){
        System.out.println("Go FAST!");
    }
}

//This is the Robot class which uses the above stratrgies

class Robot{
    private Stratgey current;

    public Robot() {
    }

    public Robot(Stratgey current) {
        this.current = current;
    }

    public Stratgey getCurrent() {
        return this.current;
    }

    public void setCurrent(Stratgey current) {
        this.current = current;
    }

    public void executeRun(){
        this.current.execute();
    }

}

//this is just a class which I have used to simulate the process.

public class ContextStrategy{
    public static void main(String args[]){
        Robot robot = new Robot(new runSlow());
        robot.executeRun();
        robot.setCurrent(new runFast());
        robot.executeRun();
    }
}