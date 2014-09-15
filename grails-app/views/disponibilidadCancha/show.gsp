<html>
    <head>
    <meta name="layout" content="club">        
        <title>Disponiblidad Horaria</title>
        <%--<link rel="stylesheet" href="${resource(dir: 'css', file: 'calendar.css')}" type="text/css">        
        --%><%--<r:require modules="calendario,jquery"/>                   
        <r:layoutResources/>              
    --%></head>
    <body>
        <g:weekly/>
	<fieldset class="buttons">
		<g:actionSubmit id="guardarDisponibilidad" class="save" action="save"
			value="${message(code: 'default.button.save.label', default: 'Guardar')}" />
		<g:actionSubmit id="borrarDisponibilidad" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Eliminar')}" formnovalidate="" 
		onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
	</fieldset>
</body>
</html>