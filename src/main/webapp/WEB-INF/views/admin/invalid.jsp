<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/reset.css">
    <link rel="stylesheet" href="../assets/css/error.css">
    <title>Error</title>
</head>
<body>

	

  <div id="error-page">
        <div class="content">
     
	<h1><font color="red" size="20px"> Access denied</font></h1>
           
           <div class="btns">
              <s:a namespace="/guest" action="homePage">Home</s:a>
              <s:a namespace="/admin" action="login">Admin Login</s:a>
           </div>
        </div>
     </div>
    <script src="./assets/fontAwesome/all.min.js"></script>
</body>
</html>