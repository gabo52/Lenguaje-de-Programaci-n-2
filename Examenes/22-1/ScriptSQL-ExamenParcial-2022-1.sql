-- Eliminación de las tablas
DROP TABLE IF EXISTS curso_docente;
DROP TABLE IF EXISTS docente_pucp;
DROP TABLE IF EXISTS docente_extranjero;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS especialidad;
DROP TABLE IF EXISTS docente;
DROP TABLE IF EXISTS tipo_docente;
DROP TABLE IF EXISTS filiacion;
-- Creación de las tablas
CREATE TABLE especialidad(
	id_especialidad INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    activo TINYINT,
    PRIMARY KEY(id_especialidad)
)ENGINE=InnoDB;
CREATE TABLE curso(
	id_curso INT AUTO_INCREMENT,
    fid_especialidad INT,
    nombre VARCHAR(100),
    clave VARCHAR(6),
    semestre VARCHAR(6),
    modalidad VARCHAR(25),
    req_computadora TINYINT,
    req_disp_movil TINYINT,
    req_disp_especial TINYINT,
    sumilla VARCHAR(5000),
    foto LONGBLOB,
    silabo LONGBLOB,
    activo TINYINT,
    PRIMARY KEY(id_curso),
    FOREIGN KEY(fid_especialidad) REFERENCES especialidad(id_especialidad) 
)ENGINE=InnoDB;
CREATE TABLE tipo_docente(
	id_tipo_docente CHAR,
    descripcion VARCHAR(75),
    PRIMARY KEY(id_tipo_docente)
)ENGINE=InnoDB;
CREATE TABLE docente(
	id_docente INT AUTO_INCREMENT,
    fid_tipo_docente CHAR,
    codigo_PUCP VARCHAR(8),
    nombre VARCHAR(50),
    apellido_paterno VARCHAR(50),
    tipo_documento VARCHAR(50),
    numero_documento VARCHAR(30),
    maximo_grado_alcanzado VARCHAR(150),
    PRIMARY KEY(id_docente),
    FOREIGN KEY(fid_tipo_docente) REFERENCES tipo_docente(id_tipo_docente)
)ENGINE=InnoDB;
CREATE TABLE curso_docente(
	id_curso_docente INT AUTO_INCREMENT,
    fid_curso INT,
    fid_docente INT,
    activo INT,
    PRIMARY KEY(id_curso_docente),
    FOREIGN KEY(fid_curso) REFERENCES curso(id_curso),
    FOREIGN KEY(fid_docente) REFERENCES docente(id_docente)
)ENGINE=InnoDB;
CREATE TABLE docente_pucp(
	id_docente_pucp INT,
    categoria VARCHAR(25),
    activo TINYINT,
    PRIMARY KEY(id_docente_pucp),
    FOREIGN KEY(id_docente_pucp) REFERENCES docente(id_docente)
)ENGINE=InnoDB;
CREATE TABLE filiacion(
	id_filiacion INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    siglas VARCHAR(10),
    PRIMARY KEY(id_filiacion)
)ENGINE=InnoDB;
CREATE TABLE docente_extranjero(
	id_docente_extranjero INT,
    fid_filiacion INT,
    domina_espanhol TINYINT,
    domina_ingles TINYINT,
    grado_revalidado_SUNEDU TINYINT,
    activo TINYINT,
    PRIMARY KEY(id_docente_extranjero),
    FOREIGN KEY(id_docente_extranjero) REFERENCES docente(id_docente),
    FOREIGN KEY(fid_filiacion) REFERENCES filiacion(id_filiacion)
)ENGINE=InnoDB;
-- Inserciones
INSERT INTO especialidad(nombre, activo) values('INGENIERIA AMBIENTAL Y SOSTENIBLE',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA BIOMEDICA',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA CIVIL',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA DE LAS TELECOMUNICACIONES',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA DE MINAS',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA ELECTRONICA',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA GEOLOGICA',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA INDUSTRIAL',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA INFORMATICA',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA MECANICA',1);
INSERT INTO especialidad(nombre, activo) values('INGENIERIA MECATRONICA',1);
INSERT INTO tipo_docente(id_tipo_docente,descripcion) values('P','DOCENTE PUCP');
INSERT INTO tipo_docente(id_tipo_docente,descripcion) values('E','DOCENTE EXTRANJERO');
-- Eliminando procedimientos almacenados
DROP PROCEDURE IF EXISTS INSERTAR_FILIACION;
DROP PROCEDURE IF EXISTS INSERTAR_DOCENTE_EXTRANJERO;
DROP PROCEDURE IF EXISTS INSERTAR_DOCENTE_PUCP;
DROP PROCEDURE IF EXISTS INSERTAR_CURSO;
DROP PROCEDURE IF EXISTS INSERTAR_CURSO_DOCENTE;
DROP PROCEDURE IF EXISTS LISTAR_ESPECIALIDADES_TODAS;
DROP PROCEDURE IF EXISTS LISTAR_DOCENTES_POR_NOMBRE_O_CODIGO;
DROP PROCEDURE IF EXISTS LISTAR_CURSOS_POR_NOMBRE_O_CLAVE;
DROP PROCEDURE IF EXISTS LISTAR_DOCENTES_POR_ID_CURSO;
-- Creando procedimientos almacenados
DELIMITER $
CREATE PROCEDURE INSERTAR_FILIACION(
	OUT _id_filiacion INT,
    IN _nombre VARCHAR(100),
    IN _siglas VARCHAR(10)
)
BEGIN
	INSERT INTO filiacion(nombre,siglas) VALUES(_nombre,_siglas);
    SET _id_filiacion = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_DOCENTE_EXTRANJERO(
	OUT _id_docente INT,
    IN _fid_filiacion INT,
    IN _codigo_PUCP VARCHAR(8),
    IN _nombre VARCHAR(50),
    IN _apellido_paterno VARCHAR(50),
    IN _tipo_documento VARCHAR(50),
    IN _numero_documento VARCHAR(30),
    IN _maximo_grado_alcanzado VARCHAR(150),
    IN _domina_espanhol TINYINT,
    IN _domina_ingles TINYINT,
    IN _grado_revalidado_SUNEDU TINYINT
)
BEGIN
	INSERT INTO docente(fid_tipo_docente,codigo_PUCP,nombre,apellido_paterno,tipo_documento,numero_documento,maximo_grado_alcanzado) VALUES('E',_codigo_PUCP,_nombre,_apellido_paterno,_tipo_documento,_numero_documento,_maximo_grado_alcanzado);
    SET _id_docente = @@last_insert_id;
    INSERT INTO docente_extranjero(id_docente_extranjero,fid_filiacion,domina_espanhol,domina_ingles,grado_revalidado_SUNEDU,activo) VALUES(_id_docente,_fid_filiacion,_domina_espanhol,_domina_ingles,_grado_revalidado_SUNEDU,1);
END$
CREATE PROCEDURE INSERTAR_DOCENTE_PUCP(
	OUT _id_docente INT,
    IN _codigo_PUCP VARCHAR(8),
    IN _nombre VARCHAR(50),
    IN _apellido_paterno VARCHAR(50),
    IN _tipo_documento VARCHAR(50),
    IN _numero_documento VARCHAR(30),
    IN _maximo_grado_alcanzado VARCHAR(150),
    IN _categoria VARCHAR(25)
)
BEGIN
	INSERT INTO docente(fid_tipo_docente,codigo_PUCP,nombre,apellido_paterno,tipo_documento,numero_documento,maximo_grado_alcanzado) VALUES('P',_codigo_PUCP,_nombre,_apellido_paterno,_tipo_documento,_numero_documento,_maximo_grado_alcanzado);
    SET _id_docente = @@last_insert_id;
    INSERT INTO docente_pucp(id_docente_pucp,categoria,activo) values(_id_docente,_categoria,1);
END$
-- Utilizando algunos procedimientos almacenados
DELIMITER ;
CALL INSERTAR_FILIACION(@id_filiacion1,'UNIVERSIDAD DEL CAUCA','UNICAUCA');
CALL INSERTAR_DOCENTE_EXTRANJERO(@id_docente_ext1,@id_filiacion1,'E0229921','CESAR','COLLAZOS','CARNET_EXTRANJERIA','20987898','DOCTOR EN CIENCIAS DE LA COMPUTACION',1,0,0);
CALL INSERTAR_FILIACION(@id_filiacion2,'BENEMERITA UNIVERSIDAD AUTONOMA DE PUEBLA','BUAP');
CALL INSERTAR_DOCENTE_EXTRANJERO(@id_docente_ext2,@id_filiacion2,'E0918710','JUAN','GONZALES','PASAPORTE','AB000221','DOCTOR EN CIENCIAS ECONOMICAS Y DE ADMINISTRACION',1,1,0);
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp1,'20119821','CESAR','MENDOZA','DNI','19877091','MAGISTER EN INTELIGENCIA ARTIFICIAL APLICADA','CONTRATADO');
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp2,'19973102','NICOLE','RUIZ','DNI','38721933','MAGISTER EN INFORMATICA CON MENCION EN CIENCIAS DE LA COMPUTACION','CONTRATADO');
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp3,'20092972','KEIRA','SUAREZ','DNI','29001828','DOCTORA EN INFORMATICA','AUXILIAR');
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp5,'20112728','FREDDY','PAZ','DNI','34553029','DOCTOR EN INGENIERIA','ASOCIADO');
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp6,'19992984','WILMER','SIFUENTES','DNI','10928716','DOCTOR EN ELECTRONICA','ASOCIADO');
CALL INSERTAR_FILIACION(@id_filiacion3,'UNIVERSIDAD DE LLEIDA','UDLL');
CALL INSERTAR_DOCENTE_EXTRANJERO(@id_docente_ext3,@id_filiacion3,'E1010271','ANTONI','GRANOLLERS','PASAPORTE','ZAB00024','DOCTOR EN CIENCIAS DE LA COMPUTACION',1,1,0);
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp7,'19931982','CRISTHIAN','JIMENEZ','DNI','33981910','MAGISTER EN DIRECCION DE TECNOLOGIA DE INFORMACION','ASOCIADO');
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp8,'19812810','PERCY','ABANTO','DNI','33981910','DOCTOR EN CIENCIAS','PRINCIPAL');
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp7,'19820921','RUBEN','AGAPITO','DNI','28019843','MAGISTER EN CIENCIA DE DATOS','PRINCIPAL');
CALL INSERTAR_FILIACION(@id_filiacion4,'PONTIFICIA UNIVERSIDAD CATOLICA DE RIO DE JANEIRO','PUC-RIO');
CALL INSERTAR_DOCENTE_EXTRANJERO(@id_docente_ext4,@id_filiacion4,'E4092031','CLARISSE','DE SOUZA','CARNET_EXTRANJERIA','10982195','DOCTORA EN LINGUISTICA COMPUTACIONAL',1,1,0);
CALL INSERTAR_DOCENTE_PUCP(@id_docente_pucp8,'0000982X','RONY','CUEVA','DNI','29381771','MAGISTER EN INTEGRACION E INNOVACION EDUCATIVA DE LAS TICS','AUXILIAR');
-- Creando procedimientos almacenados que serán utilizados en el examen parcial
DELIMITER $
CREATE PROCEDURE INSERTAR_CURSO(
	OUT _id_curso INT,
    IN _fid_especialidad INT,
    IN _nombre VARCHAR(100),
    IN _clave VARCHAR(6),
    IN _semestre VARCHAR(6),
    IN _modalidad VARCHAR(25),
    IN _req_computadora TINYINT,
    IN _req_disp_movil TINYINT,
    IN _req_disp_especial TINYINT,
    IN _sumilla VARCHAR(5000),
    IN _foto LONGBLOB,
    IN _silabo LONGBLOB
)
BEGIN
	INSERT INTO curso(fid_especialidad,nombre,clave,semestre,modalidad,req_computadora,req_disp_movil,req_disp_especial,sumilla,foto,silabo,activo) values(_fid_especialidad,_nombre,_clave,_semestre,_modalidad,_req_computadora,_req_disp_movil,_req_disp_especial,_sumilla,_foto,_silabo,1);
    SET _id_curso = @@last_insert_id;
