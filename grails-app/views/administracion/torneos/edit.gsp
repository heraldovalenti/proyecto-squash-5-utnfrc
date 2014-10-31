<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
	
		<div class="nav" >
			<ul>
				<li><g:link class="create" controller="torneo" action="show" id="${ torneoInstance?.id }">Volver</g:link></li>
				<li><g:link class="list" controller="torneo" action="list">Volver al listado de torneos</g:link></li>
			</ul>
		</div>
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
