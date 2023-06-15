-- Eliminando Tablas

DROP TABLE IF EXISTS pelicula_actor;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS pelicula;
DROP TABLE IF EXISTS genero;
-- Creando Tablas
CREATE TABLE actor(
	id_actor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido_paterno VARCHAR(100),
    nacionalidad VARCHAR(150),
    activo TINYINT
)ENGINE=InnoDB;
CREATE TABLE genero(
	id_genero INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    activo TINYINT
)ENGINE=InnoDB;
CREATE TABLE pelicula(
	id_pelicula INT PRIMARY KEY AUTO_INCREMENT,
    fid_genero INT,
    titulo VARCHAR(1000),
    fecha_estreno DATE,
    duracion TIME,
    disponible_subtitulada TINYINT,
    disponible_doblada TINYINT,
    sinopsis VARCHAR(50000),
    portada LONGBLOB,
    activo TINYINT,
    FOREIGN KEY(fid_genero) REFERENCES genero(id_genero)
)ENGINE=InnoDB;
CREATE TABLE pelicula_actor(
	id_pelicula_actor INT PRIMARY KEY AUTO_INCREMENT,
    fid_pelicula INT,
    fid_actor INT,
    activo TINYINT,
    FOREIGN KEY(fid_pelicula) REFERENCES pelicula(id_pelicula),
    FOREIGN KEY(fid_actor) REFERENCES actor(id_actor)
)ENGINE=InnoDB;
-- Realizando registros
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('LEONARDO','DICAPRIO','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('JOSEPH','GORDON-LEVITT','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('ELLIOT','PAGE','CANADA',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('CILLIAN','MURPHY','IRLANDA',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('BRAD','PITT','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('JOHNNY','DEPP','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('DWAYNE','JOHNSON','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('TOM','CRUISE','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('HARRISON','FORD','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('SCARLETT','JOHANSSON','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('JENNIFER','LAWRENCE','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('NATALIE','PORTMAN','ISRAEL',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('JENNIFER','ANISTON','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('EMMA','STONE','ESTADOS UNIDOS',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('PENELOPE','CRUZ','ESPAÑA',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('EMMA','WATSON','FRANCIA',1);
INSERT INTO actor(nombre,apellido_paterno,nacionalidad,activo) VALUES('ANA','DE ARMAS','CUBA',1);
INSERT INTO genero(nombre,activo) VALUES('ACCION',1);
INSERT INTO genero(nombre,activo) VALUES('CIENCIA FICCION',1);
INSERT INTO genero(nombre,activo) VALUES('COMEDIA',1);
INSERT INTO genero(nombre,activo) VALUES('DRAMA',1);
INSERT INTO genero(nombre,activo) VALUES('FANTASIA',1);
INSERT INTO genero(nombre,activo) VALUES('MUSICAL',1);
-- Eliminando procedimientos almacenados
DROP PROCEDURE IF EXISTS LISTAR_GENEROS_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_ACTORES_X_NOMBRE;
DROP PROCEDURE IF EXISTS INSERTAR_PELICULA;
DROP PROCEDURE IF EXISTS INSERTAR_PELICULA_ACTOR;
DROP PROCEDURE IF EXISTS LISTAR_PELICULAS_X_TITULO;
DROP PROCEDURE IF EXISTS LISTAR_ACTORES_X_ID_PELICULA;
-- Creando procedimientos almacenados
DELIMITER $
CREATE PROCEDURE LISTAR_GENEROS_TODOS()
BEGIN
	SELECT id_genero, nombre FROM genero where activo = 1;
END$
CREATE PROCEDURE LISTAR_ACTORES_X_NOMBRE(
	IN _nombre VARCHAR(200)
)
BEGIN
	SELECT id_actor, nombre, apellido_paterno, nacionalidad FROM actor WHERE (activo = 1 AND 
    (CONCAT(nombre,' ',apellido_paterno) LIKE CONCAT('%',_nombre,'%')));
END$
CREATE PROCEDURE INSERTAR_PELICULA(
	OUT _id_pelicula INT,
    IN _fid_genero INT,
    IN _titulo VARCHAR(1000),
    IN _fecha_estreno DATE,
    IN _duracion TIME,
    IN _disponible_subtitulada TINYINT,
    IN _disponible_doblada TINYINT,
    IN _sinopsis VARCHAR(50000),
    IN _portada LONGBLOB
)
BEGIN
	INSERT INTO pelicula(fid_genero,titulo,fecha_estreno,duracion,disponible_subtitulada,disponible_doblada,sinopsis,portada,activo) VALUES(_fid_genero,_titulo,_fecha_estreno,_duracion,_disponible_subtitulada,_disponible_doblada,_sinopsis,_portada,1);
    SET _id_pelicula = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_PELICULA_ACTOR(
	OUT _id_pelicula_actor INT,
    IN _fid_pelicula INT,
    IN _fid_actor INT
)
BEGIN
	INSERT INTO pelicula_actor(fid_pelicula,fid_actor,activo) VALUES(_fid_pelicula,_fid_actor,1);
    SET _id_pelicula_actor = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_PELICULAS_X_TITULO(
	IN _titulo VARCHAR(1000)
)
BEGIN
	SELECT p.id_pelicula, g.id_genero, g.nombre as nombre_genero, p.titulo, p.fecha_estreno, p.duracion, p.disponible_subtitulada, p.disponible_doblada, p.sinopsis, p.portada FROM pelicula p INNER JOIN genero g ON p.fid_genero = g.id_genero WHERE p.activo = 1 AND p.titulo LIKE CONCAT('%',_titulo,'%');
END$
CREATE PROCEDURE LISTAR_ACTORES_X_ID_PELICULA(
	IN _id_pelicula INT
)
BEGIN
	SELECT a.id_actor, a.nombre, a.apellido_paterno, a.nacionalidad FROM actor a INNER JOIN pelicula_actor pa ON a.id_actor = pa.fid_actor WHERE pa.fid_pelicula = _id_pelicula;
END$