package com.ard.oosd.a;

import org.cpsolver.ifs.example.tt.TimetableModel;

/**
 * Contains methods to generate the time table and add it to the database.
 */
public class Timetable {

    /**
     * Generates the time table with the constraints.
     * @param pathToXMLFile the path to the XML file that contains details of the constraints
     */
    void generateTimeTable(String pathToXMLFile) {
        TimetableModel.main(new String[] {
                pathToXMLFile,
                "src/generatedTimeTable.xml"
        });
    }
}
