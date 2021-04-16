DROP TABLE IF EXISTS `ride`;

CREATE TABLE `ride` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `duration` int(11) NOT NULL,
  `ride_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

LOCK TABLES `ride` WRITE;
INSERT INTO `ride` VALUES (1,'Bobsled Trail Ride',42,'2017-03-26 20:28:23'),(4,'Willow Trail Ride',30,'2017-03-26 20:28:23'),(5,'Round Valley Ride',38,'2017-03-26 20:28:23'),(6,'Sagebrush Trail',33,'2017-03-26 20:28:23'),(7,'Yellow Fork Trail',33,'2017-03-26 20:28:23'),(14,'Bobsled Trail',33,'2017-03-26 20:28:23'),(15,'Bobsled Trail',33,'2017-03-26 20:28:23'),(16,'Bobsled Trail',33,'2017-03-26 20:28:23'),(17,'Bobsled Trail',33,'2017-03-26 20:28:23');
UNLOCK TABLES;

DROP TABLE IF EXISTS `schema_version`;
CREATE TABLE `schema_version` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `schema_version` WRITE;
INSERT INTO `schema_version` VALUES (1,'1','Baseline','SQL','V1__Baseline.sql',1650775713,'root','2021-04-04 12:58:00',51,1);
UNLOCK TABLES;