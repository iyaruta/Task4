

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>

<ul class="nav nav-pills">
  <a href="/user" class="active">Назад</a>
  <h2>${elective.elective}</h2>
<tr>
  <th>Вступительный тест</th>
</tr>
  <table class="table">
    <thead>
    <tr>
      <th>#</th>
      <th>Тест</th>
      <th>Количество правильных ответов</th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${questions}" var="item" varStatus="status">
      <tr>
        <td scope="row">${status.index + 1}</td>
        <td><a href="/question/${item.id}">${item.question}</a></td>
        <td>${item.size}</td>
        <td><a href="/question/${item.id}/remove" class="active">Удалить</a></td>
        <td><a href="/question/${item.id}/update" class="active">Изминить</a></td>
        <td>&nbsp;</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

<%@include file="include/footer.jsp" %>