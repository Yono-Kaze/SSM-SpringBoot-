-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: o2odb
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `tb_person_info`
--

DROP TABLE IF EXISTS `tb_person_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_person_info` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `profile_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_flag` int NOT NULL DEFAULT '0',
  `shop_owner_flag` int NOT NULL DEFAULT '0',
  `admin_flag` int NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_person_info`
--

LOCK TABLES `tb_person_info` WRITE;
/*!40000 ALTER TABLE `tb_person_info` DISABLE KEYS */;
INSERT INTO `tb_person_info` VALUES (1,'test',NULL,NULL,'14781710576','wangxinyuan114514@gmail.com','\\upload\\images\\item\\personinfo\\2020102921564534006.png',1,1,0,'2020-10-29 13:56:46','2020-10-29 13:56:46',1),(8,'李翔',NULL,'1',NULL,NULL,'http://wx.qlogo.cn/mmopen/XZumId0qMA815ApfWI2zibDnRMahic6SU0wHib2HgGJj5narL2ymRaI4Kn2Tx2Q8UfkicibvjVicu3De6fDYRMfo0uGW0SGicibxVnJ9/0',1,1,1,'2017-06-04 19:01:09','2017-06-04 19:01:09',1),(9,'龙州一条街客服',NULL,'1',NULL,NULL,'http://wx.qlogo.cn/mmopen/icF4iau8Sj7b0FiakC6ibBoTPmkvLpIX9YhWkNyEIGYfzYyqBiag2M3q2rnxSlXAh95UDHdWgywvEW5bN5FBzFPFazxBzqHTRqNwn/0',1,1,0,'2017-06-04 21:20:43','2017-06-04 21:20:43',1),(10,'king',NULL,'2',NULL,NULL,'http://wx.qlogo.cn/mmopen/XZumId0qMA815ApfWI2zibDLckaAaV6QgcBJP0saJSDTuicZBd35HzPXUebLPSlexCIPJsLs3w6lG0xmwn3EZNicj04dJh4We7C/0',1,1,0,'2017-06-07 01:36:16','2017-06-07 01:36:16',1),(11,'音策',NULL,'2',NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKCWfIBicEwS3U0legxxQd5XFpZibBXVPyz0wphvvtaXqiblzQF2GqE28c7j8FGpuYqBCg1QRJThEzuw/0',1,1,0,'2017-09-18 23:39:38','2017-09-18 23:39:38',1),(12,'x',NULL,NULL,'1478171','e20@qq.com','\\upload\\images\\item\\personinfo\\2020110418515626139.png',1,1,0,'2020-11-04 10:51:56','2020-11-04 10:51:56',1),(13,'c',NULL,NULL,'1478171','cr@qq.com','\\upload\\images\\item\\personinfo\\2020110418522694217.png',1,1,0,'2020-11-04 10:52:26','2020-11-04 10:52:26',1);
/*!40000 ALTER TABLE `tb_person_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-06 18:29:40
