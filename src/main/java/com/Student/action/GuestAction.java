package com.Student.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Action;
import com.Student.entites.Student;
import com.Student.service.StudentService;
import com.Student.entites.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Student.service.SubjectService;
import org.apache.struts2.convention.annotation.Namespace;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/guest")
public class GuestAction extends ActionSupport
{
    private static final long serialVersionUID = 1L;
    @Autowired
    private SubjectService subjectService;
    private List<Subject> subjects;
    private Subject subject;
    private int subjectID;
    @Autowired
    private StudentService studentService;
    private List<Student> students;
    private Student student;
    
    public void setStudent(final Student student) {
        this.student = student;
    }
    
    public Student getStudent() {
        return this.student;
    }
    
    public List<Subject> getSubjects() {
        return this.subjects;
    }
    
    public void setSubjects(final List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public Subject getSubject() {
        return this.subject;
    }
    
    public void setSubject(final Subject subject) {
        this.subject = subject;
    }
    
    public int getSubjectID() {
        return this.subjectID;
    }
    
    public void setSubjectID(final int subjectID) {
        this.subjectID = subjectID;
    }
    
    public List<Student> getStudents() {
        return this.students;
    }
    
    public void setStudents(final List<Student> students) {
        this.students = students;
    }
    
    @Action(value = "index", results = { @Result(name = { "success" }, location = "/WEB-INF/views/guest/web.jsp") })
    public String index() {
        this.subjects = (List<Subject>)this.subjectService.findAll();
        return SUCCESS;

    }
    
    @Action(value = "add", results = { @Result(name = { "success" }, location = "/WEB-INF/views/guest/registerStudent.jsp") })
    public String add() {
        this.student = new Student();
        return SUCCESS;

    }
    
    @Action(value = "save", results = { @Result(name = { "success" }, type = "redirectAction", params = { "namespace", "/user", "actionName", "login" }) })
    public String save() {
        this.studentService.create(this.student);
        return SUCCESS;

    }
    
    @Action(value = "homePage", results = { @Result(name = { "success" }, location = "/WEB-INF/views/guest/HomePage.jsp") })
    public String homePage() {
        this.subjects = (List<Subject>)this.subjectService.findAll();
        return SUCCESS;

    }
    
    @Action(value = "invalid", results = { @Result(name = { "success" }, location = "/WEB-INF/views/user/invalid.jsp") })
    public String invalid() {
        this.subjects = (List<Subject>)this.subjectService.findAll();
        return SUCCESS;

    }
}