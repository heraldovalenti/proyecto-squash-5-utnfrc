
<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'club.label', default: 'Club')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-club" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" action="list"><g:message code="Clubes" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="Nuevo Club" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-club" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
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
			
				<g:if test="${clubInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label"><g:message code="club.telefono.label" default="Telefono" /></span>
					
						<span class="property-value" aria-labelledby="telefono-label"><g:fieldValue bean="${clubInstance}" field="telefono"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.domicilio}">
				<li class="fieldcontain">
					<span id="domicilio-label" class="property-label"><g:message code="club.domicilio.label" default="Domicilio" /></span>
					
						<span class="property-value" aria-labelledby="domicilio-label"><g:link controller="domicilio" action="show" id="${clubInstance?.domicilio?.id}">${clubInstance?.domicilio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.correo}">
				<li class="fieldcontain">
					<span id="correo-label" class="property-label"><g:message code="club.correo.label" default="Correo" /></span>
					
						<span class="property-value" aria-labelledby="correo-label"><g:fieldValue bean="${clubInstance}" field="correo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.sitioWeb}">
				<li class="fieldcontain">
					<span id="sitioWeb-label" class="property-label"><g:message code="club.sitioWeb.label" default="Sitio Web" /></span>
					
						<span class="property-value" aria-labelledby="sitioWeb-label"><g:fieldValue bean="${clubInstance}" field="sitioWeb"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.activo}">
				<li class="fieldcontain">
					<span id="activo-label" class="property-label"><g:message code="club.activo.label" default="Activo" /></span>
					
						<span class="property-value" aria-labelledby="activo-label"><g:formatBoolean boolean="${clubInstance?.activo}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.canchas}">
				<li class="fieldcontain">
					<span id="canchas-label" class="property-label"><g:message code="club.canchas.label" default="Canchas" /></span>
					
						<g:each in="${clubInstance.canchas}" var="c">
						<span class="property-value" aria-labelledby="canchas-label"><g:link controller="cancha" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.encargado}">
				<li class="fieldcontain">
					<span id="encargado-label" class="property-label"><g:message code="club.encargado.label" default="Encargado" /></span>
					
						<span class="property-value" aria-labelledby="encargado-label"><g:link controller="persona" action="show" id="${clubInstance?.encargado?.id}">${clubInstance?.encargado?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${clubInstance?.id}" />
					<g:link class="edit" action="edit" id="${clubInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
