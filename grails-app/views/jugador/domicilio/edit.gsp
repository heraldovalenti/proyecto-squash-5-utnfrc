<%@ page import="sgt.Domicilio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
	</head>
	<body>
		<g:if test="${ domicilio?.id }">
			<g:link action="datosDomicilio">Volver</g:link>
		</g:if>
		<div id="edit-domicilio" class="content scaffold-create" role="main">
			<h1>Domicilio de club</h1>
			<g:render template="/utils/messages"/>
			
			<g:form action="saveDomicilio">				
				<fieldset class="form">
					<g:render template="/jugador/domicilio/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
