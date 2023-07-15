/*
 Navicat Premium Data Transfer

 Source Server         : bj-cynosdbmysql-grp-cf914sze.sql.tencentcdb.com_23116
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : bj-cynosdbmysql-grp-cf914sze.sql.tencentcdb.com:23116
 Source Schema         : cupk-group06

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 15/07/2023 23:57:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `eval_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `scheme_id` bigint(20) NOT NULL COMMENT '评价方案id',
  `indicator_id` bigint(20) NOT NULL COMMENT '客制化指标id',
  `cust_weight` float DEFAULT NULL COMMENT '客制化指标权重',
  `create_user` bigint(20) NOT NULL COMMENT '创建人员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新人员',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`eval_id`),
  KEY `scheme_id` (`scheme_id`) USING BTREE,
  KEY `indicator_id` (`indicator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
BEGIN;
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (2, 1, 1, 10, 1, '2023-06-15 22:11:14', 1, '2023-06-15 22:11:14');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (3, 1, 2, 4, 1, '2023-06-15 22:11:26', 1, '2023-06-15 22:11:26');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (4, 1, 3, 20, 1, '2023-06-15 22:11:32', 1, '2023-06-15 22:11:32');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (5, 1, 4, 2, 1, '2023-06-15 22:11:36', 1, '2023-06-15 22:11:36');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (6, 2, 5, 10, 1, '2023-06-15 22:11:39', 1, '2023-06-15 22:11:39');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (7, 2, 6, 4, 1, '2023-06-15 22:11:43', 1, '2023-06-15 22:11:43');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (8, 2, 7, 20, 1, '2023-06-15 22:11:47', 1, '2023-06-15 22:11:47');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (9, 2, 8, 2, 1, '2023-06-15 22:11:50', 1, '2023-06-15 22:11:50');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (10, 2, 9, 20, 1, '2023-06-15 22:11:54', 1, '2023-06-15 22:11:54');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (11, 3, 4, 2, 1, '2023-06-16 09:59:28', 1, '2023-06-16 09:59:28');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (12, 3, 7, 10, 1, '2023-06-16 09:59:28', 1, '2023-06-16 09:59:28');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (13, 4, 4, 5, 1, '2023-06-16 10:22:49', 1, '2023-06-16 10:22:49');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (14, 4, 8, 7, 1, '2023-06-16 10:22:49', 1, '2023-06-16 10:22:49');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (15, 4, 9, 6, 1, '2023-06-17 10:31:44', 1, '2023-06-17 10:31:44');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (16, 4, 5, 9, 1, '2023-06-17 10:31:45', 1, '2023-06-17 10:31:45');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (17, 5, 9, 6, 1, '2023-06-17 10:33:26', 1, '2023-06-17 10:33:26');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (18, 5, 5, 3, 1, '2023-06-17 10:33:26', 1, '2023-06-17 10:33:26');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (19, 6, 2, 3, 1, '2023-06-13 03:54:42', 1, '2023-06-13 03:54:48');
INSERT INTO `evaluation` (`eval_id`, `scheme_id`, `indicator_id`, `cust_weight`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (20, 6, 3, 4, 1, '2023-06-13 03:54:42', 1, '2023-06-13 03:54:48');
COMMIT;

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field` (
  `field_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '油田id',
  `field_name` varchar(64) NOT NULL COMMENT '油田名',
  `field_address` varchar(64) NOT NULL COMMENT '油田地址',
  `field_area` float NOT NULL COMMENT '油田面积',
  `field_desc` varchar(255) DEFAULT NULL COMMENT '油田其他描述',
  `create_user` bigint(20) NOT NULL COMMENT '创建人员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新人员',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`field_id`),
  UNIQUE KEY `field_name` (`field_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of field
-- ----------------------------
BEGIN;
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1, '大油田', '新疆克拉玛依', 114514, NULL, 1, '2023-06-22 18:27:35', 1, '2023-06-22 18:27:40');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (3, 'Kwan Wing Fat', '795 Shennan Ave, Futian District', 80.86, 'nUA7d0bOk5', 14, '2014-04-06 08:46:24', 660, '2007-10-17 13:10:34');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (5, 'Mo Lan', '112 New Street', 513.03, 'sTuFQ1VwW3', 791, '2005-11-26 14:58:39', 305, '2014-10-04 20:30:48');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (6, '近度才动于风', 'beijing', 96, 'nostrud amet ut', 666, '2023-06-13 17:19:29', 666, '2023-06-17 00:59:45');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (7, '枫城油田', '克拉玛依', 66, '很6的油田', 666, '2023-06-13 17:44:10', 666, '2023-06-13 17:44:10');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (8, '无名油田', '克拉玛依', 555, '很5的油田', 666, '2023-06-13 17:48:23', 666, '2023-06-13 17:48:23');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (9, 'sdfgdfsgh', '啊实打实的土壤干旱', 123, 'asfsdg ', 666, '2023-06-14 21:58:46', 666, '2023-06-14 21:58:46');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (11, 'sdfgd1234fsgh', '啊实打实的土壤干旱', 16723, 'a房东太太一个胡歌 ', 666, '2023-06-14 22:00:12', 666, '2023-06-14 22:00:12');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (16, '沃尔沃', 'werw', 767, '伏尔泰', 666, '2023-06-15 12:48:39', 666, '2023-06-15 12:48:39');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (18, '违法', '未付款', 888, '我回复，我', 666, '2023-06-16 16:47:14', 666, '2023-06-16 16:47:14');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (19, '人疯狂', 'dfhk', 777, '减肥计划', 666, '2023-06-16 17:07:28', 666, '2023-06-16 17:07:28');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (20, '返回油田', '克拉玛依', 999, '很9的油田', 666, '2023-06-16 17:57:17', 666, '2023-06-16 17:57:17');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (21, '你的', '克拉玛依', 7878, '很0的油田', 666, '2023-06-16 18:01:59', 666, '2023-06-16 18:01:59');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (23, '北油', '这里', 12, '油', 666, '2023-06-17 00:48:44', 666, '2023-06-17 00:48:44');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (24, '动叫那对', '安徽省武威市郾城区', 23, 'deserunt eu anim sed', 666, '2023-06-17 00:54:01', 666, '2023-06-17 00:54:01');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (25, '点动性去何定', '河南省重庆市玛纳斯县', 94, 'amet', 666, '2023-06-17 23:56:38', 666, '2023-06-17 23:56:38');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (26, 'ddddd', 'qqqqqq', 123, 'safdgdh', 666, '2023-06-18 00:52:17', 666, '2023-06-18 00:52:17');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (28, 'd12423433', 'qqqqqq', 123, 'safdgdh', 666, '2023-06-18 00:54:44', 666, '2023-06-18 00:54:44');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (29, '北下关管', '北下关管', 1235, '北下关管', 666, '2023-06-18 16:41:41', 666, '2023-06-18 16:41:41');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (36, '广东石化', '克拉玛依', 7878, '很0的油田', 666, '2023-06-19 14:07:32', 666, '2023-06-19 14:07:35');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (40, '系全化完她', '辽宁省安康市河口区', 32, 'pariatur adipisicing esse occaecat', 666, '2023-06-19 07:43:23', 666, '2023-06-19 07:43:23');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (41, '五达与族装', '香港特别行政区吐鲁番地区隆德县', 56, 'cupidatat ea qui eu', 6, '2023-06-19 15:47:48', 6, '2023-06-19 15:47:48');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (42, '少油收', '北京中卫市华县', 9, 'do laboris', 6, '2023-06-19 15:48:19', 6, '2023-06-19 15:48:19');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (43, '查听强段', '浙江省离岛平原县', 86, 'consequat velit amet', 6, '2023-06-19 15:48:50', 6, '2023-06-19 15:50:26');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (44, '效体交天', '内蒙古自治区西双版纳傣族自治州定边县', 59, 'amet non in labore eu', 0, '2023-06-20 12:22:58', 0, '2023-06-20 12:22:58');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (45, '123', '456', 56, NULL, 0, '2023-06-20 16:45:45', 0, '2023-06-20 16:45:45');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (47, '凄凄切切凄凄切切', '123', 123, '123', 0, '2023-06-20 22:06:32', 0, '2023-06-20 22:06:32');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (48, 'qwerty', '12', 45, 'u计划i呢', 0, '2023-06-20 22:06:57', 0, '2023-06-20 22:06:57');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (49, 'awd', '123', 123, 'eg', 0, '2023-06-21 13:27:04', 0, '2023-06-21 13:27:04');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (50, 'qewsre', '123qqq', 123, 'ibn', 0, '2023-06-21 16:09:45', 0, '2023-06-21 16:09:45');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (51, '小油田', '克拉玛依', 11, NULL, 0, '2023-06-22 19:07:34', 0, '2023-06-22 19:07:34');
INSERT INTO `field` (`field_id`, `field_name`, `field_address`, `field_area`, `field_desc`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (52, '中油田', 'kry', 12, NULL, 0, '2023-06-22 20:02:32', 0, '2023-06-22 20:02:32');
COMMIT;

-- ----------------------------
-- Table structure for indicator
-- ----------------------------
DROP TABLE IF EXISTS `indicator`;
CREATE TABLE `indicator` (
  `indicator_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '指标id',
  `indicator_name` varchar(64) NOT NULL COMMENT '指标名',
  `flooding_plan` varchar(64) DEFAULT NULL COMMENT '指标所属注水计划',
  `indicator_type` varchar(64) DEFAULT NULL COMMENT '指标所属类型',
  `indicator_unit` varchar(20) NOT NULL COMMENT '指标单位',
  `important` tinyint(4) NOT NULL COMMENT '是否为重要指标',
  `default_weight` float DEFAULT NULL COMMENT '默认权重',
  `rmd_value` float DEFAULT NULL COMMENT '指标推荐值',
  `description` varchar(255) DEFAULT NULL COMMENT '其他描述，例如该条指标的推荐范围',
  `create_user` bigint(20) NOT NULL COMMENT '创建人员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新人员',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`indicator_id`),
  KEY `flooding_plan` (`flooding_plan`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of indicator
-- ----------------------------
BEGIN;
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (3, '油井双多向受益率', '注好水', '油藏', '%', 0, 2.5, 50, '>=50', 1, '2023-06-15 21:21:00', 1, '2023-06-15 21:21:00');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (4, '油层利用率', '注好水', '油藏', '%', 0, 2.5, 60, '>=60', 1, '2023-06-15 21:21:51', 1, '2023-06-15 21:21:51');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (6, '水质达标率', '注好水', '工程', '%', 1, 5, 85, '>=85', 1, '2023-06-15 21:21:54', 1, '2023-06-15 21:21:54');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (7, '腐蚀速率', '注好水', '工程', 'mm/a', 0, 2.5, 0.076, '<=0.076', 1, '2023-06-15 21:22:05', 1, '2023-06-15 21:22:05');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (8, '水井开井率', '注好水', '管理', '%', 0, 2.5, 90, '>=90', 1, '2023-06-15 21:22:05', 1, '2023-06-15 21:22:05');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (9, '水井综合时率', '注好水', '管理', '%', 1, 5, 75, '>=75', 1, '2023-06-15 21:22:06', 1, '2023-06-15 21:22:06');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (10, '动态监测完成率', '注够水', '管理', '%', 1, 5, 100, '>=100', 1, '2023-06-15 21:22:40', 1, '2023-06-15 21:22:40');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (11, '阶段注采比', '注够水', '油藏', '比例', 0, 2.5, 1.1, '1.1-1.3', 1, '2023-06-15 21:22:41', 1, '2023-06-15 21:22:41');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (12, '能量保持利用状况              （地层压力/原始地层压力）', '注够水', '油藏', '比例', 0, 2.5, 0.9, '>=0.9', 1, '2023-06-15 21:22:42', 1, '2023-06-15 21:22:42');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (13, '执配率', '注够水', '工程', '%', 0, 2.5, 95, '>=95', 1, '2023-06-16 11:01:17', 1, '2023-06-16 11:01:17');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (14, '注水压损', '注够水', '工程', 'MPa', 0, 2.5, 0.9, '<=0.9', 1, '2023-06-16 11:28:46', 1, '2023-06-16 11:28:46');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (15, '注水井措施有效率', '注够水', '工程', '&', 1, 5, 85, '>=85', 1, '2023-06-16 20:07:38', 1, '2023-06-16 20:41:15');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (17, '注水井检管周期', '注够水', '工程', 'a', 0, 2.5, 3, '<=3', 1, '2023-01-01 08:00:00', 1, '2023-01-01 08:00:00');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (22, '注水井资料全准率', '注够水', '管理', '%', 0, 2.5, 98, '>=98', 1, '2023-06-19 12:50:37', 1, '2023-06-19 12:50:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (23, '油层动用程度', '精细注水', '油藏', '%', 1, 5, 75, '>=75', 1, '2023-06-10 12:00:00', 1, '2023-06-10 12:00:00');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (24, '含水上升率', '精细注水', '油藏', '%', 0, 2.5, 3, '<=3', 1, '2002-01-24 01:13:27', 1, '2014-10-02 12:55:35');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (25, '分注率', '精细注水', '工程', '%', 0, 5, 50, '>=50', 1, '2018-08-05 00:36:08', 1, '2004-01-21 22:52:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (26, '分注合格率', '精细注水', '工程', '%', 0, 2.5, 80, '>=80', 1, '2021-03-15 12:31:10', 1, '2008-12-04 10:11:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (27, '注水系统效率', '精细注水', '管理', '%', 0, 2.5, 55, '>=55', 1, '2019-08-14 18:21:02', 1, '2017-01-31 01:49:12');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (28, '预测水驱采收率', '有效注水', '油藏', '%', 0, 5, 35, '>=51', 1, '2004-12-19 23:38:18', 1, '2002-03-05 09:30:50');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (29, '阶段末可采储量采出程度', '有效注水', '油藏', '%', 0, 2.5, 20, '>=35', 1, '2007-03-13 08:17:53', 1, '2019-06-22 19:24:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (30, '剩余可采储量采油速度', '有效注水', '油藏', '%', 0, 2.5, 5, '>=20', 1, '2010-12-05 06:08:52', 1, '2000-06-30 18:59:15');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (31, '自然递减率', '有效注水', '油藏', '%', 0, 5, 10, '>=5', 1, '2022-05-20 01:09:02', 1, '2014-05-15 07:18:28');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (32, '综合递减率', '有效注水', '油藏', '%', 0, 2.5, 3, '<=3', 1, '2008-11-26 11:10:30', 1, '2005-04-29 02:22:25');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (33, '单井日产油递减幅度', '有效注水', '油藏', '%', 0, 2.5, 4, '<=4', 1, '2014-04-28 08:29:35', 1, '2020-08-13 07:24:06');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (34, '耗水率', '有效注水', '工程', '方/吨', 0, 2.5, 0.2, '<=0.2', 1, '2005-12-21 07:40:43', 1, '2017-09-21 19:47:45');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (35, '吨油操作费用增长幅度', '有效注水', '效益', '幅度', 0, 5, 0, '<=0', 1, '2006-07-10 16:32:54', 1, '2020-06-07 17:42:02');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (44, '水驱控制程度', '注好水', '工程', '%', 1, 5, 80, '>=80', 1, '2023-06-15 17:39:52', 1, '2023-06-15 17:39:57');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (45, '注采对应率', '注好水', '工程', '%', 0, 2.5, 80, '>=80', 1, '2023-06-15 21:20:37', 1, '2023-06-15 21:20:37');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (46, '油井双多向受益率', '注好水', '管理', '%', 0, 2.5, 50, '>=50', 1, '2023-06-15 21:21:00', 1, '2023-06-15 21:21:00');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (47, '油层利用率', '注好水', '油藏', '%', 0, 2.5, 60, '>=60', 1, '2023-06-15 21:21:51', 1, '2023-06-15 21:21:51');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (48, '注水井洗井周期', '注好水', '油藏', 'm', 0, 2.5, 6, '<=6', 1, '2023-06-15 21:21:53', 1, '2023-06-15 21:21:53');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (49, '水质达标率', '注好水', '工程', '%', 1, 5, 85, '>=85', 1, '2023-06-15 21:21:54', 1, '2023-06-15 21:21:54');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (50, '腐蚀速率', '注够水', '工程', 'mm/a', 0, 2.5, 0.076, '<=0.076', 1, '2023-06-15 21:22:05', 1, '2023-06-15 21:22:05');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (51, '水井开井率', '注够水', '管理', '%', 0, 2.5, 90, '>=90', 1, '2023-06-15 21:22:05', 1, '2023-06-15 21:22:05');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (52, '水井综合时率', '注够水', '油藏', '%', 1, 5, 75, '>=75', 1, '2023-06-15 21:22:06', 1, '2023-06-15 21:22:06');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (53, '动态监测完成率', '注够水', '油藏', '%', 1, 5, 100, '>=100', 1, '2023-06-15 21:22:40', 1, '2023-06-15 21:22:40');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (54, '阶段注采比', '注够水', '工程', '比例', 0, 2.5, 1.1, '1.1-1.3', 1, '2023-06-15 21:22:41', 1, '2023-06-15 21:22:41');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (55, '能量保持利用状况              （地层压力/原始地层压力）', '注够水', '工程', '比例', 0, 2.5, 0.9, '>=0.9', 1, '2023-06-15 21:22:42', 1, '2023-06-15 21:22:42');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (56, '执配率', '注够水', '管理', '%', 0, 2.5, 95, '>=95', 1, '2023-06-16 11:01:17', 1, '2023-06-16 11:01:17');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (57, '注水压损', '注够水', '油藏', 'MPa', 0, 2.5, 0.9, '<=0.9', 1, '2023-06-16 11:28:46', 1, '2023-06-16 11:28:46');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (58, '注水井措施有效率', '精细注水', '油藏', '&', 1, 5, 85, '>=85', 1, '2023-06-16 20:07:38', 1, '2023-06-16 20:41:15');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (59, '注水井检管周期', '精细注水', '工程', 'a', 0, 2.5, 3, '<=3', 1, '2023-01-01 08:00:00', 1, '2023-01-01 08:00:00');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (60, '注水井资料全准率', '精细注水', '工程', '%', 0, 2.5, 98, '>=98', 1, '2023-06-19 12:50:37', 1, '2023-06-19 12:50:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (61, '油层动用程度', '精细注水', '管理', '%', 1, 5, 75, '>=75', 1, '2023-06-10 12:00:00', 1, '2023-06-10 12:00:00');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (62, '含水上升率', '精细注水', '油藏', '%', 0, 2.5, 3, '<=3', 1, '2002-01-24 01:13:27', 1, '2014-10-02 12:55:35');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (63, '分注率', '有效注水', '油藏', '%', 0, 5, 50, '>=50', 1, '2018-08-05 00:36:08', 1, '2004-01-21 22:52:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (64, '分注合格率', '有效注水', '工程', '%', 0, 2.5, 80, '>=80', 1, '2021-03-15 12:31:10', 1, '2008-12-04 10:11:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (65, '注水系统效率', '有效注水', '工程', '%', 0, 2.5, 55, '>=55', 1, '2019-08-14 18:21:02', 1, '2017-01-31 01:49:12');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (66, '预测水驱采收率', '有效注水', '管理', '%', 0, 5, 35, '>=51', 1, '2004-12-19 23:38:18', 1, '2002-03-05 09:30:50');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (67, '阶段末可采储量采出程度', '有效注水', '油藏', '%', 0, 2.5, 20, '>=35', 1, '2007-03-13 08:17:53', 1, '2019-06-22 19:24:47');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (68, '剩余可采储量采油速度', '有效注水', '油藏', '%', 0, 2.5, 5, '>=20', 1, '2010-12-05 06:08:52', 1, '2000-06-30 18:59:15');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (69, '自然递减率', '有效注水', '工程', '%', 0, 5, 10, '>=5', 1, '2022-05-20 01:09:02', 1, '2014-05-15 07:18:28');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (70, '综合递减率', '有效注水', '工程', '%', 0, 2.5, 3, '<=3', 1, '2008-11-26 11:10:30', 1, '2005-04-29 02:22:25');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (71, '单井日产油递减幅度', '注好水', '管理', '%', 0, 2.5, 4, '<=4', 1, '2014-04-28 08:29:35', 1, '2020-08-13 07:24:06');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (72, '耗水率', '注好水', '油藏', '方/吨', 0, 2.5, 0.2, '<=0.2', 1, '2005-12-21 07:40:43', 1, '2017-09-21 19:47:45');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (73, '吨油操作费用增长幅度', '注好水', '油藏', '幅度', 0, 5, 0, '<=0', 1, '2006-07-10 16:32:54', 1, '2020-06-07 17:42:02');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (74, 'jaoiegr', '注好水', '油藏', 'aerg', 0, 0, 0, '', 0, '2023-06-20 12:46:01', 0, '2023-06-20 12:46:01');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (75, 'aerg', '注好水', '油藏', 'serg', 0, 0, 0, '', 0, '2023-06-20 12:46:13', 0, '2023-06-20 12:46:13');
INSERT INTO `indicator` (`indicator_id`, `indicator_name`, `flooding_plan`, `indicator_type`, `indicator_unit`, `important`, `default_weight`, `rmd_value`, `description`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (76, '水气驱油率', '注好水', '油藏', '%', 1, 1, 1, '', 0, '2023-06-20 22:30:26', 0, '2023-06-20 22:30:26');
COMMIT;

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `well_id` bigint(20) NOT NULL COMMENT '注水井id',
  `flooding_plan` varchar(64) NOT NULL COMMENT '注水计划',
  PRIMARY KEY (`well_id`,`flooding_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of plan
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '单条指标记录的id',
  `record_time` datetime NOT NULL COMMENT '该条指标的产生时间（旧数据）',
  `well_id` bigint(20) NOT NULL COMMENT '注水井id',
  `indicator_id` bigint(20) NOT NULL COMMENT '该条指标的id',
  `record_value` float DEFAULT NULL COMMENT '指标值',
  `create_user` bigint(20) NOT NULL COMMENT '创建人员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新人员',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`record_id`),
  KEY `well_id` (`well_id`),
  KEY `indicator_id` (`indicator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of record
-- ----------------------------
BEGIN;
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (3, '2017-02-14 02:21:19', 1, 39, 5, 666, '2023-06-15 21:10:34', 666, '2023-06-15 21:10:34');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (4, '2023-02-14 02:21:19', 1, 40, 8, 666, '2023-06-15 21:11:36', 666, '2023-06-15 21:11:36');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (5, '2023-02-14 02:21:19', 1, 3, 8, 666, '2023-06-15 21:11:48', 666, '2023-06-15 21:11:48');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (6, '2023-02-14 02:21:19', 1, 4, 8, 666, '2023-06-15 21:11:52', 666, '2023-06-15 21:11:52');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (7, '2023-02-14 02:21:19', 1, 5, 8, 666, '2023-06-15 21:11:55', 666, '2023-06-15 21:11:55');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (8, '2023-02-14 02:21:19', 1, 6, 8, 666, '2023-06-15 21:12:18', 666, '2023-06-15 21:12:18');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (9, '2023-02-14 02:21:19', 1, 7, 8, 666, '2023-06-15 21:13:04', 666, '2023-06-15 21:13:04');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (10, '2023-02-14 02:21:19', 1, 8, 8, 666, '2023-06-15 21:13:08', 666, '2023-06-15 21:13:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (11, '2023-02-14 02:21:19', 1, 9, 8, 666, '2023-06-15 21:13:11', 666, '2023-06-15 21:13:11');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (12, '2023-02-14 02:21:19', 12, 0, 666, 666, '2023-06-15 21:13:15', 666, '2023-06-16 01:33:04');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (13, '2023-01-01 08:00:00', 1, 17, 5, 1, '2023-01-01 08:00:00', 1, '2023-01-01 08:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (14, '2023-01-01 09:00:00', 1, 18, 4, 1, '2023-01-01 09:00:00', 1, '2023-01-01 09:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (15, '2023-01-01 10:00:00', 1, 17, 6, 1, '2023-01-01 10:00:00', 1, '2023-01-01 10:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (16, '2023-01-01 11:00:00', 2, 17, 7, 1, '2023-01-01 11:00:00', 1, '2023-01-01 11:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (17, '2023-01-01 12:00:00', 2, 2, 3, 1, '2023-01-01 12:00:00', 1, '2023-01-01 12:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (18, '2023-02-01 08:00:00', 1, 1, 5, 1, '2023-02-01 08:00:00', 1, '2023-02-01 08:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (19, '2023-02-01 09:00:00', 1, 2, 4, 1, '2023-02-01 09:00:00', 1, '2023-02-01 09:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (20, '2023-02-01 10:00:00', 1, 1, 6, 1, '2023-02-01 10:00:00', 1, '2023-02-01 10:00:00');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (44, '2023-12-12 12:00:00', 1, 1, 3.1, 666, '2023-06-17 10:57:26', 666, '2023-06-17 10:57:26');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (45, '2023-12-12 12:00:00', 1, 2, 3.1, 666, '2023-06-17 10:57:26', 666, '2023-06-17 10:57:26');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (46, '2023-12-12 12:00:00', 1, 3, 3.1, 666, '2023-06-17 10:57:26', 666, '2023-06-17 10:57:26');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (47, '2023-12-12 12:00:00', 1, 4, 3.1, 666, '2023-06-17 10:57:26', 666, '2023-06-17 10:57:26');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (48, '2023-05-01 03:52:16', 21, 2, 1, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (49, '2023-05-01 03:52:16', 21, 2, 11, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (50, '2023-05-01 03:52:16', 21, 2, 7, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (51, '2023-05-01 03:52:16', 21, 2, 9, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (52, '2023-05-01 03:52:16', 21, 2, 4, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (53, '2023-05-01 03:52:16', 21, 3, 1, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (54, '2023-05-01 03:52:16', 21, 3, 1, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (55, '2023-05-01 03:52:16', 21, 3, 5, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (56, '2023-05-01 03:52:16', 21, 3, 3, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (57, '2023-05-01 03:52:16', 21, 3, 4, 12, '2023-06-14 03:52:01', 12, '2023-06-14 03:52:08');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (58, '2022-06-01 03:52:16', 21, 2, 1, 12, '2022-06-01 03:52:16', 12, '2022-06-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (59, '2022-05-01 03:52:16', 21, 2, 11, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (60, '2022-05-01 03:52:16', 21, 2, 7, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (61, '2022-05-01 03:52:16', 21, 2, 9, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (62, '2022-05-01 03:52:16', 21, 2, 4, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (63, '2022-05-01 03:52:16', 21, 3, 1, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (64, '2022-05-01 03:52:16', 21, 3, 1, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (65, '2022-05-01 03:52:16', 21, 3, 5, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (66, '2022-05-01 03:52:16', 21, 3, 3, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (67, '2022-05-01 03:52:16', 21, 3, 4, 12, '2022-05-01 03:52:16', 12, '2022-05-01 03:52:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (69, '2023-12-12 12:00:00', 1, 1, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (70, '2023-12-12 12:00:00', 1, 2, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (71, '2023-12-12 12:00:00', 1, 3, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (72, '2023-12-12 12:00:00', 1, 4, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (73, '2023-12-12 12:00:00', 1, 1, 3.1, 0, '2023-06-20 03:28:20', 0, '2023-06-20 03:28:20');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (74, '2023-05-31 00:00:00', 1, 1, 1, 0, '2023-06-20 03:42:43', 0, '2023-06-20 03:42:43');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (75, '2023-06-20 09:54:04', 1, 44, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (76, '2023-06-20 09:54:04', 1, 45, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (77, '2023-06-20 09:54:04', 1, 46, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (78, '2023-06-20 09:54:04', 1, 47, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (79, '2023-06-20 09:54:04', 1, 48, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (80, '2023-06-20 09:54:04', 1, 49, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (81, '2023-06-20 09:54:04', 1, 50, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (82, '2023-06-20 09:54:04', 1, 51, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (83, '2023-12-12 12:00:00', 2, 1, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (84, '2023-12-12 12:00:00', 2, 2, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (85, '2023-12-12 12:00:00', 2, 3, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (86, '2023-12-12 12:00:00', 2, 4, 3.1, 0, '2023-06-20 03:25:44', 0, '2023-06-20 03:25:44');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (87, '2023-12-12 12:00:00', 2, 1, 3.1, 0, '2023-06-20 03:28:20', 0, '2023-06-20 03:28:20');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (88, '2023-05-31 00:00:00', 2, 1, 1, 0, '2023-06-20 03:42:43', 0, '2023-06-20 03:42:43');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (89, '2023-06-20 09:54:04', 2, 44, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (90, '2023-06-20 09:54:04', 2, 45, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (91, '2023-06-20 09:54:04', 2, 46, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (92, '2023-06-20 09:54:04', 2, 47, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (93, '2023-06-20 09:54:04', 2, 48, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (94, '2023-06-20 09:54:04', 2, 49, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (95, '2023-06-20 09:54:04', 2, 50, 2, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (96, '2023-06-20 09:54:04', 2, 51, 23, 0, '2023-06-20 09:53:51', 0, '2023-06-20 09:53:59');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (97, '2023-06-20 00:00:00', 3, 67, 12, 0, '2023-06-20 10:05:16', 0, '2023-06-20 10:05:16');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (98, '2023-06-20 00:00:00', 2, 55, 12, 0, '2023-06-20 10:05:52', 0, '2023-06-20 10:05:52');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (99, '2023-05-30 00:00:00', 2, 34, 4, 0, '2023-06-20 10:33:57', 0, '2023-06-20 10:33:57');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (100, '2023-06-07 00:00:00', 4, 34, 66, 0, '2023-06-20 10:34:20', 0, '2023-06-20 10:34:20');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (101, '2023-06-13 00:00:00', 1, 37, 1, 0, '2023-06-20 10:34:35', 0, '2023-06-20 10:34:35');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (102, '2023-06-20 00:00:00', 1, 38, 3, 0, '2023-06-20 10:36:13', 0, '2023-06-20 10:36:13');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (103, '2023-06-21 00:00:00', 333, 111, 222, 0, '2023-06-20 12:15:55', 0, '2023-06-20 12:15:55');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (104, '2023-06-23 00:00:00', 1, 2, 11, 0, '2023-06-22 19:17:07', 0, '2023-06-22 19:17:07');
INSERT INTO `record` (`record_id`, `record_time`, `well_id`, `indicator_id`, `record_value`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (105, '2023-06-01 00:00:00', 1, 1, 33, 0, '2023-06-22 20:04:01', 0, '2023-06-22 20:04:01');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(32) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`role_id`, `role_name`) VALUES (4, '数据录入员');
INSERT INTO `role` (`role_id`, `role_name`) VALUES (2, '油田管理员');
INSERT INTO `role` (`role_id`, `role_name`) VALUES (3, '注水井管理员');
INSERT INTO `role` (`role_id`, `role_name`) VALUES (1, '系统管理员');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户名',
  `user_email` varchar(32) DEFAULT NULL COMMENT '用户邮箱',
  `user_phone` char(11) DEFAULT NULL COMMENT '用户手机号码',
  `user_password` char(64) NOT NULL COMMENT '账号密码',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`) USING BTREE,
  UNIQUE KEY `user_email` (`user_email`) USING BTREE,
  UNIQUE KEY `user_phone` (`user_phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_phone`, `user_password`, `create_time`, `update_time`) VALUES (1, 'admin', 'icy@st.cupk.edu.cn', '18309909920', '$2a$10$6OlSx7t1lPJLdPrc6lHWyOKnOi4jFJjTttzieCIeFo2aS8g6B6j7y', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '用户的角色id',
  `asset_id` bigint(20) NOT NULL COMMENT '用户代表的油田/注水井',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` (`user_id`, `role_id`, `asset_id`) VALUES (1, 1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`, `asset_id`) VALUES (2, 1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`, `asset_id`) VALUES (5, 4, 0);
INSERT INTO `user_role` (`user_id`, `role_id`, `asset_id`) VALUES (6, 4, 0);
COMMIT;

-- ----------------------------
-- Table structure for well
-- ----------------------------
DROP TABLE IF EXISTS `well`;
CREATE TABLE `well` (
  `well_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '注水井id',
  `well_name` varchar(64) NOT NULL COMMENT '注水井名',
  `well_address` varchar(64) NOT NULL COMMENT '注水井位置',
  `well_coordinate` point DEFAULT NULL COMMENT '注水井经纬度',
  `well_depth` float DEFAULT NULL COMMENT '注水井深度',
  `well_dia` float DEFAULT NULL COMMENT '注水井直径',
  `start_time` datetime DEFAULT NULL COMMENT '注水井开采时间',
  `end_time` datetime DEFAULT NULL COMMENT '注水井开采结束时间',
  `well_period` varchar(20) NOT NULL COMMENT '注水井的开发阶段',
  `well_factory` varchar(64) NOT NULL COMMENT '注水井的负责单位',
  `field_id` bigint(20) NOT NULL COMMENT '注水井所属油田id',
  `create_user` bigint(20) NOT NULL COMMENT '创建人员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人员',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`well_id`),
  UNIQUE KEY `well_name` (`well_name`) USING BTREE,
  UNIQUE KEY `well_coordinate` (`well_coordinate`(25)) USING BTREE,
  KEY `field_id` (`field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of well
-- ----------------------------
BEGIN;
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1, '新疆最油的井', '新疆', NULL, 558.16, 835.77, '2023-05-22 13:00:43', '2000-09-27 08:39:09', 'FROA0ycsIl', '新疆油田', 1, 841, '2009-05-23 23:39:49', 963, '2014-04-08 13:03:13');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (2, 'Shi Lu', '215 Jiangnan West Road, Haizhu District', NULL, 735.08, 125.14, '2009-07-18 00:26:02', '2019-06-14 07:44:31', 'i7l92TbMui', 'O4GpTyW1MR', 1, 113, '2013-11-02 17:59:07', 566, '2011-03-26 06:54:28');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (3, 'Suzuki Ayano', '463 Broadway', NULL, 397.31, 325.01, '2013-02-01 04:10:33', '2011-06-13 01:31:24', 'uuGdkvYuIW', 'tWM50BQgIH', 1, 30, '2012-12-21 13:34:08', 634, '2001-06-18 06:00:54');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (4, 'Kojima Akina', '1-7-19 Saidaiji Akodacho', NULL, 715.17, 366.19, '2017-02-14 02:21:19', '2023-04-14 10:17:54', 'P4PVBw7oB0', 'ysMe7a4e9a', 1, 428, '2019-12-07 23:43:03', 922, '2004-09-10 12:04:07');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (7, '事本然情书该', '上海 上海市 静安区', ST_GeomFromText('POINT(1 2)'), 6755.4, 427.6, '1972-03-02 17:14:49', '1975-07-17 03:14:59', '定', '步立到带育把', 54, 666, '2023-06-16 18:40:37', 666, '2023-06-16 18:40:37');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (14, '', 'hello', ST_GeomFromText('POINT(0.1 0.2)'), 200, 29, '2021-01-01 12:00:00', '2021-01-01 12:00:00', '第三期', '', 1, 666, '2023-06-16 19:05:06', 666, '2023-06-17 01:29:10');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (16, '测试呀', '测试呀', NULL, 1, 1, '2023-06-17 23:40:40', '2023-06-17 23:40:40', 'wellDTO.getPeriod()', '测试呀', 1, 1, '2023-06-17 23:40:40', 1, '2023-06-17 23:40:40');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (18, '测试', '测试呀', NULL, 1, 1, '2023-06-17 23:42:13', '2023-06-17 23:42:13', 'wellDTO.getPeriod()', '测试呀', 1, 1, '2023-06-17 23:42:13', 1, '2023-06-17 23:42:13');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (19, 'ceshiya', 'ceshiya', NULL, 1, 1, '2023-06-18 00:53:36', '2023-06-18 00:53:36', '', 'wellDTO.getFactory()', 1, 666, '2023-06-18 00:53:37', 666, '2023-06-18 00:53:37');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (20, 'ceshiya15', 'ceshiya', NULL, 1, 1, '2023-06-18 01:07:41', '2023-06-18 01:07:41', '', 'wellDTO.getFactory()', 1, 666, '2023-06-18 01:07:41', 666, '2023-06-18 01:07:41');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (21, '一号井', '新疆', ST_GeomFromText('POINT(1 3)'), 123, 2134, '2023-06-15 03:49:54', '2023-06-13 03:50:01', '12', '一号油田', 1, 666, '2023-06-14 03:50:50', NULL, '2023-06-20 03:50:53');
INSERT INTO `well` (`well_id`, `well_name`, `well_address`, `well_coordinate`, `well_depth`, `well_dia`, `start_time`, `end_time`, `well_period`, `well_factory`, `field_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (25, '交大嘉园', '交大嘉园', ST_GeomFromText('POINT(1.9 2)'), 10, 10, '2023-06-18 23:39:39', '2023-06-18 23:39:39', '交大嘉园', '交大嘉园', 1, 666, '2023-06-18 22:53:02', 666, '2023-06-18 23:39:40');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
