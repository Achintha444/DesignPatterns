import java.util.LinkedList;
import java.util.Queue;

//To get a clar idea please refer to the weblink I have given in the readme
class DBConn{
    private String userName;
    private String pass;
    private String db;

    //protected constructor
    protected DBConn(String userName, String pass, String db) {
        this.userName = userName;
        this.pass = pass;
        this.db = db;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDb() {
        return this.db;
    }

    public void setDb(String db) {
        this.db = db;
    }
}

//this is the class which gives the DBConn which has the DBConn object pool
class DBConnObjectPool{
    private Queue<DBConn>locked; 
    private Queue<DBConn>unlocked;
    private int maxAmountofObjects;

    public DBConnObjectPool(int maxAmountofObjects) {
        this.locked = new LinkedList<>();
        this.unlocked = new LinkedList<>();
        this.maxAmountofObjects = maxAmountofObjects;
    }

    public synchronized DBConn checkOut(){
        int lenLocked = this.locked.size();
        int lenUnlocked = this.unlocked.size();
        if((lenLocked+lenUnlocked)>this.maxAmountofObjects){
            if(lenUnlocked==0) return null;
            else{
                DBConn connection = this.unlocked.remove();
                this.locked.add(connection);
                return connection;
            }
        }
        else{
            if(lenUnlocked==0 || (lenUnlocked==0 && lenLocked==0)){
                DBConn connection = new DBConn("root", "pass", "tempDataBase");
                this.locked.add(connection);
                return connection;
            }
            else{
                DBConn connection = this.unlocked.remove();
                this.locked.add(connection);
                return connection;
            }
        }

    }

    public synchronized void checkIn(DBConn conn){
        //this is a wrong way, the right way is we must remove the 'conn' in the locked linked list
        this.unlocked.add(this.locked.remove());
    }
}

//This is a simple class for to simulate the process
public class ContextObjectPool{
    public static void main(String[] args) {
        DBConnObjectPool objectPool = new DBConnObjectPool(5);

        DBConn conn1 = objectPool.checkOut();
        DBConn conn2 = objectPool.checkOut();

        //both output is same
        System.out.println(conn1.getUserName());
        System.out.println(conn2.getUserName());
        
    }
}