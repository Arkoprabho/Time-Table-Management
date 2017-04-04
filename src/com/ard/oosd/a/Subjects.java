/**
 * 
 */
package com.ard.oosd.a;

import com.ard.oosd.a.sqlscripts.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class that holds the subjects associated with a professor.
 * @author Arko
 */
public class Subjects implements DatabaseEntryInterface {
    // Each subject needs to have a subject code, name and credit.
    private String subjectName, subjectCode;

    /**
     * Initializes a new instance of a subject.
     * @param code subject code
     * @param name name of the subject
     */
    public Subjects(String name, String code) {
        subjectCode = code;
        subjectName = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
		Subjects other = (Subjects) obj;
		return subjectCode == other.subjectCode;
	}

    /**
     * Writes the data about the object to database
     *
     * @return true if write is successful
     */
    @Override
    public boolean writeToDatabase() {
        try(PreparedStatement studentStatement = new DatabaseConnection().getCurrentConnection().prepareStatement("INSERT INTO subjects (SubjectCode, Name) VALUES (?, ?)")) {
            studentStatement.setString(1, this.getSubjectCode());
            studentStatement.setString(2, this.getSubjectName());

            System.out.println(studentStatement.toString());
            studentStatement.executeUpdate();
        } catch (SQLException e) {
            if(e.getErrorCode() == 1062) {
                System.out.println("Subject code already exists!");
                return true;
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * @return the name of the subject
     */
    private String getSubjectName() {
        return subjectName;
    }

    /**
     * @return SubjectCode
     */
    String getSubjectCode() {
        return subjectCode;
    }
}
