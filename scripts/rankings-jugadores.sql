/* REQUERIDOS: JUGADORES */

/* Ranking para jugadores de categoria A - Damas */
insert into ranking (id,version,jugador_id,categoria_id,puesto,puntaje) values
(1,1,1,1,1,1000),
(2,1,2,1,2, 900),
(3,1,3,1,3, 800),
(4,1,4,1,4, 700),
(5,1,5,1,5, 600),
(6,1,6,1,6, 500),
(7,1,7,1,7, 400);

/* Ranking para jugadores de categoria 1 (Primera) */
insert into ranking (id,version,jugador_id,categoria_id,puesto,puntaje) values
(1,1,1,1,1,1000),
(2,1,2,1,2, 900),
(3,1,3,1,3, 800),
(4,1,4,1,4, 700),
(5,1,5,1,5, 600),
(6,1,6,1,6, 500),
(7,1,7,1,7, 400);
/* Ranking para jugadores de categoria 2 (Segunda): 7 Jugadores, pero solo 4 rankeados */
insert into ranking (id,version,jugador_id,categoria_id,puesto,puntaje) values
(8, 1,8, 2,1,1000),
(9, 1,9, 2,2, 800),
(10,1,10,2,3, 600),
(11,1,11,2,4, 400);

/* Ranking para jugadores de categoria 3 (Tercera): Solo 6 en Tercera actualmente y 20 rankeados en tercera */
/* inicio - jugadores en tercera */
insert into ranking (id,version,jugador_id,categoria_id,puesto,puntaje) values
(12,1,15,3 ,1,1000),
(13,1,16,3 ,2, 950),
(14,1,17,3 ,3, 900),
(15,1,18,3 ,4, 850),
(16,1,19,3 ,5, 800),
(17,1,20,3 ,6, 750);
/* inicio - jugadores de primera rankeados en tercera */
insert into ranking (id,version,jugador_id,categoria_id,puesto,puntaje) values
/*(18,1,1 ,3 ,7, 650),
(19,1,2 ,3 ,8, 600),
(20,1,3 ,3 ,9, 550),
(21,1,4 ,3 ,10, 500),*/
(22,1,5 ,3 ,11, 450),
(23,1,6 ,3 ,12, 400),
(24,1,7 ,3 ,13, 350);
/* inicio - jugadores de segunda rankeados en tercera */
insert into ranking (id,version,jugador_id,categoria_id,puesto,puntaje) values
(25,1,8 ,3 ,14, 300),
(26,1,9 ,3 ,15, 250),
(27,1,10,3 ,16, 200),
(28,1,11,3 ,17, 150),
(29,1,12,3 ,18, 100),
(30,1,13,3 ,19,  50),
(31,1,14,3 ,20,  20);