/**
 * 
 */
package ch.swisshimmel.website.location.persist.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.swisshimmel.website.location.persist.entity.Country;

/**
 * @author Manohar Kumar
 *
 */

@Repository
public class CountryDAOImpl implements CountryDAO {
    
    
    private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    @Transactional
    public void addCountry(Country c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Country saved successfully, Country Details="+c);
        
    }
    
    /* (non-Javadoc)
     * @see ch.swisshimmel.website.persist.location.dao.CountryDao#updateCountry(ch.swisshimmel.website.persist.location.entity.Country)
     */
    @Override
    @Transactional
    public void updateCountry(Country c ){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("Country saved successfully, Country Details="+c);
        
    }
    
   
    @SuppressWarnings("unchecked")
    @Override
    public List<Country> listCountry() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Country> countryList = session.createQuery("from Country").list();
        return countryList;
    }
    
    /* (non-Javadoc)
     * @see ch.swisshimmel.website.persist.location.dao.CountryDao#getCountryById(int)
     */
    @Override
    @Transactional
    public Country getCountryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Country c = (Country) session.load(Country.class, new Integer(id));
        logger.info("Property loaded successfully, Property details="+c);
        return c;
    }
    
    /* (non-Javadoc)
     * @see ch.swisshimmel.website.persist.location.dao.CountryDao#getPropertyByName(java.lang.String)
     */
    @Override
    @Transactional
    public Country getCountryByName(String country) {
       /* Session session = this.sessionFactory.getCurrentSession();
        List<Country> countryList = session.createQuery("from Country where " ).list();*/
        return null;
    }
    
    /* (non-Javadoc)
     * @see ch.swisshimmel.website.persist.location.dao.CountryDao#removeCountry(int)
     */
    @Override
    @Transactional
    public void removeCountry(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Country c = (Country) session.load(Country.class, new Integer(id));
        if(null != c){
            session.delete(c);
        }
        logger.info("Country deleted successfully, Country details="+c);
        
    }
    
}
