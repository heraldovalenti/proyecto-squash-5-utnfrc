
<%@ page import="sgt.TorneoPuntuable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-torneoPuntuable" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-torneoPuntuable" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list torneoPuntuable">
			
				<g:if test="${torneoPuntuableInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="torneoPuntuable.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${torneoPuntuableInstance}" field="nombre"/></span>
					
				</li>
				</g:if>			
				
			
				<g:if test="${torneoPuntuableInstance?.ordenAnual}">
				<li class="fieldcontain">
					<span id="ordenAnual-label" class="property-label"><g:message code="torneoPuntuable.ordenAnual.label" default="Orden Anual" /></span>
					
						<span class="property-value" aria-labelledby="ordenAnual-label"><g:fieldValue bean="${torneoPuntuableInstance}" field="ordenAnual"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoPuntuableInstance?.activo}">
				<li class="fieldcontain">
					<span id="activo-label" class="property-label"><g:message code="torneoPuntuable.activo.label" default="Activo" /></span>
					
						<span class="property-value" aria-labelledby="activo-label"><g:formatBoolean boolean="${torneoPuntuableInstance?.activo}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoPuntuableInstance?.instanciasTorneo}">
				<li class="fieldcontain">
					<span id="instanciasTorneo-label" class="property-label"><g:message code="torneoPuntuable.instanciasTorneo.label" default="Instancias Torneo" /></span>
					
						<g:each in="${torneoPuntuableInstance.instanciasTorneo}" var="i">
						<span class="property-value" aria-labelledby="instanciasTorneo-label"><g:link controller="torneo" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${torneoPuntuableInstance?.id}" />
					<g:link class="edit" action="edit" id="${torneoPuntuableInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:link controller="puntaje" action="cargarPuntaje" id="${torneoPuntuableInstance?.id}">Ver puntajes </g:link>
					<g:link controller="puntaje" action="cargarPuntaje" id="${ torneoPuntuableInstance?.id }">Cargar Puntaje</g:link>
					<g:link controller="detallePuntaje" action="listarDetalles" id="${ torneoPuntuableInstance?.id }">Ver Puntajes</g:link>
					<g:link controller="puntaje" action="cargarPuntaje" id="${ torneoPuntuableInstance?.id }">Cargar Puntaje</g:link>
					<g:link controller="detallePuntaje" action="listarDetalles" id="${ torneoPuntuableInstance?.id }">Ver Puntajes</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
