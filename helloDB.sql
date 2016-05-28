# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: hello
# ------------------------------------------------------
# Server version 5.0.45-community-nt

CREATE DATABASE `hello` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hello`;

#
# Table structure for table tab_user
#

CREATE TABLE `tab_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `tab_user` VALUES (1,'tom','cat');
INSERT INTO `tab_user` VALUES (2,'frank','shang');
INSERT INTO `tab_user` VALUES (3,'天王盖地虎','宝塔镇河妖');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
