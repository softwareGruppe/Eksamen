package models;

public class Car {
    private String regNum;
    private String brand;
    private String model;
    private int year;
    private String gearbox;
    private String fuel;
    private int driveMileage;
    private int price;
    private Boolean available;

    public Car(){
        //creating an empty constructor to prevent error when deserializing and reading from json file.
    }

    public Car(String regNum, String brand, String model, int year, String gearbox, String fuel, int driveMileage, int price, Boolean available) {
        this.regNum = regNum;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.gearbox = gearbox;
        this.fuel = fuel;
        this.driveMileage = driveMileage;
        this.price = price;
        this.available = available;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getDriveMileage() {
        return driveMileage;
    }

    public void setDriveMileage(int driveMileage) {
        this.driveMileage = driveMileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}