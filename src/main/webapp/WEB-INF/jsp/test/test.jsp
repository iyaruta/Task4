
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../include/header.jsp" %>

<ul class="nav nav-pills">
  <a href="/test" class="active">Назад</a>
  <a href="/question/new?testId=${test.id}" class="active">Добавить вопрос</a>
  <h2>${test.name}</h2>

  <table class="table">
    <thead>
    <tr>
      <th>#</th>
      <th>Вопрос</th>
      <th>Количество ответов</th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${questions}" var="item" varStatus="status">
      <tr>
        <td scope="row">${status.index + 1}</td>
        <td><a href="/question/${item.id}">${item.question}</a></td>
        <td>${item.size}</td>
        <td>&nbsp;</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

<%@include file="../include/footer.jsp" %>