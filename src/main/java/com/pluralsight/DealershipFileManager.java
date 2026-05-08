package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DealershipFileManager {

public Dealership getDealership() {


    try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

        // Reads the first line (Dealership Info)
        String firstLine = bufferedReader.readLine();
        // Reads the vehicle lines
        String line;

        String[] dealershipParts = firstLine.split("\\|");
        String name = dealershipParts[0].trim();
        String address = dealershipParts[1].trim();
        String phone = dealershipParts[2].trim();

        // creating new Dealership Object
        Dealership dealership = new Dealership(dealershipParts[0], dealershipParts[1], dealershipParts[2]);


        while ((line = bufferedReader.readLine()) != null){

            String[] vehicleParts = line.split("\\|");
            int vin = Integer.parseInt(vehicleParts[0]);
            int year = Integer.parseInt(vehicleParts[1]);
            String make = vehicleParts[2];
            String model = vehicleParts[3];
            String vehicleType = vehicleParts[4];
            String color = vehicleParts[5];
            int odometer = Integer.parseInt(vehicleParts[6]);
            double price = Double.parseDouble(vehicleParts[7]);

            // Creating a new Vehicle Object
            Vehicle vehicle = new Vehicle(vin, year, make, model,vehicleType, color, odometer, price);
            dealership.addVehicle(vehicle);  // adding vehicle to the dealership object

        }
        bufferedReader.close();
        return dealership;

    } catch (IOException e){
        System.out.println("Error reading file: " + e.getMessage());
    }
    return null;
}

public void saveDealership(Dealership dealership){


}

}
