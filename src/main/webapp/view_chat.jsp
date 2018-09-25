<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<body>
<p><a href="/login?logout">Logout</a></p>
<p><a href="/home">Go to home</a></p>
<p>This is chat ${chat.name}</p>

<p>
<table id="messages">
    <c:forEach items="${messages}" var="message">
        <tr>
            <td>${message.dt}</td>
            <td>${message.user}</td>
            <td>${message.text}</td>
        </tr>
    </c:forEach>
</table>
</p>
<form:form action="/post_message?chat_id=${chat.id}" modelAttribute="newMessage" method="post">
    <form:label path="text">Message:</form:label><form:input path="text"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="OK"/>
</form:form>
</body>

</html>