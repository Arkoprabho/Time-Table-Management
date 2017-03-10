/*
Checks the last updated time of the database.
*/
SELECT UPDATE_TIME
FROM   information_schema.tables
WHERE  TABLE_SCHEMA = 'timetablemanagement'
       AND TABLE_NAME = 'abc'