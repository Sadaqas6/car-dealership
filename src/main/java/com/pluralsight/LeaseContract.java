package com.pluralsight;

public class LeaseContract extends Contract {

    protected double leaseFee, expectedEndingValue;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.leaseFee = vehicleSold.getPrice() * 0.07;
        this.expectedEndingValue = vehicleSold.getPrice() * 0.50;
    }

    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() + this.leaseFee + this.expectedEndingValue;
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyRate = 4.0 / 100 / 12;
        double loanAmount = getTotalPrice();
        int term = 36;
        return monthlyRate * loanAmount / (1 - Math.pow(1 + monthlyRate, -term));
    }

    @Override
    public String toString() {
        return super.toString() +  // gets the common fields from Contract
                "Type: LEASE\n" +
                "Lease Fee $" + leaseFee + "\n" +
                "Expected Ending Value: $" + expectedEndingValue + "\n" +
                "Total Price: $" + String.format("%.2f", getTotalPrice()) + "\n" +
                "Monthly Payment: $" + String.format("%.2f", getMonthlyPayment())+ "\n" +
                "==============================";
    }

}

