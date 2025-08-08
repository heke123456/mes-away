/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : awisenavition

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 26/09/2023 12:38:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ods_book_info
-- ----------------------------
DROP TABLE IF EXISTS `ods_book_info`;
CREATE TABLE `ods_book_info`  (
  `bookid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍唯一标识',
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `brief_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介',
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书籍来源',
  `loadtime` datetime NULL DEFAULT NULL COMMENT '装载时间',
  PRIMARY KEY (`bookid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
