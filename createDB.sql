drop database caixaEletronico;
CREATE DATABASE caixaEletronico;
USE caixaEletronico;
CREATE TABLE `conta` (
  `banco` varchar(45) NOT NULL,
  `numero` int(6) NOT NULL AUTO_INCREMENT,
  `agencia` int(6) NOT NULL,
  `senha` int(4) NOT NULL,
  `codAcesso` int(4) DEFAULT NULL,
  `titular` varchar(45) NOT NULL,
  `saldo` decimal(19,2) NOT NULL,
  `bloqueio` int(1) DEFAULT '1',
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=latin1;

INSERT INTO `caixaEletronico`.`conta` (`banco`, `agencia`, `senha`, `codAcesso`, `titular`, `saldo`, `bloqueio`) VALUES ('BANCO_DO_BRASIL', '1', '101010', '123', 'Eric Vinicius', '98755.00', '0');
INSERT INTO `caixaEletronico`.`conta` (`banco`, `agencia`, `senha`, `codAcesso`, `titular`, `saldo`, `bloqueio`) VALUES ('CAIXA', '2', '123456', '456', 'Willian Pansutti', '100000.00', '0');

CREATE TABLE `movimentacao` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `fromNumero` int(6) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `valor` decimal(19,2) NOT NULL,
  `tipoMovimentacao` varchar(20) NOT NULL,
  `toNumero` int(6) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

