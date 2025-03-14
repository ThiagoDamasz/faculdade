-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`correio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`correio` (
  `ID` INT NOT NULL,
  `prazo_entrega` VARCHAR(45) NOT NULL,
  `frete` FLOAT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)



-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cep` INT NOT NULL,
  `e-mail` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)



-- -----------------------------------------------------
-- Table `mydb`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`compra` (
  `valor_total` FLOAT NOT NULL,
  `tipo_de_pagamento` VARCHAR(45) NOT NULL,
  `codigo_rastreamento` VARCHAR(45) NOT NULL,
  `correio_ID` INT NOT NULL,
  `Cliente_cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`codigo_rastreamento`, `correio_ID`),
  INDEX `fk_compra_correio1_idx` (`correio_ID` ASC) VISIBLE,
  INDEX `fk_compra_Cliente1_idx` (`Cliente_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_compra_correio1`
    FOREIGN KEY (`correio_ID`)
    REFERENCES `mydb`.`correio` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_Cliente1`
    FOREIGN KEY (`Cliente_cpf`)
    REFERENCES `mydb`.`Cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `preco` FLOAT NOT NULL,
  `quantidade_disponivel` INT NOT NULL,
  `compra_codigo_rastreamento` VARCHAR(45) NOT NULL,
  `compra_correio_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `compra_codigo_rastreamento`, `compra_correio_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_produto_compra1_idx` (`compra_codigo_rastreamento` ASC, `compra_correio_ID` ASC) VISIBLE,
  CONSTRAINT `fk_produto_compra1`
    FOREIGN KEY (`compra_codigo_rastreamento` , `compra_correio_ID`)
    REFERENCES `mydb`.`compra` (`codigo_rastreamento` , `correio_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`loja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`loja` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `e-mail` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)



-- -----------------------------------------------------
-- Table `mydb`.`produto_has_loja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto_has_loja` (
  `produto_ID` INT NOT NULL,
  `loja_ID` INT NOT NULL,
  PRIMARY KEY (`produto_ID`, `loja_ID`),
  INDEX `fk_produto_has_loja_loja1_idx` (`loja_ID` ASC) VISIBLE,
  INDEX `fk_produto_has_loja_produto_idx` (`produto_ID` ASC) VISIBLE,
  CONSTRAINT `fk_produto_has_loja_produto`
    FOREIGN KEY (`produto_ID`)
    REFERENCES `mydb`.`produto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_loja_loja1`
    FOREIGN KEY (`loja_ID`)
    REFERENCES `mydb`.`loja` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`produto_has_loja1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto_has_loja1` (
  `produto_ID` INT NOT NULL,
  `loja_ID` INT NOT NULL,
  PRIMARY KEY (`produto_ID`, `loja_ID`),
  INDEX `fk_produto_has_loja1_loja1_idx` (`loja_ID` ASC) VISIBLE,
  INDEX `fk_produto_has_loja1_produto1_idx` (`produto_ID` ASC) VISIBLE,
  CONSTRAINT `fk_produto_has_loja1_produto1`
    FOREIGN KEY (`produto_ID`)
    REFERENCES `mydb`.`produto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_loja1_loja1`
    FOREIGN KEY (`loja_ID`)
    REFERENCES `mydb`.`loja` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`Avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Avaliacao` (
  `produto_ID` INT NOT NULL,
  `Cliente_cpf` VARCHAR(11) NOT NULL,
  `nota` INT NOT NULL,
  `texto` VARCHAR(45) NULL,
  PRIMARY KEY (`produto_ID`, `Cliente_cpf`),
  INDEX `fk_produto_has_Cliente_Cliente1_idx` (`Cliente_cpf` ASC) VISIBLE,
  INDEX `fk_produto_has_Cliente_produto1_idx` (`produto_ID` ASC) VISIBLE,
  CONSTRAINT `fk_produto_has_Cliente_produto1`
    FOREIGN KEY (`produto_ID`)
    REFERENCES `mydb`.`produto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_Cliente_Cliente1`
    FOREIGN KEY (`Cliente_cpf`)
    REFERENCES `mydb`.`Cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`avaliacao` (
  `nota` INT NULL,
  `texto` VARCHAR(45) NULL)



-- -----------------------------------------------------
-- Table `mydb`.`produto_has_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto_has_produto` (
  `produto_ID` INT NOT NULL,
  `produto_ID1` INT NOT NULL,
  PRIMARY KEY (`produto_ID`, `produto_ID1`),
  INDEX `fk_produto_has_produto_produto2_idx` (`produto_ID1` ASC) VISIBLE,
  INDEX `fk_produto_has_produto_produto1_idx` (`produto_ID` ASC) VISIBLE,
  CONSTRAINT `fk_produto_has_produto_produto1`
    FOREIGN KEY (`produto_ID`)
    REFERENCES `mydb`.`produto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_produto_produto2`
    FOREIGN KEY (`produto_ID1`)
    REFERENCES `mydb`.`produto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`produto_has_produto_has_Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto_has_produto_has_Cliente` (
  `produto_ID` INT NOT NULL,
  `produto_has_Cliente_produto_ID` INT NOT NULL,
  `produto_has_Cliente_Cliente_cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`produto_ID`, `produto_has_Cliente_produto_ID`, `produto_has_Cliente_Cliente_cpf`),
  INDEX `fk_produto_has_produto_has_Cliente_produto_has_Cliente1_idx` (`produto_has_Cliente_produto_ID` ASC, `produto_has_Cliente_Cliente_cpf` ASC) VISIBLE,
  INDEX `fk_produto_has_produto_has_Cliente_produto1_idx` (`produto_ID` ASC) VISIBLE,
  CONSTRAINT `fk_produto_has_produto_has_Cliente_produto1`
    FOREIGN KEY (`produto_ID`)
    REFERENCES `mydb`.`produto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_produto_has_Cliente_produto_has_Cliente1`
    FOREIGN KEY (`produto_has_Cliente_produto_ID` , `produto_has_Cliente_Cliente_cpf`)
    REFERENCES `mydb`.`Avaliacao` (`produto_ID` , `Cliente_cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)




