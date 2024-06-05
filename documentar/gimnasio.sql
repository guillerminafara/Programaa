-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2024 a las 23:55:32
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

CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `mail_UNIQUE` (`mail`),
  UNIQUE KEY `nif_UNIQUE` (`nif`),
  UNIQUE KEY `idcliente_UNIQUE` (`idcliente`),
  UNIQUE KEY `nif` (`nif`,`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombre`, `apellido`, `nif`, `estado`, `mail`, `pass`) VALUES
(1, 'Paquito', 'Fara', '42999999', 1, 'paquito@hotmail.com', '123456'),
(2, 'Tito', 'Fara', '49999999', 1, 'tito@hotmail.com', '123457'),
(3, 'Surubi', 'Fara', '40999999', 1, 'suru@hotmail.com', '123458'),
(4, 'Francisco', 'Arnal', '73103300g', 1, 'frankamente@gmail.com', '123456'),
(5, 'sabi', 'ferreras', '098765', 1, 'el_sabi@hotmail.com', '123456'),
(6, 'Elena', 'Arnal', '49494949', 1, 'elena@hotmail.com', '123456'),
(7, 'Jean Pierre', 'Flores', '3453', 1, 'jeanpi@hotmail.com', '123456'),
(8, 'Benji', 'Calatrava', '1234567g', 1, 'elbeji@hotmail.com', '123456'),
(10, 'Carlos', 'Ferrer', '123456p', 1, 'carlosf@hotmail.com', '123456'),
(11, 'Jose Vir', 'Arnal', '098098o', 1, 'josevir@hotmail.com', '123456'),
(12, 'Alfredo', 'Fara', '111111', 1, 'alfre@hotmail.com', '0987'),
(13, 'Ares', 'del Olimpo', '0000001a', 1, 'areslokito@hotmail.com', '123456'),
(14, 'Ludmi', 'Benitez', '090909', 1, 'ludbe@hotmail.com', '123456'),
(16, 'caro', 'Fara', '345353', 1, 'carofara@hotmail.com', '123456'),
(17, 'mina', 'Sante', '101010O', 1, 'fara@gmail.com', '0987'),
(18, 'usuario', 'de prueba', '904567', 1, 'deprueba@gmail.com', '090909'),
(20, 'Tina', 'de San Martin', '998877t', 1, 'tinasanmar@hotmail.com', '123456'),
(22, 'Paquencio', 'Parales', '2345p', 1, 'paquencio1', '123456'),
(23, 'Feli', 'Gutierrez', '45646q', 1, 'feligut@hotmail.com', '123456'),
(25, 'pepe', 'perez', '90909p', 1, 'pepe@gmail.com', '000'),
(26, 'pepa', 'pig', '9999m', 1, 'pepa@gmail.com', 'popo'),
(27, 'ana', 'pale', '989898b', 1, 'poli@mail.com', '000'),
(28, 'fulano', 'de tal', '000000k', 1, 'fulanito@gmail.com', '000'),
(29, 'Manolo', 'de la Cama', '65656c', 1, 'manolo@hotmail.com', '000'),
(30, 'pupi', 'sss', '00000w', 1, 'pupi@gmail.com', '000'),
(31, 'mari', 'lopez', '00333l', 1, 'pipi@hotmail.com', '000'),
(32, 'picopico', 'pacopaco', '5656uh', 1, 'pppp@mail.com', 'popo'),
(33, 'rigo', 'pancho', '343434l', 1, 'rigo@hotmail.com', '1212'),
(34, 'pancho', 'panchito', '121222222', 1, 'panchi@hotmail.com', '0000'),
(35, 'panchi', 'panchi', '0000m', 1, 'panchi@mail.com', '00'),
(36, 'fulano', 'de tal ', '99999z', 1, 'fulane@mail.com', '00'),
(37, 'pichu', 'lito', '4545p', 1, 'pichu@lito.com', '00'),
(39, 'pichu', 'lito', '000e', 1, 'pichulito@gmail.com', '00000'),
(40, 'paco', 'peco', '454545o', 1, 'paco@peco.com', '1111'),
(41, 'pipo', 'papo', '4545k', 1, 'pipo@pa.com', '111'),
(42, 'qwe', 'rty', '098m', 1, 'qwerty@hotmail.com', '123'),
(43, 'qtrl', 'esc', '77777v', 1, 'qtrl@esc.com', '222'),
(44, 'pipo', 'pipo', '6767uj', 1, 'popi@mail.com', '999'),
(45, 'Tuca', 'Fara', '5555o', 1, 'tuca@hotmail.com', '5678'),
(46, 'Federico', 'Amarilla', '8989898n', 1, 'federico@gmail.com', '12345'),
(47, 'Debora', 'Fara', '67667c', 1, 'debora@mail.com', '000'),
(48, 'Titino', 'Siame', '7878c', 1, 'titino@gmail.com', '987'),
(49, 'Cocoliso', 'Siame', '6777tgb', 1, 'cocoliso@gmail.com', '9999'),
(50, 'Sancho', 'Panza', '44444o', 1, 'sanchito@hotmail.com', '12345'),
(54, 'Nala', 'sita', '9898b', 1, 'mb@hotmail.com', '1234'),
(55, 'Luna', 'sita', '1234567', 1, 'nala123@gmail.com', '1234'),
(56, 'paco', 'paquito', '9898m', 1, 'trulito@hotmail.com', '000'),
(57, 'pan', 'chuque', '55555v', 1, 'panchuque@gmail.com', '7878'),
(58, 'pico', 'tazo', '6767y76y', 1, 'pico@hotmail.com', '999'),
(59, 'homero', 'simpson', '777777c', 1, 'homerito@hotmail.com', '777'),
(60, 'puma', 'del norte', '55565j', 1, 'pumita@hotmail.com', '11111'),
(61, 'antorcha', 'grande', 'grande', 1, 'antorcha@hotmail.com', 'www'),
(62, 'usuro', 'lindo', 'usuro1', 1, 'usurugato@hotmail.com', '123444'),
(63, 'Jesus', 'Lopez', '98769876i', 1, 'jesus@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuota`
--

CREATE TABLE IF NOT EXISTS `cuota` (
  `idCuota` int(11) NOT NULL AUTO_INCREMENT,
  `idPlan` varchar(10) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaVencimiento` date NOT NULL,
  PRIMARY KEY (`idCuota`),
  KEY `idInscrp_idx` (`idPlan`),
  KEY `idCliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuota`
--

INSERT INTO `cuota` (`idCuota`, `idPlan`, `idCliente`, `estado`, `fechaInicio`, `fechaVencimiento`) VALUES
(1, '01M', 2, 1, '2024-05-25', '2024-06-24'),
(2, '12M', 3, 1, '2024-05-25', '2025-05-24'),
(3, '03M', 4, 1, '2024-05-25', '2024-06-24'),
(4, '01M', 49, 1, '2024-06-02', '2024-07-01'),
(5, '01M', 2, 1, '2024-06-02', '2024-07-01'),
(6, '03M', 18, 1, '2024-06-03', '2024-09-02'),
(8, '01M', 54, 1, '2024-06-03', '2024-07-02'),
(9, '01M', 63, 1, '2024-06-03', '2024-07-02'),
(10, '01M', 63, 1, '2024-06-03', '2024-07-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `idHorario` varchar(9) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`idHorario`, `fecha_hora`, `cantidad`, `estado`) VALUES
('JUN01-21', '2024-06-01 21:00:00', 8, 1),
('JUN03-11', '2024-06-03 11:00:00', 8, 1),
('JUN03-17', '2024-06-03 17:00:00', 8, 1),
('JUN03-19', '2024-06-03 19:00:00', 8, 1),
('JUN03-20', '2024-06-03 20:00:00', 8, 1),
('JUN03-21', '2024-06-03 21:00:00', 8, 1),
('JUN04-08', '2024-06-04 08:00:00', 8, 1),
('JUN04-11', '2024-06-04 11:00:00', 8, 1),
('JUN04-16', '2024-06-04 16:00:00', 8, 1),
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
('MAY15-21', '2024-05-15 21:00:00', 8, 1),
('MAY27-13', '2027-05-28 13:00:00', 8, 1),
('MAY28-08', '2024-05-28 08:00:00', 8, 1),
('MAY28-16', '2024-05-28 16:00:00', 8, 1),
('MAY28-18', '2024-05-28 18:00:00', 8, 1),
('MAY28-19', '2024-05-28 19:00:00', 8, 1),
('MAY28-20', '2024-05-28 20:00:00', 8, 1),
('MAY29-10', '2024-05-29 10:00:00', 8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE IF NOT EXISTS `plan` (
  `idPlan` varchar(10) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `importe` double NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plan`
--

INSERT INTO `plan` (`idPlan`, `descripcion`, `importe`, `estado`) VALUES
('01M', 'Promo mensual a 30€', 30, 1),
('03M', 'Tres meses a 80€', 80, 1),
('12M', '1 año 300€', 300, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `idHorario` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_reserva_2_idx` (`idHorario`),
  KEY `idCliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `idCliente`, `idHorario`, `estado`) VALUES
(1, 2, 'MAY28-19', 0),
(3, 3, 'JUN03-19', 0),
(5, 3, 'JUN04-11', 0),
(6, 49, 'JUN03-11', 1),
(7, 54, 'JUN03-17', 0),
(8, 54, 'JUN03-20', 0),
(9, 54, 'JUN04-08', 0),
(10, 63, 'JUN04-16', 0),
(11, 63, 'JUN04-16', 1),
(12, 63, 'JUN03-21', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD CONSTRAINT `cuota_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `idSuscr` FOREIGN KEY (`idPlan`) REFERENCES `plan` (`idPlan`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `cliente_horario` FOREIGN KEY (`idHorario`) REFERENCES `horario` (`idHorario`),
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
