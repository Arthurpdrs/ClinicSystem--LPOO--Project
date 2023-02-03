CREATE DATABASE  IF NOT EXISTS `BancoLPOO` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BancoLPOO`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: database-2.ckzqkucrjrxv.us-east-1.rds.amazonaws.com    Database: BancoLPOO
-- ------------------------------------------------------
-- Server version	8.0.28

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `Administrador`
--

DROP TABLE IF EXISTS `Administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Administrador` (
  `CPF` varchar(12) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Senha` varchar(15) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administrador`
--

LOCK TABLES `Administrador` WRITE;
/*!40000 ALTER TABLE `Administrador` DISABLE KEYS */;
INSERT INTO `Administrador` VALUES ('00000000000','Admin','000000000','admin@clinicsystem.com.br','admin','pass');
/*!40000 ALTER TABLE `Administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clinica`
--

DROP TABLE IF EXISTS `Clinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clinica` (
  `Nome` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Senha` varchar(15) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  `Endereco` varchar(100) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clinica`
--

LOCK TABLES `Clinica` WRITE;
/*!40000 ALTER TABLE `Clinica` DISABLE KEYS */;
INSERT INTO `Clinica` VALUES ('QQQQQQQQQQQQQQQQQQQQ','naoresponda_clinicdata@outlook.com','clinicdata00_','81999999999','Avenida Governador Agamenon Magalhães, 84, Santo Amaro, Recife, PE',1);
/*!40000 ALTER TABLE `Clinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Consulta`
--

DROP TABLE IF EXISTS `Consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Consulta` (
  `Paciente_CPF` varchar(12) NOT NULL,
  `Medico_CPF` varchar(12) NOT NULL,
  `Data_consulta` date NOT NULL,
  `Valor` double NOT NULL,
  `Pago` tinyint NOT NULL,
  `Hora_consulta` time NOT NULL,
  PRIMARY KEY (`Paciente_CPF`,`Medico_CPF`),
  KEY `fk_Consulta_Medico1_idx` (`Medico_CPF`),
  CONSTRAINT `fk_Consulta_Medico1` FOREIGN KEY (`Medico_CPF`) REFERENCES `Medico` (`CPF`),
  CONSTRAINT `fk_Consulta_Paciente` FOREIGN KEY (`Paciente_CPF`) REFERENCES `Paciente` (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consulta`
--

LOCK TABLES `Consulta` WRITE;
/*!40000 ALTER TABLE `Consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medico`
--

DROP TABLE IF EXISTS `Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Medico` (
  `CPF` varchar(12) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Senha` varchar(15) NOT NULL,
  `CRM` varchar(15) NOT NULL,
  `Especialidade` varchar(45) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medico`
--

LOCK TABLES `Medico` WRITE;
/*!40000 ALTER TABLE `Medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paciente`
--

DROP TABLE IF EXISTS `Paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Paciente` (
  `CPF` varchar(12) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Tipo_sanguineo` varchar(3) NOT NULL,
  `Alergia` varchar(100) NOT NULL,
  `Data_nascimento` date NOT NULL,
  `Responsavel_CPF` varchar(12) DEFAULT NULL,
  `Endereco` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Observacao` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`CPF`),
  KEY `fk_Paciente_Responsavel1_idx` (`Responsavel_CPF`),
  CONSTRAINT `fk_Paciente_Responsavel1` FOREIGN KEY (`Responsavel_CPF`) REFERENCES `Responsavel` (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paciente`
--

LOCK TABLES `Paciente` WRITE;
/*!40000 ALTER TABLE `Paciente` DISABLE KEYS */;
INSERT INTO `Paciente` VALUES ('10000000000','Gabriel Vaz Luna de Almeida','81 98888-0000','gabrielvaz@gmail.com','A+','Nenhuma','2009-04-13','12349990034','Avenida Guanabara, s/n, Bairro Novo, Olinda, PE','Nenhuma'),('20000000000','Aline Pereira Brasil','81 90461-6222','alinep@hotmail.com','B-','Nenhuma','1995-12-12',NULL,'Rua Rio Branco, 16, Centro, Igarassu, PE','Nenhuma');
/*!40000 ALTER TABLE `Paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prontuario`
--

DROP TABLE IF EXISTS `Prontuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prontuario` (
  `Paciente_CPF` varchar(12) NOT NULL,
  `Medico_CPF` varchar(12) NOT NULL,
  `Queixa` varchar(100) DEFAULT NULL,
  `Prescricao` varchar(100) DEFAULT NULL,
  `Observacao` varchar(100) DEFAULT NULL,
  `Data_prontuario` date NOT NULL,
  PRIMARY KEY (`Paciente_CPF`,`Medico_CPF`),
  KEY `fk_Prontuario_Medico1_idx` (`Medico_CPF`),
  CONSTRAINT `fk_Prontuario_Medico1` FOREIGN KEY (`Medico_CPF`) REFERENCES `Medico` (`CPF`),
  CONSTRAINT `fk_Prontuario_Paciente1` FOREIGN KEY (`Paciente_CPF`) REFERENCES `Paciente` (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prontuario`
--

LOCK TABLES `Prontuario` WRITE;
/*!40000 ALTER TABLE `Prontuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Prontuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recepcionista`
--

DROP TABLE IF EXISTS `Recepcionista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Recepcionista` (
  `CPF` varchar(12) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Senha` varchar(15) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Recepcionista`
--

LOCK TABLES `Recepcionista` WRITE;
/*!40000 ALTER TABLE `Recepcionista` DISABLE KEYS */;
INSERT INTO `Recepcionista` VALUES ('12244455498','Joaquina','81 99900-8888','joaquina@clinicsystem.com','joaquina','joaquina123');
/*!40000 ALTER TABLE `Recepcionista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Responsavel`
--

DROP TABLE IF EXISTS `Responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Responsavel` (
  `CPF` varchar(12) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  `Email` varchar(100) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Responsavel`
--

LOCK TABLES `Responsavel` WRITE;
/*!40000 ALTER TABLE `Responsavel` DISABLE KEYS */;
INSERT INTO `Responsavel` VALUES ('12349990034','Maria Josefa Laercio Bezerra','81 98873-1233','mariajosefa@yahoo.com');
/*!40000 ALTER TABLE `Responsavel` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-02 22:11:36
