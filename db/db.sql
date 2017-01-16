-- MySQL Script generated by MySQL Workbench
-- 01/10/17 15:20:30
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema voteSystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema voteSystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `voteSystem` DEFAULT CHARACTER SET utf8 ;
USE `voteSystem` ;

-- -----------------------------------------------------
-- Table `voteSystem`.`constituency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `voteSystem`.`constituency` (
  `constituency_id` INT NOT NULL,
  `constituency_title` VARCHAR(45) NULL,
  PRIMARY KEY (`constituency_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `voteSystem`.`Districts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `voteSystem`.`Districts` (
  `district_id` INT NOT NULL,
  `district_title` VARCHAR(45) NULL,
  `number_of_voters` VARCHAR(45) NULL,
  `constituency_id` INT NOT NULL,
  PRIMARY KEY (`district_id`, `constituency_id`),
  INDEX `fk_Districts_constituency_idx` (`constituency_id` ASC),
  CONSTRAINT `fk_Districts_constituency`
    FOREIGN KEY (`constituency_id`)
    REFERENCES `voteSystem`.`constituency` (`constituency_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `voteSystem`.`Parties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `voteSystem`.`Parties` (
  `party_id` INT NOT NULL,
  `party_title` VARCHAR(45) NULL,
  PRIMARY KEY (`party_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `voteSystem`.`candidates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `voteSystem`.`candidates` (
  `candidate_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `second_name` VARCHAR(45) NULL,
  `list_id` INT NULL,
  `constituency_id` INT NOT NULL,
  `party_id` INT NOT NULL,
  PRIMARY KEY (`candidate_id`, `constituency_id`, `party_id`),
  INDEX `fk_candidates_constituency1_idx` (`constituency_id` ASC),
  INDEX `fk_candidates_Parties1_idx` (`party_id` ASC),
  CONSTRAINT `fk_candidates_constituency1`
    FOREIGN KEY (`constituency_id`)
    REFERENCES `voteSystem`.`constituency` (`constituency_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidates_Parties1`
    FOREIGN KEY (`party_id`)
    REFERENCES `voteSystem`.`Parties` (`party_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `voteSystem`.`multi_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `voteSystem`.`multi_member` (
  `votes` INT NULL,
  `district_id` INT NOT NULL,
  `party_id` INT NOT NULL,
  PRIMARY KEY (`district_id`, `party_id`),
  INDEX `fk_multi_member_Parties1_idx` (`party_id` ASC),
  CONSTRAINT `fk_multi_member_Districts1`
    FOREIGN KEY (`district_id`)
    REFERENCES `voteSystem`.`Districts` (`district_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_multi_member_Parties1`
    FOREIGN KEY (`party_id`)
    REFERENCES `voteSystem`.`Parties` (`party_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `voteSystem`.`single_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `voteSystem`.`single_member` (
  `votes` VARCHAR(45) NULL,
  `district_id` INT NOT NULL,
  `candidate_id` INT NOT NULL,
  PRIMARY KEY (`district_id`, `candidate_id`),
  INDEX `fk_single_member_Districts1_idx` (`district_id` ASC),
  INDEX `fk_single_member_candidates1_idx` (`candidate_id` ASC),
  CONSTRAINT `fk_single_member_Districts1`
    FOREIGN KEY (`district_id`)
    REFERENCES `voteSystem`.`Districts` (`district_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_single_member_candidates1`
    FOREIGN KEY (`candidate_id`)
    REFERENCES `voteSystem`.`candidates` (`candidate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;