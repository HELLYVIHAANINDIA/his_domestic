CREATE TABLE `tbl_medicineschedule`( `seduleid` INT NOT NULL AUTO_INCREMENT, `medicineschedule` TEXT, `status` INT DEFAULT 0, PRIMARY KEY (`seduleid`) );
ALTER TABLE `tbl_medicineschedule` CHANGE `medicineschedule` `medicineschedule` TEXT CHARSET utf8 COLLATE utf8_general_ci NULL; 
ALTER TABLE `hisdomestic1`.`tbl_consultingdoctor` ADD COLUMN `userId` INT NULL AFTER `consultingdoctorname`; 
DELETE FROM `hisdomestic1`.`tbl_consultingdoctor` WHERE `consultingdoctorid` = '1'; 
 DELETE FROM `hisdomestic1`.`tbl_consultingdoctor` WHERE `consultingdoctorid` = '2'; 
 ALTER TABLE `hisdomestic1`.`tbl_user` CHANGE `dob` `dob` DATE NULL; 
 ALTER TABLE `hisdomestic1`.`tbl_clinicalreports` ADD COLUMN `schedualid` INT(11) NULL AFTER `statusid`; 
 ALTER TABLE `hisdomestic1`.`tbl_clinicalreports` CHANGE `schedualid` `schedualid` INT(11) DEFAULT 0 NOT NULL, CHANGE `findingReport` `findingReport` VARCHAR(50) CHARSET latin1 COLLATE latin1_swedish_ci NULL; 