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
	}
	torneos {
		dependsOn 'jquery'
		resource url: "js/torneos.js"
	}
}