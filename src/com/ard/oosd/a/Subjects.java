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
class Subjects implements DatabaseEntryInterface {
    // Each subject needs to have a subject code, name and credit.
    private int credit;
    private String subjectName, subjectCode;

    /**
     * Initializes a new instance of a subject.
     * @param code subject code
     * @param credit credit of the subject
     * @param name name of the subject
     */
    public Subjects(String name, String code, int credit) {
        subjectCode = code;
        this.credit = credit;
        subjectName = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + credit;
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
        try(PreparedStatement studentStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO ? (?, ?, ?) VALUES (?, ?, ?)")) {

            studentStatement.setString(1, "subjects");
            studentStatement.setString(2, this.getSubjectCode());
            studentStatement.setString(3, this.getSubjectName());
            studentStatement.setInt(4, this.getCredit());

            studentStatement.execute();
        } catch (SQLException e) {
            if(e.getErrorCode() == 1062) {
                System.out.println("Subject code already exists!");
                return true;
            }
            return false;
        }
        return true;
    }

    /**
     * @return the credit of the subject
     */
    private int getCredit() {
        return credit;
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
