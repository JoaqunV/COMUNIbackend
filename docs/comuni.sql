-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-12-2015 a las 00:29:20
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

DELIMITER $$
--
-- Procedimientos
--

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarUsuario`(
IN _idComuna int(11),
IN _tipo int(11),
IN _email varchar(50),
IN _password varchar(50),
IN _nombre varchar(100),
IN _apellido varchar(120),
IN _fechaNacimiento DATE,
IN _direccionUsuario varchar(200),
IN _telefono varchar(30) )

BEGIN

INSERT INTO `usuario` (`ID_USUARIO`, `ID_COMUNA`, `TIPO`, `EMAIL`, `PASSWORD`, `NOMBRE`, `APELLIDO`, `FECHANACIMIENTO`, `DIRECCIONUSUARIO`, `TELEFONO`) 
	VALUES (null,_idComuna,_tipo,_email,_password,_nombre,_apellido,_fechaNacimiento,_direccionUsuario,_telefono);
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEvento`(
IN _idCategoria int(11),
IN _idComuna int(11),
IN _titulo varchar(120),
IN _horaInicio DATETIME,
IN _horaFin DATETIME,
IN _direccionEvento varchar(200),
IN _latitud varchar(100),
IN _longitud varchar(100),
IN _pathImagen varchar(400),
IN _descripcion varchar(500),
IN _estado int(11))
BEGIN

INSERT INTO `evento` (`ID_EVENTO`, `ID_CATEGORIA`, `ID_COMUNA`, `TITULO`, `HORAINICIO`, `HORAFIN`, `DIRECCIONEVENTO`, `LATITUD`, `LONGITUD`, `PATHIMAGEN`, `DESCRIPCION`, `ESTADO`, `POPULARIDAD`) 
	VALUES (null, _idCategoria, _idComuna, _titulo, _horaInicio, _horaFin, _direccionEvento, _latitud, _longitud, _pathImagen, _descripcion, _estado, 0);
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarComentario`(
IN _idUsuario int(11),
IN _idEvento int(11),
IN _textoComentario varchar(300) )

BEGIN

INSERT INTO `comentario` (`ID_COMENTARIO`, `ID_USUARIO`, `ID_EVENTO`, `TEXTOCOMENTARIO`, `FECHACOMENTARIO`) 
	VALUES (NULL, _idUsuario, _idEvento, _textoComentario, CURRENT_TIMESTAMP);
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `interesCategoria`(
IN _idCategoria int(11),
IN _idUsuario int(11) )

BEGIN

INSERT INTO `interesa` (`ID_CATEGORIA`, `ID_USUARIO`) 
	VALUES (_idCategoria, _idUsuario);
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `interesEvento`(
IN _idEvento int(11),
IN _idUsuario int(11) )

BEGIN

INSERT INTO `interesa2` (`ID_USUARIO`, `ID_EVENTO`) 
	VALUES (_idUsuario, _idEvento);
	
UPDATE evento SET evento.popularidad = evento.popularidad + 1 where evento.ID_EVENTO=_idEvento;
	
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `ID_CATEGORIA` int(11) NOT NULL,
  `NOMBRE` varchar(100) DEFAULT NULL,
  `DESCRIPCION` varchar(500) DEFAULT NULL,
  `POPULARIDAD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`ID_CATEGORIA`, `NOMBRE`, `DESCRIPCION`, `POPULARIDAD`) VALUES
(1, 'Bingo', 'Bingos a beneficio.', 0),
(2, 'Cicletada', 'Cicletadas a beneficio.', 0),
(3, 'Maratón', 'Maratones a beneficio.', 0),
(4, 'Concierto', 'Conciertos a beneficio.', 0),
(5, 'Partido de fútbol', 'Partidos de fútbol a beneficio.', 0),
(6, 'Fiesta', 'Fiestas a beneficio.', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `ID_COMENTARIO` int(11) NOT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `ID_EVENTO` int(11) DEFAULT NULL,
  `TEXTOCOMENTARIO` varchar(300) DEFAULT NULL,
  `FECHACOMENTARIO` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`ID_COMENTARIO`, `ID_USUARIO`, `ID_EVENTO`, `TEXTOCOMENTARIO`, `FECHACOMENTARIO`) VALUES
