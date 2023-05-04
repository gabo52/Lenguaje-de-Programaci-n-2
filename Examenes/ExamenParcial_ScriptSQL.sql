DROP TABLE IF EXISTS jurado;
DROP TABLE IF EXISTS proyecto;
DROP TABLE IF EXISTS estudiante;
DROP TABLE IF EXISTS docente;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS area;
CREATE TABLE area(
	id_area INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    activo TINYINT,
    PRIMARY KEY(id_area)
)ENGINE=InnoDB;
CREATE TABLE persona(
	id_persona INT AUTO_INCREMENT,
    codigo_PUCP VARCHAR(8),
    nombre VARCHAR(100),
    apellido_paterno VARCHAR(100),
    PRIMARY KEY(id_persona)
)ENGINE=InnoDB;
CREATE TABLE estudiante(
	id_estudiante INT,
    CRAEST DECIMAL(10,2),
    PRIMARY KEY(id_estudiante),
    FOREIGN KEY(id_estudiante) REFERENCES persona(id_persona)
)ENGINE=InnoDB;
CREATE TABLE docente(
	id_docente INT,
    categoria VARCHAR(100),
    PRIMARY KEY(id_docente),
    FOREIGN KEY(id_docente) REFERENCES persona(id_persona)
)ENGINE=InnoDB;
CREATE TABLE proyecto(
	id_proyecto INT AUTO_INCREMENT,
    fid_area INT,
    fid_estudiante INT,
    titulo VARCHAR(500),
    descripcion VARCHAR(30000),
    foto LONGBLOB,
    archivo_tema_tesis LONGBLOB,
    activo TINYINT,
    PRIMARY KEY(id_proyecto),
    FOREIGN KEY(fid_area) REFERENCES area(id_area),
    FOREIGN KEY(fid_estudiante) REFERENCES estudiante(id_estudiante)
)ENGINE=InnoDB;
CREATE TABLE jurado(
	id_jurado INT AUTO_INCREMENT,
    fid_docente INT,
    fid_proyecto INT,
    activo TINYINT,
    PRIMARY KEY(id_jurado),
    FOREIGN KEY(fid_docente) REFERENCES docente(id_docente),
    FOREIGN KEY(fid_proyecto) REFERENCES proyecto(id_proyecto)
)ENGINE=InnoDB;
DROP PROCEDURE IF EXISTS INSERTAR_ESTUDIANTE;
DROP PROCEDURE IF EXISTS INSERTAR_DOCENTE;
DROP PROCEDURE IF EXISTS LISTAR_AREAS_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_ESTUDIANTES_X_CODIGOPUCP_NOMBRE;
DROP PROCEDURE IF EXISTS LISTAR_DOCENTES_X_CODIGOPUCP_NOMBRE;
DROP PROCEDURE IF EXISTS INSERTAR_PROYECTO;
DROP PROCEDURE IF EXISTS INSERTAR_JURADO_PROYECTO;
DROP PROCEDURE IF EXISTS LISTAR_PROYECTOS_X_TITULO_CODIGOPUCP_NOMBRE_TESISTA;
DROP PROCEDURE IF EXISTS LISTAR_JURADOS_X_ID_PROYECTO;
DELIMITER $
CREATE PROCEDURE INSERTAR_ESTUDIANTE(
	OUT _id_estudiante INT,
    IN _codigo_PUCP VARCHAR(8),
    IN _nombre VARCHAR(100),
    IN _apellido_paterno VARCHAR(100),
    IN _CRAEST DECIMAL(10,2)
)
BEGIN
	INSERT INTO persona(codigo_PUCP,nombre,apellido_paterno) VALUES(_codigo_PUCP,_nombre,_apellido_paterno);
    SET _id_estudiante = @@last_insert_id;
    INSERT INTO estudiante(id_estudiante,CRAEST) VALUES(_id_estudiante,_CRAEST);
