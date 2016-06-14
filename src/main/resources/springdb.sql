# Host: 5745515c2fd0b.sh.cdb.myqcloud.com:4942  (Version 5.6.28-log)
# Date: 2016-06-14 20:44:08
# Generator: MySQL-Front 5.3  (Build 5.39)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_type"
#

DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "tb_type"
#

INSERT INTO `tb_type` VALUES (1,'测试'),(2,'测试2');

#
# Structure for table "tb_user"
#

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `header_path` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `last_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "tb_user"
#

INSERT INTO `tb_user` VALUES (2,'admin123','127.0.0.1','admin123','/1.jpg','2015-05-05 00:00:00'),(4,'admin1234',NULL,'admin1234',NULL,NULL),(5,'admin1236',NULL,'admin123',NULL,NULL);

#
# Structure for table "tb_post"
#

DROP TABLE IF EXISTS `tb_post`;
CREATE TABLE `tb_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `type` int(11) DEFAULT '1',
  `reply_count` int(11) DEFAULT '0' COMMENT '回复数量',
  `click_count` int(11) DEFAULT '0' COMMENT '点击数量',
  PRIMARY KEY (`post_id`),
  KEY `fk_post_user_userId` (`user_id`),
  KEY `fk_post_type_id` (`type`),
  CONSTRAINT `fk_post_type_id` FOREIGN KEY (`type`) REFERENCES `tb_type` (`type_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_post_user_userId` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

#
# Data for table "tb_post"
#

INSERT INTO `tb_post` VALUES (1,'第一个标题',2,'测试内容','2015-05-05 00:00:00',1,2,0),(4,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(5,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(6,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(7,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(8,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(9,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(10,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(11,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(12,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(13,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(14,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(15,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(16,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(17,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(18,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(19,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(20,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(21,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(22,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(23,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(24,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(25,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(26,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(27,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(28,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(29,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(30,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(31,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(32,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(33,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(34,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(35,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(36,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(37,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(38,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(39,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(40,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(41,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(42,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(43,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(44,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(45,'测试标题',2,'这个是内容','2015-05-05 00:00:00',1,0,0),(48,'tttt',2,'<p>tttt<img src=\"/project-dianshang/static/ueditor/jsp/upload/image/20160613/1465821261886049666.jpg\" title=\"1465821261886049666.jpg\" alt=\"1 (1).jpg\"/></p>','2016-06-13 20:34:24',1,0,0),(49,'ssdfsdf',2,'<p><img src=\"/project-dianshang/static/ueditor/jsp/upload/image/20160613/1465821689728083100.jpg\" title=\"1465821689728083100.jpg\" alt=\"1 (1).jpg\" width=\"326\" height=\"373\"/>测试发布的图片</p>','2016-06-13 20:42:06',1,0,0);

#
# Structure for table "tb_comment"
#

DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` varchar(255) DEFAULT NULL,
  `post_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `pre_comment_id` int(11) NOT NULL DEFAULT '0' COMMENT '表示这条回复是回复某条回复的',
  `publish_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '评论发布时间',
  PRIMARY KEY (`comment_id`),
  KEY `fk_comment_post_postId` (`post_id`),
  KEY `fk_comment_user_userid` (`user_id`),
  CONSTRAINT `fk_comment_post_postId` FOREIGN KEY (`post_id`) REFERENCES `tb_post` (`post_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_comment_user_userid` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "tb_comment"
#

INSERT INTO `tb_comment` VALUES (3,'update测试',1,2,0,'2016-05-24 00:00:00'),(4,'第一个回复',1,2,0,'2015-05-05 00:00:00');

#
# Structure for table "tb_bullet"
#

DROP TABLE IF EXISTS `tb_bullet`;
CREATE TABLE `tb_bullet` (
  `bullet_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `color` int(11) DEFAULT NULL,
  `mode` int(11) DEFAULT NULL,
  PRIMARY KEY (`bullet_id`),
  KEY `fk_userid` (`user_id`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_bullet"
#


#
# Structure for table "tb_video"
#

DROP TABLE IF EXISTS `tb_video`;
CREATE TABLE `tb_video` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`video_id`),
  KEY `fk_user` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_video"
#


#
# Trigger "tr_delete"
#

DROP TRIGGER IF EXISTS `tr_delete`;
CREATE DEFINER='cdb_outerroot'@'%' TRIGGER `tr_delete` AFTER DELETE ON `tb_comment`
  FOR EACH ROW update tb_post set tb_post.reply_count=tb_post.reply_count-1 where old.post_id=tb_post.post_id;

#
# Trigger "tr_insert"
#

DROP TRIGGER IF EXISTS `tr_insert`;
CREATE DEFINER='cdb_outerroot'@'%' TRIGGER `tr_insert` AFTER INSERT ON `tb_comment`
  FOR EACH ROW update tb_post set tb_post.reply_count=tb_post.reply_count+1 where new.post_id=tb_post.post_id;
