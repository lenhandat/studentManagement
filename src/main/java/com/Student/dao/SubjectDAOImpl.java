package com.Student.dao;

import com.Student.entites.Subject;
import java.util.List;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;

public class SubjectDAOImpl implements SubjectDAO
{
	
	
	static final Logger logger = LogManager.getLogger(MarkDAOImpl.class);
	
	
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Subject> findAll() {
        try {
            return (List<Subject>)this.entityManager.createQuery("from Subject").getResultList();
        }
        catch (Exception e) {
        	logger.error("RunTime findAll Subject fail: " + e, e);
            return null;
        }
    }
    
    @Override
    public Subject findByID(final int id) {
        try {
            return (Subject)this.entityManager.createQuery("from Subject where subjectID =:id").setParameter("id", id).getSingleResult();
        }
        catch (Exception e) {
        	logger.error("RunTime findByID Subject fail: " + e, e);
            return null;
        }
    }
    
    @Override
    public void create( Subject subject) {
        this.entityManager.persist(subject);
    }
    
    @Override
    public void update( Subject subject) {
        this.entityManager.merge(subject);
    }
    
    @Override
    public void delete( Subject subject) {
        this.entityManager.remove(this.entityManager.merge(subject));
    }
    
    @Override
    public void updateMaxSlot(final int subjectID, final int maxSlot) {
    }
}
