SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `Usuario`;
DROP TABLE IF EXISTS `Parametro`;
DROP TABLE IF EXISTS `TipoTarjeta`;
DROP TABLE IF EXISTS `Tarjeta`;
DROP TABLE IF EXISTS `Cuota`;
DROP TABLE IF EXISTS `Tea`;
DROP TABLE IF EXISTS `DiaDePago`;
DROP TABLE IF EXISTS `Simulacion`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `Usuario` (
    `usuario_id` INTEGER NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(60) NOT NULL,
    `apellido` VARCHAR(40) NOT NULL,
    `dni` VARCHAR(8) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY (`usuario_id`),
    UNIQUE (`email`)
);

CREATE TABLE `Parametro` (
    `parametro_id` INTEGER NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(40) NOT NULL,
    `valor` VARCHAR(60) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY (`parametro_id`)
);

CREATE TABLE `TipoTarjeta` (
    `tipo_tarjeta_id` VARCHAR(5) NOT NULL,
    `nombre` VARCHAR(60) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY (`tipo_tarjeta_id`),
    UNIQUE (`nombre`)
);

CREATE TABLE `Tarjeta` (
    `tarjeta_id` INTEGER NOT NULL AUTO_INCREMENT,
    `tipo_tarjeta_id` VARCHAR(5) NOT NULL,
    `numero` VARCHAR(20) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY (`tarjeta_id`),
    UNIQUE (`numero`)
);

CREATE TABLE `Cuota` (
    `cuota_id` VARCHAR(5) NOT NULL,
    `valor` INTEGER NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY (`cuota_id`)
);

CREATE TABLE `Tea` (
    `tea_id` VARCHAR(5) NOT NULL,
    `valor` DECIMAL NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY (`tea_id`)
);

CREATE TABLE `DiaDePago` (
    `dia_de_pago_id` VARCHAR(5) NOT NULL,
    `valor` INTEGER NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY (`dia_de_pago_id`)
);

CREATE TABLE `Simulacion` (
    `simulacion_id` INTEGER NOT NULL AUTO_INCREMENT,
    `dni` VARCHAR(8) NOT NULL,
    `tipo_tarjeta` VARCHAR(60) NOT NULL,
    `moneda` VARCHAR(60) NOT NULL,
    `monto` DECIMAL NOT NULL,
    `cantidad_cuotas` INTEGER NOT NULL,
    `tea` DECIMAL NOT NULL,
    `dia_pago` INTEGER NOT NULL,
    `fecha_creacion` TIMESTAMP NOT NULL,
    `estado` VARCHAR(60) NOT NULL,

    `monto_cuota` DECIMAL,
    `fecha_primera_cuota` TIMESTAMP,

--    `usuario_id` INTEGER,
--    `tipo_tarjeta_id` VARCHAR(5),

    `observaciones` VARCHAR(200),
    `is_active` BOOLEAN NOT NULL,

    PRIMARY KEY (`simulacion_id`)
);

ALTER TABLE `Tarjeta` ADD FOREIGN KEY (`tipo_tarjeta_id`) REFERENCES `TipoTarjeta`(`tipo_tarjeta_id`);
--ALTER TABLE `Simulador` ADD FOREIGN KEY (`usuario_id`) REFERENCES `Usuario`(`usuario_id`);
--ALTER TABLE `Simulador` ADD FOREIGN KEY (`tarjeta_id`) REFERENCES `Tarjeta`(`tarjeta_id`);
