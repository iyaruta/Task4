
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../include/header.jsp" %>

<ul class="nav nav-pills">
  <a href="/remove" class="active">Удалить</a>
  <a href="/addTest" class="active">Добавить тест</a>
  <table class="table">
    <thead>
      <tr>
        <th>#</th>
        <th>Название теста</th>
        <th>Количество вопросов</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item" varStatus="status">
      <tr>
        <td scope="row">${status.index + 1}</td>
        <td><a href="/test/${item.id}">${item.name}</a></td>
        <td>${item.size}</td>
        <td>&nbsp;</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
<%@include file="../include/footer.jsp" %>