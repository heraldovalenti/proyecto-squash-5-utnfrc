
<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="partido">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-partido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-partido" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list partido">
			
				<g:if test="${partidoInstance?.torneo}">
				<li class="fieldcontain">
					<span id="torneo-label" class="property-label"><g:message code="partido.torneo.label" default="Torneo" /></span>
					
						<span class="property-value" aria-labelledby="torneo-label"><g:link controller="torneo" action="show" id="${partidoInstance?.torneo?.id}">${partidoInstance?.torneo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${partidoInstance?.categoria}">
				<li class="fieldcontain">
					<span id="categoria-label" class="property-label"><g:message code="partido.categoria.label" default="Categoria" /></span>
					
						<span class="property-value" aria-labelledby="categoria-label"><g:link controller="categoria" action="show" id="${partidoInstance?.categoria?.id}">${partidoInstance?.categoria?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>	
				
				<g:if test="${partidoInstance?.fecha}">
				<li class="fieldcontain">
					<span id="fecha-label" class="property-label"><g:message code="partido.fecha.label" default="Fecha" /></span>
					
						<span class="property-value" aria-labelledby="fecha-label"><g:formatDate date="${partidoInstance?.fecha}" /></span>
					
				</li>
				</g:if>							
			
				
			
				<g:if test="${partidoInstance?.horaDesde}">
				<li class="fieldcontain">
					<span id="horaDesde-label" class="property-label"><g:message code="partido.horaDesde.label" default="Hora Desde" /></span>
					
						<span class="property-value" aria-labelledby="horaDesde-label"><g:fieldValue bean="${partidoInstance}" field="horaDesde"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partidoInstance?.horaHasta}">
				<li class="fieldcontain">
					<span id="horaHasta-label" class="property-label"><g:message code="partido.horaHasta.label" default="Hora Hasta" /></span>
					
						<span class="property-value" aria-labelledby="horaHasta-label"><g:fieldValue bean="${partidoInstance}" field="horaHasta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partidoInstance?.jugador1}">
				<li class="fieldcontain">
					<span id="jugador1-label" class="property-label"><g:message code="partido.jugador1.label" default="Jugador1" /></span>
					
						<span class="property-value" aria-labelledby="jugador1-label"><g:link controller="usuario" action="show" id="${partidoInstance?.jugador1?.id}">${partidoInstance?.jugador1?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partidoInstance?.jugador2}">
				<li class="fieldcontain">
					<span id="jugador2-label" class="property-label"><g:message code="partido.jugador2.label" default="Jugador2" /></span>
					
						<span class="property-value" aria-labelledby="jugador2-label"><g:link controller="usuario" action="show" id="${partidoInstance?.jugador2?.id}">${partidoInstance?.jugador2?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partidoInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="partido.estado.label" default="Estado" /></span>
					
						<span class="property-value" aria-labelledby="estado-label"><g:fieldValue bean="${partidoInstance}" field="estado"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${partidoInstance?.cancha}">
				<li class="fieldcontain">
					<span id="cancha-label" class="property-label"><g:message code="partido.cancha.label" default="Cancha" /></span>
					
						<span class="property-value" aria-labelledby="cancha-label"><g:link controller="cancha" action="show" id="${partidoInstance?.cancha?.id}">${partidoInstance?.cancha?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>	
			
				<g:if test="${partidoInstance?.arbitro}">
				<li class="fieldcontain">
					<span id="arbitro-label" class="property-label"><g:message code="partido.arbitro.label" default="Arbitro" /></span>
					
						<span class="property-value" aria-labelledby="arbitro-label"><g:link controller="usuario" action="show" id="${partidoInstance?.arbitro?.id}">${partidoInstance?.arbitro?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>	
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${partidoInstance?.id}" />
					<g:link class="edit" action="edit" id="${partidoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link controller="partido" action="cargarResultado" id="${ partidoInstance?.id }">Cargar Resultado</g:link>
					<g:link controller="detalleResultados" action="listarDetalles" id="${ partidoInstance?.id }">Ver Resultado</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
