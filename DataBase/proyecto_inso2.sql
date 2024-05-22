
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

create table tblTieneTrabajos(
    id_trabajo INT NOT NULL,
    id_tarea INT NOT NULL,
    importe_ud integer,
    
    constraint FK_tblTTcod_trab foreign key (id_trabajo) references tblTrabajosRealizados (cod_trabajo) ON UPDATE CASCADE,
    constraint FK_tblTTcod_tarea foreign key (id_tarea) references tblPosiblesTrabajos (id_tarea) ON UPDATE CASCADE);

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

  CREATE TABLE IF NOT EXISTS tblStockMateriales (
  IdStock int NOT NULL AUTO_INCREMENT primary key,
  IdMaterial INT NOT NULL DEFAULT '0',
  CantidadReal int NOT NULL DEFAULT '0',
  CantidadPteRecibir  int NOT NULL DEFAULT '0',
  CantidadTotal int NOT NULL DEFAULT '0',  
  CONSTRAINT FK_tblstockproductos_tblproductos FOREIGN KEY (IdMaterial) REFERENCES tblMateriales (IdMaterial));
