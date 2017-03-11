package com.ard.oosd.a.sqlscripts;

import com.ard.oosd.a.events.ListenerInterface;
import com.ard.oosd.a.events.SourceInterface;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Scanner;

/**
 * Contains methods to execute MySQL scripts from dump files.
 * Created by arko on 10-03-2017.
 */
public class SQLScriptRunner implements SourceInterface{

    /**
     * Executes the MySQL script
     * @param connection Connection object that is used to connect to the database.
     * @param fileInputStream The script file that needs to be executed.
     * @throws SQLException Exception that occurs when and if the query is not processed.
     */
    static void updateSql(Connection connection, FileInputStream fileInputStream) throws SQLException {

        Scanner scanner = new Scanner(fileInputStream);
        // The delimiters a SQL script can have. (Lets keep it to ; only. Still have the others just as a safety net)
        scanner.useDelimiter("(;(\r)?\n)|(--\n)");
        ResultSet resultSet = null;
        try (Statement statement = connection.createStatement()){
            while (scanner.hasNext()) {
                String line = scanner.next();
                // Avoid comments
                if(line.startsWith("/*!") && line.endsWith("*/")) {
                    int i = line.indexOf(' ');
                    line = line.substring(i+1, line.length() - " */".length());
                }
                if(line.trim().length() > 0) {
                    // execute the query.
                    statement.execute(line);
                }
            }
        }
    }

    /**
     * Returns the time when the table in the database was updated/changed
     * @param connection object to connect to the database
     * @param tableName the table to query
     * @param databaseName the database to query
     * @param option Updated/Created
     * @return the time updated/created/invalid option
     * @throws SQLException Exception thrown when the query can not be executed.
     */
    static String changedTime(Connection connection, String tableName, String databaseName, String option) throws SQLException {
        if(option.toLowerCase().matches("created"))
            return createdTime(connection, tableName, databaseName);
        else if (option.toLowerCase().matches("updated"))
            return updatedTime(connection, tableName, databaseName);
        else
            return "INVALID OPTION!";
    }

    /**
     * Returns the last updated time of the table in the database.
     * @param connection object to connect to the database.
     * @param tableName the table to query
     * @param databaseName the database to query
     * @return the last updated time
     * @throws SQLException Exception when query is not executed.
     */
    private static String updatedTime(Connection connection, String tableName, String databaseName) throws SQLException {
        String updatedTime = "NA";
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT UPDATE_TIME FROM information_schema.tables WHERE  TABLE_SCHEMA =? AND TABLE_NAME =?")) {
            preparedStatement.setString(1, databaseName);
            preparedStatement.setString(2, tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                updatedTime = resultSet.getString("UPDATE_TIME");
            }
        }
        return updatedTime;
    }

    /**
     * Returns the creation time of the database table
     * @param connection object to connect to the database.
     * @param tableName the table to query
     * @param databaseName the database to query
     * @return the time of creation
     * @throws SQLException Exception when query is not executed.
     */
    private static String createdTime(Connection connection, String tableName, String databaseName) throws SQLException {
        String createdTime = "NA";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT CREATE_TIME FROM information_schema.tables WHERE  TABLE_SCHEMA =? AND TABLE_NAME =?")) {
            preparedStatement.setString(1, databaseName);
            preparedStatement.setString(2, tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                createdTime = resultSet.getString("CREATE_TIME");
        }
        return createdTime;

    }

    /**
     * Adds a listener to the list
     *
     * @param listener object to add
     */
    @Override
    public void addListener(ListenerInterface listener) {
        _listeners.add(listener);
    }
}
