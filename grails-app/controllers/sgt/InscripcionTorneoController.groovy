package sgt

class InscripcionTorneoController {
		
	def inscripcionTorneo(Long id) {
		def userLogon = session.getAttribute("userLogon")
		if (!userLogon) {
			flash.message = "Debe iniciar sesi�n primero"
			redirect(controller: "usuario", action: "loginForm")
			return
		}
		
		def InscripcionTorneoService inscripcionTorneoService = new InscripcionTorneoService()
		
		
	}
}


