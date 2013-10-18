<%@ page import="sgt.Puntaje" %>

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
				<li><g:link controller="puntaje" action="list">Volver</g:link></li>
				<li><g:link controller="puntaje" action="volverTorneo">Volver al Torneo Puntuable</g:link></li>
			</ul>
		</div>
		<div id="list-puntaje" class="content scaffold-list" role="main">
			<h1>Detalles de Puntaje</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<p>Categoria: ${ categoriaInstance?.nombre }</p>
			<table>
				<thead>
					<tr>
						<th>Puesto</th>
						<th>Puntos</th>
						<th>Descripcion</th>
						<th>Opciones</th>
					</tr>
				</thead>
				
				<tbody>
				<g:each in="${detallePuntajeInstanceList}" status="i" var="detallePuntajeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${ detallePuntajeInstance?.puesto }</td>
						<td>${ detallePuntajeInstance?.puntaje }</td>
						<td>${ detallePuntajeInstance?.descripcion }</td>
						<td>
							opciones...
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			
			<h2>Agregar detalle:</h2>
			
			<g:hasErrors bean="${detallePuntajeInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${detallePuntajeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			<g:form action="agregarDetalle" >
				<fieldset class="form">
				
					<div class="fieldcontain ${hasErrors(bean: detallePuntajeInstance, field: 'puesto', 'error')} required">
						<label for="puesto">
							<g:message code="detallePuntaje.puesto.label" default="Puesto" />
							<span class="required-indicator">*</span>
						</label>
						<g:field name="puesto" type="number" value="${detallePuntajeInstance?.puesto}" required=""/>
					</div>
					
					<div class="fieldcontain ${hasErrors(bean: detallePuntajeInstance, field: 'puntaje', 'error')} required">
						<label for="puntaje">
							<g:message code="detallePuntaje.puntaje.label" default="Puntaje" />
							<span class="required-indicator">*</span>
						</label>
						<g:field name="puntaje" value="${fieldValue(bean: detallePuntajeInstance, field: 'puntaje')}" type="number" required=""/>
					</div>
					
					<div class="fieldcontain ${hasErrors(bean: detallePuntajeInstance, field: 'descripcion', 'error')} ">
						<label for="descripcion">
							<g:message code="detallePuntaje.descripcion.label" default="Descripcion" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="descripcion" value="${detallePuntajeInstance?.descripcion}"/>
					</div>

				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
			
			
			<div class="pagination">
				<g:paginate total="${puntajeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
