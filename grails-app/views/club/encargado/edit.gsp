<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:link controller="encargado" action="datosEncargado">Volver</g:link>
		<div id="edit-persona" class="content scaffold-edit" role="main">
			<h1>Encargado de Club</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${personaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${personaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${personaInstance?.id}" />
				<g:hiddenField name="version" value="${personaInstance?.version}" />
				
				<fieldset class="form">
					<g:render template="/club/encargado/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="updateEncargado" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>