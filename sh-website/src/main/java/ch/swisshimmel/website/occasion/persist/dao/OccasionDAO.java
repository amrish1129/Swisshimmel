package ch.swisshimmel.website.occasion.persist.dao;

import java.util.List;

import ch.swisshimmel.website.occasion.persist.entity.Occasion;
import ch.swisshimmel.website.occasion.persist.entity.OccasionTime;

public interface OccasionDAO {

    public void addOccasion(Occasion o);
    public void updateOccasion(Occasion o);
    public List<Occasion> listOccasion();
    public Occasion getOccasionById(int id);
    public void removeOccasion(int id);
    public List<OccasionTime> getUpcomingOccassion(int i);
    public void deleteEvent(int i);
    public OccasionTime saveEvent(OccasionTime ot);
}
