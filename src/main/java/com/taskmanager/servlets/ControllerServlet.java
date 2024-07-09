package com.taskmanager.servlets;

import com.taskmanager.commands.Command;
import com.taskmanager.commands.AddTaskCommand;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "main", value = "/")
public class ControllerServlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        commands = new HashMap<>();
        commands.put("addtask", new AddTaskCommand());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlPart = request.getRequestURI();
        String path = urlPart.substring(urlPart.lastIndexOf("/") + 1);
        Command command = commands.get(path);

        if (command == null) {
            response.sendError(404, "Not found");
            return;
        }
        String view = command.execute(request, response);

        if (view != null) {
            path = request.getContextPath() + view;
            response.sendRedirect(path);
        }
        else {
            super.service(request, response);
        }
    }

    public void destroy() {
        super.destroy();
    }
}