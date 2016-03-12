/**
 * 
 */
package ch.swisshimmel.website.occasion.persist.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.swisshimmel.website.occasion.persist.entity.Occasion;
import ch.swisshimmel.website.occasion.persist.entity.OccasionTime;

import org.hibernate.Session;

/**
 * @author Manohar Kumar
 *
 */

@Repository
public class OccasionDAOImpl implements OccasionDAO {
    
    
    private static final Logger logger = LoggerFactory.getLogger(OccasionDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addOccasion(Occasion o) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(o);
        logger.info("Occasion Saved " + o.getOccasionName());
        
    }

    @Override
    @Transactional
    public void updateOccasion(Occasion o) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(o);
        logger.info("Occasion Updated " + o.getOccasionName());
        
    }

    @Override
    @Transactional
    public List<Occasion> listOccasion() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Occasion> occasionList = session.createQuery("from Occasion").list();
        return occasionList;
    }

    @Override
    public Occasion getOccasionById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Occasion o = (Occasion) session.get(Occasion.class, new Integer(id));
        return o;
    }

    @Override
    @Transactional
    public void removeOccasion(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Occasion o = (Occasion) session.load(Occasion.class, new Integer(id));
        if(null != o){
            session.delete(o);
        }
        logger.info("Occasion deleted successfully, Occasion details="+o.getOccasionName());
        
    }

    @Override
    @Transactional
    public List<OccasionTime> getUpcomingOccassion(int i) {
        Session session = this.sessionFactory.getCurrentSession();
        return null;
    }
    
    
   /* @Override
    
    
   
  
     
    @Override
    @Transactional
    public Country getCountryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Country c = (Country) session.load(Country.class, new Integer(id));
        logger.info("Property loaded successfully, Property details="+c);
        return c;
    }
    
     (non-Javadoc)
     * @see ch.swisshimmel.website.persist.location.dao.CountryDao#getPropertyByName(java.lang.String)
     
    @Override
    @Transactional
    public Country getCountryByName(String country) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Country> countryList = session.createQuery("from Country where " ).list();
        return null;
    }
    
     (non-Javadoc)
     * @see ch.swisshimmel.website.persist.location.dao.CountryDao#removeCountry(int)
     
    @Override
    @Transactional
    public void removeCountry(int id) {
        
        
    }*/
    
}
