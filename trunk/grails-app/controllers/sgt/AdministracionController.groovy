package sgt

class AdministracionController {

    static defaultAction = 'inicio'
	
	def inicio() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		def rolAdministrador = Rol.findByNombre("Administrador")
		
		if (!u.roles.contains(rolAdministrador)) {
			render(view: "/inicio")
			return
		}
		
		render(view: 'inicio')
	}	
}
