package com.ard.oosd.a;

/**
 * Should be implemented by all the classes that have an entry to the database
 * Created by arko on 04-04-2017.
 */
public interface DatabaseEntryInterface {
    /**
     * Writes the data about the object to database
     * @return true if write is successful
     */
    boolean writeToDatabase();
}
