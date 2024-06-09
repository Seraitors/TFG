-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: figuradb
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `figura`
--

DROP TABLE IF EXISTS `figura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `figura` (
  `id` bigint NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `fecha_introducida` date DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` int NOT NULL,
  `stock` int NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `arco_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdd1te63mjd15nsf70npo5ujps` (`arco_id`),
  CONSTRAINT `FKdd1te63mjd15nsf70npo5ujps` FOREIGN KEY (`arco_id`) REFERENCES `tipo_arco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `figura`
--

LOCK TABLES `figura` WRITE;
/*!40000 ALTER TABLE `figura` DISABLE KEYS */;
INSERT INTO `figura` VALUES (1,'one-piece','Esta es una figura de luffy cuando estaba en wano ','1999-10-10','Luffy',80,1,'/imagen/fotosLista/luffy.jpg',1),(2,'one-piece','Esta es una figura de Zoro en wano, El ancho es 10 cm de alto y de largo son 70cm.  ','1999-10-10','Zoro',65,2,'/imagen/fotosLista/zoro.jpg',3),(3,'one-piece','Esta es una figura de Brook en su lucha de Bif Mom, El ancho es 15 cm de alto y de largo son 50cm.  ','2024-10-22','Brook',100,0,'/imagen/fotosLista/brook1.jpg',3),(4,'dragon-ball','Esta es la figura de Goku en su lucha contra el manvado Freezer, El ancho es 12 cm de alto y de largo son 60cm.  ','2022-08-02','Goku',100,1,'/imagen/fotosLista/goku.jpg',4),(5,'dragon-ball','Esta es una figura de vegeta herido despues de su pelea en Namek, El ancho es 10 cm de alto y de largo son 45cm.  ','2014-12-22','Vegeta',30,5,'/imagen/fotosLista/vegeta.jpg',4),(6,'dragon-ball','Esta es una figura de Freezer en Namek, El ancho es 10 cm de alto y de largo son 70cm.  ','2015-02-02','Freezer',50,2,'/imagen/fotosLista/freezer.jpg',4),(7,'dragon-ball','Esta es una figura de Piccolo en Namek, El ancho es 11.5 cm de alto y de largo son 300cm.  ','2011-11-16','Piccolo',20,10,'/imagen/fotosLista/piccolo.jpg',4),(8,'naruto','Esta es una figura de sasuke en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200cm.  ','2014-05-08','sasuke',30,5,'/imagen/fotosLista/sasuke.jpg',6),(9,'naruto','Esta es una figura de naruto en la villa oculta de la hoja de pequño, El ancho es 10.5 cm de alto y de largo son 200cm.  ','2010-10-10','naruto',30,2,'/imagen/fotosLista/naruto.jpg',6),(10,'naruto','Esta es una figura de naruto en la villa oculta de la hoja de mayor, El ancho es 10.5 cm de alto y de largo son 200cm.  ','2011-06-14','naruto',35,3,'/imagen/fotosLista/narutoM.jpg',6),(11,'novedad','Gohan modo bestia en la tierra su despertad ma skaioken','2006-05-10','Gohan',150,2,'/imagen/fotosLista/gohan.jpg',5),(12,'naruto','naruto pelea contra Pain Modo sabio 20 cm de alto y de largo 200cm','2004-08-12','naruto',50,2,'/imagen/fotosLista/narutoSabio.jpg',6),(13,'novedad','Pain pelea contra naruto Modo sabio 20 cm de alto y de largo 200cm','2018-11-26','Pain',45,3,'/imagen/fotosLista/pain.jpg',6),(14,'novedad','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2018-11-26','Obito',50,0,'/imagen/fotosLista/obito.jpg',6),(15,'novedad','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2018-11-26','Obito',50,0,'/imagen/fotosLista/obito.jpg',6),(16,'novedad','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2018-11-26','Obito',50,0,'/imagen/fotosLista/obito.jpg',6),(17,'novedad','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2018-11-26','Obito',50,0,'/imagen/fotosLista/obito.jpg',6),(18,'one-piece','Luffy en la batalla contra kaido despues de dar la cara ante los yonkous, 30 cm de alto y de largo 122cm','2024-10-22','Luffy',50,0,'/imagen/fotosOnePiece/luffySombrero.jpg',1),(19,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,1,'/imagen/fotosOnePiece/shanks.jpg',6),(20,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2014-10-22','Ace',50,2,'/imagen/fotosOnePiece/ace.jpg',6),(21,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2014-11-22','Obito',50,1,'/imagen/fotosOnePiece/choper.jpg',6),(22,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2021-10-12','Obito',50,2,'/imagen/fotosOnePiece/trio.jpg',6),(23,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosOnePiece/zoro1.jpg',6),(24,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-12-20','Obito',50,0,'/imagen/fotosOnePiece/nami.jpg',6),(25,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2023-10-20','Obito',50,0,'/imagen/fotosOnePiece/zoro2.jpg',6),(26,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2023-09-20','Obito',50,1,'/imagen/fotosOnePiece/law.jpg',6),(27,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-01-22','Obito',60,2,'/imagen/fotosOnePiece/sanji.jpg',6),(28,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2012-10-01','Obito',25,0,'/imagen/fotosOnePiece/luffy1.jpg',6),(29,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2010-09-03','Obito',30,5,'/imagen/fotosOnePiece/barbanegra.jpg',6),(30,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2011-07-08','Obito',50,1,'/imagen/fotosOnePiece/kaido.jpg',6),(31,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2010-07-17','Big Mam',40,2,'/imagen/fotosOnePiece/mam.jpg',6),(32,'one-piece','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2009-11-07','Sabo',30,3,'/imagen/fotosOnePiece/sabo.jpg',6),(33,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,1,'/imagen/fotosNaruto/gaara.jpeg',6),(34,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/naruto1.jpeg',6),(35,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/obito2.jpeg',6),(36,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/itachi.jpeg',6),(37,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/naruto2.jpeg',6),(38,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/pain.jpeg',6),(39,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/kakasi.jpeg',6),(40,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/naruto3.jpeg',6),(41,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/sasuke.jpeg',6),(42,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/madara.jpeg',6),(43,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/obite3.jpeg',6),(44,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/kakasi1.jpeg',6),(45,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/madara1.jpeg',6),(46,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/obito.jpeg',6),(47,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/naruto.jpeg',6),(48,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosNaruto/obito1.jpeg',6),(49,'naruto','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',20,0,'/imagen/fotosNaruto/sakura.jpeg',6),(50,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/broly.jpeg',6),(51,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/gohan3.jpeg',6),(52,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/vegeta.jpeg',6),(53,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/broly1.jpeg',6),(54,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/goku.jpeg',6),(55,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/vegeta1.jpeg',6),(56,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/broly2.jpeg',6),(57,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/goku1.jpeg',6),(58,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/vegeta2.jpeg',6),(59,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/gohan.jpeg',6),(60,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/goku3.jpeg',6),(61,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/vegeta3.jpeg',6),(62,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/gohan1.jpeg',6),(63,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/goku4.jpeg',6),(64,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/vegeta4.jpeg',6),(65,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/gohan2.jpeg',6),(66,'dragon-ball','Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200cm','2024-10-22','Obito',50,0,'/imagen/fotosDragonBall/goku5.jpeg',6);
/*!40000 ALTER TABLE `figura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `figura_seq`
--

