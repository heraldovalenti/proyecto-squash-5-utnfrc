<%@ page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<fieldset class="buttons">
    		<g:link controller="categoria" action="list"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		
		<div id="create-categoria" class="content scaffold-create" role="main">
			<h1>Nueva categoria</h1>
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
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="/administracion/ranking/categorias/form" />
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
