
<%@ page import="sgt.DetalleResultados" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'detalleResultados.label', default: 'DetalleResultados')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-detalleResultados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" action="list"><g:message code="Detalles de Resultados" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="Nuevo Set" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-detalleResultados" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list detalleResultados">
			
				<g:if test="${detalleResultadosInstance?.jugador1}">
				<li class="fieldcontain">
					<span id="jugador1-label" class="property-label"><g:message code="detalleResultados.jugador1.label" default="Jugador1" /></span>
					
						<span class="property-value" aria-labelledby="jugador1-label"><g:fieldValue bean="${detalleResultadosInstance}" field="jugador1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleResultadosInstance?.jugador2}">
				<li class="fieldcontain">
					<span id="jugador2-label" class="property-label"><g:message code="detalleResultados.jugador2.label" default="Jugador2" /></span>
					
						<span class="property-value" aria-labelledby="jugador2-label"><g:fieldValue bean="${detalleResultadosInstance}" field="jugador2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleResultadosInstance?.set}">
				<li class="fieldcontain">
					<span id="set-label" class="property-label"><g:message code="detalleResultados.set.label" default="Set" /></span>
					
						<span class="property-value" aria-labelledby="set-label"><g:fieldValue bean="${detalleResultadosInstance}" field="set"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${detalleResultadosInstance?.id}" />
					<g:link class="edit" action="edit" id="${detalleResultadosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link controller="detalleResultados" action="create">Nuevo SET</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
