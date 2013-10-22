<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.DetalleTorneo" %>
<%@ page import="sgt.Categoria" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'puntaje.label', default: 'Puntaje')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link controller="torneo" action="verDetalles" id="${ torneoInstance?.id }">Volver</g:link></li>
			</ul>
		</div>
		<div id="list-puntaje" class="content scaffold-list" role="main">
			<h1>Agregar categoria a torneo</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:hasErrors bean="${detalleTorneoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${detalleTorneoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			<g:form controller="torneo" action="agregarDetalle" >
				<fieldset class="form">
				
					<div class="fieldcontain ${hasErrors(bean: detalleTorneoInstance, field: 'categoria', 'error')} required">
						<label for="puesto">
							Categoria
							<span class="required-indicator">*</span>
						</label>
						<g:select id="categoria" name="categoria.id" from="${ categoriaInstanceList }" noSelection="${ null }" optionKey="id" required="" />
						
					</div>
					
					<div class="fieldcontain ${hasErrors(bean: detalleTorneoInstance, field: 'cupoMaximo', 'error')} required">
						<label for="cupoMaximo">
							Cupo maximo
							<span class="required-indicator">*</span>
						</label>
						<g:field id="cupoMaximo" name="cupoMaximo" value="${ detalleTorneoInstance.cupoMaximo }" type="number" required="" min="2"/>
					</div>

				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
			
		</div>
	</body>
</html>
