-- Borrando tablas
DROP TABLE IF EXISTS actividad_evento;
DROP TABLE IF EXISTS responsable_evento;
DROP TABLE IF EXISTS evento;
DROP TABLE IF EXISTS docente;
DROP TABLE IF EXISTS especialidad;

-- Creando tablas
CREATE TABLE especialidad(
	id_especialidad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200),
    activa TINYINT
)ENGINE=InnoDB;
CREATE TABLE docente(
	id_docente INT PRIMARY KEY AUTO_INCREMENT,
    fid_especialidad INT,
    codigo_PUCP varchar(8),
    nombre VARCHAR(100),
    apellido_paterno VARCHAR(100),
    apellido_materno VARCHAR(100),
    activo TINYINT,
    FOREIGN KEY (fid_especialidad) REFERENCES especialidad(id_especialidad)
)ENGINE=InnoDB;
CREATE TABLE evento(
	id_evento INT PRIMARY KEY AUTO_INCREMENT,
    fid_especialidad INT,
    nombre VARCHAR(500),
    fecha_inicio DATE,
    fecha_fin DATE,
    costo DECIMAL(10,2),
    foto LONGBLOB,
    activo TINYINT,
    FOREIGN KEY (fid_especialidad) REFERENCES especialidad(id_especialidad)
)ENGINE=InnoDB;
CREATE TABLE responsable_evento(
	id_responsable_evento INT PRIMARY KEY AUTO_INCREMENT,
    fid_docente INT,
    fid_evento INT,
    activo TINYINT,
    FOREIGN KEY (fid_docente) REFERENCES docente(id_docente),
    FOREIGN KEY (fid_evento) REFERENCES evento(id_evento)
)ENGINE=InnoDB;
CREATE TABLE actividad_evento(
	id_actividad INT PRIMARY KEY AUTO_INCREMENT,
    fid_evento INT,
    nombre VARCHAR(500),
    fecha DATE,
    hora_inicio TIME,
    hora_fin TIME,
    activa TINYINT,
    FOREIGN KEY (fid_evento) REFERENCES evento(id_evento)
)ENGINE=InnoDB;

-- Insertando registros
INSERT INTO especialidad(nombre,activa) VALUES('INGENIERIA CIVIL',1);
INSERT INTO especialidad(nombre,activa) VALUES('INGENIERIA INDUSTRIAL',1);
INSERT INTO especialidad(nombre,activa) VALUES('INGENIERIA INFORMATICA',1);
INSERT INTO especialidad(nombre,activa) VALUES('INGENIERIA MECANICA',1);
INSERT INTO especialidad(nombre,activa) VALUES('INGENIERIA DE MINAS',1);
INSERT INTO especialidad(nombre,activa) VALUES('INGENIERIA DE LAS TELECOMUNICACIONES',1);

INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(1,'00001218','JORGE','BLONDET','SAAVEDRA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(1,'00001496','GIAN FRANCO','OTTAZZI','PASINO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(1,'00003541','SANDRA','SANTA CRUZ','HIDALGO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(1,'00003719','DANIEL','QUIUN','WONG',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(1,'00004141','IRIS','DOMINGUEZ','TALAVERA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(1,'00006205','JUAN','DEXTRE','QUIJANDRIA',1);

INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(2,'00003816','CESAR','CORRALES','RIVEROS',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(2,'00003863','JORGE','VARGAS','FLOREZ',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(2,'00004290','MARIA','QUISPE','TRINIDAD',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(2,'00008605','WILMER','ATOCHE','DIAZ',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(2,'01500007','FIORELLA','CARDENAS','TORO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(2,'19911254','CESAR','STOLL','QUEVEDO',1);

INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(3,'000098GG','ANDRES','MELGAR','SASIETA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(3,'20112728','FREDDY','PAZ','ESPINOZA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(3,'19931850','MANUEL','TUPIA','ANTICONA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(3,'19960275','LUIS','FLORES','GARCIA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(3,'19970243','CLAUDIA','ZAPATA','DEL RIO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(3,'19970610','JOHAN','BALDEON','MEDRANO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(3,'0000982X','RONY','CUEVA','MOSCOSO',1);

INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(4,'19987713','HERBERT','YEPEZ','CASTILLO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(4,'20072312','DANTE','ARROYO','LOPEZ',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(4,'20123095','JOSE','GARCIA','SULCA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(4,'20113127','IVAN','YUPANQUI','TELLO',1);

INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(5,'00004322','SALUSTIANO','ROCCA','ESPINOZA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(5,'00004270','CARLOS','ROMERO','IZAGA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(5,'00005329','VICTOR','CISNEROS','ARATA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(5,'19921187','OSCAR','MIRANDA','CASTILLO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(5,'19880044','CARLOS','BINASCO','PEREZ',1);

INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(6,'20064452','CESAR','LUCHO','ROMERO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(6,'20150632','ALVARO','BURGA','LARCO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(6,'20161448','JULIO','CARRION','PARDO',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(6,'20160679','ALONSO','GUEVARA','HERMOZA',1);
INSERT INTO docente(fid_especialidad,codigo_PUCP,nombre,apellido_paterno,apellido_materno,activo) VALUES(6,'20161056','CARLOS','MINAYA','ORIHUELA',1);

-- Eliminando procedimientos almacenados
DROP PROCEDURE IF EXISTS LISTAR_ESPECIALIDADES_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_DOCENTES_X_CODIGOPUCP_NOMBRE_IDESPECIALIDAD;
DROP PROCEDURE IF EXISTS INSERTAR_EVENTO;
DROP PROCEDURE IF EXISTS INSERTAR_RESPONSABLE_EVENTO;
DROP PROCEDURE IF EXISTS INSERTAR_ACTIVIDAD_EVENTO;
DROP PROCEDURE IF EXISTS LISTAR_EVENTOS_X_NOMBRE;
DROP PROCEDURE IF EXISTS LISTAR_DOCENTES_X_IDEVENTO;
DROP PROCEDURE IF EXISTS LISTAR_ACTIVIDADES_X_IDEVENTO;

-- Creando procedimientos almacenados
DELIMITER $
CREATE PROCEDURE LISTAR_ESPECIALIDADES_TODAS()
BEGIN
	SELECT id_especialidad, nombre FROM especialidad WHERE activa = 1;
END$
CREATE PROCEDURE LISTAR_DOCENTES_X_CODIGOPUCP_NOMBRE_IDESPECIALIDAD(
	IN _codigo_PUCP_nombre VARCHAR(300),
    IN _id_especialidad INT
)
BEGIN
	SELECT d.id_docente, e.id_especialidad, e.nombre as nombre_especialidad, d.codigo_PUCP, d.nombre, d.apellido_paterno, d.apellido_materno FROM docente d INNER JOIN especialidad e ON d.fid_especialidad = e.id_especialidad WHERE activo = 1 AND ((CONCAT(d.nombre,' ',d.apellido_paterno,' ',d.apellido_materno) LIKE CONCAT('%',_codigo_PUCP_nombre,'%')) OR (d.codigo_PUCP LIKE CONCAT('%',_codigo_PUCP_nombre,'%'))) AND e.id_especialidad = _id_especialidad;
END$
CREATE PROCEDURE INSERTAR_EVENTO(
	OUT _id_evento INT,
    IN _fid_especialidad INT,
    IN _nombre VARCHAR(500),
    IN _fecha_inicio DATE,
    IN _fecha_fin DATE,
    IN _costo DECIMAL(10,2),
    IN _foto LONGBLOB
)
BEGIN
	INSERT INTO evento(fid_especialidad, nombre, fecha_inicio, fecha_fin, costo, foto, activo) VALUES(_fid_especialidad, _nombre, _fecha_inicio, _fecha_fin, _costo, _foto, 1);
    SET _id_evento = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_RESPONSABLE_EVENTO(
	OUT _id_responsable_evento INT,
    IN _fid_docente INT,
    IN _fid_evento INT
)
BEGIN
	INSERT INTO responsable_evento(fid_docente, fid_evento, activo) VALUES (_fid_docente,_fid_evento,1);
    SET _id_responsable_evento = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_ACTIVIDAD_EVENTO(
	OUT _id_actividad INT,
    IN _fid_evento INT,
    IN _nombre VARCHAR(500),
    IN _fecha DATE,
    IN _hora_inicio TIME,
    IN _hora_fin TIME
)
BEGIN
	INSERT INTO actividad_evento(fid_evento,nombre,fecha,hora_inicio,hora_fin,activa) VALUES(_fid_evento,_nombre,_fecha,_hora_inicio,_hora_fin,1);
    SET _id_actividad = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_EVENTOS_X_NOMBRE(
	IN _nombre VARCHAR(500)
)
BEGIN
	SELECT e.id_evento, esp.id_especialidad, esp.nombre as nombre_especialidad, e.nombre, e.fecha_inicio, e.fecha_fin, e.costo, e.foto FROM evento e INNER JOIN especialidad esp ON e.fid_especialidad = esp.id_especialidad WHERE e.activo = 1 AND e.nombre LIKE CONCAT('%',_nombre,'%');
END$
CREATE PROCEDURE LISTAR_DOCENTES_X_IDEVENTO(
	IN _id_evento INT
)
BEGIN
	SELECT d.id_docente, esp.id_especialidad, esp.nombre as nombre_especialidad, d.codigo_PUCP, d.nombre, d.apellido_paterno, d.apellido_materno FROM responsable_evento re INNER JOIN docente d ON re.fid_docente = d.id_docente INNER JOIN especialidad esp ON d.fid_especialidad = esp.id_especialidad WHERE re.fid_evento = _id_evento;
END$
CREATE PROCEDURE LISTAR_ACTIVIDADES_X_IDEVENTO(
	IN _id_evento INT
)
BEGIN
	SELECT ae.id_actividad, ae.nombre, ae.fecha, ae.hora_inicio, ae.hora_fin FROM actividad_evento ae WHERE ae.fid_evento = _id_evento AND ae.activa = 1;
END$