END$
CREATE PROCEDURE INSERTAR_DOCENTE(
	OUT _id_docente INT,
    IN _codigo_PUCP VARCHAR(8),
    IN _nombre VARCHAR(100),
    IN _apellido_paterno VARCHAR(100),
    IN _categoria VARCHAR(100)
)
BEGIN
	INSERT INTO persona(codigo_PUCP,nombre,apellido_paterno) VALUES(_codigo_PUCP,_nombre,_apellido_paterno);
    SET _id_docente = @@last_insert_id;
    INSERT INTO docente(id_docente,categoria) VALUES(_id_docente,_categoria);
END$
CREATE PROCEDURE LISTAR_AREAS_TODAS()
BEGIN
	SELECT id_area, nombre FROM area where activo = 1;
END$
CREATE PROCEDURE LISTAR_ESTUDIANTES_X_CODIGOPUCP_NOMBRE(
	IN _codigoPUCP_nombre VARCHAR(100)
)
BEGIN
	SELECT p.id_persona, p.codigo_PUCP, p.nombre, p.apellido_paterno, e.CRAEST from persona p INNER JOIN estudiante e ON p.id_persona = e.id_estudiante WHERE (p.codigo_PUCP LIKE CONCAT('%',_codigoPUCP_nombre,'%')) OR (CONCAT(p.nombre,' ',p.apellido_paterno) LIKE CONCAT('%',_codigoPUCP_nombre,'%'));
END$
CREATE PROCEDURE LISTAR_DOCENTES_X_CODIGOPUCP_NOMBRE(
	IN _codigoPUCP_nombre VARCHAR(100)
)
BEGIN
	SELECT p.id_persona, p.codigo_PUCP, p.nombre, p.apellido_paterno, d.categoria from persona p INNER JOIN docente d ON p.id_persona = d.id_docente WHERE (p.codigo_PUCP LIKE CONCAT('%',_codigoPUCP_nombre,'%')) OR (CONCAT(p.nombre,' ',p.apellido_paterno) LIKE CONCAT('%',_codigoPUCP_nombre,'%'));
END$
CREATE PROCEDURE INSERTAR_PROYECTO(
	OUT _id_proyecto INT,
    IN _fid_area INT,
    IN _fid_estudiante INT,
    IN _titulo VARCHAR(500),
    IN _descripcion VARCHAR(30000),
    IN _foto LONGBLOB,
    IN _archivo_tema_tesis LONGBLOB
)
BEGIN
	INSERT INTO proyecto(fid_area,fid_estudiante,titulo,descripcion,foto,archivo_tema_tesis,activo) VALUES(_fid_area,_fid_estudiante,_titulo,_descripcion,_foto,_archivo_tema_tesis,1);
    SET _id_proyecto = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_JURADO_PROYECTO(
	OUT _id_jurado INT,
    IN _fid_docente INT,
    IN _fid_proyecto INT
)
BEGIN
	INSERT INTO jurado(fid_docente,fid_proyecto,activo) VALUES(_fid_docente,_fid_proyecto,1);
    SET _id_jurado = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_PROYECTOS_X_TITULO_CODIGOPUCP_NOMBRE_TESISTA(
	IN _titulo_codigoPUCP_nombre VARCHAR(500)
)
BEGIN
	SELECT p.id_proyecto, a.id_area, a.nombre as nombre_area, p.titulo, p.descripcion, p.foto, p.archivo_tema_tesis, e.id_estudiante, pe.codigo_PUCP, pe.nombre as nombre_estudiante, pe.apellido_paterno, e.CRAEST FROM proyecto p INNER JOIN estudiante e ON p.fid_estudiante = e.id_estudiante INNER JOIN persona pe ON pe.id_persona = e.id_estudiante INNER JOIN area a ON p.fid_area = a.id_area WHERE p.activo = 1 AND ((titulo LIKE CONCAT('%',_titulo_codigoPUCP_nombre,'%')) OR (CONCAT(pe.nombre,' ',pe.apellido_paterno) LIKE CONCAT('%',_titulo_codigoPUCP_nombre,'%')) OR (pe.codigo_PUCP LIKE CONCAT('%',_titulo_codigoPUCP_nombre,'%')));
