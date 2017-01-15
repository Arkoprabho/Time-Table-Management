/**
 * 
 */
package com.ard.oosd.a;

/**
 * @author Arko
 * Enumeration that contains the subjects taught.
 */
enum Subjects {
    // TODO the subjects should not be hard-coded.
    CompilerDesign(1001),
    HighPerformanceComputerArchitecture(1002),
    ObjectOrientedSystemDesign(1003),
    ComputerGraphics(1004),
    Economics(2003);
    
    // The value of the enum.
    private int value;
    
    
    /**
     * Initializes the Subject with the given value.
     * @param value
     */
    private Subjects(int value) {
	this.setValue(value);
    }

    /**
     * @return the value associated with the subject
     */
    int getValue() {
	return value;
    }

    /**
     * @param value the value to set
     */
    private void setValue(int value) {
	this.value = value;
    }
}
