<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="torneo" action="show" id="${ torneoInstance?.id }"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
    		<g:link controller="torneo" action="list"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver al listado de torneos</span> </g:link>
		</fieldset>
	
		<div id="edit-torneo" class="content scaffold-edit" >
			<h1>Torneo</h1>
			
			<g:render template="/utils/messages" />
			
			<g:form method="post" >
				<g:hiddenField name="id" value="${torneoInstance?.id}" />
				<g:hiddenField name="version" value="${torneoInstance?.version}" />
				<fieldset class="form">
					<g:render template="/administracion/torneos/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="Guardar" />
					<g:actionSubmit class="delete" action="delete" value="Eliminar" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
