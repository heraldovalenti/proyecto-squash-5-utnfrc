<%@ page import="sgt.Usuario" %>
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<g:link action="show" id="${usuarioEncargado.id}">Volver</g:link>
		<div id="edit-encargado" class="content scaffold-edit" role="main">
			<h1>Encargado de Club</h1>
			<g:if test="${ flash.message }">
			<div class="message" role="status">
				${ flash.message }
			</div>
			</g:if>
			<g:if test="${ flash.errors }">
				<ul class="errors" role="alert">
					<g:each in="${ flash.errors }" var="error">
						<li>${ error }</li>
					</g:each>
				</ul>
			</g:if>
			<g:if test="${ flash.exception }">
				<ul class="errors" role="alert">
					<li>${ flash.exception.message }</li>
				</ul>
			</g:if>
			
			<g:form action="update">
				<g:hiddenField name="idUsuario" value="${usuarioEncargado?.id}" />
				
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
