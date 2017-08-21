/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : bom

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2017-08-21 10:14:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tblbom`
-- ----------------------------
DROP TABLE IF EXISTS `tblbom`;
CREATE TABLE `tblbom` (
  `Top_Partnumber` varchar(50) NOT NULL,
  `Top_Name` varchar(100) DEFAULT NULL,
  `PartNumber` varchar(50) NOT NULL,
  `PartName` varchar(100) NOT NULL,
  `F_Partnumber` varchar(50) NOT NULL DEFAULT '',
  `F_name` varchar(100) DEFAULT NULL,
  `Secq` int(11) DEFAULT NULL,
  `UseQty` double DEFAULT NULL,
  `Editor` varchar(255) DEFAULT NULL,
  `Datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Top_Partnumber`,`F_Partnumber`,`PartNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblbom
-- ----------------------------
INSERT INTO `tblbom` VALUES ('HT2016.01', '引导头', 'HT2016.01', '引导头', 'HT2016.01', '引导头', '1', '200', 'admin', '2017-08-02 11:04:00');
INSERT INTO `tblbom` VALUES ('HT2016.01', '引导头', 'HT2016.01.02', '电子舱', 'HT2016.01', '引导头', '2', '200', 'admin', '2017-08-07 14:19:55');
INSERT INTO `tblbom` VALUES ('HT2016.02', 'd头', 'HT2016.02', 'd头', 'HT2016.02', 'd头', '1', '200', 'admin', '2017-08-02 11:04:00');

