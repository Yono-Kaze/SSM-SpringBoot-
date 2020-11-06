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
-- Table structure for table `tb_user_product_map`
--

DROP TABLE IF EXISTS `tb_user_product_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_product_map` (
  `user_product_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `shop_id` int DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `point` int DEFAULT '0',
  PRIMARY KEY (`user_product_id`),
  KEY `fk_user_product_map_profile` (`user_id`),
  KEY `fk_user_product_map_product` (`product_id`),
  KEY `fk_user_product_map_shop` (`shop_id`),
  CONSTRAINT `fk_user_product_map_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`),
  CONSTRAINT `fk_user_product_map_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`),
  CONSTRAINT `fk_user_product_map_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_product_map`
--

LOCK TABLES `tb_user_product_map` WRITE;
/*!40000 ALTER TABLE `tb_user_product_map` DISABLE KEYS */;
INSERT INTO `tb_user_product_map` VALUES (1,8,1,1,'admin','测试商品1','2020-10-30 09:17:39',1),(2,1,1,1,'admin','测试商品1','2020-10-30 09:17:39',1),(3,1,1,15,'test','测试商品1','2020-11-04 07:48:21',1),(4,8,2,20,'李翔','正式商品1','2020-11-04 07:52:11',20),(5,8,2,20,'李翔','正式商品1','2020-11-04 07:53:02',20),(17,1,1,15,'test','测试商品1','2020-11-04 08:32:42',20),(18,1,2,20,'test','正式商品2','2020-11-04 08:32:53',20),(19,1,3,20,'test','正式商品3','2020-11-04 08:33:17',20),(20,1,1,15,'test','测试商品1','2020-11-04 08:33:26',20),(21,8,1,15,'李翔','测试商品1','2020-11-04 08:35:05',20),(22,8,1,15,'李翔','测试商品1','2020-11-04 08:35:33',20),(23,1,2,20,'test','正式商品2','2020-11-04 08:37:35',20),(24,1,2,20,'test','正式商品2','2020-11-04 08:38:21',20),(25,1,2,20,'test','正式商品2','2020-11-04 08:39:03',20),(26,1,2,20,'test','正式商品2','2020-11-04 08:39:36',20),(27,8,2,20,'李翔','正式商品2','2020-11-04 08:43:43',20),(28,1,1,15,'test','测试商品1','2020-11-04 08:54:31',20),(29,1,1,15,'test','测试商品1','2020-11-04 08:54:32',20),(30,1,1,15,'test','测试商品1','2020-11-04 08:54:33',20),(31,1,1,15,'test','测试商品1','2020-11-04 08:55:41',20),(32,1,1,15,'test','测试商品1','2020-11-04 08:55:42',20);
/*!40000 ALTER TABLE `tb_user_product_map` ENABLE KEYS */;
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
