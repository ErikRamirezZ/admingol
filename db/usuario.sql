-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:15:14
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `admingol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `apellido_materno` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `apellido_paterno` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `celular` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `domicilio` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_bin NOT NULL,
  `numero_intentos` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `empresa` bigint(20) NOT NULL,
  `rol` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_evxoobcvsdfsx6p0d7qa2khrr` (`empresa`),
  KEY `FK_aevanv0397v7gs2a47sb43sxs` (`rol`),
  KEY `FK_i02kr8ui5pqddyd7pkm3v4jbt` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `activo`, `apellido_materno`, `apellido_paterno`, `celular`, `domicilio`, `fecha_creacion`, `fecha_modificacion`, `fecha_nacimiento`, `nombre`, `numero_intentos`, `password`, `telefono`, `username`, `version`, `empresa`, `rol`, `usuario`) VALUES
(5, 1, 'Zúñiga', 'Ramírez', '5540067589', NULL, '2014-10-25 00:00:00', NULL, '1984-03-30 00:00:00', 'Erik', 0, 'admin', NULL, 'erik.ramirezz@gmail.com', NULL, 1, 1, NULL),
(7, 1, NULL, NULL, NULL, NULL, '2014-10-29 00:00:00', NULL, NULL, 'admin', 0, 'admin', '0', 'admin@admingol.com', NULL, 1, 2, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_aevanv0397v7gs2a47sb43sxs` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`),
  ADD CONSTRAINT `FK_evxoobcvsdfsx6p0d7qa2khrr` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`),
  ADD CONSTRAINT `FK_i02kr8ui5pqddyd7pkm3v4jbt` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
