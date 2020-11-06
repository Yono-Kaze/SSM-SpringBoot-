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
-- Table structure for table `tb_shop`
--

DROP TABLE IF EXISTS `tb_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_shop` (
  `shop_id` int NOT NULL AUTO_INCREMENT,
  `owner_id` int NOT NULL COMMENT '店铺创建人',
  `area_id` int DEFAULT NULL,
  `shop_category_id` int DEFAULT NULL,
  `parent_category_id` int DEFAULT NULL,
  `shop_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `shop_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_addr` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `longitude` double(16,12) DEFAULT NULL,
  `latitude` double(16,12) DEFAULT NULL,
  `priority` int DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int NOT NULL DEFAULT '0',
  `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `fk_shop_profile` (`owner_id`),
  KEY `fk_shop_area` (`area_id`),
  KEY `fk_shop_shopcate` (`shop_category_id`),
  KEY `fk_shop_parentcate` (`parent_category_id`),
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),
  CONSTRAINT `fk_shop_parentcate` FOREIGN KEY (`parent_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`),
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`),
  CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_shop`
--

LOCK TABLES `tb_shop` WRITE;
/*!40000 ALTER TABLE `tb_shop` DISABLE KEYS */;
INSERT INTO `tb_shop` VALUES (1,8,3,14,12,'冰冻夏天奶茶店(分店1)','本店出售各种冷饮，奶茶，冰花，鲜榨果汁。','东苑7懂2号门面','8889999','/upload/images/item/shop/27/2017060715512185473.jpg',NULL,NULL,20,'2020-10-29 14:30:22','2020-10-29 14:30:22',1,NULL),(15,8,4,14,10,'二手车辆','二手汽车、摩托车、电车等交通工具交易信息','面向全市','0000000','/upload/images/item/shop/15/2017060522042982266.png',NULL,NULL,100,'2017-06-05 22:04:29','2020-11-04 09:50:07',1,''),(16,8,3,15,10,'旧书籍交易','旧书籍交易信息','旧书籍交易板块','0000000','/upload/images/item/shop/16/2017060608534289617.png',NULL,NULL,99,'2017-06-06 08:53:42','2020-11-02 08:47:04',-1,''),(17,8,3,17,11,'靓仔靓妹美容护理中心','二十年手艺，专业护理秀发受损头发。美容美发首选。','东苑北面二号门','4445556','/upload/images/item/shop/17/2017060609084595067.jpg',NULL,NULL,0,'2017-06-06 09:08:45','2017-06-06 09:45:32',1,NULL),(18,8,3,18,11,'一剪没理发中心','专业洗剪吹，又好又便宜。','东苑北面3号门面','9998887','/upload/images/item/shop/18/2017060609110899956.jpg',NULL,NULL,0,'2017-06-06 09:11:08','2017-06-06 09:45:38',1,NULL),(19,8,4,20,12,'吃得饱大排档','吃得好又吃得饱，朋友聚会好地方。可预约。','南苑东面10号门面','1234567','/upload/images/item/shop/19/2017060609140699548.jpg',NULL,NULL,0,'2017-06-06 09:14:06','2017-06-06 09:45:43',1,NULL),(20,8,4,22,12,'香喷喷奶茶店','鲜榨果汁、奶茶等饮品。','南苑东面5号门面','77788444','/upload/images/item/shop/20/2017060609163395401.jpg',NULL,NULL,30,'2017-06-06 09:16:33','2017-06-07 16:24:07',1,''),(21,8,5,25,13,'海陆空量贩KTV','订包厢电话：8889997。节假日请预约。','西苑1号门面','8889997','/upload/images/item/shop/21/2017060609194286080.jpg',NULL,NULL,0,'2017-06-06 09:19:42','2017-06-06 09:45:59',1,NULL),(22,8,5,24,13,'幽城室逃生娱乐城','考验你的智商，和小伙伴们一起来挑战吧。','西苑3号楼第二层','6666333','/upload/images/item/shop/22/2017060609223853062.jpg',NULL,NULL,0,'2017-06-06 09:22:38','2017-06-06 09:46:04',1,NULL),(23,8,6,29,27,'威水程序设计培训教育','保教抱会，前途无量。','北苑2栋5楼','66633111','/upload/images/item/shop/23/2017060609275777519.png',NULL,NULL,0,'2017-06-06 09:27:57','2017-06-06 09:46:09',1,NULL),(24,8,6,30,27,'武林风舞蹈培训','专业培训舞蹈，声乐。','北苑9懂10楼','5555555','/upload/images/item/shop/24/2017060609354459045.png',NULL,NULL,0,'2017-06-06 09:35:44','2017-06-06 09:46:13',1,NULL),(25,8,6,14,10,'易行交通工具租赁服务中心','本店租赁各种汽车，摩托车等。详情请拨打电话咨询。电话：2222222','1栋3号4号门面','2222222','/upload/images/item/shop/25/2017060609381150709.png',NULL,NULL,40,'2017-06-06 09:38:11','2020-11-02 08:47:14',-1,''),(26,8,6,31,28,'有声有色','出租各种演出道具，乐器，服装等。','北苑15号门面','7777777','/upload/images/item/shop/26/2017060609431259039.png',NULL,NULL,41,'2017-06-06 09:43:12','2020-11-02 08:47:08',-1,''),(27,8,3,22,12,'冰冻夏天奶茶店','本店出售各种冷饮，奶茶，冰花，鲜榨果汁。','东苑7懂2号门面','8889999','/upload/images/item/shop/27/2017060715512185473.jpg',NULL,NULL,10,'2017-06-07 15:51:21','2017-06-07 16:22:28',1,''),(28,9,3,14,28,'test','dfafaf','sdafafafa','3424242','/upload/images/item/shop/28/2017082500103690946.png',NULL,NULL,0,'2017-08-25 00:10:36','2020-11-04 09:53:33',0,''),(29,8,3,14,NULL,'二手车','二手车','测试35','13810524526','\\upload\\images\\item\\shop\\29\\2020102922302210244.png',NULL,NULL,0,'2020-10-29 14:30:22','2020-10-29 14:30:22',1,NULL),(30,1,4,14,NULL,'二手车','二手车','面向全市','77788444','\\upload\\images\\item\\shop\\30\\2020103020165926733.png',NULL,NULL,0,'2020-10-30 12:17:00','2020-10-30 12:17:00',1,NULL),(31,8,6,20,12,'二手','二手','面向全市','77788444','\\upload\\images\\item\\shop\\31\\2020110417410524588.png',NULL,NULL,0,'2020-11-04 09:41:02','2020-11-04 09:54:04',1,''),(32,8,5,14,10,'二','二','南苑东面5号门面','77788444','\\upload\\images\\item\\shop\\32\\2020110417500135484.png',NULL,NULL,20,'2020-11-04 09:50:01','2020-11-04 09:53:21',0,'');
/*!40000 ALTER TABLE `tb_shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-06 18:29:39