DROP TABLE IF EXISTS `figura_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `figura_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `figura_seq`
--

LOCK TABLES `figura_seq` WRITE;
/*!40000 ALTER TABLE `figura_seq` DISABLE KEYS */;
INSERT INTO `figura_seq` VALUES (151);
/*!40000 ALTER TABLE `figura_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_perfil`
--

DROP TABLE IF EXISTS `rol_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_perfil` (
  `registar_id` bigint NOT NULL,
  `rol_id` bigint NOT NULL,
  PRIMARY KEY (`registar_id`,`rol_id`),
  KEY `FK8x88fxp4b93rs2loco3mysbkm` (`rol_id`),
  CONSTRAINT `FK71x11ln4fdqokwns76i1cidij` FOREIGN KEY (`registar_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK8x88fxp4b93rs2loco3mysbkm` FOREIGN KEY (`rol_id`) REFERENCES `super_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_perfil`
--

LOCK TABLES `rol_perfil` WRITE;
/*!40000 ALTER TABLE `rol_perfil` DISABLE KEYS */;
INSERT INTO `rol_perfil` VALUES (1,1),(2,1),(2,2);
/*!40000 ALTER TABLE `rol_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `super_roles`
--

DROP TABLE IF EXISTS `super_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `super_roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l4cjxk4irqvjuy56hdflg2xnc` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `super_roles`
--

LOCK TABLES `super_roles` WRITE;
/*!40000 ALTER TABLE `super_roles` DISABLE KEYS */;
INSERT INTO `super_roles` VALUES (1,NULL,'ROLE_USER'),(2,NULL,'ROLE_ADMIN');
/*!40000 ALTER TABLE `super_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_arco`
--

DROP TABLE IF EXISTS `tipo_arco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_arco` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_arco`
--

LOCK TABLES `tipo_arco` WRITE;
/*!40000 ALTER TABLE `tipo_arco` DISABLE KEYS */;
INSERT INTO `tipo_arco` VALUES (1,'Wano'),(2,'Marinforce'),(3,'Dressrosa'),(4,'Namek'),(5,'Tierra'),(6,'Villa oculta de la Hoja');
/*!40000 ALTER TABLE `tipo_arco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `fecha_alta` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  UNIQUE KEY `UK_863n1y3x0jalatoir4325ehal` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'user@wanted.es',NULL,'$2a$10$s12UZ2QZvo4u3MbEBcmSjer7/OFWcE34EAmGEzav3lpMcuox4yhTS','user'),(2,'admin@wanted.es',NULL,'$2a$10$cyXkbobF7gcTGSSHqWkBOegzVssY5.AAiymRQrAb4Bnz5VeYNVLDa','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id` bigint NOT NULL,
  `datos_vivienda` varchar(255) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `figura_comprada` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio_total` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas_seq`
--

DROP TABLE IF EXISTS `ventas_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas_seq`
--

LOCK TABLES `ventas_seq` WRITE;
/*!40000 ALTER TABLE `ventas_seq` DISABLE KEYS */;
INSERT INTO `ventas_seq` VALUES (1);
/*!40000 ALTER TABLE `ventas_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'figuradb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-09 19:29:42
