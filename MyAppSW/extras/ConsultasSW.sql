CREATE DATABASE dbsw2022;
USE dbsw2022;

CREATE TABLE cliente(
	cod_cliente INT PRIMARY KEY AUTO_INCREMENT,
	nombre_cliente VARCHAR(45) NOT NULL,
	apellido_cliente VARCHAR(45) NOT NULL,
	correo_cliente VARCHAR(65) NOT NULL,
	fecha_nacimiento_cliente DATE NOT NULL,
	limite_credito_cliente DOUBLE(6,2) NOT NULL
);

SELECT * FROM cliente;
TRUNCATE cliente;