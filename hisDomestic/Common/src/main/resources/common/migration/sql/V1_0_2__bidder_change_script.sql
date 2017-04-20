
CREATE TABLE `tbl_company` (
  `companyid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Company Id PK',
  `companyName` longtext NOT NULL COMMENT 'Company Name',
  `createdBy` int(11) NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT '2016-11-08 17:46:36',
  PRIMARY KEY (`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_company` */

insert  into `tbl_company`(`companyid`,`companyName`,`createdBy`,`createdOn`) values (1,'Cahoot',1,'2016-11-08 17:46:36');


ALTER TABLE `tbl_bidder` ADD `companyId` Int NOT NULL;

ALTER TABLE tbl_bidder ADD CONSTRAINT FK_tbl_bidder_company FOREIGN KEY (companyId) 
REFERENCES tbl_company(companyid) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE tbl_tendercurrency MODIFY currencyId int;

ALTER TABLE `tbl_tendercurrency` CHANGE `currencyId` `currencyId` int NOT NULL; 

ALTER TABLE tbl_tendercurrency ADD CONSTRAINT FK_tbl_tendercurrency FOREIGN KEY (currencyId) REFERENCES tbl_currency(currencyId) ON UPDATE CASCADE ON DELETE CASCADE;


CREATE TABLE `tbl_tenderbidcurrency` (
  `bidCurrencyId` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `tenderCurrencyId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`bidCurrencyId`),
  KEY `FK_tbl_tenderbidcurrency_company` (`companyId`),
  KEY `FK_tbl_tenderbidcurrency_currency` (`tenderCurrencyId`),
  CONSTRAINT `FK_tbl_tenderbidcurrency_company` FOREIGN KEY (`companyId`) REFERENCES `tbl_company` (`companyid`),
  CONSTRAINT `FK_tbl_tenderbidcurrency_currency` FOREIGN KEY (`tenderCurrencyId`) REFERENCES `tbl_tendercurrency` (`tenderCurrencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE tbl_tendercurrency ADD bidCurrencyId int;
ALTER TABLE `tbl_tendercurrency` CHANGE `bidCurrencyId` `bidCurrencyId` int NOT NULL; 


DELETE from tbl_tendercurrency;
ALTER TABLE tbl_tendercurrency ADD CONSTRAINT FK_tbl_tendercurrency_bidCurrencyId 
FOREIGN KEY (bidCurrencyId) REFERENCES tbl_tenderbidcurrency(bidCurrencyId) 
ON UPDATE CASCADE ON DELETE CASCADE;

/*Table structure for table `tbl_clientbidterm` */

CREATE TABLE `tbl_clientbidterm` (
  `clientBidTermId` int(11) NOT NULL AUTO_INCREMENT,
  `bidTerm` varchar(512) NOT NULL,
  `isActive` int(11) DEFAULT '0',
  PRIMARY KEY (`clientBidTermId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_clientbidterm` */

insert  into `tbl_clientbidterm`(`clientBidTermId`,`bidTerm`,`isActive`) values (1,'We, hereby declare that, \n<br>&#8195;&#8195;1.&#8195;We have read, examined and understood the tender document pertaining to this tender notice and have no reservations to the same,. \n<br>&#8195;&#8195;2.&#8195;We offer to execute the works in conformity with the tender Documents \n<br>&#8195;&#8195;3.&#8195;Our bid shall be valid for a period as mentioned in the tender document and it shall remain binding upon us. \n<br>&#8195;&#8195;4.&#8195;We understand that you are not bound to accept the lowest evaluate',1);


CREATE TABLE `tbl_tenderproxybid` (
  `cellValue` varchar(11) NOT NULL,
  `createdBy` int(11) NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ipAddress` varchar(11) NOT NULL,
  `proxyBidId` int(11) NOT NULL AUTO_INCREMENT,
  `rowId` int(11) NOT NULL,
  `isUpdatedFrom` int(11) NOT NULL,
  `tenderId` int(11) NOT NULL,
  `cellId` int(11) NOT NULL,
  `columnId` int(11) NOT NULL,
  `tableId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  PRIMARY KEY (`proxyBidId`),
  KEY `FK_tbl_tenderproxybid_table` (`tableId`),
  KEY `FK_tbl_tenderproxybid_column` (`columnId`),
  KEY `FK_tbl_tenderproxybid_cell` (`cellId`),
  KEY `FK_tbl_tenderproxybid_tender` (`tenderId`),
  KEY `FK_tbl_tenderproxybid_company` (`companyId`),
  CONSTRAINT `FK_tbl_tenderproxybid_cell` FOREIGN KEY (`cellId`) REFERENCES `tbl_tendercell` (`cellId`),
  CONSTRAINT `FK_tbl_tenderproxybid_column` FOREIGN KEY (`columnId`) REFERENCES `tbl_tendercolumn` (`columnId`),
  CONSTRAINT `FK_tbl_tenderproxybid_company` FOREIGN KEY (`companyId`) REFERENCES `tbl_company` (`companyid`),
  CONSTRAINT `FK_tbl_tenderproxybid_table` FOREIGN KEY (`tableId`) REFERENCES `tbl_tendertable` (`tableId`),
  CONSTRAINT `FK_tbl_tenderproxybid_tender` FOREIGN KEY (`tenderId`) REFERENCES `tbl_tender` (`tenderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



alter table tbl_tenderbidconfirmation add clientBidTermId int not null;


delete from tbl_tenderbidconfirmation;
ALTER TABLE tbl_tenderbidconfirmation ADD CONSTRAINT FK_tbl_tenderbidconfirmation_clientBidTerm FOREIGN KEY (clientBidTermId) 
REFERENCES tbl_clientbidterm(clientBidTermId) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE `tbl_tenderbidconfirmation` CHANGE `createdOn` `createdOn` DATEtime DEFAULT CURRENT_TIMESTAMP;

insert  into `tbl_bidder`(`bidderId`,`emailId`,`personName`,`companyName`,`address`,`countryId`,`stateId`,`city`,`phoneNo`,`mobileNo`,`website`,`keyword`,`cstatus`,`userId`,`datecreated`,`datemodified`,`createdBy`,`modifiedBy`,`companyId`) values (9,'bidder1@mail.com','Lipi','Cahoot','Abad',1,1,'1','1542584','1574874848','wwww.test.com','test',1,4,'0000-00-00 00:00:00','2016-11-24 17:00:00',4,4,1);



insert  into `tbl_commonlisting`(`listingId`,`actionItem`,`columnName`,`commonAction`,`discription`,`fromClause`,`isHQL`,`status`) 
values (10,'View,Dashboard','tenderNo:Tender No.:1,tenderDetail:Tender Detail:1,tenderId:tenderId:0',NULL,'Bidder Listing','from tbl_tender where 1=1 and cstatus = 1','\0',1);


alter table Tbl_TenderTable modify column formid int;