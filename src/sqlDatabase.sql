-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hospitalmanagement
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hospitalmanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospitalmanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hospitalmanagement` ;

-- -----------------------------------------------------
-- Table `hospitalmanagement`.`pacienti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospitalmanagement`.`pacienti` (
  `idPacient` INT NOT NULL,
  `nume` VARCHAR(45) NOT NULL,
  `varsta` INT NOT NULL,
  PRIMARY KEY (`idPacient`),
  INDEX `nume` (`nume` ASC) VISIBLE,
  INDEX `varsta` (`varsta` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospitalmanagement`.`istoric`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospitalmanagement`.`istoric` (
  `idistoric` INT NOT NULL,
  `idpacient` INT NOT NULL,
  `nume` VARCHAR(45) NOT NULL,
  `boli` VARCHAR(45) NOT NULL,
  `medicamente` VARCHAR(45) NOT NULL,
  `varsta` INT NOT NULL,
  PRIMARY KEY (`idistoric`),
  INDEX `numePacient_idx` (`nume` ASC) VISIBLE,
  INDEX `varstaPacient_idx` (`varsta` ASC) VISIBLE,
  CONSTRAINT `numePacient`
    FOREIGN KEY (`nume`)
    REFERENCES `hospitalmanagement`.`pacienti` (`nume`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `varstaPacient`
    FOREIGN KEY (`varsta`)
    REFERENCES `hospitalmanagement`.`pacienti` (`varsta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospitalmanagement`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospitalmanagement`.`login` (
  `idlogin` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`idlogin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospitalmanagement`.`programari`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospitalmanagement`.`programari` (
  `idProgramari` INT NOT NULL,
  `idPacient` INT NOT NULL,
  `data` VARCHAR(45) NOT NULL,
  `ora` VARCHAR(45) NOT NULL,
  `specializare` VARCHAR(45) NOT NULL,
  `medic` VARCHAR(45) NOT NULL,
  `servicii` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProgramari`),
  INDEX `idPacientProgramari_idx` (`idPacient` ASC, `data` ASC) VISIBLE,
  CONSTRAINT `idPacientProgramari`
    FOREIGN KEY (`idPacient`)
    REFERENCES `hospitalmanagement`.`pacienti` (`idPacient`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hospitalmanagement`.`servicii`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospitalmanagement`.`servicii` (
  `idservicii` INT NOT NULL,
  `numeServiciu` VARCHAR(45) NOT NULL,
  `pretServiciu` DOUBLE NOT NULL,
  PRIMARY KEY (`idservicii`),
  INDEX `numeServiciu` (`numeServiciu` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
