ALTER TABLE `tbl_clinicalreports` CHANGE `findingReport` `findingReport` TEXT CHARSET latin1 COLLATE latin1_swedish_ci NULL; 
ALTER TABLE `tbl_clinicalreports` CHANGE COLUMN `findingReport` `findingReport` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL; 
