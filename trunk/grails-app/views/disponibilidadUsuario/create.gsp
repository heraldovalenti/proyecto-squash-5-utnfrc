<html>
    <head>
        <meta name="layout" content="jugador">
        <title>Disponibilidad Horaria</title>
        <%--<link rel="stylesheet" href="${resource(dir: 'css', file: 'calendar.css')}" type="text/css">        
        --%><%--<r:require modules="calendario,jquery"/>                   
        <r:layoutResources/>              
    --%></head>
    <body>
        <g:weekly/>
	<fieldset class="buttons">
		<g:actionSubmit id="guardarDisponibilidad" class="save" action="save"
			value="${message(code: 'default.button.save.label', default: 'Guardar')}" />
	</fieldset>
</body>
</html>
