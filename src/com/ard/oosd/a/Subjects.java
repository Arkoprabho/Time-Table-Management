package com.ard.oosd.a;

/**
 * Class that holds the subjects associated with a professor.
 * @author Arko
 */
class Subjects {
    // Each subject needs to have a subject code, name and credit.
<<<<<<< HEAD
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
=======
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
    int getCredit() {
        return credit;
    }

    /**
     * @return the name of the subject associated with the current object.
     */
    String getSubjectName() {
        return subjectName;
>>>>>>> parent of 686b09c... Merge remote-tracking branch 'remotes/origin/master' into Arko
    }

    /**
     * @return the code of the subject associated with the current object.
     */
    String getSubjectCode() {
        return subjectCode;
    }
}
