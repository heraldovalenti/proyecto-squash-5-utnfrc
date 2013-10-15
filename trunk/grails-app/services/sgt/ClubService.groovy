package sgt

class ClubService {

    def Club clubLogon(Usuario u) {
		if (u) {
			u = Usuario.get(u.id)
			return u.getClub()
		}
		return null
    }
}
