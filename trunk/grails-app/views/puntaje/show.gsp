
<%@ page import="sgt.Puntaje" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'puntaje.label', default: 'Puntaje')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-puntaje" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list puntaje">
			
				<g:if test="${puntajeInstance?.categoria}">
				<li class="fieldcontain">
					<span id="categoria-label" class="property-label"><g:message code="puntaje.categoria.label" default="Categoria" /></span>
					
						<span class="property-value" aria-labelledby="categoria-label"><g:link controller="categoria" action="show" id="${puntajeInstance?.categoria?.id}">${puntajeInstance?.categoria?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${puntajeInstance?.detalles}">
				<li class="fieldcontain">
					<span id="detalles-label" class="property-label"><g:message code="puntaje.detalles.label" default="Detalles" /></span>
					
						<g:each in="${puntajeInstance.detalles}" var="d">
						<span class="property-value" aria-labelledby="detalles-label"><g:link controller="detallePuntaje" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${puntajeInstance?.id}" />
					<g:actionSubmit class="edit" action="edit" id="${puntajeInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link controller="torneoPuntuable" action="save" id="${ puntajeInstance?.id}">Cargar</g:link>
					
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
