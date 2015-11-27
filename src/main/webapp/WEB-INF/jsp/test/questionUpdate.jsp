<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
<div class="head_shift"></div>

<div class="container">
  <form class="form-signin" action="/question/update" method="POST">
    <input type="hidden" name="id" value="${question.id}">
    <h2 class="form-signin-heading">Изминить</h2>
    <input type="text" name="question" id="inputName" class="form-control" value="${question.question}" required=""
           autofocus="">

    <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
    <a href="/test/${question.testId}" class="btn btn-lg btn-primary btn-block">Назад</a>
  </form>
</div>

<%@include file="../include/footer.jsp" %>a