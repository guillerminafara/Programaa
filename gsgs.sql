CREATE DATABASE  IF NOT EXISTS `Gimnasio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Gimnasio`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: Gimnasio
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `Cuota`
--

DROP TABLE IF EXISTS `Cuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cuota` (
  `idCuota` int NOT NULL AUTO_INCREMENT,
  `idPlanes` varchar(10) NOT NULL,
  `idCliente` int NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fechaVencimiento` datetime NOT NULL,
  PRIMARY KEY (`idCuota`),
  KEY `idInscrp_idx` (`idPlanes`),
  KEY `idclien_idx` (`idCliente`),
  CONSTRAINT `idclien` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `idSuscr` FOREIGN KEY (`idPlanes`) REFERENCES `Planes` (`idPlanes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cuota`
--

LOCK TABLES `Cuota` WRITE;
/*!40000 ALTER TABLE `Cuota` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cuota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Planes`
--

DROP TABLE IF EXISTS `Planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Planes` (
  `idPlanes` varchar(10) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `importe` double NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idPlanes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Planes`
--

LOCK TABLES `Planes` WRITE;
/*!40000 ALTER TABLE `Planes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Planes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `idCuota` int DEFAULT NULL,
  `idReserva` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `mail_UNIQUE` (`mail`),
  UNIQUE KEY `nif_UNIQUE` (`nif`),
  UNIQUE KEY `idcliente_UNIQUE` (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Paquito','Fara','42999999',1,'paquito@hotmail.com','123456',NULL,NULL),(2,'Tito','Fara','49999999',1,'tito@hotmail.com','123457',NULL,NULL),(3,'Suru','Fara','40999999',1,'suru@hotmail.com','123458',NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `idHorario` varchar(9) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `cantidad` int NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES ('MAY13-08','2024-05-13 08:00:00',8,1),('MAY13-09','2024-05-13 09:00:00',8,1),('MAY13-10','2024-05-13 10:00:00',8,1),('MAY13-11','2024-05-13 10:00:00',8,1),('MAY13-12','2024-05-13 12:00:00',8,1),('MAY13-13','2024-05-13 13:00:00',8,1),('MAY13-16','2024-05-13 16:00:00',8,1),('MAY13-17','2024-05-13 17:00:00',8,1),('MAY13-18','2024-05-13 18:00:00',8,1),('MAY13-19','2024-05-13 19:00:00',8,1),('MAY13-20','2024-05-13 20:00:00',8,1),('MAY13-21','2024-05-13 21:00:00',8,1),('MAY14-08','2024-05-14 08:00:00',8,1),('MAY14-09','2024-05-14 09:00:00',8,1),('MAY14-10','2024-05-14 10:00:00',8,1),('MAY14-11','2024-05-14 10:00:00',8,1),('MAY14-12','2024-05-14 12:00:00',8,1),('MAY14-13','2024-05-14 13:00:00',8,1),('MAY14-16','2024-05-14 16:00:00',8,1),('MAY14-17','2024-05-14 17:00:00',8,1),('MAY14-18','2024-05-14 18:00:00',8,1),('MAY14-19','2024-05-14 19:00:00',8,1),('MAY14-20','2024-05-14 20:00:00',8,1),('MAY14-21','2024-05-14 21:00:00',8,1),('MAY15-08','2024-05-15 08:00:00',8,1),('MAY15-09','2024-05-15 09:00:00',8,1),('MAY15-10','2024-05-15 10:00:00',8,1),('MAY15-11','2024-05-15 10:00:00',8,1),('MAY15-12','2024-05-15 12:00:00',8,1),('MAY15-13','2024-05-15 13:00:00',8,1),('MAY15-16','2024-05-15 16:00:00',8,1),('MAY15-17','2024-05-15 17:00:00',8,1),('MAY15-18','2024-05-15 18:00:00',8,1),('MAY15-19','2024-05-15 19:00:00',8,1),('MAY15-20','2024-05-15 20:00:00',8,1),('MAY15-21','2024-05-15 21:00:00',8,1);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `idReserva` int NOT NULL,
  `idCliente` int NOT NULL,
  `idHorario` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_reserva_2_idx` (`idHorario`),
  KEY `fk_reserva_1_idx` (`idCliente`),
  CONSTRAINT `cliente_horario` FOREIGN KEY (`idHorario`) REFERENCES `horario` (`idHorario`),
  CONSTRAINT `cliente_reserva` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-24 14:25:18
