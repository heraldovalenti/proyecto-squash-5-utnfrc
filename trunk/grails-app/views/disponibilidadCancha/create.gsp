<html>
    <head>
        <meta name="layout" content="club">
        <title>Disponibilidad Horaria</title>

        <r:require modules="calendario,jquery"/>

    </head>
    <body>

    	<h1 class="mb20">Disponibilidad horaria</h1>
    	<fieldset class="buttons">
    		<g:link controller="cancha" action="show" params="[cancha: cancha.id]"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>    	

        <g:weekly/>
		<fieldset class="buttons">
			<g:actionSubmit id="guardarDisponibilidad" class="save" value="Guardar" />
		</fieldset>
		<g:render template="/secciones/referenciasDisponibilidad" />
</body>
</html>
