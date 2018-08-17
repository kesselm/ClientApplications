CREATE TABLE `transaction`
(
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `bookingDate` varchar(60) DEFAULT NULL,
  `auftraggeber` varchar(100) DEFAULT NULL,
  `verwendungszweck` varchar(500) DEFAULT NULL,
  `saldo` varchar(50) DEFAULT NULL,
  `betrag` varchar(50) DEFAULT NULL,
  `waehrung` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
)