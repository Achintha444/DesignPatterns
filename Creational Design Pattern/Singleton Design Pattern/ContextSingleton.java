//This is a class which uses the singleton design pattern
//For more info about the singleton design pattern please use the link I have given in the readme
public class ContextSingleton{
    private static ContextSingleton instance;

    private ContextSingleton(){} //private constructor

    private static ContextSingleton getInstance() { //this is the method we use to get the singleton object
        if (instance==null){
            synchronized(ContextSingleton.class){ //use synchronized keyword if you are in a multi threaded enviroment if not, not neccessary
                instance = new ContextSingleton();
            }
        }
        return instance; 
    }
}