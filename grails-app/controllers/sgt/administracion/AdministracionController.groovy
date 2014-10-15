package sgt.administracion

import sgt.Rol;
import sgt.Usuario;

class AdministracionController {
	
	def index() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		
		render(view: "/administracion/inicio")
	}	
}
