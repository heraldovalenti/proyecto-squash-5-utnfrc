
<%@ page import="modelo.DetalleDisponibilidad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-detalleDisponibilidad" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list detalleDisponibilidad">
			
				<g:if test="${detalleDisponibilidadInstance?.dia}">
				<li class="fieldcontain">
					<span id="dia-label" class="property-label"><g:message code="detalleDisponibilidad.dia.label" default="Dia" /></span>
					
						<span class="property-value" aria-labelledby="dia-label"><g:fieldValue bean="${detalleDisponibilidadInstance}" field="dia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleDisponibilidadInstance?.desde}">
				<li class="fieldcontain">
					<span id="desde-label" class="property-label"><g:message code="detalleDisponibilidad.desde.label" default="Desde" /></span>
					
						<span class="property-value" aria-labelledby="desde-label"><g:fieldValue bean="${detalleDisponibilidadInstance}" field="desde"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleDisponibilidadInstance?.hasta}">
				<li class="fieldcontain">
					<span id="hasta-label" class="property-label"><g:message code="detalleDisponibilidad.hasta.label" default="Hasta" /></span>
					
						<span class="property-value" aria-labelledby="hasta-label"><g:fieldValue bean="${detalleDisponibilidadInstance}" field="hasta"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${detalleDisponibilidadInstance?.id}" />
					<g:actionSubmit class="edit" action="edit" id="${detalleDisponibilidadInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
