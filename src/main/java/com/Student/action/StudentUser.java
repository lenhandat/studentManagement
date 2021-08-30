package com.Student.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Action;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.Student.entites.Mark;
import com.Student.service.MarkService;
import com.Student.entites.Student;
import com.Student.service.StudentService;
import com.Student.entites.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Student.service.SubjectService;
import org.apache.struts2.convention.annotation.Namespace;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/user")
public class StudentUser extends ActionSupport
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
    @Autowired
    private MarkService markService;
    private Mark mark;
    private List<Mark> marks;
    private Student student;
    private String userName;
    private String passWord;
    SimpleDateFormat formatter;
    Date date;
    
    public StudentUser() {
        this.formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.date = new Date(System.currentTimeMillis());
    }
    
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
    
    @Action(value = "listSubjectRegisted", results = { @Result(name = { "success" }, location = "/WEB-INF/views/user/listSubjectRegisted.jsp") })
    public String listSubjectRegisted() {
         Map<String, Object> session = ActionContext.getContext().getSession();
        this.student = (Student) session.get("USER");
        this.marks = (List<Mark>)this.markService.findByID(this.student.getStudentID());
        return SUCCESS;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public String getPassWord() {
        return this.passWord;
    }
    
    public void setPassWord(final String passWord) {
        this.passWord = passWord;
    }
    
    @Action(value = "registerPage", results = { @Result(name = { "success" }, location = "/WEB-INF/views/user/registerSubject.jsp") })
    public String registerPage() {
        this.subjects = (List<Subject>)this.subjectService.findAll();
        return SUCCESS;

    }
    
    @Action(value = "login", results = { @Result(name = { "success" }, location = "/WEB-INF/views/user/login.jsp") })
    public String login() {
        this.student = new Student();
        return SUCCESS;

    }
    
    @Action(value = "invalidSubject", results = { @Result(name = { "success" }, location = "/WEB-INF/views/user/invalidSubject.jsp") })
    public String invalidSubject() {
        return SUCCESS;

    }
    
    @Action(value = "submitlogin", results = { @Result(name = { "success" }, type = "redirectAction", params = { "namespace", "/user", "actionName", "registerPage" }), @Result(name = { "error" }, type = "redirectAction", params = { "namespace", "/user", "actionName", "invalid" }) })
    public String submitlogin() {
         Map<String, Object> session = ActionContext.getContext().getSession();
        this.student = this.studentService.checkLoginStudent(this.userName, this.passWord);
        if (this.student != null) {
            session.put("USER", this.student);
            return SUCCESS;

        }
        return ERROR;

    }
    
    @Action(value = "logout", results = { @Result(name = { "success" }, type = "redirectAction", params = { "namespace", "/guest", "actionName", "homePage" }) })
    public String logout() {
        Map<String, Object> session = ActionContext.getContext().getSession();
       
        session.remove("USER");
        return SUCCESS;

    }
    
    @Action(value = "registerSubject", results = { @Result(name = { "success" }, type = "redirectAction", params = { "namespace", "/user", "actionName", "listSubjectRegisted" }), @Result(name = { "error" }, type = "redirectAction", params = { "namespace", "/user", "actionName", "invalidSubject" }) })
    public String registerSubject() {
        Map<String, Object> session =ActionContext.getContext().getSession();
        this.student = (Student) session.get("USER");
        this.subject = this.subjectService.findByID(this.subjectID);
        int Maxslot = this.subject.getMaxSlot();
        if (!this.markService.checkExist(this.subject.getSubjectID(), this.student.getStudentID()) && this.date.before(this.subject.getStartDate()) && Maxslot > 0) {
            this.markService.create(this.student.getName(), this.subject.getSubjectID(), this.subject.getSubjectName(), this.subject.getEndDate(), this.student.getStudentID());
            --Maxslot;
            this.subject.setMaxSlot(Maxslot);
            this.subjectService.update(this.subject);
            return SUCCESS;

        }
        return ERROR;

    }
    
    @Action(value = "invalid", results = { @Result(name = { "success" }, location = "/WEB-INF/views/user/invalid.jsp") })
    public String invalid() {
        return SUCCESS;

    }
    
	@Action(value = "cancelSubject", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/user", "actionName", "listSubjectRegisted" }) })
	public String cancelSubject() {
		this.mark=this.markService.findByMarkID(markID);
		this.subject=this.subjectService.findByID(this.mark.getSubjectID());
		int maxSlot=this.subject.getMaxSlot();
		this.markService.delete(this.markService.findByMarkID(this.markID));
		maxSlot=maxSlot+1;
		this.subject.setMaxSlot(maxSlot);
		this.subjectService.update(this.subject);
        return SUCCESS;

	}
	
	private int markID;
    public MarkService getMarkService() {
        return this.markService;
    }
    
    public void setMarkService(final MarkService markService) {
        this.markService = markService;
    }
    
    public Mark getMark() {
        return this.mark;
    }
    
    public void setMark(final Mark mark) {
        this.mark = mark;
    }
    
    public List<Mark> getMarks() {
        return this.marks;
    }
    
    public void setMarks(final List<Mark> marks) {
        this.marks = marks;
    }

	public int getMarkID() {
		return markID;
	}

	public void setMarkID(int markID) {
		this.markID = markID;
	}
}