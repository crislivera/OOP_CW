public class Customer extends User {
//inherit the customer class from user super class
    //initializing customer attributes
    private String licenceNo;
    private String licenceExpireDate;
    private boolean isCustomer;

    //making constructor with user attributes
    public Customer(String userId, String password, String name, String address, String nic, String telephoneNumber, String licenceNo, String licenceExpireDate, boolean isCustomer) {
        super(userId, password, name, address, nic, telephoneNumber);// calling user constructor
        this.licenceNo = licenceNo;
        this.licenceExpireDate = licenceExpireDate;
        this.isCustomer = isCustomer;
    }

    //getters
    public String getLicenceNo() {
        return licenceNo;
    }

    public String getLicenceExpireDate() {
        return licenceExpireDate;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    //check whether is customer registered
    public boolean isRegisteredCustomer(String nic){
        boolean isRegistered = false;
        return isRegistered;
    }

    // check for the licence validity
    public boolean checkLicence(String licenceNo, String licenceExpireDate){
        boolean licenceValid = false;
        return licenceValid;
    }

    //overriding user toString method
    @Override
    public String toString() {
        return "Customer{"+ super.toString() +
                "licenceNo='" + licenceNo + '\'' +
                ", licenceExpireDate='" + licenceExpireDate + '\'' +
                ", isCustomer=" + isCustomer +
                '}';
    }
}
