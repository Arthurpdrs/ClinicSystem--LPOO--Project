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
INSERT INTO `Clinica` VALUES ('ClinicSystem','naoresponda_clinicdata@outlook.com','clinicdata00_','81 99999-9999','Avenida Governador Agamenon Magalhães, 84, Santo Amaro, Recife, PE',1);
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
  `Data_consulta` varchar(100) DEFAULT NULL,
  `Valor` varchar(100) DEFAULT NULL,
  `Pago` varchar(100) DEFAULT NULL,
  `Hora_consulta` varchar(100) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consulta`
--

LOCK TABLES `Consulta` WRITE;
/*!40000 ALTER TABLE `Consulta` DISABLE KEYS */;
INSERT INTO `Consulta` VALUES ('81737291927','34567890987','07/02/2023','Não informa','PAGO','14:00',3),('99999999999','91847548218','07/02/2023','100','PENDENTE','15:40',4);
/*!40000 ALTER TABLE `Consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Login`
--

DROP TABLE IF EXISTS `Login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Login` (
  `Usuario` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cargo` varchar(100) NOT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `Senha` varchar(45) NOT NULL,
  PRIMARY KEY (`Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Login`
--

LOCK TABLES `Login` WRITE;
/*!40000 ALTER TABLE `Login` DISABLE KEYS */;
INSERT INTO `Login` VALUES ('arthur','MEDICO','34567890987','123456'),('diana','RECEPCIONISTA','98765434567','123456'),('paulo','MEDICO','91847548218','oluap');
/*!40000 ALTER TABLE `Login` ENABLE KEYS */;
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
INSERT INTO `Medico` VALUES ('34567890987','ARTHUR PEDROSA','81 91111-1111','arthur@gmail.com','arthur','123456','111111','PEDIATRIA'),('91847548218','PAULO','81 99999-9999','pauloandrejanga@gmail.com','paulo','oluap','988172','PEDIATRIA');
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
  `Tipo_sanguineo` varchar(20) DEFAULT 'Não informado',
  `Alergia` varchar(100) DEFAULT 'Não informado',
  `Data_nascimento` varchar(100) NOT NULL,
  `Responsavel_CPF` varchar(12) DEFAULT 'N/E',
  `Endereco` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'Não informado',
  `Observacao` varchar(500) DEFAULT 'Não informado',
  PRIMARY KEY (`CPF`),
  KEY `fk_Paciente_Responsavel1_idx` (`Responsavel_CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paciente`
--

LOCK TABLES `Paciente` WRITE;
/*!40000 ALTER TABLE `Paciente` DISABLE KEYS */;
INSERT INTO `Paciente` VALUES ('10827914407','arthur','81986613467','modify@gmail.com','B+','nao','24/10/1996','','rua 1 1 test test 50000000','n'),('77777777777','joao','81988888888','alberto@gmail.com','B+','a','15/08/1979','33333333333','rua 1 1 test test 50000000','nao'),('81737291927','Paulo','81 98888-8888','pauloandrejanga@gmail.com','B+','Não informado','14/02/2000','','Não informado','Não informado'),('99999999999','Diana','81986613467','dksc@discente.ifpe.edu.br','B+','nao','24/10/1996','','rua 1 1 test test 50000000','n');
/*!40000 ALTER TABLE `Paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prontuario`
--

DROP TABLE IF EXISTS `Prontuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prontuario` (
  `Observacao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Data_prontuario` varchar(100) DEFAULT NULL,
  `Prescricao` varchar(100) DEFAULT NULL,
  `Medico_Especialidade` varchar(45) NOT NULL,
  `Medico_Nome` varchar(100) NOT NULL,
  `Paciente_CPF` varchar(12) NOT NULL,
  `Paciente_Nome` varchar(100) NOT NULL,
  `Queixa` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prontuario`
--

LOCK TABLES `Prontuario` WRITE;
/*!40000 ALTER TABLE `Prontuario` DISABLE KEYS */;
INSERT INTO `Prontuario` VALUES ('OBS','07/02/2023','PRESCRICAO','PEDIATRIA','PAULO','77777777777','JOAO','QUEIXA'),('OBS','07/02/2023','PRESCRICAO','PEDIATRIA','PAULO','77777777777','JOAO','QUEIXA');
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
INSERT INTO `Recepcionista` VALUES ('98765434567','DIANA','81 99999-9999','diana@gmail.com.br','diana','123456');
/*!40000 ALTER TABLE `Recepcionista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Responsavel`
--

DROP TABLE IF EXISTS `Responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Responsavel` (
  `CPF` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Responsavel`
--

LOCK TABLES `Responsavel` WRITE;
/*!40000 ALTER TABLE `Responsavel` DISABLE KEYS */;
INSERT INTO `Responsavel` VALUES ('33333333333','Inácio','81988888888');
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

-- Dump completed on 2023-02-07 13:28:40