END$
CREATE PROCEDURE INSERTAR_CURSO_DOCENTE(
	OUT _id_curso_docente INT,
    IN _fid_curso INT,
    IN _fid_docente INT
)
BEGIN
	INSERT INTO curso_docente(fid_curso,fid_docente,activo) values(_fid_curso,_fid_docente,1);
    SET _id_curso_docente = @@last_insert_id;
END$
CREATE PROCEDURE LISTAR_ESPECIALIDADES_TODAS()
BEGIN
	SELECT id_especialidad, nombre FROM especialidad WHERE activo = 1;
END$
CREATE PROCEDURE LISTAR_DOCENTES_POR_NOMBRE_O_CODIGO(
	IN _nombreCodigo VARCHAR(50)
)
BEGIN
	SELECT docente.id_docente, docente.fid_tipo_docente, tipo_docente.descripcion, docente.codigo_PUCP, docente.nombre, docente.apellido_paterno, docente.tipo_documento, docente.numero_documento, docente.maximo_grado_alcanzado, docente_pucp.categoria, filiacion.id_filiacion, filiacion.nombre as nombre_filiacion, filiacion.siglas, docente_extranjero.domina_espanhol, docente_extranjero.domina_ingles, docente_extranjero.grado_revalidado_SUNEDU FROM docente LEFT JOIN docente_extranjero ON docente.id_docente = docente_extranjero.id_docente_extranjero LEFT JOIN docente_pucp ON docente.id_docente = docente_pucp.id_docente_pucp LEFT JOIN filiacion ON docente_extranjero.fid_filiacion = filiacion.id_filiacion INNER JOIN tipo_docente ON docente.fid_tipo_docente = tipo_docente.id_tipo_docente WHERE (docente_extranjero.activo = 1 OR docente_pucp.activo = 1) AND ((CONCAT(docente.nombre,' ',docente.apellido_paterno) LIKE CONCAT('%',_nombreCodigo,'%')) OR (docente.codigo_PUCP LIKE CONCAT('%',_nombreCodigo,'%')));
