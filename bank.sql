create schema bank;
use bank;

CREATE TABLE `login` (
  `accountNo` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`accountNo`)
);

CREATE TABLE `user` (
  `accountNo` int NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `PAN` varchar(45) NOT NULL,
  `aadhar` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `DOB` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `balance` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`accountNo`),
  CONSTRAINT `FK_user_login` FOREIGN KEY (`accountNo`) REFERENCES `login` (`accountNo`)
);

CREATE TABLE `logs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `accountNo` int NOT NULL,
  `balance` int NOT NULL DEFAULT '0',
  `deposit` varchar(45) DEFAULT '0',
  `withdraw` varchar(45) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_logs_login_idx` (`accountNo`),
  CONSTRAINT `FK_logs_login` FOREIGN KEY (`accountNo`) REFERENCES `login` (`accountNo`)
);

set foreign_key_checks=0
