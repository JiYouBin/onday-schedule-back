-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ondayscheduledb
-- ------------------------------------------------------
-- Server version	5.7.40-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_event`
--

DROP TABLE IF EXISTS `t_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(30) NOT NULL,
  `event_color` varchar(10) NOT NULL,
  `event_deleted_yn` varchar(2) DEFAULT 'N',
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `all_day` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_event`
--

LOCK TABLES `t_event` WRITE;
/*!40000 ALTER TABLE `t_event` DISABLE KEYS */;
INSERT INTO `t_event` VALUES (1,'확인','#673ab7','N','2023-04-10 00:00:00','2023-04-18 15:24:00',1),(2,'하루종일','#8bc34a','N','2023-04-20 00:00:00','2023-04-20 23:59:00',1),(3,'하루종일이 아닌거','#2196f3','N','2023-04-25 00:00:00','2023-04-25 20:29:00',1),(4,'날짜 수정','#2196f3','Y','2023-04-19 16:00:00','2023-04-26 18:30:00',0),(5,'','#ff0000','N','2023-04-06 15:00:00','2023-04-12 19:31:00',0),(6,'Test1','#9c27b0','N','2023-04-24 17:51:00','2023-04-26 17:54:00',0),(7,'Test2ㅅㄷㄴㅅ','#ffeb3b','N','2023-05-01 00:00:00','2023-05-02 23:59:00',0),(8,'ㅎ','','N','2023-04-03 00:00:00','2023-04-05 16:17:00',0),(10,'ㅇ','#9c27b0','N','2023-03-31 00:00:00','2023-04-02 17:37:00',0),(11,'ㅋㅋ','#2196f3','N','2023-03-28 00:00:00','2023-03-28 23:59:00',1),(12,'','#cddc39','N','2023-03-30 00:00:00','2023-03-30 23:59:00',1),(13,'색','#009688','N','2023-04-21 00:00:00','2023-04-22 16:50:00',0),(14,'시간 설정','#03a9f4','N','2023-04-27 16:57:00','2023-04-27 23:59:00',1),(15,'테스트지롱','#7bdcb5','N','2023-04-28 00:00:00','2023-04-28 09:13:00',0),(16,'안녕하세여','#03a9f4','N','2023-04-09 00:00:00','2023-04-19 10:46:00',0),(17,'ㅎㅇㅎㅇ','#03a9f4','Y','2023-05-01 10:47:00','2023-05-03 10:47:00',0),(18,'ㅋㅋ','#03a9f4','Y','2023-05-04 00:00:00','2023-05-01 10:47:55',0),(19,'ㅋㅋ','#03a9f4','N','2023-05-03 00:00:00','2023-05-01 11:01:44',0),(20,'안녕','#03a9f4','N','2023-05-04 00:00:00','2023-05-01 11:01:59',0);
/*!40000 ALTER TABLE `t_event` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-01 12:11:53
