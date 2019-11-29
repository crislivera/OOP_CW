import java.util.Scanner;

public class Car extends Vehicle {

    private int numberOfDoors;
    private double bootCapacity;
    private boolean isAirConditioned;
    private boolean hasAirBags;

    public Car(String plateNumber, String make, String model, int seatCapacity, double fuelCapacity, double fuelEfficiency, double rental, String transmission, int numberOfDoors, double bootCapacity, boolean isAirConditioned, boolean hasAirBags) {
        super(plateNumber, make, model, seatCapacity, fuelCapacity, fuelEfficiency, rental, transmission);
        this.numberOfDoors = numberOfDoors;
        this.bootCapacity = bootCapacity;
        this.isAirConditioned = isAirConditioned;
        this.hasAirBags = hasAirBags;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public double getBootCapacity() {
        return bootCapacity;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public boolean isHasAirBags() {
        return hasAirBags;
    }

    public String getVehicle(){
       return "car";
    }

    @Override
    public String toString() {
        return "Car{"+super.toString() +
                "numberOfDoors=" + numberOfDoors +
                ", bootCapacity=" + bootCapacity +
                ", isAirConditioned=" + isAirConditioned +
                ", hasAirBags=" + hasAirBags +
                '}';
    }
}
