package com.pluralsight;

public abstract class Contract {

    protected String date, customerName, customerEmail;
    protected Vehicle vehicleSold;


    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    @Override
    public String toString() {
        return "====== Contract Receipt ======\n" +
                "Date: " + date + "\n" +
                "Customer: " + customerName + "\n" +
                "Email: " + customerEmail + "\n" +
                "Vehicle: " + vehicleSold.getYear() + " " + vehicleSold.getMake() + " " + vehicleSold.getModel() + "\n";
    }
}
