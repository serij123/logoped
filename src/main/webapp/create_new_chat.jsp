<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<p><a href="/login?logout">Logout</a></p>
<body>
Creation new chat page
<form:form action="/create_new_chat" modelAttribute="chat" method="post">
    <form:label path="name">Name:</form:label><form:input path="name"/><br/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Create new chat"/>
</form:form>

</body>

</html>