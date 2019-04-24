//This is the absract Handler super class. In here we have implementd the handle() which pass if the message to the next handler if the message isnot handled
//To get a better understanding of the Chain of Responsibility please refer to weblink I have given in the link

abstract class Handler{
    protected Handler nextHandler; 

    public abstract boolean handleImplementation(Request request);

    public void handle(Request request){
        boolean temp = this.handleImplementation(request);
        if (this.nextHandler!=null && !temp){
            nextHandler.handle(request);
        }
        else if (this.nextHandler==null && !temp){
            System.out.println("The Request cannot handle at this time!");
        }
    }
}

//The next three classes are concrete handlers.
//In there I have override the handleImplementaion(), which has the logic of how to handle a request by each class.

class ConcreteHandler1 extends Handler{

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public boolean handleImplementation(Request request){
        if (request.getId()==1){
            System.out.println("The message is "+request.getMessage()+" handled by handler 1");
            return true;
        }
        else{
            return false;
        }
    }
}

class ConcreteHandler2 extends Handler{

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public boolean handleImplementation(Request request){
        if (request.getId()==2){
            System.out.println("The message is "+request.getMessage()+" handled by handler 2");
            return true;
        }
        else{
            return false;
        }
    }
}

class ConcreteHandler3 extends Handler{

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public boolean handleImplementation(Request request){
        if (request.getId()==3){
            System.out.println("The message is "+request.getMessage()+" handled by handler 3");
            return true;
        }
        else{
            return false;
        }
    }
}

//This is the Request class , which has the details of the request.

class Request{
    private int id;
    private String message;


    public Request(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

//This is the client who sends the Request to the handlers
class Client{

    public Request createTheRequest(int id, String message){
        return new Request(id, message);
    }

    public void sendReRequest(Request request, Handler handler){
        handler.handle(request);
    }
}

//This is a just a simple class for simualte the code.
public class ContextChainOfResponsibility{
    public static void main(String[] args) {
        Client client = new Client();
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        ConcreteHandler2 handler2 = new ConcreteHandler2();
        ConcreteHandler3 handler3 = new ConcreteHandler3();
        handler1.setNextHandler(handler2); //setting the next handlers 
        handler2.setNextHandler(handler3);
        Request request1 = client.createTheRequest(1, "Message for handler 1");
        client.sendReRequest(request1, handler1);
        Request request2 = client.createTheRequest(2, "Message for handler 2");
        client.sendReRequest(request2, handler1);
        Request request3 = client.createTheRequest(3, "Message for handler 3");
        client.sendReRequest(request3, handler1);
    }

}