END$
CREATE PROCEDURE LISTAR_JURADOS_X_ID_PROYECTO(
	IN _id_proyecto INT
)
BEGIN
	SELECT d.id_docente, p.codigo_PUCP, p.nombre, p.apellido_paterno, d.categoria FROM jurado j INNER JOIN docente d ON j.fid_docente = d.id_docente INNER JOIN persona p ON d.id_docente = p.id_persona WHERE fid_proyecto = _id_proyecto and j.activo = 1;
END$
DELIMITER ;
-- Insertando registros
INSERT INTO area(nombre,activo) VALUES('CIENCIAS DE LA COMPUTACION',1);
INSERT INTO area(nombre,activo) VALUES('INGENIERIA DE SOFTWARE',1);
INSERT INTO area(nombre,activo) VALUES('TECNOLOGIAS DE LA INFORMACION',1);
INSERT INTO area(nombre,activo) VALUES('SISTEMAS DE INFORMACION',1);
CALL INSERTAR_ESTUDIANTE(@id_estudiante1,'19961290','GEISELI','AGREDA',74.24);
CALL INSERTAR_ESTUDIANTE(@id_estudiante2,'19971166','JHONNY','RAMOS',81.90);
CALL INSERTAR_ESTUDIANTE(@id_estudiante3,'19913192','YANELA','ALVARES',62.07);
CALL INSERTAR_ESTUDIANTE(@id_estudiante4,'19948026','ABIGAIL','SANCHEZ',88.46);
CALL INSERTAR_ESTUDIANTE(@id_estudiante5,'19928074','ALEX','RIOS',86.65);
CALL INSERTAR_ESTUDIANTE(@id_estudiante6,'19948034','YULISA','OTINIANO',66.34);
CALL INSERTAR_ESTUDIANTE(@id_estudiante7,'19938668','ALLISSON','SEGURA',71.28);
CALL INSERTAR_ESTUDIANTE(@id_estudiante8,'19985766','MELISSA','PALOMINO',69.26);
CALL INSERTAR_ESTUDIANTE(@id_estudiante9,'19952280','ESTEFANY','VILLALBA',93.72);
CALL INSERTAR_ESTUDIANTE(@id_estudiante10,'19948841','HEYDI','YPARRAGUIRRE',92.33);
CALL INSERTAR_ESTUDIANTE(@id_estudiante11,'19959037','JEFFERSON','ROBLES',85.66);
CALL INSERTAR_ESTUDIANTE(@id_estudiante12,'19990393','MILAGROS','BEJARANO',74.93);
CALL INSERTAR_DOCENTE(@id_docente1,'0000982X','RONY','CUEVA','AUXILIAR');
CALL INSERTAR_DOCENTE(@id_docente2,'19970610','JOHAN','BALDEON','ASOCIADO');
CALL INSERTAR_DOCENTE(@id_docente3,'19960275','LUIS','FLORES','PRINCIPAL');
CALL INSERTAR_DOCENTE(@id_docente4,'00009334','HILMAR','HINOJOSA','AUXILIAR');
CALL INSERTAR_DOCENTE(@id_docente5,'000098GG','ANDRES','MELGAR','PRINCIPAL');
CALL INSERTAR_DOCENTE(@id_docente6,'00002179','LUIS','RIOS','PRINCIPAL');
CALL INSERTAR_DOCENTE(@id_docente7,'01500262','IVAN','SIPIRAN','CONTRATADO');
CALL INSERTAR_DOCENTE(@id_docente8,'00006311','FELIPE','SOLARI','ASOCIADO');
CALL INSERTAR_DOCENTE(@id_docente9,'20112728','FREDDY','PAZ','ASOCIADO');
CALL INSERTAR_DOCENTE(@id_docente10,'19931850','MANUEL','TUPIA','PRINCIPAL');
CALL INSERTAR_DOCENTE(@id_docente11,'19970243','CLAUDIA','ZAPATA','ASOCIADO');
CALL INSERTAR_DOCENTE(@id_docente12,'00007861','JOSE','YRIGOYEN','ASOCIADO');