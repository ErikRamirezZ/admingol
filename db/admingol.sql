-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-11-2014 a las 06:41:04
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
-- Estructura de tabla para la tabla `abono`
--

CREATE TABLE IF NOT EXISTS `abono` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `observaciones` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `cargo` bigint(20) NOT NULL,
  `descuento` bigint(20) DEFAULT NULL,
  `metodo_pago` bigint(20) NOT NULL,
  `status` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p528k996vh6vgvl4qfqyveba9` (`cargo`),
  KEY `FK_1dp8746roql4c4da6c375csxj` (`descuento`),
  KEY `FK_7qxxp3v6t9qniltilq5mdaesr` (`metodo_pago`),
  KEY `FK_fp2dwydctk16cfwl94fa1nuk1` (`status`),
  KEY `FK_6m3g355l035gtonnv8bfyusrs` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alineacion`
--

CREATE TABLE IF NOT EXISTS `alineacion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `jugador` bigint(20) DEFAULT NULL,
  `partido` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eee20th47qry7s5a15s3vlrh4` (`jugador`),
  KEY `FK_nwpm2b5l8qp5ypux9kgury8aq` (`partido`),
  KEY `FK_o2ugfcb5xsmti3lyunis8ejuy` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancha`
--

CREATE TABLE IF NOT EXISTS `cancha` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `sucursal` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pvdb4859sird9noeftlmv142o` (`sucursal`),
  KEY `FK_ix7n0nrs7cs5m0xyg1ee55c0d` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE IF NOT EXISTS `cargo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `monto` double NOT NULL,
  `observaciones` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `abono` bigint(20) DEFAULT NULL,
  `concepto_cobro` bigint(20) NOT NULL,
  `equipo` bigint(20) NOT NULL,
  `status` bigint(20) DEFAULT NULL,
  `torneo` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5bl6uhgqyqs8p2yku4a6yq15w` (`abono`),
  KEY `FK_ktgvdujjwft5e590m8tn2nrlx` (`concepto_cobro`),
  KEY `FK_3i2xol96v1v5e08ksugnypp3o` (`equipo`),
  KEY `FK_8ak9wk9l2pkqj1ih1spucd5a9` (`status`),
  KEY `FK_ewl9h7nyyws2dwt738t1hcx6d` (`torneo`),
  KEY `FK_fw8cmmstmvkgkrd71wyuanjwl` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cedula_partido`
--

CREATE TABLE IF NOT EXISTS `cedula_partido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `marcador_equipo_local` int(11) NOT NULL,
  `marcador_equipo_visitante` int(11) NOT NULL,
  `observaciones` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `partido` bigint(20) NOT NULL,
  `status` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pmypktat61abdmp71e5p6urcg` (`partido`),
  KEY `FK_3rbhtvkb516swhi7ixoc08xmw` (`status`),
  KEY `FK_fo98ylolsvkt7odnh9rx22529` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto_cobro`
--

