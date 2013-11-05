package sgt.jugador
import sgt.Usuario
import sgt.InscripcionTorneo

class InscripcionesController {

    def index() {
		def Usuario usuario = session.getAttribute("userLogon")
		usuario = Usuario.get(usuario?.id)
		if (!usuario) {
			redirect(url: "/")
			return
		}
		
		def inscripcionInstanceList = InscripcionTorneo.findAllByUsuario(usuario)
		
		render(view: "/jugador/inscripcion/listadoInscripcion", model: [inscripcionInstanceList: inscripcionInstanceList, total: inscripcionInstanceList.size()])
	}
}
