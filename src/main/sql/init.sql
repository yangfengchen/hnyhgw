/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : hnyhgw

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2018-11-18 22:26:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_article_content
-- ----------------------------
DROP TABLE IF EXISTS `tbl_article_content`;
CREATE TABLE `tbl_article_content` (
  `id` varchar(50) NOT NULL,
  `title_name` varchar(200) DEFAULT NULL,
  `content` text COMMENT '内容',
  `publish_date` date DEFAULT NULL COMMENT '发布时间',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `udpate_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  `title_code` varchar(4000) DEFAULT NULL COMMENT '标题编码',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tbl_article_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_article_type`;
CREATE TABLE `tbl_article_type` (
  `id` varchar(50) NOT NULL,
  `name` varchar(4000) DEFAULT NULL COMMENT '标题名称',
  `title_code` varchar(50) DEFAULT NULL COMMENT '标题编码',
  `type` varchar(50) DEFAULT NULL COMMENT '标题类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `enable` int(11) DEFAULT NULL COMMENT '是否启用',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `udpate_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tbl_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu`;
CREATE TABLE `tbl_menu` (
  `id` varchar(50) NOT NULL,
  `name` varchar(500) DEFAULT NULL COMMENT '菜单名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序字段',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父类id',
  `enable` int(11) DEFAULT NULL COMMENT '是否启用',
  `childer_id` varchar(4000) DEFAULT NULL COMMENT '所有菜单父类',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `udpate_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '账号',
  `alias_name` varchar(100) DEFAULT NULL COMMENT '别名',
  `pwd` varchar(200) DEFAULT NULL COMMENT '密码',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `udpate_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
