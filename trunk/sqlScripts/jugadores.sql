/* REQUERIDOS: CATEGORIAS, EJEMPLOS-USUARIOS */
insert into jugador (id,version,peso,juega_desde,imagen_id,disponibilidad_id,brazo,altura) values
(1,1,72.0,'1995-01-01',null,null,'Derecho',169.0),		/*heraldov*/
(2,1,78.0,'2002-01-01',null,null,'Izquierdo',185.0),	/*matidc*/
(3,1,85.0,'1999-01-01',null,null,'Ambidiestro',180.0),	/*guillef*/
(4,1,70.0,'2008-01-01',null,null,'Izquierdo',172.0),	/*davidc*/
(5,1,90.5,'2008-04-01',null,null,'Izquierdo',190.0),	/*pedrogon*/
(6,1,84.0,'2003-03-01',null,null,'Derecho',184.0),		/*marcoantun*/
(7,1,92.1,'2006-01-04',null,null,'Derecho',189.0),		/*ramiernesto*/
(8,1,81.8,'2004-10-23',null,null,'Derecho',179.0),		/*jorguitostefo*/
(9,1,76.8,'1999-05-09',null,null,'Izquierdo',172.0),	/*marquesito*/
(10,1,89.7,'2001-02-17',null,null,'Derecho',185.0),		/*juanpier*/
(11,1,69.9,'1998-12-15',null,null,'Ambidiestro',170.0),	/*albertirsh*/
(12,1,78.6,'2005-05-12',null,null,'Derecho',175.0),		/*jorgecaser*/
(13,1,77.8,'2002-07-30',null,null,'Derecho',174.0),		/*fleitosv*/
(14,1,83.5,'2007-06-17',null,null,'Izquierdo',180.0),	/*lozanodan*/
(15,1,87.2,'2003-01-18',null,null,'Derecho',181.0),		/*philike*/
(16,1,80.3,'2010-12-18',null,null,'Izquierdo',177.0),	/*flaper*/
(17,1,90.4,'2009-04-16',null,null,'Derecho',186.0),		/*ferrvic*/
(18,1,78.6,'2001-11-10',null,null,'Izquierdo',175.0),	/*berstivan*/
(19,1,86.6,'1999-02-21',null,null,'Derecho',181.0),		/*bladimir*/
(20,1,82.3,'2001-08-17',null,null,'Derecho',179.0);		/*mamaugus*/

update usuario set jugador_id = 1 where id = 1;
update usuario set jugador_id = 2 where id = 2;
update usuario set jugador_id = 3 where id = 3;
update usuario set jugador_id = 4 where id = 4;
update usuario set jugador_id = 5 where id = 12;
update usuario set jugador_id = 6 where id = 13;
update usuario set jugador_id = 7 where id = 14;
update usuario set jugador_id = 8 where id = 15;
update usuario set jugador_id = 9 where id = 16;
update usuario set jugador_id = 10 where id = 17;
update usuario set jugador_id = 11 where id = 18;
update usuario set jugador_id = 12 where id = 19;
update usuario set jugador_id = 13 where id = 20;
update usuario set jugador_id = 14 where id = 21;
update usuario set jugador_id = 15 where id = 22;
update usuario set jugador_id = 16 where id = 23;
update usuario set jugador_id = 17 where id = 24;
update usuario set jugador_id = 18 where id = 25;
update usuario set jugador_id = 19 where id = 26;
update usuario set jugador_id = 20 where id = 27;

insert into persona (id,version,nombre,apellido,sexo,fecha_nacimiento) values
(1,1,'Heraldo Raul','Valenti','Masculino','1989-08-22'),
(2,1,'Guillermo','Fank','Masculino','1990-03-03'),
(3,1,'Matias','Del Carlo','Masculino','1989-07-19'),
(4,1,'Pedro','Gonzalez','Masculino','1978-02-21'),
(5,1,'Marcos','Antunez','Masculino','1985-10-12'),
(6,1,'Ernesto','Ramirez','Masculino','1976-12-09'),
(7,1,'Jorge','Steffolani','Masculino','1969-09-21'),
(8,1,'Oscar','Marquesin','Masculino','1981-04-27'),
(9,1,'Juan','Pierletti','Masculino','1973-07-30'),
(10,1,'Alberto','Irshick','Masculino','1978-11-10'),
(11,1,'Jorge','Casermeiro','Masculino','1987-01-14'),
(12,1,'Osvaldo','Fleitas','Masculino','1978-02-20'),
(13,1,'Daniel','Lozano','Masculino','1990-04-28'),
(14,1,'Alejandro','Weremzuk','Masculino','1990-06-18'),
(15,1,'Kevin','Philips','Masculino','1992-09-11'),
(16,1,'Flavio','Peralta','Masculino','1990-01-10'),
(17,1,'Victor','Ferreira','Masculino','1987-12-29'),
(18,1,'Ivan','Berstein','Masculino','1989-04-11'),
(19,1,'Bladimir','Flores','Masculino','1979-12-01'),
(20,1,'Augusto','Mamani','Masculino','1993-03-23');


update usuario set persona_id = 1 where id = 1;
update usuario set persona_id = 2 where id = 2;
update usuario set persona_id = 3 where id = 3;
update usuario set persona_id = 4 where id = 4;
update usuario set persona_id = 5 where id = 12;
update usuario set persona_id = 6 where id = 13;
update usuario set persona_id = 7 where id = 14;
update usuario set persona_id = 8 where id = 15;
update usuario set persona_id = 9 where id = 16;
update usuario set persona_id = 10 where id = 17;
update usuario set persona_id = 11 where id = 18;
update usuario set persona_id = 12 where id = 19;
update usuario set persona_id = 13 where id = 20;
update usuario set persona_id = 14 where id = 21;
update usuario set persona_id = 15 where id = 22;
update usuario set persona_id = 16 where id = 23;
update usuario set persona_id = 17 where id = 24;
update usuario set persona_id = 18 where id = 25;
update usuario set persona_id = 19 where id = 26;
update usuario set persona_id = 20 where id = 27;


insert into categoria_jugador (id,version,jugador_id,categoria_id,fecha_inicio,fecha_fin,estado,descripcion) values
(1,1,1,1,'2000-01-01',null,'Asignada','categoria de jugador heraldov'),
(2,1,2,1,'2000-01-01',null,'Asignada','categoria de jugador guillef'),
(3,1,3,1,'2000-01-01',null,'Asignada','categoria de jugador matidc'),
(4,1,4,1,'2000-01-01',null,'Asignada','categoria de jugador davidc'),
(5,1,5,1,'2000-01-01',null,'Asignada','categoria de jugador '),
(6,1,6,1,'2000-01-01',null,'Asignada','categoria de jugador'),
(7,1,7,1,'2000-01-01',null,'Asignada','categoria de jugador'),
(8,1,8,2,'2000-01-01',null,'Asignada','categoria de jugador'),
(9,1,9,2,'2000-01-01',null,'Asignada','categoria de jugador'),
(10,1,10,2,'2000-01-01',null,'Asignada','categoria de jugador'),
(11,1,11,2,'2000-01-01',null,'Asignada','categoria de jugador'),
(12,1,12,2,'2000-01-01',null,'Asignada','categoria de jugador'),
(13,1,13,2,'2000-01-01',null,'Asignada','categoria de jugador'),
(14,1,14,2,'2000-01-01',null,'Asignada','categoria de jugador'),
(15,1,15,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(16,1,16,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(17,1,17,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(18,1,18,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(19,1,19,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(20,1,20,3,'2000-01-01',null,'Asignada','categoria de jugador');