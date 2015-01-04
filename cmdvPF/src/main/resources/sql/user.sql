-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-12-2014 a las 16:55:22
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de datos: `cmdvpf`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) NOT NULL,
  `ROLE` enum('ADMIN','USER') NOT NULL,
  `PRIMER_APELLIDO` varchar(255) DEFAULT NULL,
  `SEGUNDO_APELLIDO` varchar(255) DEFAULT NULL,
  `LOGIN` int(50) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `INACTIVO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`ID`, `NOMBRE`, `ROLE`, `PRIMER_APELLIDO`, `SEGUNDO_APELLIDO`, `LOGIN`, `PASSWORD`, `INACTIVO`) VALUES
(1, 'Chris', '', NULL, '', 0, '', 0);
