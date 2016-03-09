package ch.swisshimmel.website.persist.property.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="PROPERTY")
public class Property {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message ="Please Enter the Property ID")
    private String propId;
    
    @NotEmpty(message ="Please Enter the Property Name")
	private String propertyName;
	
	private String location;
	
	
	private String phoneNumber;
	
	@NotEmpty(message ="Please Enter the Country")
	private String country;
	
	@NotEmpty(message ="Please Enter the City ")
	private String city;
	
	private String nearestAirport;
	
	private String nearestStation;
	
	private String howToReachAirport;
	
	private String howToReachStation;
    
	@Email(message= "Please enter a Valid email")
	@NotEmpty(message = "Please a mail id")
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNearestAirport() {
		return nearestAirport;
	}

	public void setNearestAirport(String nearestAirport) {
		this.nearestAirport = nearestAirport;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public String getHowToReachAirport() {
		return howToReachAirport;
	}

	public void setHowToReachAirport(String howToReachAirport) {
		this.howToReachAirport = howToReachAirport;
	}

	public String getHowToReachStation() {
		return howToReachStation;
	}

	public void setHowToReachStation(String howToReachStation) {
		this.howToReachStation = howToReachStation;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }
	
}