CREATE TABLE IF NOT EXISTS `concepto_cobro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_concepto_cobro` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b55ceut6lwddkjxa0ckoeawdt` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `concepto_cobro`
--

INSERT INTO `concepto_cobro` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_concepto_cobro`, `version`, `usuario`) VALUES
(1, 1, 'Renta de Cancha', '2014-10-27 00:00:00', NULL, 'Renta de Cancha', NULL, 5),
(2, 1, 'Partido', '2014-10-27 00:00:00', NULL, 'Partido', NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion_torneo`
--

CREATE TABLE IF NOT EXISTS `configuracion_torneo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `costo` double NOT NULL,
  `costo_incripcion` double NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `inscripcion` tinyint(1) DEFAULT NULL,
  `numero_jugadoresxequipo` int(11) NOT NULL,
  `numero_pagos` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `dias_juego` bigint(20) DEFAULT NULL,
  `tipo_cobro` bigint(20) DEFAULT NULL,
  `torneo` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_beosgoemou587j49nuu9sig91` (`dias_juego`),
  KEY `FK_93205j7axbnvoakhgx6lxyk3n` (`tipo_cobro`),
  KEY `FK_31ilnlxsdj035m28q247r34d8` (`torneo`),
  KEY `FK_fe1wrv65g3w7yipcr8mukdk4j` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_pago`
--

CREATE TABLE IF NOT EXISTS `control_pago` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_seguridad` int(11) NOT NULL,
  `cuenta` int(11) NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `no_referencia` int(11) NOT NULL,
  `notc` int(11) NOT NULL,
  `tarifa` double NOT NULL,
  `version` int(11) DEFAULT NULL,
  `empresa` bigint(20) NOT NULL,
  `fecha_vencimientotc` bigint(20) DEFAULT NULL,
  `tipo_tarjeta` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h4rdteveibxo12yb0xgqn5x8p` (`empresa`),
  KEY `FK_731f9462ktfp8ppkl8o1fjnxx` (`fecha_vencimientotc`),
  KEY `FK_41avgbc04upqwl4tahi1i4m8r` (`tipo_tarjeta`),
  KEY `FK_m5j2qlrdqiifm4xwpkn7ocnc1` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE IF NOT EXISTS `descuento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_descuento` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qx94kc7k7ww7wp5tw4vaml1nn` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `descuento`
--

INSERT INTO `descuento` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_descuento`, `version`, `usuario`) VALUES
(1, 1, '5', '2014-10-27 00:00:00', NULL, '5', NULL, 5),
(3, 1, '10', '2014-10-27 00:00:00', NULL, '10', NULL, 5),
(4, 1, '15', '2014-10-27 00:00:00', NULL, '15', NULL, 5),
(5, 1, '20', '2014-10-27 00:00:00', NULL, '20', NULL, 5),
(6, 1, '25', '2014-10-27 00:00:00', NULL, '25', NULL, 5),
(7, 1, '100', '2014-10-27 00:00:00', NULL, '100', NULL, 5);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=9 ;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `correoe` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `domicilio` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `logo` longblob,
  `nombre` varchar(255) COLLATE utf8_bin NOT NULL,
  `nombre_comercial` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_d3nm4bkmn198h94okwmqdfh6w` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id`, `activo`, `correoe`, `domicilio`, `fecha_creacion`, `fecha_modificacion`, `logo`, `nombre`, `nombre_comercial`, `telefono`, `version`, `usuario`) VALUES
