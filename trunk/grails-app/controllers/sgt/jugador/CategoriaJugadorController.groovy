package sgt.jugador
import sgt.Usuario
import sgt.Categoria
import sgt.CategoriaJugador

class CategoriaJugadorController {

    def index() { 
		def Usuario usuario = session.getAttribute("userLogon")
		
		
		def categoriaInstanceList = usuario.getCategoriasJugador()
		def Iterator<CategoriaJugador> iter = categoriaInstanceList.iterator()
		def categoriaActual = null
		def categoriaSolicitada = null
		while (iter.hasNext()) {
			def CategoriaJugador aux = iter.next()
			if (aux.esAsignada()) categoriaActual = aux
			if (aux.esSolicitada()) categoriaSolicitada = aux
			if (categoriaActual && categoriaSolicitada) break
		}
		
		render(view: "/jugador/categoria/verCategoria", model: [categoriaActual: categoriaActual?.categoria, categoriaSolicitada: categoriaSolicitada?.categoria])
	}
	
	def verHistorial() {
		render(view: "/jugador/categoria/historialCategorias")
	}
	
	def solicitarNuevaCategoria() {
		def categoriaInstanceList = Categoria.list()
		def categoriaJugadorInstance = new CategoriaJugador(params)
		render(view: "/jugador/categoria/solicitudCategoria", model: [categoriaJugadorInstance: categoriaJugadorInstance, categoriaInstanceList: categoriaInstanceList])
	}
	
	def cancelarSolicitud() {
		def Usuario usuario = session.getAttribute("userLogon")
		usuario = Usuario.get(usuario?.id)
		if (!usuario) {
			redirect(url: "/")
			return
		}
		
		def categoriaInstanceList = usuario.getCategoriasJugador()
		def Iterator<CategoriaJugador> iter = categoriaInstanceList.iterator()
		while (iter.hasNext()) {
			def CategoriaJugador aux = iter.next()
			if (aux.esSolicitada()) {
				aux.anular()
				aux.save()
				flash.message = "Solicitud de categor�a cancelada"
				break
			}
		}
		redirect(action: "index")
	}
	
	def save() {
		def Usuario usuario = session.getAttribute("userLogon")
		def categoriaJugadorInstance = new CategoriaJugador(params)
		categoriaJugadorInstance.setFechaInicio(new Date())
		categoriaJugadorInstance.solicitar()
		categoriaJugadorInstance.setUsuario(usuario)
		
		if (!categoriaJugadorInstance.save()) {
			def categoriaInstanceList = Categoria.list()
			render(view: "/jugador/categoria/solicitudCategoria", model: [categoriaJugadorInstance: categoriaJugadorInstance, categoriaInstanceList: categoriaInstanceList])
			return
		}
		
		//def Usuario usuario = session.getAttribute("userLogon")
		//usuario = Usuario.get(usuario?.id)
		//usuario.addToCategoriasJugador(categoriaJugadorInstance)
		//usuario.save()
		
		flash.message = "Solicitud de categor�a registrada"
		redirect(action: "index")
		return
	}
}
