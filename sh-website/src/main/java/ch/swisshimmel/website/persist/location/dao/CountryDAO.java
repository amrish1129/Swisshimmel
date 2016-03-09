package ch.swisshimmel.website.persist.location.dao;

import java.util.List;

import ch.swisshimmel.website.persist.location.entity.Country;

public interface CountryDAO {

    public void addCountry(Country c);
    public void updateCountry(Country c);
    public List<Country> listCountry();
    public Country getCountryById(int id);
    public Country getCountryByName(String country);
    public void removeCountry(int id);
    
}
