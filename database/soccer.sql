-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

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
-- Table `soccer`.`championship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`championship` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `country` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `CountryToChampionship_idx` (`country` ASC) VISIBLE,
  CONSTRAINT `CountryToChampionship`
    FOREIGN KEY (`country`)
    REFERENCES `soccer`.`country` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`user` (
  `id` INT(11) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`article` (
  `id` INT(11) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `content` LONGTEXT NOT NULL,
  `image` LONGBLOB NOT NULL,
  `user` INT(11) NULL DEFAULT NULL,
  `championship` INT(11) NULL DEFAULT NULL,
  `country` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `CountryToArticle_idx` (`country` ASC) VISIBLE,
  INDEX `ChampionshipToArticle_idx` (`championship` ASC) VISIBLE,
  CONSTRAINT `ChampionshipToArticle`
    FOREIGN KEY (`championship`)
    REFERENCES `soccer`.`championship` (`id`),
  CONSTRAINT `CountryToArticle`
    FOREIGN KEY (`country`)
    REFERENCES `soccer`.`country` (`id`),
  CONSTRAINT `userToArticle`
    FOREIGN KEY (`id`)
    REFERENCES `soccer`.`user` (`id`))
ENGINE = InnoDB
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
  `id` INT(11) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `content` MEDIUMTEXT NOT NULL,
  `article` INT(11) NOT NULL,
  `user` INT(11) NOT NULL,
  `answer` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `UserToComment_idx` (`user` ASC) VISIBLE,
  INDEX `ArticleToComment_idx` (`article` ASC) VISIBLE,
  INDEX `CommentToComment_idx` (`answer` ASC) VISIBLE,
  CONSTRAINT `ArticleToComment`
    FOREIGN KEY (`article`)
    REFERENCES `soccer`.`article` (`id`),
  CONSTRAINT `CommentToComment`
    FOREIGN KEY (`answer`)
    REFERENCES `soccer`.`comment` (`id`),
  CONSTRAINT `UserToComment`
    FOREIGN KEY (`user`)
    REFERENCES `soccer`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `soccer`.`match`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `soccer`.`match` (
  `id` INT(11) NOT NULL,
  `t1_name` VARCHAR(45) NOT NULL,
  `t2_name` VARCHAR(45) NOT NULL,
  `score` VARCHAR(45) NOT NULL,
  `match_date` DATETIME NOT NULL,
  `championship` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `ChampionshipToMatch_idx` (`championship` ASC) VISIBLE,
  CONSTRAINT `ChampionshipToMatch`
    FOREIGN KEY (`championship`)
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
  INDEX `roleID_idx` (`role_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
