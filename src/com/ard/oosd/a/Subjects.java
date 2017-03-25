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
     * @return the credit of the subject associated with the current object.
     */
    public int getCredit() {
        return credit;
    }

    /**
     * @return the name of the subject associated with the current object.
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @return the code of the subject associated with the current object.
     */
    public String getSubjectCode() {
        return subjectCode;
    }
}
