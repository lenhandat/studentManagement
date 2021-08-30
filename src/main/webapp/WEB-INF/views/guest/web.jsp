<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/reset.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <title>Home</title>
</head>
<body>      
    <header class="header">
        <h1 class="header__title">Student Management</h1>
        <div class="header__right">
            <s:a  namespace="/user" action="login" class="header__right--element header__login"> 
                Login 
                <i class="fas fa-sign-in-alt"></i>
            </s:a>

            <s:a namespace="/guest" action="add" class="header__right--element header__register"> 
                Register
                <i class="fas fa-registered"></i>
            </s:a>
        </div>
    </header>
    <main>
        <h1 class = "title">Welcome to student managerment dashboard</h1>
        <section class="table__student">
            <table class="table__content">
                <thead>
                    <tr>
                        <th>Subject</th>
                        <th>Total Times</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Available Registration</th>
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
		</c:forEach>
                </tbody>
            </table>
        </section>
    </main>
    <script src="./assets/fontAwesome/all.min.js"></script>
</body>
</html>