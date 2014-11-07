package sgt

import org.hibernate.criterion.CriteriaSpecification

class SecurityFilters {
	
	def filters = {
		securityFilter(controller: "*", action: "*") {
			before = {
				def user = session.getAttribute("userLogon")
				boolean res = allowed(user, controllerName, actionName)
				if (res) return true
				else {
					response.status = org.springframework.http.HttpStatus.FORBIDDEN.value
					return false
				}
			}
		}
	}
	
	boolean allowed(Usuario u, String _controllerName, String _actionName) {
		boolean res = policy()
		Rol rol = loadRol(u)
		if (rol) {
			for (p in rol.permisos) {
				if (p.matched(_controllerName, _actionName)) {
					res = p.allowed()
					break
				}
			}
		}
		return res
	}
	
	boolean policy() {
		boolean res = true
		def c = Permiso.createCriteria()
		def policy = c.get() {
			eq("controller", "*")
			and {
				eq("action", "*")
			}
		}
		if (policy) {
			res = policy.allowed()
		}
		return res
	}
	
	Rol loadRol(Usuario userLogon) {
		if (userLogon && userLogon.esJugador()) return Rol.get(1)
		if (userLogon && userLogon.esAdministrador()) return Rol.get(2)
		if (userLogon && userLogon.esClub()) return Rol.get(3)
		if (userLogon && userLogon.esEncargado()) return Rol.get(4)
		return Rol.get(5) //rol anonimo
	}
}
