
<%@ page import="sgt.DetallePuntaje" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'detallePuntaje.label', default: 'DetallePuntaje')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-detallePuntaje" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list detallePuntaje">
			
				<g:if test="${detallePuntajeInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="detallePuntaje.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${detallePuntajeInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detallePuntajeInstance?.puesto}">
				<li class="fieldcontain">
					<span id="puesto-label" class="property-label"><g:message code="detallePuntaje.puesto.label" default="Puesto" /></span>
					
						<span class="property-value" aria-labelledby="puesto-label"><g:fieldValue bean="${detallePuntajeInstance}" field="puesto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detallePuntajeInstance?.puntaje}">
				<li class="fieldcontain">
					<span id="puntaje-label" class="property-label"><g:message code="detallePuntaje.puntaje.label" default="Puntaje" /></span>
					
						<span class="property-value" aria-labelledby="puntaje-label"><g:fieldValue bean="${detallePuntajeInstance}" field="puntaje"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${detallePuntajeInstance?.id}" />
					<g:actionSubmit class="edit" action="edit" id="${detallePuntajeInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link controller="detallePuntaje" action="create">Nuevo</g:link>
					<g:link controller="puntaje" action="create">Finalizar</g:link>					
					
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