-- ----------------------------
-- Table structure for `tblinventory`
-- ----------------------------
DROP TABLE IF EXISTS `tblinventory`;
CREATE TABLE `tblinventory` (
  `Partnumber` varchar(50) NOT NULL DEFAULT '',
  `PartName` varchar(100) DEFAULT NULL,
  `PartRev` varchar(10) NOT NULL DEFAULT '',
  `SupplierName` varchar(50) NOT NULL DEFAULT '',
  `PartUnit` varchar(10) DEFAULT NULL,
  `I_Qty` varchar(100) DEFAULT NULL,
  `M_Editor` varchar(50) DEFAULT NULL,
  `M_Datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Partnumber`,`PartRev`,`SupplierName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tblinventory
-- ----------------------------
INSERT INTO `tblinventory` VALUES ('21454', '桌子', '002', '烤鸭场', '件', '3399', 'admin', '2017-08-21 09:50:51');
INSERT INTO `tblinventory` VALUES ('HT2016.01.02.01B', '底座', '001', '小风厂', '吨', '1197', 'admin', '2017-07-13 21:06:57');

-- ----------------------------
-- Table structure for `tblinvlog`
-- ----------------------------
DROP TABLE IF EXISTS `tblinvlog`;
CREATE TABLE `tblinvlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Partnumber` varchar(50) NOT NULL DEFAULT '',
  `PartName` varchar(100) DEFAULT NULL,
  `PartRev` varchar(10) NOT NULL DEFAULT '',
  `SupplierName` varchar(50) NOT NULL DEFAULT '',
  `PartUnit` varchar(50) DEFAULT NULL,
  `Qty` double DEFAULT NULL,
  `M_IO` varchar(1) DEFAULT NULL,
  `OrderNumber` varchar(100) DEFAULT NULL,
  `Editor` varchar(50) DEFAULT NULL,
  `Datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tblinvlog
-- ----------------------------
INSERT INTO `tblinvlog` VALUES ('1', 'aaaaaa', '电阻', '001', '打', '个', '10', 'I', 'AABBCC', 'Ken Liu', '2017-07-13 20:00:23');
INSERT INTO `tblinvlog` VALUES ('2', 'bbb', '电阻', '002', '', '个', '11', 'I', 'AABBCC', 'Ken Liu', '2017-05-23 16:00:00');
INSERT INTO `tblinvlog` VALUES ('3', 'ccc', '电阻', '003', '', '个', '12', 'I', 'AABBCC', 'Ken Liu', '2017-05-24 16:00:00');
INSERT INTO `tblinvlog` VALUES ('4', 'www', '电阻', '004', '', '个', '13', 'I', 'AABBCC', 'Ken Liu', '2017-05-25 16:00:00');
INSERT INTO `tblinvlog` VALUES ('5', 'dwww', '电阻', '005', '', '个', '14', 'I', 'AABBCC', 'Ken Liu', '2017-05-26 16:00:00');
INSERT INTO `tblinvlog` VALUES ('6', 'HT2016.01.02.01B', null, '001', '小风厂', '吨', '232', 'I', '2014', 'admin', '2017-07-13 20:12:34');
INSERT INTO `tblinvlog` VALUES ('7', 'HT2016.01.02.01B', null, '001', '小风厂', '吨', '213', 'I', '232132', 'admin', '2017-07-13 20:36:05');
INSERT INTO `tblinvlog` VALUES ('8', 'HT2016.01.02.01B', null, '001', '小风厂', '吨', '213', 'I', '232132', 'admin', '2017-07-13 20:36:56');
INSERT INTO `tblinvlog` VALUES ('9', 'HT2016.01.02.01B', '', '001', '大风厂', '克', '120', 'I', '154', 'admin', '2017-07-13 20:45:18');
INSERT INTO `tblinvlog` VALUES ('10', 'HT2016.01.02.01B', '底座', '001', '小风厂', '吨', '1', 'I', '23213', 'admin', '2017-07-13 20:50:41');
INSERT INTO `tblinvlog` VALUES ('11', 'HT2016.01.02.01B', '底座', '001', '小风厂', '吨', '454', 'I', '2323212', 'admin', '2017-07-13 20:53:14');
INSERT INTO `tblinvlog` VALUES ('12', 'HT2016.01.02.01B', '底座', '001', '小风厂', '吨', '21125', 'I', '2123124', 'admin', '2017-07-13 21:06:57');
INSERT INTO `tblinvlog` VALUES ('13', 'HT2016.01.02.01B', '底座', '001', '小风厂', '吨', '1', 'O', '1232', 'admin', '2017-07-13 21:42:05');
INSERT INTO `tblinvlog` VALUES ('14', 'HT2016.01.02.01B', '底座', '001', '小风厂', '321', '232', 'O', '21', 'admin', '2017-07-13 21:43:30');
INSERT INTO `tblinvlog` VALUES ('15', 'HT2016.01.02.01B', '底座', '001', '小风厂', '45456', '20015', 'O', '232', 'admin', '2017-07-13 21:45:33');
INSERT INTO `tblinvlog` VALUES ('16', 'HT2016.01.02.01B', '底座', '001', '小风厂', '232', '11', 'O', '232', 'admin', '2017-07-13 21:46:27');
INSERT INTO `tblinvlog` VALUES ('17', 'HT2016.01.02.01B', '底座', '001', '小风厂', '吨', '123', 'O', '232', 'admin', '2017-07-13 21:46:54');
INSERT INTO `tblinvlog` VALUES ('18', '21454', '桌子', '002', '烤鸭场', '件', '120', 'I', '424477', 'admin', '2017-08-21 09:43:33');
INSERT INTO `tblinvlog` VALUES ('19', '21454', '桌子', '002', '烤鸭场', '吨', '2212', 'I', '454545', 'admin', '2017-08-21 09:43:57');
INSERT INTO `tblinvlog` VALUES ('20', '21454', '桌子', '002', '烤鸭场', '444a', '1111', 'I', '11', 'admin', '2017-08-21 09:50:51');
INSERT INTO `tblinvlog` VALUES ('21', '21454', '桌子', '002', '烤鸭场', '777', '44', 'O', '44', 'admin', '2017-08-21 09:52:55');

-- ----------------------------
-- Table structure for `tblmaterial`
-- ----------------------------
DROP TABLE IF EXISTS `tblmaterial`;
CREATE TABLE `tblmaterial` (
  `Partnumber` varchar(50) NOT NULL DEFAULT '' COMMENT '料号',
  `PartName` varchar(100) NOT NULL COMMENT '名称',
  `PartDesc` varchar(500) NOT NULL COMMENT '描述',
  `PartActive` varchar(1) NOT NULL DEFAULT '' COMMENT '料号有效',
  `TuNumber` varchar(100) DEFAULT NULL COMMENT '图样代号',
  `PartSpec` varchar(200) DEFAULT NULL COMMENT '材料规格',
  `PartStandard` varchar(200) DEFAULT NULL COMMENT '执行标准',
  `PartModel` varchar(10) DEFAULT NULL COMMENT '零件or部件',
  `PartType` varchar(50) DEFAULT NULL COMMENT '类型',
  `PartUnit` varchar(10) DEFAULT NULL COMMENT '单位',
  `PartCost` varchar(10) DEFAULT NULL COMMENT '成本单位',
  `PartQty` double DEFAULT NULL COMMENT '成本数量',
  `PartPrice` double DEFAULT NULL COMMENT '单价',
  `PartRemark` varchar(500) DEFAULT NULL COMMENT '备注',
  `temp1` varchar(100) DEFAULT NULL COMMENT '预留栏位',
  `temp2` varchar(100) DEFAULT NULL COMMENT '预留栏位',
  `temp3` varchar(100) DEFAULT NULL COMMENT '预留栏位',
  `temp4` varchar(100) DEFAULT NULL COMMENT '预留栏位',
  `temp5` varchar(100) DEFAULT NULL COMMENT '预留栏位',
  `Editor` varchar(50) DEFAULT NULL COMMENT '编辑人',
  `Datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`Partnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblmaterial
-- ----------------------------
INSERT INTO `tblmaterial` VALUES ('2121', '凳子', '*描述：', 'Y', '*图样代号：', '*材料规格：', '*执行标准：', '部件', '*执行标准：', '*单位：', '小时', '41', '22', '22', null, null, null, null, null, 'admin', '2017-08-20 20:01:39');
INSERT INTO `tblmaterial` VALUES ('21454', '桌子', '四方桌', 'Y', '0014', '供应商', '供应商', '零件', '类型', '111', '112', '1', '111', '*备注', null, null, null, null, null, 'admin', '2017-08-20 19:53:32');
INSERT INTO `tblmaterial` VALUES ('4544', '火柴', '火柴', 'Y', '火柴', '火柴', '火柴', '零件', '火柴', '火柴', '火柴', '1', '45', '火柴', null, null, null, null, null, 'admin', '2017-08-20 20:03:08');
INSERT INTO `tblmaterial` VALUES ('HT2016.01', '引导头', '顶阶产品', 'Y', 'HT2016.01', '55', '455', '部件', '组装件', '台', '小时', '5', '100', '自组装件', null, null, null, null, null, 'admin', '2017-08-20 19:48:57');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01', '位标器', '位标器', 'Y', 'HT2016.01.01', '', '', '部件', '组装件', '台', '小时', '3', '80', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01', '陀螺', '陀螺', 'Y', 'HT2016.01.01.01', '', '', '零件', '组装件', '个', '52', '1', '30', '自组装件', null, null, null, null, null, 'admin', '2017-08-20 19:49:24');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.02', '线圈骨架', '线圈骨架', 'Y', 'HT2016.01.01.02', '', '', '部件', '组装件', '个', '小时', '1.8', '0.22', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-08-14 18:17:50');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.02', '电子舱', '电子舱', 'Y', 'HT2016.01.02', '', '', '部件', '组装件', '台', '小时', '2', '60', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03', '带插头的管壳', '带插头的管壳', 'Y', 'HT2016.01.03', '', '', '部件', '组装件', '件', '小时', '1.5', '60', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');

