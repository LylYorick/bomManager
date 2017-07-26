/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : bom

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2017-07-17 13:43:32
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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

-- ----------------------------
-- Table structure for `tblmaterial`
-- ----------------------------
DROP TABLE IF EXISTS `tblmaterial`;
CREATE TABLE `tblmaterial` (
  `Partnumber` varchar(50) NOT NULL DEFAULT '' COMMENT '料号',
  `PartName` varchar(100) NOT NULL COMMENT '名称',
  `PartDesc` varchar(500) NOT NULL COMMENT '描述',
  `PartRev` varchar(10) NOT NULL COMMENT '版本',
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
  PRIMARY KEY (`Partnumber`,`PartRev`,`PartActive`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblmaterial
-- ----------------------------
INSERT INTO `tblmaterial` VALUES ('HT2016.01', '引导头', '顶阶产品', '001', 'Y', 'HT2016.01', '', '', '部件', '组装件', '台', '小时', '5', '100', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01', '位标器', '位标器', '001', 'Y', 'HT2016.01.01', '', '', '部件', '组装件', '台', '小时', '3', '80', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01', '陀螺', '陀螺', '001', 'Y', 'HT2016.01.01.01', '', '', '部件', '组装件', '个', '小时', '2.2', '30', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.01', '转子', '转子', '001', 'Y', 'HT2016.01.01.01.01', '', '', '部件', '组装件', '件', '小时', '0.5', '50', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.01.01', '壳体', '壳体', '001', 'Y', 'HT2016.01.01.01.01.01', '钛棒TC4-R锻', 'GB2965-96', '零件', '采购件', '个', '', '1', '500', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.01.02', '磁铁', '磁铁', '001', 'Y', 'HT2016.01.01.01.01.02', '铁铬钴合金', '', '零件', '采购件', '个', '', '1', '18', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02', '万向支架', '万向支架', '001', 'Y', 'HT2016.01.01.01.02', '', '', '部件', '组装件', '件', '小时', '2', '20', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02.01', '线束', '线束', '001', 'Y', 'HT2016.01.01.01.02.01', '', '', '部件', '组装件', '件', '小时', '0.5', '2.1', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02.01.01', '标牌', '标牌', '001', 'Y', 'HT2016.01.01.01.02.01.01', '新闻纸一号', 'GB1910-80', '零件', '采购件', '件', '', '1', '3', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02.03', '物镜', '物镜', '001', 'Y', 'HT2016.01.01.01.02.03', '', '', '部件', '组装件', '件', '小时', '0.7', '20', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02.03.01', '带环的探测器', '带环的探测器', '001', 'Y', 'HT2016.01.01.01.02.03.01', '', '', '部件', '组装件', '件', '小时', '0.7', '20', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02.03.01.01', '环', '环', '001', 'Y', 'HT2016.01.01.01.02.03.01.01', '黄铜棒HPb59-1', 'GB4425-84', '零件', '采购件', '件', '', '1', '13', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02.03.10', '盖', '盖', '001', 'Y', 'HT2016.01.01.01.02.03.10', '聚碳酸脂 一级品', 'GB2920-82', '零件', '采购件', '件', '', '1', '3', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.02.06', '万向支架座', '万向支架座', '001', 'Y', 'HT2016.01.01.01.02.06', '钛棒TC4-R锻', 'GB2965-96', '零件', '采购件', '件', '', '1', '200', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.11', '螺纹压圈', '螺纹压圈', '001', 'Y', 'HT2016.01.01.01.11', '黄铜棒Hpb59-1', 'GB4425-84', '零件', '采购件', '片', '', '1', '0.5', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.01.15', '垫片', '垫片', '001', 'Y', 'HT2016.01.01.01.15', '黄铜带H62-较高-Y', 'GB402-80', '零件', '采购件', '片', '', '1', '0.25', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.02', '线圈骨架', '线圈骨架', '001', 'Y', 'HT2016.01.01.02', '', '', '部件', '组装件', '个', '小时', '1.8', '10', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.02.01', '壳体', '壳体', '001', 'Y', 'HT2016.01.01.02.01', '酚醛玻璃纤维压塑料FX-530', 'WJ2124-93', '零件', '采购件', '件', '', '1', '30', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.02.02', '线圈', '线圈', '001', 'Y', 'HT2016.01.01.02.02', '漆包线QA-2-0.315', 'GB6109.4-85', '零件', '采购件', '个', '', '1', '6', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.03.01', '弹簧组件', '弹簧组件', '001', 'Y', 'HT2016.01.01.03.01', '', '', '部件', '组装件', '件', '小时', '2.2', '40', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.03.02.02', '安装套管', '安装套管', '001', 'Y', 'HT2016.01.01.03.02.02', '黄铜线HPb59-1-6级-Y', 'GB3112-82', '零件', '采购件', '件', '', '1', '10', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.03.04B', '夹圈', '夹圈', '001', 'Y', 'HT2016.01.01.03.04B', '铸铝ZL104', 'GB1173-86', '零件', '采购件', '件', '', '1', '20', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.01.35', '灰色环氧硝基磁漆', '灰色环氧硝基磁漆', '001', 'Y', 'HT2016.01.01.35', 'H04-2 I型  ', 'GJB348-87', '零件', '采购件', '千克', '', '1', '500', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.02', '电子舱', '电子舱', '001', 'Y', 'HT2016.01.02', '', '', '部件', '组装件', '台', '小时', '2', '60', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.02.01B', '底座', '底座', '001', 'Y', 'HT2016.01.02.01B', 'sad', '王企鹅', '零件', '采购件', '吨', '', '1', '2014', '外加工件', null, null, null, null, null, 'admin', '2017-07-10 22:58:17');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.02.02B', '拉圈', '拉圈', '001', 'Y', 'HT2016.01.02.02B', '06Cr19Ni10', 'GB/T4240-93', '零件', '采购件', '个', '', '1', '50', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03', '带插头的管壳', '带插头的管壳', '001', 'Y', 'HT2016.01.03', '', '', '部件', '组装件', '件', '小时', '1.5', '60', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.01', '整流罩滤光镜框', '整流罩滤光镜框', '001', 'Y', 'HT2016.01.03.01', '', '', '部件', '组装件', '件', '小时', '0.5', '80', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.01.02', '滤光镜组件', '滤光镜组件', '001', 'Y', 'HT2016.01.03.01.02', '', '', '部件', '组装件', '件', '小时', '2', '30', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.01.02.01', '干涉滤光镜', '干涉滤光镜', '001', 'Y', 'HT2016.01.03.01.02.01', '', '', '部件', '组装件', '件', '小时', '0.6', '20', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.01.02.01.01', '滤光镜', '滤光镜', '001', 'Y', 'HT2016.01.03.01.02.01.01', '玻璃  HWB 850 （上海有色玻璃厂）', '', '零件', '采购件', '件', '', '1', '30', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.01.03', '螺纹压圈', '螺纹压圈', '001', 'Y', 'HT2016.01.03.01.03', '铝棒 LC4-CS', 'GB3191-82', '零件', '采购件', '个', '', '1', '10', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.02', '线束', '线束', '001', 'Y', 'HT2016.01.03.02', '', '', '部件', '组装件', '件', '小时', '0.8', '30', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.02.01', '插头', '插头', '001', 'Y', 'HT2016.01.03.02.01', '', '', '部件', '组装件', '件', '小时', '2', '19', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.02.01.02', '酚醛玻璃纤维压塑料', '酚醛玻璃纤维压塑料', '001', 'Y', 'HT2016.01.03.02.01.02', 'FX-530', 'WJ2124-93', '零件', '采购件', '件', '', '1', '22', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.02.02', '接线柱', '接线柱', '001', 'Y', 'HT2016.01.03.02.02', '黄铜带H62-普通-M-0.3', 'GB2060-80', '零件', '采购件', '个', '', '1', '10', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.04', '管壳', '管壳', '001', 'Y', 'HT2016.01.03.04', '钛棒TC-R锻', 'GB3191-82', '零件', '采购件', '个', '', '1', '70', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.03.10', '氮气', '氮气', '001', 'Y', 'HT2016.01.03.10', '优级', 'GB8979-88', '零件', '采购件', '升', '', '1', '20', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.04.03-C', '安装体', '安装体', '001', 'Y', 'HT2016.01.04.03-C', '圆钢30GRMnSiA', 'GB/T3077-1999', '零件', '采购件', '件', '', '1', '80', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.05.04', '聚硫密封胶', '聚硫密封胶', '001', 'Y', 'HT2016.01.05.04', '', '', '零件', '采购件', '千克', '', '1', '1000', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.05B', '推杆', '推杆', '001', 'Y', 'HT2016.01.05B', '', '', '部件', '组装件', '件', '小时', '0.5', '50', '自组装件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.07', '壳体', '壳体', '001', 'Y', 'HT2016.01.07', '铝圆管LC4-CS', 'GB4437-84', '零件', '采购件', '个', '', '1', '350', '外加工件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.08', '密封圈', '密封圈', '001', 'Y', 'HT2016.01.08', '氟橡胶2460/硅氟橡胶（60140)', '', '零件', '采购件', '个', '', '1', '20', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.21', '胶', '胶', '001', 'Y', 'HT2016.01.21', 'FN-303胶粘剂', 'WJ1419-84', '零件', '采购件', '千克', '', '1', '900', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');
INSERT INTO `tblmaterial` VALUES ('HT2016.01.22', '密封胶', '密封胶', '001', 'Y', 'HT2016.01.22', '南大704胶', 'Q/KDI-84', '零件', '采购件', '千克', '', '1', '200', '外采购件', '', '', '', '', '', 'Ken Liu', '2017-05-18 15:00:00');

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
INSERT INTO `tblorder` VALUES ('XHH20170714152159', '机加定制', 'a', 'a', '1', 'a', 'a', '1993-01-13', 'a', 'a', 'a', '21.455', 'N', '已审核', '2017-07-16 23:19:11', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714153042', '机加定制', 'b', 'b', '1', 'b', 'b', '1234-09-01', '1', '1', '1', null, 'N', '已审核', '2017-07-16 23:20:45', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155646', 'PCB定制', '1', '1', '1', '1', '1', '1993-01-13', '1', '1', '1', null, 'N', '已审核', '2017-07-16 23:22:58', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155702', '定制采购', '2', '2', '2', '2', '2', '1234-09-01', '2', '2', '2', null, 'N', '已审核', '2017-07-16 23:23:40', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155723', '系统定制', '3', '3', '3', '3', '3', '1234-09-01', '3', '3', '3', '2121214.14', 'N', '已审核', '2017-07-17 10:35:34', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714155739', '个性定制', '4', '4', '4', '4', '4', '1234-09-01', '4', '4', '4', '21.45', 'N', '待审核', '2017-07-17 10:35:09', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170714165629', '机加定制', 'bb', '12', '232', '343', '343', '2017-08-08', '23122', '32131232', '132', '888', 'N', '待审核', '2017-07-17 10:35:07', 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tblorder` VALUES ('XHH20170716163356', '机加定制', '3', '4', '5', '5', '7', '2017-08-08', '8', '9', '10', '80', 'N', '待审核', '2017-07-17 10:35:05', 'admin', null, null, null, null, null, null, null, null, null, '李跃龙正式照.jpg');
INSERT INTO `tblorder` VALUES ('XHH20170716170049', '机加定制', 'test', 'test', '212121', '21545', '五七万', '2017-08-08', '1撒娇和', '13159823165', '12323', '8897', 'N', '待审核', '2017-07-17 10:35:03', 'admin', null, null, null, null, null, null, null, null, null, 'XHH20170716170049.jpg');

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
INSERT INTO `tblsupplier` VALUES ('HT2016.01.02.01B', '底座', '001', '大风厂', 'D11', '铝合金7075', 'GB/T16474-2001', '件', '28', 'N', null, null, 'admin', '2017-07-12 16:16:16');
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
INSERT INTO `tbluser` VALUES ('13159823165', '李跃', 'c4ca4238a0b923820dcc509a6f75849b', '13159823165', '中', '请问', '12321', '1', 'Y', '2017-07-01 14:02:27', null, null, null, '0', null, '李跃', '2017-07-01 02:27:59');
INSERT INTO `tbluser` VALUES ('admin', 'das', 'c4ca4238a0b923820dcc509a6f75849b', ' 123', '232', '232', '1', '5', 'Y', '2017-07-14 15:09:33', null, null, null, '0', null, '123213', '2017-07-01 01:53:24');
