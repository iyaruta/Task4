<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
<div class="head_shift"></div>

<div class="container">
  <form class="form-signin" action="/question/new" method="POST">
    <input type="hidden" name="testId" value="${testId}">
    <h2 class="form-signin-heading">Новый вопрос</h2>
    <label for="inputName" class="sr-only">Название</label>
    <input type="text" name="question" id="inputName" class="form-control" placeholder="Текст вопроса" required=""
           autofocus="">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
    <a href="/test/${testId}" class="btn btn-lg btn-primary btn-block">Назад</a>
  </form>
</div>

<%@include file="../include/footer.jsp" %>a