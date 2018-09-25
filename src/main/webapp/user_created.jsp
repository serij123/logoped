<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<body>
Congratulations! User ${user.firstName} ${user.lastName} with login ${user.login} has been created!
Go to : <a href="/login">Login</a>
</body>

</html>