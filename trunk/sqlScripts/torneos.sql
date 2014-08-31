-- id | version | club_id | estado | 
-- fecha_alta | fecha_fin_inscripcion | fecha_fin_torneo | fecha_inicio_inscripcion | fecha_inicio_torneo | 
-- nombre  | puntuable | torneo_puntuable_id
insert into torneo values (1,1,null,"Creado","2014-08-01","2014-08-30","2014-09-30","2014-08-15","2014-08-31","Torneo 1", false,null);
insert into torneo values (2,1,null,"Creado","2014-10-01","2014-10-30","2014-11-30","2014-10-15","2014-10-31","Torneo 2", false,null);
insert into torneo values (3,1,null,"Creado","2014-06-01","2014-06-30","2014-07-30","2014-06-15","2014-06-30","Torneo 3", false,null);

insert into torneo (id,version,club_id,estado,nombre,puntuable,torneo_puntuable_id,
fecha_alta,fecha_inicio_inscripcion,fecha_fin_inscripcion,fecha_inicio_torneo,fecha_fin_torneo)
values (4,1,null,"Creado","Torneo 4", false,null,"2014-01-01","2014-12-01","2014-12-10","2014-12-11","2014-12-30");
insert into torneo (id,version,club_id,estado,nombre,puntuable,torneo_puntuable_id,
fecha_alta,fecha_inicio_inscripcion,fecha_fin_inscripcion,fecha_inicio_torneo,fecha_fin_torneo)
values (5,1,null,"Creado","Torneo 5", false,null,"2014-01-01","2014-12-01","2014-12-10","2014-12-11","2014-12-30");
insert into torneo (id,version,club_id,estado,nombre,puntuable,torneo_puntuable_id,
fecha_alta,fecha_inicio_inscripcion,fecha_fin_inscripcion,fecha_inicio_torneo,fecha_fin_torneo)
values (6,1,null,"Creado","Torneo 6", false,null,"2014-01-01","2014-12-01","2014-12-10","2014-12-11","2014-12-30");