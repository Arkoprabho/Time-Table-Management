package com.ard.oosd.a.sqlscripts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Contains methods related to the connection of the database.
 * Created by arko on 10-03-2017.
 */
public class DatabaseConnection {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/timetablemanagement?autoReconnect=true&useSSL=false";
    static String USER = "root";
    static String PASSWORD = "password";
    static String DATABASE = "timetablemanagement";
    public static Connection connection = null;

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
        // Make sure that you have the latest snapshot of the database.
        // Connect to the database.
        connect();
    }

    /**
     * Connect to the database.
     */
    private static void connect() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database!");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
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
