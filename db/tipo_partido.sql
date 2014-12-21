-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:14:42
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
-- Estructura de tabla para la tabla `tipo_partido`
--

CREATE TABLE IF NOT EXISTS `tipo_partido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_tipo_partido` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_724yxb3i5idr60oj5k9rb4e4k` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `tipo_partido`
--

INSERT INTO `tipo_partido` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_tipo_partido`, `version`, `usuario`) VALUES
(1, 1, 'Torneo', '2014-10-28 00:00:00', NULL, 'Torneo', NULL, 5),
(2, 1, 'Practica', '2014-10-28 00:00:00', NULL, 'Practica', NULL, 5),
(3, 1, 'Cascara', '2014-10-28 00:00:00', NULL, 'Cascara', NULL, 5),
(4, 1, 'Cascara', '2014-10-28 00:00:00', NULL, 'Cascara', NULL, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tipo_partido`
--
ALTER TABLE `tipo_partido`
  ADD CONSTRAINT `FK_724yxb3i5idr60oj5k9rb4e4k` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
