package ch.swisshimmel.website.location.persist.dao;

import java.util.List;

import ch.swisshimmel.website.location.persist.entity.Country;

public interface CountryDAO {

    public void addCountry(Country c);
    public void updateCountry(Country c);
    public List<Country> listCountry();
    public Country getCountryById(int id);
    public Country getCountryByName(String country);
    public void removeCountry(int id);
    
}
