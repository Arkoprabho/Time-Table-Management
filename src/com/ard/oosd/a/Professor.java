package com.ard.oosd.a;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains details of the professor.
 * @author Arko
 *
 */
class Professor implements PeopleInterface{
    // Private fields
    private String professorName = null;
    private List<Subjects> associatedSubject = new ArrayList<>();
    private TypeOfUser typeOfUser = null;
    
    /**
     * Initialize the Professor with the parameters.\n
     * @param name name of the professor.
     */
    Professor(String name) {
	    // Set the name of the professors.
	    professorName = name;
	    // Set the associated subjects with the professor.
    }

    /**
     * @return the professorname
     */
    String getProfessorname() {
	    return professorName;
    }

    /**
     * @return the associatedSubject
     */
    List<Subjects> getAssociatedSubject() {
	    return associatedSubject;
    }

    /**
     * @param associatedSubject the associatedSubject to set
     */
    public void setAssociatedSubject(List<Subjects> associatedSubject) {
	    this.associatedSubject = associatedSubject;
    }

    /**
     * Sets the type of user.
     */
    @Override
    public void setTypeOfUser() {
        typeOfUser = TypeOfUser.Teacher;
    }

    /**
     * @return the type of user.
     */
    @Override
    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    /**
     * Logs the user into the applciation.
     */
    @Override
    public void login() {

    }
}
