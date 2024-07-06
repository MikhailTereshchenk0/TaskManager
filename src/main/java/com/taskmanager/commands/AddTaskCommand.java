package com.taskmanager.commands;

import com.taskmanager.dao.DatabaseConnector;
import com.taskmanager.dao.TaskDaoImpl;
import com.taskmanager.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "AddTask", value = "/add")
public class AddTaskCommand implements Command{
    public String execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String id = request.getParameter("id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Task task = new Task(title, description);
        //add to DB
        TaskDaoImpl taskDao = new TaskDaoImpl();
        taskDao.create(task);
        return "/tasklist.jsp";
    }
}
