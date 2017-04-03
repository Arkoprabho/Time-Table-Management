package com.ard.oosd.a;

import org.cpsolver.coursett.Test;
/**
 * Created by arko on 03-04-2017.
 */
public class Timetable {
    /**
     * Generates the time table using the cpsolver API
     * @param configPath
     * @param inputPath
     * @param outputFolderPath
     */
    void generate(String configPath, String inputPath, String outputFolderPath) {
        Test.main(new String[] {
                configPath,
                inputPath,
                outputFolderPath
        });
    }
}
