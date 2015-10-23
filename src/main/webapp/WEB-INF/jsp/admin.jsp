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

        <li role="2" class="${role_2}"><a href="/admin/user?role=2">User</a></li>
        <li role="3" class="${role_3}"><a href="/admin/user?role=3">Teacher</a></li>
        <li role="4" class="${role_4}"><a href="/admin/user?role=4">Student</a></li>
            <a href="/infoTest" class="active">Тест</a>

<table class="table">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>День рождения</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.birthDay}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="include/footer.jsp" %>