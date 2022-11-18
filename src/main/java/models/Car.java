package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private int ownerId;
    private String regNum;
    private String brand;
    private String model;
    private int year;
    private String gearbox;
    private String fuel;
    private int driveMileage;
    private int price;
    private int tenantId;
    private String bookingStartDate;
    private String bookingStartTime;
    private String bookingEndDate;
    private String bookingEndTime;
    private Boolean available;

    public Car(){
        //creating an empty constructor to prevent error when deserializing and reading from json file.
    }

    public String GetInfo() {
        return "This is a string";
        //return "Booking for car " + FindCar(car_id).toString() + " starting on " + startDate + "T" + startTime + "  ends " + endDate + "T" + endTime;
    }

    public String GetBookingInfo() {
        return "Booking for: " + brand + model + year + " Starting " + bookingStartDate + "T" + bookingStartTime;

    }

    @Override
    public String toString() {
        return brand + " " + model + " " + year;
    }
    public Car(int ownerId, String regNum, String brand, String model, int year, String gearbox, String fuel, int driveMileage, int price, int tenantId, String bookingStartDate, String bookingStartTime, String bookingEndDate, String bookingEndTime, Boolean available) {
        this.regNum = regNum;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.gearbox = gearbox;
        this.fuel = fuel;
        this.driveMileage = driveMileage;
        this.price = price;
        this.tenantId = tenantId;
        this.bookingStartDate = bookingStartDate;
        this.bookingStartTime = bookingStartTime;
        this.bookingEndDate = bookingEndDate;
        this.bookingEndTime = bookingEndTime;
        this.available = available;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(String bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public String getBookingStartTime() {
        return bookingStartTime;
    }

    public void setBookingStartTime(String bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public String getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(String bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public String getBookingEndTime() {
        return bookingEndTime;
    }

    public void setBookingEndTime(String bookingEndTime) {
        this.bookingEndTime = bookingEndTime;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}