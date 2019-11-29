import java.util.Scanner;

public class Motorbike extends Vehicle {
    private boolean isScooter;
    private int numberOfHelmetsGiven;

    public Motorbike(String plateNumber, String make, String model, int seatCapacity, double fuelCapacity, double fuelEfficiency, double rental, String transmission, boolean isScooter, int numberOfhelmetsGiven) {
        super(plateNumber, make, model, seatCapacity, fuelCapacity, fuelEfficiency, rental, transmission);
        this.isScooter = isScooter;
        this.numberOfHelmetsGiven = numberOfhelmetsGiven;
    }

    public boolean isScooter() {
        return isScooter;
    }

    public int getNumberOfhelmetsGiven() {
        return numberOfHelmetsGiven;
    }

    public String getVehicle(){
      return "motorbike";
    }
    @Override
    public String toString() {
        return "Motorbike{"+super.toString() +
                "isScooter=" + isScooter +
                ", numberOfHelmetsGiven=" + numberOfHelmetsGiven +
                '}';
    }
}
