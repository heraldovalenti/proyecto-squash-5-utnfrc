<%@ page import="sgt.Usuario" %>
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<g:link action="index" >Volver</g:link>
		<div id="show-encargado" class="content scaffold-show" role="main">
			<h1>Encargado de Club</h1>
			<g:if test="${ flash.message }">
				<div class="message" role="status">${ flash.message }</div>
			</g:if>
			<ol class="property-list encargado">
			
				<g:if test="${usuarioEncargado?.nombreUsuario}">
				<li class="fieldcontain">
					<span id="nombreUsuario-label" class="property-label">Nombre de usuario</span>
					<span class="property-value">${usuarioEncargado?.nombreUsuario}</span>
				</li>
				</g:if>
				
				<g:if test="${usuarioEncargado?.correo}">
				<li class="fieldcontain">
					<span id="correo-label" class="property-label">Correo</span>
					<span class="property-value">${usuarioEncargado?.correo}</span>
				</li>
				</g:if>
			
				<g:if test="${usuarioEncargado?.activo != null}">
				<li class="fieldcontain">
					<span id="activo-label" class="property-label">Estado</span>
					<span class="property-value">
						<g:formatBoolean boolean="${ usuarioEncargado?.activo }" 
						true="Activo" false="Inactivo"/>
					</span>
				</li>
				</g:if>
			
				<g:if test="${datosEncargado?.apellido}">
				<li class="fieldcontain">
					<span id="apellido-label" class="property-label">Apellido</span>
					<span class="property-value">${datosEncargado?.apellido}</span>
				</li>
				</g:if>
				
				<g:if test="${datosEncargado?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label">Nombre</span>
					<span class="property-value">${datosEncargado?.nombre}</span>
				</li>
				</g:if>
				
				<g:if test="${datosEncargado?.fechaNacimiento}">
				<li class="fieldcontain">
					<span id="fechaNacimiento-label" class="property-label">Fecha nacimiento</span>
					<span class="property-value">
						<g:formatDate date="${datosEncargado?.fechaNacimiento}" format="dd/MM/yyyy" />
					</span>
				</li>
				</g:if>
				
				<g:if test="${datosEncargado?.tipoDocumento}">
				<li class="fieldcontain">
					<span id="tipoDocumento-label" class="property-label">Tipo documento</span>
					<span class="property-value">${datosEncargado?.tipoDocumento}</span>
				</li>
				</g:if>
				
				<g:if test="${datosEncargado?.numeroDocumento}">
				<li class="fieldcontain">
					<span id="numeroDocumento-label" class="property-label">Numero de documento</span>
					<span class="property-value">${datosEncargado?.numeroDocumento}</span>
				</li>
				</g:if>
			
				<g:if test="${datosEncargado?.sexo}">
				<li class="fieldcontain">
					<span id="sexo-label" class="property-label">Sexo</span>
					<span class="property-value">${datosEncargado?.sexo}</span>
				</li>
				</g:if>
				
				<g:if test="${datosEncargado?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label">Telefono</span>
					<span class="property-value">${datosEncargado?.telefono}</span>
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:link class="edit" action="edit" params="[usuarioId: '${usuarioEncargado?.id}']">Editar</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
