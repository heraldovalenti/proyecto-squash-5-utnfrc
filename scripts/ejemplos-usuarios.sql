/* Roles de usuario */
insert into rol (id,version,nombre) values 
(1,1,'Jugador'),
(2,1,'Administrador'),
(3,1,'Club'),
(4,1,'Encargado club'),
(5,1,'Anonimo');

/* Administrador */
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(1000, 1,true,'admin','admin','admin@acsr.com.ar',2,null,null,null);

/* Clubes */
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(100, 1,true,'megasport','manager','info@megasport.com.ar',3,null,null,null),
(101, 1,true,'lafachada','manager','info@lafachada.com.ar',3,null,null,null),
(102, 1,true,'monami','manager','info@monami.com.ar',3,null,null,null),
(103, 1,true,'tancat','manager','info@tancat.com.ar',3,null,null,null),
(104, 1,true,'cordobasquash','manager','info@cordobasquash.com.ar',3,null,null,null),
(105, 1,true,'elcerro','manager','info@elcerro.com.ar',3,null,null,null),
(116, 1,true,'squashpro','manager','info@squashpro.com.ar',3,null,null,null),
(107, 1,true,'bocajr','manager','info@boca.com',3,null,null,null),
(108, 1,true,'quality','manager','info@quality.com.ar',3,null,null,null),
(109, 1,true,'bucorr','manager','info@bucor.com.ar',3,null,null,null),
(110, 1,true,'talleres','manager','info@talleres.com',3,null,null,null);

/* Jugadores */
insert into usuario (id,version,activo,nombre_usuario,password,correo,rol_id,club_id,jugador_id,persona_id) values
(1, 1,true,'heraldov','player','heraldovalenti@gmail.com',1,null,null,null),
(2, 1,true,'guillef','player','guille.fank@gmail.com',1,null,null,null),
(3, 1,true,'matidc','player','matidc.89@gmail.com',1,null,null,null),
(4, 1,true,'davidc','player','didcoppa@gmail.com',1,null,null,null),
(5, 1,true,'albertovalenti','player','albertovalenti@gmail.com',1,null,null,null),
(6, 1,true,'tadeovalenti','player','tadeovalenti@gmail.com',1,null,null,null),
(7, 1,true,'jorguitostefo','player','stefojorge@gmail.com',1,null,null,null),
(8, 1,true,'marquesito','player','oscar_marquesin@hotmail.com',1,null,null,null),
(9, 1,true,'juanpier','player','juanpierletti@hotmail.com',1,null,null,null),
(10,1,true,'albertirsh','player','alberto_irsh@hotmail.com',1,null,null,null),
(11,1,true,'jorgecaser','player','casermeiro_jorge@gmail.com',1,null,null,null),
(12,1,true,'fleitosv','player','olval_fleitas@gmail.com',1,null,null,null),
(13,1,true,'lozanodan','player','dani_lozano@hotmail.com',1,null,null,null),
(14 ,1,true,'alewere','player','alewere@hotmail.com',1,null,null,null),
(15 ,1,true,'kevinphilips','player','kevinphilips@hotmail.com',1,null,null,null),
(16 ,1,true,'flaperalta','player','flaperalta@hotmail.com',1,null,null,null),
(17 ,1,true,'victorferreira','player','victorferreira@hotmail.com',1,null,null,null),
(18 ,1,true,'iiivaaan','player','iiivaaan@hotmail.com',1,null,null,null),
(19 ,1,true,'bladiflore','player','bladiflore@hotmail.com',1,null,null,null),
(20,1,true,'mamaugus','player','augus_mamani@gmail.com',1,null,null,null),
(21,1,true,'ramiernesto','player','ramirez_ernersto@gmail.com',1,null,null,null),
(22,1,true,'philike','player','kevin_philips@gmail.com',1,null,null,null),
(23,1,true,'flaper','player','peralta_falvio@gmail.com',1,null,null,null),
(24,1,true,'ferrvic','player','ferreira_victor@gmail.com',1,null,null,null),
(25,1,true,'berstivan','player','ivan_berst@hotmail.com',1,null,null,null),
(26,1,true,'bladimir','player','flores_blad@gmail.com',1,null,null,null),
(27,1,true,'julianpeke','player','augus_mamani2@gmail.com',1,null,null,null),
(28,1,true,'danielchamuyo','player','augus_mamani3@gmail.com',1,null,null,null),
(29,1,true,'horaciomontal','player','augus_mamani4@gmail.com',1,null,null,null),
(30,1,true,'gonzaloovie','player','augus_maman5i@gmail.com',1,null,null,null),
(31,1,true,'pablorami','player','augus_mamani6@gmail.com',1,null,null,null),
(32,1,true,'pablolerda','player','augus_mamani7@gmail.com',1,null,null,null),
(33,1,true,'mateogio','player','augus_mamani8@gmail.com',1,null,null,null),
(34,1,true,'tanquegaston','player','augus_mamani9@gmail.com',1,null,null,null),
(35,1,true,'claudiobelen','player','augus_mamani10@gmail.com',1,null,null,null),
(36,1,true,'claudiomontaldo','player','augus_mamani11@gmail.com',1,null,null,null),
(37,1,true,'nicolasbesso','player','augus_mamani12@gmail.com',1,null,null,null),
(38,1,true,'gerardoprincipi','player','augus_mamani13@gmail.com',1,null,null,null),
(39,1,true,'lionelmessi','player','augus_mamani14@gmail.com',1,null,null,null),
(40,1,true,'diegoarmando','player','augus_mamani15@gmail.com',1,null,null,null),
(41,1,true,'diegoelias','player','augus_mamani16@gmail.com',1,null,null,null),
(42,1,true,'ayrtonpagotti','player','augus_mamani17@gmail.com',1,null,null,null),
(43,1,true,'coloradoperez','player','augus_mamani18@gmail.com',1,null,null,null),
(44,1,true,'agustinmartin','player','augus_mamani19@gmail.com',1,null,null,null),
(45,1,true,'ernestoche','player','augus_mamani20@gmail.com',1,null,null,null),
(46,1,true,'juanca','player','augus_mamani21@gmail.com',1,null,null,null),
(47,1,true,'merengue','player','augus_mamani22@gmail.com',1,null,null,null),
(48,1,true,'urca','player','augus_mamani23@gmail.com',1,null,null,null),
(49,1,true,'pablosantalucia','player','augus_mamani24@gmail.com',1,null,null,null),
(50, 1,true,'brendam','player','brendaamolinari@gmail.com',1,null,null,null),
(51, 1,true,'lucilav','player','lupitavalenti@hotmail.com',1,null,null,null),
(52,1,true,'nadiab','player','nadiab@gmail.com',1,null,null,null),
(53,1,true,'ndeleu','player','ndeleu@gmail.com',1,null,null,null),
(54,1,true,'armenialoca','player','armenialoca@gmail.com',1,null,null,null);