package com.taskmanager.dao;

import com.taskmanager.model.Task;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements ITaskDao {

    private static final String SQL_CREATE_TASK = "INSERT INTO Tasks (Title, Description)" +
            "VALUES (?, ?)";
    private static final String SQL_FIND_ALL = "SELECT * FROM Tasks;";
    private static final String SQL_DELETE_TASK = "DELETE FROM Tasks WHERE Id = ?";
    private final DatabaseConnector connection = DatabaseConnector.getInstance();

    public TaskDaoImpl() {
    }

    @Override
    public void create(Task task) {
        try {
            Connection con = connection.getConnection();
            PreparedStatement statement = con.prepareStatement(SQL_CREATE_TASK);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.executeUpdate();
        } catch (SQLException | NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    public List<Task> findAll() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Connection con = connection.getConnection();
            ResultSet resultSet = con.createStatement().executeQuery(SQL_FIND_ALL);
            while (resultSet.next()) {
                tasks.add(getTask(resultSet));
            }
        }
        catch (SQLException | NullPointerException exception) {
            exception.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void delete(String id) {
        try{
            Connection con = connection.getConnection();
            PreparedStatement statement = con.prepareStatement(SQL_DELETE_TASK);
            statement.setString(1, id);
            statement.executeUpdate();
        }
        catch (SQLException | NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    //
    public Task getTask (ResultSet resultSet) throws SQLException {
        //return Task.builder().title(resultSet.getString("Title")).build();
        return new Task(resultSet.getInt("Id"), resultSet.getString("Title"), resultSet.getString("Description"));
    }
}
