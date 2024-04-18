create database GESTEMPRESARIAL;
use GESTEMPRESARIAL;

create table  tblDatos_Empresa(

IdEmpresa int NOT NULL AUTO_INCREMENT primary key,
CIF_Empresa CHAR(20) NOT NULL,
nombre_empresa char(50) NOT NULL,
direccion_empresa char(50) NOT NULL,
Telefono_empresa bigint NOT NULL,
e_mail char(50),
activaempresa bit);

CREATE TABLE IF NOT EXISTS tblFamilias (
  IdFamilia int NOT NULL AUTO_INCREMENT primary key,
  CodigoFamilia char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  familia char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  activo bit);

create table tblMateriales
(codigo_material char(5) NOT NULL primary key,
descripcion char(50),
IdFamilia int UNIQUE NOT NULL,
activo bit,
CONSTRAINT FK_tblMateriales_tbFamilia FOREIGN KEY (IdFamilia) REFERENCES tblFamilias (idFamilia));
 



create table tblProveedores
( IdProveedor int NOT NULL AUTO_INCREMENT primary key,
CIFprov char(15) NOT NULL,
nombreprov char(20) NOT NULL,
apellidosprov char(30) NOT NULL,
direccion char(50) NOT NULL,
Telefonoprov bigint NOT NULL,
e_mail char(50),
activoprov bit);

create table tblMaterialProveedor
(IdProveedor int NOT NULL,
CIFpro char(15) NOT NULL,
codemat char(5) NOT NULL,
fecha date NOT NULL,
unidades smallint NOT NULL,
importe_ud integer NOT NULL,
activo bit,
constraint PK_matprov primary key  (CIFpro,codemat, fecha),
constraint FK_TMP_prov foreign key (idProveedor) references tblProveedores(IdProveedor) ON UPDATE CASCADE,
constraint FK_TMP_Mat foreign key(codemat) references tblMateriales(codigo_material) ON UPDATE CASCADE) ;


create table tblRoles

(
IdRol int(11) NOT NULL AUTO_INCREMENT,
TipoRol char(1) NOT NULL,
descripcion varchar(100) NOT NULL,
PRIMARY KEY (IdRol)

);

create table tblTrabajadores(

NIFtrab char(15) NOT NULL UNIQUE PRIMARY KEY,
IdRol int(11) NOT NULL,
id_Empresa int NOT NULL,
Fecha date NOT NULL,
usuario char(30),
contrasenya char(10),
nombretrab char(20) NOT NULL,
apellidostrab char(30) NOT NULL,
direcciontrab char(50) NOT NULL,
Telefonotrab bigint NOT NULL,
e_mailtrab char(50),
Fecha_inicio date NOT NULL,
fecha_fin date,
activotrab bit,
constraint FK_tblTrabajadores_CIFEMPRESA foreign key(id_Empresa) references tblDatos_Empresa (IdEmpresa) ON UPDATE CASCADE,
constraint FK_tblTrabajadores_IDROL foreign key (IdRol) references tblRoles (IdRol) ON UPDATE CASCADE);





create table tblSueldos(
NIF_trab char(15) NOT NULL,
fecha date NOT NULL,
enbruto integer not null,
gastosirpf integer,
seguridad_social integer,
primas integer,
total integer NOT NULL,
constraint PK_tblsueldos primary key (NIF_trab, fecha),
constraint FK_tblSueldos_NIF foreign key(Nif_trab) references tblTrabajadores(NIFtrab) ON UPDATE CASCADE);

create table tblClientes(
CIFNIFcli char(15) NOT NULL UNIQUE PRIMARY KEY,
Fecha date NOT NULL,
nombrecli char(20) NOT NULL,
apellidoscli char(30) NOT NULL,
direccioncli varchar(50) NOT NULL,
Telefonocli bigint NOT NULL,
e_mailcli char(50),
activocli bit);

create table tblFacturas(
n_factura integer not null auto_increment primary key,
CIFNIF char(15) not null,
descripcion text,
cantidad int not null,
tipo char(10),
iva_aplicado tinyint default 21,
constraint FK_tblFacturas_NIF foreign key(CIFNIF) references tblClientes(CIFNIFcli) ON UPDATE CASCADE);

create table TblPresupuestos(
n_presupuesto integer not null auto_increment primary key,
CIFNIF char(15) not null,
descripcion text,
cantidad int not null,
tipo char(10),
iva_aplicado tinyint default 21,
constraint FK_tblPresupuestos_NIF foreign key(CIFNIF) references tblClientes(CIFNIFcli) ON UPDATE CASCADE);


create table tblPosiblesTrabajos(
codigo_tarea char(15) UNIQUE NOT NULL UNIQUE PRIMARY KEY,
descripciob char(100) NOT NULL,
activoTrabajo bit,
importeud integer);


create table tblTrabajosRealizados(
cod_trabajo integer not null auto_increment primary key,
fecha_inicio timestamp(6) not null,
descripcion text,
n_factura integer not null unique,
cifnif_trabajador char(15) not null unique,
fecha_fin timestamp(6),
constraint FK_TTR_factura foreign key (n_factura) references tblFacturas(n_factura) ON UPDATE CASCADE,
constraint FK_TTR_NIFtrabajador foreign key (cifnif_trabajador) references tblTrabajadores(NIFtrab) ON UPDATE CASCADE);

create table tblTieneTrabajos(
	codigo_trabajo integer not null,
    codigo_tarea char(15) NOT NULL,
    importe_ud integer,
    constraint PK_tblTT primary key (codigo_trabajo, codigo_tarea),
    constraint FK_tblTTcod_trab foreign key (codigo_trabajo) references tblTrabajosRealizados (cod_trabajo) ON UPDATE CASCADE,
    constraint FK_tblTTcod_tarea foreign key (codigo_tarea) references tblPosiblesTrabajos (codigo_tarea) ON UPDATE CASCADE);

create table tMaterialUsado(
	cod_trabajo integer NOT NULL, 
    code_material char(5) NOT NULL,
    unidades smallint,
    uso_desgaste boolean,
    desgastado boolean,
    constraint PK_tblMatUsado primary key (cod_trabajo, code_material),
    constraint FK_tblMatUsed_cod_travajo foreign key (cod_trabajo) references tblTrabajosrealizados (cod_trabajo) ON UPDATE CASCADE,
	constraint FK_tblMatUsed_cod_material foreign key (code_material) references tblMateriales (codigo_material) ON UPDATE CASCADE);

create table TrabajosEjecutados(
codigo_trabajo integer NOT NULL,
trabajador char(12) NOT NULL,
constraint PK_tblTrabEj primary key (codigo_trabajo, trabajador),
constraint FK_tblTrabEj_cod_trabajo foreign key (codigo_trabajo) references tblTrabajosrealizados (cod_trabajo) ON UPDATE CASCADE,
constraint FK_tblTrabEj_trabajador foreign key (trabajador) references tblTrabajadores (NIFtrab) ON UPDATE CASCADE

);


  
  
  CREATE TABLE IF NOT EXISTS tblStockMateriales (
  IdStock int NOT NULL AUTO_INCREMENT primary key,
  IdMaterial char(5) NOT NULL DEFAULT '0',
  CantidadReal int NOT NULL DEFAULT '0',
  CantidadPteRecibir  int NOT NULL DEFAULT '0',
  CantidadTotal int NOT NULL DEFAULT '0',

  
  CONSTRAINT FK_tblstockproductos_tblproductos FOREIGN KEY (IdMaterial) REFERENCES tblMateriales (codigo_material));
