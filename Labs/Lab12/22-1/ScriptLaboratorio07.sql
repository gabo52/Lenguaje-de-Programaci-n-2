DROP TABLE IF EXISTS libro_autor;
DROP TABLE IF EXISTS libro;
DROP TABLE IF EXISTS idioma;
DROP TABLE IF EXISTS editorial;
DROP TABLE IF EXISTS autor;
CREATE TABLE editorial(
	id_editorial INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(300),
    activo TINYINT
)ENGINE=innodb;
CREATE TABLE idioma(
	id_idioma CHAR PRIMARY KEY,
    descripcion VARCHAR(100)
)ENGINE=innodb;
CREATE TABLE libro(
	id_libro INT AUTO_INCREMENT PRIMARY KEY,
    fid_editorial INT,
    fid_idioma CHAR,
    titulo VARCHAR(300),
    nro_paginas INT,
    fecha_publicacion DATE,
    precio DECIMAL(10,2),
    portada LONGBLOB,
    activo TINYINT,
    FOREIGN KEY(fid_editorial) REFERENCES editorial(id_editorial),
    FOREIGN KEY(fid_idioma) REFERENCES idioma(id_idioma)
)ENGINE=innodb;
CREATE TABLE autor(
	id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido_paterno VARCHAR(100),
    nacionalidad VARCHAR(100),
    activo TINYINT
)ENGINE=innodb;
CREATE TABLE libro_autor(
	id_libro_autor INT AUTO_INCREMENT PRIMARY KEY,
    fid_libro INT,
    fid_autor INT,
    activo TINYINT,
    FOREIGN KEY(fid_libro) REFERENCES libro(id_libro),
    FOREIGN KEY(fid_autor) REFERENCES autor(id_autor)
)ENGINE=innodb;
-- Insertando idiomas
INSERT INTO idioma(id_idioma,descripcion) VALUES('E','ESPAÑOL');
INSERT INTO idioma(id_idioma,descripcion) VALUES('I','INGLÉS');
-- Insertando autores
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('LUCY MAUD', 'MONTGOMERY','CANADIENSE',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('ANTONIO', 'LORENTE','ESPAÑOLA',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('CÉSAR', 'VALLEJO','PERUANA',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('CIRO', 'ALEGRÍA','PERUANA',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('WILLIAM', 'SHAKESPEARE','REINO UNIDO',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('STEPHEN', 'KING','ESTADOUNIDENSE',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('CHARLES', 'DICKENS','REINO UNIDO',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('EDGAR ALLAN', 'POE','ESTADOUNIDENSE',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('JOANNE K.', 'ROWLING','REINO UNIDO',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('MARIO', 'VARGAS','PERUANA',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('JOHN R. R.', 'TOLKIEN','SUDAFRICANO',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('OSCAR', 'WILDE','IRLANDÉS',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('JANE', 'AUSTEN','REINO UNIDO',1);
INSERT INTO autor(nombre,apellido_paterno,nacionalidad,activo) VALUES('ISABEL', 'ALLENDE','PERUANA',1);
-- Insertando editoriales
INSERT INTO editorial(nombre,activo) VALUES('LUIS VIVES (EDELVIVES)',1);
INSERT INTO editorial(nombre,activo) VALUES('ALFAGUARA',1);
INSERT INTO editorial(nombre,activo) VALUES('EDICIONES URANO',1);
INSERT INTO editorial(nombre,activo) VALUES('PENGUIM RANDOM HOUSE',1);
INSERT INTO editorial(nombre,activo) VALUES('GRUPO PLANETA',1);
INSERT INTO editorial(nombre,activo) VALUES('GRUPO ANAYA',1);
INSERT INTO editorial(nombre,activo) VALUES('GRUPO PANINI',1);
INSERT INTO editorial(nombre,activo) VALUES('SALAMANDRA',1);
INSERT INTO editorial(nombre,activo) VALUES('IVREA ESPAÑA',1);
INSERT INTO editorial(nombre,activo) VALUES('NORMA EDITORIAL',1);
INSERT INTO editorial(nombre,activo) VALUES('SPRINGER NATURE',1);
INSERT INTO editorial(nombre,activo) VALUES('ELSEVIER',1);
INSERT INTO editorial(nombre,activo) VALUES('JOHN WILEY & SONS',1);
INSERT INTO editorial(nombre,activo) VALUES('PEARSON EDUCATION',1);
INSERT INTO editorial(nombre,activo) VALUES('MCGRAW-HILL',1);

DROP PROCEDURE IF EXISTS LISTAR_EDITORIALES_X_NOMBRE;
DROP PROCEDURE IF EXISTS LISTAR_AUTORES_X_NOMBRE;
DROP PROCEDURE IF EXISTS LISTAR_AUTORES_X_ID_LIBRO;
DROP PROCEDURE IF EXISTS INSERTAR_LIBRO;
DROP PROCEDURE IF EXISTS INSERTAR_LIBRO_AUTOR;
DROP PROCEDURE IF EXISTS LISTAR_LIBROS_X_TITULO_O_EDITORIAL;
DELIMITER $
CREATE PROCEDURE LISTAR_EDITORIALES_X_NOMBRE(
	IN _nombre VARCHAR(300)
)
BEGIN
	SELECT id_editorial, nombre FROM editorial WHERE activo = 1 AND nombre LIKE CONCAT('%',_nombre,'%');
END$
CREATE PROCEDURE LISTAR_AUTORES_X_NOMBRE(
	IN _nombre VARCHAR(100)
)
BEGIN
	SELECT id_autor, nombre, apellido_paterno, nacionalidad FROM autor WHERE activo = 1 AND nombre LIKE CONCAT('%',_nombre,'%');
END$
CREATE PROCEDURE LISTAR_AUTORES_X_ID_LIBRO(
	IN _id_libro INT
)
BEGIN
	SELECT autor.id_autor, autor.nombre, autor.apellido_paterno, autor.nacionalidad FROM libro_autor INNER JOIN autor ON libro_autor.fid_autor = autor.id_autor WHERE libro_autor.fid_libro = _id_libro AND libro_autor.activo = 1;
END$
CREATE PROCEDURE INSERTAR_LIBRO(
	OUT _id_libro INT,
    IN _fid_editorial INT,
    IN _fid_idioma CHAR,
    IN _titulo VARCHAR(300),
    IN _nro_paginas INT,
    IN _fecha_publicacion DATE,
    IN _precio DECIMAL(10,2),
    IN _portada LONGBLOB
)
BEGIN
	INSERT INTO libro(fid_editorial,fid_idioma,titulo,nro_paginas,fecha_publicacion,precio,portada,activo) VALUES(_fid_editorial,_fid_idioma,_titulo,_nro_paginas,_fecha_publicacion,_precio,_portada,1);
    SET _id_libro = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_LIBRO_AUTOR(
    IN _fid_libro INT,
    IN _fid_autor INT
)
BEGIN
	INSERT INTO libro_autor(fid_libro,fid_autor,activo) VALUES(_fid_libro,_fid_autor,1);
END$
CREATE PROCEDURE LISTAR_LIBROS_X_TITULO_O_EDITORIAL(
	IN _titulo_editorial VARCHAR(300)
)
BEGIN
	SELECT libro.id_libro, libro.titulo, libro.fid_idioma, libro.nro_paginas, libro.fecha_publicacion, libro.precio, libro.portada, libro.fid_editorial, editorial.nombre as nombre_editorial FROM libro INNER JOIN editorial ON libro.fid_editorial = editorial.id_editorial WHERE libro.activo = 1 AND ((libro.titulo LIKE CONCAT('%',_titulo_editorial,'%')) OR (editorial.nombre LIKE CONCAT('%',_titulo_editorial,'%')));
END$
