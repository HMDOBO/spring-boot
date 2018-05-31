/*
Navicat MySQL Data Transfer

Source Server         : 192.168.25.201
Source Server Version : 50635
Source Host           : 192.168.25.201:3306
Source Database       : spring_boot_shiro

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2018-05-31 14:54:27
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
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态（0冻结 1正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of shiro_admin
-- ----------------------------
INSERT INTO `shiro_admin` VALUES ('1', 'zhangsan', '123456', '13333333333', '1');
INSERT INTO `shiro_admin` VALUES ('2', 'lisi', '123456', '15555555555', '1');

-- ----------------------------
-- Table structure for shiro_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_admin_role`;
CREATE TABLE `shiro_admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `admin_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户_角色表';

-- ----------------------------
-- Records of shiro_admin_role
-- ----------------------------
INSERT INTO `shiro_admin_role` VALUES ('1', '1', '2');

-- ----------------------------
-- Table structure for shiro_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permission`;
CREATE TABLE `shiro_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission_type` varchar(20) NOT NULL COMMENT '权限类型（菜单MENU，功能操作OPERATION）',
  `resource_id` int(11) NOT NULL COMMENT '资源权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of shiro_permission
-- ----------------------------
INSERT INTO `shiro_permission` VALUES ('1', 'MENU', '1');
INSERT INTO `shiro_permission` VALUES ('2', 'MENU', '2');
INSERT INTO `shiro_permission` VALUES ('3', 'MENU', '5');
INSERT INTO `shiro_permission` VALUES ('4', 'MENU', '6');
INSERT INTO `shiro_permission` VALUES ('5', 'MENU', '7');
INSERT INTO `shiro_permission` VALUES ('6', 'MENU', '9');
INSERT INTO `shiro_permission` VALUES ('7', 'MENU', '10');
INSERT INTO `shiro_permission` VALUES ('8', 'MENU', '12');
INSERT INTO `shiro_permission` VALUES ('9', 'MENU', '13');
INSERT INTO `shiro_permission` VALUES ('10', 'MENU', '14');
INSERT INTO `shiro_permission` VALUES ('11', 'MENU', '15');
INSERT INTO `shiro_permission` VALUES ('12', 'OPERATION', '1');
INSERT INTO `shiro_permission` VALUES ('13', 'OPERATION', '2');
INSERT INTO `shiro_permission` VALUES ('14', 'OPERATION', '3');
INSERT INTO `shiro_permission` VALUES ('15', 'OPERATION', '4');
INSERT INTO `shiro_permission` VALUES ('16', 'OPERATION', '5');
INSERT INTO `shiro_permission` VALUES ('17', 'OPERATION', '6');
INSERT INTO `shiro_permission` VALUES ('18', 'OPERATION', '7');
INSERT INTO `shiro_permission` VALUES ('19', 'OPERATION', '8');
INSERT INTO `shiro_permission` VALUES ('20', 'OPERATION', '9');
INSERT INTO `shiro_permission` VALUES ('21', 'OPERATION', '10');
INSERT INTO `shiro_permission` VALUES ('22', 'OPERATION', '11');
INSERT INTO `shiro_permission` VALUES ('23', 'OPERATION', '12');
INSERT INTO `shiro_permission` VALUES ('24', 'OPERATION', '13');
INSERT INTO `shiro_permission` VALUES ('25', 'OPERATION', '14');
INSERT INTO `shiro_permission` VALUES ('26', 'OPERATION', '15');
INSERT INTO `shiro_permission` VALUES ('27', 'OPERATION', '16');
INSERT INTO `shiro_permission` VALUES ('28', 'OPERATION', '17');
INSERT INTO `shiro_permission` VALUES ('29', 'OPERATION', '18');
INSERT INTO `shiro_permission` VALUES ('30', 'OPERATION', '19');
INSERT INTO `shiro_permission` VALUES ('31', 'OPERATION', '20');
INSERT INTO `shiro_permission` VALUES ('32', 'OPERATION', '21');
INSERT INTO `shiro_permission` VALUES ('33', 'OPERATION', '22');

-- ----------------------------
-- Table structure for shiro_resource_menu
-- ----------------------------
DROP TABLE IF EXISTS `shiro_resource_menu`;
CREATE TABLE `shiro_resource_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(50) NOT NULL COMMENT '菜单url',
  `parent_menu_id` int(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of shiro_resource_menu
-- ----------------------------
INSERT INTO `shiro_resource_menu` VALUES ('1', '首页菜单', '/index.html', '0');
INSERT INTO `shiro_resource_menu` VALUES ('2', '用户管理菜单', '/user/user.html', '0');
INSERT INTO `shiro_resource_menu` VALUES ('3', '商品管理菜单', '/item', '0');
INSERT INTO `shiro_resource_menu` VALUES ('4', '数码电子商品管理菜单', '/item/3c', '3');
INSERT INTO `shiro_resource_menu` VALUES ('5', '手机商品管理菜单', '/item/3c/phone.html', '4');
INSERT INTO `shiro_resource_menu` VALUES ('6', '电脑商品管理菜单', '/item/3c/computer.html', '4');
INSERT INTO `shiro_resource_menu` VALUES ('7', '衣装服饰商品管理菜单', '/item/dress/dress.html', '3');
INSERT INTO `shiro_resource_menu` VALUES ('8', '订单管理菜单', '/order', '0');
INSERT INTO `shiro_resource_menu` VALUES ('9', '在线支付订单菜单', '/order/online_pay.html', '8');
INSERT INTO `shiro_resource_menu` VALUES ('10', '货到付款订单菜单', '/order/offline_pay.html', '8');
INSERT INTO `shiro_resource_menu` VALUES ('11', '系统管理菜单', '/system', '0');
INSERT INTO `shiro_resource_menu` VALUES ('12', '管理员管理菜单', '/system/admin.html', '11');
INSERT INTO `shiro_resource_menu` VALUES ('13', '角色管理菜单', '/system/role.html', '11');
INSERT INTO `shiro_resource_menu` VALUES ('14', '权限管理菜单', '/system/permission.html', '11');
INSERT INTO `shiro_resource_menu` VALUES ('15', '个人信息菜单', '/personal/info.html', '0');

-- ----------------------------
-- Table structure for shiro_resource_operation
-- ----------------------------
DROP TABLE IF EXISTS `shiro_resource_operation`;
CREATE TABLE `shiro_resource_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operation_name` varchar(20) NOT NULL COMMENT '操作名称',
  `operation_code` varchar(20) NOT NULL COMMENT '操作编码，权限字符串',
  `url_prefix` varchar(50) DEFAULT NULL COMMENT '拦截URL前缀',
  `parent_operation_id` int(11) NOT NULL DEFAULT '0' COMMENT '父操作ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='功能操作表';

-- ----------------------------
-- Records of shiro_resource_operation
-- ----------------------------
INSERT INTO `shiro_resource_operation` VALUES ('1', '用户新增', 'user:create', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('2', '用户删除', 'user:delete', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('3', '用户修改', 'user:update', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('4', '用户查询', 'user:select', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('5', '商品新增', 'item:create', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('6', '商品删除', 'item:delete', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('7', '商品修改', 'item:update', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('8', '商品查询', 'item:select', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('9', '订单删除', 'order:delete', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('10', '订单修改', 'order:update', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('12', '订单查询', 'order:select', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('13', '系统管理员新增', 'sys:admin:create', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('14', '系统管理员删除', 'sys:admin:delete', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('15', '系统管理员修改', 'sys:admin:update', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('16', '系统管理员查询', 'sys:admin:select', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('17', '角色新增', 'sys:role:create', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('18', '角色删除', 'sys:role:delete', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('19', '角色修改', 'sys:role:update', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('20', '角色查看', 'sys:role:select', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('21', '个人信息修改', 'sys:info:update', null, '0');
INSERT INTO `shiro_resource_operation` VALUES ('22', '个人信息查询', 'sys:info:select', null, '0');

-- ----------------------------
-- Table structure for shiro_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(20) NOT NULL COMMENT '角色名',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色权限码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of shiro_role
-- ----------------------------
INSERT INTO `shiro_role` VALUES ('1', '系统管理员', 'admin');
INSERT INTO `shiro_role` VALUES ('2', '用户管理员', 'user_manager');
INSERT INTO `shiro_role` VALUES ('3', '商品管理员', 'item_manager');
INSERT INTO `shiro_role` VALUES ('4', '订单管理员', 'order_manager');

-- ----------------------------
-- Table structure for shiro_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色_权限表';

-- ----------------------------
-- Records of shiro_role_permission
-- ----------------------------
INSERT INTO `shiro_role_permission` VALUES ('1', '2', '1');
INSERT INTO `shiro_role_permission` VALUES ('2', '2', '2');
INSERT INTO `shiro_role_permission` VALUES ('3', '2', '12');
INSERT INTO `shiro_role_permission` VALUES ('4', '2', '13');
INSERT INTO `shiro_role_permission` VALUES ('5', '2', '14');
INSERT INTO `shiro_role_permission` VALUES ('6', '2', '15');
