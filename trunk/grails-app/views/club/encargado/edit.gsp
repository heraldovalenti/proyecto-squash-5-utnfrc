<%@ page import="sgt.Usuario" %>
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<g:link action="show" params="[encargado: usuarioEncargado.id]">Volver</g:link>
		<div id="edit-encargado" class="content scaffold-edit" role="main">
			<h1>Encargado de Club</h1>
			<g:render template="/utils/messages"/>
			
			<g:form action="update">
				<g:hiddenField name="encargado" value="${usuarioEncargado?.id}" />
				
				<fieldset class="form">
					<g:render template="/club/encargado/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
