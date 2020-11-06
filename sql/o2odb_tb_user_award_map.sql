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
-- Table structure for table `tb_user_award_map`
--

DROP TABLE IF EXISTS `tb_user_award_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_award_map` (
  `user_award_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `award_id` int NOT NULL,
  `shop_id` int NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `award_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `expire_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `used_status` int NOT NULL DEFAULT '0',
  `point` int DEFAULT NULL,
  PRIMARY KEY (`user_award_id`),
  KEY `fk_user_award_map_profile` (`user_id`),
  KEY `fk_user_award_map_award` (`award_id`),
  KEY `fk_user_award_map_shop` (`shop_id`),
  CONSTRAINT `fk_user_award_map_award` FOREIGN KEY (`award_id`) REFERENCES `tb_award` (`award_id`),
  CONSTRAINT `fk_user_award_map_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`),
  CONSTRAINT `fk_user_award_map_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_award_map`
--

LOCK TABLES `tb_user_award_map` WRITE;
/*!40000 ALTER TABLE `tb_user_award_map` DISABLE KEYS */;
INSERT INTO `tb_user_award_map` VALUES (1,8,1,1,'顾客1','奖品1','2020-10-30 09:17:39','2020-10-30 09:17:39',1,2),(2,1,11,1,'顾客2','奖品2','2020-10-30 09:17:39','2020-10-30 09:17:39',1,3),(3,1,2,15,'test','奖品2',NULL,'2020-11-04 06:26:03',1,20),(4,1,1,15,'test','奖品1',NULL,'2020-11-04 06:31:19',1,1),(5,1,2,15,'test','奖品2',NULL,'2020-11-04 07:33:28',1,20),(6,1,2,15,'test','奖品2',NULL,'2020-11-04 07:33:31',1,20),(7,1,1,15,'test','奖品1',NULL,'2020-11-04 07:33:32',1,1),(8,1,1,15,'test','奖品1',NULL,'2020-11-04 08:33:36',1,1),(9,1,1,15,'test','奖品1',NULL,'2020-11-04 08:33:46',1,1),(10,1,1,15,'test','奖品1',NULL,'2020-11-04 08:33:47',1,1),(11,8,1,15,'李翔','奖品1',NULL,'2020-11-04 08:44:02',1,1),(12,8,1,15,'李翔','奖品1',NULL,'2020-11-04 08:44:02',1,1),(13,8,1,15,'李翔','奖品1',NULL,'2020-11-04 08:44:02',1,1),(14,8,1,15,'李翔','奖品1',NULL,'2020-11-04 08:44:03',1,1),(15,8,1,15,'李翔','奖品1',NULL,'2020-11-04 08:44:03',1,1),(16,8,1,15,'李翔','奖品1',NULL,'2020-11-04 08:44:03',1,1),(17,8,1,15,'李翔','奖品1',NULL,'2020-11-04 08:44:03',1,1),(18,8,2,15,'李翔','奖品2',NULL,'2020-11-04 08:44:04',1,20),(19,8,2,15,'李翔','奖品2',NULL,'2020-11-04 08:44:04',1,20),(20,1,2,15,'test','奖品2',NULL,'2020-11-04 11:00:10',1,20),(21,1,2,15,'test','奖品2',NULL,'2020-11-04 11:00:11',1,20);
/*!40000 ALTER TABLE `tb_user_award_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-06 18:29:37
