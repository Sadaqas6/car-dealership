package com.pluralsight;
import java.util.List;
import java.util.Scanner;


public class UserInterface {



    private Dealership dealership;
    private Scanner sc = new Scanner(System.in);
    private void loadDealership(){

        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void display(){

        loadDealership();  // grabbing the instance of the DealershipFileManager class


        int choice = 0;

        while (choice != 0) {

             displayMenu();   // Calling on the menu

            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    // add vehicle
                    break;
                case 9:
                    // remove vehicle
                    break;
                case 99:
                    System.out.println("Goodbye!!");
                    System.exit(99);
                    break;
                default:
                    System.out.println("Invalid option, please TRY AGAIN.");

            }
        }
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("1 - Find vehicles within price range");
        System.out.println("2 - Find vehicles by make/model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
    }


    private void displayVehicles(List<Vehicle> vehicles) {
        for(Vehicle v : vehicles){
            System.out.println(v);
        }
    }

    private void processGetByPriceRequest(){
        System.out.print("Please enter the minimum price you are looking for: ");
        double min = sc.nextDouble();
        System.out.print("Please enter the maximum price you are looking for: ");
        double max = sc.nextDouble();

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);

    }

    private void processGetByMakeModelRequest(){
        System.out.print("Please enter the make of the vehicle you are looking for: ");
        String make = sc.nextLine().trim();
        System.out.print("Please enter the model of the vehicle you are looking for: ");
        String model = sc.nextLine().trim();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest(){
        System.out.print("Please enter the minimum year you are looking for: ");
        int min = sc.nextInt();
        System.out.print("Please enter the maximum year you are looking for: ");
        int max = sc.nextInt();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);

    }

    private void processGetByColorRequest(){
        System.out.print("Please enter the desired color you are looking for: ");
        String color = sc.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);

    }

    private void processGetByMileageRequest(){
        System.out.print("Please enter the minimum mileage you are looking for: ");
        int min = sc.nextInt();
        System.out.print("Please enter the maximum mileage you are looking for: ");
        int max = sc.nextInt();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);

    }

    private void processGetByVehicleTypeRequest(){
        System.out.print("Please enter the type of vehicle you are looking for: ");
        String vehicleType = sc.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);

    }

    private void processAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
}
