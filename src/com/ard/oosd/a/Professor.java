/**
 * 
 */
package com.ard.oosd.a;

/**
 * @author Arko
 *
 */
class Professor {
    // Private fields
    private String professorName = null;

    /**
     * Initialize the Professor with the parameters.
     * @param name
     * @param subjects
     */
    Professor(String name) {
	// Set the name of the professors.
	professorName = name;
	// Set the associated subjects with the professor.
    }

    /**
     * @return the professorname
     */
    public String getProfessorname() {
	return professorName;
    }

}
