package com.ard.oosd.a.sqlscripts;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains methods to create a dump file of the SQL Schema
 * Created by arko on 11-03-2017.
 */
public class DumpSQL {
    static Logger LOGGER = null;
    FileHandler logFile = null;

    public DumpSQL() {
         LOGGER = Logger.getLogger(Class.class.getName());
        try {
            logFile = new FileHandler("log.log");
            LOGGER.addHandler(logFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the last modified time of the mysqldump file
     */
    private String dumpFileModifiedTime() {
        File file = new File("src/com/ard/oosd/a/sqlscripts/scripts/Time-Table-Management-Dump.sql");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return simpleDateFormat.format(file.lastModified());
    }

    /**
     * Creates a mysqldump of the database.
     * @param userName username of the database.
     * @param password password of the database.
     * @param databaseName name of the database to dump.
     * @throws IOException In case it is unable to execute the command
     * @throws InterruptedException Wait fails
     */
    void backupDatabase(String userName, String password, String databaseName) throws IOException, InterruptedException {
        //NOTE  Make sure mysqldump is added to PATH
        LOGGER.log(Level.FINEST, "Starting backup");
        String[] executeCommand = new String[] {"cmd.exe", "/c", "\"C:/Program Files (x86)/MySQL/MySQL Server 5.7/bin/mysqldump.exe\" -u "+userName+" -p"+password+" "+databaseName+" > src/com/ard/oosd/a/sqlscripts/scripts/Time-Table-Management-Dump.sql"};
        Process process = Runtime.getRuntime().exec(executeCommand);
        if(process.waitFor() == 0) {
            LOGGER.log(Level.INFO, "Backup success!");
            InputStream inputStream = process.getInputStream();
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String out = new String(buffer);
            System.out.println(out);
        }
        else {
            System.out.println(process.waitFor());
            LOGGER.log(Level.SEVERE, "Backup failed!");
            InputStream errorStream = process.getErrorStream();
            byte[] buffer = new byte[errorStream.available()];
            errorStream.read(buffer);
            String out = new String(buffer);
            System.out.println(out);
        }
    }

    /**
     * Restores the database with the help of the dump that was created.
     * @param userName username of the database.
     * @param password password of the database.
     * @throws IOException In case it is unable to execute the command
     * @throws InterruptedException Wait fails
     */
    void restoreDatabase(String userName, String password) throws IOException, InterruptedException {
        String executeCommand = "mysql -u"+userName+"-p"+password+"< Time-Table-Management-Dump.sql";
        Process process = Runtime.getRuntime().exec(executeCommand);
        int processCompletion = process.waitFor();
        if(processCompletion == 0)
            LOGGER.log(Level.INFO, "Restore success!");
        else{
            LOGGER.log(Level.SEVERE, "Restore failed!");
            System.out.println("RESTORE FAILED!");
        }
    }
}
