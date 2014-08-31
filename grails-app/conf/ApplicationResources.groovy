modules = {
    application {
        resource url:'js/application.js'
    }
	
	listaPersonas {
		resource url:'js/listaPersonas.js'
	}
	jquery {
		resource url: "js/jquery/jquery-1.10.2.js", disposition: "head"
		resource url: "js/jquery/jquery-ui-1.11.1.js", disposition: "head"
		resource url: "css/jquery-ui.css", disposition: "head"
	}
	torneos {
		dependsOn 'jquery'
		resource url: 'js/torneos.js'
	}
	dialogs {
		dependsOn 'jquery'
		resource url: 'js/dialogs.js'
	}
}