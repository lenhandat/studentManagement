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
    <link rel="stylesheet" href="../assets/css/reset.css">
    <link rel="stylesheet"   href="../assets/css/login.css">
    <title>Login</title>
</head>
<body>      
    <div class="center">
        <h1>Login</h1>
      
    
        
  <s:form  namespace="/admin" method="post" action="submitloginAdmin">
          <div class="txt_field">
       <input type="text" name="adminName" value="" id="submitloginAdmin_adminName">
            <span></span>
            <label>Username</label>
          </div>
          <div class="txt_field">
           <input type="text" name="adminPassWord" value="" id="submitloginAdmin_adminPassWord">
            <span></span>
            <label>Password</label>
          </div>
          <div class="pass">Forgot Password?</div>
          <input type="submit" value="Submit" id="submitloginAdmin_0" >
          <div class="signup_link">
            Not a member? <s:a namespace="/guest" action="add">Signup</s:a>
          </div>
        </s:form>
        
      </div>
    <script src="../assets/fontAwesome/all.min.js"></script>
</body>
</html>