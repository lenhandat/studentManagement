package com.Student.entites;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "mark")
public class Mark
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int markID;
    private String studentName;
    private int studentID;
    private int subjectID;
    private String subjectName;
    private Date testDate;
    private double mark;
    
    public int getMarkID() {
        return this.markID;
    }
    
    public void setMarkID(final int markID) {
        this.markID = markID;
    }
    
    public int getSubjectID() {
        return this.subjectID;
    }
    
    public void setSubjectID(final int subjectID) {
        this.subjectID = subjectID;
    }
    
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public void setSubjectName(final String subjectName) {
        this.subjectName = subjectName;
    }
    
    public Date getTestDate() {
        return this.testDate;
    }
    
    public void setTestDate(final Date testDate) {
        this.testDate = testDate;
    }
    
    public double getMark() {
        return this.mark;
    }
    
    public void setMark(final double mark) {
        this.mark = mark;
    }
    
    public String getStudentName() {
        return this.studentName;
    }
    
    public void setStudentName(final String studentName) {
        this.studentName = studentName;
    }
    
    public int getStudentID() {
        return this.studentID;
    }
    
    public void setStudentID(final int studentID) {
        this.studentID = studentID;
    }
}
