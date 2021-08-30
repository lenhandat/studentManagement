package com.Student.service;

import com.Student.entites.Student;
import java.util.List;
import com.Student.dao.StudentDAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentServiceImpl implements StudentService
{
    private StudentDAO studentDAO;
    
    public StudentServiceImpl( StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    
    @Override
    public List<Student> findAll() {
        return this.studentDAO.findAll();
    }
    
    @Override
    public Student findByID( int id) {
        return this.studentDAO.findByID(id);
    }
    
    @Override
    public void create( Student student) {
        this.studentDAO.create(student);
    }
    
    @Override
    public void update( Student student) {
        this.studentDAO.update(student);
    }
    
    @Override
    public void delete( Student student) {
        this.studentDAO.delete(student);
    }
    
    @Override
    public Student checkLoginStudent( String name,  String pass) {
        return this.studentDAO.checkLoginStudent(name, pass);
    }
    
    @Override
    public Student checkLoginAdmin( String name,  String pass) {
        return this.studentDAO.checkLoginAdmin(name, pass);
    }
}