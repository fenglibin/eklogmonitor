-- MySQL dump 10.16  Distrib 10.1.48-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: eklogmonitor
-- ------------------------------------------------------
-- Server version	10.1.48-MariaDB-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_monitor_config`
--

DROP TABLE IF EXISTS `app_monitor_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_monitor_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `appName` varchar(50) NOT NULL DEFAULT '' COMMENT '应用监控名称描述',
  `appOwner` varchar(50) NOT NULL DEFAULT '' COMMENT '应用负责人',
  `esIndex` varchar(256) NOT NULL DEFAULT '' COMMENT 'Es的索引',
  `esParam` varchar(10240) NOT NULL DEFAULT '' COMMENT 'Es的查询参数,json格式',
  `kibanaIndex` varchar(50) NOT NULL DEFAULT '' COMMENT '对应的Kibana索引',
  `ddWebhookAccessToken` varchar(100) NOT NULL DEFAULT '' COMMENT '钉钉告警使用的accessToken',
  `ddRobotMobile` varchar(100) DEFAULT '' COMMENT '钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人',
  `alarmThreshold` int(10) unsigned DEFAULT '1' COMMENT '告警阈值,大于等于该阈值才需要告警',
  `phoneAlarmThreshold` int(10) unsigned DEFAULT '10' COMMENT '电话告警阈值,大于等于该阈值才需要告警',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `createUserId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建用户id',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updateUserId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '更新用户id',
  `lastScanTime` datetime DEFAULT NULL COMMENT '最近一次的扫描时间点,用来保证扫描不发生时间空洞',
  `isDel` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除:1表示删除,0表示可用',
  `executeCycle` int(10) DEFAULT '10' COMMENT '任务的执行周期，以分钟为执行单位，默认为１０分钟',
  `deptId` bigint(20) unsigned NOT NULL DEFAULT '1',
  `testerName` varchar(24) DEFAULT NULL COMMENT '负责的测试人员的名称',
  `testerPhone` varchar(24) DEFAULT NULL COMMENT '负责的测试人员的电话，用于告警达到一定的频度时用于电话告警通知',
  PRIMARY KEY (`id`),
  KEY `idx_owner` (`appOwner`),
  KEY `idx_del` (`isDel`),
  KEY `idx_deptId` (`deptId`),
  KEY `idx_phone` (`ddRobotMobile`),
  KEY `idx_es_index` (`esIndex`(20)),
  KEY `idx_tester_name` (`testerName`),
  KEY `idx_tester_phone` (`testerPhone`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COMMENT='应用异常告警配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_monitor_config`
--

LOCK TABLES `app_monitor_config` WRITE;
/*!40000 ALTER TABLE `app_monitor_config` DISABLE KEYS */;
INSERT INTO `app_monitor_config` VALUES (9,'xxx-job应用异常监控','张三','xxx-job*','{\n    \"query\": {\n        \"bool\": {\n            \"must\": [\n                {\n                    \"term\": {\n                        \"message\": {\n                            \"value\": \"error\"\n                        }\n                    }\n                }\n            ],\n            \"must_not\": [\n                {\n                    \"term\": {\n                        \"message\": {\n                            \"value\": \"info\"\n                        }\n                    }\n                },\n                {\n                    \"term\": {\n                        \"message\": {\n                            \"value\": \"xxl\"\n                        }\n                    }\n                },\n                {\n                    \"term\": {\n                        \"message\": {\n                            \"value\": \"rpc\"\n                        }\n                    }\n                }\n            ]\n        }\n    }\n}','xxx-job','1234567898765432345678765','13888888888',20,10000,'2021-01-06 16:11:34',0,'2021-07-09 15:14:25',0,'2021-07-06 14:20:00',0,10,1,NULL,NULL);
/*!40000 ALTER TABLE `app_monitor_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_monitor_data`
--

DROP TABLE IF EXISTS `app_monitor_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_monitor_data` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `configId` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联配置app_monitor_config表的主键id',
  `errCount` int(11) NOT NULL DEFAULT '0' COMMENT '错误数',
  `kibanaUrl` varchar(2048) NOT NULL DEFAULT '' COMMENT 'Kibana的URL',
  `startTime` datetime NOT NULL COMMENT '起始时间',
  `endTime` datetime NOT NULL COMMENT '截止时间',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(11) DEFAULT '0' COMMENT '当前告警的状态，0：未解决，１：已解决',
  `closeTime` datetime DEFAULT NULL COMMENT '当前告警的关闭时间',
  `remark` varchar(10240) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`id`),
  KEY `idxConfigId` (`configId`),
  KEY `idxStartTime` (`startTime`),
  KEY `idxEndTime` (`endTime`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=19028 DEFAULT CHARSET=utf8mb4 COMMENT='应用异常告警数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_monitor_data`
--

LOCK TABLES `app_monitor_data` WRITE;
/*!40000 ALTER TABLE `app_monitor_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_monitor_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_monitor_dept`
--

DROP TABLE IF EXISTS `app_monitor_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_monitor_dept` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `deptName` varchar(32) NOT NULL DEFAULT '' COMMENT '所属项目部的名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='应用异常告警归属项目部';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_monitor_dept`
--

LOCK TABLES `app_monitor_dept` WRITE;
/*!40000 ALTER TABLE `app_monitor_dept` DISABLE KEYS */;
INSERT INTO `app_monitor_dept` VALUES (1,'XX项目部'),(2,'YY项目部'),(3,'ZZ项目部');
/*!40000 ALTER TABLE `app_monitor_dept` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-09 15:15:33
