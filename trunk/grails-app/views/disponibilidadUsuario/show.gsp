<html>
    <head>
        <meta name="layout" content="jugador">
        <title>Disponibilidad Horaria</title>
		<r:require modules="calendario,jquery"/>
	</head>
    <body>
        <g:weekly/>
		<fieldset class="buttons">
			<g:actionSubmit id="guardarDisponibilidad" class="save" value="Guardar" />
			<g:actionSubmit id="borrarDisponibilidad" class="delete" value="Eliminar" />
		</fieldset>
	</body>
</html>