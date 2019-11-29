import com.mongodb.client.MongoClient;

public interface RentalVehicleManager {

    public abstract  void addVehicle(Vehicle vehicle);
    public abstract void deleteVehicle(String plateNo);
    public abstract void updateVehicle();
    public abstract void viewListOfVehicles();


}
