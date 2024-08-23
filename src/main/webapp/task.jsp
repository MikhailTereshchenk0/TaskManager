<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Task</h3>
<p>Title: "${sessionScope.task.getTitle()}"</p>
<p>Description: "${sessionScope.task.getDescription()}"</p>
</body>
</html>
