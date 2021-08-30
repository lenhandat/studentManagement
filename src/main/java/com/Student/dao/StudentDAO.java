package com.Student.dao;

import com.Student.entites.Student;
import java.util.List;

public interface StudentDAO
{
  public  List<Student> findAll();
    
  public  Student findByID( int studentID);
    
  public  void create( Student student);
    
  public   void update( Student student);
    
  public   void delete( Student student);
    
  public Student checkLoginStudent( String name,  String pass);
    
  public  Student checkLoginAdmin( String name,  String pass);
}