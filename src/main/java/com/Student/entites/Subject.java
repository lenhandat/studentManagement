package com.Student.entites;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "subject")
public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectID;
    private String subjectName;
    private double learnHours;
    private Date startDate;
    private Date endDate;
    private int maxSlot;
    
    public void setSubjectID(final int subjectID) {
        this.subjectID = subjectID;
    }
    
    public int getSubjectID() {
        return this.subjectID;
    }
    
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public void setSubjectName(final String subjectName) {
        this.subjectName = subjectName;
    }
    
    public double getLearnHours() {
        return this.learnHours;
    }
    
    public void setLearnHours(final double learnHours) {
        this.learnHours = learnHours;
    }
    
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }
    
    public int getMaxSlot() {
        return this.maxSlot;
    }
    
    public void setMaxSlot(final int maxSlot) {
        this.maxSlot = maxSlot;
    }
}