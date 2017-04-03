package com.ard.oosd.a;

import com.ard.oosd.a.sqlscripts.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arko
 * Defines the department of the branch.
 */
class Department {
    /**
     * List of professorArrayList associated with the department.
     */
    private List<Professor> professorArrayList = new ArrayList<>();

    private String name;

    /**
     * Initializes a new instance of Department.
     * @param name name of the department
     * @param professors list of professorArrayList associated with this department.
     */
    public Department(String name, ArrayList<Professor> professors) {
	    this.name = name;
	    this.professorArrayList = professors;

	    writeToDatabase();
    }

    /**
     * Writes the details of the department to database.
     */
    private void writeToDatabase() {
        PreparedStatement databasePreparedStatement = null;
        try  {
            databasePreparedStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO timetablemanagement.department (DepartmentHashCode, Name) VALUES (?, ?)");
            // Set the values.
            // This is for the department.
            databasePreparedStatement.setInt(1, this.hashCode());
            databasePreparedStatement.setString(2, getName());
            // Execute.
            databasePreparedStatement.execute();
            // Got to update the faculty table as well.
            for (Professor professor : professorArrayList) {
                // This is for the faculty
                databasePreparedStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO timetablemanagement.faculty (Name, DepartmentCode, Type, SubjectCode) VALUES (?, ?, 'Teacher', ?)");
                // Got to update the subject table as well.
                for (Subjects subject : professor.getAssociatedSubject()) {
                    try(PreparedStatement subjectStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO timetablemanagement.subjects (SubjectCode, Name, Credit) VALUES (?, ?, ?)")) {
                        // Set the subject query
                        // This is for the subject.
                        subjectStatement.setString(1, subject.getSubjectCode());
                        subjectStatement.setString(2, subject.getSubjectName());
                        subjectStatement.setInt(3, subject.getCredit());

                        // Set the professor query.
                        databasePreparedStatement.setString(1, professor.getProfessorname());
                        databasePreparedStatement.setInt(2, this.hashCode());
                        databasePreparedStatement.setString(3, subject.getSubjectCode());

                        // Execute the 2 queries.
                        // There will be a new entry in the faculty table for each subject that he/she teaches.
                        databasePreparedStatement.execute();
                        subjectStatement.execute();
                    }
                    catch (SQLException e) {
                        if(e.getErrorCode() == 1062)
                            System.out.println("Subject code already exists!" +subject.getSubjectCode());
                        else
                            e.printStackTrace();
                    }
                }
            }

        } catch (SQLException e) {
            if(e.getErrorCode() == 1062)
                System.out.println("Department already exists. Kindly check/rename!");
            else
                e.printStackTrace();
        }
        finally {
            try {
                if (databasePreparedStatement != null)
                    databasePreparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return the name of department
     */
    private String getName() {
	    return name;
    }

    /**
     * @return the professorArrayList associated.
     */
    public List<Professor> getProfessorArrayList() {
        try {
            Statement professorStatement = DatabaseConnection.connection.createStatement();
            // Select all the professors that have the department code as that of this object.
            ResultSet professorResultSet = professorStatement.executeQuery("SELECT Name FROM timetablemanagement.faculty WHERE DepartmentCode ="+this.hashCode());
            while (professorResultSet.next()) {
                professorArrayList.add(new Professor(professorResultSet.getString("Name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professorArrayList;
    }

    /**
     * Acts as the department code for the current department.
     * @return the hash code of the department.
     */
    @Override
    public int hashCode() {
        return (92 * 29 + (this.name != null ? this.name.toLowerCase().hashCode() : 0));
    }

    @Override
    public boolean equals(Object o) {
        if(getClass() != o.getClass())
            return false;
        Department other = (Department) o;
        return other.hashCode() == this.hashCode();
    }
}
