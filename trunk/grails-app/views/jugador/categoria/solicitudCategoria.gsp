<%@ page import="sgt.Categoria" %>
<%@ page import="sgt.CategoriaJugador" %>

<html>
<head>
	<meta name="layout" content="jugador">
	<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
</head>
<body>
	<h3>Solicitud de Categoría de jugador</h3>
	<g:link controller="categoriaJugador" action="index">Volver</g:link>
	
	<div id="create-categoriaJugador" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${categoriaJugadorInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${categoriaJugadorInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
		<g:form controller="categoriaJugador" action="save" >
			<fieldset class="form">
				
				<div class="fieldcontain ${hasErrors(bean: categoriaJugadorInstance, field: 'categoria', 'error')} ">
					<label for="categoria">Categoría</label>
					<g:select name="categoria" from="${ categoriaInstanceList }" value="${categoriaJugadorInstance?.categoria}" valueMessagePrefix="categoriaJugador.categoria" noSelection="['': '']"/>
				</div>
				
				<div class="fieldcontain ${hasErrors(bean: categoriaJugadorInstance, field: 'descripcion', 'error')} ">
					<label for="descripcion">Observaciones</label>
					<g:textArea name="descripcion" value="${categoriaJugadorInstance?.descripcion}"/>
				</div>
		
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Registrar" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>