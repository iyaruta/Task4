
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>

<ul class="nav nav-pills">
  <%--<c:set var="role_2" value=""/>--%>
  <%--<c:set var="role_3" value=""/>--%>
  <%--<c:set var="role_4" value=""/>--%>
  <c:choose>
  <c:when test="${role eq 2}">
    <c:set var="role_2" value="active"/>
  </c:when>
  <c:when test="${role eq 3}">
    <c:set var="role_3" value="active"/>
  </c:when>
  <c:otherwise>
    <c:set var="role_4" value="active"/>
  </c:otherwise>
  </c:choose>

    <table class="table">
    <thead>
    <tr>
      <th>#</th>
      <th>Факультатив</th>
      <th>Вступительный тест</th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${electives}" var="electives" varStatus="status">
      <tr>
        <td scope="row">${status.index + 1}</td>
        <td>${electives.elective}</td>
        <td><a href="/elective/${electives.id}" class="active">Начать тест</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
    <%@include file="include/footer.jsp" %>
