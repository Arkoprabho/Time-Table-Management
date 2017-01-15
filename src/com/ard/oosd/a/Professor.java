/**
 * 
 */
package com.ard.oosd.a;

import java.util.ArrayList;


/**
 * @author Arko
 *
 */
class Professor {
    // Private fields
    private String professorname = null;
    private ArrayList<Subjects> associatedSubjects = null;
    
    /**
     * Initialize the Professor with the parameters.
     * @param name
     * @param subjects
     */
    Professor(String name, ArrayList<Subjects> subjects) {
	// Set the name of the professors.
	professorname = name;
	associatedSubjects = subjects;
    }

    /**
     * @return the professor's name
     */
    String getProfessorname() {
	return professorname;
    }

    /**
     * @return the associated subjects
     */
    ArrayList<Subjects> getAssociatedSubjects() {
	return associatedSubjects;
    }
}