END$
CREATE PROCEDURE LISTAR_CURSOS_POR_NOMBRE_O_CLAVE(
	IN _nombreClave VARCHAR(100)
)
BEGIN
	SELECT curso.id_curso, curso.fid_especialidad, especialidad.nombre as nombre_especialidad, curso.nombre, curso.clave, curso.semestre, curso.modalidad, curso.req_computadora, curso.req_disp_movil, curso.req_disp_especial, curso.sumilla, curso.foto, curso.silabo FROM curso INNER JOIN especialidad ON curso.fid_especialidad = especialidad.id_especialidad WHERE curso.activo = 1 AND ((curso.nombre LIKE CONCAT('%',_nombreClave,'%')) OR (curso.clave LIKE CONCAT('%',_nombreClave,'%')));
END$
CREATE PROCEDURE LISTAR_DOCENTES_POR_ID_CURSO(
	IN _id_curso INT
)
BEGIN
	SELECT docente.id_docente, docente.fid_tipo_docente, tipo_docente.descripcion, docente.codigo_PUCP, docente.nombre, docente.apellido_paterno, docente.tipo_documento, docente.numero_documento, docente.maximo_grado_alcanzado, docente_pucp.categoria, filiacion.id_filiacion, filiacion.nombre as nombre_filiacion, filiacion.siglas, docente_extranjero.domina_espanhol, docente_extranjero.domina_ingles, docente_extranjero.grado_revalidado_SUNEDU FROM docente LEFT JOIN docente_extranjero ON docente.id_docente = docente_extranjero.id_docente_extranjero LEFT JOIN docente_pucp ON docente.id_docente = docente_pucp.id_docente_pucp LEFT JOIN filiacion ON docente_extranjero.fid_filiacion = filiacion.id_filiacion INNER JOIN tipo_docente ON docente.fid_tipo_docente = tipo_docente.id_tipo_docente INNER JOIN curso_docente ON curso_docente.fid_docente = docente.id_docente WHERE curso_docente.fid_curso = _id_curso and curso_docente.activo = 1;
END$