(1, 1, 'erik.ramirezz@gmail.com', 'domicilio', '2014-10-25 00:00:00', NULL, NULL, 'Administrador', NULL, NULL, NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `logo` longblob,
  `nombre` varchar(255) COLLATE utf8_bin NOT NULL,
  `nombre_corto` varchar(255) COLLATE utf8_bin NOT NULL,
  `nombre_largo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `status` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cmegfslm0bwm7k3c3jdlg22dj` (`status`),
  KEY `FK_h5k0mxued15gwh46yesie169o` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadisticas`
--

CREATE TABLE IF NOT EXISTS `estadisticas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `minuto` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `accion` bigint(20) NOT NULL,
  `alineacion` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_75wqpx0x1s1mvy0nm5gsum39p` (`accion`),
  KEY `FK_o3u30793snt4qbkeca24yl9wy` (`alineacion`),
  KEY `FK_od583me65nuhfawgish3p5kid` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fecha_vencimientotc`
--

CREATE TABLE IF NOT EXISTS `fecha_vencimientotc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `anio` int(11) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `mes` int(11) NOT NULL,
  `nombre_fecha_vencimientotc` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_j5ld1e535pnlopj66wv7egav1` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `domingo` tinyint(1) DEFAULT NULL,
  `duracion` int(11) NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `hora_inicio` datetime NOT NULL,
  `jueves` tinyint(1) DEFAULT NULL,
  `lunes` tinyint(1) DEFAULT NULL,
  `martes` tinyint(1) DEFAULT NULL,
  `miercoles` tinyint(1) DEFAULT NULL,
  `sabado` tinyint(1) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `viernes` tinyint(1) DEFAULT NULL,
  `cancha` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g6m8gvwwb4o2e64suithr2y3c` (`cancha`),
  KEY `FK_iiw8pfabtoihlwuv7d0l1rtv0` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE IF NOT EXISTS `jugador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `apellido_materno` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `apellido_paterno` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `correoe` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `domicilio` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `es_delegado` tinyint(1) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `foto` longblob,
  `nombre` varchar(255) COLLATE utf8_bin NOT NULL,
  `telefono` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `equipo` bigint(20) NOT NULL,
  `posicion` bigint(20) DEFAULT NULL,
  `status` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4wyf99t7d1amq3imv5t20g74n` (`equipo`),
  KEY `FK_dqdqlhlqw3d2gianff1uo39mj` (`posicion`),
  KEY `FK_2lq5bmnqiaryvx80s9tlgqkum` (`status`),
  KEY `FK_gn1ep39qqprhl9ai5nn362qlm` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `metodo_pago`
--

INSERT INTO `metodo_pago` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_metodo_pago`, `version`, `usuario`) VALUES
(1, 1, 'Efectivo', '2014-10-28 00:00:00', NULL, 'Efectivo', NULL, 5),
(2, 1, 'Tarjeta de Credito', '2014-10-28 00:00:00', NULL, 'Tarjeta de Credito', NULL, 5),
(3, 1, 'Tarjeta de Debito', '2014-10-28 00:00:00', NULL, 'Tarjeta de Debito', NULL, 5),
(4, 1, 'Transferencia Electrónica', '2014-10-28 00:00:00', NULL, 'Transferencia Electrónica', NULL, 5),
(5, 1, 'Deposito en efectvo', '2014-10-28 00:00:00', NULL, 'Deposito en efectvo', NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_hecho`
--

CREATE TABLE IF NOT EXISTS `pago_hecho` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descuento` int(11) NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `fecha_pago` datetime DEFAULT NULL,
  `fecha_vencimiento` datetime DEFAULT NULL,
  `monto` double NOT NULL,
  `version` int(11) DEFAULT NULL,
  `control_pago` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kt8om0aviqenv6qnn8q46732u` (`control_pago`),
  KEY `FK_pbndimas8thkikxqf3b7v3c3g` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE IF NOT EXISTS `partido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_juego` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `cancha` bigint(20) NOT NULL,
  `equipo_local` bigint(20) DEFAULT NULL,
  `equipo_visitante` bigint(20) DEFAULT NULL,
  `horario` bigint(20) DEFAULT NULL,
  `status` bigint(20) NOT NULL,
  `tipo_partido` bigint(20) DEFAULT NULL,
  `torneo_equipo_local` bigint(20) DEFAULT NULL,
  `torneo_equipo_visitante` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_a9p0cmbks5c8t6x1xtcch2p3s` (`cancha`),
  KEY `FK_tr4i07rdt0yd6ruxxmcu4ade2` (`equipo_local`),
  KEY `FK_crpfjtr6ns67lbn5r465hsjiu` (`equipo_visitante`),
  KEY `FK_1mh101iqkqtr5pka5ubax966f` (`horario`),
  KEY `FK_pyei095bi7q64wymrawbuy6xl` (`status`),
  KEY `FK_c4n228fbj7xe6svgo7ho6710h` (`tipo_partido`),
  KEY `FK_pqgbcey6oume9f6fcbwonb9oc` (`torneo_equipo_local`),
  KEY `FK_fejdcqvlxs5ubsn8f8dvk3hsw` (`torneo_equipo_visitante`),
  KEY `FK_gsyo5fi9k8p9k0mimacjq0mlk` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido_arbitros`
--

CREATE TABLE IF NOT EXISTS `partido_arbitros` (
  `partido` bigint(20) NOT NULL,
  `arbitros` bigint(20) NOT NULL,
  PRIMARY KEY (`partido`,`arbitros`),
  KEY `FK_7f7x90ejy6x76u4txl654gl54` (`arbitros`),
  KEY `FK_2yedsythkhqe8kt5xxfcguddg` (`partido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `posicion`
--

CREATE TABLE IF NOT EXISTS `posicion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_posicion` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ifnrhw4gbq4urbhr2yx7nukvs` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `posicion`
--

INSERT INTO `posicion` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_posicion`, `version`, `usuario`) VALUES
(1, 1, 'Portero', '2014-10-28 00:00:00', NULL, 'Portero', NULL, 5),
(2, 1, 'Defesnsa', '2014-10-28 00:00:00', NULL, 'Defesnsa', NULL, 5),
(3, 1, 'Medio', '2014-10-28 00:00:00', NULL, 'Medio', NULL, 5),
(4, 1, 'Delantero', '2014-10-28 00:00:00', NULL, 'Delantero', NULL, 5),
(5, 1, 'Director Técnico', '2014-10-28 00:00:00', NULL, 'Director Técnico', NULL, 5);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_rol`, `version`, `usuario`) VALUES
(1, 1, 'El SUPER puede tener acceso a todo lo que esl quiera', '2014-10-25 00:00:00', NULL, 'SUPER', NULL, 5),
(2, 1, 'ADMIN, puede hacer cambios en su empresa', '2014-10-28 00:00:00', NULL, 'ADMIN', NULL, 5),
(3, 1, 'COOR, puede hacer configuración de partidos y cobros', '2014-10-28 00:00:00', NULL, 'COOR', NULL, 5),
(4, 1, 'ARBITRO, puede registrar las estadisticas de de un Partido', '2014-10-28 00:00:00', NULL, 'ARBITRO', NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `status_cargo_abono`
--

CREATE TABLE IF NOT EXISTS `status_cargo_abono` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_status_cargo_abono` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3iikm626oyls3yelgcce13um2` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `status_cargo_abono`
--

INSERT INTO `status_cargo_abono` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_status_cargo_abono`, `version`, `usuario`) VALUES
(1, 1, 'Pendiente de pago', '2014-10-28 00:00:00', NULL, 'Pendiente de pago', NULL, 5),
(2, 1, 'Pagado', '2014-10-28 00:00:00', NULL, 'Pagado', NULL, 5),
(3, 1, 'Vencido', '2014-10-28 00:00:00', NULL, 'Vencido', NULL, 5);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `status_cedula`
--

