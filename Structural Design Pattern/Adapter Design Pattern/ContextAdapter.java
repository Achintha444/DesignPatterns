//To get a more idea about the Adapter design pattern please refer to the web link I have given in the readme
//Target interface
interface Human{
    public String walk();
    public String talk();
    public String eat();
}

//Adaptee class
class Robot{
    public String run(){
        return(" am a robot so I don't walk I run");
    }
    public String talk(){
        return("I am a robot so I can't talk");
    }
    public String drink(){
        return("I am a robot so I don't eat I drink oil!");
    }
}

//Adapter class
class HumanRobotAdapter implements Human{
    private Robot robotAdaptee;
    public HumanRobotAdapter(Robot robotAdaptee){
        this.robotAdaptee = robotAdaptee;
    }

    public String walk() {
        return this.robotAdaptee.run();
    }

    public String talk() {
        return this.robotAdaptee.talk();    }

    public String eat() {
        return this.robotAdaptee.drink();
    }
}

//Just a class that implements the human interface and acts like a human
class HumanHuman implements Human{

    public String walk() {
        return("I am human so I walk");
    }

    public String talk() {
        return("I am human so I talk");
    }

    public String eat() {
        return("I am human so I eat");
    }
}

public class ContextAdapter{
    public static void main(String args[]){
        Human realHuman = new HumanHuman();
        Robot robot = new Robot();
        Human roboHuman = new HumanRobotAdapter(robot);
        
        System.out.println("Real Human");
        System.out.println("Real Human walks like: "+realHuman.walk());
        System.out.println("Real Human talks like: "+realHuman.talk());
        System.out.println("Real Human eats like: "+realHuman.eat());
        
        System.out.println("");
        
        System.out.println("Robot");
        System.out.println("Robot walks like: "+robot.run());
        System.out.println("Robot talks like: "+robot.talk());
        System.out.println("Robot eats like: "+robot.drink());
                
        System.out.println("");
        
        System.out.println("Robot Human");
        System.out.println("Real Human walks like: "+roboHuman.walk());
        System.out.println("Real Human talks like: "+roboHuman.talk());
        System.out.println("Real Human eats like: "+roboHuman.eat());
        
    }
}