<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="create-persona" class="content scaffold-create" role="main">
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
			<g:form action="saveEncargado" >
				<fieldset class="form">
					<g:render template="/club/encargado/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
				<g:hiddenField name="parentId" value="${ parentId }"/>
			</g:form>
		</div>
	</body>
</html>
