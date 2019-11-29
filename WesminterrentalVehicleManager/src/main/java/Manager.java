import java.util.Scanner;

public class Manager extends User {
    //inherit the manager class from user super class
    //initializing manager attributes
    private boolean isManager;
    private int numOfOrders;

    //making constructor with user attributes
    public Manager(String userId, String password, String name, String address, String nic, String telephoneNumber, boolean isManager, int numOfOrders) {
        super(userId, password, name, address, nic, telephoneNumber);
        this.isManager = isManager;
        this.numOfOrders = numOfOrders;
    }

    public Manager() {
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public void setNumOfOrders(int numOfOrders) {
        this.numOfOrders = numOfOrders;
    }

    //getters for manager
    public boolean isManager() {
        return isManager;
    }

    public int getNumOfOrders() {
        return numOfOrders;
    }


    //overriding user toString method of user class
    @Override
    public String toString() {
        return "Manager{"+ super.toString() +
                "isManager=" + isManager +
                ", numOfOrders=" + numOfOrders +
                '}';
    }
}
