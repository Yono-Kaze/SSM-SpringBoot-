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
-- Table structure for table `tb_shop_auth_map`
--

DROP TABLE IF EXISTS `tb_shop_auth_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_shop_auth_map` (
  `shop_auth_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `shop_id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '冗余是为了让shop在查找员工的时候，不需要去连tb_shop表，直接连tb_shop_auth_map就okay',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_flag` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`shop_auth_id`),
  KEY `fk_shop_auth_map_shop` (`shop_id`),
  CONSTRAINT `fk_shop_auth_map_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_shop_auth_map`
--

LOCK TABLES `tb_shop_auth_map` WRITE;
/*!40000 ALTER TABLE `tb_shop_auth_map` DISABLE KEYS */;
INSERT INTO `tb_shop_auth_map` VALUES (13,8,15,'雇员1','店家本人',1,'2017-06-05 22:04:30','2017-06-05 22:04:30',1),(14,8,16,'','店家本人',1,'2017-06-06 08:53:42','2017-06-06 08:53:42',1),(15,8,17,'','店家本人',1,'2017-06-06 09:08:45','2017-06-06 09:08:45',1),(16,8,18,'','店家本人',1,'2017-06-06 09:11:09','2017-06-06 09:11:09',1),(17,8,19,'','店家本人',1,'2017-06-06 09:14:06','2017-06-06 09:14:06',1),(18,8,20,'','店家本人',1,'2017-06-06 09:16:33','2017-06-06 09:16:33',1),(19,8,21,'','店家本人',1,'2017-06-06 09:19:42','2017-06-06 09:19:42',1),(20,8,22,'','店家本人',1,'2017-06-06 09:22:38','2017-06-06 09:22:38',1),(21,8,23,'','店家本人',1,'2017-06-06 09:27:57','2017-06-06 09:27:57',1),(22,8,24,'','店家本人',1,'2017-06-06 09:35:44','2017-06-06 09:35:44',1),(23,8,25,'','店家本人',1,'2017-06-06 09:38:11','2017-06-06 09:38:11',1),(24,8,26,'','店家本人',1,'2017-06-06 09:43:13','2017-06-06 09:43:13',1),(25,8,27,'','店家本人',1,'2017-06-07 15:51:21','2017-06-07 15:51:21',1),(26,9,28,'','店家本人',1,'2017-08-25 00:10:36','2017-08-25 00:10:36',1),(33,8,15,'雇员2','服务员',NULL,'2020-11-04 08:34:24','2020-11-04 08:34:24',1);
/*!40000 ALTER TABLE `tb_shop_auth_map` ENABLE KEYS */;
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
