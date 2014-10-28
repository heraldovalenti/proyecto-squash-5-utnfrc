package sgt
import sgt.Persona;
import sgt.Partido;
import grails.converters.JSON
import java.text.SimpleDateFormat
import org.springframework.dao.DataIntegrityViolationException

class PartidoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def cargarResultado(Long id)
	{
		def partidoInstance = Partido.get(id)
		redirect(controller: 'resultadoPartido', action:'cargarResultado', id: id)
		return
	}		
	
	//Acciones del Scaffold

    def index() {
        redirect(action: "list1", params: params)
    }

    def list1(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [partidoInstanceList: Partido.list(params), partidoInstanceTotal: Partido.count()]
    }

    def create() {		
		def idTorneo= params.torneo
		def torneoInstance=Torneo.get(idTorneo)    
		render(view: "create", model: [torneoInstance: torneoInstance])
    }

    def save() {
		System.out.println(params.toString())
		/*def paramCancha=params.cancha.split(":")
		Long cancha=Long.parseLong(paramCancha[1])*/
		def torneoId=params.torneo
		def torneo=Torneo.get(torneoId)
		def horaDesde=params.horaDesde	
		def horaHasta=params.horaHasta
		def fechaParam=params.fecha
		System.out.println(fechaParam)
		Date fecha= new SimpleDateFormat("dd/MM/yyyy").parse(fechaParam)
		def categoriaId=params.categoria.id		
		def categoria=Categoria.get(categoriaId)
		def jugador1Id=params.jugador1
		def jugador1=Usuario.get(jugador1Id)	
		def jugador2Id=params.jugador2
		def jugador2=Usuario.get(jugador2Id)
		def arbitroId=params.arbitro
		def arbitro=Usuario.get(arbitroId)		
		def canchaId=params.cancha.id
		def cancha=Cancha.get(canchaId)
		def estado="Creado"
		//def partidoInstance = new Partido(torneo:1,horaDesde:"8:00",horaHasta:"9:00",cancha:1,jugador1:1,jugador2:2,arbitro:3,estado:"Creado").save(flush: true)
        def partidoInstance = new Partido(torneo:torneo,horaDesde:horaDesde,horaHasta:horaHasta,fecha:fecha,categoria:categoria,cancha:cancha,jugador1:jugador1,jugador2:jugador2,arbitro:arbitro,estado:estado)			
        if (!partidoInstance.save(flush: true, onFailError:true)) {			
			def torneoInstance=Torneo.get(torneoId)  
            render(view: "create", model: [partidoInstance: partidoInstance,torneoInstance: torneoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'partido.label', default: 'Partido'), partidoInstance.id])
        redirect(action: "show1", id: partidoInstance.id)
    }

    def show1(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        [partidoInstance: partidoInstance]
    }

    def edit(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        [partidoInstance: partidoInstance]
    }

    def update(Long id, Long version) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        if (version != null) {
            if (partidoInstance.version > version) {
                partidoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'partido.label', default: 'Partido')] as Object[],
                          "Another user has updated this Partido while you were editing")
                render(view: "edit", model: [partidoInstance: partidoInstance])
                return
            }
        }

        partidoInstance.properties = params

        if (!partidoInstance.save(flush: true)) {
            render(view: "edit", model: [partidoInstance: partidoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'partido.label', default: 'Partido'), partidoInstance.id])
        redirect(action: "show1", id: partidoInstance.id)
    }

    def delete(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        try {
            partidoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "show1", id: id)
        }
    }
}