-- ----------------------------
-- Table structure for `tblorder`
-- ----------------------------
DROP TABLE IF EXISTS `tblorder`;
CREATE TABLE `tblorder` (
  `OrderNumber` varchar(50) NOT NULL DEFAULT '',
  `OrderMode` varchar(50) DEFAULT NULL,
  `OrderName` varchar(50) DEFAULT NULL,
  `OrderType` varchar(50) DEFAULT NULL,
  `OrderQty` double DEFAULT NULL,
  `OrderMaterial` varchar(50) DEFAULT NULL,
  `OrderDesc` varchar(500) DEFAULT NULL,
  `ReqDate` date DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `CellPhone` varchar(50) DEFAULT NULL,
  `Address` varchar(500) DEFAULT NULL,
  `OrderPrice` double DEFAULT NULL,
  `OrderConfirm` varchar(1) DEFAULT NULL,
  `OrderStatus` varchar(50) DEFAULT NULL,
  `VerifyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `VerifyBy` varchar(20) DEFAULT NULL,
  `confirmTime` timestamp NULL DEFAULT NULL,
  `confirmBy` varchar(20) DEFAULT NULL,
  `Delivered` varchar(1) DEFAULT NULL,
  `DeliveryTime` timestamp NULL DEFAULT NULL,
  `Payment` double DEFAULT NULL,
  `PayWay` varchar(20) DEFAULT NULL,
  `Paid` varchar(1) DEFAULT NULL,
  `Express` varchar(20) DEFAULT NULL,
  `ExpressNum` varchar(20) DEFAULT NULL,
  `FileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`OrderNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblorder
-- ----------------------------
INSERT INTO `tblorder` VALUES ('XHH20170714152159', '机加定制', 'a', 'a', '1', 'a', 'a', '1993-01-13', 'a', 'a', 'a', '21.455', 'N', '已审核', '2017-07-17 16:38:58', 'admin', '2017-07-28 16:37:06', 'confirmby', 'd', '2017-07-22 16:37:41', '1', 'payway', 'p', 'express', 'exNum', 'wqw1');
INSERT INTO `tblorder` VALUES ('XHH20170714153042', '机加定制', 'b', 'b', '1', 'b', 'b', '1234-09-01', '1', '1', '1', null, 'N', '已审核', '2017-07-16 23:20:45', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155646', 'PCB定制', '1', '1', '1', '1', '1', '1993-01-13', '1', '1', '1', null, 'N', '已审核', '2017-07-16 23:22:58', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155702', '定制采购', '2', '2', '2', '2', '2', '1234-09-01', '2', '2', '2', null, 'N', '已审核', '2017-07-16 23:23:40', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155723', '系统定制', '3', '3', '3', '3', '3', '1234-09-01', '3', '3', '3', '2121214.14', 'Y', '已确认', '2017-07-17 10:35:34', 'admin', '2017-07-24 15:36:46', 'admin', null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155739', '个性定制', '4', '4', '4', '4', '4', '1234-09-01', '4', '4', '4', '21.45', 'N', '待审核', '2017-07-17 10:35:09', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714165629', '机加定制', 'bb', '12', '232', '343', '343', '2017-08-08', '23122', '32131232', '132', '888', 'N', '待审核', '2017-07-17 10:35:07', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170716163356', '机加定制', '3', '4', '5', '5', '7', '2017-08-08', '8', '9', '10', '80', 'N', '待审核', '2017-07-17 10:35:05', 'admin', null, null, null, null, null, null, null, null, null, '李跃龙正式照.jpg');
INSERT INTO `tblorder` VALUES ('XHH20170716170049', '机加定制', 'test ', 'test', '212121', '21545', '五七万', '2017-08-10', '1撒娇和', '13159823165', '12323', null, 'Y', '已确认', '2017-07-17 10:35:03', 'admin', '2017-07-19 21:22:29', 'admin', null, null, null, null, null, null, null, 'XHH20170716170049.jpg');
INSERT INTO `tblorder` VALUES ('XHH20170719152339', '定制采购', '呜呜 ', '呜呜', '778', '呜呜', '呜呜', '2017-07-06', '呜呜', '呜呜', '呜呜', null, 'Y', '已确认', null, null, '2017-07-24 11:12:10', 'admin', 'Y', '2017-07-13 00:00:00', '201177', '支付宝', 'Y', '空运', '121214', null);
INSERT INTO `tblorder` VALUES ('XHH20170724154211', '机加定制', '李', '跃', '1214', '龙', 'as大家好', '2017-07-06', '13159823165', '13159823165', '12321', '50', 'Y', '已确认', '2017-07-24 15:43:55', '13159823165', '2017-07-24 15:44:03', '13159823165', null, null, null, null, null, null, null, 'XHH20170724154211.jpg');
INSERT INTO `tblorder` VALUES ('XHH20170801184121', '机加定制', '零件名称', '机械加工', '123', '材料型号', '其他具体要求', '2017-08-10', 'das', '12321', '1', null, 'N', '待审核', null, null, null, null, null, null, null, null, null, null, null, 'XHH20170801184121.jpg');
INSERT INTO `tblorder` VALUES ('XHH20170801190818', '机加定制', '输入零件名称或项目名称', '输入零件名称或项目名称', '21.16', '输入零件名称或项目名称', '输入零件名称或项目名称', '2017-08-09', 'das', '12313212', '1', null, 'N', '待审核', null, null, null, null, null, null, null, null, null, null, null, 'XHH20170801190818.docx');

-- ----------------------------
-- Table structure for `tblsupplier`
-- ----------------------------
DROP TABLE IF EXISTS `tblsupplier`;
CREATE TABLE `tblsupplier` (
  `Partnumber` varchar(50) NOT NULL DEFAULT '',
  `PartName` varchar(100) NOT NULL,
  `PartRev` varchar(100) NOT NULL DEFAULT '',
  `supplierName` varchar(100) NOT NULL,
  `supplierCode` varchar(100) DEFAULT NULL,
  `partStandard` varchar(200) DEFAULT NULL,
  `partSpec` varchar(200) DEFAULT NULL,
  `partUnit` varchar(10) DEFAULT NULL,
  `partPrice` double DEFAULT NULL,
  `partActive` varchar(1) DEFAULT NULL,
  `S_Temp1` varchar(100) DEFAULT NULL,
  `S_Temp2` double(100,0) DEFAULT NULL,
  `Editor` varchar(50) DEFAULT NULL,
  `Datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Partnumber`,`PartRev`,`supplierName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblsupplier
-- ----------------------------
INSERT INTO `tblsupplier` VALUES ('21454', '桌子', '002', '烤鸭场', '002', '烤鸭场', '烤鸭场', '500', '20', 'N', null, null, 'admin', '2017-08-20 21:39:54');
INSERT INTO `tblsupplier` VALUES ('21454', '桌子', '01', '火鸡场', '01', '供应商', '供应商', '111', '111', 'Y', null, null, 'admin', '2017-08-20 21:39:54');
INSERT INTO `tblsupplier` VALUES ('HT2016.01.02.01B', '底座', '001', '小风厂', 'D12', '铝合金6061', 'GB/T16474-2001', '卡', '280', 'N', null, null, 'admin', '2017-07-12 16:18:22');
INSERT INTO `tblsupplier` VALUES ('HT2016.01.02.01B', '545', '001', '龙卷风厂', '20134', '王企鹅', 'sad', '吨', '2014', 'Y', null, null, 'admin', '2017-07-12 15:43:35');

-- ----------------------------
-- Table structure for `tbluser`
-- ----------------------------
DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE `tbluser` (
  `U_Number` varchar(20) NOT NULL,
  `U_Name` varchar(20) NOT NULL,
  `U_Password` varchar(50) NOT NULL,
  `U_Phone` varchar(50) DEFAULT NULL,
  `U_Title` varchar(20) DEFAULT NULL,
  `U_Comany` varchar(50) DEFAULT NULL,
  `U_Address` varchar(500) DEFAULT NULL,
  `U_Level` int(11) DEFAULT NULL COMMENT '1/2/3/4/5',
  `U_Active` varchar(1) DEFAULT NULL,
  `U_CreateDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `U_Temp1` varchar(50) DEFAULT NULL,
  `U_Temp2` varchar(50) DEFAULT NULL,
  `U_Temp3` varchar(50) DEFAULT NULL,
  `U_Temp4` double NOT NULL,
  `U_Temp5` timestamp NULL DEFAULT NULL,
  `Editor` varchar(50) DEFAULT NULL,
  `Datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`U_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbluser
-- ----------------------------
INSERT INTO `tbluser` VALUES ('13159823165', '李跃', 'c4ca4238a0b923820dcc509a6f75849b', '13159823165', '中', '请问', '12321', '3', 'Y', '2017-07-27 10:53:33', null, null, null, '0', null, '李跃', '2017-07-27 10:53:33');
INSERT INTO `tbluser` VALUES ('admin', 'das', 'c4ca4238a0b923820dcc509a6f75849b', ' 123', '232', '232', '1', '5', 'Y', '2017-08-14 15:52:24', null, null, null, '0', null, '123213', '2017-07-01 01:53:24');
