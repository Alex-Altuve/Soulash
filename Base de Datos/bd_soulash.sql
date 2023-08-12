-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-01-2023 a las 08:40:15
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_soulash`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cédula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Télefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Dirección` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_Ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla del personas administrativo';

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`Nombre`, `Cédula`, `Télefono`, `Dirección`, `Usuario`, `Password`, `Fecha_Ingreso`) VALUES
('Alex Altuve', '29828497', '04142075537', 'Caracas', 'admin', 'admin', '2022-12-11'),
('Santiago Pena', '30210543', '04244593634', 'Valencia', 'admin2', 'admin2', '2022-12-15'),
('Lia Mendoza', '8304543', '04124354354', 'Caracas', 'admin3', 'admin3', '2022-12-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compradores`
--

CREATE TABLE `compradores` (
  `Nombre_Comprador` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cedula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(59) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `compradores`
--

INSERT INTO `compradores` (`Nombre_Comprador`, `Cedula`, `Telefono`, `Direccion`) VALUES
('Santiago Pena', '30210543', '04244593634', 'Venezuela'),
('Luisa Loreto', '8631665', '38643646384', 'Acarigua');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Código` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Precio` double NOT NULL,
  `Costo` double NOT NULL,
  `Fecha_Vencimiento` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Num_Lote` int(50) NOT NULL,
  `Num_Existencia` int(50) NOT NULL,
  `Unid_Vendidas` int(50) NOT NULL,
  `En Oferta` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla de Inventario y Productos';

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`Nombre`, `Código`, `Precio`, `Costo`, `Fecha_Vencimiento`, `Num_Lote`, `Num_Existencia`, `Unid_Vendidas`, `En Oferta`) VALUES
('Labial Kartier', '349', 674.64, 562.2, '5-9-2032', 5656, 0, 0, 'No'),
('Polvo Marc', '426', 38.4, 64, '1-1-2022', 431, 0, 50, 'Si'),
('Crema Gucci', '456', 48.6, 40.5, '6-4-2026', 23, 1, 0, 'No'),
('Brillo Miel', '437', 67.2, 56, '6-2-2031', 76, 4, 0, 'No'),
('Rubor Prada', '486', 28.08, 46.8, '1-1-2022', 2, 3, 0, 'Si'),
('Rimel Nivea', '913', 81.53999, 135.9, '1-1-2022', 349, 2, 3, 'Si'),
('Contorno', '156', 6, 10, '1-1-2022', 10, 4, 0, 'Si'),
('Romel', '4688', 65.159996, 45, '19-11-2034', 1, 10, 0, 'No'),
('Brillo', '54', 39, 65, '1-1-2022', 56, 37, 26, 'Si'),
('Delineador Kylie', '100', 120, 100, '26-11-2043', 1000, 86, 14, 'No'),
('Sombra Mac', '135', 403.8, 673, '1-1-2022', 613, 80, 20, 'Si'),
('Base', '234', 20.4, 34, '1-1-2022', 34, 213, 33, 'Si'),
('Deliniador', '546', 321.6, 536, '6-5-2027', 536, 521, 80, 'Si'),
('Iluminador', '75', 471, 785, '1-1-2022', 578, 564, 23, 'Si'),
('Lapiz Delineador', '864', 121.86001, 203.1, '1-1-2022', 434, 7823, 0, 'Si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores_productos`
--

CREATE TABLE `proveedores_productos` (
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Código` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Precio` double NOT NULL,
  `Costo` double NOT NULL,
  `Fecha_Vencimiento` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Num_Lote` int(50) NOT NULL,
  `Num_Existencia` int(50) NOT NULL,
  `Unid_Vendidas` int(50) NOT NULL,
  `En Oferta` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla de productos de los proveedores';

--
-- Volcado de datos para la tabla `proveedores_productos`
--

INSERT INTO `proveedores_productos` (`Nombre`, `Código`, `Precio`, `Costo`, `Fecha_Vencimiento`, `Num_Lote`, `Num_Existencia`, `Unid_Vendidas`, `En Oferta`) VALUES
('Base Kylie', '0101', 320, 490, '11-12-2024', 101, 300, 0, 'No'),
('Brochas', '0111', 163.56, 789, '5-5-2022', 1011, 920, 0, 'Si'),
('Crema Yope', '10101', 902, 436, '4-5-2024', 1212, 234, 0, 'No'),
('Labial Kartier', '349', 665, 6846, '5-9-2032', 5656, 64641, 0, 'No'),
('Crema Gucci', '456', 864, 1944, '6-4-2026', 23, 656, 0, 'Si'),
('Brillo Miel', '437', 64, 194, '6-2-2031', 76, 121, 0, 'No');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `Nombre_Comprador` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cedula` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Teléfono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Dirección` varchar(59) COLLATE utf8_unicode_ci NOT NULL,
  `Monto_Pagado` float NOT NULL,
  `Tipo_Pago` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Num_Factura` int(50) NOT NULL,
  `Num_Tarjeta` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla de historial de ventas-compras';

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`Nombre_Comprador`, `Cedula`, `Teléfono`, `Dirección`, `Monto_Pagado`, `Tipo_Pago`, `Num_Factura`, `Num_Tarjeta`, `Fecha`) VALUES
('Diana Pena', '30210488', '04125678566', 'Valencia', 643.2, 'Tarjeta', 1, '501878200086364058', '2022-12-10'),
('Esmeralda Perez', '12311654', '04245678345', 'Barinas', 964.8, 'Tarjeta', 2, '501878211186784535', '2022-12-10'),
('Eneida Delgado', '10800808', '04241605969', 'Caracas', 78, 'Efectivo', 3, 'null', '2022-12-10'),
('Maria Jose', '29828567', '04248667471', 'Valencia', 61.2, 'Tarjeta', 4, '501878123467895645', '2022-12-10'),
('Jorge Catari', '11345678', '04141107201', 'Caracas', 1081.8, 'Efectivo', 5, 'null', '2022-12-10'),
('Santiago Perez', '30210367', '04241567890', 'Caracas', 40.8, 'Efectivo', 6, 'null', '2022-12-10'),
('Sara Hernandez', '12345678', '04242345678', 'Valencia', 1304.4, 'Efectivo', 7, 'null', '2022-12-10'),
('Jose Pena', '29473547', '04246168460', 'Valencia', 40.8, 'Tarjeta', 8, '123456789101829123', '2022-12-10'),
('Cristiano Ronaldo', '12098652', '04143710260', 'Caracas', 78, 'Tarjeta', 9, '123458975798579832', '2022-12-10'),
('Maria Victoria', '29828127', '04240858369', 'Caracas', 321.6, 'Tarjeta', 10, '986763246557887906', '2022-12-10'),
('Jose Maria', '12543897', '04122543310', 'Valencia', 39, 'Efectivo', 11, 'null', '2022-12-10'),
('Di Maria', '13454553', '02124327348', 'Caracas', 5652, 'Efectivo', 12, 'null', '2022-12-10'),
('Daniel Rojas', '8228340', '04244435534', 'Naguanagua', 39, 'Efectivo', 13, 'null', '2022-12-10'),
('Santiago', '30210488', '04244596364', 'Caracas', 2083.08, 'Efectivo', 14, 'null', '2022-12-14'),
('Santiago Pena', '30210543', '04244593634', 'Venezuela', 81.54, 'Efectivo', 15, 'null', '2023-01-06'),
('Diana Pena', '30210543', '04244593634', 'Venezuela', 60, 'Efectivo', 16, 'null', '2023-01-06'),
('Luisa Loreto', '8631665', '38643646384', 'Acarigua', 8076, 'Efectivo', 17, 'null', '2023-01-06'),
('Santiago Pena', '30210543', '04244593634', 'Venezuela', 780, 'Efectivo', 18, 'null', '2023-01-06');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
