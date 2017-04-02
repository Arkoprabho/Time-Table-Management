
/*!40000 DROP DATABASE IF EXISTS `timetablemanagement`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `timetablemanagement` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `timetablemanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `DepartmentHashCode` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`DepartmentHashCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `Name` varchar(45) NOT NULL,
  `DepartmentCode` int(11) NOT NULL,
  `SubjectCode` varchar(45) NOT NULL,
  `Type` enum('Teacher','LabAssitant','Administration','Research','Others') NOT NULL,
  KEY `DepartmentCode_idx` (`DepartmentCode`),
  KEY `SubjectCode_idx` (`SubjectCode`),
  CONSTRAINT `DepartmentCode` FOREIGN KEY (`DepartmentCode`) REFERENCES `department` (`DepartmentHashCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SubjectCode` FOREIGN KEY (`SubjectCode`) REFERENCES `subjects` (`SubjectCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `RoomHashCode` int(11) NOT NULL,
  `Name` varchar(5) NOT NULL,
  PRIMARY KEY (`RoomHashCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `SubjectCode` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Credit` int(11) NOT NULL,
  PRIMARY KEY (`SubjectCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
