package com.ard.oosd.a;

import com.ard.oosd.a.sqlscripts.DatabaseConnection;
import com.ard.oosd.r.WindowMain;

import java.awt.*;

/**
 * @author Arko
 * Acts as the starting point of the program.
 */
public class MainClass {


    /**
     * Perform the initial checks before starting the program.
     * Make sure that the program is ready to be executed.
     */
    private void performInitCheck() {
        // TODO perform the required checks.
        /*
        Checks:
        1. Does the necessary databases exist (timetablemanagement)
            1.1 If not create it.
        2. Is the timetable updated? Compare the update time of the table and the dump file.
         */
        new DatabaseConnection();
    }	


    /**
     * Main method. Starting point of the program.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
    	new MainClass().performInitCheck();
		EventQueue.invokeLater(() -> {
	    	try {
		    	new WindowMain().frame.setVisible(true);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	    });
    }
}
