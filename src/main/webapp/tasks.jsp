<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Task Manager</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1><%= "Task List" %>
</h1>
<form action="addtask.jsp">
    <button type="submit">add</button>
</form>
<br>
<form action="deletetask" method="post" id="foo">
    <button type="submit">delete</button>
</form>
<br>
<c:forEach var="task" items="${sessionScope.tasks}">
    <label>
        <input type="radio" name="id" value="${task.getId()}" form="foo">
        <a href="/taskmanager/task?id=${task.getId()}">
            <c:out value="${task.getTitle()}"/>
        </a>
    </label>
    <br>
</c:forEach>
</body>
