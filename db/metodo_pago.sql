-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2014 a las 15:12:17
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
-- Estructura de tabla para la tabla `metodo_pago`
--

CREATE TABLE IF NOT EXISTS `metodo_pago` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_metodo_pago` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_krpobsmtbbswcc5t6q6fjlvgm` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `metodo_pago`
--

INSERT INTO `metodo_pago` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_metodo_pago`, `version`, `usuario`) VALUES
(1, 1, 'Efectivo', '2014-10-28 00:00:00', NULL, 'Efectivo', NULL, 5),
(2, 1, 'Tarjeta de Credito', '2014-10-28 00:00:00', NULL, 'Tarjeta de Credito', NULL, 5),
(3, 1, 'Tarjeta de Debito', '2014-10-28 00:00:00', NULL, 'Tarjeta de Debito', NULL, 5),
(4, 1, 'Transferencia Electrónica', '2014-10-28 00:00:00', NULL, 'Transferencia Electrónica', NULL, 5),
(5, 1, 'Deposito en efectvo', '2014-10-28 00:00:00', NULL, 'Deposito en efectvo', NULL, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD CONSTRAINT `FK_krpobsmtbbswcc5t6q6fjlvgm` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
