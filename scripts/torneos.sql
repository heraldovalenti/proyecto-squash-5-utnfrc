/* REQUERIDOS: CATEGORIAS, CLUBES */
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
(1,1,null,'Inscripcion Abierta','I Fecha Puntuable 2014', true,1,null,
'2014-01-01','2014-01-01','2014-11-30','2014-12-01','2014-12-10'),

(2,1,null,'Inscripcion Finalizada','II Fecha Puntuable 2014', true,2,null,
'2014-01-01','2014-11-10','2014-11-25','2014-12-02','2014-12-14'), #TODO: actualizar fechas para presentacion final 

(3,1,null,'Finalizado','III Fecha Puntuable 2014', true,3,null,
'2014-01-01','2014-11-01','2014-11-10','2014-11-15','2014-11-25'), #TODO: actualizar fechas para presentacion final

(4,1,null,'Ranking Actualizado','IV Fecha Puntuable 2014', true,4,null,
'2014-01-01','2014-01-01','2014-01-02','2014-01-03','2014-01-04'),

(5,1,null,'Ranking Actualizado','V Fecha Puntuable 2014', true,5,null,
'2014-02-01','2014-02-01','2014-02-02','2014-02-03','2014-02-04'),

(6,1,null,'Ranking Actualizado','VI Fecha Puntuable 2014', true,6,null,
'2014-03-01','2014-03-01','2014-03-02','2014-03-03','2014-03-04');

/*(7,1,null,'Ranking Actualizado','VII Fecha Puntuable 2014', true,7,null, #removidos 6 torneos para vision mas clara
'2014-04-01','2014-04-01','2014-04-02','2014-04-03','2014-04-04'),

(8,1,null,'Ranking Actualizado','VIII Fecha Puntuable 2014', true,8,null,
'2014-05-01','2014-05-01','2014-05-02','2014-05-03','2014-05-04'),

(9,1,null,'Ranking Actualizado','XI Fecha Puntuable 2014', true,9,null,
'2014-06-01','2014-06-01','2014-06-02','2014-06-03','2014-06-04'),

(10,1,null,'Ranking Actualizado','X Fecha Puntuable 2014', true,10,null,
'2014-07-01','2014-07-01','2014-07-02','2014-07-03','2014-07-04'),

(11,1,null,'Ranking Actualizado','XI Fecha Puntuable 2014', true,11,null,
'2014-08-01','2014-08-01','2014-08-02','2014-08-03','2014-08-04'),

(12,1,null,'Ranking Actualizado','XII Fecha Puntuable 2014', true,12,null,
'2014-09-01','2014-09-01','2014-09-02','2014-09-03','2014-09-04');*/

/* ASIGNACIONES DE CLUB Y POSTULACIONES */
update torneo set club_id = 9 where id = 2;/*quality*/
update torneo set club_id = 2 where id = 3;/*la fachada*/
insert into postulacion_torneo (id,version,observaciones,fecha,estado,torneo_id,club_id) values
(1,1,null,'2014-01-01','Solicitado',1,1),
(2,1,null,'2014-01-01','Solicitado',1,2),
(3,1,null,'2014-01-01','Solicitado',1,3),
(4,1,null,'2014-01-01','Solicitado',1,4);

insert into detalle_torneo (id,version,torneo_id,categoria_id,cupo_maximo) values 
(1,1,1,1,32),(2,1,1,2,32),(3,1,1,3,32),(4,1,1,4,32),(5,1,1,5,32),
(6,1,1,6,32),(7,1,1,7,32),(8,1,1,8,32),(9,1,1,9,32),(10,1,1,10,32);/*DETALLES FECHA PUNTUABLE I 2014*/

insert into detalle_torneo (id,version,torneo_id,categoria_id,cupo_maximo) values 
(11,1,2,1,32),(12,1,2,2,32),(13,1,2,3,32),(14,1,2,4,32),(15,1,2,5,32),
(16,1,2,6,32),(17,1,2,7,32),(18,1,2,8,32),(19,1,2,9,32),(20,1,2,10,32);/*DETALLES FECHA PUNTUABLE II 2014*/

insert into detalle_torneo (id,version,torneo_id,categoria_id,cupo_maximo) values 
(21,1,3,1,32),(22,1,3,2,32),(23,1,3,3,32),(24,1,3,4,32),(25,1,3,5,32),
(26,1,3,6,32),(27,1,3,7,32),(28,1,3,8,32),(29,1,3,9,32),(30,1,3,10,32);/*DETALLES FECHA PUNTUABLE III 2014*/

