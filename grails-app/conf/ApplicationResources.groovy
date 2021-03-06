modules = {
    application {
        resource url:'js/application.js'
    }	
	jquery {
		resource url: "js/jquery/jquery-1.10.2.js", disposition: "head"
		resource url: "js/jquery/jquery-ui-1.11.1.js", disposition: "head"
		resource url: "css/jquery-ui.css", disposition: "head"
	}
	jugadoresPartido {
		dependsOn 'jquery'
		resource url:'js/jugadoresPartido.js'
	}
	torneos {
		dependsOn 'jquery'
		resource url: 'js/torneos.js'
	}
	calendario {
		dependsOn 'dialogs'		
		resource url: 'js/calendario.js'
		resource url: 'css/calendar.css', disposition: 'head'
	}
	dialogs {
		dependsOn 'jquery'
		resource url: 'js/dialogs.js'
	}
	usuarios {
		dependsOn 'jquery'
		resource url: 'js/usuarios.js'
	}
	imagenes {
		dependsOn 'jquery'
		resource url: 'js/imagenes.js'
	}
	club {
		dependsOn 'jquery'
		resource url: 'js/club.js'
	}
	jugador {
		dependsOn 'jquery'
		resource url: 'js/jugador.js'
	}
	bootstrap{
		dependsOn 'jquery'
		resource url: 'js/bootstrap.min.js'
	}
	deletion {
		dependsOn 'dialogs'
		resource url: 'js/deletion.js'
	}
	diagramacion {
		dependsOn 'jquery'
		resource url: 'js/diagramacion/diagramacion.js'
		resource url: 'css/diagramacion.css', disposition: 'head'
	}
	fixture {
		dependsOn 'jquery'
		resource url: 'js/fixture.js'
		resource url: "js/jquery/jquery-bracket.js", disposition: "head"
		resource url: "css/jquery-bracket.css", disposition: "head"
	}
	listaClubes{
		dependsOn 'jquery'
		resource url: 'js/listaClubes.js'
	}
	listaJugadores{
		dependsOn 'jquery'
		resource url: 'js/listaJugadores.js'
	}
	inicio{
		dependsOn 'jquery'
		resource url: 'js/slider.js'
		//resource url: 'http://www.acsr.com.ar/js/news/js/jquery.easing.js'
		resource url: 'js/script.js'
	}
	fechas{
		dependsOn 'jquery'
		resource url: 'js/datePicker.js'
	}
	fechasTorneo{
		dependsOn 'jquery'
		resource url: 'js/torneoDatePicker.js'
	}
	headToHead{
		dependsOn 'jquery'
		resource url: 'js/headToHead.js'
	}
	listaResultadosPartidos{
		dependsOn 'jquery'
		resource url: 'js/listaResultadosPartidos.js'
	}
	menu{
		dependsOn 'jquery'
		resource url: 'js/menu.js'
	}
	selection {
		dependsOn 'jquery'
		resource url: 'js/selection.js'
	}
	listaPosicionesTorneo{
		dependsOn 'jquery'
		resource url: 'js/listaPosicionesTorneo.js'
	}
	perfilJugador{
		dependsOn 'jquery'
		resource url: 'js/perfilJugador.js'
	}
	listaPartidosPorJugar{
		dependsOn 'jquery'
		resource url: 'js/listaPartidosPorJugar.js'
	}
	graficoJugadoresPorCategoria {
		dependsOn 'jquery'
		resource url: 'js/informeJugadoresPorcategoria.js'
		resource url: 'js/graficos/excanvas.js',disposition: "head"
		resource url: 'js/graficos/jquery.min.js',disposition: "head"
		resource url: 'js/graficos/jquery.jqplot.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.pieRenderer.min.js',disposition: "head"		
		resource url: 'js/graficos/jquery.jqplot.min.css',disposition: "head"
		
	}
	graficoClubesMayorDisponibilidad{
		dependsOn 'jquery'
		resource url: 'js/informeClubesMayorDisponibilidad.js'
		resource url: 'js/graficos/excanvas.js',disposition: "head"
		resource url: 'js/graficos/jquery.min.js',disposition: "head"
		resource url: 'js/graficos/jquery.jqplot.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.barRenderer.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.categoryAxisRenderer.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.pointLabels.min.js',disposition: "head"	
		resource url: 'js/graficos/jqplot.pieRenderer.min.js',disposition: "head"
		resource url: 'js/graficos/jquery.jqplot.min.css',disposition: "head"
		
	}
	
	graficoInscriptosPorTorneo{
		dependsOn 'dialogs'	
		resource url: 'js/informeInscriptosPorTorneo.js'
		resource url: 'js/graficos/excanvas.js',disposition: "head"
		resource url: 'js/graficos/jquery.jqplot.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.barRenderer.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.categoryAxisRenderer.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.pointLabels.min.js',disposition: "head"
		resource url: 'js/graficos/jqplot.pieRenderer.min.js',disposition: "head"
		resource url: 'js/graficos/jquery.jqplot.min.css',disposition: "head"
		
	}
	
}