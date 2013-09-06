package sgt

class JugadorController {

	static defaultAction ='index'
	
    def index() { 
		render(view: '/jugador/inicioJugador')
		return
	}
	
	def datosPersonales() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!u.persona) {
			redirect(controller: 'persona', action:'create', params: [layout: 'jugador'])
			return
		} else {
			redirect(controller: 'persona', action: 'show', id: u.persona.id, params: [layout: 'jugador'])
			return
		}
	}
}
