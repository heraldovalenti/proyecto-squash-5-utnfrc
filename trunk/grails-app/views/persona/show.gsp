
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-persona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" action="list"><g:message code="Lista de Personas" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="Nueva Persona" args="[entityName]" /></g:link></li>
			</ul>
		</div>
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
			
				<g:if test="${personaInstance?.domicilio}">
				<li class="fieldcontain">
					<span id="domicilio-label" class="property-label"><g:message code="persona.domicilio.label" default="Domicilio" /></span>
					
						<span class="property-value" aria-labelledby="domicilio-label"><g:link controller="domicilio" action="show" id="${personaInstance?.domicilio?.id}">${personaInstance?.domicilio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.imagen}">
				<li class="fieldcontain">
					<span id="imagen-label" class="property-label"><g:message code="persona.imagen.label" default="Imagen" /></span>
					
						<span class="property-value" aria-labelledby="imagen-label"><g:fieldValue bean="${personaInstance}" field="imagen"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personaInstance?.numeroDocumento}">
				<li class="fieldcontain">
					<span id="numeroDocumento-label" class="property-label"><g:message code="persona.numeroDocumento.label" default="Numero Documento" /></span>
					
						<span class="property-value" aria-labelledby="numeroDocumento-label"><g:fieldValue bean="${personaInstance}" field="numeroDocumento"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personaInstance?.id}" />
					<g:link class="edit" action="edit" id="${personaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
