/**
 * 
 */
package com.ard.oosd.a;

import com.ard.oosd.a.sqlscripts.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains details of the professor.
 * @author Arko
 *
 */
class Professor implements DatabaseEntryInterface {
    // Private fields
    private String professorName = null;
    private String tableName = "faculty";
    private List<Subjects> associatedSubject = new ArrayList<>();
    
    /**
     * Initialize the Professor with the parameters.
     * @param name of the professor
     * @param subjects to add
     */
    Professor(String name, List<Subjects> subjects) {
	    // Set the name of the professors.
	    professorName = name;
	    // Set the associated subjects with the professor.
        setAssociatedSubject(subjects);
        // Write the details to database for fetch later on.
        writeToDatabase();
    }

    /**
     * @return the professorname
     */
    public String getProfessorname() {
	    return professorName;
    }

    /**
     * @return the associatedSubject
     */
    public List<Subjects> getAssociatedSubject() {
	    return associatedSubject;
    }

    /**
     * @param associatedSubject the associatedSubject to set
     */
    public void setAssociatedSubject(List<Subjects> associatedSubject) {
	this.associatedSubject = associatedSubject;
    }

    /**
     * Writes the data about the object to database
     *
     * @return true if write is successful
     */
    @Override
    public boolean writeToDatabase() {
        // INSERT INTO FACULTY (NAME, SUBJECTCODE, TYPE) VALUES (getProfessorname(), , Teacher)
        try (PreparedStatement facultyStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO ? (?, ?, Type) VALUES (?, ?, Teacher)")) {
            facultyStatement.setString(1, this.tableName);
            facultyStatement.setString(2, "Name");
            facultyStatement.setString(3, "SubjectCode");
            facultyStatement.setString(4, this.getProfessorname());
            // Make sure that the subject also exists in the database.
            for (Subjects subject : associatedSubject) {
                // Might throw an exception in case the Subject already exists in the database.
                subject.writeToDatabase();
                facultyStatement.setString(5, subject.getSubjectCode());
            }
            facultyStatement.execute();
        } catch (SQLException e) {
            // In case any of the entries are not executed.
            return false;
        }
        return true;
    }
}
