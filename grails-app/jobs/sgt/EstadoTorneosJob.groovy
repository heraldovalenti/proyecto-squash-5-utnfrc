package sgt

class EstadoTorneosJob {
    
	def torneoService
	
	static triggers = {
		simple name: "EstadoTorneoSimple", startDelay:10000l, repeatInterval: 10000l, repeatCount: 1
		cron name: "EstadoTorneoCron", startDelay: 10000l, cronExpression: "0 5 0 * * ?"
    }

    def execute() {
        torneoService.actualizarEstados()
    }
}
