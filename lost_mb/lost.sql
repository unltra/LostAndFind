/*
Navicat MySQL Data Transfer

Source Server         : linz86
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : lost

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-01-08 12:44:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lp_admin
-- ----------------------------
DROP TABLE IF EXISTS `lp_admin`;
CREATE TABLE `lp_admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(10) DEFAULT NULL,
  `apw` varchar(20) DEFAULT NULL,
  `apower` int(11) DEFAULT NULL,
  `atel` varchar(12) DEFAULT NULL,
  `aphone` varchar(11) DEFAULT NULL,
  `aqq` varchar(12) DEFAULT NULL,
  `amail` varchar(25) DEFAULT NULL,
  `acreatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lp_admin
-- ----------------------------
INSERT INTO `lp_admin` VALUES ('4', 'admin', 'admin', '55', '55', '55', '55', '11', '2017-11-17 19:45:09');
INSERT INTO `lp_admin` VALUES ('5', '222', '222', '222', '222', '222', '222', '222', '2017-11-17 19:45:09');
INSERT INTO `lp_admin` VALUES ('6', '111', '111', '1', '111', '111', '111', '111', '2017-11-17 19:45:09');
INSERT INTO `lp_admin` VALUES ('7', '55', '5', '55', '55', '55', '5', '55', '2017-11-17 19:51:47');
INSERT INTO `lp_admin` VALUES ('8', '123', '123', '1', '123', '123', '123', '123', '2017-11-17 20:33:47');

-- ----------------------------
-- Table structure for lp_kind
-- ----------------------------
DROP TABLE IF EXISTS `lp_kind`;
CREATE TABLE `lp_kind` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `a_kid` int(11) NOT NULL,
  `kname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lp_kind
-- ----------------------------
INSERT INTO `lp_kind` VALUES ('1', '0', '电子产品');
INSERT INTO `lp_kind` VALUES ('2', '0', '生活及运动用品');
INSERT INTO `lp_kind` VALUES ('3', '0', '现金及证件');
INSERT INTO `lp_kind` VALUES ('4', '0', '文具用品');
INSERT INTO `lp_kind` VALUES ('5', '0', '衣物及配件');
INSERT INTO `lp_kind` VALUES ('6', '0', '其它');
INSERT INTO `lp_kind` VALUES ('7', '1', 'U盘');
INSERT INTO `lp_kind` VALUES ('8', '1', '笔记本电脑');
INSERT INTO `lp_kind` VALUES ('9', '1', '相机');
INSERT INTO `lp_kind` VALUES ('10', '2', '水瓶');
INSERT INTO `lp_kind` VALUES ('11', '2', '眼镜');
INSERT INTO `lp_kind` VALUES ('12', '1', '耳机');
INSERT INTO `lp_kind` VALUES ('13', '2', '背包');
INSERT INTO `lp_kind` VALUES ('14', '2', '雨伞');
INSERT INTO `lp_kind` VALUES ('15', '2', '钥匙');
INSERT INTO `lp_kind` VALUES ('16', '2', '运动用品');
INSERT INTO `lp_kind` VALUES ('17', '1', '充电宝');
INSERT INTO `lp_kind` VALUES ('18', '1', '手机');
INSERT INTO `lp_kind` VALUES ('19', '6', '帽子');
INSERT INTO `lp_kind` VALUES ('20', '6', '手套');
INSERT INTO `lp_kind` VALUES ('21', '4', '文具');
INSERT INTO `lp_kind` VALUES ('22', '4', '书本');
INSERT INTO `lp_kind` VALUES ('23', '4', '本子');
INSERT INTO `lp_kind` VALUES ('24', '4', '其它');
INSERT INTO `lp_kind` VALUES ('25', '6', '其它');
INSERT INTO `lp_kind` VALUES ('26', '1', '其它');
INSERT INTO `lp_kind` VALUES ('27', '2', '其它');
INSERT INTO `lp_kind` VALUES ('28', '3', '其它');
INSERT INTO `lp_kind` VALUES ('29', '5', '其它');
INSERT INTO `lp_kind` VALUES ('30', '3', '餐卡');

-- ----------------------------
-- Table structure for lp_lostnotice
-- ----------------------------
DROP TABLE IF EXISTS `lp_lostnotice`;
CREATE TABLE `lp_lostnotice` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `kid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `lpic` varchar(50) DEFAULT NULL,
  `ldescri` varchar(50) DEFAULT NULL,
  `lplace` varchar(20) DEFAULT NULL,
  `ltime` date DEFAULT NULL,
  `loutstatus` int(1) DEFAULT '0',
  `lcreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`lid`),
  KEY `FK_lost_ad` (`aid`),
  KEY `FK_lost_user` (`uid`),
  KEY `FK_lost_classd` (`kid`),
  CONSTRAINT `FK_lost_ad` FOREIGN KEY (`aid`) REFERENCES `lp_admin` (`aid`),
  CONSTRAINT `FK_lost_classd` FOREIGN KEY (`kid`) REFERENCES `lp_kind` (`kid`),
  CONSTRAINT `FK_lost_user` FOREIGN KEY (`uid`) REFERENCES `lp_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lp_lostnotice
-- ----------------------------
INSERT INTO `lp_lostnotice` VALUES ('1', '1', '9', '4', '黑蛇书包', '123.jpg', '蛇皮', '111', '2017-12-04', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('2', '1', '9', '4', '书本', '123.jpg', '哪个卫视书籍', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('3', '1', '9', '4', '课本', '123.jpg', '多少级了咖啡机看来', '111', '2017-12-12', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('4', '1', '9', '4', '数据线', '123.jpg', '石达开交付海军', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('5', '1', '9', '4', '岛上书店', '123.jpg', '第三空间啊分开就到', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('6', '1', '9', '4', '一念永恒', '123.jpg', '的手机卡号', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('7', '1', '9', '4', '元尊', '123.jpg', '山东黄金刻录机啊', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('8', '1', '9', '4', '大道朝天', '123.jpg', '收到货看见啊', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('9', '1', '9', '4', '不朽凡人', '123.jpg', '大家欧克', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('10', '1', '9', '4', '剑来', '123.jpg', '市静安好了', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('11', '1', '9', '4', '斗罗大陆', '123.jpg', '大神快来减肥', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('12', '1', '9', '4', '诛仙', '123.jpg', '阿萨德昆仑决hi乱', '111', '2017-12-07', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('13', '9', '9', '4', '笔记本', '123.jpg', '三大航空链接啊', '111', '2017-12-12', '0', '2017-12-01 16:32:38');
INSERT INTO `lp_lostnotice` VALUES ('17', '9', '16', '4', '道德经', '70e9d317-d227-462f-af28-945c9ff35623.gif', '按时打卡了几分活力', '666', '2018-01-26', '0', '2018-01-06 22:07:42');
INSERT INTO `lp_lostnotice` VALUES ('18', '9', '14', '4', '金刚经', '74654e41-79db-4ef5-b275-97939cd5cb09.jpg', 'of代刷卡缴费', '666', '2017-11-11', '0', '2018-01-06 22:25:59');
INSERT INTO `lp_lostnotice` VALUES ('19', '9', '3', '4', 'id card', '0b8da0fa-f7c2-4256-98f2-2fe1d932d0a4.jpg', '回答看世界航空', 'nb222', '2017-11-11', '0', '2018-01-06 22:50:25');
INSERT INTO `lp_lostnotice` VALUES ('20', '9', '7', '4', 'U盘', '00093334-7b6a-4004-afe3-acb38cd445eb.jpg', '金士顿黑色16G', 'sl607', '2017-11-11', '0', '2018-01-08 11:22:21');

-- ----------------------------
-- Table structure for lp_pick
-- ----------------------------
DROP TABLE IF EXISTS `lp_pick`;
CREATE TABLE `lp_pick` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `kid` int(11) DEFAULT NULL,
  `pname` varchar(30) DEFAULT NULL,
  `ppic` varchar(50) DEFAULT 'default.jpg',
  `pdescri` varchar(50) DEFAULT NULL,
  `pplace` varchar(20) DEFAULT NULL,
  `ptime` date DEFAULT NULL,
  `ppersoninf` varchar(50) DEFAULT NULL,
  `pnowplace` varchar(20) DEFAULT NULL,
  `poutstatus` int(1) DEFAULT '1',
  `pownstatus` int(1) DEFAULT '0',
  `pcreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`),
  KEY `FK_pick_ad` (`aid`),
  KEY `FK_pick_classd` (`kid`),
  CONSTRAINT `FK_pick_ad` FOREIGN KEY (`aid`) REFERENCES `lp_admin` (`aid`),
  CONSTRAINT `FK_pick_classd` FOREIGN KEY (`kid`) REFERENCES `lp_kind` (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lp_pick
-- ----------------------------
INSERT INTO `lp_pick` VALUES ('1', '4', '16', '一个人', '58221602_p0.jpg', '爱花一枚', 'nb222', '2017-11-08', '111', '微校园', '0', '0', '2017-11-08 19:59:56');
INSERT INTO `lp_pick` VALUES ('9', '5', '17', '黑色大衣', '58221602_p0.jpg', '亮黑色，带白色icon', '北操场', '2018-01-09', '111', '微校园', '1', '0', '2018-01-01 19:04:54');
INSERT INTO `lp_pick` VALUES ('10', '4', '14', '绿色帽子', '24e95585-6569-403c-91ff-7577ac93bda1.jpg', '圣诞帽', 'sb111', '2017-01-16', '666', '微校园', '1', '0', '2018-01-01 19:16:20');
INSERT INTO `lp_pick` VALUES ('11', '5', '15', 'SanDisk', '9d239ea7-e9d9-4943-a083-53e77a1ba53b.jpg', '32G，银色', 'sc222', '2018-01-03', '555', '微校园', '1', '0', '2018-01-01 19:16:59');
INSERT INTO `lp_pick` VALUES ('12', '6', '12', '罗技鼠标', 'default.jpg', '红色，无线', 'nc103', '2018-01-02', '111', '微校园', '1', '0', '2018-01-01 19:21:06');
INSERT INTO `lp_pick` VALUES ('13', '4', '12', '白色围巾', 'default.jpg', '有个松鼠图案', 'nb208', '2017-06-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');
INSERT INTO `lp_pick` VALUES ('14', '4', '12', '计算机组成原理课本', 'default.jpg', 'nb大厅', 'nb大厅', '2017-05-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');
INSERT INTO `lp_pick` VALUES ('15', '4', '12', '操作系统书', 'default.jpg', '英文版', 'sl607', '2017-03-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');
INSERT INTO `lp_pick` VALUES ('16', '4', '12', '羽博充电宝', 'default.jpg', '1000mah', '通用楼', '2017-05-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');
INSERT INTO `lp_pick` VALUES ('17', '4', '12', '口红', 'default.jpg', '斩男色', 'sl403', '2016-01-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');
INSERT INTO `lp_pick` VALUES ('18', '4', '12', '白色情侣杯', 'default.jpg', '两个，一男一女', 'sa102', '2017-10-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');
INSERT INTO `lp_pick` VALUES ('19', '4', '12', '数据线黑色', 'default.jpg', '苹果', 'na302', '2017-08-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');
INSERT INTO `lp_pick` VALUES ('20', '4', '12', '黑蛇书包', 'default.jpg', '里面', '老食堂', '2017-11-16', '111', '微校园', '1', '0', '2018-01-02 19:12:18');

-- ----------------------------
-- Table structure for lp_user
-- ----------------------------
DROP TABLE IF EXISTS `lp_user`;
CREATE TABLE `lp_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) NOT NULL,
  `stuid` varchar(10) DEFAULT NULL,
  `upw` varchar(20) NOT NULL,
  `uphone` varchar(11) DEFAULT NULL,
  `uqq` varchar(12) DEFAULT NULL,
  `umail` varchar(25) DEFAULT NULL,
  `uaddress` varchar(50) DEFAULT NULL,
  `ucreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lp_user
-- ----------------------------
INSERT INTO `lp_user` VALUES ('1', '石昊', '3150407888', '1111', '13060328581', '166666', '11231234@qq.com', '12131', '2017-11-17 19:26:53');
INSERT INTO `lp_user` VALUES ('5', '林一', '3150407000', '456', '123', '465', '465', '465', '2017-11-17 20:08:34');
INSERT INTO `lp_user` VALUES ('8', '牧尘', '3150407666', 'mu123', '1562356', '23123', '65456456', '46465465', '2017-12-10 21:28:24');
INSERT INTO `lp_user` VALUES ('9', '123', '3150407145', '123', '15060326666', '965993256', '12294@qq.com', '宁波理工', '2018-01-02 20:59:21');
INSERT INTO `lp_user` VALUES ('10', '123', '', '666', '', '', '', '', '2018-01-02 22:15:29');
INSERT INTO `lp_user` VALUES ('11', 'qw666', null, 'qw222', '15659393690', null, '1221@qq.com', null, '2018-01-05 16:37:24');
INSERT INTO `lp_user` VALUES ('12', 'linz86', null, 'linz86', '15659396906', null, '1@qq.com', null, '2018-01-05 16:42:15');
INSERT INTO `lp_user` VALUES ('13', 'linz86123', '3150407145', 'linz86123', '15659396906', null, '2111@qq.com', null, '2018-01-05 20:09:24');
