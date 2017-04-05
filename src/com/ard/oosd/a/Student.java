package com.ard.oosd.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Arko<br>
 * Contains the basic functionalities of a student
 */
class Student {
    // The student can login, view his time table.
    int rollNumber;
    /**
     * Takes the input from the user.
     */
    void input(){
        // TODO needs to be changed when the GUI is fixed
        System.out.print("Input roll number: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            rollNumber = Integer.parseInt(reader.readLine());
            System.out.println(rollNumber);
        }
        catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
