package com.pluralsight;

public class SalesContract extends Contract {

    protected double taxAmount, recordingFee, processingFee;
    protected boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.taxAmount = vehicleSold.getPrice() * 0.05;
        this.recordingFee = 100;
        this.processingFee = vehicleSold.getPrice() < 10000 ? 295 : 495;
        this.isFinanced = isFinanced;
    }


    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + this.taxAmount + this.recordingFee + this.processingFee;
    }

    @Override
    public double getMonthlyPayment() {

        if (isFinanced && getTotalPrice() >= 10000) {
            double monthlyRate = 4.25 / 100 / 12;
            double loanAmount = getTotalPrice();
            int term = 48;
            return monthlyRate * loanAmount / (1 - Math.pow(1 + monthlyRate, -term));
        } else if (isFinanced && getTotalPrice() < 10000) {
            double monthlyRate = 5.25 / 100 / 12;
            double loanAmount = getTotalPrice();
            int term = 24;
            return monthlyRate * loanAmount / (1 - Math.pow(1 + monthlyRate, -term));
        }else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return super.toString() +  // gets the common fields from Contract
                "Type: SALE\n" +
                    "Tax Amount: $" + taxAmount + "\n" +
                    "Recording Fee: $" + recordingFee + "\n" +
                    "Processing Fee: $" + processingFee + "\n" +
                    "Financed: " + isFinanced + "\n" +
                    "Total Price: $" + String.format("%.2f", getTotalPrice()) + "\n" +
                    "Monthly Payment: $" + String.format("%.2f", getMonthlyPayment()) + "\n" +
                    "==============================";
        }

    }
