<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.taskmanager.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="com.taskmanager.servlets.ControllerServlet" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Task Manager</title>
</head>
<body>
<h1><%= "Task List" %>
</h1>
<ul>
    <% List<Task> tasks = (List<Task>) session.getAttribute("tasks"); %>
    <% if (tasks != null) { %>
    <% for (Task task : tasks) { %>
    <h3>
        <%=task.getTitle()%>
    </h3>
    <% } %>
    <% } else {%>
    <h3>No tasks.</h3>
    <% } %>
</ul>
</body>