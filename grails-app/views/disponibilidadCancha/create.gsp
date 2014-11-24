<html>
    <head>
        <meta name="layout" content="club">
        <title>Disponibilidad Horaria</title>
        <r:require modules="calendario,jquery"/>
        
    </head>
    <body>
    	<h1 class="mb20">Disponibilidad horaria</h1>
    	<div class="nav">
    		<ul>
    			<li>
			    	<g:link controller="cancha" action="show" params="[cancha: cancha.id]">Volver</g:link>
    			</li>
    		</ul>
    	</div>
        <g:weekly/>
		<fieldset class="buttons">
			<g:actionSubmit id="guardarDisponibilidad" class="save" value="Guardar" />
		</fieldset>
		<g:render template="/secciones/referenciasDisponibilidad" />
</body>
</html>
