<html>
    <head>
        <meta name="layout" content="club">
        <title>Disponibilidad Horaria</title>
        <r:require modules="calendario,jquery"/>                       
    </head>
    <body>
    	<g:link controller="cancha" action="show" id="${ idCancha }">Volver</g:link>
        <g:weekly/>
		<fieldset class="buttons">
			<g:actionSubmit id="guardarDisponibilidad" class="save" value="Guardar" />
		</fieldset>
</body>
</html>
