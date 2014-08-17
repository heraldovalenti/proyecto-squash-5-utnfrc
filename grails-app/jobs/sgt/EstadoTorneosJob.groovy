package sgt

class EstadoTorneosJob {
    
	def torneoService
	
	/**
	 * CRON TRIGGER:
	 * segundos minutos horas diaDelMes mes diaDeLaSemana
	 * (* : todos, ? : no especificado)
	 */
	static triggers = {
		simple name: "EstadoTorneoSimple", startDelay:10000l, repeatInterval: 10000l, repeatCount: 1 //una vez cuando se arranca la aplicación
		cron name: "EstadoTorneoCron", startDelay: 10000l, cronExpression: "0 5 0 * * ?" //todos los dias del mes, todos los meses, a las 00hs 05min 00segs
    }

    def execute() {
        torneoService.actualizarEstados()
    }
}