INSERT INTO `status_cedula` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_status_cedula`, `version`, `usuario`) VALUES
(1, 1, 'En juego', '2014-10-28 00:00:00', NULL, 'En juego', NULL, 5),
(2, 1, 'Pendiente', '2014-10-28 00:00:00', NULL, 'Pendiente', NULL, 5),
(3, 1, 'Cerrada', '2014-10-28 00:00:00', NULL, 'Cerrada', NULL, 5);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `status_equipo_jugador`
--

INSERT INTO `status_equipo_jugador` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_status_equipo_jugador`, `version`, `usuario`) VALUES
(1, 1, 'Activo', '2014-10-28 00:00:00', NULL, 'Activo', NULL, 5),
(2, 1, 'Suspendido', '2014-10-28 00:00:00', NULL, 'Suspendido', NULL, 5),
(3, 1, 'Expulsado', '2014-10-28 00:00:00', NULL, 'Expulsado', NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `status_partido`
--

CREATE TABLE IF NOT EXISTS `status_partido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_status_partido` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8rafl5w9orcimjjnnmse0xx0d` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `status_partido`
--

INSERT INTO `status_partido` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_status_partido`, `version`, `usuario`) VALUES
(1, 1, 'Programado', '2014-10-28 00:00:00', NULL, 'Programado', NULL, 5),
(2, 1, 'En juego', '2014-10-28 00:00:00', NULL, 'En juego', NULL, 5),
(3, 1, 'Cancelado', '2014-10-28 00:00:00', NULL, 'Cancelado', NULL, 5),
(4, 1, 'Terminado', '2014-10-28 00:00:00', NULL, 'Terminado', NULL, 5),
(5, 1, 'Suspendido', '2014-10-28 00:00:00', NULL, 'Suspendido', NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE IF NOT EXISTS `sucursal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `correoe` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `domicilio` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_bin NOT NULL,
  `telefono` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `empresa` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f4ikw5pvpryxtjqc93iftc2as` (`empresa`),
  KEY `FK_iaxgi10bwho9vqs5aq5n4n6cl` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=723 ;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`id`, `activo`, `correoe`, `domicilio`, `fecha_creacion`, `fecha_modificacion`, `nombre`, `telefono`, `version`, `empresa`, `usuario`) VALUES
