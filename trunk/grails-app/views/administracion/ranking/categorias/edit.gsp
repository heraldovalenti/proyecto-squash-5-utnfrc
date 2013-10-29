<%@ page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				<li><g:link controller="categoria" action="show" id="${ categoriaInstance?.id }">Volver</g:link></li>
				<li><g:link controller="categoria" action="list">Volver al listado</g:link></li>
			</ul>
		</div>
		<div id="edit-categoria" class="content scaffold-edit" role="main">
			<h1>Edicion de categoria</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${categoriaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${categoriaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${categoriaInstance?.id}" />
				<g:hiddenField name="version" value="${categoriaInstance?.version}" />
				<fieldset class="form">
					<g:render template="/administracion/ranking/categorias/form" />
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="Guardar" />
					<g:actionSubmit class="delete" action="delete" value="Eliminar" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
