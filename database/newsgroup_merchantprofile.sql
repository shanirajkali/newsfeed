-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: newsgroup
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `merchantprofile`
--

DROP TABLE IF EXISTS `merchantprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchantprofile` (
  `merchant_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` decimal(10,0) NOT NULL,
  `merchant_type` varchar(20) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `address_line` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `create_time_stamp` datetime DEFAULT NULL,
  `update_time_stamp` datetime DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`merchant_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `merchantprofile_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchantprofile`
--

LOCK TABLES `merchantprofile` WRITE;
/*!40000 ALTER TABLE `merchantprofile` DISABLE KEYS */;
INSERT INTO `merchantprofile` VALUES (29,'Shani rajkali','male','shanirajkali@gmail.com',9897028778,'technical',0,'753 moh tihai mawana','2094-10-04','1KALIhpdlink','2017-03-09 17:09:57','2017-03-09 17:09:57',1),(30,'sandeep kumar','male','gelobmith@gmail.com',9434303020,'local',7,'753 mawana','1994-09-30','1KALIhpdlink','2017-03-14 16:54:24','2017-03-14 16:54:24',1),(31,'anoop','male','anoop@gmail.com',999999999,'health',0,'','2017-03-02','1KALIhpdlink','2017-03-23 02:08:50','2017-03-23 02:08:50',1),(32,'anees','male','mohdanees@gmail.com',9897,'bussiness',0,'','2017-03-09','2017-03-09','2017-03-27 03:02:11','2017-03-27 03:02:11',1),(33,'sdf','male','sdfas',3425,'technical',0,'234','2017-03-10','admin','2017-03-27 03:35:12','2017-03-27 03:35:12',1),(34,'sdfasss','female','sdfasss',234,'bussiness',0,'sdf','2017-03-04','aa','2017-03-27 03:36:44','2017-03-27 03:36:44',1);
/*!40000 ALTER TABLE `merchantprofile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-28 13:31:57
