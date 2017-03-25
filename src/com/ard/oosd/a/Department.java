package com.ard.oosd.a;

import com.ard.oosd.a.sqlscripts.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arko
 * Defines the department of the branch.
 */
class Department {
    /**
     * List of professors associated with the department.
     */
    private List<Professor> professors = new ArrayList<>();
    private List<Department> existingDepartments = new ArrayList<>();

    private String name;

    /**
     * Initializes a new instance of Department.
     * @param name name of the department
     * @param professors list of professors associated with this department.
     */
    public Department(String name, ArrayList<Professor> professors) {
        loadDepartmentList();
	    this.name = name;
	    this.professors = professors;
	    writeToDatabase();
    }

    /**
     * Loads the details of the department from database.
     */
    private void loadDepartmentList() {
        // TODO implement this.
    }

    /**
     * Writes the details of the department to database.
     */
    private void writeToDatabase() {
        try  {
            PreparedStatement preparedStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO timetablemanagement.department (DepartmentHashCode, Name) VALUES (?, ?)");
            // Set the values.
            // This is for the department.
            preparedStatement.setInt(1, this.hashCode());
            preparedStatement.setString(2, getName());
            // Execute.
            preparedStatement.execute();
            // Got to update the faculty table as well.
            for (Professor professor : professors) {
                // This is for the faculty
                preparedStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO timetablemanagement.faculty (Name, DepartmentCode, Type, SubjectCode) VALUES (?, ?, 'Teacher', ?)");
                for (Subjects subject : professor.getAssociatedSubject()) {
                    try(PreparedStatement subjectStatement = DatabaseConnection.connection.prepareStatement("INSERT INTO timetablemanagement.subjects (SubjectCode, Name, Credit) VALUES (?, ?, ?)")) {
                        // Set the subject query
                        // This is for the subject.
                        subjectStatement.setString(1, subject.getSubjectCode());
                        subjectStatement.setString(2, subject.getSubjectName());
                        subjectStatement.setInt(3, subject.getCredit());

                        // Set the professor query.
                        preparedStatement.setString(1, professor.getProfessorname());
                        preparedStatement.setInt(2, this.hashCode());
                        preparedStatement.setString(3, subject.getSubjectCode());
                        // Execute the 2 queries.
                        // There will be a new entry in the faculty table for each subject that he/she teaches.
                        preparedStatement.execute();
                        subjectStatement.execute();
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the name of department
     */
    public String getName() {
	    return name;
    }

    /**
     * @return the professors associated.
     */
    public List<Professor> getProfessors() {
	    return professors;
    }

    @Override
    public int hashCode() {
        return (92 * 29 + (this.name != null ? this.name.toLowerCase().hashCode() : 0));
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        Department other = (Department) o;
        return other.hashCode() == this.hashCode();
    }
}
