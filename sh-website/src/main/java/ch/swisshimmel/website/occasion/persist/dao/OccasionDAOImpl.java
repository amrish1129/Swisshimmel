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

    @Override
    public void deleteEvent(int i) {
        Session session = this.sessionFactory.getCurrentSession();
        OccasionTime oT = (OccasionTime) session.load(OccasionTime.class, new Integer(i));
        if(null != oT){
            session.delete(oT);
        }        
    }
    
    @Override
    public OccasionTime saveEvent(OccasionTime oT) {
        Session session = this.sessionFactory.getCurrentSession();
        if (oT.getOccasion_time_id() == 0 ) {
        session.persist(oT);
        } else {
            session.update(oT);
        }
        System.out.println("Pesisted Values " + oT.getOccasion_time_id());
        return oT;
    }

   

  
    
}
