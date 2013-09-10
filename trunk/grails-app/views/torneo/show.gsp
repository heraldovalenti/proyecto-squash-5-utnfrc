
<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'torneo.label', default: 'Torneo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-torneo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list torneo">
			
				<g:if test="${torneoInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="torneo.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${torneoInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaAlta}">
				<li class="fieldcontain">
					<span id="fechaAlta-label" class="property-label"><g:message code="torneo.fechaAlta.label" default="Fecha Alta" /></span>
					
						<span class="property-value" aria-labelledby="fechaAlta-label"><g:formatDate date="${torneoInstance?.fechaAlta}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaInicioInscripcion}">
				<li class="fieldcontain">
					<span id="fechaInicioInscripcion-label" class="property-label"><g:message code="torneo.fechaInicioInscripcion.label" default="Fecha Inicio Inscripcion" /></span>
					
						<span class="property-value" aria-labelledby="fechaInicioInscripcion-label"><g:formatDate date="${torneoInstance?.fechaInicioInscripcion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaFinInscripcion}">
				<li class="fieldcontain">
					<span id="fechaFinInscripcion-label" class="property-label"><g:message code="torneo.fechaFinInscripcion.label" default="Fecha Fin Inscripcion" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinInscripcion-label"><g:formatDate date="${torneoInstance?.fechaFinInscripcion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaInicioTorneo}">
				<li class="fieldcontain">
					<span id="fechaInicioTorneo-label" class="property-label"><g:message code="torneo.fechaInicioTorneo.label" default="Fecha Inicio Torneo" /></span>
					
						<span class="property-value" aria-labelledby="fechaInicioTorneo-label"><g:formatDate date="${torneoInstance?.fechaInicioTorneo}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaFinTorneo}">
				<li class="fieldcontain">
					<span id="fechaFinTorneo-label" class="property-label"><g:message code="torneo.fechaFinTorneo.label" default="Fecha Fin Torneo" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinTorneo-label"><g:formatDate date="${torneoInstance?.fechaFinTorneo}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.club}">
				<li class="fieldcontain">
					<span id="club-label" class="property-label"><g:message code="torneo.club.label" default="Club" /></span>
					
						<span class="property-value" aria-labelledby="club-label"><g:link controller="club" action="show" id="${torneoInstance?.club?.id}">${torneoInstance?.club?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="torneo.estado.label" default="Estado" /></span>
					
						<span class="property-value" aria-labelledby="estado-label"><g:fieldValue bean="${torneoInstance}" field="estado"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.detalles}">
				<li class="fieldcontain">
					<span id="detalles-label" class="property-label"><g:message code="torneo.detalles.label" default="Detalles" /></span>
					
						<g:each in="${torneoInstance.detalles}" var="d">
						<span class="property-value" aria-labelledby="detalles-label"><g:link controller="detalleTorneo" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.puntuable}">
				<li class="fieldcontain">
					<span id="puntuable-label" class="property-label"><g:message code="torneo.puntuable.label" default="Puntuable" /></span>
					
						<span class="property-value" aria-labelledby="puntuable-label"><g:formatBoolean boolean="${torneoInstance?.puntuable}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${torneoInstance?.id}" />
					<g:actionSubmit class="edit" action="edit" id="${torneoInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
