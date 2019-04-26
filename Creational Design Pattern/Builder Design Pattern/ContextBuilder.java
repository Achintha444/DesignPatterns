//To get a clear idea about the builder design pattern please refer to the web link I have given in the readme
//When using this design pattern please use clever packaging
//Except the last class we must put all the other class into one package, it will ensure the better use of builder design pattern
class Pepsi{
    protected Pepsi(){} //Mind the protected constructors
}
class Cola{
    protected Cola(){}
}
class VegiBurger{
    protected VegiBurger(){}
}
class ChickenBurger{
    protected ChickenBurger(){}
}

class VegiFood{
    private Pepsi pepsi;
    private VegiBurger vBurger;

    protected VegiFood(){} 

    protected void setPepsi(Pepsi pepsi) {
        this.pepsi = new Pepsi();
    }

    protected void setVBurger(VegiBurger vBurger) {
        this.vBurger = new VegiBurger();
    }

}

class ChickenFood{
    private Cola cola;
    private ChickenBurger cBurger;

    protected ChickenFood(){}

    protected void setCola(Cola cola) {
        this.cola = new Cola();
    }

    protected void setCBurger(ChickenBurger cBurger) {
        this.cBurger = new ChickenBurger();
    }

}

class Builder{
    
    protected VegiFood createVegiFood(){
        VegiFood vegiFood = new VegiFood();
        vegiFood.setVBurger(new VegiBurger());
        vegiFood.setPepsi(new Pepsi());
        return vegiFood;
    }

    protected ChickenFood createChickenFood(){
        ChickenFood chickenFood = new ChickenFood();
        chickenFood.setCBurger(new ChickenBurger());
        chickenFood.setCola(new Cola());
        return chickenFood;
    }
}

class Director{
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public VegiFood getVegiFood(){
        return this.builder.createVegiFood();
    }
    public ChickenFood getChickenFood(){
        return this.builder.createChickenFood();
    }
}

//This is just a simple class to simulate the process that is happening
public class ContextBuilder{
    public static void main(String[] args) {
        Builder builder = new Builder();
        Director director = new Director(builder);
        VegiFood vegiFood = director.getVegiFood();
        ChickenFood chickenFood = director.getChickenFood();
    }
}