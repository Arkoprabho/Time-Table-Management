package com.ard.oosd.a;

import org.cpsolver.coursett.Test;
/**
 * Created by arko on 03-04-2017.
 */
public class Timetable {
    /**
     * Generates the time table using the cpsolver API
     */
    public void generate() {
        String configPath, inputPath, outputFolderPath;
        configPath = "llr.cfg";
        inputPath = "input.xml";
        outputFolderPath = "./src/output";
        Test.main(new String[] {
                configPath,
                inputPath,
                outputFolderPath
        });
    }
}
