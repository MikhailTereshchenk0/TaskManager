package com.taskmanager.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DatabaseConnector implements AutoCloseable{
    private static DatabaseConnector instance;
    private Connection connection;

    private DatabaseConnector() {
        try {
            Properties properties = new Properties();
            try (InputStream in = Files.newInputStream(Paths.get("/src/main/resources/config_db.properties"))) {
                properties.load(in);
            }
            String URL = properties.getProperty("URL");

            this.connection = DriverManager.getConnection(URL, properties);
        }
        catch(SQLException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
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
