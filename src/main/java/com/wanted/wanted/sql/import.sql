/*
-- Insertar Roles
INSERT INTO super_roles (nombre, descripcion) VALUES ('ROLE_USER', NULL);


INSERT INTO super_roles (nombre, descripcion) VALUES ('ROLE_ADMIN', NULL);

-- Insertar Usuarios (con contraseñas codificadas)
INSERT INTO usuario (username, email, password, fecha_alta)
VALUES ('user', 'user@wanted.es', 'user', NOW());

INSERT INTO usuario (username, email, password, fecha_alta)
VALUES ('admin', 'admin@wanted.es', 'admin', NOW());

-- Obtener IDs de Roles
-- Supongamos que los IDs son 1 para ROLE_USER y 2 para ROLE_ADMIN

-- Obtener IDs de Usuarios
-- Supongamos que los IDs son 1 para user y 2 para admin

-- Insertar Relaciones en rol_perfil
INSERT INTO rol_perfil (registar_id, rol_id) VALUES (1, 1); -- user tiene ROLE_USER
INSERT INTO rol_perfil (registar_id, rol_id) VALUES (2, 1); -- admin tiene ROLE_USER
INSERT INTO rol_perfil (registar_id, rol_id) VALUES (2, 2); -- admin tiene ROLE_ADMIN





INSERT INTO tipo_arco  (id, nombre) VALUES (1, 'Wano');

INSERT INTO tipo_arco (id, nombre) VALUES (2, 'Marinforce');

INSERT INTO tipo_arco (id, nombre) VALUES (3, 'Dressrosa');

INSERT INTO tipo_arco (id, nombre) VALUES (4, 'Namek');

INSERT INTO tipo_arco (id, nombre) VALUES (5, 'Tierra');

INSERT INTO tipo_arco (id, nombre) VALUES (6, 'Villa oculta de la Hoja');



INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (1, '/imagen/fotosLista/luffy.jpg', 'Luffy', 'Esta es una figura de luffy cuando estaba en wano. El ancho es de 10 cm y de largo es 20 cm ', 1, 1, 'one-piece', '2022-10-10', 80);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (2, '/imagen/fotosLista/zoro.jpg', 'Zoro', 'Esta es una figura de Zoro en wano. El ancho es 10 cm de alto y de largo son 70 cm.', 2, 2, 'one-piece', '2020-10-10', 65);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (3, '/imagen/fotosLista/brook1.jpg', 'Brook', 'Esta es una figura de Brook en su lucha de Bif Mom. El ancho es 15 cm de alto y de largo son 50 cm.', 2, 0, 'one-piece', '2023-10-22', 100);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (4, '/imagen/fotosLista/goku.jpg', 'Goku', 'Esta es la figura de Goku en su lucha contra el malvado Freezer. El ancho es 12 cm de alto y de largo son 60 cm.', 3, 1, 'dragon-ball', '2022-08-02', 100);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (5, '/imagen/fotosLista/vegeta.jpg', 'Vegeta', 'Esta es una figura de vegeta herido despues de su pelea en Namek. El ancho es 10 cm de alto y de largo son 45 cm.', 3, 5, 'dragon-ball', '2014-12-22', 30);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (6, '/imagen/fotosLista/freezer.jpg', 'Freezer', 'Esta es una figura de Freezer en Namek. El ancho es 10 cm de alto y de largo son 70 cm.', 3, 2, 'dragon-ball', '2015-02-02', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (7, '/imagen/fotosLista/piccolo.jpg', 'Piccolo', 'Esta es una figura de Piccolo en Namek. El ancho es 11.5 cm de alto y de largo son 300 cm.', 3, 10, 'dragon-ball', '2011-11-16', 20);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (8, '/imagen/fotosLista/sasuke.jpg', 'Sasuke', 'Esta es una figura de sasuke en la villa oculta de la hoja de pequeño. El ancho es 10.5 cm de alto y de largo son 200cm.', 5, 5, 'naruto', '2014-05-08', 30);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (9, '/imagen/fotosLista/naruto.jpg', 'Naruto', 'Esta es una figura de naruto en la villa oculta de la hoja de pequeño, El ancho es 10.5 cm de alto y de largo son 200cm.', 5, 2, 'naruto', '2010-10-10', 30);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (10, '/imagen/fotosLista/narutoM.jpg', 'Naruto', 'Esta es una figura de naruto en la villa oculta de la hoja de mayor, El ancho es 10.5 cm de alto y de largo son 200cm.', 5, 3, 'naruto', '2011-06-14', 35);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (11, '/imagen/fotosLista/gohan.jpg', 'Gohan', 'Gohan modo bestia en la tierra su despertar Bakai. El ancho es 11 cm y de largo son 150 cm ', 4, 2, 'novedad', '2006-05-10', 150);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (12, '/imagen/fotosLista/narutoSabio.jpg', 'Naruto', 'Naruto pelea contra Pain Modo sabio 20 cm de alto y de largo 200cm', 5, 2, 'naruto', '2004-08-12', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (13, '/imagen/fotosNovedad/pain.jpeg', 'Pain', 'Pain pelea contra Naruto Modo sabio 20 cm de alto y de largo 200cm', 5, 3, 'novedad', '2018-11-26', 45);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (14, '/imagen/fotosNovedad/sora.jpg', 'Sora', 'figura de Sora de Kingdom Hearts con llave Espada de agua.El ancho es de 13 cm y de largo son 17 cm   ', 5, 2, 'novedad', '2020-11-26', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (15, '/imagen/fotosNovedad/roxas.jpg', 'Roxas', 'Roxas de Kingdom Hearts cuando estaba en la Organization XIII . El ancho 20 cm de alto y de largo 35 cm', 5, 1, 'novedad', '2018-11-26', 65);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (16, '/imagen/fotosNovedad/axel.jpg', 'Axel', 'Axel modo pelea en la gran guerra de entre la luz y la oscuridad. El ancho 20 cm y de largo 20cm', 5, 0, 'novedad', '2019-11-26', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (17, '/imagen/fotosNovedad/rimuru.jpg', 'Rimuru', 'Rimuru acto del rey antes de la pelea con Escanor. El ancho 20 cm  y de largo 15 cm', 5, 1, 'novedad', '2021-11-26', 36);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (18, '/imagen/fotosOnePiece/luffySombrero.jpg', 'Luffy', 'Luffy en la batalla contra kaido despues de dar la cara ante los yonkous. El ancho  30 cm  y de largo 12 cm', 1, 0, 'one-piece', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (19, '/imagen/fotosOnePiece/shanks.jpg', 'Shanks', 'Shanks entregando el sombre a luffi antes de partida. El ancho es de  20 cm y de largo 20 cm', 5, 1, 'one-piece', '2021-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (20, '/imagen/fotosOnePiece/ace.jpg', 'Ace', 'Ace puño de fuego miembro de la tripulacion de barba blanca. El ancho es de  10 cm  y de largo 30 cm', 5, 2, 'one-piece', '2014-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (21, '/imagen/fotosOnePiece/choper.jpg', 'Chopper', 'Chopper miembro de la tripulación de sombrero de paja. El ancho es de   20 cm  y de largo 7 cm', 5, 1, 'one-piece', '2014-11-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (22, '/imagen/fotosOnePiece/trio.jpg', 'Zoro, Sanji, Luffi ', 'Los tres mas famosos del easy blue. El ancho es de  20 cm  y de largo 20 cm', 5, 2, 'one-piece', '2021-10-12', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (23, '/imagen/fotosOnePiece/zoro1.jpg', 'Zoro', 'Zoro estilo tres espadas activando el Bankai. El ancho es de  20 cm  y de largo 20 cm', 5, 0, 'one-piece', '2024-10-22', 55);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (24, '/imagen/fotosOnePiece/nami.jpg', 'Nami', 'Nami miembro de los sombrero de paja navegante. El ancho es de   20 cm  y de largo 20 cm', 5, 0, 'one-piece', '2024-12-20', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (25, '/imagen/fotosOnePiece/zoro2.jpg', 'Zoro', 'Zoro afilando la cata es la tierra de Wano. El ancho es de   20 cm  y de largo 10 cm', 5, 0, 'one-piece', '2023-10-20', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (26, '/imagen/fotosOnePiece/law.jpg', 'Law', 'Law en Wano llendo de camuflaje para no ser descubierto. El ancho es de 10 cm  y de largo 25cm', 5, 1, 'one-piece', '2023-09-20', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (27, '/imagen/fotosOnePiece/sanji.jpg', 'Sanji', 'Sanji antes de la boda roja.El ancho es de 20 cm y de largo 20cm', 5, 2, 'one-piece', '2024-01-22', 60);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (28, '/imagen/fotosOnePiece/luffy1.jpg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'one-piece', '2012-10-01', 25);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (29, '/imagen/fotosOnePiece/barbanegra.jpg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 5, 'one-piece', '2010-09-03', 30);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (30, '/imagen/fotosOnePiece/kaido.jpg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 1, 'one-piece', '2011-07-08', 50);
INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (31, '/imagen/fotosOnePiece/mam.jpg', 'Big Mam', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 2, 'one-piece', '2010-07-17', 40);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (32, '/imagen/fotosOnePiece/sabo.jpg', 'Sabo', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 3, 'one-piece', '2009-11-07', 30);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (33, '/imagen/fotosNaruto/gaara.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 1, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (34, '/imagen/fotosNaruto/naruto1.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (35, '/imagen/fotosNaruto/obito2.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (36, '/imagen/fotosNaruto/itachi.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (37, '/imagen/fotosNaruto/naruto2.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (38, '/imagen/fotosNaruto/pain.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (39, '/imagen/fotosNaruto/kakasi.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (40, '/imagen/fotosNaruto/naruto3.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (41, '/imagen/fotosNaruto/sasuke.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (42, '/imagen/fotosNaruto/madara.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22',50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
 VALUES (43, '/imagen/fotosNaruto/madara1.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (44, '/imagen/fotosNaruto/obito.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (45, '/imagen/fotosNaruto/naruto.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (46, '/imagen/fotosNaruto/obito1.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (47, '/imagen/fotosNaruto/sakura.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja .El ancho es de 20 cm y de largo 20cm', 5, 0, 'naruto', '2024-10-22', 20);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (48, '/imagen/fotosDragonBall/broly.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja. El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (49, '/imagen/fotosDragonBall/gohan3.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (50, '/imagen/fotosDragonBall/vegeta.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (51, '/imagen/fotosDragonBall/broly1.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (52, '/imagen/fotosDragonBall/goku.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (53, '/imagen/fotosDragonBall/vegeta1.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (54, '/imagen/fotosDragonBall/broly2.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (55, '/imagen/fotosDragonBall/goku1.jpeg', 'Obito', 'Obito modo pelea en la gran guerra.El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (56, '/imagen/fotosDragonBall/vegeta2.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);
INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (57, '/imagen/fotosDragonBall/gohan.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (58, '/imagen/fotosDragonBall/goku3.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (59, '/imagen/fotosDragonBall/vegeta3.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (60, '/imagen/fotosDragonBall/gohan1.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (61, '/imagen/fotosDragonBall/goku4.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (62, '/imagen/fotosDragonBall/vegeta4.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (63, '/imagen/fotosDragonBall/gohan2.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (64, '/imagen/fotosDragonBall/goku5.jpeg', 'Obito', 'Obito modo pelea en la gran guerra .El ancho es de 20 cm y de largo 20cm', 5, 0, 'dragon-ball', '2024-10-22', 50);

INSERT INTO figura (id, url, nombre, des, arco_id, stock, categoria, fecha_introducida, precio)
VALUES (65, '/imagen/fotosNaruto/obito2.jpeg', 'Obito', 'Obito modo pelea en la gran guerra ninja 20 cm de alto y de largo 200 cm', 5, 0, 'naruto', '2024-10-22', 50);
*/






