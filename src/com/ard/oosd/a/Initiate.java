/**
 * 
 */
package com.ard.oosd.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Arko
 * Initiates the objects and starts the project.
 */
class Initiate {
    // Variable declaration
    private BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));


    /**
     * Gets the input from the user.
     * @throws IOException
     */
    void input() throws IOException {

	int numberOfSubjects;
	String name;
	List<Subjects> subjectList = new ArrayList<>();

	System.out.print("Enter the name of the professor: ");
	name = inputReader.readLine();
	Professor professor = new Professor(name);
	System.out.print("How many subjects are associated with this:  ");
	numberOfSubjects = Integer.parseInt(inputReader.readLine());

	// Create the list of subject that the professor can teach.
	while(numberOfSubjects-- != 0) {
	    String subName, code;
	    int credit;
	    System.out.print("Subject name: ");
	    subName = inputReader.readLine();
	    System.out.print("Subject code: ");
	    code = inputReader.readLine();
	    System.out.print("Subject credit: ");
	    credit = Integer.parseInt(inputReader.readLine());
	    Subjects subjectToAdd = new Subjects(subName, code, credit);
	}
	
	// Associate the subjects with the professor.
	professor.setAssociatedSubject(subjectList);
    }
}
