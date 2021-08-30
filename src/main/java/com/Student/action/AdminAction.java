package com.Student.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Action;
import com.Student.entites.Mark;
import com.Student.service.MarkService;
import com.Student.entites.Subject;
import com.Student.service.SubjectService;
import com.Student.entites.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Student.service.StudentService;
import org.apache.struts2.convention.annotation.Namespace;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
public class AdminAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private StudentService studentService;
	private List<Student> students;
	private Student student;
	private int studentID;
	private String adminName;
	private String adminPassWord;
	@Autowired
	private SubjectService subjectService;
	private List<Subject> subjects;
	private Subject subject;
	private int subjectID;
	@Autowired
	private MarkService markService;
	private Mark mark;
	private List<Mark> marks;
	private int markID;

	public void setStudent(final Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return this.student;
	}

	public int getStudentID() {
		return this.studentID;
	}

	public void setStudentID(final int studentID) {
		this.studentID = studentID;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(final List<Student> students) {
		this.students = students;
	}

	@Action(value = "homeStudent", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/homeStudent.jsp") })
	public String index() {
		this.setStudents(this.studentService.findAll());
        return SUCCESS;

	}

	@Action(value = "addStudent", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/addStudent.jsp") })
	public String addStudent() {
		this.student = new Student();
        return SUCCESS;

	}

	@Action(value = "saveStudent", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/admin", "actionName", "homeStudent" }) })
	public String save() {
		this.studentService.create(this.student);
        return SUCCESS;

	}

	@Action(value = "deleteStudent", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/admin", "actionName", "homeStudent" }) })
	public String deleteStudent() {
		this.studentService.delete(this.studentService.findByID(this.studentID));
        return SUCCESS;

	}

	@Action(value = "editStudent", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/editStudent.jsp") })
	public String editStudent() {
		this.student = this.studentService.findByID(this.studentID);
        return SUCCESS;

	}

	@Action(value = "updateStudent", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/admin", "actionName", "homeStudent" }) })
	public String updateStudent() {
		this.studentService.update(this.student);
        return SUCCESS;

	}

	@Action(value = "login", results = { @Result(name = { "success" }, location = "/WEB-INF/views/admin/login.jsp") })
	public String login() {
        return SUCCESS;

	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(final String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassWord() {
		return this.adminPassWord;
	}

	public void setAdminPassWord(final String adminPassWord) {
		this.adminPassWord = adminPassWord;
	}

	@Action(value = "submitloginAdmin", results = {
			@Result(name = { "success" }, type = "redirectAction", params = { "namespace", "/admin", "actionName",
					"homeSubject" }),
			@Result(name = { "error" }, type = "redirectAction", params = { "namespace", "/admin", "actionName",
					"invalid" }) })
	public String submitloginAdmin() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.student = this.studentService.checkLoginAdmin(this.adminName, this.adminPassWord);
		if (this.student != null) {
			session.put("ADMIN", this.student);
	        return SUCCESS;

		}
		return ERROR;
	}

	@Action(value = "invalid", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/invalid.jsp") })
	public String invalid() {
		return "success";
	}

	@Action(value = "logout", results = { @Result(name = { "success" }, type = "redirectAction", params = { "namespace",
			"/guest", "actionName", "homePage" }) })
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("ADMIN");
        return SUCCESS;

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

	@Action(value = "homeSubject", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/homeSubject.jsp") })
	public String homeSubject() {
		this.subjects = (List<Subject>) this.subjectService.findAll();
        return SUCCESS;

	}

	@Action(value = "addSubject", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/addSubject.jsp") })
	public String addSubject() {
		this.subject = new Subject();
        return SUCCESS;

	}

	@Action(value = "saveSubject", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/admin", "actionName", "homeSubject" }) })
	public String saveSubject() {
		this.subjectService.create(this.subject);
        return SUCCESS;

	}

	@Action(value = "deleteSubject", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/admin", "actionName", "homeSubject" }) })
	public String deleteSubject() {
		this.subjectService.delete(this.subjectService.findByID(this.subjectID));
        return SUCCESS;

	}

	@Action(value = "editSubject", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/editSubject.jsp") })
	public String editSubject() {
		this.subject = this.subjectService.findByID(this.subjectID);
        return SUCCESS;

	}

	@Action(value = "updateSubject", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/admin", "actionName", "homeSubject" }) })
	public String updateSubject() {
		this.subjectService.update(this.subject);
        return SUCCESS;

	}

	public int getSubjectID() {
		return this.subjectID;
	}

	public void setSubjectID(final int subjectID) {
		this.subjectID = subjectID;
	}

	@Action(value = "viewMark", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/viewMark.jsp") })
	public String viewMark() {
		this.student = this.studentService.findByID(this.studentID);
		this.setMarks(this.markService.findByID(this.student.getStudentID()));
        return SUCCESS;

	}

	@Action(value = "editMark", results = {
			@Result(name = { "success" }, location = "/WEB-INF/views/admin/editMark.jsp") })
	public String editMark() {
		this.mark = this.markService.findByMarkID(this.markID);
        return SUCCESS;

	}

	@Action(value = "updateMark", results = { @Result(name = { "success" }, type = "redirectAction", params = {
			"namespace", "/admin", "actionName", "homeStudent" }) })
	public String updateMark() {
		this.markService.update(this.mark);
        return SUCCESS;

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
		return this.markID;
	}

	public void setMarkID(final int markID) {
		this.markID = markID;
	}
}