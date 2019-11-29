
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {


private static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
private int numOfVehicles;

    public WestminsterRentalVehicleManager( ) {
        this.numOfVehicles = 50;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {

        System.out.println(vehicleList.size());
        if (vehicleList.size()<numOfVehicles) {
            vehicleList.add(vehicle);
        }else {
            System.out.println("The car park limit is exceeded you cant enter more vehicle.!");
        }
    }



    @Override
    public void deleteVehicle(String plateNo) {

        int preListSize = vehicleList.size();
        int itCount = 0;
        for (Vehicle vehicle:vehicleList){
            if (plateNo.equals(vehicle.getPlateNumber())){
                vehicleList.remove(vehicle);
                System.out.println("The "+vehicle.getClass()+" with plate no: "+vehicle.getPlateNumber()+" is deleted successfully.!");
                break;
            }else {
                itCount++;
                if (itCount==preListSize){
                    System.out.println("The plate number is not in the list.!");
                }
            }

        }
    }

    @Override
    public void updateVehicle() {

    }

    @Override
    public void viewListOfVehicles() {

        for(Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);  // Will invoke overrided `toString()` method
        }
//        //access the database
//        MongoDatabase database = mongoClient.getDatabase("WesminsterRentalVehicleManager");
//        MongoCollection collection = database.getCollection("Vehicle");
//
//        //making the list of objects
//       FindIterable<Document> cursor = collection.find();
//       //creating the count
//       int vehicleCount =1;
//
//       //printing the objects
//       for (Document document : cursor){
//           //checking the type of object in  the database
//          String type = document.getString("type");
//          if (type.equals("car")){
//
//              //converting string inputs to boolean values
//              String isAC = "NO";
//              String hasAB = "NO";
//              if (document.getBoolean("isAirConditioned")) isAC = "YES";
//              if(document.getBoolean("hasAirBags")) hasAB = "YES";
//
//
//              //printing one object of the list
//           System.out.println(vehicleCount+". Type of the vehicle: "+document.get("type")+", Plate No: "+ document.get("_id")+", Make: "+document.get("make")+", Model: "+document.get("model")+
//                   ", Seat capacity: "+ document.get("seatCapacity")+", Fuel capacity: "+document.get("fuelCapacity")+", Fuel efficiency: "+document.get("fuelEfficiency")+", Rental rate: "+
//                   document.get("rental")+", Transmission: "+document.get("transmission")+", Number of doors: "+document.get("numberOfDoors")+", Boot capacity: "+document.get("bootCapacity")+
//                   ", Is air conditioned: "+isAC+", Has air bags: "+hasAB+"\n");
//          }
//          //checking the type of object in  the database
//          else if (type.equals("motorbike")){
//
//              //converting string inputs to boolean values
//              String isScooter = "NO";
//              if (document.getBoolean("isScooter")) isScooter = "YES";
//
//              //printing one object of the list
//              System.out.println(vehicleCount+". Type of the vehicle: "+document.get("type")+", Plate No: "+ document.get("_id")+", Make: "+document.get("make")+", Model: "+document.get("model")+
//                      ", Seat capacity: "+ document.get("seatCapacity")+ ", Fuel capacity: "+document.get("fuelCapacity")+", Fuel efficiency: "+document.get("fuelEfficiency")+", Rental rate: "+
//                      document.get("rental")+", Transmission: "+document.get("transmission")+", Is Scooter: "+isScooter+", Number of Helmets are given: "+document.get("numOfHelmetsGiven")+"\n");
//          }
//          vehicleCount+=1;
//       }
//
    }
    public static void sendVehiclesMongo(MongoClient mongoClient){

       MongoDatabase database = mongoClient.getDatabase("WestminsterRentalVehicleManager");
        MongoCollection collection = database.getCollection("Vehicle");

        for(Vehicle vehicle : vehicleList) {


//checking the vehicle class type
            MongoCollection<Document> existingCollection = database.getCollection("Vehicle");
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("employeeId", 5);
            collection.deleteOne(new Document());
            if (vehicle.getClass() == Car.class) {
                Car car = (Car) vehicle;

                //adding class variables in to the database
                Document document = new Document("_id", vehicle.getPlateNumber());
                document.append("type", "car");
                document.append("make", car.getMake());
                document.append("model", car.getModel());
                document.append("seatCapacity", car.getSeatCapacity());
                document.append("fuelCapacity", car.getFuelCapacity());
                document.append("fuelEfficiency", car.getFuelEfficiency());
                document.append("rental", car.getRental());
                document.append("transmission", car.getTransmission());
                document.append("numberOfDoors", car.getNumberOfDoors());
                document.append("bootCapacity", car.getBootCapacity());
                document.append("isAirConditioned", car.isAirConditioned());
                document.append("hasAirBags", car.isHasAirBags());



                    collection.insertOne(document);
                System.out.println("The car with plate number " + car.getPlateNumber() + " id added successfully!");

            }
            //checking the vehicle class type
            else if (vehicle.getClass() == Motorbike.class) {
                Motorbike motorbike = (Motorbike) vehicle;

                //adding class variables in to the database
                Document document = new Document("_id", vehicle.getPlateNumber());
                document.append("type", "motorbike");
                document.append("make", motorbike.getMake());
                document.append("model", motorbike.getModel());
                document.append("seatCapacity", motorbike.getSeatCapacity());
                document.append("fuelCapacity", motorbike.getFuelCapacity());
                document.append("fuelEfficiency", motorbike.getFuelEfficiency());
                document.append("rental", motorbike.getRental());
                document.append("transmission", motorbike.getTransmission());
                document.append("isScooter", motorbike.isScooter());
                document.append("numOfHelmetsGiven", motorbike.getNumberOfhelmetsGiven());




                    collection.insertOne(document);

                System.out.println("The motorbike with plate number " + motorbike.getPlateNumber() + " id added successfully!");
            }

        }
    }


    public void registerUser(){

    }



    public void loginUser(){

    }


    public void filterVehicles() {


    }

    public void checkAvailability(){

    }

    public void bookVehicel(){

    }





}
