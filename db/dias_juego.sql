-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:10:46
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
-- Estructura de tabla para la tabla `dias_juego`
--

CREATE TABLE IF NOT EXISTS `dias_juego` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_dias_juego` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_260w19hw2krikkdayu1r2a1os` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `dias_juego`
--

INSERT INTO `dias_juego` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_dias_juego`, `version`, `usuario`) VALUES
(1, 1, 'Intersemanal', '2014-10-27 00:00:00', NULL, 'Intersemanal', NULL, 5),
(2, 1, 'Sabatino', '2014-10-27 00:00:00', NULL, 'Sabatino', NULL, 5),
(3, 1, 'Dominical', '2014-10-27 00:00:00', NULL, 'Dominical', NULL, 5),
(4, 1, 'Lunes', '2014-10-27 00:00:00', NULL, 'Lunes', NULL, 5),
(5, 1, 'Martes', '2014-10-27 00:00:00', NULL, 'Martes', NULL, 5),
(6, 1, 'Miércoles', '2014-10-27 00:00:00', NULL, 'Miércoles', NULL, 5),
(7, 1, 'Jueves', '2014-10-27 00:00:00', NULL, 'Jueves', NULL, 5),
(8, 1, 'Viernes', '2014-10-27 00:00:00', NULL, 'Viernes', NULL, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dias_juego`
--
ALTER TABLE `dias_juego`
  ADD CONSTRAINT `FK_260w19hw2krikkdayu1r2a1os` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
