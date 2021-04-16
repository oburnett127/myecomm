DROP TABLE IF EXISTS ``;

CREATE TABLE `ride` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `duration` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

LOCK TABLES `ride` WRITE;
INSERT INTO `ride` VALUES (1,'Bobsled Trail Ride',35),(4,'Willow Trail Ride',30),(5,'Round Valley Ride',38);
UNLOCK TABLES;