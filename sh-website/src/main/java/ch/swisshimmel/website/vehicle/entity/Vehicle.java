package ch.swisshimmel.website.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "Vehicle")
public class Vehicle {
    
    private Long id;
    private String licensePlateNumber;
    private String licensePlateState;
    private String licensePlateCountry;
    
    private String make; //Ford
    private String model; // Mustang
    private String style; //convertiable
    private String color;
    private String year;
    private VehicleSegment vehicleSegment;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
    public String getLicensePlateState() {
        return licensePlateState;
    }
    public void setLicensePlateState(String licensePlateState) {
        this.licensePlateState = licensePlateState;
    }
    public String getLicensePlateCountry() {
        return licensePlateCountry;
    }
    public void setLicensePlateCountry(String licensePlateCountry) {
        this.licensePlateCountry = licensePlateCountry;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public VehicleSegment getVehicleSegment() {
        return vehicleSegment;
    }
    public void setVehicleSegment(VehicleSegment vehicleSegment) {
        this.vehicleSegment = vehicleSegment;
    }
    
}
