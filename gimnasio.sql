-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2024 a las 23:27:39
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gimnasio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `idCuota` int(11) DEFAULT NULL,
  `idReserva` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombre`, `apellido`, `nif`, `estado`, `mail`, `pass`, `idCuota`, `idReserva`) VALUES
(1, 'Paquito', 'Fara', '42999999', 1, 'paquito@hotmail.com', '123456', NULL, NULL),
(2, 'Tito', 'Fara', '49999999', 1, 'tito@hotmail.com', '123457', NULL, NULL),
(3, 'Suru', 'Fara', '40999999', 1, 'suru@hotmail.com', '123458', NULL, NULL),
(4, 'Francisco', 'Arnal', '73103300g', 1, 'frankamente@gmail.com', '123456', NULL, NULL),
(5, 'sabi', 'ferreras', '098765', 1, 'el_sabi@hotmail.com', '123456', NULL, NULL),
(6, 'Elena', 'Arnal', '49494949', 1, 'elena@hotmail.com', '123456', NULL, NULL),
(7, 'Jean Pierre', 'Flores', '3453', 1, 'jeanpi@hotmail.com', '123456', NULL, NULL),
(8, 'Benji', 'Calatrava', '1234567g', 1, 'elbeji@hotmail.com', '123456', NULL, NULL),
(10, 'Carlos', 'Ferrer', '123456p', 1, 'carlosf@hotmail.com', '123456', NULL, NULL),
(11, 'Jose Vir', 'Arnal', '098098o', 1, 'josevir@hotmail.com', '123456', NULL, NULL),
(12, 'Alfredo', 'Fara', '111111', 1, 'alfre@hotmail.com', '0987', NULL, NULL),
(13, 'Ares', 'del Olimpo', '0000001a', 1, 'areslokito@hotmail.com', '123456', NULL, NULL),
(14, 'Ludmi', 'Benitez', '090909', 1, 'ludbe@hotmail.com', '123456', NULL, NULL),
(16, 'caro', 'Fara', '345353', 1, 'carofara@hotmail.com', '123456', NULL, NULL),
(17, 'mina', 'Sante', '101010O', 1, 'fara@gmail.com', '0987', NULL, NULL),
(18, 'usuario', 'de prueba', '904567', 1, 'deprueba@gmail.com', '090909', NULL, NULL),
(20, 'Tina', 'de San Martin', '998877t', 1, 'tinasanmar@hotmail.com', '123456', NULL, NULL),
(22, 'Paquencio', 'Parales', '2345p', 1, 'paquencio1', '123456', NULL, NULL),
(23, 'Feli', 'Gutierrez', '45646q', 1, 'feligut@hotmail.com', '123456', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuota`
--

CREATE TABLE `cuota` (
  `idICuota` int(11) NOT NULL,
  `idSuscripcion` varchar(10) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fechaVencimiento` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `idHorario` varchar(9) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`idHorario`, `fecha_hora`, `cantidad`, `estado`) VALUES
('MAY13-08', '2024-05-13 08:00:00', 8, 1),
('MAY13-09', '2024-05-13 09:00:00', 8, 1),
('MAY13-10', '2024-05-13 10:00:00', 8, 1),
('MAY13-11', '2024-05-13 10:00:00', 8, 1),
('MAY13-12', '2024-05-13 12:00:00', 8, 1),
('MAY13-13', '2024-05-13 13:00:00', 8, 1),
('MAY13-16', '2024-05-13 16:00:00', 8, 1),
('MAY13-17', '2024-05-13 17:00:00', 8, 1),
('MAY13-18', '2024-05-13 18:00:00', 8, 1),
('MAY13-19', '2024-05-13 19:00:00', 8, 1),
('MAY13-20', '2024-05-13 20:00:00', 8, 1),
('MAY13-21', '2024-05-13 21:00:00', 8, 1),
('MAY14-08', '2024-05-14 08:00:00', 8, 1),
('MAY14-09', '2024-05-14 09:00:00', 8, 1),
('MAY14-10', '2024-05-14 10:00:00', 8, 1),
('MAY14-11', '2024-05-14 10:00:00', 8, 1),
('MAY14-12', '2024-05-14 12:00:00', 8, 1),
('MAY14-13', '2024-05-14 13:00:00', 8, 1),
('MAY14-16', '2024-05-14 16:00:00', 8, 1),
('MAY14-17', '2024-05-14 17:00:00', 8, 1),
('MAY14-18', '2024-05-14 18:00:00', 8, 1),
('MAY14-19', '2024-05-14 19:00:00', 8, 1),
('MAY14-20', '2024-05-14 20:00:00', 8, 1),
('MAY14-21', '2024-05-14 21:00:00', 8, 1),
('MAY15-08', '2024-05-15 08:00:00', 8, 1),
('MAY15-09', '2024-05-15 09:00:00', 8, 1),
('MAY15-10', '2024-05-15 10:00:00', 8, 1),
('MAY15-11', '2024-05-15 10:00:00', 8, 1),
('MAY15-12', '2024-05-15 12:00:00', 8, 1),
('MAY15-13', '2024-05-15 13:00:00', 8, 1),
('MAY15-16', '2024-05-15 16:00:00', 8, 1),
('MAY15-17', '2024-05-15 17:00:00', 8, 1),
('MAY15-18', '2024-05-15 18:00:00', 8, 1),
('MAY15-19', '2024-05-15 19:00:00', 8, 1),
('MAY15-20', '2024-05-15 20:00:00', 8, 1),
('MAY15-21', '2024-05-15 21:00:00', 8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE `plan` (
  `idSuscripcion` varchar(10) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `importe` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plan`
--

INSERT INTO `plan` (`idSuscripcion`, `descripcion`, `importe`, `estado`) VALUES
('12M', '1 año 300 euros', 300, 1),
('1MesEstand', 'Promo mensual', 30, 1),
('3M', 'Tres meses seguido a 80', 80, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idHorario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD UNIQUE KEY `mail_UNIQUE` (`mail`),
  ADD UNIQUE KEY `nif_UNIQUE` (`nif`),
  ADD UNIQUE KEY `idcliente_UNIQUE` (`idcliente`),
  ADD UNIQUE KEY `nif` (`nif`,`mail`),
  ADD UNIQUE KEY `idCuota` (`idCuota`,`idReserva`),
  ADD KEY `idReserva` (`idReserva`);

--
-- Indices de la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD PRIMARY KEY (`idICuota`),
  ADD KEY `idInscrp_idx` (`idSuscripcion`),
  ADD KEY `idclien_idx` (`idCliente`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`idHorario`);

--
-- Indices de la tabla `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`idSuscripcion`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `fk_reserva_2_idx` (`idHorario`),
  ADD KEY `fk_reserva_1_idx` (`idCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `cuota`
--
ALTER TABLE `cuota`
  MODIFY `idICuota` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`idCuota`) REFERENCES `cuota` (`idICuota`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD CONSTRAINT `idSuscr` FOREIGN KEY (`idSuscripcion`) REFERENCES `plan` (`idSuscripcion`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `cliente_horario` FOREIGN KEY (`idHorario`) REFERENCES `horario` (`idHorario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
