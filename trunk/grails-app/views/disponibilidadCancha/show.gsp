<html>
    <head>
    	<meta name="layout" content="club">        
        <title>Disponibilidad Horaria</title>
        <r:require modules="calendario,jquery"/>
	</head>
    <body>
    	<g:link controller="cancha" action="show" params="[cancha: cancha.id]">Volver</g:link>
		<g:weekly/>
		<fieldset class="buttons">
			<g:actionSubmit id="guardarDisponibilidad" class="save" value="Guardar" />
			<g:actionSubmit id="borrarDisponibilidad" class="delete" value="Eliminar" />
		</fieldset>
	</body>
</html>