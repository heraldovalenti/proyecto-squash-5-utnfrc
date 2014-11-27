/* REQUIERE EJEMPLOS-USUARIOS */

insert into domicilio (id,version,calle,numero,piso,departamento,ciudad,codigo_postal,provincia) values
(1,1,'Velez Sardfield','1134',null,null,'Cordoba',5000,'Cordoba'),
(2,1,'Belgrano','389',null,null,'Cordoba',5000,'Cordoba'),
(3,1,'Cruz Roja','1678',null,null,'Cordoba',5000,'Cordoba'),
(4,1,'Lima','549',null,null,'Cordoba',5000,'Cordoba'),
(5,1,'Humberto Primo','2148',null,null,'Cordoba',5000,'Cordoba'),
(6,1,'San Martin','331',null,null,'Cordoba',5000,'Cordoba'),
(7,1,'San Juan','2000',null,null,'Cordoba',5000,'Cordoba'),
(8, 1,'La Boca','SN',null,null,'Buenos Aires',011,'Buenos Aires'),
(9, 1,'Independencia','533',null,null,'Cordoba',5000,'Cordoba'),
(10,1,'Buenos Aires','889',null,null,'Cordoba',5000,'Cordoba'),
(11,1,'Chateau','S/N',null,null,'Cordoba',5000,'Cordoba');


insert into club (id,version,nombre,telefono,domicilio_id,sitio_web,correo,validado) values
(1,1,'Megasport','0351154675123',1,'www.megasport.com.ar','megasport@gmail.com',true),
(2,1,'La Fachada','0351154987654',2,'www.fachada.com.ar','la-fachada@gmail.com',true),
(3,1,'Monami','0351154675682',3,'www.monami.com.ar','monami@gmail.com',true),
(4,1,'Tancat','0351155643712',4,'www.tancat.com.ar','tancat@gmail.com',true),
(5,1,'Cordoba Squash','0351155432145',5,'www.cba-squash.com.ar','cba-squash@gmail.com',true),
(6,1,'El Cerro','0351155438133',6,'www.elcerroSquash.com.ar','elcerroSquash@gmail.com',true),
(7,1,'Squash Pro','0351155432145',7,'www.squashpro.com','squashpro@pro.com',true),
(8 ,1,'Boca Juniors','0800 555 BOCA',8,'www.bocajuniors.com.ar','info@bocajuniors.com.ar',true),
(9 ,1,'Quality ISSAD','0351 4595959',9,'www.qualityisad.com','info@qualityisad.com',true),
(10,1,'Bucor','0351 5550000',10,'www.bucor-natacion.com.ar','info@bucor-natacion.com.ar',true),
(11,1,'CAT - Club Atletico Talleres','0351 MUERTOS 911',11,'www.talleresdecordoba.com.ar','info@talleresdecordoba.com.ar',true);

update usuario set club_id = 1 where id = 100;
update usuario set club_id = 2 where id = 101;
update usuario set club_id = 3 where id = 102;
update usuario set club_id = 4 where id = 103;
update usuario set club_id = 5 where id = 104;
update usuario set club_id = 6 where id = 105;
update usuario set club_id = 7 where id = 106;
update usuario set club_id = 8 where id = 107;
update usuario set club_id = 9 where id = 108;
update usuario set club_id = 10 where id =109;
update usuario set club_id = 11 where id =110;

insert into cancha (id,version,club_id,numero,nombre,tipo_suelo,techada,disponibilidad_id) values
(1, 1,9,1,'Q01','Cemento',true,null),
(2, 1,1,1,'M1','Cemento',true,null),
(3, 1,1,2,'M2','Cemento',true,null),
(4, 1,1,4,'M4','Cemento',true,null),
(5, 1,2,1,'F1','Parquet',true,null),
(6, 1,2,2,'F2','Parquet',true,null),
(7, 1,2,3,'F3','Parquet',true,null),
(8, 1,3,1,'MO1','Parquet',true,null),
(9, 1,3,2,'M02','Parquet',true,null),
(10,1,3,3,'M03','Parquet',true,null),
(11,1,3,4,'M04','Parquet',true,null),
(12,1,4,1,'T1','Parquet',true,null),
(13,1,4,2,'T2','Parquet',true,null),
(14,1,4,3,'T3','Parquet',true,null),
(15,1,5,1,'CS1','Parquet',true,null),
(16,1,5,2,'CS2','Parquet',true,null),
(17,1,5,3,'CS3','Parquet',true,null),
(18,1,5,4,'CS4','Parquet',true,null),
(19,1,6,1,'CSP1','Parquet',true,null),
(20,1,6,2,'CSP2','Parquet',true,null),
(21,1,6,3,'CSP3','Parquet',true,null),
(22,1,7,1,'SP1','Parquet',true,null),
(23,1,8,1,'CABJ-01','Parquet',true,null),
(24,1,8,2,'CABJ-02','Parquet',true,null),
(25,1,8,3,'CABJ-03','Parquet',true,null),
(26,1,10,1,'B1','Parquet',true,null),
(27,1,11,1,'T1','Parquet',true,null),
(28,1,11,2,'T2','Parquet',true,null);