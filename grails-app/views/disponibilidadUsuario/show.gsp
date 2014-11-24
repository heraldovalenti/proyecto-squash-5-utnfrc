<html>
    <head>
        <meta name="layout" content="jugador">
		<r:require modules="calendario,jquery"/>
	</head>
    <body>
    	<h1 class="mb20">Disponibilidad horaria</h1>
        <g:weekly/>
		<fieldset class="buttons">
			<g:actionSubmit id="guardarDisponibilidad" class="save" value="Guardar" />
			<g:actionSubmit id="borrarDisponibilidad" class="delete" value="Eliminar" />
		</fieldset>
    	<g:render template="/secciones/referenciasDisponibilidad" />
	</body>
</html>