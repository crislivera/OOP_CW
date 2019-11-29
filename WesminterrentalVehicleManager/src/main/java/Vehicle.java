

abstract public class Vehicle {
    private String plateNumber;
    private String make;
    private String model;
    private int seatCapacity;
    private double fuelCapacity;
    private double fuelEfficiency;
    private double rental;
    private String transmission;

    public Vehicle(String plateNumber, String make, String model, int seatCapacity, double fuelCapacity, double fuelEfficiency, double rental, String transmission) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.seatCapacity = seatCapacity;
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
        this.rental = rental;
        this.transmission = transmission;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public double getRental() {
        return rental;
    }

    public String getTransmission() {
        return transmission;
    }

    public boolean isAvailabale(Schedule date){
        boolean availabe = true;
        return availabe;
    }
    abstract public String getVehicle();

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", fuelCapacity=" + fuelCapacity +
                ", fuelEfficiency=" + fuelEfficiency +
                ", rental=" + rental +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
