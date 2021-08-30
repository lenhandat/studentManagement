package com.Student.service;

import com.Student.entites.Subject;
import java.util.List;

public interface SubjectService
{
    public List<Subject> findAll();
    
    public Subject findByID( int id);
    
    public void create( Subject subject);
    
    public void update( Subject subject);
    
    public void delete( Subject subject);
    
    public void updateMaxSlot( int p0,  int p1);
}