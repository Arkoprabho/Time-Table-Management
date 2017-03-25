package com.ard.oosd.a;

import java.util.List;
import java.util.Objects;

/**
 * Class that holds the subjects associated with a professor.
 * @author Arko
 */
class Subjects {
    // Each subject needs to have a subject code, name and credit.
    private int credit;
    private String subjectName, subjectCode;

	/**
	 * * Initializes a new instance of a subject.\m
	 * @param credit credit associated with the subject.
	 * @param name name of the subject.
	 * @param code subject code.
	 */
    public Subjects(String name, String code, int credit) {
		subjectCode = code;
		this.credit = credit;
		subjectName = name;
    }

    /**
     * Check if the subject has the same code as any other subject in the list.
     * @param subjectList the list of subjects.
     * @return checks if the subject already exists in the list.
     */
    public boolean CheckEquality(List<Subjects> subjectList) {
        for (Subjects subjects : subjectList) {
            if(subjects.equals(this))
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + credit;
        result = prime * result + subjectCode.hashCode();
        result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        Subjects other = (Subjects) obj;
        return Objects.equals(subjectCode, other.subjectCode);
    }
}
