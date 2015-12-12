-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2015 a las 03:59:14
-- Versión del servidor: 10.1.9-MariaDB
-- Versión de PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `comuni`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL,
  `ID_COMUNA` int(11) DEFAULT NULL,
  `TIPO` int(11) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `NOMBRE` varchar(100) DEFAULT NULL,
  `APELLIDO` varchar(120) DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `DIRECCIONUSUARIO` varchar(200) DEFAULT NULL,
  `TELEFONO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `ID_COMUNA`, `TIPO`, `EMAIL`, `PASSWORD`, `NOMBRE`, `APELLIDO`, `FECHANACIMIENTO`, `DIRECCIONUSUARIO`, `TELEFONO`) VALUES
(1, 4, 0, 'jqnevada16@yopmail.com', 'q406106j9q', 'Marcela', 'Villapalos', '1981-12-08', 'Privada Maridueña No. 882', '+56(656)-6335404'),
(2, 10, 0, 'ftemilian19@yopmail.com', 't13518f5t', 'Emilia', 'Agarrado', '1989-10-07', 'Hope No. 806', '+56(848)-5664531'),
(3, 13, 0, 'ajvillamon9@yopmail.com', 'j07120a0j', 'Óliver', 'Antepara', '1994-04-21', 'Privada Jeremiah No. 573', '+56(050)-1118070'),
(4, 18, 0, 'jwlisandroariel22@yopmail.com', 'w76035j9w', 'Lisandro', 'Landero', '1990-06-09', 'Calle Alvarez de Cienfuegos No. 997', '+56(545)-0665267'),
(5, 4, 0, 'bjmagrach9@yopmail.co', 'j000108b1j', 'Rodrigo', 'Fuentes', '1975-11-10', 'Boulevard Misiones No. 666', '+56(858)-0995900'),
(6, 32, 0, 'ghsineriz7@yopmail.com', 'h01756g6h', 'Fernando', 'Berrendero', '1989-05-01', 'Calle Glavan No. 517', '+56(636)-7553310'),
(7, 29, 0, 'clangelica11@yopmail.com', 'l79040c2l', 'Angelica', 'Flores', '1991-02-14', 'Calle Paraguari No. 39', ' +56(050)-0777597');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD KEY `FK_TIENE3` (`ID_COMUNA`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_TIENE3` FOREIGN KEY (`ID_COMUNA`) REFERENCES `comuna` (`ID_COMUNA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
