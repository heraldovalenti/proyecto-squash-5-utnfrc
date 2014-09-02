<%@ page import="sgt.DetalleDisponibilidad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		
		<g:set var="entityName" value="${message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
		
		<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	 	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	</head>
	<body>
		<g:link controller="disponibilidadCancha" action="list" namespace="club">Volver</g:link>
	
		
		<div id="edit-detalleDisponibilidad" class="content scaffold-edit" role="main">
			<h1>Edicion de disponibilidad</h1>
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
			<g:form method="post" >
				<g:hiddenField name="id" value="${detalleDisponibilidadInstance?.id}" />
				<g:hiddenField name="version" value="${detalleDisponibilidadInstance?.version}" />
				<fieldset class="form">
					<g:render template="/detalleDisponibilidad/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" controller="${ controladorDisponibilidad }" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" controller="${ controladorDisponibilidad }" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>