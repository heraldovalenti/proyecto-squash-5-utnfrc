
<%@ page import="sgt.DetalleRanking" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'detalleRanking.label', default: 'DetalleRanking')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-detalleRanking" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list detalleRanking">
			
				<g:if test="${detalleRankingInstance?.desde}">
				<li class="fieldcontain">
					<span id="desde-label" class="property-label"><g:message code="detalleRanking.desde.label" default="Desde" /></span>
					
						<span class="property-value" aria-labelledby="desde-label"><g:formatDate date="${detalleRankingInstance?.desde}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleRankingInstance?.hasta}">
				<li class="fieldcontain">
					<span id="hasta-label" class="property-label"><g:message code="detalleRanking.hasta.label" default="Hasta" /></span>
					
						<span class="property-value" aria-labelledby="hasta-label"><g:formatDate date="${detalleRankingInstance?.hasta}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleRankingInstance?.posicionTorneo}">
				<li class="fieldcontain">
					<span id="posicionTorneo-label" class="property-label"><g:message code="detalleRanking.posicionTorneo.label" default="Posicion Torneo" /></span>
					
						<span class="property-value" aria-labelledby="posicionTorneo-label"><g:fieldValue bean="${detalleRankingInstance}" field="posicionTorneo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleRankingInstance?.puntos}">
				<li class="fieldcontain">
					<span id="puntos-label" class="property-label"><g:message code="detalleRanking.puntos.label" default="Puntos" /></span>
					
						<span class="property-value" aria-labelledby="puntos-label"><g:fieldValue bean="${detalleRankingInstance}" field="puntos"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleRankingInstance?.torneo}">
				<li class="fieldcontain">
					<span id="torneo-label" class="property-label"><g:message code="detalleRanking.torneo.label" default="Torneo" /></span>
					
						<span class="property-value" aria-labelledby="torneo-label"><g:link controller="torneo" action="show" id="${detalleRankingInstance?.torneo?.id}">${detalleRankingInstance?.torneo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${detalleRankingInstance?.torneoPuntuable}">
				<li class="fieldcontain">
					<span id="torneoPuntuable-label" class="property-label"><g:message code="detalleRanking.torneoPuntuable.label" default="Torneo Puntuable" /></span>
					
						<span class="property-value" aria-labelledby="torneoPuntuable-label"><g:link controller="torneoPuntuable" action="show" id="${detalleRankingInstance?.torneoPuntuable?.id}">${detalleRankingInstance?.torneoPuntuable?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${detalleRankingInstance?.id}" />
					<g:actionSubmit class="edit" action="edit" id="${detalleRankingInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
