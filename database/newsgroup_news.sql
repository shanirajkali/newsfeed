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
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `heading` varchar(100) NOT NULL,
  `description` varchar(400) DEFAULT NULL,
  `news_type` varchar(15) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `merchant_id` int(11) DEFAULT NULL,
  `active_status` int(11) NOT NULL,
  PRIMARY KEY (`news_id`),
  KEY `merchant_id` (`merchant_id`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`merchant_id`) REFERENCES `merchantprofile` (`merchant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (14,'Samsung Galaxy Tab S3 to cost $600 in US','','technical','2017-03-14 14:35:15','2017-03-14 14:35:15',29,1),(15,'LG Fortune launched with quad-core CPU, 5-inch display','','technical','2017-03-14 14:35:46','2017-03-14 14:35:46',29,1),(16,'Sony Xperia XZs goes up for pre-order in Europe, free speaker included as well','','technical','2017-03-14 14:36:03','2017-03-14 14:36:03',29,1),(18,'New SwiftKey for Android update brings keypress soundsNew SwiftKey for Android update brings k','','technical','2017-03-14 14:36:33','2017-03-14 14:36:33',29,1),(19,'Original Huawei Watch to get Android Wear 2.0 by the end of MarchOriginal Huawei Watch to get ','','technical','2017-03-14 14:36:43','2017-03-14 14:36:43',29,1),(20,'Next LeEco flagship smartphone purportedly leaks showing curved displayNext LeEco flagship sma','','technical','2017-03-14 14:36:52','2017-03-14 14:36:52',29,1),(21,'Apples latest iPhone 7 ad is all about iMessage stickersApples late','','technical','2017-03-14 14:38:22','2017-03-14 14:38:22',29,1),(22,'Xiaomi Redmi Pro 2 to sport MediaTeks Helio P25 SoC, not the Snapdragon 660Xiaomi Redmi Pro 2','','technical','2017-03-14 14:38:55','2017-03-14 14:38:55',29,1),(23,'Samsung promises monthly security updates for unlocked units sold in the USSamsung promises mo','','technical','2017-03-14 14:39:07','2017-03-14 14:39:07',29,1),(24,'Unlocked Sony Xperia X is now just $269.99Unlocked Sony Xperia X is now just $269.99','','technical','2017-03-14 14:39:19','2017-03-14 14:39:19',29,1),(25,'Sense Companion app for the HTC U Ultra is now available in the Play StoreSense Companion app ','','technical','2017-03-14 14:39:28','2017-03-14 14:39:28',29,1),(26,'nubia Z17 mini said to be the ZTE handset with dual rear cameras launching on March 21nubia Z1','','technical','2017-03-14 14:39:41','2017-03-14 14:39:41',29,1),(27,'LG G6 will cost â‚¬749 in Europe when it goes on sale in late AprilLG G6 will cost â‚¬749 in Europ','','technical','2017-03-14 14:39:52','2017-03-14 14:39:52',29,1),(28,'Samsung is kicking off the  Galaxy S8 ad campaign in KoreaSamsung is kicking off the Galaxy S8','','technical','2017-03-14 14:40:04','2017-03-14 14:40:04',29,1),(29,'Vertu sells its business for Â£50MVertu sells its business for Â£50M','','technical','2017-03-14 14:40:15','2017-03-14 14:40:15',29,1),(30,'Samsung Galaxy S8 gets certified by 3C in ChinaSamsung Galaxy S8 gets certified by 3C in China','','technical','2017-03-14 14:40:30','2017-03-14 14:40:30',29,1),(31,'ZTE Nubia phone with Dual Camera to be announced on March 21ZTE Nubia phone with Dual Camera t','','technical','2017-03-14 14:40:41','2017-03-14 14:40:41',29,1),(32,'New leak shows the Samsung Galaxy S8 and S8+ side by sideNew leak shows the Samsung Galaxy S8 ','','technical','2017-03-14 14:40:50','2017-03-14 14:40:50',29,1),(33,'Xiaomi Redmi Note 4 with 4 GB RAM coming tomorrowXiaomi Redmi Note 4 with 4 GB RAM coming tomo','','technical','2017-03-14 14:41:04','2017-03-14 14:41:04',29,1),(34,'Future Nokias may have Carl Zeiss optics, but HMD is playing coyFuture Nokias may have Carl Ze','','technical','2017-03-14 14:41:29','2017-03-14 14:41:29',29,1),(35,'Future Nokias may have Carl Zeiss optics, but HMD is playing coyFuture Nokias may have Carl Ze','','technical','2017-03-14 14:41:36','2017-03-14 14:41:36',29,1),(36,'ZTE Blade V8 Pro gets its first software update','','technical','2017-03-14 14:41:59','2017-03-14 14:41:59',29,1),(37,'Xiaomi Redmi Note 4 with 4 GB RAM coming tomorrowXiaomi Redmi Note 4 with 4 GB RAM coming tomo','','technical','2017-03-14 14:43:54','2017-03-14 14:43:54',29,1),(38,'ZTE Blade V8 Pro gets its first software updateZTE Blade V8 Pro gets its first software update','','technical','2017-03-14 14:44:10','2017-03-14 14:44:10',29,1),(39,'Green Oppo R9s spotted, said to be coming this monthGreen Oppo R9s spotted, said to be coming ','','technical','2017-03-14 14:44:18','2017-03-14 14:44:18',29,1),(40,'Xiaomi Redmi Pro 2 tipped to come this monthXiaomi Redmi Pro 2 tipped to come this month','','technical','2017-03-14 14:44:29','2017-03-14 14:44:29',29,1),(41,'Sony Xperia XA1 European launch set for April 10','','technical','2017-03-14 14:44:52','2017-03-14 14:44:52',29,1),(42,'Samsung Galaxy Note5, Note 4, and S5 Active on AT&T getting new security updateSamsung Galaxy ','','technical','2017-03-14 14:45:03','2017-03-14 14:45:03',29,1),(43,'hi welcome to freshheap','get your city news ','local','2017-03-14 16:57:46','2017-03-14 16:57:46',30,1),(44,'hi there','i m on newsheap','local','2017-03-15 10:08:23','2017-03-15 10:08:23',30,1),(45,'hello mawana','i m on newsheap','local','2017-03-15 10:13:19','2017-03-15 10:13:19',30,1),(49,'Gc unveils the Connect smartwatch, dont confuse it with Guess Connect','American fashion brand Guess unveiled a pair of smartwatches and now its Swiss arm is doing the same. Gc crafts luxury Swiss watches and that sets its Connect watch apart from Guess Connect watch.That said, the two share a lot of similarities. The design is based on Gc Structura series of analog watches.','technical','2017-03-21 17:26:26','2017-03-21 17:26:26',29,1),(50,'Risky surgery separates 10-month-old from parasitic twin.','Swabb saw a photo of baby Dominique on her mother lap. That photo really captured my heart Swabb said. She looked so sweet.The nonprofit has asked CNN not to include Dominique last name for privacy reasons.','health','2017-03-23 02:16:14','2017-03-23 02:16:14',31,1),(51,'The psychology of privacy in the era of the Internet of Things','purportedly from the CIA, claimed that the agency can hack smart TVs and place them in fake-off mode, allowing an owners private conversations to be recorded and sent to a covert server.','health','2017-03-23 02:18:00','2017-03-23 02:18:00',31,1),(52,'What doctors think about the Affordable Care Act','He spends his 14-hour days moving quickly between the waiting room Hi, I m Brian, nice to meet you the operating room We all good here?-- and the recovery area, where a typical conversation might involve telling his elderly patient she is beautiful while giving her daughter a high five.','health','2017-03-23 02:19:36','2017-03-23 02:19:36',31,1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-28 13:31:58
