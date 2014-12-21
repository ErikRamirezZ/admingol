-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:14:19
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
-- Estructura de tabla para la tabla `status_equipo_jugador`
--

CREATE TABLE IF NOT EXISTS `status_equipo_jugador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_status_equipo_jugador` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fu5orbh5vmxg65ey6o3upyrl5` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `status_equipo_jugador`
--

INSERT INTO `status_equipo_jugador` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_status_equipo_jugador`, `version`, `usuario`) VALUES
(1, 1, 'Activo', '2014-10-28 00:00:00', NULL, 'Activo', NULL, 5),
(2, 1, 'Suspendido', '2014-10-28 00:00:00', NULL, 'Suspendido', NULL, 5),
(3, 1, 'Expulsado', '2014-10-28 00:00:00', NULL, 'Expulsado', NULL, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `status_equipo_jugador`
--
ALTER TABLE `status_equipo_jugador`
  ADD CONSTRAINT `FK_fu5orbh5vmxg65ey6o3upyrl5` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
