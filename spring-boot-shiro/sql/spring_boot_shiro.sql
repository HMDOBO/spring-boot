/*
Navicat MySQL Data Transfer

Source Server         : 192.168.25.201
Source Server Version : 50635
Source Host           : 192.168.25.201:3306
Source Database       : spring_boot_shiro

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2018-05-24 17:24:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shiro_admin
-- ----------------------------
DROP TABLE IF EXISTS `shiro_admin`;
CREATE TABLE `shiro_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `status` bigint(1) NOT NULL DEFAULT '1' COMMENT '状态（0冻结 1正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of shiro_admin
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_admin_role`;
CREATE TABLE `shiro_admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_角色表';

-- ----------------------------
-- Records of shiro_admin_role
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(20) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of shiro_role
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色_权限表';

-- ----------------------------
-- Records of shiro_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_sys_permission`;
CREATE TABLE `shiro_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission_type` varchar(20) NOT NULL COMMENT '权限类型（菜单MENU，功能操作OPERATION）',
  `resource_id` int(11) NOT NULL COMMENT '资源权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of shiro_sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_sys_resource_menu
-- ----------------------------
DROP TABLE IF EXISTS `shiro_sys_resource_menu`;
CREATE TABLE `shiro_sys_resource_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(50) NOT NULL COMMENT '菜单url',
  `parent_menu_id` int(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of shiro_sys_resource_menu
-- ----------------------------

-- ----------------------------
-- Table structure for shiro_sys_resource_operation
-- ----------------------------
DROP TABLE IF EXISTS `shiro_sys_resource_operation`;
CREATE TABLE `shiro_sys_resource_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operation_name` varchar(20) NOT NULL COMMENT '操作名称',
  `operation_code` varchar(20) NOT NULL COMMENT '操作编码，权限字符串',
  `url_prefix` varchar(50) DEFAULT NULL COMMENT '拦截URL前缀',
  `parent_operation_id` int(11) NOT NULL DEFAULT '0' COMMENT '父操作ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能操作表';

-- ----------------------------
-- Records of shiro_sys_resource_operation
-- ----------------------------
