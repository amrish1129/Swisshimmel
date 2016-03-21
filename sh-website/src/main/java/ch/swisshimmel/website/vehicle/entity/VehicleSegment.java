package ch.swisshimmel.website.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "VEHICLESEGMENT")
public class VehicleSegment {
    
    private Long id;
    private String name;
    private Integer seat;
    private Integer luggage;
    private Integer handBag;
    private String description;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSeat() {
        return seat;
    }
    public void setSeat(Integer seat) {
        this.seat = seat;
    }
    public Integer getLuggage() {
        return luggage;
    }
    public void setLuggage(Integer luggage) {
        this.luggage = luggage;
    }
    public Integer getHandBag() {
        return handBag;
    }
    public void setHandBag(Integer handBag) {
        this.handBag = handBag;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
