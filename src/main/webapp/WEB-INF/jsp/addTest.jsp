<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>
<link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
<div class="head_shift"></div>

<div class="container">
  <form class="form-signin" action="/addTest" method="POST">
    <h2 class="form-signin-heading">Добавить тест</h2>
    <label for="inputName" class="sr-only">Название</label>
    <input type="text" name="name" id="inputName" class="form-control" placeholder="Название теста" required=""
           autofocus="">
    <c:if test="${error_password}">
            <span class="error">
                Пароль неверный
            </span>
    </c:if>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
    <a href="/infoTest" class="btn btn-lg btn-primary btn-block">Выйти</a>
  </form>
</div>

<%@include file="include/footer.jsp" %>a