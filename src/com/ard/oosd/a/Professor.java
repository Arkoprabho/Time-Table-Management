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
public class Professor implements DatabaseEntryInterface {
    // Private fields
    private String professorName = null;
    private String tableName = "faculty";
    private List<Subjects> associatedSubject = new ArrayList<>();
    
    /**
     * Initialize the Professor with the parameters.
     * @param name of the professor
     * @param subjects to add
     */
    public Professor(String name, List<Subjects> subjects) {
	    // Set the name of the professors.
	    professorName = name;
	    // Set the associated subjects with the professor.
        setAssociatedSubject(subjects);
        // Write the details to database for fetch later on.
        new Thread(() -> writeToDatabase()).start();
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
        try (PreparedStatement facultyStatement = new DatabaseConnection().getCurrentConnection().prepareStatement("INSERT INTO faculty SET Name = ?, SubjectCode = (SELECT subjects.SubjectCode from subjects where subjects.SubjectCode = ?)")) {
            facultyStatement.setString(1, this.getProfessorname());


            // Make sure that the subject also exists in the database.
            for (Subjects subject : associatedSubject) {
                if(subject.writeToDatabase()) {
                    facultyStatement.setString(2, subject.getSubjectCode());
                    facultyStatement.toString();
                    facultyStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            // In case any of the entries are not executed.
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
