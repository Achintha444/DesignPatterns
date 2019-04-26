//For more information about Abstract Factory Design Pattern please refer to the web link I have given in the readme
//Eventhough I have not shown here, it is better if you can package your code as follows
//These 3 should be in a one package
abstract class ProductA{
    public abstract String operationA1();
    public abstract String operationA2();
}

abstract class ProductB{
    public abstract String operationB1();
    public abstract String operationB2();
}

abstract class Factory{
    public abstract ProductA getProductA();
    public abstract ProductB getProductB();
}
//-----------------------------------------


//These 3 should be in a one package
class ProductA1 extends ProductA{

    protected ProductA1(){} //note the protected constructor
    public String operationA1(){
        return "Product A1 op A1";
    }

    public String operationA2(){
        return "Product A1 op A2";
    }
}

class ProductB1 extends ProductB{
    protected ProductB1(){} //note the protected constructor
    public String operationB1(){
        return "Product B1 op B1";
    }

    public String operationB2(){
        return "Product B1 op B2";
    }
}

class Factory1 extends Factory{
    public ProductA getProductA(){
        return new ProductA1();
    }

    public ProductB getProductB(){
        return new ProductB1();
    }
}
//----------------------------------------

//These 3 should be in a one package
class ProductA2 extends ProductA{
    protected ProductA2(){} //note the protected constructor
    public String operationA1(){
        return "Product A2 op A1";
    }

    public String operationA2(){
        return "Product A2 op A2";
    }
}

class ProductB2 extends ProductB{
    protected ProductB2(){} //note the protected constructor
    public String operationB1(){
        return "Product B2 op B1";
    }

    public String operationB2(){
        return "Product B2 op B2";
    }
}

class Factory2 extends Factory{
    public ProductA getProductA(){
        return new ProductA2();
    }

    public ProductB getProductB(){
        return new ProductB2();
    }
}
//---------------------------------------

public class ContextAbstractFactory{
    public static void main(String[] args) {
        Factory1 fac1 = new Factory1();
        Factory2 fac2 = new Factory2();

        ProductA a1 = fac1.getProductA();
        ProductA a2 = fac2.getProductA();
        System.out.println(a1.operationA1());
        System.out.println(a2.operationA1());

        ProductB b1 = fac1.getProductB();
        ProductB b2 = fac2.getProductB();
        System.out.println(b1.operationB1());
        System.out.println(b2.operationB1());

    }
}