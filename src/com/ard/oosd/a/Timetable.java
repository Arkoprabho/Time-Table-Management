package com.ard.oosd.a;

import org.cpsolver.coursett.Test;

/**
 * Contains methods to generate time table
 * Created by arko on 03-04-2017.
 */
public class Timetable implements Runnable {
    /**
     * Generates the time table using the cpsolver API
     */
    public void generate() {
        String configPath, inputPath, outputFolderPath;
        configPath = "src/llr.cfg";
        inputPath = "src/input.xml";
        outputFolderPath = "./src/output";
        Test.main(new String[] {
                configPath,
                inputPath,
                outputFolderPath
        });
    }

    @Override
    public void run() {
        generate();
    }
}
