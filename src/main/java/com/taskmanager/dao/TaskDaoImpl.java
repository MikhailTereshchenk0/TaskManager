package com.taskmanager.dao;

import com.taskmanager.model.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDaoImpl implements ITaskDao {

    private static final String SQL_CREATE_TASK = "INSERT INTO task_manager_db.Tasks (Title, Description)" +
            "VALUES (?, ?)";
    private final DatabaseConnector connection = DatabaseConnector.getInstance();
    public TaskDaoImpl() {}
    @Override
    public void create(Task task) {
        try(Connection con = connection.getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQL_CREATE_TASK);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
