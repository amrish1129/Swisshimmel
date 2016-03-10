package ch.swisshimmel.website.occasion.persist.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OCCASION")
public class Occasion {

    @Id
    @Column(name="occasion_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int occasion_id;
    
  //  @Column(name="occasionName")
    private String occasionName;
    
    //@Column(name="city")
    private String city;
    
   // @Column(name="country")
    private String country;
    
    //@Column(name="comment")
    private String comment;

    //@Column(name="wikiLink")
    private String  wikiLink ;
    
    //@Column(name="occasionName")
    private boolean repeatsEveryYear;
    
    //@Column(name="timeEnteredBy")
    private Date timeEnteredBy;
    
    
    @OneToMany(targetEntity=OccasionTime.class, mappedBy="occasion_id", fetch=FetchType.EAGER)
    private List<OccasionTime> occasionTimesList;

    
    
    public int getOccasion_id() {
        return occasion_id;
    }

    public void setOccasion_id(int occasion_id) {
        this.occasion_id = occasion_id;
    }

    public String getOccasionName() {
        return occasionName;
    }

    public void setOccasionName(String occasionName) {
        this.occasionName = occasionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public boolean isRepeatsEveryYear() {
        return repeatsEveryYear;
    }

    public void setRepeatsEveryYear(boolean repeatsEveryYear) {
        this.repeatsEveryYear = repeatsEveryYear;
    }

    public Date getTimeEnteredBy() {
        return timeEnteredBy;
    }

    public void setTimeEnteredBy(Date timeEnteredBy) {
        this.timeEnteredBy = timeEnteredBy;
    }

    public List<OccasionTime> getOccasionTimes() {
        return occasionTimesList;
    }

    public void setOccasionTimes(List<OccasionTime> occasionTimesList) {
        this.occasionTimesList = occasionTimesList;
    }   
    
}

