/* Roles de usuario */
insert into rol (id,version,nombre) values 
(1,1,'Jugador'),
(2,1,'Administrador'),
(3,1,'Club');

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
(9, 1,true,'bucor','manager','info@bucor.com.ar',3,null,null,null),
(10,1,true,'talleres','manager','info@talleres.com',3,null,null,null);
/* Administrador */
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(11, 1,true,'admin','admin','admin@acsr.com.ar',2,null,null,null);