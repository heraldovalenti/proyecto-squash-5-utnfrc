
<%@ page import="sgt.Cancha" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<g:link controller="cancha" action="list" namespace="club">Volver al listado de canchas</g:link>
		
		<div id="show-cancha" class="content scaffold-show" role="main">
			<h1>Datos de cancha</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list cancha">
			
				<g:if test="${canchaInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="cancha.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${canchaInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canchaInstance?.tipoSuelo}">
				<li class="fieldcontain">
					<span id="tipoSuelo-label" class="property-label"><g:message code="cancha.tipoSuelo.label" default="Tipo Suelo" /></span>
					
						<span class="property-value" aria-labelledby="tipoSuelo-label"><g:fieldValue bean="${canchaInstance}" field="tipoSuelo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canchaInstance?.ancho}">
				<li class="fieldcontain">
					<span id="ancho-label" class="property-label"><g:message code="cancha.ancho.label" default="Ancho" /></span>
					
						<span class="property-value" aria-labelledby="ancho-label"><g:fieldValue bean="${canchaInstance}" field="ancho"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canchaInstance?.largo}">
				<li class="fieldcontain">
					<span id="largo-label" class="property-label"><g:message code="cancha.largo.label" default="Largo" /></span>
					
						<span class="property-value" aria-labelledby="largo-label"><g:fieldValue bean="${canchaInstance}" field="largo"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${canchaInstance?.techo}">
				<li class="fieldcontain">
					<span id="techo-label" class="property-label"><g:message code="cancha.techo.label" default="Techo" /></span>
					
						<span class="property-value" aria-labelledby="techo-label"><g:formatBoolean boolean="${canchaInstance?.techo}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${canchaInstance?.paredes}">
				<li class="fieldcontain">
					<span id="paredes-label" class="property-label"><g:message code="cancha.paredes.label" default="Paredes" /></span>
					
						<span class="property-value" aria-labelledby="paredes-label"><g:fieldValue bean="${canchaInstance}" field="paredes"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="disponibilidad-label" class="property-label">Disp. Horaria</span>
					<span class="property-value" aria-labelledby="disponibilidad-label">
						 <g:link controller="disponibilidadCancha" 
							params="[idCancha: canchaInstance.id]">Ver disponibilidad</g:link>
					</span>
				</li>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${canchaInstance?.id}" />
					<g:actionSubmit class="edit" controller="cancha" action="edit" namespace="club" id="${canchaInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
					
					<g:actionSubmit class="delete" controller="cancha" action="delete" namespace="club" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
