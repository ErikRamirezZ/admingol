-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:09:05
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
-- Estructura de tabla para la tabla `accion`
--

CREATE TABLE IF NOT EXISTS `accion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_accion` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lravxb0w3gytcb2uc6opq8n61` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `accion`
--

INSERT INTO `accion` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_accion`, `version`, `usuario`) VALUES
(1, 1, 'Gol', '2014-10-27 00:00:00', NULL, 'Gol', NULL, 5),
(2, 1, 'Falta', '2014-10-27 00:00:00', NULL, 'Falta', NULL, 5),
(3, 1, 'Tiro Esquina', '2014-10-27 00:00:00', NULL, 'Tiro Esquina', NULL, 5),
(4, 1, 'Saque Lateral', '2014-10-27 00:00:00', NULL, 'Saque Lateral', NULL, 5),
(5, 1, 'Fuera de lugar', '2014-10-27 00:00:00', NULL, 'Fuera de lugar', NULL, 5),
(6, 1, 'Autogol', '2014-10-27 00:00:00', NULL, 'Autogol', NULL, 5),
(7, 1, 'Tarjeta Amarilla', '2014-10-27 00:00:00', NULL, 'Tarjeta Amarilla', NULL, 5),
(8, 1, 'Tarjeta Roja', '2014-10-27 00:00:00', NULL, 'Tarjeta Roja', NULL, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `accion`
--
ALTER TABLE `accion`
  ADD CONSTRAINT `FK_lravxb0w3gytcb2uc6opq8n61` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
