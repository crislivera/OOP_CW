import com.mongodb.client.MongoClient;

public interface RentalVehicleManager {

    public abstract  void addVehicle(Vehicle vehicle,  MongoClient mongoClient);
    public abstract void deleteVehicle(String delPlate, String decision,MongoClient mongoClient);
    public abstract void updateVehicle();
    public abstract void viewListOfVehicles(MongoClient mongoClient);

}
