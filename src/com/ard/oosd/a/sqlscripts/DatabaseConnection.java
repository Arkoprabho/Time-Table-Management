package com.ard.oosd.a.sqlscripts;

import com.ard.oosd.a.events.ListenerInterface;
import com.ard.oosd.a.events.SourceInterface;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * Contains methods related to the connection of the database.
 * Created by arko on 10-03-2017.
 */
public class DatabaseConnection implements SourceInterface {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/timetablemanagement?autoReconnect=true&useSSL=false";
    private static String USER = "root";
    private static String PASSWORD = "password";

    /**
     * Initialize the connection to the database
     */
    public DatabaseConnection() {
        // Database details.
        System.out.println("Establishing connection!");
        System.out.println("Current details!");
        System.out.println("JDBC Driver: " + JDBC_DRIVER);
        System.out.println("Database URL: " + DB_URL);
        System.out.println("Username: " + USER);
        System.out.println("Password: " + PASSWORD);
        System.out.print("Do you want to change any of the above details?(1.Yes\t2.No): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1) {
            // Make sure that all the variables are correct.
            changeVariable(scanner);
        }
        // Connect to the database.
        connect();
    }

    /**
     * Connect to the database.
     */
    private void connect() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database!");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return the last modified time of the mysqldump file
     */
    private String dumpFileModifiedTime() {
        File file = new File("src/com/ard/oosd/a/sqlscripts/scripts/Time-Table-Management-Dump.sql");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return simpleDateFormat.format(file.lastModified());
    }

    /**
     * Checks if the update time is older than the dump time.
     * @param updateTime time of updation of DB
     * @param dumpTime time of dump of DB
     * @return true if dump is older than updated time.
     */
    private boolean isDumpOld(Date updateTime, Date dumpTime) {
        return updateTime.after(dumpTime);
    }

    /**
     * Change the variables that are different for the system.
     * @param scanner Object to take input
     */
    private void changeVariable(Scanner scanner) {
        int choice;
        int flag = 1;
        System.out.println("What would you like to change");
        while(flag == 1){
            System.out.println("1.JDBC Driver\n2.Database URL\n3.Username\n4.Password\n5.Break");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new JDBC Driver: ");
                    JDBC_DRIVER = scanner.next();
                    break;
                case 2:
                    System.out.println("Enter new Database URL: ");
                    DB_URL = scanner.next();
                    break;
                case 3:
                    System.out.println("Enter new username: ");
                    USER = scanner.next();
                    break;
                case 4:
                    System.out.println("Enter new PASSWORD: ");
                    PASSWORD = scanner.next();
                    break;
                case 5:
                    System.out.println("Press 0 to stop changing!");
                    flag = scanner.nextInt();
                    break;
            }
        }
    }
}
