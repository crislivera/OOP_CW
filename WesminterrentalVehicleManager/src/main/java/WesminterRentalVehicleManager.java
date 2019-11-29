import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WesminterRentalVehicleManager implements RentalVehicleManager {

private ArrayList<Vehicle> vehicleList;
private int numOfVehicles;

    public WesminterRentalVehicleManager( ) {
        this.numOfVehicles = 50;
    }

    @Override
    public void addVehicle(Vehicle vehicle, MongoClient mongoClient) {

        MongoDatabase database = mongoClient.getDatabase("WesminsterRentalVehicleManager");
        MongoCollection collection = database.getCollection("Vehicle");




        //check if there are slots to park vehicle in the vehicle park

        if (collection.countDocuments()<numOfVehicles){
            //checking the vehicle class type
            if(vehicle.getClass() == Car.class) {
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

                System.out.println("The car with plate number "+car.getPlateNumber()+" id added successfully!");

            }
            //checking the vehicle class type
            else if(vehicle.getClass() == Motorbike.class){
                Motorbike motorbike = (Motorbike)vehicle;

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
                System.out.println("The motorbike with plate number "+motorbike.getPlateNumber()+" id added successfully!");
            }
        }else {
            System.out.println("No more space in the Park!");
        }

    }

    @Override
    public void deleteVehicle(String plateDel,String decision,MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("WesminsterRentalVehicleManager");
        MongoCollection<Document> collection = database.getCollection("Vehicle");




        if (decision.equals("Y") || decision.equals("y")) {
            collection.deleteOne(new Document("name", plateDel));
            System.out.println(plateDel+ " is successfully deleted!");
        }else System.out.println(plateDel+ " is not deleted!");

    }

    @Override
    public void updateVehicle() {

    }

    @Override
    public void viewListOfVehicles(MongoClient mongoClient) {
        //access the database
        MongoDatabase database = mongoClient.getDatabase("WesminsterRentalVehicleManager");
        MongoCollection collection = database.getCollection("Vehicle");

        //making the list of objects
       FindIterable<Document> cursor = collection.find();
       //creating the count
       int vehicleCount =1;

       //printing the objects
       for (Document document : cursor){
           //checking the type of object in  the database
          String type = document.getString("type");
          if (type.equals("car")){

              //converting string inputs to boolean values
              String isAC = "NO";
              String hasAB = "NO";
              if (document.getBoolean("isAirConditioned")) isAC = "YES";
              if(document.getBoolean("hasAirBags")) hasAB = "YES";


              //printing one object of the list
           System.out.println(vehicleCount+". Type of the vehicle: "+document.get("type")+", Plate No: "+ document.get("_id")+", Make: "+document.get("make")+", Model: "+document.get("model")+
                   ", Seat capacity: "+ document.get("seatCapacity")+", Fuel capacity: "+document.get("fuelCapacity")+", Fuel efficiency: "+document.get("fuelEfficiency")+", Rental rate: "+
                   document.get("rental")+", Transmission: "+document.get("transmission")+", Number of doors: "+document.get("numberOfDoors")+", Boot capacity: "+document.get("bootCapacity")+
                   ", Is air conditioned: "+isAC+", Has air bags: "+hasAB+"\n");
          }
          //checking the type of object in  the database
          else if (type.equals("motorbike")){

              //converting string inputs to boolean values
              String isScooter = "NO";
              if (document.getBoolean("isScooter")) isScooter = "YES";

              //printing one object of the list
              System.out.println(vehicleCount+". Type of the vehicle: "+document.get("type")+", Plate No: "+ document.get("_id")+", Make: "+document.get("make")+", Model: "+document.get("model")+
                      ", Seat capacity: "+ document.get("seatCapacity")+ ", Fuel capacity: "+document.get("fuelCapacity")+", Fuel efficiency: "+document.get("fuelEfficiency")+", Rental rate: "+
                      document.get("rental")+", Transmission: "+document.get("transmission")+", Is Scooter: "+isScooter+", Number of Helmets are given: "+document.get("numOfHelmetsGiven")+"\n");
          }
          vehicleCount+=1;
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
