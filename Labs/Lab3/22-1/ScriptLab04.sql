DROP TABLE IF EXISTS servicio;
DROP TABLE IF EXISTS estado_servicio;
CREATE TABLE estado_servicio(
	id_estado_servicio CHAR PRIMARY KEY,
    descripcion VARCHAR(300)
)ENGINE=innodb;
CREATE TABLE servicio(
	id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion VARCHAR(300),
    costo DECIMAL(10,2),
    relevancia INT,
    fecha DATE,
    estado CHAR,
    FOREIGN KEY (estado) REFERENCES estado_servicio(id_estado_servicio)
)ENGINE=innodb;
INSERT INTO estado_servicio(id_estado_servicio,descripcion) VALUES('P','Pendiente');
INSERT INTO estado_servicio(id_estado_servicio,descripcion) VALUES('D','En Desarrollo');
INSERT INTO estado_servicio(id_estado_servicio,descripcion) VALUES('F','Finalizado');