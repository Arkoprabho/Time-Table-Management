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
    public Location(String name) {
        this.name = "C"+name;
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
        try(PreparedStatement locationStatement = new DatabaseConnection().getCurrentConnection().prepareStatement("INSERT INTO location (RoomHashCode, Name) VALUES (?, ?)")) {
            locationStatement.setInt(1, roomHashCode);
            locationStatement.setString(2, name);
            locationStatement.executeUpdate();
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
