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
    <link rel="stylesheet" href="../assets/css/homeUser.css" />
    <title>Registered</title>
  </head>
<body>

  <header class="header">
      <h1 class="header__title">Student Management</h1>
      <div class="header__right">
        <h2 class="header__text">Welcome,${sessionScope.USER.name }</a></h2>
        <s:a namespace="/user" action="logout" class="header__right--element header__register">
          Sign out
          <i class="fas fa-sign-out-alt"></i>
        </s:a>
      </div>
    </header>
    <main>
      <h1 class="title">Welcome to student managerment dashboard</h1>
      <section class="section__content">
        <div class="table__student">
          <table class="table__content">
            <thead>
              <tr>
                <th>Subject</th>
                <th>Total Times</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Available Registration</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="subject" items="${subjects}">
              <tr>
                <td>${subject.subjectName}</td>
                <td>${subject.learnHours} hours</td>
                <td>${subject.startDate}</td>
                <td>${subject.endDate}</td>
                <td>${subject.maxSlot}</td>
                <td>
                <s:url var="url_registerSubject" namespace="/user" action="registerSubject">
						<s:param name="subjectID">${subject.subjectID }</s:param>
					</s:url>
                  <s:a href="%{url_registerSubject}">
                    <i class="fas fa-plus"></i>
                    <span>Register</span>
                  </s:a>
                </td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <s:a
          namespace="/user" action="listSubjectRegisted"
          class="btn__view header__right--element"
        >
          View Subject Registered
        </s:a>
      </section>
    </main>
    <script src="../assets/fontAwesome/all.min.js"></script>


	
</body>
</html>