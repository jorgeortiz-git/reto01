-- init load table person
INSERT INTO Usuario(usuario_id, nombre, apellido, dni, email, is_active) VALUES (1, 'Jorge', 'Ortiz', '45678901', 'correo@dominio.com', true);
INSERT INTO Usuario(usuario_id, nombre, apellido, dni, email, is_active) VALUES (2, 'Marcia', 'Alcantara', '12345678', 'otrocorreo@dominio.com', true);
INSERT INTO Usuario(usuario_id, nombre, apellido, dni, email, is_active) VALUES (3, 'Pepe', 'Vargas', '98765432', 'pepevargas@dominio.com', true);

INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (1, 'TipoTarjeta', 'Clasica' , true );
INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (2, 'TipoTarjeta', 'Oro' , true );
INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (3, 'TipoTarjeta', 'Black' , true );

INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (4, 'Cuota', '1' , true );
INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (5, 'Cuota', '36' , true );

INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (6, 'TEA', '90.90' , true );
INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (7, 'TEA', '95.90' , true );
INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (8, 'TEA', '99.90' , true );

INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (9, 'DiaDePago', '5' , true );
INSERT INTO Parametro(parametro_id, nombre, valor, is_active) VALUES (10, 'DiaDePago', '20' , true );

INSERT INTO TipoTarjeta(tipo_tarjeta_id, nombre, is_active) VALUES ('TT001','Clasica', true );
INSERT INTO TipoTarjeta(tipo_tarjeta_id, nombre, is_active) VALUES ('TT002','Oro', true );
INSERT INTO TipoTarjeta(tipo_tarjeta_id, nombre, is_active) VALUES ('TT003','Black', true );

INSERT INTO Cuota(cuota_id, valor, is_active) VALUES ('C0001', 1 , true );
INSERT INTO Cuota(cuota_id, valor, is_active) VALUES ('C0002', 36 , true );

INSERT INTO Tea(tea_id, valor, is_active) VALUES ('T0001', 90.90 , true );
INSERT INTO Tea(tea_id, valor, is_active) VALUES ('T0002', 95.90 , true );
INSERT INTO Tea(tea_id, valor, is_active) VALUES ('T0003', 99.90 , true );

INSERT INTO DiaDePago(dia_de_pago_id, valor, is_active) VALUES ('DP001', 5 , true );
INSERT INTO DiaDePago(dia_de_pago_id, valor, is_active) VALUES ('DP002', 20 , true );