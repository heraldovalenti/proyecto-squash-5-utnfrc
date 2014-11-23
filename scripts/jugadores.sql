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
(20,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(21,1,82.3,'2001-10-16',null,null,'Derecho',179.0),
(22,1,82.3,'2001-10-16',null,null,'Derecho',179.0),
(23,1,82.3,'2001-10-16',null,null,'Derecho',179.0),
(24,1,82.3,'2001-10-16',null,null,'Derecho',179.0),
(25,1,82.3,'2001-10-16',null,null,'Derecho',179.0),
(26,1,82.3,'2001-10-16',null,null,'Derecho',179.0),
(27,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(28,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(29,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(30,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(31,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(32,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(33,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(34,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(35,1,82.3,'2000-10-10',null,null,'Derecho',179.0),
(36,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(37,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(38,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(39,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(40,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(41,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(42,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(43,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(44,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(45,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(46,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(47,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(48,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(49,1,82.3,'1995-01-10',null,null,'Derecho',179.0),
(50,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(51,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(52,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(53,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(54,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(55,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(56,1,82.3,'2001-08-17',null,null,'Derecho',179.0),
(57,1,82.3,'2001-08-17',null,null,'Derecho',179.0);		

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
update usuario set jugador_id = 21 where id = 28;
update usuario set jugador_id = 22 where id = 29;
update usuario set jugador_id = 23 where id = 30;
update usuario set jugador_id = 24 where id = 31;
update usuario set jugador_id = 25 where id = 32;
update usuario set jugador_id = 26 where id = 33;
update usuario set jugador_id = 27 where id = 34;
update usuario set jugador_id = 28 where id = 35;
update usuario set jugador_id = 29 where id = 36;
update usuario set jugador_id = 30 where id = 37;
update usuario set jugador_id = 31 where id = 38;
update usuario set jugador_id = 32 where id = 39;
update usuario set jugador_id = 33 where id = 40;
update usuario set jugador_id = 34 where id = 41;
update usuario set jugador_id = 35 where id = 42;
update usuario set jugador_id = 36 where id = 43;
update usuario set jugador_id = 37 where id = 44;
update usuario set jugador_id = 38 where id = 45;
update usuario set jugador_id = 39 where id = 46;
update usuario set jugador_id = 40 where id = 47;
update usuario set jugador_id = 41 where id = 48;
update usuario set jugador_id = 42 where id = 49;
update usuario set jugador_id = 43 where id = 50;
update usuario set jugador_id = 44 where id = 51;
update usuario set jugador_id = 45 where id = 52;
update usuario set jugador_id = 46 where id = 53;
update usuario set jugador_id = 47 where id = 54;
update usuario set jugador_id = 48 where id = 55;
update usuario set jugador_id = 49 where id = 56;
update usuario set jugador_id = 50 where id = 57;
update usuario set jugador_id = 51 where id = 58;
update usuario set jugador_id = 52 where id = 59;
update usuario set jugador_id = 53 where id = 60;
update usuario set jugador_id = 54 where id = 61;
update usuario set jugador_id = 55 where id = 62;
update usuario set jugador_id = 56 where id = 63;
update usuario set jugador_id = 57 where id = 64;


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
(20,1,'Augusto','Mamani','Masculino','1993-03-23'),
(21,1,'Julian','Peker','Masculino','1993-03-23'),
(22,1,'Daniel','Chumasero','Masculino','1993-03-23'),
(23,1,'Horacio','Montalvetti','Masculino','1993-03-23'),
(24,1,'Gonzalo','Oviedo','Masculino','1993-03-23'),
(25,1,'Pablo','Ramirez','Masculino','1993-03-23'),
(26,1,'Pablo','Lerda','Masculino','1993-03-23'),
(27,1,'Mateo','Giomi','Masculino','1993-03-23'),
(28,1,'Gaston','Torregiani','Masculino','1993-03-23'),
(29,1,'Claudio','Belen','Masculino','1993-03-23'),
(30,1,'Claudio','Montaldo','Masculino','1993-03-23'),
(31,1,'Nicolas','Besso','Masculino','1993-03-23'),
(32,1,'Gerardo','Principi','Masculino','1993-03-23'),
(33,1,'Lionel','Messi','Masculino','1993-03-23'),
(34,1,'Diego','Armando','Masculino','1993-03-23'),
(35,1,'Diego','Elias','Masculino','1993-03-23'),--42
(36,1,'Ayrton','Pagotti','Masculino','1993-03-23'),
(37,1,'Juan','Perez','Masculino','1993-03-23'),
(38,1,'Ernesto','Martinez','Masculino','1993-03-23'),
(39,1,'Juan','Carlos','Masculino','1993-03-23'),
(40,1,'Humberto','Francia','Masculino','1993-03-23'),
(41,1,'Miguel','Urca','Masculino','1993-03-23'),
(42,1,'Pablo','Santalucia','Masculino','1993-03-23'),
(43,1,'Daniel','Gomez','Masculino','1993-03-23'),
(44,1,'Sebastian','Bustos','Masculino','1993-03-23'),
(45,1,'Sebastian','Villena','Masculino','1993-03-23'),
(46,1,'Carlos','Vertonni','Masculino','1993-03-23'),
(47,1,'Gaston','Alonzo','Masculino','1993-03-23'),
(48,1,'Diego','Murua','Masculino','1993-03-23'),
(49,1,'Yan','Nekola','Masculino','1993-03-23'),
(50,1,'Tomas','Juncos','Masculino','1993-03-23'),
(51,1,'Tomas','Estevez','Masculino','1993-03-23'),
(52,1,'Daniel','Orpianessi','Masculino','1993-03-23'),
(53,1,'Pedro','Juan','Masculino','1993-03-23'),
(54,1,'Emiliano','Giraudo','Masculino','1993-03-23');



update usuario set persona_id = 1 where id = 1;
update usuario set persona_id = 2 where id = 2;
update usuario set persona_id = 3 where id = 3;
update usuario set persona_id = 4 where id = 4;
update usuario set persona_id = 5 where id = 5;
update usuario set persona_id = 6 where id = 6;
update usuario set persona_id = 7 where id = 12;
update usuario set persona_id = 8 where id = 13;
update usuario set persona_id = 9 where id = 14;
update usuario set persona_id = 10 where id = 15;
update usuario set persona_id = 11 where id = 16;
update usuario set persona_id = 12 where id = 17;
update usuario set persona_id = 13 where id = 18;
update usuario set persona_id = 14 where id = 19;
update usuario set persona_id = 15 where id = 20;
update usuario set persona_id = 16 where id = 21;
update usuario set persona_id = 17 where id = 22;
update usuario set persona_id = 18 where id = 23;
update usuario set persona_id = 19 where id = 24;
update usuario set persona_id = 20 where id = 25;
update usuario set persona_id = 21 where id = 26;
update usuario set persona_id = 22 where id = 27;
update usuario set persona_id = 23 where id = 28;
update usuario set persona_id = 24 where id = 29;
update usuario set persona_id = 25 where id = 30;
update usuario set persona_id = 26 where id = 31;
update usuario set persona_id = 27 where id = 32;
update usuario set persona_id = 28 where id = 33;
update usuario set persona_id = 29 where id = 34;
update usuario set persona_id = 30 where id = 35;
update usuario set persona_id = 31 where id = 36;
update usuario set persona_id = 32 where id = 37;
update usuario set persona_id = 33 where id = 38;
update usuario set persona_id = 34 where id = 39;
update usuario set persona_id = 35 where id = 40;
update usuario set persona_id = 36 where id = 41;
update usuario set persona_id = 37 where id = 42;
update usuario set persona_id = 38 where id = 43;
update usuario set persona_id = 39 where id = 44;
update usuario set persona_id = 40 where id = 45;
update usuario set persona_id = 41 where id = 46;
update usuario set persona_id = 42 where id = 47;
update usuario set persona_id = 43 where id = 48;
update usuario set persona_id = 44 where id = 49;
update usuario set persona_id = 45 where id = 50;
update usuario set persona_id = 46 where id = 51;
update usuario set persona_id = 47 where id = 52;
update usuario set persona_id = 48 where id = 53;
update usuario set persona_id = 49 where id = 54;


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
(57,1,20,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(58,1,8,1,'2000-01-01',null,'Asignada','categoria de jugador'),
(59,1,9,1,'2000-01-01',null,'Asignada','categoria de jugador'),
(20,1,21,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(21,1,22,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(22,1,23,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(23,1,24,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(24,1,25,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(25,1,26,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(26,1,27,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(27,1,28,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(28,1,29,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(29,1,30,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(30,1,31,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(31,1,32,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(32,1,33,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(33,1,34,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(34,1,35,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(35,1,36,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(36,1,37,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(37,1,38,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(38,1,39,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(39,1,40,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(40,1,41,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(41,1,42,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(42,1,43,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(43,1,44,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(44,1,45,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(45,1,46,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(46,1,47,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(47,1,48,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(48,1,49,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(49,1,50,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(50,1,51,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(51,1,52,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(52,1,53,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(53,1,54,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(54,1,55,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(55,1,56,3,'2000-01-01',null,'Asignada','categoria de jugador'),
(56,1,57,3,'2000-01-01',null,'Asignada','categoria de jugador');