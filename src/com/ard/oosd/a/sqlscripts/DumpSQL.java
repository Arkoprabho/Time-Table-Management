package com.ard.oosd.a.sqlscripts;

import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;

/**
 * Contains methods to create a dump file of the SQL Schema
 * Created by arko on 11-03-2017.
 */
public class DumpSQL {

    /**
     * @return the last modified time of the mysqldump file
     */
    private String dumpFileModifiedTime() {
        File file = new File("src/com/ard/oosd/a/sqlscripts/scripts/Time-Table-Management-Dump.sql");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return simpleDateFormat.format(file.lastModified());
    }

    void updateDump(Connection connection) {

    }
}
