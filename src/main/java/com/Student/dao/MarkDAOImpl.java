package com.Student.dao;

import java.util.Date;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Student.entites.Mark;

import java.util.List;


import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class MarkDAOImpl implements MarkDAO
{
	 static final Logger logger = LogManager.getLogger(MarkDAOImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Mark> findAll() {
        try {
            return (List<Mark>)this.entityManager.createQuery("from Mark").getResultList();
        }
        catch (Exception e) {
        	logger.error("RunTime FindAllMark: " + e, e);
            return null;
        }
    }
    
    @Override
    public boolean checkExist( int subjectID,  int studentID) {
        
        
       
			 String select = " FROM  Mark  WHERE subjectID =:subjectID and studentID =:studentID ";
         Query q = this.entityManager.createQuery(select);
        q.setParameter("subjectID", (Object)subjectID);
        q.setParameter("studentID", (Object)studentID);
        if (q.getResultList().size() > 0) {
			return true;
		}else {
			return false;
		}
         
		
		
    }
    
    @Override
    public List<Mark> findByID( int studentID) {
        try {
            return (List<Mark>)this.entityManager.createQuery("from Mark where studentID =:studentID").setParameter("studentID", studentID).getResultList();
        }
        catch (Exception e) {
        	logger.error("RunTime findByIDStudent: " + e, e);
            return null;
        }
    }
    
    @Override
    public void create( String studentName,  int subjectID,  String subjectName,  Date testDate,  int studentID) {
        final String insertQuery = "INSERT INTO [dbo].[mark]\r\n           ([mark]\r\n           ,[studentID]\r\n           ,[studentName]\r\n           ,[subjectID]\r\n           ,[subjectName]\r\n           ,[testDate])\r\n     VALUES\r\n           (?\r\n           ,?\r\n           ,?\r\n           ,?\r\n           ,?\r\n           ,?)";
        this.entityManager.createNativeQuery(insertQuery).setParameter(1, 0).setParameter(3, studentName).setParameter(4, subjectID).setParameter(5, subjectName).setParameter(6, testDate).setParameter(2, studentID).executeUpdate();
    }
    
    @Override
    public void update( Mark mark) {
        this.entityManager.merge(mark);
    }
    
    @Override
    public Mark findByMarkID( int markID) {
        try {
            return (Mark)this.entityManager.createQuery("from Mark where markID =:markID").setParameter("markID", markID).getSingleResult();
        }
        catch (Exception e) {
        	logger.error("RunTime findByMarkID: " + e, e);
            return null;
        }
    }

	@Override
	public void delete(Mark mark) {
		// TODO Auto-generated method stub
		 this.entityManager.remove(this.entityManager.merge(mark));
	}
    
}