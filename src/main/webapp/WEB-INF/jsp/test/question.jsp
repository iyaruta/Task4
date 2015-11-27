<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../include/header.jsp" %>

<ul class="nav nav-pills">
  <a href="/test/${question.testId}" class="active">Назад</a>
  <a href="/option/new?questionId=${question.id}" class="active">Добавить ответ</a>
  <h2>${question.question}</h2>

  <table class="table">
    <thead>
    <tr>
      <th>#</th>
      <th>Ответы</th>
      <th>Количество балов</th>
      <th>Удалить вариант</th>
      <th>Изминить</th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${option}" var="item" varStatus="status">
      <tr>
        <td scope="row">${status.index + 1}</td>
        <td>${item.option}</td>
        <td>${item.score}</td>
        <td><a href="/option/${item.id}/remove" class="active">Удалить</a> </td>
        <td><a href="/option/${item.id}/update" class="active">Изминить</a> </td>
        <td>&nbsp;</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

<%@include file="../include/footer.jsp" %>