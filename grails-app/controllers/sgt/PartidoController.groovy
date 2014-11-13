package sgt
import grails.validation.ValidationException

import java.text.SimpleDateFormat

import org.springframework.dao.DataIntegrityViolationException

import sgt.exceptions.DiagramacionException

class PartidoController {
	
	def partidoService

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
		def torneoInstance = (sgt.Torneo)session.getAttribute("torneoSeleccionado")
		torneoInstance = Torneo.get(torneoInstance.id)
        params.max = Math.min(max ?: 10, 100)
        [partidoInstanceList: Partido.createCriteria().list(params) {
			eq("torneo", torneoInstance)
		}, partidoInstanceTotal: Partido.count(), torneoInstance:torneoInstance]
    }

    def create() {
    	def torneoInstance = (sgt.Torneo)session.getAttribute("torneoSeleccionado")
		torneoInstance = Torneo.get(torneoInstance.id)
		Partido p = new Partido(params)
		p.torneo = torneoInstance		   
		try {
			partidoService.esPosibleDiagramar(p)
		} catch (DiagramacionException e) {
			flash.exception = e
			redirect(action: "list1")
			return
		}
		render(view: "create", model: [torneoInstance: torneoInstance])
    }

    def save() {	
		def torneoInstance = Torneo.get(params.torneo)
		def partidoInstance = setearParametrosPartido(params)
		try {
			partidoService.savePartido(partidoInstance)
			flash.message = "El partido se ha creado correctamente"
			redirect(action: "show1", id: partidoInstance.id)
		} catch (DiagramacionException e) {
			flash.exception = e
			render(view: "create", model: [partidoInstance: partidoInstance,torneoInstance: torneoInstance])
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render(view: "create", model: [partidoInstance: partidoInstance,torneoInstance: torneoInstance])
		} catch (e) {
			flash.exception = e
			render(view: "create", model: [partidoInstance: partidoInstance,torneoInstance: torneoInstance])
		}
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
		try {
			partidoService.esPosibleDiagramar(partidoInstance)
		} catch (DiagramacionException e) {
			flash.exception = e
			redirect(action: "list1")
			return
		}
		def torneoInstance = (sgt.Torneo)session.getAttribute("torneoSeleccionado")		
		torneoInstance = Torneo.get(torneoInstance.id)
        [partidoInstance: partidoInstance,torneoInstance:torneoInstance]
    }

    def update(Long id, Long version) {
        def partidoInstance = Partido.get(id)
		def torneoInstance = (sgt.Torneo)session.getAttribute("torneoSeleccionado")
		torneoInstance = Torneo.get(torneoInstance.id)
        
		setearParametrosPartido2(partidoInstance,params)
		try {
			partidoService.savePartido(partidoInstance)
			flash.message = "El partido se ha actualizado correctamente"
			redirect(action: "show1", id: partidoInstance.id)
			return
		} catch (DiagramacionException e) {
			flash.exception = e
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
		} catch (e) {
			flash.exception = e
		}
        render(view: "edit", model: [partidoInstance: partidoInstance,torneoInstance:torneoInstance])
    }

    def delete(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        try {
			partidoService.esPosibleDiagramar(partidoInstance)
            partidoInstance.delete(flush: true)
            flash.message = "El partido fue eliminado correctamente"
            redirect(action: "list1")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "show1", id: id)
        }
		catch (DiagramacionException e) {
			flash.exception = e
			redirect(action: "show1", id: id)
		}
    }
	
	def setearParametrosPartido(def parametros){
		def torneoId=parametros.torneo
		def torneo=Torneo.get(torneoId)
		def horaDesde=parametros.horaDesde
		def horaHasta=(Integer.parseInt(horaDesde) + 1).toString()
		def fechaParam=parametros.fecha
		Date fecha
		if(fechaParam!=""){
			fecha= new SimpleDateFormat("dd/MM/yyyy").parse(fechaParam)
		}				
		def categoriaId=parametros.categoria.id
		def categoria=Categoria.get(categoriaId)
		def persona1Id=parametros.jugador1
		def persona1=Persona.get(persona1Id)
		def jugador1=Usuario.findByPersona(persona1)
		def persona2Id=parametros.jugador2
		def persona2=Persona.get(persona2Id)
		def jugador2=Usuario.findByPersona(persona2)
		def personaArbitroId=parametros.arbitro
		def personaArbitro=Persona.get(personaArbitroId)
		def arbitro=Usuario.findByPersona(personaArbitro)
		def canchaId=parametros.cancha.id
		def cancha=Cancha.get(canchaId)
		def estado="Creado"
		
		def partidoInstance = new Partido(torneo:torneo,horaDesde:horaDesde,horaHasta:horaHasta,fecha:fecha,categoria:categoria,cancha:cancha,jugador1:jugador1,jugador2:jugador2,arbitro:arbitro,estado:estado)
		return partidoInstance
		
	}
	
	def setearParametrosPartido2(Partido p, def parametros){
		def torneoId=parametros.torneo
		def torneo=Torneo.get(torneoId)
		def horaDesde=parametros.horaDesde
		def horaHasta=(Integer.parseInt(horaDesde) + 1).toString()
		def fechaParam=parametros.fecha
		Date fecha
		if(fechaParam!=""){
			fecha= new SimpleDateFormat("dd/MM/yyyy").parse(fechaParam)
		}
		def categoriaId=parametros.categoria.id
		def categoria=Categoria.get(categoriaId)
		def persona1Id=parametros.jugador1
		def persona1=Persona.get(persona1Id)
		def jugador1=Usuario.findByPersona(persona1)
		def persona2Id=parametros.jugador2
		def persona2=Persona.get(persona2Id)
		def jugador2=Usuario.findByPersona(persona2)
		def personaArbitroId=parametros.arbitro
		def personaArbitro=Persona.get(personaArbitroId)
		def arbitro=Usuario.findByPersona(personaArbitro)
		def canchaId=parametros.cancha.id
		def cancha=Cancha.get(canchaId)
		def estado="Creado"
		
		p.torneo = torneo
		p.horaDesde = horaDesde
		p.horaHasta = horaHasta
		p.fecha = fecha
		p.categoria = categoria
		p.cancha = cancha
		p.jugador1 = jugador1
		p.jugador2 = jugador2
		p.arbitro = arbitro
		p.estado = estado
	}
	
	def listarResultadosPartidosTorneo(){
		
		def torneoInstance = (sgt.Torneo)session.getAttribute("torneoSeleccionado")
		torneoInstance = Torneo.get(torneoInstance.id)		
		def categoriaSeleccionada
		
		if(params.categoria!=null && params.categoria!=""){		
		Long idCategoria=Long.parseLong(params.categoria)
		categoriaSeleccionada=Categoria.get(idCategoria)
		}
		def categorias= torneoInstance?.detalles?.categoria		
		
		Integer max = (params.max) ? Integer.parseInt(params.max) : 10
		params.max = Math.min(max ?: 10, 100)
		
		def partidos=partidoService.listarPartidosTorneo(torneoInstance.id,categoriaSeleccionada?.id,params)
		
		def totalPartidos= partidos.getTotalCount()
		
		render(view: "listadoResultadosPartidoTorneo", model: [partidos:partidos,totalPartidos:totalPartidos,categorias:categorias,categoriaSeleccionada:categoriaSeleccionada])
		
	}
}
