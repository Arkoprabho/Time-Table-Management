/**
 * 
 */
package com.ard.oosd.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author Arko
 * Initiates the objects and starts the project.
 */
class Initiate {
    // Variable declaration
    private BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private ConcurrentHashMap<Professor, HashSet<Subjects>> professorHashMap= new ConcurrentHashMap<>();


    /**
     * Gets the input from the user.
     * @throws IOException
     */
    void input() throws IOException {

	int numberOfSubjects;
	String name;
	HashSet<Subjects> subjectList = new HashSet<>();

	System.out.print("Enter the name of the professor: ");
	name = inputReader.readLine();
	System.out.print("How many subjects are associated with this:  ");
	// HACK: Weird formatting was seen when using only inputReader.read(), Thus this method is used.
	numberOfSubjects = Integer.parseInt(inputReader.readLine());

	// Create the list of subject that the professor can teach.
	while(numberOfSubjects-- != 0) {
	    String subName;
	    int code, credit; 
	    System.out.print("Subject name: ");
	    subName = inputReader.readLine();
	    System.out.print("Subject code: ");
	    code = Integer.parseInt(inputReader.readLine());
	    System.out.print("Subject credit: ");
	    credit = Integer.parseInt(inputReader.readLine());
	    Subjects subjectToAdd = new Subjects(subName, code, credit);
	    if(!Subjects.CheckEquality(subjectToAdd, subjectList)) {
		System.out.println("Error. Try again!");
		numberOfSubjects++;
	    }
	    else
		subjectList.add(subjectToAdd);

	}

	// Associate the subjects with the professor.
	professorHashMap.put(new Professor(name), subjectList);
    }
}
