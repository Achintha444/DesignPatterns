import java.util.ArrayList;

//To get a clear idea about the Flyweight design pattern please refer the weblink I have given in the readme
//This is the flyweight class
//Eventhough sometimes it is not clearly mentioned about the use of packaging in the Flyweight design pattern, I think it is better to use clever packaging when u are using this design pattern

//According to my belief these 3 classes should be in a one package----------
class SoliderFlyweight{
    private String weapon;
    private String armour;
    private String helmet;

    protected SoliderFlyweight(String weapon, String armour, String helmet) { //This is protected because to, prevent other classes (except Soilder class) from creating objects of SoilderFlyweight
        this.weapon = weapon;
        this.armour = armour;
        this.helmet = helmet;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getArmour() {
        return armour;
    }

    public String getHelmet() {
        return helmet;
    }
    
    protected void setWeapon(String weapon){
        this.weapon = weapon;
    } 
}

class Solider{
    private SoliderFlyweight solider;
    public Solider(String weapon){
        this.solider= SoliderFlyweightFactory.getSolider();
        this.solider.setWeapon(weapon);
    }    
}

class SoliderFlyweightFactory{
    private static SoliderFlyweight solider;
    protected static SoliderFlyweight getSolider(){
        if(solider==null){
            synchronized(SoliderFlyweightFactory.class){
                if(solider==null){
                    solider = new SoliderFlyweight("T-56","Armour","Helmet");
                }
            }
        }
        return solider;
    }
}
//-------------------------------------------------------------------------------

//This is a class which writtern to show the difference between, when we are using flyweight and not
class Solider2{
    private String weapon;
    private String armour;
    private String helmet;

    public Solider2(String weapon, String armour, String helmet) {
        this.weapon = weapon;
        this.armour = armour;
        this.helmet = helmet;
    }    
}

//This is a simple class written to show simulate the process
public class ContextFlyweight{
    public static void main(String args[]){
        
        //This is what happens when we use flyweight design pattern
        ArrayList<Solider> soliders = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i=0; i<200000; i++){
            soliders.add(new Solider("AK-47"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("With Flyweight");
        System.out.println("Time spent is: "+(endTime-startTime)); //smaller
        
        System.out.println("");
        
         //This is what happens when we don't use flyweight design pattern
        ArrayList<Solider2> soliders2 = new ArrayList<>();
        long startTime2 = System.currentTimeMillis();
        for (int i=0; i<200000; i++){
            soliders2.add(new Solider2("AK-47","Armour","Helmet"));
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("Without Flyweight");
        System.out.println("Time spent is: "+(endTime2-startTime2)); //larger  
    }
}
