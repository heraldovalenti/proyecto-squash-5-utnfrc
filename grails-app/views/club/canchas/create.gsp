<%@ page import="sgt.Cancha"%>
<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css"
	rel="stylesheet">
<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css"
	rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css"
	rel="stylesheet">
<link href="${resource(dir: 'css', file: 'tabla.css') }" type="text/css"
	rel="stylesheet">
<meta name="layout" content="club">
<g:set var="entityName"
	value="${message(code: 'cancha.label', default: 'Cancha')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
</head>

<body>
	<g:link controller="cancha" action="list" namespace="club">Volver al listado de canchas</g:link>
	<div id="create-cancha" class="content scaffold-create" role="main">
		<h1>Registro de nueva cancha</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${canchaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${canchaInstance}" var="error">
					<li
						<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
							error="${error}" /></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		<g:form action="save">
			<fieldset class="form">
				<g:render template="/club/canchas/form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save"
					value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
