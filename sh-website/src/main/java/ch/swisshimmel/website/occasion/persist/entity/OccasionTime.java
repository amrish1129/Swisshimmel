
package ch.swisshimmel.website.occasion.persist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import ch.swisshimmel.website.common.util.DateUtil;

@Entity
@Table(name="OCCASION_TIME")
public class OccasionTime {
    
    @Id
    @Column(name="occasion_time_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int occasion_time_id;
    
    @Column(name="occasion_id" )
    private int occasion_id;    
    
    @Column(name="dateFrom")
    private Date dateFrom;
    
    @Column(name="dateTo")
    private Date dateTo;

    @Column(name="comment")
    private String comment;
    
    @Column(name="timeEnteredBy")
    private String timeEnteredBy;

    @Column(name="wiki")
    private String wiki;
    

   public OccasionTime() {
        // default constructor
   }
   
   public OccasionTime(int occasion_id ) {
       this.occasion_id = occasion_id;
   }
    
    
    @ManyToOne(optional=false)
    @JoinColumn(name="occasion_id",referencedColumnName="occasion_id", insertable=false, updatable=false)
    private Occasion occasion;

    @Transient
    @NotEmpty(message="Mandatory Field")
    private String dateFromStr;
    
    @Transient
    private String dateToStr;

    
    
    public String getWiki() {
        return wiki;
    }
    
    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getDateFromStr() {
        return DateUtil.convertDateToStr(dateFrom);
    }

    public void setDateFromStr(String dateFromStr) {
        this.dateFromStr = dateFromStr;
        this.dateFrom = DateUtil.convertStrToDate(dateFromStr);
    }

    public String getDateToStr() {
        return DateUtil.convertDateToStr(dateTo);
    }

    public void setDateToStr(String dateToStr) {
        this.dateToStr = dateToStr;
       this.dateTo =  DateUtil.convertStrToDate(dateToStr);
    }

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

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
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
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
