ALTER TABLE `tbl_consultingdoctor` ADD COLUMN `userid` INT NULL AFTER `consultingdoctorname`; 
DELETE FROM `tbl_consultingdoctor` WHERE `consultingdoctorid` = '1'; 
 DELETE FROM `tbl_consultingdoctor` WHERE `consultingdoctorid` = '2'; 