package com.ard.oosd.a.sqlscripts;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Contains methods to execute MySQL scripts from dump files.
 * Created by arko on 10-03-2017.
 */
public class SQLScriptRunner {

    /**
     * Executes the MySQL script
     * @param connection Connection object that is used to connect to the database.
     * @param fileInputStream The script file that needs to be executed.
     * @return ResultSet object that contains the result of the query
     * @throws SQLException Exception that occurs when and if the query is not processed.
     */
    public static void executeSql(Connection connection, FileInputStream fileInputStream) {

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
            // return the result set associated with the statement.
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void lastUpdated(Connection connection, FileInputStream fileInputStream, String tableName, String databaseName) {
        // TODO return the last updated time.

    }
}
