package com.ard.oosd.a.sqlscripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Contains methods related to the connection of the database.
 * Created by arko on 10-03-2017.
 */
public class DatabaseConnection {
    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost:3306/timetablemanagement?autoReconnect=true";
    private String USER = "root";
    private String PASSWORD = "password";
    public static String DATABASE = "timetablemanagement";
    private Connection connection = null;

    /**
     * Initialize the connection to the database
     */
    public DatabaseConnection() {
        connect();
    }

    /**
     * Connects to the database
     * @return the connection object.
     */
    public Connection getCurrentConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * Connect to the database.
     */
    private void connect() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database!");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