(1, 3, 1, 'se ve muy bueno!', '2016-01-05 08:00:00'),
(2, 6, 3, 'quiero ir!', '2015-12-22 16:21:50'),
(3, 5, 3, 'vamos!', '2016-01-04 12:08:00'),
(4, 5, 1, 'buen evento', '2015-12-20 10:00:00'),
(5, 5, 1, 'buena iniciativa', '2016-01-08 00:32:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comuna`
--

CREATE TABLE `comuna` (
  `ID_COMUNA` int(11) NOT NULL,
  `NOMBRECOMUNA` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comuna`
--

INSERT INTO `comuna` (`ID_COMUNA`, `NOMBRECOMUNA`) VALUES
(1, 'Cerrillos'),
(2, 'Cerro Navia'),
(3, 'Conchalí'),
(4, 'El Bosque'),
(5, 'Estación Central'),
(6, 'Huechuraba'),
(7, 'Independencia'),
(8, 'La Cisterna'),
(9, 'La Florida'),
(10, 'La Pintana'),
(11, 'La Granja'),
(12, 'La Reina'),
(13, 'Las Condes'),
(14, 'Lo Barnechea'),
(15, 'Lo Espejo'),
(16, 'Lo Prado'),
(17, 'Macul'),
(18, 'Maipú'),
(19, 'Ñuñoa'),
(20, 'Pedro Aguirre Cerda'),
(21, 'Peñalolén'),
(22, 'Providencia'),
(23, 'Pudahuel'),
(24, 'Quilicura'),
(25, 'Quinta Normal'),
(26, 'Recoleta'),
(27, 'Renca'),
(28, 'San Miguel'),
(29, 'San Joaquín'),
(30, 'San Ramón'),
(31, 'Santiago'),
(32, 'Vitacura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `ID_EVENTO` int(11) NOT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  `ID_COMUNA` int(11) DEFAULT NULL,
  `TITULO` varchar(120) DEFAULT NULL,
  `HORAINICIO` datetime DEFAULT NULL,
  `HORAFIN` datetime DEFAULT NULL,
  `DIRECCIONEVENTO` varchar(200) DEFAULT NULL,
  `LATITUD` varchar(100) DEFAULT NULL,
  `LONGITUD` varchar(100) DEFAULT NULL,
  `PATHIMAGEN` varchar(400) DEFAULT NULL,
  `DESCRIPCION` varchar(500) DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  `POPULARIDAD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`ID_EVENTO`, `ID_CATEGORIA`, `ID_COMUNA`, `TITULO`, `HORAINICIO`, `HORAFIN`, `DIRECCIONEVENTO`, `LATITUD`, `LONGITUD`, `PATHIMAGEN`, `DESCRIPCION`, `ESTADO`, `POPULARIDAD`) VALUES
(1, 2, 5, 'Gran cicletada a beneficio', '2015-12-26 13:00:00', '2015-12-26 20:00:00', '5 de Abril 5040', '-33.464437', '-70.704141', 'img1.jpg', 'Este 26 de diciembre se realizará una gran cicletada a beneficio en la comuna de estación central!', 0, 2),
(2, 5, 22, 'Partido de leyendas a beneficio', '2016-02-17 12:00:00', '2016-02-17 18:00:00', 'Eliodoro Yañez 2035', '-33.431210', '-70.608281', 'img2.jpg', 'No te pierdas el partido de futbol a beneficio!', 0, 1),
(3, 4, 25, 'Concierto a beneficio', '2016-04-01 19:00:00', '2016-04-01 23:00:00', 'Martínez de Rozas 4533', '-33.435443', '-70.697271', 'img3.jpg', 'Muchos artistas invitados a este gran concierto a beneficio.', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interesa`
--

CREATE TABLE `interesa` (
  `ID_CATEGORIA` int(11) NOT NULL,
  `ID_USUARIO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `interesa`
--

INSERT INTO `interesa` (`ID_CATEGORIA`, `ID_USUARIO`) VALUES
(1, 5),
(1, 6),
(2, 1),
(2, 5),
(2, 7),
(3, 4),
(6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interesa2`
--

CREATE TABLE `interesa2` (
  `ID_USUARIO` int(11) NOT NULL,
  `ID_EVENTO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `interesa2`
--

INSERT INTO `interesa2` (`ID_USUARIO`, `ID_EVENTO`) VALUES
(2, 1),
(3, 2),
(7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE `notificacion` (
  `ID_NOTIFICACION` int(11) NOT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `ID_TIPO` int(11) DEFAULT NULL,
  `TEXTONOTIFICACION` varchar(140) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencia`
--

CREATE TABLE `sugerencia` (
  `ID_SUGERENCIA` int(11) NOT NULL,
  `ID_USUARIORECEPTOR` int(11) NOT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiponotificacion`
--

CREATE TABLE `tiponotificacion` (
  `ID_TIPO` int(11) NOT NULL,
  `DESCRIPCION` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`ID_CATEGORIA`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`ID_COMENTARIO`),
  ADD KEY `FK_REALIZA` (`ID_USUARIO`),
  ADD KEY `FK_TIENE` (`ID_EVENTO`);

--
-- Indices de la tabla `comuna`
--
ALTER TABLE `comuna`
  ADD PRIMARY KEY (`ID_COMUNA`);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`ID_EVENTO`),
  ADD KEY `FK_TIENE2` (`ID_COMUNA`),
  ADD KEY `FK_TIENE6` (`ID_CATEGORIA`);

--
-- Indices de la tabla `interesa`
--
ALTER TABLE `interesa`
  ADD PRIMARY KEY (`ID_CATEGORIA`,`ID_USUARIO`),
  ADD KEY `FK_INTERESA2` (`ID_USUARIO`);

--
-- Indices de la tabla `interesa2`
--
ALTER TABLE `interesa2`
  ADD PRIMARY KEY (`ID_USUARIO`,`ID_EVENTO`),
  ADD KEY `FK_INTERESA4` (`ID_EVENTO`);

--
-- Indices de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD PRIMARY KEY (`ID_NOTIFICACION`),
  ADD KEY `FK_RECIBE` (`ID_USUARIO`),
  ADD KEY `FK_TIENE5` (`ID_TIPO`);

--
-- Indices de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD PRIMARY KEY (`ID_SUGERENCIA`,`ID_USUARIORECEPTOR`),
  ADD KEY `FK_REALIZA2` (`ID_USUARIO`);

--
-- Indices de la tabla `tiponotificacion`
--
ALTER TABLE `tiponotificacion`
  ADD PRIMARY KEY (`ID_TIPO`);

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
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `ID_COMENTARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `comuna`
--
ALTER TABLE `comuna`
  MODIFY `ID_COMUNA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT de la tabla `evento`
--
ALTER TABLE `evento`
  MODIFY `ID_EVENTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  MODIFY `ID_NOTIFICACION` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  MODIFY `ID_SUGERENCIA` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tiponotificacion`
--
ALTER TABLE `tiponotificacion`
  MODIFY `ID_TIPO` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `FK_REALIZA` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  ADD CONSTRAINT `FK_TIENE` FOREIGN KEY (`ID_EVENTO`) REFERENCES `evento` (`ID_EVENTO`);

--
-- Filtros para la tabla `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `FK_TIENE2` FOREIGN KEY (`ID_COMUNA`) REFERENCES `comuna` (`ID_COMUNA`),
  ADD CONSTRAINT `FK_TIENE6` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID_CATEGORIA`);

--
-- Filtros para la tabla `interesa`
--
ALTER TABLE `interesa`
  ADD CONSTRAINT `FK_INTERESA` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID_CATEGORIA`),
  ADD CONSTRAINT `FK_INTERESA2` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`);

--
-- Filtros para la tabla `interesa2`
--
ALTER TABLE `interesa2`
  ADD CONSTRAINT `FK_INTERESA3` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  ADD CONSTRAINT `FK_INTERESA4` FOREIGN KEY (`ID_EVENTO`) REFERENCES `evento` (`ID_EVENTO`);

--
-- Filtros para la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD CONSTRAINT `FK_RECIBE` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`),
  ADD CONSTRAINT `FK_TIENE5` FOREIGN KEY (`ID_TIPO`) REFERENCES `tiponotificacion` (`ID_TIPO`);

--
-- Filtros para la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD CONSTRAINT `FK_REALIZA2` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_TIENE3` FOREIGN KEY (`ID_COMUNA`) REFERENCES `comuna` (`ID_COMUNA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
