DROP TABLE IF EXISTS ponencia;
DROP TABLE IF EXISTS integrante;
DROP TABLE IF EXISTS tipo_integrante;
DROP TABLE IF EXISTS evento;
CREATE TABLE evento(
	id_evento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    fecha DATE,
    descripcion VARCHAR(5000),
    portada LONGBLOB,
    activo TINYINT
)ENGINE=INNODB;
CREATE TABLE tipo_integrante(
	id_tipo_integrante INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(200)
)ENGINE=INNODB;
CREATE TABLE integrante(
	id_integrante INT PRIMARY KEY AUTO_INCREMENT,
	fid_tipo_integrante INT,
    codigo_PUCP VARCHAR(8),
    nombre VARCHAR(75),
    apellido_paterno VARCHAR(75),
    activo TINYINT,
    FOREIGN KEY (fid_tipo_integrante) REFERENCES tipo_integrante(id_tipo_integrante)
)ENGINE=INNODB;
CREATE TABLE ponencia(
	id_ponencia INT PRIMARY KEY AUTO_INCREMENT,
    fid_evento INT,
    fid_ponente INT,
    titulo VARCHAR(500),
    hora_inicio TIME,
    hora_fin TIME,
    activo TINYINT,
    FOREIGN KEY(fid_evento) REFERENCES evento(id_evento),
    FOREIGN KEY(fid_ponente) REFERENCES integrante(id_integrante)
)ENGINE=INNODB;
INSERT INTO tipo_integrante(descripcion) VALUES('DOCENTE');
INSERT INTO tipo_integrante(descripcion) VALUES('EGRESADO');
INSERT INTO tipo_integrante(descripcion) VALUES('ALUMNO');
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(1,'20112728','FREDDY','PAZ',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(1,'20099362','ARTURO','MOQUILLAZA',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(1,'0000982X','RONY','CUEVA',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(2,'20110736','JOEL','AGUIRRE',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(3,'20160493','CARLOS','RAMOS',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(2,'20167441','ROSANGELA','VALENZUELA',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(3,'20155470','ALEXIS','AVELINO',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(1,'20022214','JUAN','ARENAS',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(3,'20170910','FRANCISCO','ROSALES',1);
INSERT INTO integrante(fid_tipo_integrante,codigo_PUCP,nombre,apellido_paterno,activo) VALUES(3,'20156084','DIANA','ALARCÓN',1);
DELIMITER $
DROP PROCEDURE IF EXISTS LISTAR_INTEGRANTES_X_NOMBRE_TIPO$
DROP PROCEDURE IF EXISTS INSERTAR_EVENTO$
DROP PROCEDURE IF EXISTS INSERTAR_PONENCIA$
DROP PROCEDURE IF EXISTS LISTAR_EVENTO_X_NOMBRE$
DROP PROCEDURE IF EXISTS LISTAR_PONENCIAS_X_ID_EVENTO$
CREATE PROCEDURE LISTAR_INTEGRANTES_X_NOMBRE_TIPO(
	_nombre VARCHAR(75),
    _tipo VARCHAR(1)
)
BEGIN
	SELECT integrante.id_integrante, integrante.codigo_PUCP, integrante.nombre, integrante.apellido_paterno, tipo_integrante.id_tipo_integrante, tipo_integrante.descripcion, integrante.activo FROM integrante INNER JOIN tipo_integrante ON integrante.fid_tipo_integrante = tipo_integrante.id_tipo_integrante WHERE integrante.activo = 1 AND (CONCAT(integrante.nombre,' ',integrante.apellido_paterno) LIKE CONCAT('%',_nombre,'%')) AND 
    (tipo_integrante.descripcion LIKE (CASE 
    WHEN _tipo = 'A' THEN 'ALUMNO' 
    WHEN _tipo = 'E' THEN 'EGRESADO'
    WHEN _tipo = 'D' THEN 'DOCENTE'
    ELSE '%' END));
END$
CREATE PROCEDURE INSERTAR_EVENTO(
	OUT _id_evento INT,
    IN _nombre VARCHAR(100),
    IN _fecha DATE,
    IN _descripcion VARCHAR(5000),
    IN _portada LONGBLOB
)
BEGIN
	INSERT INTO evento(nombre,fecha,descripcion,portada,activo) VALUES(_nombre,_fecha,_descripcion,_portada,1);
    SET _id_evento = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_PONENCIA(
	OUT _id_ponencia INT,
    IN _fid_evento INT,
    IN _fid_ponente INT,
    IN _titulo VARCHAR(500),
    IN _hora_inicio TIME,
    IN _hora_fin TIME
)
BEGIN
	INSERT INTO ponencia(fid_evento,fid_ponente,titulo,hora_inicio,hora_fin,activo) VALUES(_fid_evento,_fid_ponente,_titulo,_hora_inicio,_hora_fin,1);
    SET _id_ponencia = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_EVENTO_X_NOMBRE(
	IN _nombre VARCHAR(100)
)
BEGIN
	SELECT evento.id_evento, evento.nombre, evento.fecha, evento.descripcion, evento.portada, evento.activo FROM evento WHERE evento.activo = 1 AND evento.nombre LIKE CONCAT('%',_nombre,'%');
END$
CREATE PROCEDURE LISTAR_PONENCIAS_X_ID_EVENTO(
	IN _id_evento INT
)
BEGIN
	SELECT ponencia.id_ponencia, ponencia.titulo, ponencia.hora_inicio, ponencia.hora_fin, integrante.id_integrante, integrante.nombre, integrante.apellido_paterno FROM ponencia INNER JOIN integrante ON ponencia.fid_ponente = integrante.id_integrante WHERE ponencia.activo = 1 AND ponencia.fid_evento = _id_evento;
END$

select * from evento;