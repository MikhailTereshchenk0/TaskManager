package com.taskmanager.dao;

import lombok.Getter;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

@Getter
public class DatabaseConnector implements AutoCloseable{
    private static DatabaseConnector instance;
    private Connection connection;

    private DatabaseConnector() {
        String url = System.getenv("URL");
        String user = System.getenv("user");
        String password = System.getenv("password");
        try {

            Driver driver = new com.mysql.cj.jdbc.Driver();    //no suitable driver found for jdbc:mysql://localhost:3306
            DriverManager.registerDriver(driver);       //

            this.connection = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    @Override
    public void close()  {
        if (Objects.nonNull(connection)){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