(722, 1, 'admingol@admingol.com', 'dfdfsdsc', '2014-11-01 00:00:00', NULL, 'Sucursal1', '5345345', 0, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cobro`
--

CREATE TABLE IF NOT EXISTS `tipo_cobro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_tipo_cobro` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_25v936wudu2je8arjlacye01` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `tipo_partido`
--

INSERT INTO `tipo_partido` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_tipo_partido`, `version`, `usuario`) VALUES
(1, 1, 'Torneo', '2014-10-28 00:00:00', NULL, 'Torneo', NULL, 5),
(2, 1, 'Practica', '2014-10-28 00:00:00', NULL, 'Practica', NULL, 5),
(3, 1, 'Cascara', '2014-10-28 00:00:00', NULL, 'Cascara', NULL, 5),
(4, 1, 'Cascara', '2014-10-28 00:00:00', NULL, 'Cascara', NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_tarjeta`
--

CREATE TABLE IF NOT EXISTS `tipo_tarjeta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre_tipo_tarjeta` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_703so3n67tf1okkox76vwgnb7` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tipo_tarjeta`
--

INSERT INTO `tipo_tarjeta` (`id`, `activo`, `descripcion`, `fecha_creacion`, `fecha_modificacion`, `nombre_tipo_tarjeta`, `version`, `usuario`) VALUES
(1, 1, 'Master Card', '2014-10-28 00:00:00', NULL, 'Master Card', NULL, 5),
(2, 1, 'Visa', '2014-10-28 00:00:00', NULL, 'Visa', NULL, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE IF NOT EXISTS `torneo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_bin NOT NULL,
  `version` int(11) DEFAULT NULL,
  `sucursal` bigint(20) NOT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gqssq28s7aip8yvlx1ox6ehkn` (`sucursal`),
  KEY `FK_oqk5j782rltdj9vttmjm75mcr` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo_equipo`
--

CREATE TABLE IF NOT EXISTS `torneo_equipo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `equipo` bigint(20) DEFAULT NULL,
  `torneo` bigint(20) DEFAULT NULL,
  `usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eoqvenucg3nc5v6sn9i6iri9t` (`equipo`),
  KEY `FK_i3ldyn9qast570k5hwoxqsp8u` (`torneo`),
  KEY `FK_7el2cv2c1wrjkneqex016nweg` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=8 ;

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
-- Filtros para la tabla `abono`
--
ALTER TABLE `abono`
  ADD CONSTRAINT `FK_1dp8746roql4c4da6c375csxj` FOREIGN KEY (`descuento`) REFERENCES `descuento` (`id`),
  ADD CONSTRAINT `FK_6m3g355l035gtonnv8bfyusrs` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_7qxxp3v6t9qniltilq5mdaesr` FOREIGN KEY (`metodo_pago`) REFERENCES `metodo_pago` (`id`),
  ADD CONSTRAINT `FK_fp2dwydctk16cfwl94fa1nuk1` FOREIGN KEY (`status`) REFERENCES `status_cargo_abono` (`id`),
  ADD CONSTRAINT `FK_p528k996vh6vgvl4qfqyveba9` FOREIGN KEY (`cargo`) REFERENCES `cargo` (`id`);

--
-- Filtros para la tabla `accion`
--
ALTER TABLE `accion`
  ADD CONSTRAINT `FK_lravxb0w3gytcb2uc6opq8n61` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `alineacion`
--
ALTER TABLE `alineacion`
  ADD CONSTRAINT `FK_eee20th47qry7s5a15s3vlrh4` FOREIGN KEY (`jugador`) REFERENCES `jugador` (`id`),
  ADD CONSTRAINT `FK_nwpm2b5l8qp5ypux9kgury8aq` FOREIGN KEY (`partido`) REFERENCES `partido` (`id`),
  ADD CONSTRAINT `FK_o2ugfcb5xsmti3lyunis8ejuy` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `cancha`
--
ALTER TABLE `cancha`
  ADD CONSTRAINT `FK_ix7n0nrs7cs5m0xyg1ee55c0d` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_pvdb4859sird9noeftlmv142o` FOREIGN KEY (`sucursal`) REFERENCES `sucursal` (`id`);

--
-- Filtros para la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD CONSTRAINT `FK_3i2xol96v1v5e08ksugnypp3o` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`id`),
  ADD CONSTRAINT `FK_5bl6uhgqyqs8p2yku4a6yq15w` FOREIGN KEY (`abono`) REFERENCES `abono` (`id`),
  ADD CONSTRAINT `FK_8ak9wk9l2pkqj1ih1spucd5a9` FOREIGN KEY (`status`) REFERENCES `status_cargo_abono` (`id`),
  ADD CONSTRAINT `FK_ewl9h7nyyws2dwt738t1hcx6d` FOREIGN KEY (`torneo`) REFERENCES `torneo` (`id`),
  ADD CONSTRAINT `FK_fw8cmmstmvkgkrd71wyuanjwl` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_ktgvdujjwft5e590m8tn2nrlx` FOREIGN KEY (`concepto_cobro`) REFERENCES `concepto_cobro` (`id`);

--
-- Filtros para la tabla `cedula_partido`
--
ALTER TABLE `cedula_partido`
  ADD CONSTRAINT `FK_3rbhtvkb516swhi7ixoc08xmw` FOREIGN KEY (`status`) REFERENCES `status_cedula` (`id`),
  ADD CONSTRAINT `FK_fo98ylolsvkt7odnh9rx22529` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_pmypktat61abdmp71e5p6urcg` FOREIGN KEY (`partido`) REFERENCES `partido` (`id`);

--
-- Filtros para la tabla `concepto_cobro`
--
ALTER TABLE `concepto_cobro`
  ADD CONSTRAINT `FK_b55ceut6lwddkjxa0ckoeawdt` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `configuracion_torneo`
--
ALTER TABLE `configuracion_torneo`
  ADD CONSTRAINT `FK_31ilnlxsdj035m28q247r34d8` FOREIGN KEY (`torneo`) REFERENCES `torneo` (`id`),
  ADD CONSTRAINT `FK_93205j7axbnvoakhgx6lxyk3n` FOREIGN KEY (`tipo_cobro`) REFERENCES `tipo_cobro` (`id`),
  ADD CONSTRAINT `FK_beosgoemou587j49nuu9sig91` FOREIGN KEY (`dias_juego`) REFERENCES `dias_juego` (`id`),
  ADD CONSTRAINT `FK_fe1wrv65g3w7yipcr8mukdk4j` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `control_pago`
--
ALTER TABLE `control_pago`
  ADD CONSTRAINT `FK_41avgbc04upqwl4tahi1i4m8r` FOREIGN KEY (`tipo_tarjeta`) REFERENCES `tipo_tarjeta` (`id`),
  ADD CONSTRAINT `FK_731f9462ktfp8ppkl8o1fjnxx` FOREIGN KEY (`fecha_vencimientotc`) REFERENCES `fecha_vencimientotc` (`id`),
  ADD CONSTRAINT `FK_h4rdteveibxo12yb0xgqn5x8p` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`),
  ADD CONSTRAINT `FK_m5j2qlrdqiifm4xwpkn7ocnc1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD CONSTRAINT `FK_qx94kc7k7ww7wp5tw4vaml1nn` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `dias_juego`
--
ALTER TABLE `dias_juego`
  ADD CONSTRAINT `FK_260w19hw2krikkdayu1r2a1os` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `FK_d3nm4bkmn198h94okwmqdfh6w` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `FK_cmegfslm0bwm7k3c3jdlg22dj` FOREIGN KEY (`status`) REFERENCES `status_equipo_jugador` (`id`),
  ADD CONSTRAINT `FK_h5k0mxued15gwh46yesie169o` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD CONSTRAINT `FK_75wqpx0x1s1mvy0nm5gsum39p` FOREIGN KEY (`accion`) REFERENCES `accion` (`id`),
  ADD CONSTRAINT `FK_o3u30793snt4qbkeca24yl9wy` FOREIGN KEY (`alineacion`) REFERENCES `alineacion` (`id`),
  ADD CONSTRAINT `FK_od583me65nuhfawgish3p5kid` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `fecha_vencimientotc`
--
ALTER TABLE `fecha_vencimientotc`
  ADD CONSTRAINT `FK_j5ld1e535pnlopj66wv7egav1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `FK_g6m8gvwwb4o2e64suithr2y3c` FOREIGN KEY (`cancha`) REFERENCES `cancha` (`id`),
  ADD CONSTRAINT `FK_iiw8pfabtoihlwuv7d0l1rtv0` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `FK_2lq5bmnqiaryvx80s9tlgqkum` FOREIGN KEY (`status`) REFERENCES `status_equipo_jugador` (`id`),
  ADD CONSTRAINT `FK_4wyf99t7d1amq3imv5t20g74n` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`id`),
  ADD CONSTRAINT `FK_dqdqlhlqw3d2gianff1uo39mj` FOREIGN KEY (`posicion`) REFERENCES `posicion` (`id`),
  ADD CONSTRAINT `FK_gn1ep39qqprhl9ai5nn362qlm` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD CONSTRAINT `FK_krpobsmtbbswcc5t6q6fjlvgm` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `pago_hecho`
--
ALTER TABLE `pago_hecho`
  ADD CONSTRAINT `FK_kt8om0aviqenv6qnn8q46732u` FOREIGN KEY (`control_pago`) REFERENCES `control_pago` (`id`),
  ADD CONSTRAINT `FK_pbndimas8thkikxqf3b7v3c3g` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `FK_1mh101iqkqtr5pka5ubax966f` FOREIGN KEY (`horario`) REFERENCES `horario` (`id`),
  ADD CONSTRAINT `FK_a9p0cmbks5c8t6x1xtcch2p3s` FOREIGN KEY (`cancha`) REFERENCES `cancha` (`id`),
  ADD CONSTRAINT `FK_c4n228fbj7xe6svgo7ho6710h` FOREIGN KEY (`tipo_partido`) REFERENCES `tipo_partido` (`id`),
  ADD CONSTRAINT `FK_crpfjtr6ns67lbn5r465hsjiu` FOREIGN KEY (`equipo_visitante`) REFERENCES `equipo` (`id`),
  ADD CONSTRAINT `FK_fejdcqvlxs5ubsn8f8dvk3hsw` FOREIGN KEY (`torneo_equipo_visitante`) REFERENCES `torneo` (`id`),
  ADD CONSTRAINT `FK_gsyo5fi9k8p9k0mimacjq0mlk` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_pqgbcey6oume9f6fcbwonb9oc` FOREIGN KEY (`torneo_equipo_local`) REFERENCES `torneo` (`id`),
  ADD CONSTRAINT `FK_pyei095bi7q64wymrawbuy6xl` FOREIGN KEY (`status`) REFERENCES `status_partido` (`id`),
  ADD CONSTRAINT `FK_tr4i07rdt0yd6ruxxmcu4ade2` FOREIGN KEY (`equipo_local`) REFERENCES `equipo` (`id`);

--
-- Filtros para la tabla `partido_arbitros`
--
ALTER TABLE `partido_arbitros`
  ADD CONSTRAINT `FK_2yedsythkhqe8kt5xxfcguddg` FOREIGN KEY (`partido`) REFERENCES `partido` (`id`),
  ADD CONSTRAINT `FK_7f7x90ejy6x76u4txl654gl54` FOREIGN KEY (`arbitros`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `posicion`
--
ALTER TABLE `posicion`
  ADD CONSTRAINT `FK_ifnrhw4gbq4urbhr2yx7nukvs` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `FK_mxw8nxcik5qm7ca04u2nhf2iv` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `status_cargo_abono`
--
ALTER TABLE `status_cargo_abono`
  ADD CONSTRAINT `FK_3iikm626oyls3yelgcce13um2` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `status_cedula`
--
ALTER TABLE `status_cedula`
  ADD CONSTRAINT `FK_cfx1gg53xdl0svducv5d68pd9` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `status_equipo_jugador`
--
ALTER TABLE `status_equipo_jugador`
  ADD CONSTRAINT `FK_fu5orbh5vmxg65ey6o3upyrl5` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `status_partido`
--
ALTER TABLE `status_partido`
  ADD CONSTRAINT `FK_8rafl5w9orcimjjnnmse0xx0d` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `FK_f4ikw5pvpryxtjqc93iftc2as` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`),
  ADD CONSTRAINT `FK_iaxgi10bwho9vqs5aq5n4n6cl` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `tipo_cobro`
--
ALTER TABLE `tipo_cobro`
  ADD CONSTRAINT `FK_25v936wudu2je8arjlacye01` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `tipo_partido`
--
ALTER TABLE `tipo_partido`
  ADD CONSTRAINT `FK_724yxb3i5idr60oj5k9rb4e4k` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `tipo_tarjeta`
--
ALTER TABLE `tipo_tarjeta`
  ADD CONSTRAINT `FK_703so3n67tf1okkox76vwgnb7` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `torneo`
--
ALTER TABLE `torneo`
  ADD CONSTRAINT `FK_gqssq28s7aip8yvlx1ox6ehkn` FOREIGN KEY (`sucursal`) REFERENCES `sucursal` (`id`),
  ADD CONSTRAINT `FK_oqk5j782rltdj9vttmjm75mcr` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `torneo_equipo`
--
ALTER TABLE `torneo_equipo`
  ADD CONSTRAINT `FK_7el2cv2c1wrjkneqex016nweg` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_eoqvenucg3nc5v6sn9i6iri9t` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`id`),
  ADD CONSTRAINT `FK_i3ldyn9qast570k5hwoxqsp8u` FOREIGN KEY (`torneo`) REFERENCES `torneo` (`id`);

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
