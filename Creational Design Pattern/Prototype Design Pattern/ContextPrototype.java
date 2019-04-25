//This is the class which has the clone()
//For more info please refer to the web link I have given in the web link
//Clonable interface is java implement interface, which helps Prototype design pattern to implemnt easily

class Student implements Cloneable{
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

//This is a simple class which simulate the process
public class ContextPrototype{
    public static void main(String args[]) throws CloneNotSupportedException{
        Student s1 = new Student("1","Yogya");
        Student s2 = (Student)s1.clone();
        
        //Both output is 'Yogya'
        System.out.println(s1.getName());
        System.out.println(s2.getName());
    }
}