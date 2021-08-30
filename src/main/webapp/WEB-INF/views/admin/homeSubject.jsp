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
      rel="stylesheet"
    />
    <link rel="stylesheet" href="../assets/css/reset.css" />
    <link rel="stylesheet" href="../assets/css/homeAdmin.css" />
    <title>Home</title>
  </head>
<body>






 <header class="header">
      <h1 class="header__title">Student Management</h1>
      <div class="header__right">
        <h2 class="header__text">Welcome admin:${sessionScope.ADMIN.name }</h2>
        <s:a namespace="/admin" action="logout" class="header__right--element header__register">
          Sign out
          <i class="fas fa-sign-out-alt"></i>
        </s:a>
      </div>
    </header>
    <main>
      <h1 class="title">Welcome to student managerment dashboard</h1>
      <section class="section__content">
        <div class="table__student">
          <s:a namespace="/admin" action="addSubject" class="btn-add header__right--element">
            <i class="fas fa-plus"></i>
            <span> Add Subject </span>
          </s:a>
          <table class="table__content">
            <thead>
              <tr>
                <th>Subject</th>
                <th>Total Times</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Available Registration</th>
                <th>Handle</th>
              </tr>
            </thead>
            <tbody>
                    <c:forEach var="subject" items="${subjects}">
			<tr>
				<td>${subject.subjectName}</td>
				<td>${subject.learnHours}</td>
				<td>${subject.startDate}</td>
				<td>${subject.endDate}</td>
				<td>${subject.maxSlot}</td>	
				<td>
				
				<s:url var="url_update" namespace="/admin" action="editSubject">
						<s:param name="subjectID">${subject.subjectID }</s:param>
					</s:url> 
                  <s:a href="%{url_update}">
                    <i class="fas fa-pen btn-edit"></i>
                  </s:a>
                  
                  <s:url var="url_delete"
						namespace="/admin" action="deleteSubject">
						<s:param name="subjectID">${subject.subjectID }</s:param>
					</s:url>
                  <s:a href="%{url_delete}" onclick="return confirm('Are you sure to delete this subject?')">
                    <i class="fas fa-trash btn-delete"></i>
                  </s:a>
                </td>
		</c:forEach>
              
            </tbody>
          </table>
        </div>
        <ul class="list__btn">
          <li>
            <s:a namespace="/admin" action="homeSubject" class="btn__element header__right--element"
              >Handle Subject</s:a
            >
          </li>
          <li>
            <s:a
               namespace="/admin" action="homeStudent"
              class="btn__element header__right--element"
              >Handle Student</s:a
            >
          </li>
      
        </ul>
      </section>
    </main>
    <script src="../assets/fontAwesome/all.min.js"></script>
  </body>
</html>