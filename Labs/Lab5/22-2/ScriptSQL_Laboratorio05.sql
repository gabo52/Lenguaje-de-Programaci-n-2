-- Limpieza de tablas
DROP TABLE IF EXISTS videojuego;
DROP TABLE IF EXISTS genero;
DROP TABLE IF EXISTS desarrolladora;
DROP TABLE IF EXISTS plataforma;
-- Creación de tablas
CREATE TABLE genero(
	id_genero INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    activo TINYINT,
    PRIMARY KEY(id_genero)
)ENGINE=InnoDB;
CREATE TABLE desarrolladora(
	id_desarrolladora INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    activo TINYINT,
    PRIMARY KEY(id_desarrolladora)
)ENGINE=InnoDB;
CREATE TABLE plataforma(
	id_plataforma CHAR,
    nombre VARCHAR(100),
    activo TINYINT,
    PRIMARY KEY (id_plataforma)
)ENGINE=InnoDB;
CREATE TABLE videojuego(
	id_videojuego INT AUTO_INCREMENT,
    fid_desarrolladora INT,
    fid_genero INT,
    fid_plataforma CHAR,
    nombre VARCHAR(100),
    max_jugadores INT,
    es_cooperativo TINYINT,
    es_multiplayer TINYINT,
    es_edicion_especial TINYINT,
    precio DECIMAL(10,2),
    descripcion VARCHAR(10000),
    portada LONGBLOB,
    activo TINYINT,
    PRIMARY KEY(id_videojuego),
    FOREIGN KEY (fid_desarrolladora) REFERENCES desarrolladora(id_desarrolladora),
    FOREIGN KEY (fid_genero) REFERENCES genero(id_genero),
    FOREIGN KEY (fid_plataforma) REFERENCES plataforma(id_plataforma)
)ENGINE=InnoDB;
-- Registros iniciales
INSERT INTO genero(nombre,activo) VALUES('ACCIÓN',1);
INSERT INTO genero(nombre,activo) VALUES('AVENTURA',1);
INSERT INTO genero(nombre,activo) VALUES('ARCADE',1);
INSERT INTO genero(nombre,activo) VALUES('DEPORTIVO',1);
INSERT INTO genero(nombre,activo) VALUES('ESTRATEGIA',1);
INSERT INTO genero(nombre,activo) VALUES('SHOOTER',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('ELECTRONIC ARTS',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('BUNGIE STUDIOS',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('NAUGHTY DOG',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('SANTA MONICA STUDIO',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('GUERRILLA GAMES',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('NINTENDO DEVELOPMENT',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('CAPCOM',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('SQUARE ENIX',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('BETHESDA SOFTWORKS',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('ACTIVISION BLIZZARD',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('EPIC GAMES',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('SEGA CORPORATION',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('UBISOFT ENTERTAINMENT',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('ROCKSTAR STUDIOS',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('VALVE CORPORATION',1);
INSERT INTO desarrolladora(nombre,activo) VALUES('XBOX GAME STUDIOS',1);
INSERT INTO plataforma(id_plataforma,nombre,activo) VALUES('P','PLAYSTATION 5',1);
INSERT INTO plataforma(id_plataforma,nombre,activo) VALUES('N','NINTENDO SWITCH',1);
INSERT INTO plataforma(id_plataforma,nombre,activo) VALUES('X','XBOX ONE',1);
-- Eliminando procedimientos almacenados
DROP PROCEDURE IF EXISTS LISTAR_GENEROS_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_DESARROLLADORAS_POR_NOMBRE;
DROP PROCEDURE IF EXISTS INSERTAR_VIDEOJUEGO;
DROP PROCEDURE IF EXISTS LISTAR_VIDEOJUEGOS_POR_NOMBRE;
-- Creando procedimientos almacenados
DELIMITER $
CREATE PROCEDURE LISTAR_GENEROS_TODOS()
BEGIN
	SELECT id_genero, nombre FROM genero WHERE activo = 1 ORDER BY nombre ASC;
END$
CREATE PROCEDURE LISTAR_DESARROLLADORAS_POR_NOMBRE(
	_nombre VARCHAR(100)
)
BEGIN
	SELECT id_desarrolladora, nombre FROM desarrolladora WHERE activo = 1 AND (nombre LIKE CONCAT('%',_nombre,'%')) ORDER BY nombre ASC;
END$
CREATE PROCEDURE INSERTAR_VIDEOJUEGO(
	OUT _id_videojuego INT,
    IN _fid_desarrolladora INT,
    IN _fid_genero INT,
    IN _fid_plataforma CHAR,
    IN _nombre VARCHAR(100),
    IN _max_jugadores INT,
    IN _es_cooperativo TINYINT,
    IN _es_multiplayer TINYINT,
    IN _es_edicion_especial TINYINT,
    IN _precio DECIMAL(10,2),
    IN _descripcion VARCHAR(10000),
    IN _portada LONGBLOB
)
BEGIN
	INSERT INTO videojuego(fid_desarrolladora,fid_genero,fid_plataforma,nombre,max_jugadores,es_cooperativo,es_multiplayer,es_edicion_especial,precio,descripcion,portada,activo) values(_fid_desarrolladora,_fid_genero,_fid_plataforma,_nombre,_max_jugadores,_es_cooperativo,_es_multiplayer,_es_edicion_especial,_precio,_descripcion,_portada,1);
    SET _id_videojuego = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_VIDEOJUEGOS_POR_NOMBRE(
	IN _nombre VARCHAR(100)
)
BEGIN
	SELECT v.id_videojuego, d.id_desarrolladora, d.nombre as nombre_desarrolladora, g.id_genero, g.nombre as nombre_genero, p.id_plataforma, p.nombre as nombre_plataforma, v.nombre as nombre_videojuego, v.max_jugadores, v.es_cooperativo, v.es_multiplayer, v.es_edicion_especial, v.precio, v.descripcion, v.portada FROM videojuego v INNER JOIN desarrolladora d ON v.fid_desarrolladora = d.id_desarrolladora INNER JOIN genero g ON v.fid_genero = g.id_genero INNER JOIN plataforma p ON v.fid_plataforma = p.id_plataforma WHERE v.activo = 1 and (v.nombre LIKE CONCAT('%',_nombre,'%')) ORDER BY v.nombre ASC;
END$