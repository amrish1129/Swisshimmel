package ch.swisshimmel.website.persist.property.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.swisshimmel.website.persist.property.entity.Property;
 

 
@Repository
public class PropertyDAOImpl implements PropertyDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(PropertyDAOImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
 
    @Override
    public void addProperty(Property p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Property saved successfully, Person Details="+p);
    }
 
    @Override
    public void updateProperty(Property p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Property> listProperty() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Property> propertyList = session.createQuery("from Property").list();
        return propertyList;
    }
 
    @Override
    public Property getPropertyById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Property p = (Property) session.load(Property.class, new Integer(id));
        logger.info("Property loaded successfully, Property details="+p);
        return p;
    }
 
    @Override
    public void removeProperty(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Property p = (Property) session.load(Property.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Property deleted successfully, Property details="+p);
    }

 

    @Override
    public Property getPropertyByPropId(String propId) {
        // TODO Auto-generated method stub
        return null;
    }
 
}