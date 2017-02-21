/**
 * 
 */
package com.ard.oosd.a;

import java.util.HashSet;

/**
 * @author Arko
 * Class that holds the subjects associated with a professor.
 */
class Subjects {
    // Each subject needs to have a subject code, name and credit.
    int credit, subjectCode;
    String subjectName;
    
    /**
     * Initializes a new instance of a subject.
     * @param credit
     * @param name
     */
    public Subjects(String name, int code, int credit) {
	subjectCode = code;
	this.credit = credit;
	subjectName = name;
    }

    /**
     * Check if the subject has the same code as any other subject in the list.
     * @param subjectToAdd
     * @param subjectList
     * @return
     */
    public static boolean CheckEquality(Subjects subjectToAdd, HashSet<Subjects> subjectList) {
	for (Subjects subjects : subjectList) {
	    if(subjects.equals(subjectToAdd))
		return false;
	}
	return true;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + credit;
	result = prime * result + subjectCode;
	result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	Subjects other = (Subjects) obj;
	if (subjectCode != other.subjectCode)
	    return false;
	return true;
    }
}
