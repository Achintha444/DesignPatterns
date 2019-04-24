import java.util.ArrayList;
//This is the abstract Colleuge super class
// To get a more clear idea about this code please refer to the web link in the read me.

abstract class Collegue{
    private Mediator mediator;

    public Collegue(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }


    public Mediator getMediator() {
        return this.mediator;
    }


    public Message createMessage(String message){
        return new Message(message);
    }

    public abstract void send(Message message);

    public abstract void recieve(Message message);
            
}

//The next three classes are concrete collegue classes which override the send() and recieve()
class Collegue1 extends Collegue{

    public Collegue1(Mediator mediator) {
        super(mediator);
    }

    public void send(Message message){
        Mediator mediator = this.getMediator();
        mediator.sendMessage(message);
    }

    public void recieve(Message message){
        System.out.println(message.getMessage()+" is recieved by collegue 1");
    }

}

class Collegue2 extends Collegue{

    public Collegue2(Mediator mediator) {
        super(mediator);
    }

    public void send(Message message){
        Mediator mediator = this.getMediator();
        mediator.sendMessage(message);
    }

    public void recieve(Message message){
        System.out.println(message.getMessage()+" is recieved by collegue 2");
    }

}

class Collegue3 extends Collegue{

    public Collegue3(Mediator mediator) {
        super(mediator);
    }

    public void send(Message message){
        Mediator mediator = this.getMediator();
        mediator.sendMessage(message);
    }

    public void recieve(Message message){
        System.out.println(message.getMessage()+" is recieved by collegue 3");
    }

}

//This is the Message class which has the details of the message
class Message{
    private String message;

    public Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

//This is the mediator class which used to send the message to all the collegues
//In here I have sent the message to the sender as well, but if you want you can not send it to the sender as well

class Mediator{

    private ArrayList<Collegue> collegues;

    public Mediator(){
        this.collegues = new ArrayList<>();
    }

    public void addCollegue(Collegue collegue){
        this.collegues.add(collegue);
    }

    public void sendMessage(Message message){
        for (Collegue collegue : collegues) {
            collegue.recieve(message);
        }
    }
}

//This is a just class which is used to simualte the process
public class ContextMediator{
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Collegue1 collegue1 = new Collegue1(mediator);
        Collegue2 collegue2 = new Collegue2(mediator);
        Collegue3 collegue3 = new Collegue3(mediator);
        mediator.addCollegue(collegue1);
        mediator.addCollegue(collegue2);
        mediator.addCollegue(collegue3);
        Message message = collegue1.createMessage("HI all!"); 
        collegue1.send(message);   
    }
}