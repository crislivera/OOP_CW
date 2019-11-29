public class User {

    //initializing the user common attributes
    private String userId;
    private String password;
    private String name;
    private String address;
    private String nic;
    private String telephoneNumber;

    //creating the constructor of user class
    public User(String userId, String password, String name, String address, String nic, String telephoneNumber) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.telephoneNumber = telephoneNumber;
    }

    public User() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    //getters for the user class
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNic() {
        return nic;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    //toString print method


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
