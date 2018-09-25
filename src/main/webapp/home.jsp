<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
<p><a href="/login?logout">Logout</a></p>
<p>hello world, ${user.firstName} ${user.lastName}</p>
<p>
<table id="chats">
<c:forEach items="${chats}" var="chat">
    <tr>
        <td><a href="/view_chat?chat_id=${chat.id}">${chat.name}</a></td>
    </tr>
</c:forEach>
</table>
</p>
<p><a href="/create_new_chat">Create new chat</a></p>

</body>

</html>