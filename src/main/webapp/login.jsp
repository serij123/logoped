<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/custom_style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/login" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please login</h2>

        <label for="username" class="sr-only">username:</label>
        <input type="text" class="form-control" placeholder="Login name" required="1" autofocus="1" id="username" name="username"/>

        <label for="password" class="sr-only">Password:</label>
        <input id="password" type="password" class="form-control" placeholder="Password" required="1" name="password"/>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
        <a href="/signup" class="btn btn-block btn-secondary">Sign Up</a>
    </form>
</div>


</body>

</html>