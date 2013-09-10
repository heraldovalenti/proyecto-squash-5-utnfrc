
<%@ page import="sgt.Domicilio" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'domicilio.label', default: 'Domicilio')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-domicilio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" /></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" action="list"><g:message code="Domicilio" args="[entityName]" /></g:link></li>				
			</ul>
		</div>
		<div id="show-domicilio" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list domicilio">
			
				<g:if test="${domicilioInstance?.piso}">
				<li class="fieldcontain">
					<span id="piso-label" class="property-label"><g:message code="domicilio.piso.label" default="Piso" /></span>
					
						<span class="property-value" aria-labelledby="piso-label"><g:fieldValue bean="${domicilioInstance}" field="piso"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.dpto}">
				<li class="fieldcontain">
					<span id="dpto-label" class="property-label"><g:message code="domicilio.dpto.label" default="Dpto" /></span>
					
						<span class="property-value" aria-labelledby="dpto-label"><g:fieldValue bean="${domicilioInstance}" field="dpto"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.codPostal}">
				<li class="fieldcontain">
					<span id="codPostal-label" class="property-label"><g:message code="domicilio.codPostal.label" default="Cod Postal" /></span>
					
						<span class="property-value" aria-labelledby="codPostal-label"><g:fieldValue bean="${domicilioInstance}" field="codPostal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.ciudadOrigen}">
				<li class="fieldcontain">
					<span id="ciudadOrigen-label" class="property-label"><g:message code="domicilio.ciudadOrigen.label" default="Ciudad Origen" /></span>
					
						<span class="property-value" aria-labelledby="ciudadOrigen-label"><g:fieldValue bean="${domicilioInstance}" field="ciudadOrigen"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.provincia}">
				<li class="fieldcontain">
					<span id="provincia-label" class="property-label"><g:message code="domicilio.provincia.label" default="Provincia" /></span>
					
						<span class="property-value" aria-labelledby="provincia-label"><g:fieldValue bean="${domicilioInstance}" field="provincia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.ciudad}">
				<li class="fieldcontain">
					<span id="ciudad-label" class="property-label"><g:message code="domicilio.ciudad.label" default="Ciudad" /></span>
					
						<span class="property-value" aria-labelledby="ciudad-label"><g:fieldValue bean="${domicilioInstance}" field="ciudad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.domicilio}">
				<li class="fieldcontain">
					<span id="domicilio-label" class="property-label"><g:message code="domicilio.domicilio.label" default="Domicilio" /></span>
					
						<span class="property-value" aria-labelledby="domicilio-label"><g:fieldValue bean="${domicilioInstance}" field="domicilio"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${domicilioInstance?.id}" />
					<g:link class="edit" action="edit" id="${domicilioInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
