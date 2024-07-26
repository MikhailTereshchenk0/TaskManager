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
<% List<Task> tasks = (List<Task>) session.getAttribute("tasks"); %>
<ol>
    <% String id; %>
    <% if (tasks != null) { %>
    <% for (Task task : tasks) { %>
        <li><%=task.getTitle()%></li>
        <% id = task.getId();%>
        <form action="deletetask">
            <button type="submit" name="id" value=<%=id%>>delete</button>
        </form>
    <% } %>
    <% } else {%>
    <h3>No tasks.</h3>
    <% } %>
</ol>
</body>