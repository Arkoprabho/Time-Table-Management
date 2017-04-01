package com.ard.oosd.a;

/**
 * @author Arko<br>
 * Contains the basic functionalities of a student
 */
class Student implements PeopleInterface{
    // The student can login, view his time table.
    private int rollNumber;
    TypeOfUser typeOfUser = null;

    /**
     * Initializes the student
     * @param rollNumber the roll number of the student.
     */
    Student(int rollNumber) {
        setRollNumber(rollNumber);
    }

    /**
     * @return the roll number of the student.
     */
    public int getRollNumber() {
        return rollNumber;
    }

    /**
     * Sets the roll number of the student.
     * @param rollNumber the roll number.
     */
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    /**

     * Sets the type of user.
     */
    @Override
    public void setTypeOfUser() {
        typeOfUser = TypeOfUser.Student;
    }

    /**
     * @return the type of user.
     */
    @Override
    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    /**
     * Logs the user into the application
     */
    @Override
    public void login() {
	    // TODO implement the interface methods

    }
}
