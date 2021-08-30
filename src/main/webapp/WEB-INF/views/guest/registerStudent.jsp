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
    <link rel="stylesheet" href="../assets/css/register.css">
    <title>Register</title>
</head>
<body>      


    <div class="center">
        <h1>Register</h1>
        <s:form namespace="/guest" method="post" action="save">
          <div class="txt_field">
            <input type="text" name="student.name" value="" id="save_name">
            <span></span>
            <label>Enter your username</label>
          </div>
          <div class="txt_field">
            <input  type="text" name="student.passWord" value="" id="save_passWord">
            <span></span>
            <label>Enter your password</label>
          </div>
          
          <div class="txt_field">
            <input type="text" name="student.adrress" value="" id="save_adrress">
            <span></span>
            <label>Enter your address</label>
          </div>

          <div class="txt_radio">
            <div class="radio__male">
                <input id="male" type="radio" name="student.gender" value="male">
                <label>Male</label>
              </div>
              <div class="radio__female">
                <input id="female" type="radio" name="student.gender" value="female">
                <label>Female</label>
              </div>
              
             
          </div>

          <input type="submit"  value="Save" id="save_0" >
          <div class="signup_link">
            Have an account? <a href="#">Login</a>
          </div>
        </s:form>
      </div>
    <script src="./assets/fontAwesome/all.min.js"></script>
</body>
</html>