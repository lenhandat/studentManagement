package com.Student.dao;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.NoResultException;
import com.Student.entites.Student;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

public class StudentDAOImpl implements StudentDAO
{
	static final Logger logger = LogManager.getLogger(MarkDAOImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Student> findAll() {
        try {
            return (List<Student>)this.entityManager.createQuery("from Student").getResultList();
        }
        catch (Exception e) {
        	logger.error("RunTime findAllStudnet fail: " + e, e);
            return null;
        }
    }
    
    @Override
    public Student findByID( int id) {
        try {
            return (Student)this.entityManager.createQuery("from Student where studentID =:id").setParameter("id", (Object)id).getSingleResult();
        }
        catch (Exception e) {
        	logger.error("RunTime findByID fail: " + e, e);
            return null;
        }
    }
    
    @Override
    public void create( Student student) {
        this.entityManager.persist(student);
    }
    
    @Override
    public void update( Student student) {
        this.entityManager.merge(student);
    }
    
    @Override
    public void delete( Student student) {
        this.entityManager.remove(this.entityManager.merge(student));
    }
    
    @Override
    public Student checkLoginStudent( String name,  String pass) {
        try {
            final String select = "SELECT ua FROM Student ua WHERE ua.name =:name and ua.passWord =:pass ";
            final Query q = this.entityManager.createQuery(select);
            q.setParameter("name", name);
            q.setParameter("pass", pass);
            return (Student)q.getSingleResult();
        }
        catch (NoResultException e) {
        	logger.error("RunTime checkLoginStudent NoResultException: " + e, e);
            return null;
        }
    }
    
    @Override
    public Student checkLoginAdmin( String name,  String pass) {
        try {
            final String select = "SELECT ua FROM Student ua WHERE ua.name =:name and ua.passWord =:pass and role='admin' ";
            final Query q = this.entityManager.createQuery(select);
            q.setParameter("name", name);
            q.setParameter("pass", pass);
            return (Student)q.getSingleResult();
        }
        catch (NoResultException e) {
        	logger.error("RunTime checkLoginAdmin NoResultException: " + e, e);
            return null;
        }
    }
}