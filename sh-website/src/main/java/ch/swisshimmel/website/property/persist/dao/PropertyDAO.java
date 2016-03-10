package ch.swisshimmel.website.property.persist.dao;

import java.util.List;

import ch.swisshimmel.website.property.persist.entity.Property;
 
public interface PropertyDAO {
 
    public void addProperty(Property p);
    public void updateProperty(Property p);
    public List<Property> listProperty();
    public Property getPropertyById(int id);
    public Property getPropertyByPropId(String propId);
    public void removeProperty(int id);
}