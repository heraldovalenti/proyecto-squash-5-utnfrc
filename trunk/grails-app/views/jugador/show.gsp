
<%@ page import="sgt.Jugador" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
		<g:set var="entityName" value="${message(code: 'jugador.label', default: 'Jugador')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-jugador" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		
		<div id="show-jugador" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list jugador">
			
				<g:if test="${jugadorInstance?.brazo}">
				<li class="fieldcontain">
					<span id="brazo-label" class="property-label"><g:message code="jugador.brazo.label" default="Brazo" /></span>
					
						<span class="property-value" aria-labelledby="brazo-label"><g:fieldValue bean="${jugadorInstance}" field="brazo"/></span>
					
				</li>
				</g:if>
			
			
				<g:if test="${jugadorInstance?.altura}">
				<li class="fieldcontain">
					<span id="altura-label" class="property-label"><g:message code="jugador.altura.label" default="Altura (cm)" /></span>
					
						<span class="property-value" aria-labelledby="altura-label"><g:fieldValue bean="${jugadorInstance}" field="altura"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jugadorInstance?.peso}">
				<li class="fieldcontain">
					<span id="peso-label" class="property-label"><g:message code="jugador.peso.label" default="Peso (Kg)" /></span>
					
						<span class="property-value" aria-labelledby="peso-label"><g:fieldValue bean="${jugadorInstance}" field="peso"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jugadorInstance?.juegaDesde}">
				<li class="fieldcontain">
					<span id="juegaDesde-label" class="property-label"><g:message code="jugador.juegaDesde.label" default="Juega Desde" /></span>
					
						<span class="property-value" aria-labelledby="juegaDesde-label"><g:formatDate date="${jugadorInstance?.juegaDesde}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${jugadorInstance?.id}" />
					<g:link class="edit" action="edit" id="${jugadorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
