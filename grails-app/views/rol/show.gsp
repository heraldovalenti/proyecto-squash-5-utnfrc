
<%@ page import="sgt.Rol" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'rol.label', default: 'Rol')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link action="list"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
			
		<div id="show-rol" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list rol">
			
				<g:if test="${rolInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="rol.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${rolInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rolInstance?.permisos}">
				<li class="fieldcontain">
					<span id="permisos-label" class="property-label"><g:message code="rol.permisos.label" default="Permisos" /></span>
					
						<g:each in="${rolInstance.permisos}" var="p">
						<span class="property-value" aria-labelledby="permisos-label">${p?.encodeAsHTML()}</span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${rolInstance?.id}" />
					<g:link class="edit" action="edit" id="${rolInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
