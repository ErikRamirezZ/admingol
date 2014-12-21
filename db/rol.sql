-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:13:13
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
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_rol` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mxw8nxcik5qm7ca04u2nhf2iv` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_rol`, `version`, `usuario`) VALUES
(1, 1, 'El SUPER puede tener acceso a todo lo que esl quiera', '2014-10-25 00:00:00', NULL, 'SUPER', NULL, 5),
(2, 1, 'ADMIN, puede hacer cambios en su empresa', '2014-10-28 00:00:00', NULL, 'ADMIN', NULL, 5),
(3, 1, 'COOR, puede hacer configuración de partidos y cobros', '2014-10-28 00:00:00', NULL, 'COOR', NULL, 5),
(4, 1, 'ARBITRO, puede registrar las estadisticas de de un Partido', '2014-10-28 00:00:00', NULL, 'ARBITRO', NULL, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `FK_mxw8nxcik5qm7ca04u2nhf2iv` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
