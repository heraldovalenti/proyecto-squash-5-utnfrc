package sgt

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DiagramacionService2Tests {
	
	static transactional = true
	
	def diagramacionService
	def sqlLoaderService
	
	@Before
	void setUp() {
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("torneos.sql")
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
		sqlLoaderService.loadInsertFile("rankings-jugadores.sql")
		sqlLoaderService.loadInsertFile("inscripciones-jugadores.sql")
		sqlLoaderService.loadInsertFile("clubes.sql")
	}

	@After	
	void tearDown() {
		Partido.executeUpdate("delete from Partido")
	}
	
	@Test
	void generarDiagramacionTest_1() {
		Torneo torneo = Torneo.get(7)
		torneo.estado = "Inscripcion Finalizada"
		torneo.save(failOnError: true, flush: true)
		
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		
		diagramacionService.generarDiagramacion(torneo.id)
		
		Assert.assertTrue(torneo.diagramado())
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(29, partidosTorneo.size())
		Categoria primera = Categoria.get(1)
		partidosTorneo = Partido.findAllByTorneoAndCategoria(torneo,primera)
		Assert.assertEquals(7, partidosTorneo.size())
		Categoria segunda = Categoria.get(2)
		partidosTorneo = Partido.findAllByTorneoAndCategoria(torneo,segunda)
		Assert.assertEquals(7, partidosTorneo.size())
		Categoria tercera = Categoria.get(3)
		partidosTorneo = Partido.findAllByTorneoAndCategoria(torneo,tercera)
		Assert.assertEquals(15, partidosTorneo.size())
	}
	
	@Test
	void generarDiagramacionTest_2() {
		Torneo torneo = Torneo.get(8)
		torneo.estado = "Inscripcion Finalizada"
		torneo.save(failOnError: true, flush: true)
		DetalleTorneo detalle = DetalleTorneo.get(4)
		Usuario heraldov = Usuario.get(1)
		Usuario user2 = Usuario.get(2)
		Usuario user3 = Usuario.get(3)
		Usuario user4 = Usuario.get(4)
		InscripcionTorneo inscripcion1 = 
			new InscripcionTorneo(usuario: heraldov, estado: "Vinculada", fecha: new Date(), detalleTorneo: detalle)
			.save(failOnError: true, flush: true)
		InscripcionTorneo inscripcion2 =
			new InscripcionTorneo(usuario: user2, estado: "Vinculada", fecha: new Date(), detalleTorneo: detalle)
			.save(failOnError: true, flush: true)
		InscripcionTorneo inscripcion3 =
			new InscripcionTorneo(usuario: user3, estado: "Vinculada", fecha: new Date(), detalleTorneo: detalle)
			.save(failOnError: true, flush: true)
		InscripcionTorneo inscripcion4 =
			new InscripcionTorneo(usuario: user4, estado: "Vinculada", fecha: new Date(), detalleTorneo: detalle)
			.save(failOnError: true, flush: true)
		
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		def inscripciones = InscripcionTorneo.createCriteria().list {
			eq("detalleTorneo", detalle)
		}
		Assert.assertEquals(4, inscripciones.size())
		
		diagramacionService.generarDiagramacion(torneo.id)
		
		Assert.assertTrue(torneo.diagramado())
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(3, partidosTorneo.size())
	}
	
	@Test
	void generarDiagramacionTest_3() {
		Torneo torneo = Torneo.get(8)
		torneo.estado = "Inscripcion Finalizada"
		torneo.save(failOnError: true, flush: true)
		DetalleTorneo detalle = DetalleTorneo.get(4)
		Usuario user1 = Usuario.get(1)
		Usuario user2 = Usuario.get(2)
		InscripcionTorneo inscripcion1 =
			new InscripcionTorneo(usuario: user1, estado: "Vinculada", fecha: new Date(), detalleTorneo: detalle)
			.save(failOnError: true, flush: true)
		InscripcionTorneo inscripcion2 =
			new InscripcionTorneo(usuario: user2, estado: "Vinculada", fecha: new Date(), detalleTorneo: detalle)
			.save(failOnError: true, flush: true)
				
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		
		diagramacionService.generarDiagramacion(torneo.id)
		
		Assert.assertTrue(torneo.diagramado())
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(1, partidosTorneo.size())
	}
	
	@Test
	void generarDiagramacionTest_4() {
		Torneo torneo = Torneo.get(8)
		torneo.estado = "Inscripcion Finalizada"
		torneo.save(failOnError: true, flush: true)
		DetalleTorneo detalle = DetalleTorneo.get(4)
		Usuario user1 = Usuario.get(1)
		InscripcionTorneo inscripcion1 =
			new InscripcionTorneo(usuario: user1, estado: "Vinculada", fecha: new Date(), detalleTorneo: detalle)
			.save(failOnError: true, flush: true)
				
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		
		diagramacionService.generarDiagramacion(torneo.id)
		
		Assert.assertTrue(torneo.diagramado())
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(1, partidosTorneo.size())
	}
}
