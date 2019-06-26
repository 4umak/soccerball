-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema soccer
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema soccer
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `soccer` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `soccer` ;

-- -----------------------------------------------------
-- Table `soccer`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`country` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`championship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`championship` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `CountryToChampionship_idx` (`country_id` ASC),
  CONSTRAINT `CountryToChampionship`
  FOREIGN KEY (`country_id`)
  REFERENCES `soccer`.`country` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`article` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `create_date` DATE NULL DEFAULT NULL,
  `content` LONGTEXT NOT NULL,
  `image_link` VARCHAR(150) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `championship_id` INT(11) NULL DEFAULT NULL,
  `country_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKa80w8gw66jb4d5hxhbrlbjcwg` (`country_id` ASC),
  INDEX `FKfl20oix4tcj01tvpydr40uww` (`championship_id` ASC),
  INDEX `FKbc2qerk3l47javnl2yvn51uoi` (`user_id` ASC),
  CONSTRAINT `FKa80w8gw66jb4d5hxhbrlbjcwg`
  FOREIGN KEY (`country_id`)
  REFERENCES `soccer`.`country` (`id`)
    ON UPDATE CASCADE,
  CONSTRAINT `FKbc2qerk3l47javnl2yvn51uoi`
  FOREIGN KEY (`user_id`)
  REFERENCES `soccer`.`user` (`id`),
  CONSTRAINT `FKfl20oix4tcj01tvpydr40uww`
  FOREIGN KEY (`championship_id`)
  REFERENCES `soccer`.`championship` (`id`)
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`authorities` (
  `id` INT(11) NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` MEDIUMTEXT NOT NULL,
  `article_id` INT(11) NULL DEFAULT NULL,
  `client_id` INT(11) NOT NULL,
  `answer_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKh4c82iael0pn65rhfrmubm1mi` (`client_id` ASC),
  INDEX `FK5yx0uphgjc6ik6hb82kkw501y` (`article_id` ASC),
  INDEX `FKk2u1rd366m8wvf2c2wu1wc6ir` (`answer_id` ASC),
  CONSTRAINT `FK5yx0uphgjc6ik6hb82kkw501y`
  FOREIGN KEY (`article_id`)
  REFERENCES `soccer`.`article` (`id`),
  CONSTRAINT `FKh4c82iael0pn65rhfrmubm1mi`
  FOREIGN KEY (`client_id`)
  REFERENCES `soccer`.`user` (`id`),
  CONSTRAINT `FKk2u1rd366m8wvf2c2wu1wc6ir`
  FOREIGN KEY (`answer_id`)
  REFERENCES `soccer`.`comment` (`id`))
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`match_story`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`match_story` (
  `id` INT(11) NOT NULL,
  `t1_name` VARCHAR(45) NOT NULL,
  `t2_name` VARCHAR(45) NOT NULL,
  `score` VARCHAR(45) NOT NULL,
  `match_date` DATETIME NOT NULL,
  `championship_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `ChampionshipToMatch_idx` (`championship_id` ASC),
  CONSTRAINT `ChampionshipToMatch`
  FOREIGN KEY (`championship_id`)
  REFERENCES `soccer`.`championship` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`role` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `roleID_idx` (`role_id` ASC),
  CONSTRAINT `AuthorityToRole`
  FOREIGN KEY (`role_id`)
  REFERENCES `soccer`.`authorities` (`id`)
    ON UPDATE CASCADE,
  CONSTRAINT `FK61g3ambult7v7nh59xirgd9nf`
  FOREIGN KEY (`user_id`)
  REFERENCES `soccer`.`user` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
