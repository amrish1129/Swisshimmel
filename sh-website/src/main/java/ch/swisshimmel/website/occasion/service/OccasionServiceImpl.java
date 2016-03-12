package ch.swisshimmel.website.occasion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.swisshimmel.website.occasion.persist.dao.OccasionDAO;
import ch.swisshimmel.website.occasion.persist.entity.Occasion;
import ch.swisshimmel.website.occasion.persist.entity.OccasionTime;
 

 
@Service
public class OccasionServiceImpl implements OccasionService {
     
    @Autowired
    private OccasionDAO occasionDAO;

    
    @Override
    @Transactional
    public void addOccasion(Occasion o) {
        this.occasionDAO.addOccasion(o);
        
    }

    
    @Override
    @Transactional
    public void updateOccasion(Occasion o) {
        this.occasionDAO.updateOccasion(o);
        
    }

    @Override
    @Transactional
    public List<Occasion> listOccasion() {
        return this.occasionDAO.listOccasion();
    }

    @Override
    @Transactional
    public Occasion getOccasionById(int id) {
        return this.occasionDAO.getOccasionById(id);
    }

    @Override
    @Transactional
    public void removeOccasion(int id) {
        this.occasionDAO.removeOccasion(id);
        
    }

    @Override
    @Transactional
    public List<OccasionTime> getUpcomingOccassion(int i) {
        // TODO Auto-generated method stub
        return null;
    }

}