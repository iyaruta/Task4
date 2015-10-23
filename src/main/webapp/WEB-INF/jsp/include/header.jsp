<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to University</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <style>
        .head_shift {
            margin-top: 65px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/task-4">Task - 4</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <div class="form-group">
                            <c:choose>
                                <c:when test="${sessionScope.user.roleId eq 1}">
                                    <c:set var="url" value="/admin"/>
                                </c:when>
                                <c:when test="${sessionScope.user.roleId eq 2}">
                                    <c:set var="url" value="/user"/>
                                </c:when>
                                <c:when test="${sessionScope.user.roleId eq 3}">
                                    <c:set var="url" value="/teacher"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="url" value="/MyStudentCourse"/>
                                </c:otherwise>
                            </c:choose>
                            <a href="${url}"
                               class="btn btn-success">Welcome, ${sessionScope.user.firstName}</a>
                            <a href="/logout" class="btn btn-danger">Выход</a>

                        </div>
                    </c:when>
                    <c:otherwise>
                        <a href="/login" class="btn btn-success">Вход</a>
                        <a href="/registration" class="btn btn-success">Регистрация</a>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
        <!--/.navbar-collapse -->
    </div>
</nav>
<div class="head_shift"></div>