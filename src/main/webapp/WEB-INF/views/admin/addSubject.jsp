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
    <link rel="stylesheet" href="../assets/css/addSubject.css" />
    <title>Add Subject</title>
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
      <section class="section__content">
        <div class="form__addSubject">
          <h1 class="title__form">Add Subject</h1>
          <s:form namespace="/admin" method="post" action="saveSubject" class="form__add">
            <div class="form__item">
              <label for="">Subject Name</label>
              <input type="text" name="subject.subjectName" value="" id="saveSubject_subjectName">
            </div>
            <div class="form__item">
              <label for="">Learn Hours</label>
              <input type="text" name="subject.learnHours" value="" id="saveSubject_learnHours">
            </div>

            <div class="form__item">
              <label for="">Start Date</label>
               <input type="text" name="subject.startDate" value="" id="saveSubject_startDate">
            </div>

            <div class="form__item">
              <label for="">End Date</label>
               <input type="text" name="subject.endDate" value="" id="saveSubject_endDate">
            </div>

            <div class="form__item">
              <label for="">Max Slot</label>
              <input type="text" name="subject.maxSlot" value="" id="saveSubject_maxSlot">
            </div>
            <input type="submit"  value="Save" id="save_0" >
          </s:form>
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