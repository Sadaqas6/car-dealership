package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {

    String fileName = "src/main/resources/contracts.csv";

    public void saveContract(Contract contract) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));


            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                bw.write("SALE|" +
                        sc.getDate() + "|" +
                        sc.getCustomerName() + "|" +
                        sc.getCustomerEmail() + "|" +
                        sc.getVehicleSold().getVin() + "|" +
                        sc.getVehicleSold().getYear() + "|" +
                        sc.getVehicleSold().getMake() + "|" +
                        sc.getVehicleSold().getModel() + "|" +
                        sc.getVehicleSold().getVehicleType() + "|" +
                        sc.getVehicleSold().getColor() + "|" +
                        sc.getVehicleSold().getOdometer() + "|" +
                        sc.getVehicleSold().getPrice() + "|" +
                        sc.taxAmount + "|" +
                        sc.recordingFee + "|" +
                        sc.processingFee + "|" +
                        sc.getTotalPrice() + "|" +
                        sc.isFinanced + "|" +
                        sc.getMonthlyPayment());
                bw.newLine();

            } else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                bw.write("LEASE|" +
                        lc.getDate() + "|" +
                        lc.getCustomerName() + "|" +
                        lc.getCustomerEmail() + "|" +
                        lc.getVehicleSold().getVin() + "|" +
                        lc.getVehicleSold().getYear() + "|" +
                        lc.getVehicleSold().getMake() + "|" +
                        lc.getVehicleSold().getModel() + "|" +
                        lc.getVehicleSold().getVehicleType() + "|" +
                        lc.getVehicleSold().getColor() + "|" +
                        lc.getVehicleSold().getOdometer() + "|" +
                        lc.getVehicleSold().getPrice() + "|" +
                        lc.leaseFee + "|" +
                        lc.expectedEndingValue + "|" +
                        lc.getTotalPrice() + "|" +
                        lc.getMonthlyPayment());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }

    public List<Contract> getContracts() {
        List<Contract> contracts = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null){
                if(line.trim().isEmpty()) continue;

                String[] contractParts  = line.split("\\|");

                String contractType =  contractParts[0];
                String date =  contractParts[1];
                String customerName =  contractParts[2];
                String customerEmail =  contractParts[3];
                int vin =  Integer.parseInt(contractParts[4]);
                int year =  Integer.parseInt(contractParts[5]);
                String make =  contractParts[6];
                String model =  contractParts[7];
                String vehicleType =  contractParts[8];
                String color =  contractParts[9];
                int odometer =  Integer.parseInt(contractParts[10]);
                double price =  Double.parseDouble(contractParts[11]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                if (contractType.equalsIgnoreCase("SALE")){
                    boolean isFinanced = Boolean.parseBoolean(contractParts[16]);
                    SalesContract sc = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
                    contracts.add(sc);
                } else if (contractType.equalsIgnoreCase("LEASE")) {
                    LeaseContract lc = new LeaseContract(date, customerName, customerEmail, vehicle);
                    contracts.add(lc);
                }

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error reading contracts: " + e.getMessage());
        }
        return contracts;
    }



}
