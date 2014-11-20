package sgt

class PanelPersonalTagLib {
	
	def linkPanelPersonal = {
		Usuario u = session.getAttribute("userLogon")
		def rolJugador = Rol.findByNombre('Jugador')
		if (u && (u.esClub() || u.esEncargado() ) ) {
			out << g.link(controller: "club", class: "button_small green", style: "margin: 3px", { "Panel de control personal" })
		}
		//si se encontro el usuario y es un Jugador
		if (u && u.esJugador()) {
			out << g.link(controller: "jugador", class: "button_small green", style: "margin: 3px", { "Panel de control personal" })
		}
		//si se encontro el usuario y es un Administrador
		if (u && u.esAdministrador()) {
			out << g.link(controller: "administracion", class: "button_small green", style: "margin: 3px", { "Panel de administracion" })
		}
	}

}
