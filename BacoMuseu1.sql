-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `museuatomovel`
--
CREATE DATABASE `museuatomovel` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `museuatomovel`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

CREATE TABLE IF NOT EXISTS `evento` (
  `idEvento` int(11) NOT NULL,
  `Descricao` varchar(200) NOT NULL,
  `Texto1` varchar(500) NOT NULL,
  `Texto2` varchar(500) NOT NULL,
  `DataInicio` date NOT NULL,
  `DataFinal` date NOT NULL,
  `MaxEntradasDia` int(11) NOT NULL,
  PRIMARY KEY (`idEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `expediente`
--

CREATE TABLE IF NOT EXISTS `expediente` (
  `idExpediente` int(11) NOT NULL,
  `Data` int(11) NOT NULL,
  `idEvento` int(11) NOT NULL,
  `Meia` int(11) NOT NULL,
  `Inteira` int(11) NOT NULL,
  PRIMARY KEY (`idExpediente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `exposicao`
--

CREATE TABLE IF NOT EXISTS `exposicao` (
  `idEvento` int(11) NOT NULL,
  `idObra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcao`
--

CREATE TABLE IF NOT EXISTS `funcao` (
  `idFuncao` int(11) NOT NULL,
  `Descricao` varchar(100) NOT NULL,
  `Privilegio` int(11) NOT NULL,
  PRIMARY KEY (`idFuncao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `idFuncionario` int(11) NOT NULL,
  `idFuncao` int(11) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `Nome` varchar(150) NOT NULL,
  `Telefone` varchar(11) NOT NULL,
  `Endereco` varchar(100) NOT NULL,
  `Email` varchar(150) NOT NULL,
  PRIMARY KEY (`idFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `idFuncionario` int(11) NOT NULL,
  `Login` int(11) NOT NULL,
  `Senha` int(11) NOT NULL,
  `Ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `obra`
--

CREATE TABLE IF NOT EXISTS `obra` (
  `idObra` int(11) NOT NULL,
  `Descriçao` varchar(100) NOT NULL,
  `idTipo` int(11) NOT NULL,
  `Texto1` varchar(500) NOT NULL,
  `Texto2` varchar(500) NOT NULL,
  `Proprietrio` varchar(150) NOT NULL,
  PRIMARY KEY (`idObra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
