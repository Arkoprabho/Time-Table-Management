/**
 * 
 */
package com.ard.oosd.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Contains details of the professor.
 * @author Arko
 *
 */
class Professor {
    // Private fields
    private String professorName = null;
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

}
