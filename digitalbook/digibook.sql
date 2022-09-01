-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: digital_book
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_email` varchar(255) DEFAULT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `author_pass` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Rahul@gmail.com','Rahul','deepak','male'),(2,'deepak@gmail.com','Deepak','deepak','male'),(3,'Sandeep@gmail.com','Sandeep','sandeep','male'),(4,'riya@gmail.com','Riya','riya','female');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `author_id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,_binary '',1,'Fantsy','My Sipder man is hero for everyone',265.23,'Bharti Publication','23-Jul-2022','Spiderman The bigning'),(2,_binary '',1,'Fantsy','My Super man is hero for everyone',278.2,'Deepak Publication','15-Jul-2022','Superman The bigning'),(3,_binary '',2,'Fantsy','My man is hero for everyone',2789.2,'Rahul Publication','15-Jul-2022','Hero The bigning'),(4,_binary '',1,'Fantsy','My man is hero for everyone',278.2,'Rahul Publication','15-Jul-2022','Hero The bigning'),(5,_binary '',3,'Science','It is a story about a main who knows everything',693.2,'Sandeep Publication','16-Jul-2022','Sandeep The Hero'),(6,_binary '',3,'Science','It is a story about a main who knows everything',693.2,'Sandeep Publication','16-Jul-2022','Sandeep The Hero'),(7,_binary '',1,'Science','It is a story about a main who knows everything',693.2,'Sandeep Publication','16-Jul-2022','Sandeep The Hero'),(8,_binary '',1,'Fantasy','When the crises happens to the world. The how deepak saved this world using his power',689.2,'Deepak Publication','01-Jan-2022','Deepak Is Comming');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `book_price` double NOT NULL,
  `purchase_date` varchar(255) DEFAULT NULL,
  `reader_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,2,278.2,'2022-07-23','kumar@gmail.com'),(2,2,278.2,'2022-07-23','deepak@gmail.com'),(3,2,278.2,'2022-07-28','deepak@gmail.com');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-29 11:16:08
