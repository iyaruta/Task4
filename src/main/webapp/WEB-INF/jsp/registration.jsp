<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>
<link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
<div class="head_shift"></div>

<div class="container">
    <form class="form-signin" action="/registration" method="POST">
        <h2 class="form-signin-heading">Регистрация</h2>
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email" required="" autofocus="">

        <label for="inputPassword" class="sr-only">Пароль</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Пароль" required="">

        <label for="inputPassword2" class="sr-only">Пароль2</label>
        <input type="password" name="password2" id="inputPassword2" class="form-control" placeholder="Пароль2" required="">

        <label for="inputFirst_name" class="sr-only">First name</label>
        <input type="text" name="firstName" id="inputFirst_name" class="form-control" placeholder="First name" required="">

        <label for="inputLast_name" class="sr-only">Last name</label>
        <input type="text" name="lastName" id="inputLast_name" class="form-control" placeholder="Last name" required="">

        <label for="inputBirthDay" class="sr-only">День Раждения</label>
        <input type="text" name="birthDay" id="inputBirthDay" class="form-control" placeholder="День Рождения">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>

<%@include file="include/footer.jsp" %>