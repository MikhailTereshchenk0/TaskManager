package com.taskmanager.commands;

import com.taskmanager.dao.TaskDaoImpl;
import com.taskmanager.model.Task;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTaskCommand implements Command{
    public String execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Task task = new Task(title, description);
        TaskDaoImpl taskDao = new TaskDaoImpl();
        taskDao.create(task);
        return "/tasks";
    }
}
