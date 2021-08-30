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
    <title>Handle Mark</title>
  </head>
<body>

	
	
	
	    <header class="header">
      <h1 class="header__title">Student Management</h1>
      <h1>Danh sach khoa hoc da dang ki cua: ${student.name } </h1>
      <div class="header__right">
        <h2 class="header__text">Welcome admin:${sessionScope.ADMIN.name }</h2>
        <s:a namespace="/admin" action="logout" class="header__right--element header__register">
          Sign out
          <i class="fas fa-sign-out-alt"></i>
        </s:a>
      </div>
    </header>
    <main>
      <h1 class="title">Handle Mark Dashboard</h1>
      <section class="section__content">
        <div class="table__student">
          <table class="table__content">
            <thead>
              <tr>
                <th>Subject Name</th>
                <th>Test Date</th>
                <th>Mark</th>
                <th>Operation</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="mark" items="${marks}">
              <tr>
                <td>${mark.subjectName}</td>
				<td>${mark.testDate}</td>
				<td>${mark.mark}</td>
                <td>
                <s:url var="url_updateMark" namespace="/admin" action="editMark" >
		<s:param name="markID">${mark.markID }</s:param>	
		</s:url>
                  <s:a href="%{url_updateMark}">
                    <i class="fas fa-pen btn-edit"></i>
                  </s:a>
                </td>
              </tr>
             </c:forEach>
            </tbody>
          </table>
        </div>
       <ul class="list__btn">
				<li><s:a namespace="/admin" action="homeSubject"
						class="btn__element header__right--element">Handle Subject</s:a>
				</li>
				<li><s:a namespace="/admin" action="homeStudent"
						class="btn__element header__right--element">Handle Student</s:a>
				</li>

			</ul>
      </section>
    </main>
    <script src="../assets/fontAwesome/all.min.js"></script>
</body>
</html>