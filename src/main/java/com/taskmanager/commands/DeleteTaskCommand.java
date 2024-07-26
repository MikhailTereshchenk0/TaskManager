package com.taskmanager.commands;

import com.taskmanager.dao.TaskDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTaskCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDaoImpl taskDao = new TaskDaoImpl();
        taskDao.delete(request.getParameter("id"));
        return "/index.jsp";
    }
}
