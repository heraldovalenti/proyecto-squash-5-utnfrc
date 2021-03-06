
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
		<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-persona" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list persona">
			
				<g:if test="${personaInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="persona.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${personaInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.apellido}">
				<li class="fieldcontain">
					<span id="apellido-label" class="property-label"><g:message code="persona.apellido.label" default="Apellido" /></span>
					
						<span class="property-value" aria-labelledby="apellido-label"><g:fieldValue bean="${personaInstance}" field="apellido"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.fechaNacimiento}">
				<li class="fieldcontain">
					<span id="fechaNacimiento-label" class="property-label"><g:message code="persona.fechaNacimiento.label" default="Fecha Nacimiento" /></span>
					
						<span class="property-value" aria-labelledby="fechaNacimiento-label"><g:formatDate date="${personaInstance?.fechaNacimiento}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.tipoDocumento}">
				<li class="fieldcontain">
					<span id="tipoDocumento-label" class="property-label"><g:message code="persona.tipoDocumento.label" default="Tipo Documento" /></span>
					
						<span class="property-value" aria-labelledby="tipoDocumento-label"><g:fieldValue bean="${personaInstance}" field="tipoDocumento"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.sexo}">
				<li class="fieldcontain">
					<span id="sexo-label" class="property-label"><g:message code="persona.sexo.label" default="Sexo" /></span>
					
						<span class="property-value" aria-labelledby="sexo-label"><g:fieldValue bean="${personaInstance}" field="sexo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label"><g:message code="persona.telefono.label" default="Telefono" /></span>
					
						<span class="property-value" aria-labelledby="telefono-label"><g:fieldValue bean="${personaInstance}" field="telefono"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.numeroDocumento}">
				<li class="fieldcontain">
					<span id="numeroDocumento-label" class="property-label"><g:message code="persona.numeroDocumento.label" default="Numero de Documento" /></span>
					
						<span class="property-value" aria-labelledby="numeroDocumento-label"><g:fieldValue bean="${personaInstance}" field="numeroDocumento"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${personaInstance?.lugarNacimiento}">
				<li class="fieldcontain">
					<span id="lugarNacimiento" class="property-label"><g:message code="persona.lugarNacimiento.label" default="Lugar de Nacimiento" /></span>
					
						<span class="property-value" aria-labelledby="lugarNacimiento-label"><g:fieldValue bean="${personaInstance}" field="lugarNacimiento"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personaInstance?.id}" />
					<g:link class="edit" action="edit" id="${personaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
