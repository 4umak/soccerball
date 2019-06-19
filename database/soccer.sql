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
  `country_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `CountryToChampionship_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `CountryToChampionship`
    FOREIGN KEY (`country_id`)
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
  `password` VARCHAR(300) NOT NULL,
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
  `image_link` VARCHAR(150) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `championship_id` INT(11) NULL DEFAULT NULL,
  `country_id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`),
  INDEX `CountryToArticle_idx` (`country_id` ASC) VISIBLE,
  INDEX `ChampionshipToArticle_idx` (`championship_id` ASC) VISIBLE,
  INDEX `UserToArticle_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `ChampionshipToArticle`
    FOREIGN KEY (`championship_id`)
    REFERENCES `soccer`.`championship` (`id`),
  CONSTRAINT `CountryToArticle`
    FOREIGN KEY (`country_id`)
    REFERENCES `soccer`.`country` (`id`),
  CONSTRAINT `UserToArticle`
    FOREIGN KEY (`user_id`)
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
  `article_id` INT(11) NOT NULL,
  `client_id` INT(11) NOT NULL,
  `answer_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `UserToComment_idx` (`client_id` ASC) VISIBLE,
  INDEX `ArticleToComment_idx` (`article_id` ASC) VISIBLE,
  INDEX `CommentToComment_idx` (`answer_id` ASC) VISIBLE,
  CONSTRAINT `ArticleToComment`
    FOREIGN KEY (`article_id`)
    REFERENCES `soccer`.`article` (`id`),
  CONSTRAINT `CommentToComment`
    FOREIGN KEY (`answer_id`)
    REFERENCES `soccer`.`comment` (`id`),
  CONSTRAINT `UserToComment`
    FOREIGN KEY (`client_id`)
    REFERENCES `soccer`.`user` (`id`))
ENGINE = InnoDB
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
  INDEX `ChampionshipToMatch_idx` (`championship_id` ASC) VISIBLE,
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
  INDEX `roleID_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `AuthorityToRole`
    FOREIGN KEY (`role_id`)
    REFERENCES `soccer`.`authorities` (`id`),
  CONSTRAINT `UserToRole`
    FOREIGN KEY (`user_id`)
    REFERENCES `soccer`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
