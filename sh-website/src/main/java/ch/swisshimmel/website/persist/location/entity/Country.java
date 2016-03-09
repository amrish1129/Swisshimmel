package ch.swisshimmel.website.persist.location.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Country")
public class Country {

    
    @Id
    @Column(name="countryId")
    private int countryId;
    
    @NotEmpty(message="Please enter a country Name")
    @Column(name="countryName")
    private String countryName;
    
    @NotEmpty(message="Country Must have a currency")
    @Column(name="currency")
    private String currency;
    
    @Column(name="shortCountryCode")
    private String shortCountryCode;
    
    @Column(name="countryEnteredBy")
    private String countryEnteredBy;

    
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getShortCountryCode() {
        return shortCountryCode;
    }

    public void setShortCountryCode(String shortCountryCode) {
        this.shortCountryCode = shortCountryCode;
    }

    public String getCountryEnteredBy() {
        return countryEnteredBy;
    }

    public void setCountryEnteredBy(String countryEnteredBy) {
        this.countryEnteredBy = countryEnteredBy;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
}

