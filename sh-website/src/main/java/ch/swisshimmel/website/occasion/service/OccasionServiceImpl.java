package ch.swisshimmel.website.occasion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.swisshimmel.website.occasion.persist.dao.OccasionDAO;
import ch.swisshimmel.website.occasion.persist.entity.Occasion;
import ch.swisshimmel.website.occasion.persist.entity.OccasionTime;
import ch.swisshimmel.website.property.persist.dao.PropertyDAO;
import ch.swisshimmel.website.property.persist.entity.Property;
 

 
@Service
public class OccasionServiceImpl implements OccasionService {
     
    @Autowired
    private OccasionDAO occasionDAO;

    @Override
    public void addOccasion(Occasion o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateOccasion(Occasion o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Occasion> listOccasion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Occasion getOccasionById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeOccasion(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<OccasionTime> getUpcomingOccassion(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    
    
    
 
    
 
    /*@Override
    @Transactional
    public void addProperty(Property p) {
        this.personDAO.addPerson(p);
    }
 
    @Override
    @Transactional
    public void updateProperty(Property p) {
        this.personDAO.updatePerson(p);
    }
 
    @Override
    @Transactional
    public List<Property> listProperty() {
        return this.personDAO.listPersons();
    }
 
    @Override
    @Transactional
    public Person getPropertyById(int id) {
        return this.personDAO.getPersonById(id);
    }
 
    @Override
    @Transactional
    public void removeProperty(String id) {
        this.personDAO.removePerson(id);
    }
 */
}