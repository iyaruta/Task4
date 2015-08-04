<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/header.jsp"%>
<div class="jumbotron">
  <div class="container">
    <h1>Факультатив</h1>
    <p>Добро пожловать в факультатив Task-4</p>
  </div>
</div>

<div class="container">
  <div class="row">
    <div class="col-md-4">
      <h2>Учитесь</h2>
      <p>Найдите лучшие курсы, пройдите лекции и получите оценки и отзывы лучших преподавателей. </p>
      <p><a class="btn btn-default" href="/task-4/course" role="button">Найти курс »</a></p>
    </div>
    <div class="col-md-4">
      <h2>Преподавайте</h2>
      <p>Лучшие программные решения для преподавателей, автоматизированная зачетка и отслеживание записи студентов.</p>
      <p><a class="btn btn-default" href="/task-4/teacher" role="button">Перейти »</a></p>
    </div>
    <div class="col-md-4">
      <h2>Пройдите тест</h2>
      <p>Пройдите тест чтобы вас записать на курсы.</p>
      <p><a class="btn btn-default" target="_blank" href="/test" role="button">Оценить »</a></p>
    </div>
  </div>
</div>