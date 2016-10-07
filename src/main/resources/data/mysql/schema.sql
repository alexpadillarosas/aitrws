/*
 * MySQL script.
 * Create the database schema for the application.
 */
DROP TABLE IF EXISTS `Work` ;
DROP TABLE IF EXISTS `Schedule` ;
DROP TABLE IF EXISTS `User` ;
DROP TABLE IF EXISTS `Client` ;


-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `User` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Client` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `phone1` VARCHAR(45) NULL,
  `phone2` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Schedule` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `clientId` INT UNSIGNED NOT NULL,
  `userId` INT UNSIGNED NOT NULL,
  `address` VARCHAR(80) NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Schedule_Client_idx` (`clientId` ASC),
  INDEX `fk_Schedule_User1_idx` (`userId` ASC),
  CONSTRAINT `fk_Schedule_Client`
    FOREIGN KEY (`clientId`)
    REFERENCES `Client` (`id`),
  CONSTRAINT `fk_Schedule_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `User` (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Work`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Work` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `scheduleId` INT UNSIGNED NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `notes` VARCHAR(100) NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_work_Schedule1_idx` (`scheduleId` ASC),
  CONSTRAINT `fk_work_Schedule1`
    FOREIGN KEY (`scheduleId`)
    REFERENCES `Schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

