<%@ page import="sgt.DetalleDisponibilidad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		
		<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	 	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	</head>
	<body>
		<g:link controller="disponibilidadCancha" action="list">Volver</g:link>
		<div id="create-detalleDisponibilidad" class="content scaffold-create" role="main">
			<h1>Nueva disponibilidad</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${detalleDisponibilidadInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${detalleDisponibilidadInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form controller="disponibilidadCancha" action="save" namespace="club">
				<fieldset class="form">
					<g:render template="/club/canchas/disponibilidad/form" />
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
