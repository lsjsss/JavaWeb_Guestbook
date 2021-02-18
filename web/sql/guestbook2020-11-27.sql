/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : guestbook

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-11-27 11:31:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言Id',
  `user_id` int(11) DEFAULT NULL COMMENT '留言用户id',
  `title` varchar(200) DEFAULT NULL COMMENT '留言的标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '留言内容',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '留言日期',
  `can_comment` varchar(2) DEFAULT NULL COMMENT '是否能够评论，0：可以，1：不可以',
  `pid` int(11) DEFAULT NULL COMMENT '当前留言所评论的留言Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `sys_role` VALUES ('2', 'register', '注册用户');
INSERT INTO `sys_role` VALUES ('3', 'aaa', 'aaa');
INSERT INTO `sys_role` VALUES ('4', 'bbb', 'bbb');
INSERT INTO `sys_role` VALUES ('5', 'ccc', 'ccc');
INSERT INTO `sys_role` VALUES ('6', 'ddd', 'ddd');
INSERT INTO `sys_role` VALUES ('7', 'dddd', 'ddd');
INSERT INTO `sys_role` VALUES ('8', 'test', 'test');
INSERT INTO `sys_role` VALUES ('9', 'fff', 'fff');
INSERT INTO `sys_role` VALUES ('10', 'ggg', 'ggg');
INSERT INTO `sys_role` VALUES ('11', 'hhh', 'hhh');
INSERT INTO `sys_role` VALUES ('12', 'kkk', 'kkk');
INSERT INTO `sys_role` VALUES ('13', 'kkkk', 'kkkk');
INSERT INTO `sys_role` VALUES ('14', 'kkkkk', 'kkkkk');
INSERT INTO `sys_role` VALUES ('17', 'kkkkk', 'kkkkk');
INSERT INTO `sys_role` VALUES ('18', 'kkkkk', 'kkkkk');
INSERT INTO `sys_role` VALUES ('20', 'kkkkk', 'kkkkk');
INSERT INTO `sys_role` VALUES ('21', 'test', 'test');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ju',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名称',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `status` varchar(2) DEFAULT NULL COMMENT '用户状态，0为正常状态，1为禁言状态',
  `role_id` int(11) DEFAULT NULL COMMENT '角色编号',
  `img` varchar(200) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  KEY `user_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'tom', '123456', '0', '1', '');
INSERT INTO `sys_user` VALUES ('2', 'Alice', 'alice', '123456', '0', '2', '');
INSERT INTO `sys_user` VALUES ('3', 'Mike', 'little mike', '123456', '0', '2', '');
