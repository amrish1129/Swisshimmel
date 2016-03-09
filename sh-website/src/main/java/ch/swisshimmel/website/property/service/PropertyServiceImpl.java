package ch.swisshimmel.website.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.swisshimmel.website.persist.property.dao.PropertyDAO;
import ch.swisshimmel.website.persist.property.entity.Property;
 

 
@Service
public class PropertyServiceImpl implements PropertyService {
     
    @Autowired
    private PropertyDAO propertyDAO;

    
    
    @Override
    @Transactional
    public void addProperty(Property p) {
      this.propertyDAO.addProperty(p);
        
    }

    @Override
    @Transactional
    public void updateProperty(Property p) {
        this.propertyDAO.updateProperty(p);
        
    }

    @Override
    @Transactional
    public List<Property> listProperty() {
        return this.propertyDAO.listProperty();
    }

    @Override
    @Transactional
    public Property getPropertyById(int id) {
        return this.propertyDAO.getPropertyById(id);

    }

    @Override
    @Transactional
    public void removeProperty(int id) {
        this.propertyDAO.removeProperty(id);
        
    }

    @Override
    @Transactional
    public Property getPropertyByPropId(String propId) {
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