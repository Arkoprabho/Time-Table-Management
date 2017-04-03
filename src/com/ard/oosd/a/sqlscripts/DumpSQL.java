package com.ard.oosd.a.sqlscripts;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * Contains methods to create a dump file of the SQL Schema
 * Created by arko on 11-03-2017.
 */
class DumpSQL {

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
        //NOTE  Make sure mysql is added to PATH
        String[] executeCommand = new String[] {"cmd.exe", "/c", "\"C:/Program Files (x86)/MySQL/MySQL Server 5.7/bin/mysqldump.exe\" --compact --add-drop-database -u "+userName+" -p"+password+" -B "+databaseName+" > Time-Table-Management-Dump.sql"};
        Process process = Runtime.getRuntime().exec(executeCommand);
        if(process.waitFor() == 0) {
            InputStream inputStream = process.getInputStream();
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String out = new String(buffer);
            System.out.println(out);
        }
        else {
            System.out.println(process.waitFor());
            InputStream errorStream = process.getErrorStream();
            byte[] buffer = new byte[errorStream.available()];
            errorStream.read(buffer);
            String out = new String(buffer);
            System.out.println(out);
        }
    }

    /**
     * Restores the database with the help of the dump that was created.
     */
    void restoreDatabase() {
        try{
            String[] executeCommand = new String[] {
                    "cmd.exe",
                    "/c",
                    "mysql -u"+DatabaseConnection.USER+" -p"+DatabaseConnection.PASSWORD+" -B "+DatabaseConnection.DATABASE+" < \"Time-Table-Management-Dump.sql\""
            };
            Process process = Runtime.getRuntime().exec(executeCommand);
            if(process.waitFor() == 0) {
                InputStream inputStream = process.getInputStream();
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                String out = new String(buffer);
                System.out.println(out);
            }
            else {
                System.out.println(process.waitFor());
                InputStream errorStream = process.getErrorStream();
                byte[] buffer = new byte[errorStream.available()];
                errorStream.read(buffer);
                String out = new String(buffer);
                System.out.println(out);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
