package com.Student.service;

import java.util.Date;
import com.Student.entites.Mark;
import java.util.List;
import com.Student.dao.MarkDAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MarkServiceImpl implements MarkService
{
    private MarkDAO markDao;
    
    public MarkServiceImpl( MarkDAO markDao) {
        this.markDao = markDao;
    }
    
    @Override
    public List<Mark> findAll() {
        return this.markDao.findAll();
    }
    
    @Override
    public void create( String studentName,  int subjectID,  String subjectName,  Date testDate,  int studentID) {
        this.markDao.create(studentName, subjectID, subjectName, testDate, studentID);
    }
    
    @Override
    public boolean checkExist( int subjectID,  int studentID) {
        return this.markDao.checkExist(subjectID, studentID);
    }
    
    @Override
    public List<Mark> findByID( int studentID) {
        return this.markDao.findByID(studentID);
    }
    
    @Override
    public void update( Mark mark) {
        this.markDao.update(mark);
    }
    
    @Override
    public Mark findByMarkID( int markID) {
        return this.markDao.findByMarkID(markID);
    }

	@Override
	public void delete(Mark mark) {
		// TODO Auto-generated method stub
		this.markDao.delete(mark);
	}
}