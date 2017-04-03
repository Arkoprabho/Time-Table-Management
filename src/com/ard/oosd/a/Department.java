/**
 * 
 */
package com.ard.oosd.a;

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
    
    private String name;

    /**
     * Initializes a new instance of Department.
     * @param name
     * @param professors
     */
    public Department(String name, ArrayList<Professor> professors) {
	this.name = name;
	this.professors = professors;
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
    
    
}
