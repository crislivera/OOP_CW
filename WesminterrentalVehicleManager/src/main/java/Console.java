import java.util.Scanner;

public class Console {

    public static void main(String[] args) {





       System.out.println("Welcome to Westminster Rental Vehicle Manager Console!");

       boolean exit = false;
       while (!exit){
           exit = menu();

       }

       WestminsterRentalVehicleManager wrm = new WestminsterRentalVehicleManager();
        wrm.sendVehiclesMongo(Mongos.mongoConnection());











    }

    public static boolean menu(){
        System.out.println("To add a car press 1");
        System.out.println("To add a motorbike press 2");
        System.out.println("To delete a vehicle press 3");
        System.out.println("To print the vehicle List press 4");
        System.out.println("To enter the customer GUI press 5");
        System.out.println("To exit program press 0");

        System.out.println("Enter choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        boolean exit = false;
        switch (choice){

            case 1:
                RentalVehicleManager addCar = new WestminsterRentalVehicleManager();
                addCar.addVehicle(addingACar());
                break;

            case 2:
                RentalVehicleManager addBike = new WestminsterRentalVehicleManager();
                addBike.addVehicle(addingAMotorbike());
                break;

            case 3:
                //deleting vehicle here
               deleteVehicle();
                break;

            case 4:
                RentalVehicleManager sys = new WestminsterRentalVehicleManager();
                sys.viewListOfVehicles();
                break;

            case 5:
                System.out.println("not implemented");
                break;
            case 0:
                exit = true;
                break;

                default:
                    System.out.println("Please Enter valid function number:");


        }
        return exit;
    }


    public static   Car addingACar(){
        Scanner add = new Scanner(System.in);
        System.out.println("Adding a Car..................");
        System.out.print("Insert the plate number of the vehicle: ");
        String plateNo = add.next();
        System.out.print("Insert the make of the vehicle: ");
        String make = add.next();
        System.out.print("Inert the model of the vehicle: ");
        String model = add.next();
        System.out.print("Insert the seat capacity of the vehicle: ");
        int seatCap = add.nextInt();
        System.out.print("Insert the fuel capacity of the vehicle: ");
        double fuelCap = add.nextDouble();
        System.out.print("Insert the fuel efficiency of the vehicle: ");
        double fuelEf = add.nextDouble();
        System.out.print("Insert the rental rate for the vehicle:");
        double rental = add.nextDouble();
        System.out.print("Insert the transmission type of the vehicle (Auto/Manual): ");
        String transmission = add.next();
        System.out.print("Insert the number of doors of the vehicle: ");
        int numDoors = add.nextInt();
        System.out.print("Insert the boot capacity of the vehicle:");
        double boot = add.nextDouble();
        System.out.print("Is vehicle conditioned?(YES/NO): ");
        String ac= add.next();
        boolean isAC = false;
        if (ac.equals("YES") || ac.equals("yes")) isAC = true;
        System.out.print("Does vehicle has air bags?(YES/NO): ");
        String ab= add.next();
        boolean hasAB = false;
        if (ab.equals("YES") || ab.equals("yes")) hasAB = true;

        Vehicle car = new Car(plateNo,make,model,seatCap,fuelCap,fuelEf,rental,transmission,numDoors,boot,isAC,hasAB);
        return (Car) car;


    }

    public static Motorbike addingAMotorbike(){
        Scanner add = new Scanner(System.in);
        System.out.println("Adding a Motorbike..................");
        System.out.print("Insert the plate number of the vehicle: ");
        String plateNo = add.next();
        System.out.print("Insert the make of the vehicle: ");
        String make = add.next();
        System.out.print("Inert the model of the vehicle: ");
        String model = add.next();
        System.out.print("Insert the seat capacity of the vehicle: ");
        int seatCap = add.nextInt();
        System.out.print("Insert the fuel capacity of the vehicle: ");
        double fuelCap = add.nextDouble();
        System.out.print("Insert the fuel efficiency of the vehicle: ");
        double fuelEf = add.nextDouble();
        System.out.print("Insert the rental rate for the vehicle:");
        double rental = add.nextDouble();
        System.out.print("Insert the transmission type of the vehicle (Auto/Manual): ");
        String transmission = add.next();
        System.out.print("Is motorbike a Scooter? (YES/NO): ");
        String scoot= add.next();
        boolean isScoot = false;
        if (scoot.equals("YES") || scoot.equals("yes")) isScoot = true;
        System.out.print("Insert the number of helmets given: ");
        int numOfHelmets = add.nextInt();




        Vehicle motorbike = new Motorbike(plateNo,make,model,seatCap,fuelCap,fuelEf,rental,transmission,isScoot,numOfHelmets);
        return (Motorbike) motorbike;

    }
    public static void deleteVehicle(){
        System.out.print("Please enter the vehicle plate number that you want to delete: ");
        Scanner scanner = new Scanner(System.in);
        String plateDel = scanner.next();
        System.out.println("Warning!!! Are you sure to delete "+plateDel+" vehicle? (Y/N):");
        String decision = scanner.next();
        if (decision.equals("y")|| decision.equals("Y")) {
            WestminsterRentalVehicleManager delwrm = new WestminsterRentalVehicleManager();
            delwrm.deleteVehicle(plateDel);
        }
    }
}
