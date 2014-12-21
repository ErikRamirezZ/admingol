-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:13:49
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
-- Estructura de tabla para la tabla `status_cedula`
--

CREATE TABLE IF NOT EXISTS `status_cedula` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_status_cedula` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cfx1gg53xdl0svducv5d68pd9` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `status_cedula`
--

INSERT INTO `status_cedula` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_status_cedula`, `version`, `usuario`) VALUES
(1, 1, 'En juego', '2014-10-28 00:00:00', NULL, 'En juego', NULL, 5),
(2, 1, 'Pendiente', '2014-10-28 00:00:00', NULL, 'Pendiente', NULL, 5),
(3, 1, 'Cerrada', '2014-10-28 00:00:00', NULL, 'Cerrada', NULL, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `status_cedula`
--
ALTER TABLE `status_cedula`
  ADD CONSTRAINT `FK_cfx1gg53xdl0svducv5d68pd9` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
