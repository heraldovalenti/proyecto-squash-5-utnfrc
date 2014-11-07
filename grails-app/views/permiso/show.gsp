
<%@ page import="sgt.Permiso" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'permiso.label', default: 'Permiso')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-permiso" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-permiso" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list permiso">
			
				<g:if test="${permisoInstance?.controller}">
				<li class="fieldcontain">
					<span id="controller-label" class="property-label"><g:message code="permiso.controller.label" default="Controller" /></span>
					
						<span class="property-value" aria-labelledby="controller-label"><g:fieldValue bean="${permisoInstance}" field="controller"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${permisoInstance?.action}">
				<li class="fieldcontain">
					<span id="action-label" class="property-label"><g:message code="permiso.action.label" default="Action" /></span>
					
						<span class="property-value" aria-labelledby="action-label"><g:fieldValue bean="${permisoInstance}" field="action"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${permisoInstance?.mode}">
				<li class="fieldcontain">
					<span id="mode-label" class="property-label"><g:message code="permiso.mode.label" default="Mode" /></span>
					
						<span class="property-value" aria-labelledby="mode-label"><g:fieldValue bean="${permisoInstance}" field="mode"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${permisoInstance?.id}" />
					<g:link class="edit" action="edit" id="${permisoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
