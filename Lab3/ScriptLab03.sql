DROP TABLE IF EXISTS biblioteca;
CREATE TABLE biblioteca(
	id_biblioteca INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    hora_apertura TIME NOT NULL,
    hora_cierre TIME NOT NULL,
    ubicada_en_campus TINYINT NOT NULL,
    activa TINYINT NOT NULL
)ENGINE=InnoDB;
INSERT INTO biblioteca(nombre,hora_apertura,hora_cierre,ubicada_en_campus,activa) VALUES('Biblioteca del Complejo de Innovación Académica','08:00:00','20:00:00',1,1);
INSERT INTO biblioteca(nombre,hora_apertura,hora_cierre,ubicada_en_campus,activa) VALUES('Biblioteca del Instituto Confucio','10:00:00','17:00:00',0,1);