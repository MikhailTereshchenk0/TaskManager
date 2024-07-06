<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add task</title>
</head>
<body>
<h1>Add task</h1>

<form action="addtask" method="post">
    <label for="title">Title:</label>
    <input type="text" name="title" id="title" required>

    <label for="description">Description:</label>
    <textarea name="description" id="description"></textarea>

    <input type="submit" value="Add">
</form>
</body>
</html>