package com.ard.oosd.a;

import com.ard.oosd.a.sqlscripts.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by arko on 04-04-2017.
 */
public class Location implements DatabaseEntryInterface {
    private int roomHashCode;
    private String name;

    /**
     * Initializes a new instance of the object
     * @param name name of the location (eg: C13)
     */
    Location(String name) {
        this.name = name;
        roomHashCode = hashCode();
        writeToDatabase();
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    /**
     * Writes the data about the object to database
     *
     * @return true if write is successful
     */
    @Override
    public boolean writeToDatabase() {
        try(PreparedStatement locationStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO ? (?, ?) VALUES (?, ?)")) {
            locationStatement.setString(1, "location");
            locationStatement.setString(2, "RoomHashCode");
            locationStatement.setString(3, "Name");
            locationStatement.setInt(4, roomHashCode);
            locationStatement.setString(5, name);
        } catch (SQLException e) {
            if(e.getErrorCode() == 1062) {
                System.out.println("Location already exists!");
                return true;
            }
            return false;
        }
        return true;
    }
}
