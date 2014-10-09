<%@ page import="sgt.Jugador" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
	</head>
	<body>
		
		<g:if test="${ jugador.checkDatosCompletados() }">
		<g:link controller="jugador" action="datosJugador">Volver</g:link>
		</g:if>
		
		<div id="edit-datosJugador" class="content scaffold-edit">
			<h1>Datos de jugador</h1>
			
			<g:render template="/utils/messages" />
			
			<g:form method="post" enctype="multipart/form-data" >
				<fieldset class="form">
					<g:render template="/jugador/datosJugador/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit controller="jugador" action="saveDatosJugador" class="save" value="Guardar"/>
				</fieldset>
			</g:form>
		</div>
		<r:require modules="imagenes, jugador"/>
	</body>
</html>
