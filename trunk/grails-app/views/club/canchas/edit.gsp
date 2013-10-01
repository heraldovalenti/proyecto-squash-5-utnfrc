<%@ page import="sgt.Cancha"%>
<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css"
	rel="stylesheet">
<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css"
	rel="stylesheet">
<link href="${resource(dir: 'css', file: 'errors.css') }"
	type="text/css" rel="stylesheet">
<link href="${resource(dir: 'css', file: 'tabla.css') }" type="text/css"
	rel="stylesheet">
<meta name="layout" content="club">
<g:set var="entityName"
	value="${message(code: 'cancha.label', default: 'Cancha')}" />
<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>

	<div id="edit-cancha" class="content scaffold-edit" role="main">
		<g:link controller="club" action="listarCanchas">Volver al listado de canchas</g:link>
		<h1>Datos de cancha</h1>
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
		<g:form method="post">
			<g:hiddenField name="id" value="${canchaInstance?.id}" />
			<g:hiddenField name="version" value="${canchaInstance?.version}" />
			<fieldset class="form">
				<g:render template="/club/canchas/form" />
			</fieldset>
			<fieldset class="buttons">
				<g:actionSubmit class="save" action="updateCancha" controller="cancha"
					value="${message(code: 'default.button.update.label', default: 'Update')}" />
				<g:actionSubmit class="delete" action="deleteCancha" controller="cancha"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					formnovalidate=""
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
