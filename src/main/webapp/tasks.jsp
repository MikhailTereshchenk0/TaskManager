<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.taskmanager.model.Task" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Task Manager</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1><%= "Task List" %></h1>
<form action = "addtask.jsp">
    <button type = "submit">add</button>
</form>
<br>
<% List<Task> tasks = (List<Task>) session.getAttribute("tasks"); %>
    <% if (tasks != null) { %>

        <form action = "deletetask" method = "post" id = "foo">
            <button type = "submit">delete</button>
        </form>
        <br>
        <% for (Task task : tasks) { %>
        <label>
            <input type = "radio" name = "id" value = "<%=task.getId()%>" form = "foo">
            <%=task.getTitle()%>
        </label>
        <br>
    <% } %>
    <% } else {%>
    <h3>No tasks.</h3>
    <% } %>
</body>