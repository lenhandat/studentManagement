package com.Student.entites;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;
    private String name;
    private String passWord;
    private String gender;
    private String adrress;
    private String role;
    
    public String getAdrress() {
        return this.adrress;
    }
    
    public void setAdrress(final String adrress) {
        this.adrress = adrress;
    }
    
    public void setStudentID(final int studentID) {
        this.studentID = studentID;
    }
    
    public int getStudentID() {
        return this.studentID;
    }
    
    public String getPassWord() {
        return this.passWord;
    }
    
    public void setPassWord(final String passWord) {
        this.passWord = passWord;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(final String gender) {
        this.gender = gender;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public void setRole(final String role) {
        this.role = role;
    }
}