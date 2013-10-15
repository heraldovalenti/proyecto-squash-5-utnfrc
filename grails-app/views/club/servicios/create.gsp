<%@ page import="sgt.ServicioClub" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'servicioClub.label', default: 'ServicioClub')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:link controller="servicioClub" action="list">Volver</g:link>
		
		<div id="create-servicioClub" class="content scaffold-create" role="main">
			<h1>Nuevo servicio</h1>
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
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="/club/servicios/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
