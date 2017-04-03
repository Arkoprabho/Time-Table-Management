/**
 * 
 */
package com.ard.oosd.a;

import java.util.List;

/**
 * Class that holds the subjects associated with a professor.
 * @author Arko
 */
class Subjects {
    // Each subject needs to have a subject code, name and credit.
    int credit;
    String subjectName, subjectCode;

    /**
     * Initializes a new instance of a subject.
     * @param credit
     * @param name
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
}
