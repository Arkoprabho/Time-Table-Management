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
    String name = null;
    ArrayList<Subjects> subjectsAssociated = null;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    List<Professor> professorList = new ArrayList<>();
    
    /**
     * Gets the input from the user.
     * @throws IOException
     */
    void input() throws IOException {
	
	subjectsAssociated = new ArrayList<Subjects>(3);
	System.out.print("Enter the name of the professor: ");
	name = input.readLine();
	
	System.out.println("Here is the coding of the subjects: ");
	
	// Display the subjects so that the user can enter the correct code.
	for(Subjects s : Subjects.values()) {
	    System.out.println("Subject name: "+s+"Subject code: "+s.getValue());
	}
	System.out.print("Enter the codes of the subjects he is associated with(3): ");
	
	// Get the code from the user and feed it to the subject associated list.
	// TODO: if the code doest not match then it is completely ignored. This behaviour needs to be fixed, so that on entering a wrong code, it should throw an error and let the user enter it again.
	for (int i = 0; i < 3; i++) {
	    int subCode = Integer.parseInt(input.readLine());
	    for(Subjects s : Subjects.values()) {
		if(subCode == s.getValue()){
		    subjectsAssociated.add(s);
		}
	    }
	}
	// Add the details to a list of professor.
	professorList.add(new Professor(name, subjectsAssociated));
    }
    
    /**
     * Displays the output to standard output console.
     */
    void output() {
	// Display the list of the professor and its associated subjects.
	for (Professor professor : professorList) {
	    System.out.println("Professor name: "+professor.getProfessorname());
	    System.out.println("Subjects associated: ");
	    for (Subjects s: professor.getAssociatedSubjects()) {
		System.out.println(s.toString());
	    }
	}
	// Enter an extra line for aesthetics sake.
	System.out.println();
    }
}
