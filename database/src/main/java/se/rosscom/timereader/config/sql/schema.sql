-- ----------------------------
--  Table structure for `ClientAuthorization`
-- ----------------------------
DROP TABLE IF EXISTS `ClientAuthorization`;
CREATE TABLE `ClientAuthorization` (
  `CompetitionName` varchar(30) NOT NULL,
  `User` varchar(40) NOT NULL,
  `Password` varchar(40) NOT NULL,
  `ClientType` varchar(12) NOT NULL,
  `Occupied` smallint(6) NOT NULL,
  PRIMARY KEY (`CompetitionName`,`User`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Competition`
-- ----------------------------
DROP TABLE IF EXISTS `Competition`;
CREATE TABLE `Competition` (
  `CompetitionId` smallint(6) NOT NULL,
  `CompetitionDate` date NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CompetitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `CompetitionPart`
-- ----------------------------
DROP TABLE IF EXISTS `CompetitionPart`;
CREATE TABLE `CompetitionPart` (
  `CompetitionPartId` smallint(6) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Length` decimal(5,2) DEFAULT NULL,
  `CompetitionId` smallint(6) NOT NULL,
  `Type` varchar(12) DEFAULT '',
  `Time` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`CompetitionPartId`),
  KEY `CompetitionId` (`CompetitionId`),
  CONSTRAINT `competitionpart_ibfk_1` FOREIGN KEY (`CompetitionId`) REFERENCES `Competition` (`CompetitionId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Competitor`
-- ----------------------------
DROP TABLE IF EXISTS `Competitor`;
CREATE TABLE `Competitor` (
  `CompetitorId` int(11) NOT NULL AUTO_INCREMENT,
  `StartNr` smallint(6) DEFAULT NULL,
  `StartingGroupId` int(11) DEFAULT NULL,
  `CompetitionPartId` smallint(6) DEFAULT NULL,
  `Ename` varchar(30) DEFAULT NULL,
  `Fname` varchar(30) DEFAULT NULL,
  `Sex` varchar(10) NOT NULL,
  `BornDate` date DEFAULT NULL,
  `Location` varchar(40) DEFAULT NULL,
  `Country` varchar(40) DEFAULT NULL,
  `Club` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`CompetitorId`),
  KEY `StartNr` (`StartNr`),
  KEY `StartingGroupId` (`StartingGroupId`),
  KEY `CompetitionPartId` (`CompetitionPartId`),
  KEY `StartNr_2` (`StartNr`,`CompetitionPartId`),
  KEY `StartNr_3` (`StartNr`,`CompetitionPartId`),
  CONSTRAINT `competitor_ibfk_2` FOREIGN KEY (`StartNr`) REFERENCES `StartId` (`StartNr`) ON DELETE SET NULL,
  CONSTRAINT `competitor_ibfk_3` FOREIGN KEY (`StartingGroupId`) REFERENCES `StartingGroup` (`Id`) ON DELETE SET NULL,
  CONSTRAINT `competitor_ibfk_4` FOREIGN KEY (`CompetitionPartId`) REFERENCES `CompetitionPart` (`CompetitionPartId`),
  CONSTRAINT `competitor_ibfk_5` FOREIGN KEY (`CompetitionPartId`) REFERENCES `StartId` (`CompetitionPartId`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4558 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `History_Results`
-- ----------------------------
DROP TABLE IF EXISTS `History_Results`;
CREATE TABLE `History_Results` (
  `CompetitionPartId` smallint(6) NOT NULL DEFAULT '0',
  `StartNr` smallint(6) NOT NULL DEFAULT '0',
  `ResultType` varchar(10) NOT NULL DEFAULT '',
  `Lap` smallint(3) NOT NULL DEFAULT '0',
  `Position` smallint(6) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `EndTime` time DEFAULT NULL,
  `ReaderID` smallint(2) DEFAULT NULL,
  `RFID` varchar(30) DEFAULT NULL,
  `ReaderDatetime` datetime DEFAULT NULL,
  `ReaderCount` smallint(3) DEFAULT NULL,
  PRIMARY KEY (`StartNr`,`ResultType`,`CompetitionPartId`,`Lap`),
  KEY `StartNr` (`StartNr`),
  KEY `StartNr_3` (`StartNr`,`CompetitionPartId`),
  KEY `CompetitionPartId` (`CompetitionPartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `RFID`
-- ----------------------------
DROP TABLE IF EXISTS `RFID`;
CREATE TABLE `RFID` (
  `RFIDtag` varchar(30) NOT NULL,
  PRIMARY KEY (`RFIDtag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Reader`
-- ----------------------------
DROP TABLE IF EXISTS `Reader`;
CREATE TABLE `Reader` (
  `ReaderId` smallint(2) NOT NULL DEFAULT '0',
  `Lap` smallint(3) NOT NULL DEFAULT '0',
  `CompetitionPartId` smallint(6) NOT NULL,
  `ReaderType` varchar(10) NOT NULL DEFAULT '',
  `LengthFromStart` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`ReaderId`,`Lap`,`CompetitionPartId`,`ReaderType`),
  KEY `ReaderId` (`ReaderId`),
  KEY `Lap` (`Lap`),
  KEY `CompetitionPartId` (`CompetitionPartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `ReaderConfiguration`
-- ----------------------------
DROP TABLE IF EXISTS `ReaderConfiguration`;
CREATE TABLE `ReaderConfiguration` (
  `ReaderId` smallint(3) NOT NULL,
  `Ipadress` varchar(20) DEFAULT NULL,
  `Readpower` smallint(4) DEFAULT NULL,
  `AsyncOffTime` smallint(4) DEFAULT NULL,
  PRIMARY KEY (`ReaderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `ReaderRegistration`
-- ----------------------------
DROP TABLE IF EXISTS `ReaderRegistration`;
CREATE TABLE `ReaderRegistration` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ReaderID` smallint(2) NOT NULL DEFAULT '0',
  `RFID` varchar(30) NOT NULL DEFAULT '0',
  `AntennID` smallint(1) NOT NULL DEFAULT '0',
  `ReaderDateTime` datetime DEFAULT '1900-01-01 00:00:00',
  `AppDateTime` datetime DEFAULT '1900-01-01 00:00:00',
  `TimeStamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ReaderCount` smallint(3) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `RFID` (`RFID`),
  KEY `ReaderID` (`ReaderID`),
  KEY `ReaderID_2` (`ReaderID`),
  KEY `ReaderID_3` (`ReaderID`),
  KEY `ReaderID_4` (`ReaderID`),
  KEY `ReaderCount` (`ReaderCount`),
  CONSTRAINT `readerregistration_ibfk_1` FOREIGN KEY (`ReaderID`) REFERENCES `Reader` (`ReaderId`)
) ENGINE=InnoDB AUTO_INCREMENT=730 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Results`
-- ----------------------------
DROP TABLE IF EXISTS `Results`;
CREATE TABLE `Results` (
  `ResultId` int(11) NOT NULL AUTO_INCREMENT,
  `CompetitionPartId` smallint(6) DEFAULT '0',
  `StartNr` smallint(6) DEFAULT '0',
  `ResultType` varchar(10) DEFAULT '',
  `Lap` smallint(3) DEFAULT '0',
  `Position` smallint(6) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `EndTime` time DEFAULT NULL,
  PRIMARY KEY (`ResultId`),
  KEY `StartNr` (`StartNr`),
  KEY `StartNr_3` (`StartNr`,`CompetitionPartId`),
  KEY `CompetitionPartId` (`CompetitionPartId`)
) ENGINE=InnoDB AUTO_INCREMENT=368 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `StartId`
-- ----------------------------
DROP TABLE IF EXISTS `StartId`;
CREATE TABLE `StartId` (
  `StartNr` smallint(6) NOT NULL,
  `CompetitionPartId` smallint(6) NOT NULL,
  `RFID` varchar(30) DEFAULT '0',
  `StartingGroupId` int(11) DEFAULT NULL,
  PRIMARY KEY (`StartNr`,`CompetitionPartId`),
  KEY `RFID` (`RFID`),
  KEY `StartNr` (`StartNr`),
  KEY `CompetitionPartId` (`CompetitionPartId`),
  KEY `StartNr_2` (`StartNr`,`CompetitionPartId`),
  KEY `StartingGroupId` (`StartingGroupId`),
  KEY `StartingGroupId_2` (`StartingGroupId`),
  CONSTRAINT `startid_ibfk_1` FOREIGN KEY (`CompetitionPartId`) REFERENCES `CompetitionPart` (`CompetitionPartId`),
  CONSTRAINT `startid_ibfk_2` FOREIGN KEY (`StartingGroupId`) REFERENCES `StartingGroup` (`Id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `StartingGroup`
-- ----------------------------
DROP TABLE IF EXISTS `StartingGroup`;
CREATE TABLE `StartingGroup` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `OfficialStartingTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ActualStartingTime` timestamp NULL DEFAULT NULL,
  `StartArea` varchar(30) DEFAULT NULL,
  `AutomaticStart` int(11) DEFAULT NULL,
  `CompetitionPartId` smallint(6) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `CompetitionPartId` (`CompetitionPartId`),
  CONSTRAINT `startinggroup_ibfk_1` FOREIGN KEY (`CompetitionPartId`) REFERENCES `CompetitionPart` (`CompetitionPartId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `lopare`
-- ----------------------------
DROP TABLE IF EXISTS `lopare`;
CREATE TABLE `lopare` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `f_namn` char(100) COLLATE utf8_swedish_ci DEFAULT NULL,
  `e_namn` char(100) COLLATE utf8_swedish_ci DEFAULT NULL,
  `TavlingID` int(5) DEFAULT '0',
  `ResultatID` int(11) DEFAULT '0',
  `stracka_old` int(3) DEFAULT '0',
  `kon` smallint(1) DEFAULT '0',
  `borndate` date DEFAULT '1900-01-01',
  `AgeClassID` int(11) DEFAULT '0',
  `UserID` int(11) DEFAULT '0',
  `ort` char(100) COLLATE utf8_swedish_ci DEFAULT NULL,
  `country` char(30) COLLATE utf8_swedish_ci DEFAULT NULL,
  `countryid` int(11) DEFAULT '0',
  `klubb` char(200) COLLATE utf8_swedish_ci DEFAULT NULL,
  `epost` char(100) COLLATE utf8_swedish_ci DEFAULT NULL,
  `mobil` char(100) COLLATE utf8_swedish_ci DEFAULT NULL,
  `shirtsize` char(10) COLLATE utf8_swedish_ci DEFAULT NULL,
  `url` char(255) COLLATE utf8_swedish_ci DEFAULT NULL,
  `seedning` longtext COLLATE utf8_swedish_ci,
  `speaker` tinytext COLLATE utf8_swedish_ci,
  `b120` smallint(1) DEFAULT '0',
  `kortsim` smallint(1) DEFAULT '0',
  `halvsim` smallint(1) DEFAULT '0',
  `tjejsim` smallint(1) DEFAULT '0',
  `tritahlon` smallint(1) DEFAULT '0',
  `lillasim` smallint(1) DEFAULT '0',
  `ungdomssim` smallint(1) DEFAULT '0',
  `masters` smallint(1) DEFAULT '0',
  `simningen` smallint(1) DEFAULT '0',
  `ageok` smallint(1) DEFAULT '0',
  `fotook` smallint(1) DEFAULT '0',
  `ansvarok` smallint(1) DEFAULT '0',
  `VisaDatum` datetime DEFAULT '1900-01-01 00:00:00',
  `SessionID` int(20) DEFAULT NULL,
  `IpNr` char(20) COLLATE utf8_swedish_ci DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'OBS INTE On Update!!!',
  `StatusID` smallint(1) DEFAULT '1',
  `Avgift` int(5) DEFAULT '0',
  `AvgiftOK` smallint(6) DEFAULT '0',
  `BetaldmetodID` int(1) DEFAULT '0',
  `BetaldDatum` date DEFAULT '1900-01-01',
  `Kommentar` longtext COLLATE utf8_swedish_ci,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1017 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

-- ----------------------------
--  Table structure for `resultat`
-- ----------------------------
DROP TABLE IF EXISTS `resultat`;
CREATE TABLE `resultat` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TavlingID` int(5) DEFAULT '6',
  `Stracka` int(3) DEFAULT '0',
  `StartTime` datetime DEFAULT '1900-01-01 00:00:00',
  `StartNr` int(5) DEFAULT '0',
  `StartGroup` int(5) DEFAULT '2',
  `FinishTime` datetime DEFAULT '1900-01-01 00:00:00',
  `BibStatusID` smallint(2) DEFAULT '0',
  `Kommentar` longtext COLLATE utf8_swedish_ci,
  `FinishTime_old` time DEFAULT '00:00:00' COMMENT 'Not Calculated Time',
  `StartTime_old` time DEFAULT '15:45:00',
  `StartDate_old` date DEFAULT '2012-07-05',
  `Finish_OK_old` smallint(1) DEFAULT '0',
  `Place_old` int(5) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `Resultat` (`TavlingID`,`StartNr`,`BibStatusID`,`StartTime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1164 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

