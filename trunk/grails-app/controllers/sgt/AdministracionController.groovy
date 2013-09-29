package sgt

class AdministracionController {

    static defaultAction = 'inicio'
	
	def inicio() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		def rolAdministrador = Rol.findByNombre("Administrador")
		
		
		
		render(view: 'inicio')
	}	
}
