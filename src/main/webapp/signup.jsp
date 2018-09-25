<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/custom_style.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <form:form action="/signup" modelAttribute="user" method="post" class="form-signin">
        <h2 class="form-signin-heading">User registration</h2>

        <form:label path="firstName" class="sr-only">First Name:</form:label>
        <form:input path="firstName" class="form-control" placeholder="First Name" required="1" autofocus="1" />

        <form:label path="lastName" class="sr-only">Last Name:</form:label>
        <form:input path="lastName" class="form-control" placeholder="Last Name" required="1" />

        <form:label path="email" class="sr-only">Email:</form:label>
        <form:input path="email" class="form-control" placeholder="Email address" required="1"/>

        <form:label path="login" class="sr-only" >Login:</form:label>
        <form:input path="login" class="form-control" placeholder="Login name" required="1"/>

        <form:label path="password" class="sr-only">Password:</form:label>
        <form:password path="password" class="form-control" placeholder="Password" required="1"/>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
    </form:form>

</div>

</body>

</html>