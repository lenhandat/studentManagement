package com.Student.dao;

import java.util.Date;
import java.util.List;

import com.Student.entites.Mark;

public interface MarkDAO
{
   public List<Mark> findAll();
    
   public void update( Mark mark);
    
   public  void create( String studentName,  int subjectID,  String subjectName,  Date p3testDate,  int studentID);
    
   public boolean checkExist( int subjectID,  int studentID);
    
   public List<Mark> findByID( int studentID);
    
   public  Mark findByMarkID(final int markID);
   public   void delete( Mark mark);
}
