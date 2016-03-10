/**
 * 
 */
package ch.swisshimmel.website.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.swisshimmel.website.location.persist.dao.CountryDAO;
import ch.swisshimmel.website.location.persist.entity.Country;

/**
 * @author Manohar Kumar
 *
 */
@Service
public class CountryServiceImpl implements CountryService {
    
    @Autowired
    private CountryDAO countryDAO;

    
    @Override
    @Transactional
    public void addCountry(Country c) {
        this.countryDAO.addCountry(c);
    }
    
    
    @Override
    @Transactional
    public void updateCountry(Country c) {
        this.countryDAO.updateCountry(c);
    }
    
   
    @Override
    @Transactional
    public List<Country> listCountry() {
      return  this.countryDAO.listCountry();
    }
    
    
    @Override
    @Transactional
    public Country getCountryById(int id) {
        return  this.countryDAO.getCountryById(id);        
    }
    
  
    @Override
    @Transactional
    public Country getCountryByName(String country) {
     return  this.countryDAO.getCountryByName(country);
    }
    
   
    @Override
    @Transactional
    public void removeCountry(int id) {
        this.countryDAO.removeCountry(id);
    }
    
}
