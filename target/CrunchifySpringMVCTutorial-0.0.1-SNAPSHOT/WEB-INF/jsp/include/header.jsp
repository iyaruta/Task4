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
            margin-top: 35px;
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
                <%--<div class="form-group">--%>
                <%--<input type="text" placeholder="Email" class="form-control">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                <%--<input type="password" placeholder="Password" class="form-control">--%>
                <%--</div>--%>
                <c:choose>
                    <c:when test="${not empty sessionScope.me}">
                        <div class="form-group">

                            <a href="/task-4/infoCourseStudent"
                               class="btn btn-success">Welcome, ${sessionScope.me.name}</a>
                            <a href="/task-4/logout" class="btn btn-danger">Выйти</a>

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