
<%@ page import="sgt.ResultadosPartido" %>
<!DOCTYPE html>
<html>
	<head>
	
		<link href="${resource(dir: 'css', file: 'common.css') }" type="text/css" rel="stylesheet">
		<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'resultadosPartido.label', default: 'ResultadosPartido')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-resultadosPartido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" action="list"><g:message code="Lista de Resultados" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="Nuevo" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-resultadosPartido" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list resultadosPartido">
			
				<g:if test="${resultadosPartidoInstance?.ganador}">
				<li class="fieldcontain">
					<span id="ganador-label" class="property-label"><g:message code="resultadosPartido.ganador.label" default="Ganador" /></span>
					
						<span class="property-value" aria-labelledby="ganador-label"><g:link controller="persona" action="show" id="${resultadosPartidoInstance?.ganador?.id}">${resultadosPartidoInstance?.ganador?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${resultadosPartidoInstance?.detalles}">
				<li class="fieldcontain">
					<span id="detalles-label" class="property-label"><g:message code="resultadosPartido.detalles.label" default="Detalles" /></span>
					
						<g:each in="${resultadosPartidoInstance.detalles}" var="d">
						<span class="property-value" aria-labelledby="detalles-label"><g:link controller="detalleResultados" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${resultadosPartidoInstance?.id}" />
					<g:link class="edit" action="edit" id="${resultadosPartidoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>	
		
		
	</body>
</html>
