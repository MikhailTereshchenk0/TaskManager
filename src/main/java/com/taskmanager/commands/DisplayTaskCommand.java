package com.taskmanager.commands;

import com.taskmanager.dao.TaskDaoImpl;
import com.taskmanager.model.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayTaskCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TaskDaoImpl taskDao = new TaskDaoImpl();
        String id = request.getParameter("id");
        System.out.println(id);//
        Task task = taskDao.findById(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("task", task);
        return "/task.jsp";
    }
}
