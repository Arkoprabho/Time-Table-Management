package com.ard.oosd.a;

import org.cpsolver.coursett.Test;
/**
 * Contains methods to generate the time table and add it to the database.
 */
public class Timetable {

    /**
     * Generates the time table with the constraints.
     * @param pathToOutputFolder the path to the output folder where the final soluction will reside.
     * @param pathToXMLFile the path to the XML file that contains details of the constraints
     */
    void generateTimeTable(String pathToXMLFile, String pathToOutputFolder) {
        Test.main(new String[] {
                pathToXMLFile,
                pathToOutputFolder
        });
    }
}
