/* Roles de usuario */
insert into rol (id,version,nombre) values 
(1,1,'Jugador'),
(2,1,'Administrador'),
(3,1,'Club'),
(4,1,'Encargado club'),
(5,1,'Anonimo');

/* Jugadores */
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(1,1,true,'heraldov','player','heraldovalenti@gmail.com',1,null,null,null),
(2,1,true,'guillef','player','guille.fank@gmail.com',1,null,null,null),
(3,1,true,'matidc','player','matidc.89@gmail.com',1,null,null,null),
(4,1,true,'davidc','player','didcoppa@gmail.com',1,null,null,null),
(5,1,true,'brendam','player','brendaamolinari@gmail.com',1,null,null,null),
(6,1,true,'lucilav','player','lupitavalenti@hotmail.com',1,null,null,null);

/* Clubes */
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(7, 1,true,'bocajr','manager','info@boca.com',3,null,null,null),
(8, 1,true,'quality','manager','info@quality.com.ar',3,null,null,null),
(9, 1,true,'bucorr','manager','info@bucor.com.ar',3,null,null,null),
(10,1,true,'talleres','manager','info@talleres.com',3,null,null,null);
/* Administrador */
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(11, 1,true,'admin','admin','admin@acsr.com.ar',2,null,null,null);
/* Nuevos usuarios*/
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(12,1,true,'pedrogon','player','pedrogonzalez@hotmail.com',1,null,null,null),
(13,1,true,'marcoantun','player','marco_antunez@hotmail.com',1,null,null,null),
(14,1,true,'ramiernesto','player','ramirez_ernersto@gmail.com',1,null,null,null),
(15,1,true,'jorguitostefo','player','stefojorge@gmail.com',1,null,null,null),
(16,1,true,'marquesito','player','oscar_marquesin@hotmail.com',1,null,null,null),
(17,1,true,'juanpier','player','juanpierletti@hotmail.com',1,null,null,null),
(18,1,true,'albertirsh','player','alberto_irsh@hotmail.com',1,null,null,null),
(19,1,true,'jorgecaser','player','casermeiro_jorge@gmail.com',1,null,null,null),
(20,1,true,'fleitosv','player','olval_fleitas@gmail.com',1,null,null,null),
(21,1,true,'lozanodan','player','dani_lozano@hotmail.com',1,null,null,null),
(22,1,true,'philike','player','kevin_philips@gmail.com',1,null,null,null),
(23,1,true,'flaper','player','peralta_falvio@gmail.com',1,null,null,null),
(24,1,true,'ferrvic','player','ferreira_victor@gmail.com',1,null,null,null),
(25,1,true,'berstivan','player','ivan_berst@hotmail.com',1,null,null,null),
(26,1,true,'bladimir','player','flores_blad@gmail.com',1,null,null,null),
(27,1,true,'mamaugus','player','augus_mamani@gmail.com',1,null,null,null);