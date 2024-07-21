package com.taskmanager.commands;

import com.taskmanager.dao.TaskDaoImpl;
import com.taskmanager.model.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DisplayTasksCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TaskDaoImpl taskDao = new TaskDaoImpl();

        List<Task> tasks = taskDao.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("tasks", tasks);
        return "/tasks.jsp";
    }
}
