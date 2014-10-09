<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
	</head>
	<body>
		<div id="show-datosPersonales" class="content scaffold-show">
			<h1>Datos personales</h1>
			
			<g:render template="/utils/messages" />
			
			<ol class="property-list datosPersonales">
			
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label">Nombre</span>
					<span class="property-value">${ persona.nombre }</span>
				</li>
			
				<li class="fieldcontain">
					<span id="apellido-label" class="property-label">Apellido</span>
					<span class="property-value">${ persona.apellido }</span>
				</li>
				
				<li class="fieldcontain">
					<span id="sexo-label" class="property-label">Sexo</span>
					<span class="property-value">${ persona.sexo }</span>
				</li>
			
				<li class="fieldcontain">
					<span id="fechaNacimiento-label" class="property-label">Fecha Nacimiento</span>	
					<span class="property-value">
						<g:formatDate date="${persona.fechaNacimiento}" format="dd/MM/yyyy"/>
					</span>
				</li>
			
				<g:if test="${persona?.lugarNacimiento}">
				<li class="fieldcontain">
					<span id="lugarNacimiento" class="property-label">Lugar de Nacimiento</span>
					<span class="property-value">${ persona.lugarNacimiento }</span>
				</li>
				</g:if>
			
				<g:if test="${persona.tipoDocumento}">
				<li class="fieldcontain">
					<span id="tipoDocumento-label" class="property-label">Tipo Documento</span>
					<span class="property-value">${ persona.tipoDocumento }</span>
				</li>
				</g:if>
				
				<g:if test="${persona?.numeroDocumento}">
				<li class="fieldcontain">
					<span id="numeroDocumento-label" class="property-label">Numero de Documento</span>
					<span class="property-value">${ persona.numeroDocumento }</span>					
				</li>
				</g:if>
			
				<g:if test="${persona?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label">Telefono</span>
					<span class="property-value">${ persona.telefono }</span>
				</li>
				</g:if>
				
			</ol>
			
			<fieldset class="buttons">
				<g:link class="edit" action="editDatosPersonales">Editar</g:link>
			</fieldset>
		</div>
	</body>
</html>