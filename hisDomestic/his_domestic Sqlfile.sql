/*
SQLyog Community v12.2.6 (64 bit)
MySQL - 5.7.16-log : Database - hisdomestic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hisdomestic` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hisdomestic`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(4733),
(4733);

/*Table structure for table `tbl_addiction` */

DROP TABLE IF EXISTS `tbl_addiction`;

CREATE TABLE `tbl_addiction` (
  `addictionid` int(11) NOT NULL AUTO_INCREMENT,
  `addictionname` tinytext,
  PRIMARY KEY (`addictionid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_addiction` */

insert  into `tbl_addiction`(`addictionid`,`addictionname`) values 
(1,'Other'),
(2,'Tabeco'),
(3,'Smoking'),
(4,'Alcohol');

/*Table structure for table `tbl_appointment` */

DROP TABLE IF EXISTS `tbl_appointment`;

CREATE TABLE `tbl_appointment` (
  `appid` int(11) NOT NULL AUTO_INCREMENT,
  `casetypeid` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0-pending, 1-aknowledge,2-cancel',
  `appdate` datetime DEFAULT NULL,
  `createddate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `reseaon` text,
  PRIMARY KEY (`appid`),
  KEY `tblcasetype` (`casetypeid`),
  CONSTRAINT `tblcasetype` FOREIGN KEY (`casetypeid`) REFERENCES `tbl_casetype` (`casetypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4732 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_appointment` */

insert  into `tbl_appointment`(`appid`,`casetypeid`,`status`,`appdate`,`createddate`,`reseaon`) values 
(4731,1,0,'2017-06-13 12:30:00','2017-06-13 12:05:02',NULL);

/*Table structure for table `tbl_auditlog` */

DROP TABLE IF EXISTS `tbl_auditlog`;

CREATE TABLE `tbl_auditlog` (
  `AUDIT_LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACTION` varchar(300) DEFAULT NULL,
  `DETAIL` varchar(1000) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `ENTITY_ID` bigint(20) DEFAULT NULL,
  `ENTITY_NAME` varchar(765) DEFAULT NULL,
  `EMAIL_ID` varchar(765) DEFAULT NULL,
  `PAGE_URL` varchar(765) DEFAULT NULL,
  PRIMARY KEY (`AUDIT_LOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=572 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_auditlog` */

insert  into `tbl_auditlog`(`AUDIT_LOG_ID`,`ACTION`,`DETAIL`,`CREATED_DATE`,`ENTITY_ID`,`ENTITY_NAME`,`EMAIL_ID`,`PAGE_URL`) values 
(1,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(2,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(3,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(4,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(5,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(6,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(7,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(8,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(9,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(10,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(11,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(12,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/A'),
(13,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/A-001'),
(14,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/A-001'),
(15,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/A-001'),
(16,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/A-001'),
(17,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-001'),
(18,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(19,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/7/4654'),
(20,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(21,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(22,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(23,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(24,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(25,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(26,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(27,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(28,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(29,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(30,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(31,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(32,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(33,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(34,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(35,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(36,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(37,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(38,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(39,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(40,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-001'),
(41,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(42,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/7/4654'),
(43,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(44,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(45,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(46,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(47,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(48,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(49,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(50,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(51,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(52,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(53,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-001'),
(54,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(55,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/7/4654'),
(56,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(57,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(58,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(59,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(60,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(61,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(62,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(63,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/3/0'),
(64,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/1'),
(65,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(66,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(67,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(68,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(69,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(70,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/2'),
(71,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchAppointment/test'),
(72,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchAppointment/ute'),
(73,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(74,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/7/4685'),
(75,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(76,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(77,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(78,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(79,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(80,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(81,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(82,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(83,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(84,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(85,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(86,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(87,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(88,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(89,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(90,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(91,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(92,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(93,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(94,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-001'),
(95,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/P-001'),
(96,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/P-01'),
(97,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(98,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(99,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(100,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(101,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(102,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(103,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(104,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(105,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(106,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(107,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(108,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(109,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(110,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(111,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(112,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(113,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(114,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(115,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(116,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(117,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(118,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(119,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(120,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(121,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(122,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(123,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(124,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(125,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(126,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(127,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(128,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(129,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(130,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(131,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(132,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(133,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(134,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(135,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(136,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(137,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(138,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(139,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(140,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(141,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(142,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(143,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(144,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(145,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(146,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(147,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(148,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(149,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(150,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(151,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(152,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(153,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(154,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(155,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(156,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(157,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(158,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(159,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(160,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(161,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(162,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(163,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(164,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(165,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(166,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(167,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(168,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(169,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(170,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(171,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(172,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(173,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(174,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(175,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(176,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(177,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(178,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(179,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(180,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(181,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(182,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(183,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(184,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(185,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(186,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(187,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(188,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(189,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(190,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(191,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(192,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(193,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(194,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(195,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(196,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(197,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(198,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(199,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(200,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(201,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(202,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(203,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(204,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(205,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(206,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(207,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(208,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(209,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(210,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(211,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(212,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(213,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(214,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(215,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(216,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(217,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(218,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(219,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(220,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(221,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(222,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(223,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(224,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(225,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(226,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(227,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(228,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(229,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(230,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(231,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(232,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(233,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(234,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(235,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(236,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(237,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(238,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(239,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(240,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(241,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(242,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(243,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(244,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(245,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(246,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(247,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(248,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(249,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(250,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(251,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(252,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(253,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(254,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(255,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(256,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(257,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(258,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(259,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(260,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(261,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(262,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(263,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(264,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(265,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(266,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(267,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(268,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(269,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(270,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(271,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(272,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(273,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(274,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(275,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(276,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(277,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(278,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(279,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(280,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(281,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(282,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(283,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(284,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(285,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/P-001'),
(286,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(287,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(288,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(289,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(290,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(291,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(292,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(293,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(294,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(295,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(296,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/P-001'),
(297,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(298,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/7/4727'),
(299,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(300,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(301,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(302,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(303,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(304,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(305,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(306,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(307,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(308,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(309,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-001'),
(310,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(311,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(312,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(313,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(314,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(315,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(316,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(317,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(318,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(319,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(320,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/P-001'),
(321,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(322,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(323,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(324,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(325,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(326,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(327,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(328,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(329,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(330,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(331,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-001'),
(332,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(333,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(334,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(335,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(336,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(337,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(338,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(339,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(340,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(341,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(342,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-001'),
(343,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(344,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(345,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(346,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(347,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(348,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(349,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(350,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(351,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(352,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(353,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/P-001'),
(354,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(355,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(356,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(357,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(358,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(359,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(360,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(361,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(362,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(363,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/2'),
(364,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchPatient/p-'),
(365,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(366,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/7/4727'),
(367,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(368,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(369,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(370,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(371,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(372,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(373,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(374,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(375,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(376,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(377,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(378,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(379,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/3/0'),
(380,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/1'),
(381,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(382,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(383,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(384,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(385,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(386,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/3/0'),
(387,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/1'),
(388,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(389,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(390,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(391,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(392,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(393,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/SavePatient'),
(394,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(395,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/3/0'),
(396,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/1'),
(397,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(398,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(399,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(400,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(401,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(402,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/2'),
(403,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/patient/searchAppointment/A-001'),
(404,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/cancleAppointment'),
(405,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(406,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(407,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/3/0'),
(408,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/1'),
(409,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(410,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(411,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(412,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(413,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(414,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/2/2'),
(415,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(416,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(417,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(418,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(419,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(420,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(421,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(422,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(423,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(424,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(425,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(426,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(427,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(428,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(429,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(430,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(431,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(432,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(433,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(434,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(435,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(436,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(437,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(438,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(439,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(440,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(441,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(442,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(443,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(444,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(445,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(446,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(447,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(448,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(449,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(450,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(451,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(452,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(453,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(454,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(455,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(456,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(457,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(458,'GET','User has access ','2017-06-13 00:00:00',0,'superadmin@webstrikers.com','','/hisd/domestic/user/dashboard'),
(459,'POST','User has access ','2017-06-13 00:00:00',0,'superadmin@webstrikers.com','','/hisd/domestic/user/tabcontent/1/0'),
(460,'GET','User has access ','2017-06-13 00:00:00',1,'superadmin@webstrikers.com','','/hisd/domestic/user/getstatebycountry/1'),
(461,'GET','User has access ','2017-06-13 00:00:00',0,'superadmin@webstrikers.com','','/hisd/domestic/user/dashboard'),
(462,'GET','User has access ','2017-06-13 00:00:00',0,'superadmin@webstrikers.com','','/hisd/domestic/user/dashboard'),
(463,'GET','User has access ','2017-06-13 00:00:00',0,'superadmin@webstrikers.com','','/hisd/domestic/user/dashboard'),
(464,'GET','User has access ','2017-06-13 00:00:00',0,'superadmin@webstrikers.com','','/hisd/domestic/user/dashboard'),
(465,'POST','User has access ','2017-06-13 00:00:00',0,'superadmin@webstrikers.com','','/hisd/domestic/user/tabcontent/1/0'),
(466,'GET','User has access ','2017-06-13 00:00:00',1,'superadmin@webstrikers.com','','/hisd/domestic/user/getstatebycountry/1'),
(467,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(468,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(469,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(470,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(471,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(472,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(473,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(474,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(475,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(476,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(477,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(478,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(479,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(480,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(481,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(482,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(483,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(484,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(485,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(486,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(487,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(488,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(489,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(490,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(491,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(492,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(493,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(494,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(495,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(496,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(497,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(498,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(499,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(500,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(501,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(502,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(503,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(504,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(505,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(506,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(507,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(508,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(509,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(510,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(511,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(512,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(513,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(514,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(515,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(516,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(517,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(518,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(519,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(520,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(521,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(522,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(523,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(524,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(525,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(526,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(527,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(528,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(529,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(530,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(531,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(532,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(533,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(534,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(535,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(536,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(537,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(538,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(539,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(540,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(541,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(542,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(543,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(544,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(545,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(546,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(547,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(548,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(549,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(550,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(551,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(552,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(553,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(554,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(555,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(556,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(557,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(558,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(559,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(560,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(561,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(562,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus'),
(563,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/dashboard'),
(564,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/0/0'),
(565,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/tabcontent/2/0'),
(566,'POST','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getCaseType/1/1'),
(567,'GET','User has access ','2017-06-13 00:00:00',1,'admin@123.com','','/hisd/domestic/user/getstatebycountry/1'),
(568,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getreferencetype'),
(569,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getPayBy'),
(570,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getConsltingDoctor'),
(571,'GET','User has access ','2017-06-13 00:00:00',0,'admin@123.com','','/hisd/domestic/user/getSocialEconomicStatus');

/*Table structure for table `tbl_casetype` */

DROP TABLE IF EXISTS `tbl_casetype`;

CREATE TABLE `tbl_casetype` (
  `casetypeid` int(11) NOT NULL AUTO_INCREMENT,
  `casetypename` text,
  PRIMARY KEY (`casetypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_casetype` */

insert  into `tbl_casetype`(`casetypeid`,`casetypename`) values 
(1,'New'),
(2,'FollowUp');

/*Table structure for table `tbl_consultingdoctor` */

DROP TABLE IF EXISTS `tbl_consultingdoctor`;

CREATE TABLE `tbl_consultingdoctor` (
  `consultingdoctorid` int(11) NOT NULL AUTO_INCREMENT,
  `consultingdoctorname` text NOT NULL,
  PRIMARY KEY (`consultingdoctorid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_consultingdoctor` */

insert  into `tbl_consultingdoctor`(`consultingdoctorid`,`consultingdoctorname`) values 
(1,'Dr.Shah'),
(2,'Dr. Patel');

/*Table structure for table `tbl_country` */

DROP TABLE IF EXISTS `tbl_country`;

CREATE TABLE `tbl_country` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(25) NOT NULL,
  `countryCode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_country` */

insert  into `tbl_country`(`countryId`,`countryName`,`countryCode`) values 
(1,'India','AF'),
(2,'Albania','AL'),
(3,'Algeria','DZ'),
(4,'American Samoa','AS'),
(5,'Andorra','AD'),
(6,'Angola','AO'),
(7,'Anguilla','AI'),
(8,'Antarctica','AQ'),
(9,'Antigua And Barbuda','AG'),
(10,'Argentina','AR'),
(11,'Armenia','AM'),
(12,'Aruba','AW'),
(13,'Australia','AU'),
(14,'Austria','AT'),
(15,'Azerbaijan','AZ'),
(16,'Bahamas The','BS'),
(17,'Bahrain','BH'),
(18,'Bangladesh','BD'),
(19,'Barbados','BB'),
(20,'Belarus','BY'),
(21,'Belgium','BE'),
(22,'Belize','BZ'),
(23,'Benin','BJ'),
(24,'Bermuda','BM'),
(25,'Bhutan','BT'),
(26,'Bolivia','BO'),
(27,'Bosnia and Herzegovina','BA'),
(28,'Botswana','BW'),
(29,'Bouvet Island','BV'),
(30,'Brazil','BR'),
(31,'British Indian Ocean Terr','IO'),
(32,'Brunei','BN'),
(33,'Bulgaria','BG'),
(34,'Burkina Faso','BF'),
(35,'Burundi','BI'),
(36,'Cambodia','KH'),
(37,'Cameroon','CM'),
(38,'Canada','CA'),
(39,'Cape Verde','CV'),
(40,'Cayman Islands','KY'),
(41,'Central African Republic','CF'),
(42,'Chad','TD'),
(43,'Chile','CL'),
(44,'China','CN'),
(45,'Christmas Island','CX'),
(46,'Cocos (Keeling) Islands','CC'),
(47,'Colombia','CO'),
(48,'Comoros','KM'),
(49,'Congo','CG'),
(50,'Congo The Democratic Repu','CD'),
(51,'Cook Islands','CK'),
(52,'Costa Rica','CR'),
(53,'Cote D Ivoire (Ivory Coas','CI'),
(54,'Croatia (Hrvatska)','HR'),
(55,'Cuba','CU'),
(56,'Cyprus','CY'),
(57,'Czech Republic','CZ'),
(58,'Denmark','DK'),
(59,'Djibouti','DJ'),
(60,'Dominica','DM'),
(61,'Dominican Republic','DO'),
(62,'East Timor','TP'),
(63,'Ecuador','EC'),
(64,'Egypt','EG'),
(65,'El Salvador','SV'),
(66,'Equatorial Guinea','GQ'),
(67,'Eritrea','ER'),
(68,'Estonia','EE'),
(69,'Ethiopia','ET'),
(70,'External Territories of A','XA'),
(71,'Falkland Islands','FK'),
(72,'Faroe Islands','FO'),
(73,'Fiji Islands','FJ'),
(74,'Finland','FI'),
(75,'France','FR'),
(76,'French Guiana','GF'),
(77,'French Polynesia','PF'),
(78,'French Southern Territori','TF'),
(79,'Gabon','GA'),
(80,'Gambia The','GM'),
(81,'Georgia','GE'),
(82,'Germany','DE'),
(83,'Ghana','GH'),
(84,'Gibraltar','GI'),
(85,'Greece','GR'),
(86,'Greenland','GL'),
(87,'Grenada','GD'),
(88,'Guadeloupe','GP'),
(89,'Guam','GU'),
(90,'Guatemala','GT'),
(91,'Guernsey and Alderney','XU'),
(92,'Guinea','GN'),
(93,'Guinea-Bissau','GW'),
(94,'Guyana','GY'),
(95,'Haiti','HT'),
(96,'Heard and McDonald Island','HM'),
(97,'Honduras','HN'),
(98,'Hong Kong S.A.R.','HK'),
(99,'Hungary','HU'),
(100,'Iceland','IS'),
(101,'Afghanistan','IN'),
(102,'Indonesia','ID'),
(103,'Iran','IR'),
(104,'Iraq','IQ'),
(105,'Ireland','IE'),
(106,'Israel','IL'),
(107,'Italy','IT'),
(108,'Jamaica','JM'),
(109,'Japan','JP'),
(110,'Jersey','XJ'),
(111,'Jordan','JO'),
(112,'Kazakhstan','KZ'),
(113,'Kenya','KE'),
(114,'Kiribati','KI'),
(115,'Korea North','KP'),
(116,'Korea South','KR'),
(117,'Kuwait','KW'),
(118,'Kyrgyzstan','KG'),
(119,'Laos','LA'),
(120,'Latvia','LV'),
(121,'Lebanon','LB'),
(122,'Lesotho','LS'),
(123,'Liberia','LR'),
(124,'Libya','LY'),
(125,'Liechtenstein','LI'),
(126,'Lithuania','LT'),
(127,'Luxembourg','LU'),
(128,'Macau S.A.R.','MO'),
(129,'Macedonia','MK'),
(130,'Madagascar','MG'),
(131,'Malawi','MW'),
(132,'Malaysia','MY'),
(133,'Maldives','MV'),
(134,'Mali','ML'),
(135,'Malta','MT'),
(136,'Man (Isle of)','XM'),
(137,'Marshall Islands','MH'),
(138,'Martinique','MQ'),
(139,'Mauritania','MR'),
(140,'Mauritius','MU'),
(141,'Mayotte','YT'),
(142,'Mexico','MX'),
(143,'Micronesia','FM'),
(144,'Moldova','MD'),
(145,'Monaco','MC'),
(146,'Mongolia','MN'),
(147,'Montserrat','MS'),
(148,'Morocco','MA'),
(149,'Mozambique','MZ'),
(150,'Myanmar','MM'),
(151,'Namibia','NA'),
(152,'Nauru','NR'),
(153,'Nepal','NP'),
(154,'Netherlands Antilles','AN'),
(155,'Netherlands The','NL'),
(156,'New Caledonia','NC'),
(157,'New Zealand','NZ'),
(158,'Nicaragua','NI'),
(159,'Niger','NE'),
(160,'Nigeria','NG'),
(161,'Niue','NU'),
(162,'Norfolk Island','NF'),
(163,'Northern Mariana Islands','MP'),
(164,'Norway','NO'),
(165,'Oman','OM'),
(166,'Pakistan','PK'),
(167,'Palau','PW'),
(168,'Palestinian Territory Occ','PS'),
(169,'Panama','PA'),
(170,'Papua new Guinea','PG'),
(171,'Paraguay','PY'),
(172,'Peru','PE'),
(173,'Philippines','PH'),
(174,'Pitcairn Island','PN'),
(175,'Poland','PL'),
(176,'Portugal','PT'),
(177,'Puerto Rico','PR'),
(178,'Qatar','QA'),
(179,'Reunion','RE'),
(180,'Romania','RO'),
(181,'Russia','RU'),
(182,'Rwanda','RW'),
(183,'Saint Helena','SH'),
(184,'Saint Kitts And Nevis','KN'),
(185,'Saint Lucia','LC'),
(186,'Saint Pierre and Miquelon','PM'),
(187,'Saint Vincent And The Gre','VC'),
(188,'Samoa','WS'),
(189,'San Marino','SM'),
(190,'Sao Tome and Principe','ST'),
(191,'Saudi Arabia','SA'),
(192,'Senegal','SN'),
(193,'Serbia','RS'),
(194,'Seychelles','SC'),
(195,'Sierra Leone','SL'),
(196,'Singapore','SG'),
(197,'Slovakia','SK'),
(198,'Slovenia','SI'),
(199,'Smaller Territories of th','XG'),
(200,'Solomon Islands','SB'),
(201,'Somalia','SO'),
(202,'South Africa','ZA'),
(203,'South Georgia','GS'),
(204,'South Sudan','SS'),
(205,'Spain','ES'),
(206,'Sri Lanka','LK'),
(207,'Sudan','SD'),
(208,'Suriname','SR'),
(209,'Svalbard And Jan Mayen Is','SJ'),
(210,'Swaziland','SZ'),
(211,'Sweden','SE'),
(212,'Switzerland','CH'),
(213,'Syria','SY'),
(214,'Taiwan','TW'),
(215,'Tajikistan','TJ'),
(216,'Tanzania','TZ'),
(217,'Thailand','TH'),
(218,'Togo','TG'),
(219,'Tokelau','TK'),
(220,'Tonga','TO'),
(221,'Trinidad And Tobago','TT'),
(222,'Tunisia','TN'),
(223,'Turkey','TR'),
(224,'Turkmenistan','TM'),
(225,'Turks And Caicos Islands','TC'),
(226,'Tuvalu','TV'),
(227,'Uganda','UG'),
(228,'Ukraine','UA'),
(229,'United Arab Emirates','AE'),
(230,'United Kingdom','GB'),
(231,'United States','US'),
(232,'United States Minor Outly','UM'),
(233,'Uruguay','UY'),
(234,'Uzbekistan','UZ'),
(235,'Vanuatu','VU'),
(236,'Vatican City State (Holy ','VA'),
(237,'Venezuela','VE'),
(238,'Vietnam','VN'),
(239,'Virgin Islands (British)','VG'),
(240,'Virgin Islands (US)','VI'),
(241,'Wallis And Futuna Islands','WF'),
(242,'Western Sahara','EH'),
(243,'Yemen','YE'),
(244,'Yugoslavia','YU'),
(245,'Zambia','ZM'),
(246,'Zimbabwe','ZW');

/*Table structure for table `tbl_designation` */

DROP TABLE IF EXISTS `tbl_designation`;

CREATE TABLE `tbl_designation` (
  `designationid` int(11) NOT NULL AUTO_INCREMENT,
  `designationname` text NOT NULL,
  PRIMARY KEY (`designationid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_designation` */

insert  into `tbl_designation`(`designationid`,`designationname`) values 
(1,'PhD'),
(2,'MBBS'),
(3,'MD'),
(4,'MPH');

/*Table structure for table `tbl_patient` */

DROP TABLE IF EXISTS `tbl_patient`;

CREATE TABLE `tbl_patient` (
  `patientid` int(11) NOT NULL AUTO_INCREMENT,
  `patientcrno` varchar(50) DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `referenceid` int(11) DEFAULT NULL,
  `socialeconomicstatusid` int(11) DEFAULT NULL,
  `paybyid` int(11) DEFAULT NULL,
  `consultingdoctorid` int(11) NOT NULL,
  `isdiabetic` int(11) DEFAULT '0',
  `ishignbp` int(11) DEFAULT '0',
  `userdetailid` int(11) DEFAULT NULL,
  `refothersname` text,
  `patbyname` text,
  `appid` int(11) DEFAULT NULL,
  `addictionother` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`patientid`),
  KEY `tblrefrence` (`referenceid`),
  KEY `tblconsltingDoctor` (`consultingdoctorid`),
  KEY `tbluser` (`userdetailid`),
  CONSTRAINT `tblconsltingDoctor` FOREIGN KEY (`consultingdoctorid`) REFERENCES `tbl_consultingdoctor` (`consultingdoctorid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tbluser` FOREIGN KEY (`userdetailid`) REFERENCES `tbl_user` (`userdetailid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4733 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_patient` */

insert  into `tbl_patient`(`patientid`,`patientcrno`,`regdate`,`age`,`referenceid`,`socialeconomicstatusid`,`paybyid`,`consultingdoctorid`,`isdiabetic`,`ishignbp`,`userdetailid`,`refothersname`,`patbyname`,`appid`,`addictionother`) values 
(4727,'P-001','2017-06-13 00:00:00',0,0,0,0,1,0,0,4726,NULL,NULL,0,''),
(4732,'A-001',NULL,0,0,0,0,1,0,0,4730,NULL,NULL,4731,NULL);

/*Table structure for table `tbl_patientaddiction` */

DROP TABLE IF EXISTS `tbl_patientaddiction`;

CREATE TABLE `tbl_patientaddiction` (
  `patientaddictionid` int(11) NOT NULL AUTO_INCREMENT,
  `patientid` int(11) NOT NULL,
  `addictionid` int(11) NOT NULL,
  PRIMARY KEY (`patientaddictionid`),
  KEY `tblpatient` (`patientid`),
  KEY `tbladdiction` (`addictionid`),
  CONSTRAINT `tbladdiction` FOREIGN KEY (`addictionid`) REFERENCES `tbl_addiction` (`addictionid`)
) ENGINE=InnoDB AUTO_INCREMENT=4730 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_patientaddiction` */

insert  into `tbl_patientaddiction`(`patientaddictionid`,`patientid`,`addictionid`) values 
(4697,4696,3),
(4698,4696,2),
(4705,4704,3),
(4706,4704,2),
(4710,4709,4),
(4711,4709,2),
(4721,4720,1),
(4724,4723,3),
(4725,4723,1),
(4728,4727,3),
(4729,4727,1);

/*Table structure for table `tbl_patientreference` */

DROP TABLE IF EXISTS `tbl_patientreference`;

CREATE TABLE `tbl_patientreference` (
  `referenceid` int(11) NOT NULL AUTO_INCREMENT,
  `referencebytypeid` int(11) NOT NULL,
  `referencedtl` text,
  PRIMARY KEY (`referenceid`),
  KEY `tblreferencetype` (`referencebytypeid`),
  CONSTRAINT `tblreferencetype` FOREIGN KEY (`referencebytypeid`) REFERENCES `tbl_referencebytype` (`referencebytypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4717 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_patientreference` */

insert  into `tbl_patientreference`(`referenceid`,`referencebytypeid`,`referencedtl`) values 
(4652,2,'test'),
(4658,1,'test'),
(4679,2,'test'),
(4683,2,'test'),
(4689,2,'rwar'),
(4694,3,'test'),
(4702,1,'test'),
(4707,3,''),
(4716,3,'test');

/*Table structure for table `tbl_payby` */

DROP TABLE IF EXISTS `tbl_payby`;

CREATE TABLE `tbl_payby` (
  `paybyid` int(11) NOT NULL AUTO_INCREMENT,
  `paybyname` text NOT NULL,
  PRIMARY KEY (`paybyid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_payby` */

insert  into `tbl_payby`(`paybyid`,`paybyname`) values 
(1,'Other'),
(2,'Insurance'),
(3,'Government scheme'),
(4,'Self');

/*Table structure for table `tbl_referencebytype` */

DROP TABLE IF EXISTS `tbl_referencebytype`;

CREATE TABLE `tbl_referencebytype` (
  `referencebytypeid` int(11) NOT NULL AUTO_INCREMENT,
  `referencebytypename` varchar(25) NOT NULL,
  PRIMARY KEY (`referencebytypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_referencebytype` */

insert  into `tbl_referencebytype`(`referencebytypeid`,`referencebytypename`) values 
(1,'Other'),
(2,'Patient'),
(3,'Doctor');

/*Table structure for table `tbl_socialeconomicstatus` */

DROP TABLE IF EXISTS `tbl_socialeconomicstatus`;

CREATE TABLE `tbl_socialeconomicstatus` (
  `socialeconomicstatusid` int(11) NOT NULL AUTO_INCREMENT,
  `socialeconomicstatusname` text NOT NULL,
  PRIMARY KEY (`socialeconomicstatusid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_socialeconomicstatus` */

insert  into `tbl_socialeconomicstatus`(`socialeconomicstatusid`,`socialeconomicstatusname`) values 
(1,'Low'),
(2,'Middle'),
(3,'High');

/*Table structure for table `tbl_state` */

DROP TABLE IF EXISTS `tbl_state`;

CREATE TABLE `tbl_state` (
  `stateId` int(11) NOT NULL AUTO_INCREMENT,
  `stateName` varchar(25) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`stateId`),
  KEY `countryId` (`countryId`),
  CONSTRAINT `tbl_state_ibfk_1` FOREIGN KEY (`countryId`) REFERENCES `tbl_country` (`countryId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2182 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_state` */

insert  into `tbl_state`(`stateId`,`stateName`,`countryId`) values 
(1,'Andaman and Nicobar Islan',1),
(2,'Andhra Pradesh',1),
(3,'Arunachal Pradesh',1),
(4,'Assam',1),
(5,'Bihar',1),
(6,'Chandigarh',1),
(7,'Chhattisgarh',1),
(8,'Dadra and Nagar Haveli',1),
(9,'Daman and Diu',1),
(10,'Delhi',1),
(11,'Goa',1),
(12,'Gujarat',1),
(13,'Haryana',1),
(14,'Himachal Pradesh',1),
(15,'Jammu and Kashmir',1),
(16,'Jharkhand',1),
(17,'Karnataka',1),
(18,'Kenmore',1),
(19,'Kerala',1),
(20,'Lakshadweep',1),
(21,'Madhya Pradesh',1),
(22,'Maharashtra',1),
(23,'Manipur',1),
(24,'Meghalaya',1),
(25,'Mizoram',1),
(26,'Nagaland',1),
(27,'Narora',1),
(28,'Natwar',1),
(29,'Odisha',1),
(30,'Paschim Medinipur',1),
(31,'Pondicherry',1),
(32,'Punjab',1),
(33,'Rajasthan',1),
(34,'Sikkim',1),
(35,'Tamil Nadu',1),
(36,'Telangana',1),
(37,'Tripura',1),
(38,'Uttar Pradesh',1),
(39,'Uttarakhand',1),
(40,'Vaishali',1),
(41,'West Bengal',1),
(42,'Badakhshan',101),
(43,'Badgis',101),
(44,'Baglan',101),
(45,'Balkh',101),
(46,'Bamiyan',101),
(47,'Farah',101),
(48,'Faryab',101),
(49,'Gawr',101),
(50,'Gazni',101),
(51,'Herat',101),
(52,'Hilmand',101),
(53,'Jawzjan',101),
(54,'Kabul',101),
(55,'Kapisa',101),
(56,'Khawst',101),
(57,'Kunar',101),
(58,'Lagman',101),
(59,'Lawghar',101),
(60,'Nangarhar',101),
(61,'Nimruz',101),
(62,'Nuristan',101),
(63,'Paktika',101),
(64,'Paktiya',101),
(65,'Parwan',101),
(66,'Qandahar',101),
(67,'Qunduz',101),
(68,'Samangan',101),
(69,'Sar-e Pul',101),
(70,'Takhar',101),
(71,'Uruzgan',101),
(72,'Wardag',101),
(73,'Zabul',101),
(74,'Berat',2),
(75,'Bulqize',2),
(76,'Delvine',2),
(77,'Devoll',2),
(78,'Dibre',2),
(79,'Durres',2),
(80,'Elbasan',2),
(81,'Fier',2),
(82,'Gjirokaster',2),
(83,'Gramsh',2),
(84,'Has',2),
(85,'Kavaje',2),
(86,'Kolonje',2),
(87,'Korce',2),
(88,'Kruje',2),
(89,'Kucove',2),
(90,'Kukes',2),
(91,'Kurbin',2),
(92,'Lezhe',2),
(93,'Librazhd',2),
(94,'Lushnje',2),
(95,'Mallakaster',2),
(96,'Malsi e Madhe',2),
(97,'Mat',2),
(98,'Mirdite',2),
(99,'Peqin',2),
(100,'Permet',2),
(101,'Pogradec',2),
(102,'Puke',2),
(103,'Sarande',2),
(104,'Shkoder',2),
(105,'Skrapar',2),
(106,'Tepelene',2),
(107,'Tirane',2),
(108,'Tropoje',2),
(109,'Vlore',2),
(110,'Ayn Daflah',3),
(111,'Ayn Tamushanat',3),
(112,'Adrar',3),
(113,'Algiers',3),
(114,'Annabah',3),
(115,'Bashshar',3),
(116,'Batnah',3),
(117,'Bijayah',3),
(118,'Biskrah',3),
(119,'Blidah',3),
(120,'Buirah',3),
(121,'Bumardas',3),
(122,'Burj Bu Arririj',3),
(123,'Ghalizan',3),
(124,'Ghardayah',3),
(125,'Ilizi',3),
(126,'Jijili',3),
(127,'Jilfah',3),
(128,'Khanshalah',3),
(129,'Masilah',3),
(130,'Midyah',3),
(131,'Milah',3),
(132,'Muaskar',3),
(133,'Mustaghanam',3),
(134,'Naama',3),
(135,'Oran',3),
(136,'Ouargla',3),
(137,'Qalmah',3),
(138,'Qustantinah',3),
(139,'Sakikdah',3),
(140,'Satif',3),
(141,'Sayda',3),
(142,'Sidi ban-al-Abbas',3),
(143,'Suq Ahras',3),
(144,'Tamanghasat',3),
(145,'Tibazah',3),
(146,'Tibissah',3),
(147,'Tilimsan',3),
(148,'Tinduf',3),
(149,'Tisamsilt',3),
(150,'Tiyarat',3),
(151,'Tizi Wazu',3),
(152,'Umm-al-Bawaghi',3),
(153,'Wahran',3),
(154,'Warqla',3),
(155,'Wilaya d Alger',3),
(156,'Wilaya de Bejaia',3),
(157,'Wilaya de Constantine',3),
(158,'al-Aghwat',3),
(159,'al-Bayadh',3),
(160,'al-Jazair',3),
(161,'al-Wad',3),
(162,'ash-Shalif',3),
(163,'at-Tarif',3),
(164,'Eastern',4),
(165,'Manua',4),
(166,'Swains Island',4),
(167,'Western',4),
(168,'Andorra la Vella',5),
(169,'Canillo',5),
(170,'Encamp',5),
(171,'La Massana',5),
(172,'Les Escaldes',5),
(173,'Ordino',5),
(174,'Sant Julia de Loria',5),
(175,'Bengo',6),
(176,'Benguela',6),
(177,'Bie',6),
(178,'Cabinda',6),
(179,'Cunene',6),
(180,'Huambo',6),
(181,'Huila',6),
(182,'Kuando-Kubango',6),
(183,'Kwanza Norte',6),
(184,'Kwanza Sul',6),
(185,'Luanda',6),
(186,'Lunda Norte',6),
(187,'Lunda Sul',6),
(188,'Malanje',6),
(189,'Moxico',6),
(190,'Namibe',6),
(191,'Uige',6),
(192,'Zaire',6),
(193,'Other Provinces',7),
(194,'Sector claimed by Argenti',8),
(195,'Sector claimed by Argenti',8),
(196,'Sector claimed by Austral',8),
(197,'Sector claimed by France',8),
(198,'Sector claimed by New Zea',8),
(199,'Sector claimed by Norway',8),
(200,'Unclaimed Sector',8),
(201,'Barbuda',9),
(202,'Saint George',9),
(203,'Saint John',9),
(204,'Saint Mary',9),
(205,'Saint Paul',9),
(206,'Saint Peter',9),
(207,'Saint Philip',9),
(208,'Buenos Aires',10),
(209,'Catamarca',10),
(210,'Chaco',10),
(211,'Chubut',10),
(212,'Cordoba',10),
(213,'Corrientes',10),
(214,'Distrito Federal',10),
(215,'Entre Rios',10),
(216,'Formosa',10),
(217,'Jujuy',10),
(218,'La Pampa',10),
(219,'La Rioja',10),
(220,'Mendoza',10),
(221,'Misiones',10),
(222,'Neuquen',10),
(223,'Rio Negro',10),
(224,'Salta',10),
(225,'San Juan',10),
(226,'San Luis',10),
(227,'Santa Cruz',10),
(228,'Santa Fe',10),
(229,'Santiago del Estero',10),
(230,'Tierra del Fuego',10),
(231,'Tucuman',10),
(232,'Aragatsotn',11),
(233,'Ararat',11),
(234,'Armavir',11),
(235,'Gegharkunik',11),
(236,'Kotaik',11),
(237,'Lori',11),
(238,'Shirak',11),
(239,'Stepanakert',11),
(240,'Syunik',11),
(241,'Tavush',11),
(242,'Vayots Dzor',11),
(243,'Yerevan',11),
(244,'Aruba',12),
(245,'Auckland',13),
(246,'Australian Capital Territ',13),
(247,'Balgowlah',13),
(248,'Balmain',13),
(249,'Bankstown',13),
(250,'Baulkham Hills',13),
(251,'Bonnet Bay',13),
(252,'Camberwell',13),
(253,'Carole Park',13),
(254,'Castle Hill',13),
(255,'Caulfield',13),
(256,'Chatswood',13),
(257,'Cheltenham',13),
(258,'Cherrybrook',13),
(259,'Clayton',13),
(260,'Collingwood',13),
(261,'Frenchs Forest',13),
(262,'Hawthorn',13),
(263,'Jannnali',13),
(264,'Knoxfield',13),
(265,'Melbourne',13),
(266,'New South Wales',13),
(267,'Northern Territory',13),
(268,'Perth',13),
(269,'Queensland',13),
(270,'South Australia',13),
(271,'Tasmania',13),
(272,'Templestowe',13),
(273,'Victoria',13),
(274,'Werribee south',13),
(275,'Western Australia',13),
(276,'Wheeler',13),
(277,'Bundesland Salzburg',14),
(278,'Bundesland Steiermark',14),
(279,'Bundesland Tirol',14),
(280,'Burgenland',14),
(281,'Carinthia',14),
(282,'Karnten',14),
(283,'Liezen',14),
(284,'Lower Austria',14),
(285,'Niederosterreich',14),
(286,'Oberosterreich',14),
(287,'Salzburg',14),
(288,'Schleswig-Holstein',14),
(289,'Steiermark',14),
(290,'Styria',14),
(291,'Tirol',14),
(292,'Upper Austria',14),
(293,'Vorarlberg',14),
(294,'Wien',14),
(295,'Abseron',15),
(296,'Baki Sahari',15),
(297,'Ganca',15),
(298,'Ganja',15),
(299,'Kalbacar',15),
(300,'Lankaran',15),
(301,'Mil-Qarabax',15),
(302,'Mugan-Salyan',15),
(303,'Nagorni-Qarabax',15),
(304,'Naxcivan',15),
(305,'Priaraks',15),
(306,'Qazax',15),
(307,'Saki',15),
(308,'Sirvan',15),
(309,'Xacmaz',15),
(310,'Abaco',16),
(311,'Acklins Island',16),
(312,'Andros',16),
(313,'Berry Islands',16),
(314,'Biminis',16),
(315,'Cat Island',16),
(316,'Crooked Island',16),
(317,'Eleuthera',16),
(318,'Exuma and Cays',16),
(319,'Grand Bahama',16),
(320,'Inagua Islands',16),
(321,'Long Island',16),
(322,'Mayaguana',16),
(323,'New Providence',16),
(324,'Ragged Island',16),
(325,'Rum Cay',16),
(326,'San Salvador',16),
(327,'Isa',17),
(328,'Badiyah',17),
(329,'Hidd',17),
(330,'Jidd Hafs',17),
(331,'Mahama',17),
(332,'Manama',17),
(333,'Sitrah',17),
(334,'al-Manamah',17),
(335,'al-Muharraq',17),
(336,'ar-Rifaa',17),
(337,'Bagar Hat',18),
(338,'Bandarban',18),
(339,'Barguna',18),
(340,'Barisal',18),
(341,'Bhola',18),
(342,'Bogora',18),
(343,'Brahman Bariya',18),
(344,'Chandpur',18),
(345,'Chattagam',18),
(346,'Chittagong Division',18),
(347,'Chuadanga',18),
(348,'Dhaka',18),
(349,'Dinajpur',18),
(350,'Faridpur',18),
(351,'Feni',18),
(352,'Gaybanda',18),
(353,'Gazipur',18),
(354,'Gopalganj',18),
(355,'Habiganj',18),
(356,'Jaipur Hat',18),
(357,'Jamalpur',18),
(358,'Jessor',18),
(359,'Jhalakati',18),
(360,'Jhanaydah',18),
(361,'Khagrachhari',18),
(362,'Khulna',18),
(363,'Kishorganj',18),
(364,'Koks Bazar',18),
(365,'Komilla',18),
(366,'Kurigram',18),
(367,'Kushtiya',18),
(368,'Lakshmipur',18),
(369,'Lalmanir Hat',18),
(370,'Madaripur',18),
(371,'Magura',18),
(372,'Maimansingh',18),
(373,'Manikganj',18),
(374,'Maulvi Bazar',18),
(375,'Meherpur',18),
(376,'Munshiganj',18),
(377,'Naral',18),
(378,'Narayanganj',18),
(379,'Narsingdi',18),
(380,'Nator',18),
(381,'Naugaon',18),
(382,'Nawabganj',18),
(383,'Netrakona',18),
(384,'Nilphamari',18),
(385,'Noakhali',18),
(386,'Pabna',18),
(387,'Panchagarh',18),
(388,'Patuakhali',18),
(389,'Pirojpur',18),
(390,'Rajbari',18),
(391,'Rajshahi',18),
(392,'Rangamati',18),
(393,'Rangpur',18),
(394,'Satkhira',18),
(395,'Shariatpur',18),
(396,'Sherpur',18),
(397,'Silhat',18),
(398,'Sirajganj',18),
(399,'Sunamganj',18),
(400,'Tangayal',18),
(401,'Thakurgaon',18),
(402,'Christ Church',19),
(403,'Saint Andrew',19),
(404,'Saint George',19),
(405,'Saint James',19),
(406,'Saint John',19),
(407,'Saint Joseph',19),
(408,'Saint Lucy',19),
(409,'Saint Michael',19),
(410,'Saint Peter',19),
(411,'Saint Philip',19),
(412,'Saint Thomas',19),
(413,'Brest',20),
(414,'Homjel',20),
(415,'Hrodna',20),
(416,'Mahiljow',20),
(417,'Mahilyowskaya Voblasts',20),
(418,'Minsk',20),
(419,'Minskaja Voblasts',20),
(420,'Petrik',20),
(421,'Vicebsk',20),
(422,'Antwerpen',21),
(423,'Berchem',21),
(424,'Brabant',21),
(425,'Brabant Wallon',21),
(426,'Brussel',21),
(427,'East Flanders',21),
(428,'Hainaut',21),
(429,'Liege',21),
(430,'Limburg',21),
(431,'Luxembourg',21),
(432,'Namur',21),
(433,'Ontario',21),
(434,'Oost-Vlaanderen',21),
(435,'Provincie Brabant',21),
(436,'Vlaams-Brabant',21),
(437,'Wallonne',21),
(438,'West-Vlaanderen',21),
(439,'Belize',22),
(440,'Cayo',22),
(441,'Corozal',22),
(442,'Orange Walk',22),
(443,'Stann Creek',22),
(444,'Toledo',22),
(445,'Alibori',23),
(446,'Atacora',23),
(447,'Atlantique',23),
(448,'Borgou',23),
(449,'Collines',23),
(450,'Couffo',23),
(451,'Donga',23),
(452,'Littoral',23),
(453,'Mono',23),
(454,'Oueme',23),
(455,'Plateau',23),
(456,'Zou',23),
(457,'Hamilton',24),
(458,'Saint George',24),
(459,'Bumthang',25),
(460,'Chhukha',25),
(461,'Chirang',25),
(462,'Daga',25),
(463,'Geylegphug',25),
(464,'Ha',25),
(465,'Lhuntshi',25),
(466,'Mongar',25),
(467,'Pemagatsel',25),
(468,'Punakha',25),
(469,'Rinpung',25),
(470,'Samchi',25),
(471,'Samdrup Jongkhar',25),
(472,'Shemgang',25),
(473,'Tashigang',25),
(474,'Timphu',25),
(475,'Tongsa',25),
(476,'Wangdiphodrang',25),
(477,'Beni',26),
(478,'Chuquisaca',26),
(479,'Cochabamba',26),
(480,'La Paz',26),
(481,'Oruro',26),
(482,'Pando',26),
(483,'Potosi',26),
(484,'Santa Cruz',26),
(485,'Tarija',26),
(486,'Federacija Bosna i Herceg',27),
(487,'Republika Srpska',27),
(488,'Central Bobonong',28),
(489,'Central Boteti',28),
(490,'Central Mahalapye',28),
(491,'Central Serowe-Palapye',28),
(492,'Central Tutume',28),
(493,'Chobe',28),
(494,'Francistown',28),
(495,'Gaborone',28),
(496,'Ghanzi',28),
(497,'Jwaneng',28),
(498,'Kgalagadi North',28),
(499,'Kgalagadi South',28),
(500,'Kgatleng',28),
(501,'Kweneng',28),
(502,'Lobatse',28),
(503,'Ngamiland',28),
(504,'Ngwaketse',28),
(505,'North East',28),
(506,'Okavango',28),
(507,'Orapa',28),
(508,'Selibe Phikwe',28),
(509,'South East',28),
(510,'Sowa',28),
(511,'Bouvet Island',29),
(512,'Acre',30),
(513,'Alagoas',30),
(514,'Amapa',30),
(515,'Amazonas',30),
(516,'Bahia',30),
(517,'Ceara',30),
(518,'Distrito Federal',30),
(519,'Espirito Santo',30),
(520,'Estado de Sao Paulo',30),
(521,'Goias',30),
(522,'Maranhao',30),
(523,'Mato Grosso',30),
(524,'Mato Grosso do Sul',30),
(525,'Minas Gerais',30),
(526,'Para',30),
(527,'Paraiba',30),
(528,'Parana',30),
(529,'Pernambuco',30),
(530,'Piaui',30),
(531,'Rio Grande do Norte',30),
(532,'Rio Grande do Sul',30),
(533,'Rio de Janeiro',30),
(534,'Rondonia',30),
(535,'Roraima',30),
(536,'Santa Catarina',30),
(537,'Sao Paulo',30),
(538,'Sergipe',30),
(539,'Tocantins',30),
(540,'British Indian Ocean Terr',31),
(541,'Belait',32),
(542,'Brunei-Muara',32),
(543,'Temburong',32),
(544,'Tutong',32),
(545,'Blagoevgrad',33),
(546,'Burgas',33),
(547,'Dobrich',33),
(548,'Gabrovo',33),
(549,'Haskovo',33),
(550,'Jambol',33),
(551,'Kardzhali',33),
(552,'Kjustendil',33),
(553,'Lovech',33),
(554,'Montana',33),
(555,'Oblast Sofiya-Grad',33),
(556,'Pazardzhik',33),
(557,'Pernik',33),
(558,'Pleven',33),
(559,'Plovdiv',33),
(560,'Razgrad',33),
(561,'Ruse',33),
(562,'Shumen',33),
(563,'Silistra',33),
(564,'Sliven',33),
(565,'Smoljan',33),
(566,'Sofija grad',33),
(567,'Sofijska oblast',33),
(568,'Stara Zagora',33),
(569,'Targovishte',33),
(570,'Varna',33),
(571,'Veliko Tarnovo',33),
(572,'Vidin',33),
(573,'Vraca',33),
(574,'Yablaniza',33),
(575,'Bale',34),
(576,'Bam',34),
(577,'Bazega',34),
(578,'Bougouriba',34),
(579,'Boulgou',34),
(580,'Boulkiemde',34),
(581,'Comoe',34),
(582,'Ganzourgou',34),
(583,'Gnagna',34),
(584,'Gourma',34),
(585,'Houet',34),
(586,'Ioba',34),
(587,'Kadiogo',34),
(588,'Kenedougou',34),
(589,'Komandjari',34),
(590,'Kompienga',34),
(591,'Kossi',34),
(592,'Kouritenga',34),
(593,'Kourweogo',34),
(594,'Leraba',34),
(595,'Mouhoun',34),
(596,'Nahouri',34),
(597,'Namentenga',34),
(598,'Noumbiel',34),
(599,'Oubritenga',34),
(600,'Oudalan',34),
(601,'Passore',34),
(602,'Poni',34),
(603,'Sanguie',34),
(604,'Sanmatenga',34),
(605,'Seno',34),
(606,'Sissili',34),
(607,'Soum',34),
(608,'Sourou',34),
(609,'Tapoa',34),
(610,'Tuy',34),
(611,'Yatenga',34),
(612,'Zondoma',34),
(613,'Zoundweogo',34),
(614,'Bubanza',35),
(615,'Bujumbura',35),
(616,'Bururi',35),
(617,'Cankuzo',35),
(618,'Cibitoke',35),
(619,'Gitega',35),
(620,'Karuzi',35),
(621,'Kayanza',35),
(622,'Kirundo',35),
(623,'Makamba',35),
(624,'Muramvya',35),
(625,'Muyinga',35),
(626,'Ngozi',35),
(627,'Rutana',35),
(628,'Ruyigi',35),
(629,'Banteay Mean Chey',36),
(630,'Bat Dambang',36),
(631,'Kampong Cham',36),
(632,'Kampong Chhnang',36),
(633,'Kampong Spoeu',36),
(634,'Kampong Thum',36),
(635,'Kampot',36),
(636,'Kandal',36),
(637,'Kaoh Kong',36),
(638,'Kracheh',36),
(639,'Krong Kaeb',36),
(640,'Krong Pailin',36),
(641,'Krong Preah Sihanouk',36),
(642,'Mondol Kiri',36),
(643,'Otdar Mean Chey',36),
(644,'Phnum Penh',36),
(645,'Pousat',36),
(646,'Preah Vihear',36),
(647,'Prey Veaeng',36),
(648,'Rotanak Kiri',36),
(649,'Siem Reab',36),
(650,'Stueng Traeng',36),
(651,'Svay Rieng',36),
(652,'Takaev',36),
(653,'Adamaoua',37),
(654,'Centre',37),
(655,'Est',37),
(656,'Littoral',37),
(657,'Nord',37),
(658,'Nord Extreme',37),
(659,'Nordouest',37),
(660,'Ouest',37),
(661,'Sud',37),
(662,'Sudouest',37),
(663,'Alberta',38),
(664,'British Columbia',38),
(665,'Manitoba',38),
(666,'New Brunswick',38),
(667,'Newfoundland and Labrador',38),
(668,'Northwest Territories',38),
(669,'Nova Scotia',38),
(670,'Nunavut',38),
(671,'Ontario',38),
(672,'Prince Edward Island',38),
(673,'Quebec',38),
(674,'Saskatchewan',38),
(675,'Yukon',38),
(676,'Boavista',39),
(677,'Brava',39),
(678,'Fogo',39),
(679,'Maio',39),
(680,'Sal',39),
(681,'Santo Antao',39),
(682,'Sao Nicolau',39),
(683,'Sao Tiago',39),
(684,'Sao Vicente',39),
(685,'Grand Cayman',40),
(686,'Bamingui-Bangoran',41),
(687,'Bangui',41),
(688,'Basse-Kotto',41),
(689,'Haut-Mbomou',41),
(690,'Haute-Kotto',41),
(691,'Kemo',41),
(692,'Lobaye',41),
(693,'Mambere-Kadei',41),
(694,'Mbomou',41),
(695,'Nana-Gribizi',41),
(696,'Nana-Mambere',41),
(697,'Ombella Mpoko',41),
(698,'Ouaka',41),
(699,'Ouham',41),
(700,'Ouham-Pende',41),
(701,'Sangha-Mbaere',41),
(702,'Vakaga',41),
(703,'Batha',42),
(704,'Biltine',42),
(705,'Bourkou-Ennedi-Tibesti',42),
(706,'Chari-Baguirmi',42),
(707,'Guera',42),
(708,'Kanem',42),
(709,'Lac',42),
(710,'Logone Occidental',42),
(711,'Logone Oriental',42),
(712,'Mayo-Kebbi',42),
(713,'Moyen-Chari',42),
(714,'Ouaddai',42),
(715,'Salamat',42),
(716,'Tandjile',42),
(717,'Aisen',43),
(718,'Antofagasta',43),
(719,'Araucania',43),
(720,'Atacama',43),
(721,'Bio Bio',43),
(722,'Coquimbo',43),
(723,'Libertador General Bernar',43),
(724,'Los Lagos',43),
(725,'Magellanes',43),
(726,'Maule',43),
(727,'Metropolitana',43),
(728,'Metropolitana de Santiago',43),
(729,'Tarapaca',43),
(730,'Valparaiso',43),
(731,'Anhui',44),
(732,'Anhui Province',44),
(733,'Anhui Sheng',44),
(734,'Aomen',44),
(735,'Beijing',44),
(736,'Beijing Shi',44),
(737,'Chongqing',44),
(738,'Fujian',44),
(739,'Fujian Sheng',44),
(740,'Gansu',44),
(741,'Guangdong',44),
(742,'Guangdong Sheng',44),
(743,'Guangxi',44),
(744,'Guizhou',44),
(745,'Hainan',44),
(746,'Hebei',44),
(747,'Heilongjiang',44),
(748,'Henan',44),
(749,'Hubei',44),
(750,'Hunan',44),
(751,'Jiangsu',44),
(752,'Jiangsu Sheng',44),
(753,'Jiangxi',44),
(754,'Jilin',44),
(755,'Liaoning',44),
(756,'Liaoning Sheng',44),
(757,'Nei Monggol',44),
(758,'Ningxia Hui',44),
(759,'Qinghai',44),
(760,'Shaanxi',44),
(761,'Shandong',44),
(762,'Shandong Sheng',44),
(763,'Shanghai',44),
(764,'Shanxi',44),
(765,'Sichuan',44),
(766,'Tianjin',44),
(767,'Xianggang',44),
(768,'Xinjiang',44),
(769,'Xizang',44),
(770,'Yunnan',44),
(771,'Zhejiang',44),
(772,'Zhejiang Sheng',44),
(773,'Christmas Island',45),
(774,'Cocos (Keeling) Islands',46),
(775,'Amazonas',47),
(776,'Antioquia',47),
(777,'Arauca',47),
(778,'Atlantico',47),
(779,'Bogota',47),
(780,'Bolivar',47),
(781,'Boyaca',47),
(782,'Caldas',47),
(783,'Caqueta',47),
(784,'Casanare',47),
(785,'Cauca',47),
(786,'Cesar',47),
(787,'Choco',47),
(788,'Cordoba',47),
(789,'Cundinamarca',47),
(790,'Guainia',47),
(791,'Guaviare',47),
(792,'Huila',47),
(793,'La Guajira',47),
(794,'Magdalena',47),
(795,'Meta',47),
(796,'Narino',47),
(797,'Norte de Santander',47),
(798,'Putumayo',47),
(799,'Quindio',47),
(800,'Risaralda',47),
(801,'San Andres y Providencia',47),
(802,'Santander',47),
(803,'Sucre',47),
(804,'Tolima',47),
(805,'Valle del Cauca',47),
(806,'Vaupes',47),
(807,'Vichada',47),
(808,'Mwali',48),
(809,'Njazidja',48),
(810,'Nzwani',48),
(811,'Bouenza',49),
(812,'Brazzaville',49),
(813,'Cuvette',49),
(814,'Kouilou',49),
(815,'Lekoumou',49),
(816,'Likouala',49),
(817,'Niari',49),
(818,'Plateaux',49),
(819,'Pool',49),
(820,'Sangha',49),
(821,'Bandundu',50),
(822,'Bas-Congo',50),
(823,'Equateur',50),
(824,'Haut-Congo',50),
(825,'Kasai-Occidental',50),
(826,'Kasai-Oriental',50),
(827,'Katanga',50),
(828,'Kinshasa',50),
(829,'Maniema',50),
(830,'Nord-Kivu',50),
(831,'Sud-Kivu',50),
(832,'Aitutaki',51),
(833,'Atiu',51),
(834,'Mangaia',51),
(835,'Manihiki',51),
(836,'Mauke',51),
(837,'Mitiaro',51),
(838,'Nassau',51),
(839,'Pukapuka',51),
(840,'Rakahanga',51),
(841,'Rarotonga',51),
(842,'Tongareva',51),
(843,'Alajuela',52),
(844,'Cartago',52),
(845,'Guanacaste',52),
(846,'Heredia',52),
(847,'Limon',52),
(848,'Puntarenas',52),
(849,'San Jose',52),
(850,'Abidjan',53),
(851,'Agneby',53),
(852,'Bafing',53),
(853,'Denguele',53),
(854,'Dix-huit Montagnes',53),
(855,'Fromager',53),
(856,'Haut-Sassandra',53),
(857,'Lacs',53),
(858,'Lagunes',53),
(859,'Marahoue',53),
(860,'Moyen-Cavally',53),
(861,'Moyen-Comoe',53),
(862,'Nzi-Comoe',53),
(863,'Sassandra',53),
(864,'Savanes',53),
(865,'Sud-Bandama',53),
(866,'Sud-Comoe',53),
(867,'Vallee du Bandama',53),
(868,'Worodougou',53),
(869,'Zanzan',53),
(870,'Bjelovar-Bilogora',54),
(871,'Dubrovnik-Neretva',54),
(872,'Grad Zagreb',54),
(873,'Istra',54),
(874,'Karlovac',54),
(875,'Koprivnica-Krizhevci',54),
(876,'Krapina-Zagorje',54),
(877,'Lika-Senj',54),
(878,'Medhimurje',54),
(879,'Medimurska Zupanija',54),
(880,'Osijek-Baranja',54),
(881,'Osjecko-Baranjska Zupanij',54),
(882,'Pozhega-Slavonija',54),
(883,'Primorje-Gorski Kotar',54),
(884,'Shibenik-Knin',54),
(885,'Sisak-Moslavina',54),
(886,'Slavonski Brod-Posavina',54),
(887,'Split-Dalmacija',54),
(888,'Varazhdin',54),
(889,'Virovitica-Podravina',54),
(890,'Vukovar-Srijem',54),
(891,'Zadar',54),
(892,'Zagreb',54),
(893,'Camaguey',55),
(894,'Ciego de Avila',55),
(895,'Cienfuegos',55),
(896,'Ciudad de la Habana',55),
(897,'Granma',55),
(898,'Guantanamo',55),
(899,'Habana',55),
(900,'Holguin',55),
(901,'Isla de la Juventud',55),
(902,'La Habana',55),
(903,'Las Tunas',55),
(904,'Matanzas',55),
(905,'Pinar del Rio',55),
(906,'Sancti Spiritus',55),
(907,'Santiago de Cuba',55),
(908,'Villa Clara',55),
(909,'Government controlled are',56),
(910,'Limassol',56),
(911,'Nicosia District',56),
(912,'Paphos',56),
(913,'Turkish controlled area',56),
(914,'Central Bohemian',57),
(915,'Frycovice',57),
(916,'Jihocesky Kraj',57),
(917,'Jihochesky',57),
(918,'Jihomoravsky',57),
(919,'Karlovarsky',57),
(920,'Klecany',57),
(921,'Kralovehradecky',57),
(922,'Liberecky',57),
(923,'Lipov',57),
(924,'Moravskoslezsky',57),
(925,'Olomoucky',57),
(926,'Olomoucky Kraj',57),
(927,'Pardubicky',57),
(928,'Plzensky',57),
(929,'Praha',57),
(930,'Rajhrad',57),
(931,'Smirice',57),
(932,'South Moravian',57),
(933,'Straz nad Nisou',57),
(934,'Stredochesky',57),
(935,'Unicov',57),
(936,'Ustecky',57),
(937,'Valletta',57),
(938,'Velesin',57),
(939,'Vysochina',57),
(940,'Zlinsky',57),
(941,'Arhus',58),
(942,'Bornholm',58),
(943,'Frederiksborg',58),
(944,'Fyn',58),
(945,'Hovedstaden',58),
(946,'Kobenhavn',58),
(947,'Kobenhavns Amt',58),
(948,'Kobenhavns Kommune',58),
(949,'Nordjylland',58),
(950,'Ribe',58),
(951,'Ringkobing',58),
(952,'Roervig',58),
(953,'Roskilde',58),
(954,'Roslev',58),
(955,'Sjaelland',58),
(956,'Soeborg',58),
(957,'Sonderjylland',58),
(958,'Storstrom',58),
(959,'Syddanmark',58),
(960,'Toelloese',58),
(961,'Vejle',58),
(962,'Vestsjalland',58),
(963,'Viborg',58),
(964,'Ali Sabih',59),
(965,'Dikhil',59),
(966,'Jibuti',59),
(967,'Tajurah',59),
(968,'Ubuk',59),
(969,'Saint Andrew',60),
(970,'Saint David',60),
(971,'Saint George',60),
(972,'Saint John',60),
(973,'Saint Joseph',60),
(974,'Saint Luke',60),
(975,'Saint Mark',60),
(976,'Saint Patrick',60),
(977,'Saint Paul',60),
(978,'Saint Peter',60),
(979,'Azua',61),
(980,'Bahoruco',61),
(981,'Barahona',61),
(982,'Dajabon',61),
(983,'Distrito Nacional',61),
(984,'Duarte',61),
(985,'El Seybo',61),
(986,'Elias Pina',61),
(987,'Espaillat',61),
(988,'Hato Mayor',61),
(989,'Independencia',61),
(990,'La Altagracia',61),
(991,'La Romana',61),
(992,'La Vega',61),
(993,'Maria Trinidad Sanchez',61),
(994,'Monsenor Nouel',61),
(995,'Monte Cristi',61),
(996,'Monte Plata',61),
(997,'Pedernales',61),
(998,'Peravia',61),
(999,'Puerto Plata',61),
(1000,'Salcedo',61),
(1001,'Samana',61),
(1002,'San Cristobal',61),
(1003,'San Juan',61),
(1004,'San Pedro de Macoris',61),
(1005,'Sanchez Ramirez',61),
(1006,'Santiago',61),
(1007,'Santiago Rodriguez',61),
(1008,'Valverde',61),
(1009,'Aileu',62),
(1010,'Ainaro',62),
(1011,'Ambeno',62),
(1012,'Baucau',62),
(1013,'Bobonaro',62),
(1014,'Cova Lima',62),
(1015,'Dili',62),
(1016,'Ermera',62),
(1017,'Lautem',62),
(1018,'Liquica',62),
(1019,'Manatuto',62),
(1020,'Manufahi',62),
(1021,'Viqueque',62),
(1022,'Azuay',63),
(1023,'Bolivar',63),
(1024,'Canar',63),
(1025,'Carchi',63),
(1026,'Chimborazo',63),
(1027,'Cotopaxi',63),
(1028,'El Oro',63),
(1029,'Esmeraldas',63),
(1030,'Galapagos',63),
(1031,'Guayas',63),
(1032,'Imbabura',63),
(1033,'Loja',63),
(1034,'Los Rios',63),
(1035,'Manabi',63),
(1036,'Morona Santiago',63),
(1037,'Napo',63),
(1038,'Orellana',63),
(1039,'Pastaza',63),
(1040,'Pichincha',63),
(1041,'Sucumbios',63),
(1042,'Tungurahua',63),
(1043,'Zamora Chinchipe',63),
(1044,'Aswan',64),
(1045,'Asyut',64),
(1046,'Bani Suwayf',64),
(1047,'Bur Said',64),
(1048,'Cairo',64),
(1049,'Dumyat',64),
(1050,'Kafr-ash-Shaykh',64),
(1051,'Matruh',64),
(1052,'Muhafazat ad Daqahliyah',64),
(1053,'Muhafazat al Fayyum',64),
(1054,'Muhafazat al Gharbiyah',64),
(1055,'Muhafazat al Iskandariyah',64),
(1056,'Muhafazat al Qahirah',64),
(1057,'Qina',64),
(1058,'Sawhaj',64),
(1059,'Sina al-Janubiyah',64),
(1060,'Sina ash-Shamaliyah',64),
(1061,'ad-Daqahliyah',64),
(1062,'al-Bahr-al-Ahmar',64),
(1063,'al-Buhayrah',64),
(1064,'al-Fayyum',64),
(1065,'al-Gharbiyah',64),
(1066,'al-Iskandariyah',64),
(1067,'al-Ismailiyah',64),
(1068,'al-Jizah',64),
(1069,'al-Minufiyah',64),
(1070,'al-Minya',64),
(1071,'al-Qahira',64),
(1072,'al-Qalyubiyah',64),
(1073,'al-Uqsur',64),
(1074,'al-Wadi al-Jadid',64),
(1075,'as-Suways',64),
(1076,'ash-Sharqiyah',64),
(1077,'Ahuachapan',65),
(1078,'Cabanas',65),
(1079,'Chalatenango',65),
(1080,'Cuscatlan',65),
(1081,'La Libertad',65),
(1082,'La Paz',65),
(1083,'La Union',65),
(1084,'Morazan',65),
(1085,'San Miguel',65),
(1086,'San Salvador',65),
(1087,'San Vicente',65),
(1088,'Santa Ana',65),
(1089,'Sonsonate',65),
(1090,'Usulutan',65),
(1091,'Annobon',66),
(1092,'Bioko Norte',66),
(1093,'Bioko Sur',66),
(1094,'Centro Sur',66),
(1095,'Kie-Ntem',66),
(1096,'Litoral',66),
(1097,'Wele-Nzas',66),
(1098,'Anseba',67),
(1099,'Debub',67),
(1100,'Debub-Keih-Bahri',67),
(1101,'Gash-Barka',67),
(1102,'Maekel',67),
(1103,'Semien-Keih-Bahri',67),
(1104,'Harju',68),
(1105,'Hiiu',68),
(1106,'Ida-Viru',68),
(1107,'Jarva',68),
(1108,'Jogeva',68),
(1109,'Laane',68),
(1110,'Laane-Viru',68),
(1111,'Parnu',68),
(1112,'Polva',68),
(1113,'Rapla',68),
(1114,'Saare',68),
(1115,'Tartu',68),
(1116,'Valga',68),
(1117,'Viljandi',68),
(1118,'Voru',68),
(1119,'Addis Abeba',69),
(1120,'Afar',69),
(1121,'Amhara',69),
(1122,'Benishangul',69),
(1123,'Diredawa',69),
(1124,'Gambella',69),
(1125,'Harar',69),
(1126,'Jigjiga',69),
(1127,'Mekele',69),
(1128,'Oromia',69),
(1129,'Somali',69),
(1130,'Southern',69),
(1131,'Tigray',69),
(1132,'Christmas Island',70),
(1133,'Cocos Islands',70),
(1134,'Coral Sea Islands',70),
(1135,'Falkland Islands',71),
(1136,'South Georgia',71),
(1137,'Klaksvik',72),
(1138,'Nor ara Eysturoy',72),
(1139,'Nor oy',72),
(1140,'Sandoy',72),
(1141,'Streymoy',72),
(1142,'Su uroy',72),
(1143,'Sy ra Eysturoy',72),
(1144,'Torshavn',72),
(1145,'Vaga',72),
(1146,'Central',73),
(1147,'Eastern',73),
(1148,'Northern',73),
(1149,'South Pacific',73),
(1150,'Western',73),
(1151,'Ahvenanmaa',74),
(1152,'Etela-Karjala',74),
(1153,'Etela-Pohjanmaa',74),
(1154,'Etela-Savo',74),
(1155,'Etela-Suomen Laani',74),
(1156,'Ita-Suomen Laani',74),
(1157,'Ita-Uusimaa',74),
(1158,'Kainuu',74),
(1159,'Kanta-Hame',74),
(1160,'Keski-Pohjanmaa',74),
(1161,'Keski-Suomi',74),
(1162,'Kymenlaakso',74),
(1163,'Lansi-Suomen Laani',74),
(1164,'Lappi',74),
(1165,'Northern Savonia',74),
(1166,'Ostrobothnia',74),
(1167,'Oulun Laani',74),
(1168,'Paijat-Hame',74),
(1169,'Pirkanmaa',74),
(1170,'Pohjanmaa',74),
(1171,'Pohjois-Karjala',74),
(1172,'Pohjois-Pohjanmaa',74),
(1173,'Pohjois-Savo',74),
(1174,'Saarijarvi',74),
(1175,'Satakunta',74),
(1176,'Southern Savonia',74),
(1177,'Tavastia Proper',74),
(1178,'Uleaborgs Lan',74),
(1179,'Uusimaa',74),
(1180,'Varsinais-Suomi',74),
(1181,'Ain',75),
(1182,'Aisne',75),
(1183,'Albi Le Sequestre',75),
(1184,'Allier',75),
(1185,'Alpes-Cote dAzur',75),
(1186,'Alpes-Maritimes',75),
(1187,'Alpes-de-Haute-Provence',75),
(1188,'Alsace',75),
(1189,'Aquitaine',75),
(1190,'Ardeche',75),
(1191,'Ardennes',75),
(1192,'Ariege',75),
(1193,'Aube',75),
(1194,'Aude',75),
(1195,'Auvergne',75),
(1196,'Aveyron',75),
(1197,'Bas-Rhin',75),
(1198,'Basse-Normandie',75),
(1199,'Bouches-du-Rhone',75),
(1200,'Bourgogne',75),
(1201,'Bretagne',75),
(1202,'Brittany',75),
(1203,'Burgundy',75),
(1204,'Calvados',75),
(1205,'Cantal',75),
(1206,'Cedex',75),
(1207,'Centre',75),
(1208,'Charente',75),
(1209,'Charente-Maritime',75),
(1210,'Cher',75),
(1211,'Correze',75),
(1212,'Corse-du-Sud',75),
(1213,'Cote-dOr',75),
(1214,'Cotes-dArmor',75),
(1215,'Creuse',75),
(1216,'Crolles',75),
(1217,'Deux-Sevres',75),
(1218,'Dordogne',75),
(1219,'Doubs',75),
(1220,'Drome',75),
(1221,'Essonne',75),
(1222,'Eure',75),
(1223,'Eure-et-Loir',75),
(1224,'Feucherolles',75),
(1225,'Finistere',75),
(1226,'Franche-Comte',75),
(1227,'Gard',75),
(1228,'Gers',75),
(1229,'Gironde',75),
(1230,'Haut-Rhin',75),
(1231,'Haute-Corse',75),
(1232,'Haute-Garonne',75),
(1233,'Haute-Loire',75),
(1234,'Haute-Marne',75),
(1235,'Haute-Saone',75),
(1236,'Haute-Savoie',75),
(1237,'Haute-Vienne',75),
(1238,'Hautes-Alpes',75),
(1239,'Hautes-Pyrenees',75),
(1240,'Hauts-de-Seine',75),
(1241,'Herault',75),
(1242,'Ile-de-France',75),
(1243,'Ille-et-Vilaine',75),
(1244,'Indre',75),
(1245,'Indre-et-Loire',75),
(1246,'Isere',75),
(1247,'Jura',75),
(1248,'Klagenfurt',75),
(1249,'Landes',75),
(1250,'Languedoc-Roussillon',75),
(1251,'Larcay',75),
(1252,'Le Castellet',75),
(1253,'Le Creusot',75),
(1254,'Limousin',75),
(1255,'Loir-et-Cher',75),
(1256,'Loire',75),
(1257,'Loire-Atlantique',75),
(1258,'Loiret',75),
(1259,'Lorraine',75),
(1260,'Lot',75),
(1261,'Lot-et-Garonne',75),
(1262,'Lower Normandy',75),
(1263,'Lozere',75),
(1264,'Maine-et-Loire',75),
(1265,'Manche',75),
(1266,'Marne',75),
(1267,'Mayenne',75),
(1268,'Meurthe-et-Moselle',75),
(1269,'Meuse',75),
(1270,'Midi-Pyrenees',75),
(1271,'Morbihan',75),
(1272,'Moselle',75),
(1273,'Nievre',75),
(1274,'Nord',75),
(1275,'Nord-Pas-de-Calais',75),
(1276,'Oise',75),
(1277,'Orne',75),
(1278,'Paris',75),
(1279,'Pas-de-Calais',75),
(1280,'Pays de la Loire',75),
(1281,'Pays-de-la-Loire',75),
(1282,'Picardy',75),
(1283,'Puy-de-Dome',75),
(1284,'Pyrenees-Atlantiques',75),
(1285,'Pyrenees-Orientales',75),
(1286,'Quelmes',75),
(1287,'Rhone',75),
(1288,'Rhone-Alpes',75),
(1289,'Saint Ouen',75),
(1290,'Saint Viatre',75),
(1291,'Saone-et-Loire',75),
(1292,'Sarthe',75),
(1293,'Savoie',75),
(1294,'Seine-Maritime',75),
(1295,'Seine-Saint-Denis',75),
(1296,'Seine-et-Marne',75),
(1297,'Somme',75),
(1298,'Sophia Antipolis',75),
(1299,'Souvans',75),
(1300,'Tarn',75),
(1301,'Tarn-et-Garonne',75),
(1302,'Territoire de Belfort',75),
(1303,'Treignac',75),
(1304,'Upper Normandy',75),
(1305,'Val-dOise',75),
(1306,'Val-de-Marne',75),
(1307,'Var',75),
(1308,'Vaucluse',75),
(1309,'Vellise',75),
(1310,'Vendee',75),
(1311,'Vienne',75),
(1312,'Vosges',75),
(1313,'Yonne',75),
(1314,'Yvelines',75),
(1315,'Cayenne',76),
(1316,'Saint-Laurent-du-Maroni',76),
(1317,'Iles du Vent',77),
(1318,'Iles sous le Vent',77),
(1319,'Marquesas',77),
(1320,'Tuamotu',77),
(1321,'Tubuai',77),
(1322,'Amsterdam',78),
(1323,'Crozet Islands',78),
(1324,'Kerguelen',78),
(1325,'Estuaire',79),
(1326,'Haut-Ogooue',79),
(1327,'Moyen-Ogooue',79),
(1328,'Ngounie',79),
(1329,'Nyanga',79),
(1330,'Ogooue-Ivindo',79),
(1331,'Ogooue-Lolo',79),
(1332,'Ogooue-Maritime',79),
(1333,'Woleu-Ntem',79),
(1334,'Banjul',80),
(1335,'Basse',80),
(1336,'Brikama',80),
(1337,'Janjanbureh',80),
(1338,'Kanifing',80),
(1339,'Kerewan',80),
(1340,'Kuntaur',80),
(1341,'Mansakonko',80),
(1342,'Abhasia',81),
(1343,'Ajaria',81),
(1344,'Guria',81),
(1345,'Imereti',81),
(1346,'Kaheti',81),
(1347,'Kvemo Kartli',81),
(1348,'Mcheta-Mtianeti',81),
(1349,'Racha',81),
(1350,'Samagrelo-Zemo Svaneti',81),
(1351,'Samche-Zhavaheti',81),
(1352,'Shida Kartli',81),
(1353,'Tbilisi',81),
(1354,'Auvergne',82),
(1355,'Baden-Wurttemberg',82),
(1356,'Bavaria',82),
(1357,'Bayern',82),
(1358,'Beilstein Wurtt',82),
(1359,'Berlin',82),
(1360,'Brandenburg',82),
(1361,'Bremen',82),
(1362,'Dreisbach',82),
(1363,'Freistaat Bayern',82),
(1364,'Hamburg',82),
(1365,'Hannover',82),
(1366,'Heroldstatt',82),
(1367,'Hessen',82),
(1368,'Kortenberg',82),
(1369,'Laasdorf',82),
(1370,'Land Baden-Wurttemberg',82),
(1371,'Land Bayern',82),
(1372,'Land Brandenburg',82),
(1373,'Land Hessen',82),
(1374,'Land Mecklenburg-Vorpomme',82),
(1375,'Land Nordrhein-Westfalen',82),
(1376,'Land Rheinland-Pfalz',82),
(1377,'Land Sachsen',82),
(1378,'Land Sachsen-Anhalt',82),
(1379,'Land Thuringen',82),
(1380,'Lower Saxony',82),
(1381,'Mecklenburg-Vorpommern',82),
(1382,'Mulfingen',82),
(1383,'Munich',82),
(1384,'Neubeuern',82),
(1385,'Niedersachsen',82),
(1386,'Noord-Holland',82),
(1387,'Nordrhein-Westfalen',82),
(1388,'North Rhine-Westphalia',82),
(1389,'Osterode',82),
(1390,'Rheinland-Pfalz',82),
(1391,'Rhineland-Palatinate',82),
(1392,'Saarland',82),
(1393,'Sachsen',82),
(1394,'Sachsen-Anhalt',82),
(1395,'Saxony',82),
(1396,'Schleswig-Holstein',82),
(1397,'Thuringia',82),
(1398,'Webling',82),
(1399,'Weinstrabe',82),
(1400,'schlobborn',82),
(1401,'Ashanti',83),
(1402,'Brong-Ahafo',83),
(1403,'Central',83),
(1404,'Eastern',83),
(1405,'Greater Accra',83),
(1406,'Northern',83),
(1407,'Upper East',83),
(1408,'Upper West',83),
(1409,'Volta',83),
(1410,'Western',83),
(1411,'Gibraltar',84),
(1412,'Acharnes',85),
(1413,'Ahaia',85),
(1414,'Aitolia kai Akarnania',85),
(1415,'Argolis',85),
(1416,'Arkadia',85),
(1417,'Arta',85),
(1418,'Attica',85),
(1419,'Attiki',85),
(1420,'Ayion Oros',85),
(1421,'Crete',85),
(1422,'Dodekanisos',85),
(1423,'Drama',85),
(1424,'Evia',85),
(1425,'Evritania',85),
(1426,'Evros',85),
(1427,'Evvoia',85),
(1428,'Florina',85),
(1429,'Fokis',85),
(1430,'Fthiotis',85),
(1431,'Grevena',85),
(1432,'Halandri',85),
(1433,'Halkidiki',85),
(1434,'Hania',85),
(1435,'Heraklion',85),
(1436,'Hios',85),
(1437,'Ilia',85),
(1438,'Imathia',85),
(1439,'Ioannina',85),
(1440,'Iraklion',85),
(1441,'Karditsa',85),
(1442,'Kastoria',85),
(1443,'Kavala',85),
(1444,'Kefallinia',85),
(1445,'Kerkira',85),
(1446,'Kiklades',85),
(1447,'Kilkis',85),
(1448,'Korinthia',85),
(1449,'Kozani',85),
(1450,'Lakonia',85),
(1451,'Larisa',85),
(1452,'Lasithi',85),
(1453,'Lesvos',85),
(1454,'Levkas',85),
(1455,'Magnisia',85),
(1456,'Messinia',85),
(1457,'Nomos Attikis',85),
(1458,'Nomos Zakynthou',85),
(1459,'Pella',85),
(1460,'Pieria',85),
(1461,'Piraios',85),
(1462,'Preveza',85),
(1463,'Rethimni',85),
(1464,'Rodopi',85),
(1465,'Samos',85),
(1466,'Serrai',85),
(1467,'Thesprotia',85),
(1468,'Thessaloniki',85),
(1469,'Trikala',85),
(1470,'Voiotia',85),
(1471,'West Greece',85),
(1472,'Xanthi',85),
(1473,'Zakinthos',85),
(1474,'Aasiaat',86),
(1475,'Ammassalik',86),
(1476,'Illoqqortoormiut',86),
(1477,'Ilulissat',86),
(1478,'Ivittuut',86),
(1479,'Kangaatsiaq',86),
(1480,'Maniitsoq',86),
(1481,'Nanortalik',86),
(1482,'Narsaq',86),
(1483,'Nuuk',86),
(1484,'Paamiut',86),
(1485,'Qaanaaq',86),
(1486,'Qaqortoq',86),
(1487,'Qasigiannguit',86),
(1488,'Qeqertarsuaq',86),
(1489,'Sisimiut',86),
(1490,'Udenfor kommunal inddelin',86),
(1491,'Upernavik',86),
(1492,'Uummannaq',86),
(1493,'Carriacou-Petite Martiniq',87),
(1494,'Saint Andrew',87),
(1495,'Saint Davids',87),
(1496,'Saint Georges',87),
(1497,'Saint John',87),
(1498,'Saint Mark',87),
(1499,'Saint Patrick',87),
(1500,'Basse-Terre',88),
(1501,'Grande-Terre',88),
(1502,'Iles des Saintes',88),
(1503,'La Desirade',88),
(1504,'Marie-Galante',88),
(1505,'Saint Barthelemy',88),
(1506,'Saint Martin',88),
(1507,'Agana Heights',89),
(1508,'Agat',89),
(1509,'Barrigada',89),
(1510,'Chalan-Pago-Ordot',89),
(1511,'Dededo',89),
(1512,'Hagatna',89),
(1513,'Inarajan',89),
(1514,'Mangilao',89),
(1515,'Merizo',89),
(1516,'Mongmong-Toto-Maite',89),
(1517,'Santa Rita',89),
(1518,'Sinajana',89),
(1519,'Talofofo',89),
(1520,'Tamuning',89),
(1521,'Yigo',89),
(1522,'Yona',89),
(1523,'Alta Verapaz',90),
(1524,'Baja Verapaz',90),
(1525,'Chimaltenango',90),
(1526,'Chiquimula',90),
(1527,'El Progreso',90),
(1528,'Escuintla',90),
(1529,'Guatemala',90),
(1530,'Huehuetenango',90),
(1531,'Izabal',90),
(1532,'Jalapa',90),
(1533,'Jutiapa',90),
(1534,'Peten',90),
(1535,'Quezaltenango',90),
(1536,'Quiche',90),
(1537,'Retalhuleu',90),
(1538,'Sacatepequez',90),
(1539,'San Marcos',90),
(1540,'Santa Rosa',90),
(1541,'Solola',90),
(1542,'Suchitepequez',90),
(1543,'Totonicapan',90),
(1544,'Zacapa',90),
(1545,'Alderney',91),
(1546,'Castel',91),
(1547,'Forest',91),
(1548,'Saint Andrew',91),
(1549,'Saint Martin',91),
(1550,'Saint Peter Port',91),
(1551,'Saint Pierre du Bois',91),
(1552,'Saint Sampson',91),
(1553,'Saint Saviour',91),
(1554,'Sark',91),
(1555,'Torteval',91),
(1556,'Vale',91),
(1557,'Beyla',92),
(1558,'Boffa',92),
(1559,'Boke',92),
(1560,'Conakry',92),
(1561,'Coyah',92),
(1562,'Dabola',92),
(1563,'Dalaba',92),
(1564,'Dinguiraye',92),
(1565,'Faranah',92),
(1566,'Forecariah',92),
(1567,'Fria',92),
(1568,'Gaoual',92),
(1569,'Gueckedou',92),
(1570,'Kankan',92),
(1571,'Kerouane',92),
(1572,'Kindia',92),
(1573,'Kissidougou',92),
(1574,'Koubia',92),
(1575,'Koundara',92),
(1576,'Kouroussa',92),
(1577,'Labe',92),
(1578,'Lola',92),
(1579,'Macenta',92),
(1580,'Mali',92),
(1581,'Mamou',92),
(1582,'Mandiana',92),
(1583,'Nzerekore',92),
(1584,'Pita',92),
(1585,'Siguiri',92),
(1586,'Telimele',92),
(1587,'Tougue',92),
(1588,'Yomou',92),
(1589,'Bafata',93),
(1590,'Bissau',93),
(1591,'Bolama',93),
(1592,'Cacheu',93),
(1593,'Gabu',93),
(1594,'Oio',93),
(1595,'Quinara',93),
(1596,'Tombali',93),
(1597,'Barima-Waini',94),
(1598,'Cuyuni-Mazaruni',94),
(1599,'Demerara-Mahaica',94),
(1600,'East Berbice-Corentyne',94),
(1601,'Essequibo Islands-West De',94),
(1602,'Mahaica-Berbice',94),
(1603,'Pomeroon-Supenaam',94),
(1604,'Potaro-Siparuni',94),
(1605,'Upper Demerara-Berbice',94),
(1606,'Upper Takutu-Upper Essequ',94),
(1607,'Artibonite',95),
(1608,'Centre',95),
(1609,'GrandAnse',95),
(1610,'Nord',95),
(1611,'Nord-Est',95),
(1612,'Nord-Ouest',95),
(1613,'Ouest',95),
(1614,'Sud',95),
(1615,'Sud-Est',95),
(1616,'Heard and McDonald Island',96),
(1617,'Atlantida',97),
(1618,'Choluteca',97),
(1619,'Colon',97),
(1620,'Comayagua',97),
(1621,'Copan',97),
(1622,'Cortes',97),
(1623,'Distrito Central',97),
(1624,'El Paraiso',97),
(1625,'Francisco Morazan',97),
(1626,'Gracias a Dios',97),
(1627,'Intibuca',97),
(1628,'Islas de la Bahia',97),
(1629,'La Paz',97),
(1630,'Lempira',97),
(1631,'Ocotepeque',97),
(1632,'Olancho',97),
(1633,'Santa Barbara',97),
(1634,'Valle',97),
(1635,'Yoro',97),
(1636,'Hong Kong',98),
(1637,'Bacs-Kiskun',99),
(1638,'Baranya',99),
(1639,'Bekes',99),
(1640,'Borsod-Abauj-Zemplen',99),
(1641,'Budapest',99),
(1642,'Csongrad',99),
(1643,'Fejer',99),
(1644,'Gyor-Moson-Sopron',99),
(1645,'Hajdu-Bihar',99),
(1646,'Heves',99),
(1647,'Jasz-Nagykun-Szolnok',99),
(1648,'Komarom-Esztergom',99),
(1649,'Nograd',99),
(1650,'Pest',99),
(1651,'Somogy',99),
(1652,'Szabolcs-Szatmar-Bereg',99),
(1653,'Tolna',99),
(1654,'Vas',99),
(1655,'Veszprem',99),
(1656,'Zala',99),
(1657,'Austurland',100),
(1658,'Gullbringusysla',100),
(1659,'Hofu borgarsva i',100),
(1660,'Nor urland eystra',100),
(1661,'Nor urland vestra',100),
(1662,'Su urland',100),
(1663,'Su urnes',100),
(1664,'Vestfir ir',100),
(1665,'Vesturland',100),
(1666,'Aceh',102),
(1667,'Bali',102),
(1668,'Bangka-Belitung',102),
(1669,'Banten',102),
(1670,'Bengkulu',102),
(1671,'Gandaria',102),
(1672,'Gorontalo',102),
(1673,'Jakarta',102),
(1674,'Jambi',102),
(1675,'Jawa Barat',102),
(1676,'Jawa Tengah',102),
(1677,'Jawa Timur',102),
(1678,'Kalimantan Barat',102),
(1679,'Kalimantan Selatan',102),
(1680,'Kalimantan Tengah',102),
(1681,'Kalimantan Timur',102),
(1682,'Kendal',102),
(1683,'Lampung',102),
(1684,'Maluku',102),
(1685,'Maluku Utara',102),
(1686,'Nusa Tenggara Barat',102),
(1687,'Nusa Tenggara Timur',102),
(1688,'Papua',102),
(1689,'Riau',102),
(1690,'Riau Kepulauan',102),
(1691,'Solo',102),
(1692,'Sulawesi Selatan',102),
(1693,'Sulawesi Tengah',102),
(1694,'Sulawesi Tenggara',102),
(1695,'Sulawesi Utara',102),
(1696,'Sumatera Barat',102),
(1697,'Sumatera Selatan',102),
(1698,'Sumatera Utara',102),
(1699,'Yogyakarta',102),
(1700,'Ardabil',103),
(1701,'Azarbayjan-e Bakhtari',103),
(1702,'Azarbayjan-e Khavari',103),
(1703,'Bushehr',103),
(1704,'Chahar Mahal-e Bakhtiari',103),
(1705,'Esfahan',103),
(1706,'Fars',103),
(1707,'Gilan',103),
(1708,'Golestan',103),
(1709,'Hamadan',103),
(1710,'Hormozgan',103),
(1711,'Ilam',103),
(1712,'Kerman',103),
(1713,'Kermanshah',103),
(1714,'Khorasan',103),
(1715,'Khuzestan',103),
(1716,'Kohgiluyeh-e Boyerahmad',103),
(1717,'Kordestan',103),
(1718,'Lorestan',103),
(1719,'Markazi',103),
(1720,'Mazandaran',103),
(1721,'Ostan-e Esfahan',103),
(1722,'Qazvin',103),
(1723,'Qom',103),
(1724,'Semnan',103),
(1725,'Sistan-e Baluchestan',103),
(1726,'Tehran',103),
(1727,'Yazd',103),
(1728,'Zanjan',103),
(1729,'Babil',104),
(1730,'Baghdad',104),
(1731,'Dahuk',104),
(1732,'Dhi Qar',104),
(1733,'Diyala',104),
(1734,'Erbil',104),
(1735,'Irbil',104),
(1736,'Karbala',104),
(1737,'Kurdistan',104),
(1738,'Maysan',104),
(1739,'Ninawa',104),
(1740,'Salah-ad-Din',104),
(1741,'Wasit',104),
(1742,'al-Anbar',104),
(1743,'al-Basrah',104),
(1744,'al-Muthanna',104),
(1745,'al-Qadisiyah',104),
(1746,'an-Najaf',104),
(1747,'as-Sulaymaniyah',104),
(1748,'at-Tamim',104),
(1749,'Armagh',105),
(1750,'Carlow',105),
(1751,'Cavan',105),
(1752,'Clare',105),
(1753,'Cork',105),
(1754,'Donegal',105),
(1755,'Dublin',105),
(1756,'Galway',105),
(1757,'Kerry',105),
(1758,'Kildare',105),
(1759,'Kilkenny',105),
(1760,'Laois',105),
(1761,'Leinster',105),
(1762,'Leitrim',105),
(1763,'Limerick',105),
(1764,'Loch Garman',105),
(1765,'Longford',105),
(1766,'Louth',105),
(1767,'Mayo',105),
(1768,'Meath',105),
(1769,'Monaghan',105),
(1770,'Offaly',105),
(1771,'Roscommon',105),
(1772,'Sligo',105),
(1773,'Tipperary North Riding',105),
(1774,'Tipperary South Riding',105),
(1775,'Ulster',105),
(1776,'Waterford',105),
(1777,'Westmeath',105),
(1778,'Wexford',105),
(1779,'Wicklow',105),
(1780,'Beit Hanania',106),
(1781,'Ben Gurion Airport',106),
(1782,'Bethlehem',106),
(1783,'Caesarea',106),
(1784,'Centre',106),
(1785,'Gaza',106),
(1786,'Hadaron',106),
(1787,'Haifa District',106),
(1788,'Hamerkaz',106),
(1789,'Hazafon',106),
(1790,'Hebron',106),
(1791,'Jaffa',106),
(1792,'Jerusalem',106),
(1793,'Khefa',106),
(1794,'Kiryat Yam',106),
(1795,'Lower Galilee',106),
(1796,'Qalqilya',106),
(1797,'Talme Elazar',106),
(1798,'Tel Aviv',106),
(1799,'Tsafon',106),
(1800,'Umm El Fahem',106),
(1801,'Yerushalayim',106),
(1802,'Abruzzi',107),
(1803,'Abruzzo',107),
(1804,'Agrigento',107),
(1805,'Alessandria',107),
(1806,'Ancona',107),
(1807,'Arezzo',107),
(1808,'Ascoli Piceno',107),
(1809,'Asti',107),
(1810,'Avellino',107),
(1811,'Bari',107),
(1812,'Basilicata',107),
(1813,'Belluno',107),
(1814,'Benevento',107),
(1815,'Bergamo',107),
(1816,'Biella',107),
(1817,'Bologna',107),
(1818,'Bolzano',107),
(1819,'Brescia',107),
(1820,'Brindisi',107),
(1821,'Calabria',107),
(1822,'Campania',107),
(1823,'Cartoceto',107),
(1824,'Caserta',107),
(1825,'Catania',107),
(1826,'Chieti',107),
(1827,'Como',107),
(1828,'Cosenza',107),
(1829,'Cremona',107),
(1830,'Cuneo',107),
(1831,'Emilia-Romagna',107),
(1832,'Ferrara',107),
(1833,'Firenze',107),
(1834,'Florence',107),
(1835,'Forli-Cesena ',107),
(1836,'Friuli-Venezia Giulia',107),
(1837,'Frosinone',107),
(1838,'Genoa',107),
(1839,'Gorizia',107),
(1840,'LAquila',107),
(1841,'Lazio',107),
(1842,'Lecce',107),
(1843,'Lecco',107),
(1844,'Lecco Province',107),
(1845,'Liguria',107),
(1846,'Lodi',107),
(1847,'Lombardia',107),
(1848,'Lombardy',107),
(1849,'Macerata',107),
(1850,'Mantova',107),
(1851,'Marche',107),
(1852,'Messina',107),
(1853,'Milan',107),
(1854,'Modena',107),
(1855,'Molise',107),
(1856,'Molteno',107),
(1857,'Montenegro',107),
(1858,'Monza and Brianza',107),
(1859,'Naples',107),
(1860,'Novara',107),
(1861,'Padova',107),
(1862,'Parma',107),
(1863,'Pavia',107),
(1864,'Perugia',107),
(1865,'Pesaro-Urbino',107),
(1866,'Piacenza',107),
(1867,'Piedmont',107),
(1868,'Piemonte',107),
(1869,'Pisa',107),
(1870,'Pordenone',107),
(1871,'Potenza',107),
(1872,'Puglia',107),
(1873,'Reggio Emilia',107),
(1874,'Rimini',107),
(1875,'Roma',107),
(1876,'Salerno',107),
(1877,'Sardegna',107),
(1878,'Sassari',107),
(1879,'Savona',107),
(1880,'Sicilia',107),
(1881,'Siena',107),
(1882,'Sondrio',107),
(1883,'South Tyrol',107),
(1884,'Taranto',107),
(1885,'Teramo',107),
(1886,'Torino',107),
(1887,'Toscana',107),
(1888,'Trapani',107),
(1889,'Trentino-Alto Adige',107),
(1890,'Trento',107),
(1891,'Treviso',107),
(1892,'Udine',107),
(1893,'Umbria',107),
(1894,'Valle dAosta',107),
(1895,'Varese',107),
(1896,'Veneto',107),
(1897,'Venezia',107),
(1898,'Verbano-Cusio-Ossola',107),
(1899,'Vercelli',107),
(1900,'Verona',107),
(1901,'Vicenza',107),
(1902,'Viterbo',107),
(1903,'Buxoro Viloyati',108),
(1904,'Clarendon',108),
(1905,'Hanover',108),
(1906,'Kingston',108),
(1907,'Manchester',108),
(1908,'Portland',108),
(1909,'Saint Andrews',108),
(1910,'Saint Ann',108),
(1911,'Saint Catherine',108),
(1912,'Saint Elizabeth',108),
(1913,'Saint James',108),
(1914,'Saint Mary',108),
(1915,'Saint Thomas',108),
(1916,'Trelawney',108),
(1917,'Westmoreland',108),
(1918,'Aichi',109),
(1919,'Akita',109),
(1920,'Aomori',109),
(1921,'Chiba',109),
(1922,'Ehime',109),
(1923,'Fukui',109),
(1924,'Fukuoka',109),
(1925,'Fukushima',109),
(1926,'Gifu',109),
(1927,'Gumma',109),
(1928,'Hiroshima',109),
(1929,'Hokkaido',109),
(1930,'Hyogo',109),
(1931,'Ibaraki',109),
(1932,'Ishikawa',109),
(1933,'Iwate',109),
(1934,'Kagawa',109),
(1935,'Kagoshima',109),
(1936,'Kanagawa',109),
(1937,'Kanto',109),
(1938,'Kochi',109),
(1939,'Kumamoto',109),
(1940,'Kyoto',109),
(1941,'Mie',109),
(1942,'Miyagi',109),
(1943,'Miyazaki',109),
(1944,'Nagano',109),
(1945,'Nagasaki',109),
(1946,'Nara',109),
(1947,'Niigata',109),
(1948,'Oita',109),
(1949,'Okayama',109),
(1950,'Okinawa',109),
(1951,'Osaka',109),
(1952,'Saga',109),
(1953,'Saitama',109),
(1954,'Shiga',109),
(1955,'Shimane',109),
(1956,'Shizuoka',109),
(1957,'Tochigi',109),
(1958,'Tokushima',109),
(1959,'Tokyo',109),
(1960,'Tottori',109),
(1961,'Toyama',109),
(1962,'Wakayama',109),
(1963,'Yamagata',109),
(1964,'Yamaguchi',109),
(1965,'Yamanashi',109),
(1966,'Grouville',110),
(1967,'Saint Brelade',110),
(1968,'Saint Clement',110),
(1969,'Saint Helier',110),
(1970,'Saint John',110),
(1971,'Saint Lawrence',110),
(1972,'Saint Martin',110),
(1973,'Saint Mary',110),
(1974,'Saint Peter',110),
(1975,'Saint Saviour',110),
(1976,'Trinity',110),
(1977,'Ajlun',111),
(1978,'Amman',111),
(1979,'Irbid',111),
(1980,'Jarash',111),
(1981,'Maan',111),
(1982,'Madaba',111),
(1983,'al-Aqabah',111),
(1984,'al-Balqa',111),
(1985,'al-Karak',111),
(1986,'al-Mafraq',111),
(1987,'at-Tafilah',111),
(1988,'az-Zarqa',111),
(1989,'Akmecet',112),
(1990,'Akmola',112),
(1991,'Aktobe',112),
(1992,'Almati',112),
(1993,'Atirau',112),
(1994,'Batis Kazakstan',112),
(1995,'Burlinsky Region',112),
(1996,'Karagandi',112),
(1997,'Kostanay',112),
(1998,'Mankistau',112),
(1999,'Ontustik Kazakstan',112),
(2000,'Pavlodar',112),
(2001,'Sigis Kazakstan',112),
(2002,'Soltustik Kazakstan',112),
(2003,'Taraz',112),
(2004,'Central',113),
(2005,'Coast',113),
(2006,'Eastern',113),
(2007,'Nairobi',113),
(2008,'North Eastern',113),
(2009,'Nyanza',113),
(2010,'Rift Valley',113),
(2011,'Western',113),
(2012,'Abaiang',114),
(2013,'Abemana',114),
(2014,'Aranuka',114),
(2015,'Arorae',114),
(2016,'Banaba',114),
(2017,'Beru',114),
(2018,'Butaritari',114),
(2019,'Kiritimati',114),
(2020,'Kuria',114),
(2021,'Maiana',114),
(2022,'Makin',114),
(2023,'Marakei',114),
(2024,'Nikunau',114),
(2025,'Nonouti',114),
(2026,'Onotoa',114),
(2027,'Phoenix Islands',114),
(2028,'Tabiteuea North',114),
(2029,'Tabiteuea South',114),
(2030,'Tabuaeran',114),
(2031,'Tamana',114),
(2032,'Tarawa North',114),
(2033,'Tarawa South',114),
(2034,'Teraina',114),
(2035,'Chagangdo',115),
(2036,'Hamgyeongbukto',115),
(2037,'Hamgyeongnamdo',115),
(2038,'Hwanghaebukto',115),
(2039,'Hwanghaenamdo',115),
(2040,'Kaeseong',115),
(2041,'Kangweon',115),
(2042,'Nampo',115),
(2043,'Pyeonganbukto',115),
(2044,'Pyeongannamdo',115),
(2045,'Pyeongyang',115),
(2046,'Yanggang',115),
(2047,'Busan',116),
(2048,'Cheju',116),
(2049,'Chollabuk',116),
(2050,'Chollanam',116),
(2051,'Chungbuk',116),
(2052,'Chungcheongbuk',116),
(2053,'Chungcheongnam',116),
(2054,'Chungnam',116),
(2055,'Daegu',116),
(2056,'Gangwon-do',116),
(2057,'Goyang-si',116),
(2058,'Gyeonggi-do',116),
(2059,'Gyeongsang ',116),
(2060,'Gyeongsangnam-do',116),
(2061,'Incheon',116),
(2062,'Jeju-Si',116),
(2063,'Jeonbuk',116),
(2064,'Kangweon',116),
(2065,'Kwangju',116),
(2066,'Kyeonggi',116),
(2067,'Kyeongsangbuk',116),
(2068,'Kyeongsangnam',116),
(2069,'Kyonggi-do',116),
(2070,'Kyungbuk-Do',116),
(2071,'Kyunggi-Do',116),
(2072,'Kyunggi-do',116),
(2073,'Pusan',116),
(2074,'Seoul',116),
(2075,'Sudogwon',116),
(2076,'Taegu',116),
(2077,'Taejeon',116),
(2078,'Taejon-gwangyoksi',116),
(2079,'Ulsan',116),
(2080,'Wonju',116),
(2081,'gwangyoksi',116),
(2082,'Al Asimah',117),
(2083,'Hawalli',117),
(2084,'Mishref',117),
(2085,'Qadesiya',117),
(2086,'Safat',117),
(2087,'Salmiya',117),
(2088,'al-Ahmadi',117),
(2089,'al-Farwaniyah',117),
(2090,'al-Jahra',117),
(2091,'al-Kuwayt',117),
(2092,'Batken',118),
(2093,'Bishkek',118),
(2094,'Chui',118),
(2095,'Issyk-Kul',118),
(2096,'Jalal-Abad',118),
(2097,'Naryn',118),
(2098,'Osh',118),
(2099,'Talas',118),
(2100,'Attopu',119),
(2101,'Bokeo',119),
(2102,'Bolikhamsay',119),
(2103,'Champasak',119),
(2104,'Houaphanh',119),
(2105,'Khammouane',119),
(2106,'Luang Nam Tha',119),
(2107,'Luang Prabang',119),
(2108,'Oudomxay',119),
(2109,'Phongsaly',119),
(2110,'Saravan',119),
(2111,'Savannakhet',119),
(2112,'Sekong',119),
(2113,'Viangchan Prefecture',119),
(2114,'Viangchan Province',119),
(2115,'Xaignabury',119),
(2116,'Xiang Khuang',119),
(2117,'Aizkraukles',120),
(2118,'Aluksnes',120),
(2119,'Balvu',120),
(2120,'Bauskas',120),
(2121,'Cesu',120),
(2122,'Daugavpils',120),
(2123,'Daugavpils City',120),
(2124,'Dobeles',120),
(2125,'Gulbenes',120),
(2126,'Jekabspils',120),
(2127,'Jelgava',120),
(2128,'Jelgavas',120),
(2129,'Jurmala City',120),
(2130,'Kraslavas',120),
(2131,'Kuldigas',120),
(2132,'Liepaja',120),
(2133,'Liepajas',120),
(2134,'Limbazhu',120),
(2135,'Ludzas',120),
(2136,'Madonas',120),
(2137,'Ogres',120),
(2138,'Preilu',120),
(2139,'Rezekne',120),
(2140,'Rezeknes',120),
(2141,'Riga',120),
(2142,'Rigas',120),
(2143,'Saldus',120),
(2144,'Talsu',120),
(2145,'Tukuma',120),
(2146,'Valkas',120),
(2147,'Valmieras',120),
(2148,'Ventspils',120),
(2149,'Ventspils City',120),
(2150,'Beirut',121),
(2151,'Jabal Lubnan',121),
(2152,'Mohafazat Liban-Nord',121),
(2153,'Mohafazat Mont-Liban',121),
(2154,'Sidon',121),
(2155,'al-Biqa',121),
(2156,'al-Janub',121),
(2157,'an-Nabatiyah',121),
(2158,'ash-Shamal',121),
(2159,'Berea',122),
(2160,'Butha-Buthe',122),
(2161,'Leribe',122),
(2162,'Mafeteng',122),
(2163,'Maseru',122),
(2164,'Mohales Hoek',122),
(2165,'Mokhotlong',122),
(2166,'Qachas Nek',122),
(2167,'Quthing',122),
(2168,'Thaba-Tseka',122),
(2169,'Bomi',123),
(2170,'Bong',123),
(2171,'Grand Bassa',123),
(2172,'Grand Cape Mount',123),
(2173,'Grand Gedeh',123),
(2174,'Loffa',123),
(2175,'Margibi',123),
(2176,'Maryland and Grand Kru',123),
(2177,'Montserrado',123),
(2178,'Nimba',123),
(2179,'Rivercess',123),
(2180,'Sinoe',123),
(2181,'Ajdabiya',124);

/*Table structure for table `tbl_timezone` */

DROP TABLE IF EXISTS `tbl_timezone`;

CREATE TABLE `tbl_timezone` (
  `timezoneId` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(100) DEFAULT NULL,
  `utcOffset` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`timezoneId`)
) ENGINE=InnoDB AUTO_INCREMENT=589 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_timezone` */

insert  into `tbl_timezone`(`timezoneId`,`countryName`,`utcOffset`) values 
(1,'Africa/Abidjan','+00:00'),
(2,'Africa/Accra','+00:00'),
(3,'Africa/Addis_Ababa','+03:00'),
(4,'Africa/Algiers','+01:00'),
(5,'Africa/Asmara','+03:00'),
(6,'Africa/Asmera','+03:00'),
(7,'Africa/Bamako','+00:00'),
(8,'Africa/Bangui','+01:00'),
(9,'Africa/Banjul','+00:00'),
(10,'Africa/Bissau','+00:00'),
(11,'Africa/Blantyre','+02:00'),
(12,'Africa/Brazzaville','+01:00'),
(13,'Africa/Bujumbura','+02:00'),
(14,'Africa/Cairo','+02:00'),
(15,'Africa/Casablanca','+00:00'),
(16,'Africa/Ceuta','+01:00'),
(17,'Africa/Conakry','+00:00'),
(18,'Africa/Dakar','+00:00'),
(19,'Africa/Dar_es_Salaam','+03:00'),
(20,'Africa/Djibouti','+03:00'),
(21,'Africa/Douala','+01:00'),
(22,'Africa/El_Aaiun','+00:00'),
(23,'Africa/Freetown','+00:00'),
(24,'Africa/Gaborone','+02:00'),
(25,'Africa/Harare','+02:00'),
(26,'Africa/Johannesburg','+02:00'),
(27,'Africa/Juba','+03:00'),
(28,'Africa/Kampala','+03:00'),
(29,'Africa/Khartoum','+03:00'),
(30,'Africa/Kigali','+02:00'),
(31,'Africa/Kinshasa','+01:00'),
(32,'Africa/Lagos','+01:00'),
(33,'Africa/Libreville','+01:00'),
(34,'Africa/Lome','+00:00'),
(35,'Africa/Luanda','+01:00'),
(36,'Africa/Lubumbashi','+02:00'),
(37,'Africa/Lusaka','+02:00'),
(38,'Africa/Malabo','+01:00'),
(39,'Africa/Maputo','+02:00'),
(40,'Africa/Maseru','+02:00'),
(41,'Africa/Mbabane','+02:00'),
(42,'Africa/Mogadishu','+03:00'),
(43,'Africa/Monrovia','+00:00'),
(44,'Africa/Nairobi','+03:00'),
(45,'Africa/Ndjamena','+01:00'),
(46,'Africa/Niamey','+01:00'),
(47,'Africa/Nouakchott','+00:00'),
(48,'Africa/Ouagadougou','+00:00'),
(49,'Africa/Porto-Novo','+01:00'),
(50,'Africa/Sao_Tome','+00:00'),
(51,'Africa/Timbuktu','+00:00'),
(52,'Africa/Tripoli','+02:00'),
(53,'Africa/Tunis','+01:00'),
(54,'Africa/Windhoek','+01:00'),
(55,'America/Adak','-10:00'),
(56,'America/Anchorage','-09:00'),
(57,'America/Anguilla','-04:00'),
(58,'America/Antigua','-04:00'),
(59,'America/Araguaina','-03:00'),
(60,'America/Argentina/Buenos_Aires','-03:00'),
(61,'America/Argentina/Catamarca','-03:00'),
(62,'America/Argentina/ComodRivadavia','-03:00'),
(63,'America/Argentina/Cordoba','-03:00'),
(64,'America/Argentina/Jujuy','-03:00'),
(65,'America/Argentina/La_Rioja','-03:00'),
(66,'America/Argentina/Mendoza','-03:00'),
(67,'America/Argentina/Rio_Gallegos','-03:00'),
(68,'America/Argentina/Salta','-03:00'),
(69,'America/Argentina/San_Juan','-03:00'),
(70,'America/Argentina/San_Luis','-03:00'),
(71,'America/Argentina/Tucuman','-03:00'),
(72,'America/Argentina/Ushuaia','-03:00'),
(73,'America/Aruba','-04:00'),
(74,'America/Asuncion','-04:00'),
(75,'America/Atikokan','-05:00'),
(76,'America/Atka','-10:00'),
(77,'America/Bahia','-03:00'),
(78,'America/Bahia_Banderas','-06:00'),
(79,'America/Barbados','-04:00'),
(80,'America/Belem','-03:00'),
(81,'America/Belize','-06:00'),
(82,'America/Blanc-Sablon','-04:00'),
(83,'America/Boa_Vista','-04:00'),
(84,'America/Bogota','-05:00'),
(85,'America/Boise','-07:00'),
(86,'America/Buenos_Aires','-03:00'),
(87,'America/Cambridge_Bay','-07:00'),
(88,'America/Campo_Grande','-04:00'),
(89,'America/Cancun','-05:00'),
(90,'America/Caracas','-04:00'),
(91,'America/Catamarca','-03:00'),
(92,'America/Cayenne','-03:00'),
(93,'America/Cayman','-05:00'),
(94,'America/Chicago','-06:00'),
(95,'America/Chihuahua','-07:00'),
(96,'America/Coral_Harbour','-05:00'),
(97,'America/Cordoba','-03:00'),
(98,'America/Costa_Rica','-06:00'),
(99,'America/Creston','-07:00'),
(100,'America/Cuiaba','-04:00'),
(101,'America/Curacao','-04:00'),
(102,'America/Danmarkshavn','+00:00'),
(103,'America/Dawson','-08:00'),
(104,'America/Dawson_Creek','-07:00'),
(105,'America/Denver','-07:00'),
(106,'America/Detroit','-05:00'),
(107,'America/Dominica','-04:00'),
(108,'America/Edmonton','-07:00'),
(109,'America/Eirunepe','-05:00'),
(110,'America/El_Salvador','-06:00'),
(111,'America/Ensenada','-08:00'),
(112,'America/Fort_Nelson','-07:00'),
(113,'America/Fort_Wayne','-05:00'),
(114,'America/Fortaleza','-03:00'),
(115,'America/Glace_Bay','-04:00'),
(116,'America/Godthab','-03:00'),
(117,'America/Goose_Bay','-04:00'),
(118,'America/Grand_Turk','-04:00'),
(119,'America/Grenada','-04:00'),
(120,'America/Guadeloupe','-04:00'),
(121,'America/Guatemala','-06:00'),
(122,'America/Guayaquil','-05:00'),
(123,'America/Guyana','-04:00'),
(124,'America/Halifax','-04:00'),
(125,'America/Havana','-05:00'),
(126,'America/Hermosillo','-07:00'),
(127,'America/Indiana/Indianapolis','-05:00'),
(128,'America/Indiana/Knox','-06:00'),
(129,'America/Indiana/Marengo','-05:00'),
(130,'America/Indiana/Petersburg','-05:00'),
(131,'America/Indiana/Tell_City','-06:00'),
(132,'America/Indiana/Vevay','-05:00'),
(133,'America/Indiana/Vincennes','-05:00'),
(134,'America/Indiana/Winamac','-05:00'),
(135,'America/Indianapolis','-05:00'),
(136,'America/Inuvik','-07:00'),
(137,'America/Iqaluit','-05:00'),
(138,'America/Jamaica','-05:00'),
(139,'America/Jujuy','-03:00'),
(140,'America/Juneau','-09:00'),
(141,'America/Kentucky/Louisville','-05:00'),
(142,'America/Kentucky/Monticello','-05:00'),
(143,'America/Knox_IN','-06:00'),
(144,'America/Kralendijk','-04:00'),
(145,'America/La_Paz','-04:00'),
(146,'America/Lima','-05:00'),
(147,'America/Los_Angeles','-08:00'),
(148,'America/Louisville','-05:00'),
(149,'America/Lower_Princes','-04:00'),
(150,'America/Maceio','-03:00'),
(151,'America/Managua','-06:00'),
(152,'America/Manaus','-04:00'),
(153,'America/Marigot','-04:00'),
(154,'America/Martinique','-04:00'),
(155,'America/Matamoros','-06:00'),
(156,'America/Mazatlan','-07:00'),
(157,'America/Mendoza','-03:00'),
(158,'America/Menominee','-06:00'),
(159,'America/Merida','-06:00'),
(160,'America/Metlakatla','-09:00'),
(161,'America/Mexico_City','-06:00'),
(162,'America/Miquelon','-03:00'),
(163,'America/Moncton','-04:00'),
(164,'America/Monterrey','-06:00'),
(165,'America/Montevideo','-03:00'),
(166,'America/Montreal','-05:00'),
(167,'America/Montserrat','-04:00'),
(168,'America/Nassau','-05:00'),
(169,'America/New_York','-05:00'),
(170,'America/Nipigon','-05:00'),
(171,'America/Nome','-09:00'),
(172,'America/Noronha','-02:00'),
(173,'America/North_Dakota/Beulah','-06:00'),
(174,'America/North_Dakota/Center','-06:00'),
(175,'America/North_Dakota/New_Salem','-06:00'),
(176,'America/Ojinaga','-07:00'),
(177,'America/Panama','-05:00'),
(178,'America/Pangnirtung','-05:00'),
(179,'America/Paramaribo','-03:00'),
(180,'America/Phoenix','-07:00'),
(181,'America/Port_of_Spain','-04:00'),
(182,'America/Port-au-Prince','-05:00'),
(183,'America/Porto_Acre','-05:00'),
(184,'America/Porto_Velho','-04:00'),
(185,'America/Puerto_Rico','-04:00'),
(186,'America/Rainy_River','-06:00'),
(187,'America/Rankin_Inlet','-06:00'),
(188,'America/Recife','-03:00'),
(189,'America/Regina','-06:00'),
(190,'America/Resolute','-06:00'),
(191,'America/Rio_Branco','-05:00'),
(192,'America/Rosario','-03:00'),
(193,'America/Santa_Isabel','-08:00'),
(194,'America/Santarem','-03:00'),
(195,'America/Santiago','-04:00'),
(196,'America/Santo_Domingo','-04:00'),
(197,'America/Sao_Paulo','-03:00'),
(198,'America/Scoresbysund','-01:00'),
(199,'America/Shiprock','-07:00'),
(200,'America/Sitka','-09:00'),
(201,'America/St_Barthelemy','-04:00'),
(202,'America/St_Johns','#VALUE!'),
(203,'America/St_Kitts','-04:00'),
(204,'America/St_Lucia','-04:00'),
(205,'America/St_Thomas','-04:00'),
(206,'America/St_Vincent','-04:00'),
(207,'America/Swift_Current','-06:00'),
(208,'America/Tegucigalpa','-06:00'),
(209,'America/Thule','-04:00'),
(210,'America/Thunder_Bay','-05:00'),
(211,'America/Tijuana','-08:00'),
(212,'America/Toronto','-05:00'),
(213,'America/Tortola','-04:00'),
(214,'America/Vancouver','-08:00'),
(215,'America/Virgin','-04:00'),
(216,'America/Whitehorse','-08:00'),
(217,'America/Winnipeg','-06:00'),
(218,'America/Yakutat','-09:00'),
(219,'America/Yellowknife','-07:00'),
(220,'Antarctica/Casey','+08:00'),
(221,'Antarctica/Davis','+07:00'),
(222,'Antarctica/DumontDUrville','+10:00'),
(223,'Antarctica/Macquarie','+11:00'),
(224,'Antarctica/Mawson','+05:00'),
(225,'Antarctica/McMurdo','+12:00'),
(226,'Antarctica/Palmer','-04:00'),
(227,'Antarctica/Rothera','-03:00'),
(228,'Antarctica/South_Pole','+12:00'),
(229,'Antarctica/Syowa','+03:00'),
(230,'Antarctica/Troll','+00:00'),
(231,'Antarctica/Vostok','+06:00'),
(232,'Arctic/Longyearbyen','+01:00'),
(233,'Asia/Aden','+03:00'),
(234,'Asia/Almaty','+06:00'),
(235,'Asia/Amman','+02:00'),
(236,'Asia/Anadyr','+12:00'),
(237,'Asia/Aqtau','+05:00'),
(238,'Asia/Aqtobe','+05:00'),
(239,'Asia/Ashgabat','+05:00'),
(240,'Asia/Ashkhabad','+05:00'),
(241,'Asia/Baghdad','+03:00'),
(242,'Asia/Bahrain','+03:00'),
(243,'Asia/Baku','+04:00'),
(244,'Asia/Bangkok','+07:00'),
(245,'Asia/Barnaul','+07:00'),
(246,'Asia/Beirut','+02:00'),
(247,'Asia/Bishkek','+06:00'),
(248,'Asia/Brunei','+08:00'),
(249,'Asia/Calcutta','+05:30'),
(250,'Asia/Chita','+09:00'),
(251,'Asia/Choibalsan','+08:00'),
(252,'Asia/Chongqing','+08:00'),
(253,'Asia/Chungking','+08:00'),
(254,'Asia/Colombo','+05:30'),
(255,'Asia/Dacca','+06:00'),
(256,'Asia/Damascus','+02:00'),
(257,'Asia/Dhaka','+06:00'),
(258,'Asia/Dili','+09:00'),
(259,'Asia/Dubai','+04:00'),
(260,'Asia/Dushanbe','+05:00'),
(261,'Asia/Gaza','+02:00'),
(262,'Asia/Harbin','+08:00'),
(263,'Asia/Hebron','+02:00'),
(264,'Asia/Ho_Chi_Minh','+07:00'),
(265,'Asia/Hong_Kong','+08:00'),
(266,'Asia/Hovd','+07:00'),
(267,'Asia/Irkutsk','+08:00'),
(268,'Asia/Istanbul','+03:00'),
(269,'Asia/Jakarta','+07:00'),
(270,'Asia/Jayapura','+09:00'),
(271,'Asia/Jerusalem','+02:00'),
(272,'Asia/Kabul','+04:30'),
(273,'Asia/Kamchatka','+12:00'),
(274,'Asia/Karachi','+05:00'),
(275,'Asia/Kashgar[note 1]','+06:00'),
(276,'Asia/Kathmandu','+05:45'),
(277,'Asia/Katmandu','+05:45'),
(278,'Asia/Khandyga','+09:00'),
(279,'Asia/Kolkata','+05:30'),
(280,'Asia/Krasnoyarsk','+07:00'),
(281,'Asia/Kuala_Lumpur','+08:00'),
(282,'Asia/Kuching','+08:00'),
(283,'Asia/Kuwait','+03:00'),
(284,'Asia/Macao','+08:00'),
(285,'Asia/Macau','+08:00'),
(286,'Asia/Magadan','+11:00'),
(287,'Asia/Makassar','+08:00'),
(288,'Asia/Manila','+08:00'),
(289,'Asia/Muscat','+04:00'),
(290,'Asia/Nicosia','+02:00'),
(291,'Asia/Novokuznetsk','+07:00'),
(292,'Asia/Novosibirsk','+07:00'),
(293,'Asia/Omsk','+06:00'),
(294,'Asia/Oral','+05:00'),
(295,'Asia/Phnom_Penh','+07:00'),
(296,'Asia/Pontianak','+07:00'),
(297,'Asia/Pyongyang','+08:30'),
(298,'Asia/Qatar','+03:00'),
(299,'Asia/Qyzylorda','+06:00'),
(300,'Asia/Rangoon','+06:30'),
(301,'Asia/Riyadh','+03:00'),
(302,'Asia/Saigon','+07:00'),
(303,'Asia/Sakhalin','+11:00'),
(304,'Asia/Samarkand','+05:00'),
(305,'Asia/Seoul','+09:00'),
(306,'Asia/Shanghai','+08:00'),
(307,'Asia/Singapore','+08:00'),
(308,'Asia/Srednekolymsk','+11:00'),
(309,'Asia/Taipei','+08:00'),
(310,'Asia/Tashkent','+05:00'),
(311,'Asia/Tbilisi','+04:00'),
(312,'Asia/Tehran','+03:30'),
(313,'Asia/Tel_Aviv','+02:00'),
(314,'Asia/Thimbu','+06:00'),
(315,'Asia/Thimphu','+06:00'),
(316,'Asia/Tokyo','+09:00'),
(317,'Asia/Tomsk','+07:00'),
(318,'Asia/Ujung_Pandang','+08:00'),
(319,'Asia/Ulaanbaatar','+08:00'),
(320,'Asia/Ulan_Bator','+08:00'),
(321,'Asia/Urumqi[note 2]','+06:00'),
(322,'Asia/Ust-Nera','+10:00'),
(323,'Asia/Vientiane','+07:00'),
(324,'Asia/Vladivostok','+10:00'),
(325,'Asia/Yakutsk','+09:00'),
(326,'Asia/Yekaterinburg','+05:00'),
(327,'Asia/Yerevan','+04:00'),
(328,'Atlantic/Azores','-01:00'),
(329,'Atlantic/Bermuda','-04:00'),
(330,'Atlantic/Canary','+00:00'),
(331,'Atlantic/Cape_Verde','-01:00'),
(332,'Atlantic/Faeroe','+00:00'),
(333,'Atlantic/Faroe','+00:00'),
(334,'Atlantic/Jan_Mayen','+01:00'),
(335,'Atlantic/Madeira','+00:00'),
(336,'Atlantic/Reykjavik','+00:00'),
(337,'Atlantic/South_Georgia','-02:00'),
(338,'Atlantic/St_Helena','+00:00'),
(339,'Atlantic/Stanley','-03:00'),
(340,'Australia/ACT','+10:00'),
(341,'Australia/Adelaide','+09:30'),
(342,'Australia/Brisbane','+10:00'),
(343,'Australia/Broken_Hill','+09:30'),
(344,'Australia/Canberra','+10:00'),
(345,'Australia/Currie','+10:00'),
(346,'Australia/Darwin','+09:30'),
(347,'Australia/Eucla','+08:45'),
(348,'Australia/Hobart','+10:00'),
(349,'Australia/LHI','+10:30'),
(350,'Australia/Lindeman','+10:00'),
(351,'Australia/Lord_Howe','+10:30'),
(352,'Australia/Melbourne','+10:00'),
(353,'Australia/North','+09:30'),
(354,'Australia/NSW','+10:00'),
(355,'Australia/Perth','+08:00'),
(356,'Australia/Queensland','+10:00'),
(357,'Australia/South','+09:30'),
(358,'Australia/Sydney','+10:00'),
(359,'Australia/Tasmania','+10:00'),
(360,'Australia/Victoria','+10:00'),
(361,'Australia/West','+08:00'),
(362,'Australia/Yancowinna','+09:30'),
(363,'Brazil/Acre','-05:00'),
(364,'Brazil/DeNoronha','-02:00'),
(365,'Brazil/East','-03:00'),
(366,'Brazil/West','-04:00'),
(367,'Canada/Atlantic','-04:00'),
(368,'Canada/Central','-06:00'),
(369,'Canada/Eastern','-05:00'),
(370,'Canada/East-Saskatchewan','-06:00'),
(371,'Canada/Mountain','-07:00'),
(372,'Canada/Newfoundland','#VALUE!'),
(373,'Canada/Pacific','-08:00'),
(374,'Canada/Saskatchewan','-06:00'),
(375,'Canada/Yukon','-08:00'),
(376,'CET','+01:00'),
(377,'Chile/Continental','-04:00'),
(378,'Chile/EasterIsland','-06:00'),
(379,'CST6CDT','-06:00'),
(380,'Cuba','-05:00'),
(381,'EET','+02:00'),
(382,'Egypt','+02:00'),
(383,'Eire','+00:00'),
(384,'EST','-05:00'),
(385,'EST5EDT','-05:00'),
(386,'Etc/GMT','+00:00'),
(387,'Etc/GMT+0','+00:00'),
(388,'Etc/GMT+1','-01:00'),
(389,'Etc/GMT+10','-10:00'),
(390,'Etc/GMT+11','-11:00'),
(391,'Etc/GMT+12','-12:00'),
(392,'Etc/GMT+2','-02:00'),
(393,'Etc/GMT+3','-03:00'),
(394,'Etc/GMT+4','-04:00'),
(395,'Etc/GMT+5','-05:00'),
(396,'Etc/GMT+6','-06:00'),
(397,'Etc/GMT+7','-07:00'),
(398,'Etc/GMT+8','-08:00'),
(399,'Etc/GMT+9','-09:00'),
(400,'Etc/GMT0','+00:00'),
(401,'Etc/GMT-0','+00:00'),
(402,'Etc/GMT-1','+01:00'),
(403,'Etc/GMT-10','+10:00'),
(404,'Etc/GMT-11','+11:00'),
(405,'Etc/GMT-12','+12:00'),
(406,'Etc/GMT-13','+13:00'),
(407,'Etc/GMT-14','+14:00'),
(408,'Etc/GMT-2','+02:00'),
(409,'Etc/GMT-3','+03:00'),
(410,'Etc/GMT-4','+04:00'),
(411,'Etc/GMT-5','+05:00'),
(412,'Etc/GMT-6','+06:00'),
(413,'Etc/GMT-7','+07:00'),
(414,'Etc/GMT-8','+08:00'),
(415,'Etc/GMT-9','+09:00'),
(416,'Etc/Greenwich','+00:00'),
(417,'Etc/UCT','+00:00'),
(418,'Etc/Universal','+00:00'),
(419,'Etc/UTC','+00:00'),
(420,'Etc/Zulu','+00:00'),
(421,'Europe/Amsterdam','+01:00'),
(422,'Europe/Andorra','+01:00'),
(423,'Europe/Astrakhan','+04:00'),
(424,'Europe/Athens','+02:00'),
(425,'Europe/Belfast','+00:00'),
(426,'Europe/Belgrade','+01:00'),
(427,'Europe/Berlin','+01:00'),
(428,'Europe/Bratislava','+01:00'),
(429,'Europe/Brussels','+01:00'),
(430,'Europe/Bucharest','+02:00'),
(431,'Europe/Budapest','+01:00'),
(432,'Europe/Busingen','+01:00'),
(433,'Europe/Chisinau','+02:00'),
(434,'Europe/Copenhagen','+01:00'),
(435,'Europe/Dublin','+00:00'),
(436,'Europe/Gibraltar','+01:00'),
(437,'Europe/Guernsey','+00:00'),
(438,'Europe/Helsinki','+02:00'),
(439,'Europe/Isle_of_Man','+00:00'),
(440,'Europe/Istanbul','+03:00'),
(441,'Europe/Jersey','+00:00'),
(442,'Europe/Kaliningrad','+02:00'),
(443,'Europe/Kiev','+02:00'),
(444,'Europe/Kirov','+03:00'),
(445,'Europe/Lisbon','+00:00'),
(446,'Europe/Ljubljana','+01:00'),
(447,'Europe/London','+00:00'),
(448,'Europe/Luxembourg','+01:00'),
(449,'Europe/Madrid','+01:00'),
(450,'Europe/Malta','+01:00'),
(451,'Europe/Mariehamn','+02:00'),
(452,'Europe/Minsk','+03:00'),
(453,'Europe/Monaco','+01:00'),
(454,'Europe/Moscow','+03:00'),
(455,'Europe/Nicosia','+02:00'),
(456,'Europe/Oslo','+01:00'),
(457,'Europe/Paris','+01:00'),
(458,'Europe/Podgorica','+01:00'),
(459,'Europe/Prague','+01:00'),
(460,'Europe/Riga','+02:00'),
(461,'Europe/Rome','+01:00'),
(462,'Europe/Samara','+04:00'),
(463,'Europe/San_Marino','+01:00'),
(464,'Europe/Sarajevo','+01:00'),
(465,'Europe/Simferopol','+03:00'),
(466,'Europe/Skopje','+01:00'),
(467,'Europe/Sofia','+02:00'),
(468,'Europe/Stockholm','+01:00'),
(469,'Europe/Tallinn','+02:00'),
(470,'Europe/Tirane','+01:00'),
(471,'Europe/Tiraspol','+02:00'),
(472,'Europe/Ulyanovsk','+04:00'),
(473,'Europe/Uzhgorod','+02:00'),
(474,'Europe/Vaduz','+01:00'),
(475,'Europe/Vatican','+01:00'),
(476,'Europe/Vienna','+01:00'),
(477,'Europe/Vilnius','+02:00'),
(478,'Europe/Volgograd','+03:00'),
(479,'Europe/Warsaw','+01:00'),
(480,'Europe/Zagreb','+01:00'),
(481,'Europe/Zaporozhye','+02:00'),
(482,'Europe/Zurich','+01:00'),
(483,'GB','+00:00'),
(484,'GB-Eire','+00:00'),
(485,'GMT','+00:00'),
(486,'GMT+0','+00:00'),
(487,'GMT0','+00:00'),
(488,'GMT-0','+00:00'),
(489,'Greenwich','+00:00'),
(490,'Hongkong','+08:00'),
(491,'HST','-10:00'),
(492,'Iceland','+00:00'),
(493,'Indian/Antananarivo','+03:00'),
(494,'Indian/Chagos','+06:00'),
(495,'Indian/Christmas','+07:00'),
(496,'Indian/Cocos','+06:30'),
(497,'Indian/Comoro','+03:00'),
(498,'Indian/Kerguelen','+05:00'),
(499,'Indian/Mahe','+04:00'),
(500,'Indian/Maldives','+05:00'),
(501,'Indian/Mauritius','+04:00'),
(502,'Indian/Mayotte','+03:00'),
(503,'Indian/Reunion','+04:00'),
(504,'Iran','+03:30'),
(505,'Israel','+02:00'),
(506,'Jamaica','-05:00'),
(507,'Japan','+09:00'),
(508,'Kwajalein','+12:00'),
(509,'Libya','+02:00'),
(510,'MET','+01:00'),
(511,'Mexico/BajaNorte','-08:00'),
(512,'Mexico/BajaSur','-07:00'),
(513,'Mexico/General','-06:00'),
(514,'MST','-07:00'),
(515,'MST7MDT','-07:00'),
(516,'Navajo','-07:00'),
(517,'NZ','+12:00'),
(518,'NZ-CHAT','+12:45'),
(519,'Pacific/Apia','+13:00'),
(520,'Pacific/Auckland','+12:00'),
(521,'Pacific/Bougainville','+11:00'),
(522,'Pacific/Chatham','+12:45'),
(523,'Pacific/Chuuk','+10:00'),
(524,'Pacific/Easter','-06:00'),
(525,'Pacific/Efate','+11:00'),
(526,'Pacific/Enderbury','+13:00'),
(527,'Pacific/Fakaofo','+13:00'),
(528,'Pacific/Fiji','+12:00'),
(529,'Pacific/Funafuti','+12:00'),
(530,'Pacific/Galapagos','-06:00'),
(531,'Pacific/Gambier','-09:00'),
(532,'Pacific/Guadalcanal','+11:00'),
(533,'Pacific/Guam','+10:00'),
(534,'Pacific/Honolulu','-10:00'),
(535,'Pacific/Johnston','-10:00'),
(536,'Pacific/Kiritimati','+14:00'),
(537,'Pacific/Kosrae','+11:00'),
(538,'Pacific/Kwajalein','+12:00'),
(539,'Pacific/Majuro','+12:00'),
(540,'Pacific/Marquesas','#VALUE!'),
(541,'Pacific/Midway','-11:00'),
(542,'Pacific/Nauru','+12:00'),
(543,'Pacific/Niue','-11:00'),
(544,'Pacific/Norfolk','+11:00'),
(545,'Pacific/Noumea','+11:00'),
(546,'Pacific/Pago_Pago','-11:00'),
(547,'Pacific/Palau','+09:00'),
(548,'Pacific/Pitcairn','-08:00'),
(549,'Pacific/Pohnpei','+11:00'),
(550,'Pacific/Ponape','+11:00'),
(551,'Pacific/Port_Moresby','+10:00'),
(552,'Pacific/Rarotonga','-10:00'),
(553,'Pacific/Saipan','+10:00'),
(554,'Pacific/Samoa','-11:00'),
(555,'Pacific/Tahiti','-10:00'),
(556,'Pacific/Tarawa','+12:00'),
(557,'Pacific/Tongatapu','+13:00'),
(558,'Pacific/Truk','+10:00'),
(559,'Pacific/Wake','+12:00'),
(560,'Pacific/Wallis','+12:00'),
(561,'Pacific/Yap','+10:00'),
(562,'Poland','+01:00'),
(563,'Portugal','+00:00'),
(564,'PRC','+08:00'),
(565,'PST8PDT','-08:00'),
(566,'ROC','+08:00'),
(567,'ROK','+09:00'),
(568,'Singapore','+08:00'),
(569,'Turkey','+03:00'),
(570,'UCT','+00:00'),
(571,'Universal','+00:00'),
(572,'US/Alaska','-09:00'),
(573,'US/Aleutian','-10:00'),
(574,'US/Arizona','-07:00'),
(575,'US/Central','-06:00'),
(576,'US/Eastern','-05:00'),
(577,'US/East-Indiana','-05:00'),
(578,'US/Hawaii','-10:00'),
(579,'US/Indiana-Starke','-06:00'),
(580,'US/Michigan','-05:00'),
(581,'US/Mountain','-07:00'),
(582,'US/Pacific','-08:00'),
(583,'US/Pacific-New','-08:00'),
(584,'US/Samoa','-11:00'),
(585,'UTC','+00:00'),
(586,'WET','+00:00'),
(587,'W-SU','+03:00'),
(588,'Zulu','+00:00');

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `userdetailid` int(11) NOT NULL AUTO_INCREMENT,
  `usercode` varchar(20) DEFAULT NULL,
  `firstname` varchar(100) NOT NULL,
  `middlename` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `mobileno` varchar(15) NOT NULL,
  `coutrycodemobile` varchar(5) NOT NULL,
  `landlineno` varchar(15) DEFAULT NULL,
  `countrycodelandline` varchar(5) DEFAULT NULL,
  `address` text,
  `landmark` text,
  `area` varchar(50) DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  `stateId` int(11) NOT NULL,
  `city` varchar(150) DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `extlandline` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`userdetailid`),
  KEY `FK_tbl_userCountry` (`countryId`),
  KEY `FK_tbl_userstate` (`stateId`)
) ENGINE=InnoDB AUTO_INCREMENT=4731 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`userdetailid`,`usercode`,`firstname`,`middlename`,`lastname`,`gender`,`dob`,`mobileno`,`coutrycodemobile`,`landlineno`,`countrycodelandline`,`address`,`landmark`,`area`,`countryId`,`stateId`,`city`,`pincode`,`userid`,`extlandline`,`status`) values 
(4653,'hosregno1','test','test','test','Male','2015-04-01','3423423423','342','234','234','test','test','test',1,12,'test','323232',0,'2342',1),
(4659,'hosregno1','demo','demo','demo','Female','1997-04-16','3423423423','342','234','234','demo','demo','demo',1,12,'demo','213333',0,'2342',1),
(4661,NULL,'test','test','test','Male','2015-04-01','3423423423','342',NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,0,NULL,0),
(4680,'hosregno1','Lipi','Shah','Shah','Female','2017-04-05','1234567899','454','123','123','test','test','test',1,1,'abad','789547',0,'1213',1),
(4684,'hosregno1','Lipi','test','Shah','Female','2017-04-01','4545456465','454','454','454','Test','test','test',1,1,'test','789547',0,'1213',1),
(4690,'hosregno1','test','test','test','Male','2017-04-05','5465465465','454','123','123','test','landmark','area',3,158,'test','789547',0,'1213',1),
(4703,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','091','091','S.g Highway','','',1,12,'Ahmedabad','380067',0,'989898',1),
(4708,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','','','S.g Highway','','',1,12,'Ahmedabad','',0,'',1),
(4712,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','','','S.g Highway','','',1,12,'Ahmedabad','',0,'',1),
(4714,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','','','S.g Highway','','',1,12,'Ahmedabad','',0,'',1),
(4717,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','091','091','S.g Highway','','',1,12,'Ahmedabad','',0,'989898',1),
(4719,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','','','S.g Highway','','',1,12,'Ahmedabad','',0,'',1),
(4722,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','','','S.g Highway','','',1,12,'Ahmedabad','',0,'',1),
(4726,'hosregno1','Bhumika','','Patel','Female','2017-04-05','9898989898','091','','','S.g Highway','','',1,12,'Ahmedabad','',0,'',1),
(4730,NULL,'Bhumika','','Patel','Female','2005-06-13','9898989898','091',NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,0,NULL,0);

/*Table structure for table `tbl_userlogin` */

DROP TABLE IF EXISTS `tbl_userlogin`;

CREATE TABLE `tbl_userlogin` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `isCTPLUser` int(11) DEFAULT '0',
  `failedattempt` int(11) DEFAULT '0',
  `loginid` longtext NOT NULL,
  `password` varchar(255) NOT NULL,
  `cstatus` int(11) NOT NULL,
  `designationId` int(10) DEFAULT NULL,
  `forgotpwdHash` varchar(250) DEFAULT NULL,
  `forgotpwdExpiryDate` datetime DEFAULT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `isFirstLogin` int(11) DEFAULT '1',
  `usertypeid` int(11) NOT NULL,
  `casetypeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_tbl_userlogincasetype` (`casetypeid`),
  KEY `FK_tbl_userloginusertype` (`usertypeid`),
  KEY `FK_tbl_userlogindesign` (`designationId`),
  CONSTRAINT `FK_tbl_userlogindesign` FOREIGN KEY (`designationId`) REFERENCES `tbl_designation` (`designationid`),
  CONSTRAINT `FK_tbl_userloginusertype` FOREIGN KEY (`usertypeid`) REFERENCES `tbl_usertype` (`usertypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4131 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_userlogin` */

insert  into `tbl_userlogin`(`userId`,`isCTPLUser`,`failedattempt`,`loginid`,`password`,`cstatus`,`designationId`,`forgotpwdHash`,`forgotpwdExpiryDate`,`lastLogin`,`isFirstLogin`,`usertypeid`,`casetypeid`) values 
(4064,1,0,'superadmin@webstrikers.com','i3KIfuzbumRZYld9mcvu/g==',1,1,NULL,NULL,'2017-06-13 06:47:26',0,1,1),
(4130,0,0,'admin@123.com','i3KIfuzbumRZYld9mcvu/g==',1,1,NULL,NULL,'2017-06-13 07:14:23',0,1,NULL);

/*Table structure for table `tbl_usertype` */

DROP TABLE IF EXISTS `tbl_usertype`;

CREATE TABLE `tbl_usertype` (
  `usertypeid` int(11) NOT NULL AUTO_INCREMENT,
  `usertypename` text NOT NULL,
  PRIMARY KEY (`usertypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_usertype` */

insert  into `tbl_usertype`(`usertypeid`,`usertypename`) values 
(1,'Admin'),
(2,'Doctor'),
(3,'Patient'),
(4,'User');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
