
<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link action="list1"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
    		<g:link action="create"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Nuevo Partido</span> </g:link>
		</fieldset>
		
		<div id="show-partido" class="content scaffold-show" role="main">
			
			<g:render template="/utils/messages" />
			
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
					
						<span class="property-value" aria-labelledby="categoria-label"><g:fieldValue bean="${partidoInstance}" field="categoria"/></span>
					
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
					
						<span class="property-value" aria-labelledby="jugador1-label"><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador1?.id,categoria:partidoInstance?.categoria,tipo:'Jugador']">${partidoInstance?.jugador1?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${partidoInstance?.jugador2}">
				<li class="fieldcontain">
					<span id="jugador2-label" class="property-label"><g:message code="partido.jugador2.label" default="Jugador2" /></span>
					
						<span class="property-value" aria-labelledby="jugador2-label"><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador2?.id,categoria:partidoInstance?.categoria,tipo:'Jugador']">${partidoInstance?.jugador2?.encodeAsHTML()}</g:link></span>
					
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
					
						<span class="property-value" aria-labelledby="cancha-label"><g:fieldValue bean="${partidoInstance}" field="cancha"/></span>
					
				</li>
				</g:if>	
			
				<g:if test="${partidoInstance?.arbitro}">
				<li class="fieldcontain">
					<span id="arbitro-label" class="property-label"><g:message code="partido.arbitro.label" default="Arbitro" /></span>
					
						<span class="property-value" aria-labelledby="arbitro-label"><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.arbitro?.id,categoria:partidoInstance?.categoria,tipo:'Jugador']">${partidoInstance?.arbitro?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>	
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${partidoInstance?.id}" />
					<g:link class="edit" action="edit" id="${partidoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:if test="${ !partidoInstance.esSingle() }">
					<g:link controller="resultadoPartido" action="cargarResultado" id="${ partidoInstance?.id }">
						<g:if test="${ !partidoInstance.finalizado() }">Cargar Resultado</g:if>
						<g:else>Ver Resultado</g:else>
					</g:link>
					</g:if>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
