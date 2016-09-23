-- MySQL Script generated by MySQL Workbench
-- 09/20/16 11:41:47
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kinoempire
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `kinoempire`;
CREATE SCHEMA IF NOT EXISTS `kinoempire` DEFAULT CHARACTER SET utf8 ;
USE `kinoempire` ;

-- -----------------------------------------------------
-- Table `KinoXP`.`Movies`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `kinoempire`.`Movies` ;

CREATE TABLE IF NOT EXISTS `kinoempire`.`Movies` (
  `Danish Title` VARCHAR(45) NOT NULL,
  `Original Title` VARCHAR(45) NULL,
  `Genre` VARCHAR(45) NULL,
  `Filmlength` INT NULL,
  `Filmdescription` VARCHAR(45) NULL,
  `Release Date` DATE NULL,
  `Price` INT NULL,
  `Director` VARCHAR(45) NULL,
  `Age Restriction` INT NULL,
  `Versions` VARCHAR(45),
  PRIMARY KEY (`Title`));


-- -----------------------------------------------------
-- Table `KinoXP`.`Shows`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `kinoempire`.`Shows` ;

CREATE TABLE IF NOT EXISTS `kinoempire`.`Shows` (
  `show_id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NULL,
  `Date` DATE NULL,
  `Time` INT NULL,
  `Theater` INT NULL,
  PRIMARY KEY (`show_id`),
  INDEX `fk_movies_idx` (`Title` ASC),
  CONSTRAINT `fk_movies`
  FOREIGN KEY (`Title`)
  REFERENCES `kinoempire`.`Movies` (`Title`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `KinoXP`.`Customers`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `kinoempire`.`Customers` ;

CREATE TABLE IF NOT EXISTS `kinoempire`.`Customers` (
  `E-mail` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Phone Number` VARCHAR(11) NULL,
  PRIMARY KEY (`E-mail`));


-- -----------------------------------------------------
-- Table `KinoXP`.`Log`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `kinoempire`.`Sales` ;

CREATE TABLE IF NOT EXISTS `kinoempire`.`Sales` (
  `sales_id` INT NOT NULL AUTO_INCREMENT,
  `Show` INT NULL,
  `Customer` VARCHAR(45) NULL,
  `SeatIndex` INT NULL,
  `TimeOfSale` DATETIME NULL,
  `Status` VARCHAR(45) NULL,
  PRIMARY KEY (`sales_id`),
  INDEX `fk_show_idx` (`Show` ASC),
  INDEX `fk_customer_idx` (`Customer` ASC),
  CONSTRAINT `fk_show`
  FOREIGN KEY (`Show`)
  REFERENCES `kinoempire`.`Shows` (`show_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_customer`
  FOREIGN KEY (`Customer`)
  REFERENCES `kinoempire`.`Customers` (`E-mail`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;