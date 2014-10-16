/* REQUERIDOS: CATEGORIAS, EJEMPLOS-USUARIOS */
insert into jugador (id,version,peso,juega_desde,imagen_id,disponibilidad_id,brazo,altura) values
(1,1,72.0,'1995-01-01',null,null,'Derecho',169.0),
(2,1,78.0,'2002-01-01',null,null,'Izquierdo',185.0),
(3,1,85.0,'1999-01-01',null,null,'Ambidiestro',180.0),
(4,1,70,'2008-01-01',null,null,'Izquierdo',172.0);
update usuario set jugador_id = 1 where id = 1;
update usuario set jugador_id = 2 where id = 2;
update usuario set jugador_id = 3 where id = 3;
update usuario set jugador_id = 4 where id = 4;

insert into persona (id,version,nombre,apellido,sexo,fecha_nacimiento) values
(1,1,'Valenti','Heraldo Raul','Masculino','1989-08-22'),
(2,1,'Fank','Guillermo','Masculino','1990-03-03'),
(3,1,'Del Carlo','Matias','Masculino','1989-07-19'),
(4,1,'Coppa','David','Masculino','1989-01-01');
update usuario set persona_id = 1 where id = 1;
update usuario set persona_id = 2 where id = 2;
update usuario set persona_id = 3 where id = 3;
update usuario set persona_id = 4 where id = 4;

insert into categoria_jugador (id,version,jugador_id,categoria_id,fecha_inicio,fecha_fin,estado,descripcion) values
(1,1,1,1,'2000-01-01',null,'Asignada','categoria de jugador heraldov'),
(2,1,2,2,'2000-01-01',null,'Asignada','categoria de jugador guillef'),
(3,1,3,3,'2000-01-01',null,'Asignada','categoria de jugador matidc'),
(4,1,4,3,'2000-01-01',null,'Asignada','categoria de jugador davidc');