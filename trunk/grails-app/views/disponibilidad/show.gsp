
<%@ page import="modelo.Disponibilidad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'disponibilidad.label', default: 'Disponibilidad')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-disponibilidad" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list disponibilidad">
			
				<g:if test="${disponibilidadInstance?.detalles}">
				<li class="fieldcontain">
					<span id="detalles-label" class="property-label"><g:message code="disponibilidad.detalles.label" default="Detalles" /></span>
					
						<g:each in="${disponibilidadInstance.detalles}" var="d">
						<span class="property-value" aria-labelledby="detalles-label"><g:link controller="detalleDisponibilidad" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${disponibilidadInstance?.fechaActualizacion}">
				<li class="fieldcontain">
					<span id="fechaActualizacion-label" class="property-label"><g:message code="disponibilidad.fechaActualizacion.label" default="Fecha Actualizacion" /></span>
					
						<span class="property-value" aria-labelledby="fechaActualizacion-label"><g:formatDate date="${disponibilidadInstance?.fechaActualizacion}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${disponibilidadInstance?.id}" />
					<g:actionSubmit class="edit" action="edit" id="${disponibilidadInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
