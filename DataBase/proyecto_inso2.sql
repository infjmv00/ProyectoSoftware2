-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.3.0 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONºE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para gestempresarial
CREATE DATABASE IF NOT EXISTS `gestempresarial` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestempresarial`;

-- Volcando estructura para tabla gestempresarial.menu
CREATE TABLE IF NOT EXISTS `tblMenu` (
  `idMenu` int NOT NULL AUTO_INCREMENT,
  `idRol` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `tipo` enum('S','I') DEFAULT NULL,
  `codigo_submenu` int DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idMenu`),
  KEY `FK_tblmenu_tblRoles` (`idRol`),
  KEY `FK_Menu_Item` (`codigo_submenu`),
  CONSTRAINT `FK_Menu_Item` FOREIGN KEY (`codigo_submenu`) REFERENCES `tblMenu` (`idMenu`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_tblmenu_tblRoles` FOREIGN KEY (`idRol`) REFERENCES `tblroles` (`IdRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.menu: ~0 rows (aproximadamente)
DELETE FROM `tblMenu`;

-- Volcando estructura para tabla gestempresarial.tblclientes
CREATE TABLE IF NOT EXISTS `tblclientes` (
  `id_Cliente` int NOT NULL,
  `CIFNIFcli` char(15) NOT NULL,
  `Fecha` date NOT NULL,
  `nombrecli` char(20) NOT NULL,
  `apellidoscli` char(30) NOT NULL,
  `direccioncli` varchar(50) NOT NULL,
  `Telefonocli` bigint NOT NULL,
  `e_mailcli` char(50) DEFAULT NULL,
  `activocli` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblclientes: ~0 rows (aproximadamente)
DELETE FROM `tblclientes`;

-- Volcando estructura para tabla gestempresarial.tbldatos_empresa
CREATE TABLE IF NOT EXISTS `tbldatos_empresa` (
  `IdEmpresa` int NOT NULL AUTO_INCREMENT,
  `CIF_Empresa` char(20) NOT NULL,
  `nombre_empresa` char(50) NOT NULL,
  `direccion_empresa` char(50) NOT NULL,
  `Telefono_empresa` bigint NOT NULL,
  `e_mail` char(50) DEFAULT NULL,
  `activaempresa` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tbldatos_empresa: ~0 rows (aproximadamente)
DELETE FROM `tbldatos_empresa`;

-- Volcando estructura para tabla gestempresarial.tblfacturas
CREATE TABLE IF NOT EXISTS `tblfacturas` (
  `n_factura` int NOT NULL AUTO_INCREMENT,
  `id_Cliente` int NOT NULL,
  `descripcion` text,
  `cantidad` int NOT NULL,
  `tipo` char(10) DEFAULT NULL,
  `iva_aplicado` tinyint DEFAULT '21',
  PRIMARY KEY (`n_factura`),
  KEY `FK_tblFacturas_NIF` (`id_Cliente`),
  CONSTRAINT `FK_tblFacturas_NIF` FOREIGN KEY (`id_Cliente`) REFERENCES `tblclientes` (`id_Cliente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblfacturas: ~0 rows (aproximadamente)
DELETE FROM `tblfacturas`;

-- Volcando estructura para tabla gestempresarial.tblfamilias
CREATE TABLE IF NOT EXISTS `tblfamilias` (
  `IdFamilia` int NOT NULL AUTO_INCREMENT,
  `CodigoFamilia` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `familia` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `activo` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdFamilia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblfamilias: ~0 rows (aproximadamente)
DELETE FROM `tblfamilias`;

-- Volcando estructura para tabla gestempresarial.tblmateriales
CREATE TABLE IF NOT EXISTS `tblmateriales` (
  `IdMaterial` int NOT NULL AUTO_INCREMENT,
  `codigo_material` char(15) NOT NULL,
  `descripcion` char(50) DEFAULT NULL,
  `IdFamilia` int NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdMaterial`),
  UNIQUE KEY `IdFamilia` (`IdFamilia`),
  CONSTRAINT `FK_tblMateriales_tbFamilia` FOREIGN KEY (`IdFamilia`) REFERENCES `tblfamilias` (`IdFamilia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblmateriales: ~0 rows (aproximadamente)
DELETE FROM `tblmateriales`;

-- Volcando estructura para tabla gestempresarial.tblmaterialproveedor
CREATE TABLE IF NOT EXISTS `tblmaterialproveedor` (
  `CIFpro` int NOT NULL,
  `idmat` int NOT NULL,
  `fecha` date NOT NULL,
  `unidades` smallint NOT NULL,
  `importe_ud` float NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  KEY `FK_TMP_prov` (`CIFpro`),
  KEY `FK_TMP_Mat` (`idmat`),
  CONSTRAINT `FK_TMP_Mat` FOREIGN KEY (`idmat`) REFERENCES `tblmateriales` (`IdMaterial`) ON UPDATE CASCADE,
  CONSTRAINT `FK_TMP_prov` FOREIGN KEY (`CIFpro`) REFERENCES `tblproveedores` (`IdProveedor`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblmaterialproveedor: ~0 rows (aproximadamente)
DELETE FROM `tblmaterialproveedor`;

-- Volcando estructura para tabla gestempresarial.tblmaterialusado
CREATE TABLE IF NOT EXISTS `tblmaterialusado` (
  `cod_trabajo` int NOT NULL,
  `code_material` int NOT NULL,
  `unidades` smallint DEFAULT NULL,
  `uso_desgaste` tinyint(1) DEFAULT NULL,
  `desgastado` tinyint(1) DEFAULT NULL,
  KEY `FK_tblMatUsed_cod_trabajo` (`cod_trabajo`),
  KEY `FK_tblMatUsed_cod_material` (`code_material`),
  CONSTRAINT `FK_tblMatUsed_cod_material` FOREIGN KEY (`code_material`) REFERENCES `tblmateriales` (`IdMaterial`) ON UPDATE CASCADE,
  CONSTRAINT `FK_tblMatUsed_cod_trabajo` FOREIGN KEY (`cod_trabajo`) REFERENCES `tbltrabajosrealizados` (`cod_trabajo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblmaterialusado: ~0 rows (aproximadamente)
DELETE FROM `tblmaterialusado`;

-- Volcando estructura para tabla gestempresarial.tblposiblestrabajos
CREATE TABLE IF NOT EXISTS `tblposiblestrabajos` (
  `id_tarea` int NOT NULL AUTO_INCREMENT,
  `descripcion` char(100) NOT NULL,
  `activoTrabajo` bit(1) DEFAULT NULL,
  `importeud` float DEFAULT NULL,
  PRIMARY KEY (`id_tarea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblposiblestrabajos: ~0 rows (aproximadamente)
DELETE FROM `tblposiblestrabajos`;

-- Volcando estructura para tabla gestempresarial.tblpresupuestos
CREATE TABLE IF NOT EXISTS `tblpresupuestos` (
  `n_presupuesto` int NOT NULL AUTO_INCREMENT,
  `id_Cliente` int NOT NULL,
  `descripcion` text,
  `cantidad` int NOT NULL,
  `tipo` char(10) DEFAULT NULL,
  `iva_aplicado` tinyint DEFAULT '21',
  PRIMARY KEY (`n_presupuesto`),
  KEY `FK_tblPresupuestos_NIF` (`id_Cliente`),
  CONSTRAINT `FK_tblPresupuestos_NIF` FOREIGN KEY (`id_Cliente`) REFERENCES `tblclientes` (`id_Cliente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblpresupuestos: ~0 rows (aproximadamente)
DELETE FROM `tblpresupuestos`;

-- Volcando estructura para tabla gestempresarial.tblproveedores
CREATE TABLE IF NOT EXISTS `tblproveedores` (
  `IdProveedor` int NOT NULL AUTO_INCREMENT,
  `CIFprov` char(15) NOT NULL,
  `nombreprov` char(20) NOT NULL,
  `apellidosprov` char(30) NOT NULL,
  `direccion` char(50) NOT NULL,
  `Telefonoprov` bigint NOT NULL,
  `e_mail` char(50) DEFAULT NULL,
  `activoprov` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblproveedores: ~0 rows (aproximadamente)
DELETE FROM `tblproveedores`;

-- Volcando estructura para tabla gestempresarial.tblroles
CREATE TABLE IF NOT EXISTS `tblroles` (
  `IdRol` int NOT NULL AUTO_INCREMENT,
  `TipoRol` char(1) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblroles: ~3 rows (aproximadamente)
DELETE FROM `tblroles`;
INSERT INTO `tblroles` (`IdRol`, `TipoRol`, `descripcion`) VALUES
	(1, 'P', 'Propietario'),
	(2, 'E', 'Empleado'),
	(3, 'A', 'Administrador');

-- Volcando estructura para tabla gestempresarial.tblstockmateriales
CREATE TABLE IF NOT EXISTS `tblstockmateriales` (
  `IdStock` int NOT NULL AUTO_INCREMENT,
  `IdMaterial` int NOT NULL DEFAULT '0',
  `CantidadReal` int NOT NULL DEFAULT '0',
  `CantidadPteRecibir` int NOT NULL DEFAULT '0',
  `CantidadTotal` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdStock`),
  KEY `FK_tblstockproductos_tblproductos` (`IdMaterial`),
  CONSTRAINT `FK_tblstockproductos_tblproductos` FOREIGN KEY (`IdMaterial`) REFERENCES `tblmateriales` (`IdMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblstockmateriales: ~0 rows (aproximadamente)
DELETE FROM `tblstockmateriales`;

-- Volcando estructura para tabla gestempresarial.tblsueldos
CREATE TABLE IF NOT EXISTS `tblsueldos` (
  `IdTrabajador` int NOT NULL,
  `fecha` date NOT NULL,
  `enbruto` float NOT NULL,
  `gastosirpf` float DEFAULT NULL,
  `seguridad_social` float DEFAULT NULL,
  `primas` float DEFAULT NULL,
  `total` float NOT NULL,
  KEY `FK_tblSueldos_NIF` (`IdTrabajador`),
  CONSTRAINT `FK_tblSueldos_NIF` FOREIGN KEY (`IdTrabajador`) REFERENCES `tbltrabajadores` (`IdTrabajador`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tblsueldos: ~0 rows (aproximadamente)
DELETE FROM `tblsueldos`;

-- Volcando estructura para tabla gestempresarial.tbltienetrabajos
CREATE TABLE IF NOT EXISTS `tbltienetrabajos` (
  `id_trabajo` int NOT NULL,
  `id_tarea` int NOT NULL,
  `importe_ud` int DEFAULT NULL,
  KEY `FK_tblTTcod_trab` (`id_trabajo`),
  KEY `FK_tblTTcod_tarea` (`id_tarea`),
  CONSTRAINT `FK_tblTTcod_tarea` FOREIGN KEY (`id_tarea`) REFERENCES `tblposiblestrabajos` (`id_tarea`) ON UPDATE CASCADE,
  CONSTRAINT `FK_tblTTcod_trab` FOREIGN KEY (`id_trabajo`) REFERENCES `tbltrabajosrealizados` (`cod_trabajo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tbltienetrabajos: ~0 rows (aproximadamente)
DELETE FROM `tbltienetrabajos`;

-- Volcando estructura para tabla gestempresarial.tbltrabajadores
CREATE TABLE IF NOT EXISTS `tbltrabajadores` (
  `IdTrabajador` int NOT NULL AUTO_INCREMENT,
  `NIFtrab` char(15) NOT NULL,
  `IdRol` int NOT NULL,
  `id_Empresa` int NOT NULL,
  `Fecha` date NOT NULL,
  `usuario` char(30) DEFAULT NULL,
  `contrasenya` char(10) DEFAULT NULL,
  `nombretrab` char(20) NOT NULL,
  `apellidostrab` char(30) NOT NULL,
  `direcciontrab` char(50) NOT NULL,
  `Telefonotrab` bigint NOT NULL,
  `e_mailtrab` char(50) DEFAULT NULL,
  `Fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `activotrab` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdTrabajador`),
  UNIQUE KEY `NIFtrab` (`NIFtrab`),
  KEY `FK_tblTrabajadores_CIFEMPRESA` (`id_Empresa`),
  KEY `FK_tblTrabajadores_IDROL` (`IdRol`),
  CONSTRAINT `FK_tblTrabajadores_CIFEMPRESA` FOREIGN KEY (`id_Empresa`) REFERENCES `tbldatos_empresa` (`IdEmpresa`) ON UPDATE CASCADE,
  CONSTRAINT `FK_tblTrabajadores_IDROL` FOREIGN KEY (`IdRol`) REFERENCES `tblroles` (`IdRol`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tbltrabajadores: ~0 rows (aproximadamente)
DELETE FROM `tbltrabajadores`;

-- Volcando estructura para tabla gestempresarial.tbltrabajosejecutados
CREATE TABLE IF NOT EXISTS `tbltrabajosejecutados` (
  `codigo_trabajo` int NOT NULL,
  `trabajador` int NOT NULL,
  KEY `FK_tblTrabEj_cod_trabajo` (`codigo_trabajo`),
  KEY `FK_tblTrabEj_trabajador` (`trabajador`),
  CONSTRAINT `FK_tblTrabEj_cod_trabajo` FOREIGN KEY (`codigo_trabajo`) REFERENCES `tbltrabajosrealizados` (`cod_trabajo`) ON UPDATE CASCADE,
  CONSTRAINT `FK_tblTrabEj_trabajador` FOREIGN KEY (`trabajador`) REFERENCES `tbltrabajadores` (`IdTrabajador`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tbltrabajosejecutados: ~0 rows (aproximadamente)
DELETE FROM `tbltrabajosejecutados`;

-- Volcando estructura para tabla gestempresarial.tbltrabajosrealizados
CREATE TABLE IF NOT EXISTS `tbltrabajosrealizados` (
  `cod_trabajo` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` timestamp(6) NOT NULL,
  `descripcion` text,
  `n_factura` int NOT NULL,
  `IdTrabajador` int NOT NULL,
  `fecha_fin` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_trabajo`),
  UNIQUE KEY `n_factura` (`n_factura`),
  UNIQUE KEY `IdTrabajador` (`IdTrabajador`),
  CONSTRAINT `FK_TTR_factura` FOREIGN KEY (`n_factura`) REFERENCES `tblfacturas` (`n_factura`) ON UPDATE CASCADE,
  CONSTRAINT `FK_TTR_NIFtrabajador` FOREIGN KEY (`IdTrabajador`) REFERENCES `tbltrabajadores` (`IdTrabajador`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla gestempresarial.tbltrabajosrealizados: ~0 rows (aproximadamente)
DELETE FROM `tbltrabajosrealizados`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
