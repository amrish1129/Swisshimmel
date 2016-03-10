
package ch.swisshimmel.website.occasion.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OCCASION_TIME")
public class OccasionTime {
    
    @Id
    @Column(name="occasion_time_id")
    private int occasion_time_id;
    
    @Column(name="occasion_id" )
    private int occasion_id;
    
    @Column(name="dateFrom")
    private String dateFrom;
    
    @Column(name="dateTo")
    private String dateTo;

    @Column(name="timeEnteredBy")
    private String timeEnteredBy;
    
   
 
    @ManyToOne(optional=false)
    @JoinColumn(name="occasion_id",referencedColumnName="occasion_id", insertable=false, updatable=false)
    private Occasion occasion;

    public int getOccasion_time_id() {
        return occasion_time_id;
    }

    public void setOccasion_time_id(int occasion_time_id) {
        this.occasion_time_id = occasion_time_id;
    }

    public int getOccasion_id() {
        return occasion_id;
    }

    public void setOccasion_id(int occasion_id) {
        this.occasion_id = occasion_id;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getTimeEnteredBy() {
        return timeEnteredBy;
    }

    public void setTimeEnteredBy(String timeEnteredBy) {
        this.timeEnteredBy = timeEnteredBy;
    }

    
    public Occasion getOccasion() {
        return occasion;
    }

    public void setOccasion(Occasion occasion) {
        this.occasion = occasion;
    }
    
}
