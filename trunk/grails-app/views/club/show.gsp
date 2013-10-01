
<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'club.label', default: 'Club')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-club" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		
		<div id="show-club" class="content scaffold-show" role="main">
			<h1>Datos de club</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list club">
			
				<g:if test="${clubInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="club.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${clubInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.razonSocial}">
				<li class="fieldcontain">
					<span id="razonSocial-label" class="property-label"><g:message code="club.razonSocial.label" default="Razon Social" /></span>
					
						<span class="property-value" aria-labelledby="razonSocial-label"><g:fieldValue bean="${clubInstance}" field="razonSocial"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.correo}">
				<li class="fieldcontain">
					<span id="correo-label" class="property-label"><g:message code="club.correo.label" default="Correo" /></span>
					
						<span class="property-value" aria-labelledby="correo-label"><g:fieldValue bean="${clubInstance}" field="correo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label"><g:message code="club.telefono.label" default="Telefono" /></span>
					
						<span class="property-value" aria-labelledby="telefono-label"><g:fieldValue bean="${clubInstance}" field="telefono"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.sitioWeb}">
				<li class="fieldcontain">
					<span id="sitioWeb-label" class="property-label"><g:message code="club.sitioWeb.label" default="Sitio Web" /></span>
					
						<span class="property-value" aria-labelledby="sitioWeb-label"><g:fieldValue bean="${clubInstance}" field="sitioWeb"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${clubInstance?.id}" />
					<g:link class="edit" action="edit" id="${clubInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
