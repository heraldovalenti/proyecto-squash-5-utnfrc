<%@ page import="sgt.Jugador" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
	</head>
	<body>
		<div id="show-datosJugador" class="content scaffold-show">
			<h1>Datos de jugador</h1>
			
			<g:render template="/utils/messages" />
			
			<ol class="property-list show-datosJugador">
			
				<g:if test="${ jugador.brazo }">
				<li class="fieldcontain">
					<span id="brazo-label" class="property-label">Brazo</span>
					<span class="property-value">${ jugador.brazo }</span>
				</li>
				</g:if>
				
				<g:if test="${ jugador.altura }">
				<li class="fieldcontain">
					<span id="altura-label" class="property-label">Altura</span>
					<span class="property-value">${ jugador.altura }</span>
				</li>
				</g:if>
				
				<g:if test="${ jugador.peso }">
				<li class="fieldcontain">
					<span id="peso-label" class="property-label">Peso</span>
					<span class="property-value">${ jugador.peso }</span>
				</li>
				</g:if>
			
				<g:if test="${ jugador.juegaDesde }">
				<li class="fieldcontain">
					<span id="juegaDesde-label" class="property-label">Juega desde</span>	
					<span class="property-value">
						<g:formatDate date="${ jugador.juegaDesde }" format="dd/MM/yyyy"/>
					</span>
				</li>
				</g:if>
				
				<g:if test="${ jugador.imagen }">
				<li class="fieldcontain">
					<span id="imagenPerfil-label" class="property-label">
						Imagen de perfil
					</span>
					<div class="vista-previa"
						style="background-image: url(<g:imagenPerfilJugador jugador="${ jugador }"/>);"	>
					</div>
				</li>
				</g:if>
				
			</ol>
			
			<fieldset class="buttons">
				<g:link class="edit" action="editDatosJugador">Editar</g:link>
			</fieldset>
		</div>
	</body>
</html>