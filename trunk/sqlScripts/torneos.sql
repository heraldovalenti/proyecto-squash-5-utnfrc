/* REQUERIDOS: CATEGORIAS */
insert into torneo (id,version,club_id,estado,nombre,puntuable,torneo_puntuable_id,imagen_id,
fecha_alta,fecha_inicio_inscripcion,fecha_fin_inscripcion,fecha_inicio_torneo,fecha_fin_torneo) values
(1,1,null,'Creado','Torneo 1', false,null,null,'2014-08-01','2014-08-15','2014-08-30','2014-08-31','2014-09-30'),
(2,1,null,'Creado','Torneo 2', false,null,null,'2014-10-01','2014-10-15','2014-10-30','2014-10-31','2014-11-30'),
(3,1,null,'Creado','Torneo 3', false,null,null,'2014-06-01','2014-06-30','2014-06-30','2014-06-01','2014-06-15'),
(4,1,null,'Creado','Torneo 4', false,null,null,'2014-01-01','2014-12-01','2014-12-10','2014-12-11','2014-12-30'),
(5,1,null,'Creado','Torneo 5', false,null,null,'2014-01-01','2014-12-01','2014-12-10','2014-12-11','2014-12-30'),
(6,1,null,'Creado','Torneo 6', false,null,null,'2014-01-01','2014-12-01','2014-12-10','2014-12-11','2014-12-30');

insert into torneo_puntuable (id,version,nombre,orden_anual,activo) values 
(1, 1, 'I Fecha Puntuable', 	1, true),
(2, 1, 'II Fecha Puntuable',	2, true),
(3, 1, 'III Fecha Puntuable',	3, true),
(4, 1, 'IV Fecha Puntuable',	4, true),
(5, 1, 'V Fecha Puntuable',		5, true),
(6, 1, 'VI Fecha Puntuable',	6, true),
(7, 1, 'VII Fecha Puntuable',	7, true),
(8, 1, 'VIII Fecha Puntuable',	8, true),
(9, 1, 'IX Fecha Puntuable',	9, true),
(10,1, 'X Fecha Puntuable',		10,true),
(11,1, 'XI Fecha Puntuable',	11,false),
(12,1, 'XII Fecha Puntuable',	12,false);

insert into torneo (id,version,club_id,estado,nombre,puntuable,torneo_puntuable_id,imagen_id,
fecha_alta,fecha_inicio_inscripcion,fecha_fin_inscripcion,fecha_inicio_torneo,fecha_fin_torneo) values
(7,1,null,'Creado','I Fecha Puntuable 2014', true,1,null,'2014-01-01','2014-01-01','2014-01-10','2014-01-15','2014-01-25'),
(8,1,null,'Inscripcion Abierta','II Fecha Puntuable 2014', true,2,null,'2014-02-01','2014-02-01','2014-02-10','2014-02-15','2014-02-25'),
(9,1,null,'Inscripcion Cerrada','III Fecha Puntuable 2014', true,3,null,'2014-03-01','2014-03-01','2014-03-10','2014-03-15','2014-03-25'),
(10,1,null,'Inscripcion Finalizada','IV Fecha Puntuable 2014', true,4,null,'2014-04-01','2014-04-01','2014-04-10','2014-04-15','2014-04-25'),
(11,1,null,'Creado','V Fecha Puntuable 2014', true,5,null,'2014-05-01','2014-05-01','2014-05-10','2014-05-15','2014-05-25'),
(12,1,null,'Creado','VI Fecha Puntuable 2014', true,6,null,'2014-06-01','2014-06-01','2014-06-10','2014-06-15','2014-06-25'),
(13,1,null,'Creado','VII Fecha Puntuable 2014', true,7,null,'2014-07-01','2014-07-01','2014-07-10','2014-07-15','2014-07-25'),
(14,1,null,'Creado','VIII Fecha Puntuable 2014', true,8,null,'2014-08-01','2014-08-01','2014-08-10','2014-08-15','2014-08-25'),
(15,1,null,'Creado','XI Fecha Puntuable 2014', true,9,null,'2014-09-01','2014-09-01','2014-09-10','2014-09-15','2014-09-25'),
(16,1,null,'Creado','X Fecha Puntuable 2014', true,10,null,'2014-10-01','2014-10-01','2014-10-10','2014-10-15','2014-10-25'),
(17,1,null,'Creado','XI Fecha Puntuable 2014', true,11,null,'2014-11-01','2014-11-01','2014-11-10','2014-11-15','2014-11-25'),
(18,1,null,'Creado','XII Fecha Puntuable 2014', true,12,null,'2014-12-01','2014-12-01','2014-12-10','2014-12-15','2014-12-25');

insert into detalle_torneo (id,version,torneo_id,categoria_id,cupo_maximo) values 
(1,1,7,1,64), /* 7 - Creado - I Fecha Puntuable 2014 */
(2,1,7,2,64),
(3,1,7,3,64),
(4,1,8,1,64), /* 8 - Inscripcion Abierta - II Fecha Puntuable 2014 */
(5,1,8,2,64),
(6,1,8,3,64),
(7,1,9,1,64), /* 9 - Inscripcion Cerrada - III Fecha Puntuable 2014 */
(8,1,9,2,64),
(9,1,9,3,64),
(10,1,9,4,64),
(11,1,10,1,64), /* 10 - Inscripcion Finalizada - IV Fecha Puntuable 2014 */
(12,1,10,2,64),
(13,1,10,3,64),
(14,1,10,4,64),
(15,1,10,5,64),
(16,1,16,1,64), /* 16 - X Fecha Puntuable 2014 */
(17,1,16,2,64),
(18,1,16,3,64);