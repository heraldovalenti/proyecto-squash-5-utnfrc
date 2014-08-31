package sgt.administracion.torneos

import static org.junit.Assert.*

import org.junit.*

import sgt.Club
import sgt.PostulacionTorneo
import sgt.Torneo

class PostulacionTorneoServiceTests {
	
	def postulacionTorneoService
	
	@Test
	void aceptarPostulacionTorneoTest() {
		def listaPostulaciones = PostulacionTorneo.list()
		PostulacionTorneo postulacion1 = listaPostulaciones.remove(0)
		PostulacionTorneo postulacion2 = listaPostulaciones.remove(0)
		Torneo torneo = Torneo.list().remove(0)
		Assert.assertTrue(postulacion1.esPendiente())
		Assert.assertTrue(postulacion2.esPendiente())
		Assert.assertTrue(torneo.creado())
		
		postulacionTorneoService.aceptarPostulacionTorneo(postulacion1.id)
		
		Assert.assertTrue(postulacion1.esAceptada())
		Assert.assertTrue(postulacion2.esRechazada())
		Assert.assertTrue(torneo.clubAsignado())
	}
	
	@Test
	void rechazarPostulacionTorneoTest() {
		def listaPostulaciones = PostulacionTorneo.list()
		PostulacionTorneo postulacion1 = listaPostulaciones.remove(0)
		PostulacionTorneo postulacion2 = listaPostulaciones.remove(0)
		Assert.assertTrue(postulacion1.esPendiente())
		Assert.assertTrue(postulacion2.esPendiente())
		
		postulacionTorneoService.rechazarPostulacionTorneo(postulacion1.id)
		postulacionTorneoService.rechazarPostulacionTorneo(postulacion2.id)
		
		Assert.assertTrue(postulacion1.esRechazada())
		Assert.assertTrue(postulacion2.esRechazada())
	}
	
    @Before
    void setUp() {
        def torneo = new Torneo(nombre: "Torneo postulable",
								fechaAlta: new Date(),
								fechaInicioTorneo: new Date(),
								fechaFinTorneo: new Date(),
								fechaInicioInscripcion: new Date(),
								fechaFinInscripcion: new Date(),
								estado: "Creado",
								club: null,
								puntuable: false).save(failOnError: true)
								
		def club1 = new Club(nombre: "club1",
						    razonSocial: "club1",
							validado: true).save(failOnError: true)
							
		def club2 = new Club(nombre: "club2",
			razonSocial: "club2",
			validado: true).save(failOnError: true)
			
		def postulacion1 = new PostulacionTorneo(torneo: torneo,
												fecha: new Date(),
												estado: "Solicitado",
												club: club1).save(failOnError: true)
		
		def postulacion2 = new PostulacionTorneo(torneo: torneo,
												fecha: new Date(),
												estado: "Solicitado",
												club: club2).save(failOnError: true)
    }

    @After
    void tearDown() {
    }

}
