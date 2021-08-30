package com.Student.service;

import com.Student.entites.Subject;
import java.util.List;
import com.Student.dao.SubjectDAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SubjectServiceImpl implements SubjectService
{
    private SubjectDAO subjectDAO;
    
    public SubjectServiceImpl( SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }
    
    @Override
    public List<Subject> findAll() {
        return this.subjectDAO.findAll();
    }
    
    @Override
    public Subject findByID( int id) {
        return this.subjectDAO.findByID(id);
    }
    
    @Override
    public void create( Subject subject) {
        this.subjectDAO.create(subject);
    }
    
    @Override
    public void update( Subject subject) {
        this.subjectDAO.update(subject);
    }
    
    @Override
    public void delete( Subject subject) {
        this.subjectDAO.delete(subject);
    }
    
    @Override
    public void updateMaxSlot( int subjectID,  int maxSlot) {
        this.subjectDAO.updateMaxSlot(subjectID, maxSlot);
    }
}