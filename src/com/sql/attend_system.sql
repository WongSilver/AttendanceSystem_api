/*
Navicat MySQL Data Transfer

Source Server         : WONG
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : attend_system

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-06-21 15:21:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_tb`
-- ----------------------------
DROP TABLE IF EXISTS `admin_tb`;
CREATE TABLE `admin_tb` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin_tb
-- ----------------------------
INSERT INTO `admin_tb` VALUES ('1', 'admin', 'admin', null);
INSERT INTO `admin_tb` VALUES ('2', '1', '1', '1');

-- ----------------------------
-- Table structure for `class_tb`
-- ----------------------------
DROP TABLE IF EXISTS `class_tb`;
CREATE TABLE `class_tb` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `info` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of class_tb
-- ----------------------------
INSERT INTO `class_tb` VALUES ('1', '17应用1班', null);
INSERT INTO `class_tb` VALUES ('2', '17应用2班', null);
INSERT INTO `class_tb` VALUES ('3', '17应用3班', null);
INSERT INTO `class_tb` VALUES ('4', '17应用4班', null);
INSERT INTO `class_tb` VALUES ('5', '17应用5班', null);

-- ----------------------------
-- Table structure for `leave_tb`
-- ----------------------------
DROP TABLE IF EXISTS `leave_tb`;
CREATE TABLE `leave_tb` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `student_id` int(5) NOT NULL,
  `start` varchar(20) NOT NULL,
  `end` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `context` varchar(255) NOT NULL,
  `status` int(5) NOT NULL DEFAULT '0',
  `remark` varchar(20) DEFAULT NULL,
  `ps` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `leave_student_fk` (`student_id`),
  CONSTRAINT `leave_student_fk` FOREIGN KEY (`student_id`) REFERENCES `student_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of leave_tb
-- ----------------------------
INSERT INTO `leave_tb` VALUES ('59', '1', '2019-06-20', '2019-06-20', '事假', '', '1', null, null);
INSERT INTO `leave_tb` VALUES ('60', '1', '2019-06-20', '2019-06-20', '事假', '', '-1', null, null);
INSERT INTO `leave_tb` VALUES ('61', '1', '2019-06-20', '2019-06-20', '事假', '', '1', null, null);
INSERT INTO `leave_tb` VALUES ('62', '1', '2019-06-20', '2019-06-20', '事假', '你还', '1', null, null);
INSERT INTO `leave_tb` VALUES ('66', '1', '2019-06-20', '2019-06-20', '事假', '', '1', null, null);
INSERT INTO `leave_tb` VALUES ('67', '1', '2019-06-20', '2019-6-21', '事假', '我测试一下。。。', '1', null, null);
INSERT INTO `leave_tb` VALUES ('68', '4', '2019-06-20', '2019-06-20', '事假', '我是', '-1', null, null);
INSERT INTO `leave_tb` VALUES ('69', '1', '2019-06-20', '2019-06-20', '事假', '', '1', null, null);
INSERT INTO `leave_tb` VALUES ('70', '1', '2019-06-20', '2019-6-21', '事假', '凉凉了', '-1', null, null);
INSERT INTO `leave_tb` VALUES ('71', '1', '2019-06-20', '2019-06-20', '婚假', '我要结婚', '-1', null, null);
INSERT INTO `leave_tb` VALUES ('72', '1', '2019-06-20', '2019-06-20', '事假', '你好', '1', null, null);
INSERT INTO `leave_tb` VALUES ('73', '1', '2019-06-20', '2019-06-20', '事假', '', '-1', null, null);

-- ----------------------------
-- Table structure for `student_tb`
-- ----------------------------
DROP TABLE IF EXISTS `student_tb`;
CREATE TABLE `student_tb` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uNum` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `uName` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `password` varchar(20) NOT NULL,
  `class_id` int(5) NOT NULL,
  `sex` int(5) NOT NULL DEFAULT '2' COMMENT '0女 1男 2未知',
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_class_fk` (`class_id`),
  CONSTRAINT `student_class_fk` FOREIGN KEY (`class_id`) REFERENCES `class_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of student_tb
-- ----------------------------
INSERT INTO `student_tb` VALUES ('1', '1', '王志', '1', '1', '2', null);
INSERT INTO `student_tb` VALUES ('3', '201730271', '朱奕成', '201730271', '1', '2', null);
INSERT INTO `student_tb` VALUES ('4', '201730431', '刘成', '201730431', '5', '2', null);
INSERT INTO `student_tb` VALUES ('5', '201730428', '梁靖', '201730428', '5', '2', null);
INSERT INTO `student_tb` VALUES ('6', '201730275', '王贵来', '201730275', '1', '2', null);

-- ----------------------------
-- Table structure for `teacher_tb`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_tb`;
CREATE TABLE `teacher_tb` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `uNum` varchar(20) NOT NULL,
  `sex` int(5) NOT NULL DEFAULT '2' COMMENT '0 1 2 ',
  `class_id` int(5) NOT NULL,
  `phone` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_class_fk` (`class_id`),
  CONSTRAINT `teacher_class_fk` FOREIGN KEY (`class_id`) REFERENCES `class_tb` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of teacher_tb
-- ----------------------------
INSERT INTO `teacher_tb` VALUES ('1', '万芳', '1', '1', '2', '1', null);
