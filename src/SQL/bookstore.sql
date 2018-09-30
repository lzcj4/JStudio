# Host: localhost  (Version 5.7.19)
# Date: 2018-09-30 18:00:45
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "t_author"
#

DROP TABLE IF EXISTS `t_author`;
CREATE TABLE `t_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "t_author"
#

INSERT INTO `t_author` VALUES (1,'张三',b'1','杭州','0571-88620001'),(2,'李四',b'1','宁波','0574-55660001');

#
# Structure for table "t_cover"
#

DROP TABLE IF EXISTS `t_cover`;
CREATE TABLE `t_cover` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `file_path` varchar(200) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_cover"
#


#
# Structure for table "t_store"
#

DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "t_store"
#

INSERT INTO `t_store` VALUES (1,'杭州库','杭州文一路','0571-88621234'),(2,'宁波库','宁波天一阁','0574-55661234');

#
# Structure for table "t_book"
#

DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_author` (`author_id`),
  KEY `fk_store_` (`store_id`),
  CONSTRAINT `fk_author` FOREIGN KEY (`author_id`) REFERENCES `t_author` (`id`),
  CONSTRAINT `fk_store_` FOREIGN KEY (`store_id`) REFERENCES `t_store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "t_book"
#

INSERT INTO `t_book` VALUES (1,'高数',1,1),(7,'线性代数',2,2),(8,'语文',2,1);
