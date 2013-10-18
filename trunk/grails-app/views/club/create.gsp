<%@ page import="sgt.Club"%>
<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css"
	rel="stylesheet">
<meta name="layout" content="club">
<g:set var="entityName"
	value="${message(code: 'club.label', default: 'Club')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
</head>
<body>
	<a href="#create-club" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>

	<div id="create-club" class="content scaffold-create" role="main">
		<h1>Datos de Club</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${clubInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${clubInstance}" var="error">
					<li
						<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
							error="${error}" /></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		<g:form action="save">
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save"
					value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>