import java.util.HashMap;

//This is the class which uses the multiton design pattern.
//To get a better idea of this code please refer to the link I have given in the readme

class Customer{
    private static HashMap<String,String> customers = new HashMap<>(); //This is the Hashmap which saves the data of the customers
    private static HashMap<String,Customer> multitonCustomers = new HashMap<>(); //This is the Hashmap which saves the created customer objects
    private String id;
    private String name;

    private Customer(String id, String name){
        this.id = id;
        this.name = name;
    }

    public static void addCustomer(String id, String name){
        customers.put(id, name);
    }

    public static Customer getCustomer(String id){
        Customer customer = multitonCustomers.get(id);
        if(customer==null){
            String name = customers.get(id);
            if(name==null) return null;
            else{
                customer = new Customer(id, name);
                multitonCustomers.put(id, customer);
                return customer;
            }
        }
        return customer;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
}

//This is the class which uses to simulate the process

public class ContextMultiton{
    public static void main(String[] args) {
        Customer.addCustomer("1", "Achintha");
        Customer.addCustomer("2", "Yogya");

        Customer cus1 = Customer.getCustomer("1");
        Customer cus2 = Customer.getCustomer("2");
        Customer cus3 = Customer.getCustomer("1");
        Customer cus4 = Customer.getCustomer("2");

        //Output is Achintha
        System.out.println(cus1.getName());
        System.out.println(cus3.getName());

        //Output is Yogya
        System.out.println(cus2.getName());
        System.out.println(cus4.getName());
    }
}