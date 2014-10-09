<%@ page import="sgt.Jugador" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
	</head>
	<body>
		
		<g:if test="${ persona.id }">
		<g:link controller="jugador" action="datosPersonales">Volver</g:link>
		</g:if>
		
		<div id="edit-datosJugador" class="content scaffold-edit">
			<h1>Datos personales</h1>
			
			<g:render template="/utils/messages" />
			
			<g:form method="post" >
				<fieldset class="form">
					<g:render template="/jugador/datosPersonales/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" controller="jugador" action="saveDatosPersonales" value="Guardar"/>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
