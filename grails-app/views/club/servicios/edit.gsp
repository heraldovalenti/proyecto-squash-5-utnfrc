<%@ page import="sgt.ServicioClub" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'servicioClub.label', default: 'ServicioClub')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<ul>
			<li><g:link controller="servicioClub" action="show" id="${ servicioClubInstance.id }">Volver</g:link></li>
		</ul>
		<div id="edit-servicioClub" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
				<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
				<g:hasErrors bean="${servicioClubInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${servicioClubInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${servicioClubInstance?.id}" />
				<g:hiddenField name="version" value="${servicioClubInstance?.version}" />
				<fieldset class="form">
					<g:render template="/club/servicios/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Guardar')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Eliminar')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
