<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="../assets/css/reset.css" />
<link rel="stylesheet" href="../assets/css/homeAdmin.css" />
<title>Update Student</title>
</head>
<body>




	<header class="header">
		<h1 class="header__title">Student Management</h1>
		<div class="header__right">
			<h2 class="header__text">Welcome admin:${sessionScope.ADMIN.name }</h2>
			<s:a namespace="/admin" action="logout"
				class="header__right--element header__register">
          Sign out
          <i class="fas fa-sign-out-alt"></i>
			</s:a>
		</div>
	</header>
	<main>
		<section class="section__content">
			<div class="form__addSubject">
				<h1 class="title__form">Update Student</h1>
				<s:form namespace="/admin" method="post" action="updateStudent"
					class="form__add">
					<div class="form__item">
						<label for="">Student Name</label> <input type="text"
							name="student.name" value='<s:property value="student.name"/>'
							id="updateSubject_subjectName">
					</div>
					<div class="form__item">
						<label for="">Student Gender</label>


						<div class="txt_radio">
							<div class="radio__male">
								<input <c:if test="${ student.gender=='male'}">checked="checked"</c:if> id="male" type="radio" name="student.gender" value="male">
								<label>Male</label>
							</div>
							<div class="radio__female">
								<input <c:if test="${student.gender=='female'}">checked="checked"</c:if> id="female" type="radio" name="student.gender"
									value="female"> <label>Female</label>
							</div>

						</div>

					</div>


					<div class="form__item">
						<label for="">Student Address</label> <input type="text"
							name="subject.subjectName"
							value='<s:property value="subject.subjectName"/>'
							id="updateSubject_subjectName">
					</div>

					<div class="form__item">
						<label for="">Role</label>
							


						<div class="txt_radio">
							<div class="radio__male">
								<input <c:if test="${student.role==''}">checked="checked"</c:if> id="student" type="radio" name="student.role" value="">
								<label>Student</label>
							</div>
							<div class="radio__female">
								<input <c:if test="${student.role=='admin'}">checked="checked"</c:if> id="admin" type="radio" name="student.role"
									value="admin"> <label>Admin</label>
							</div>

						</div>
					</div>
					<s:hidden name="student.studentID"></s:hidden>
					<input type="submit" value="UPDATE" id="updateStudent_0">
				</s:form>
			</div>
			<ul class="list__btn">
				<li><s:a namespace="/admin" action="homeSubject"
						class="btn__element header__right--element">Handle Subject</s:a></li>
				<li><s:a namespace="/admin" action="homeStudent"
						class="btn__element header__right--element">Handle Student</s:a></li>

			</ul>
		</section>
	</main>
	<script src="../assets/fontAwesome/all.min.js"></script>


</body>
</html>