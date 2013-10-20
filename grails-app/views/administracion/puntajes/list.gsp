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
				<li><g:link controller="puntaje" action="volverTorneo">Volver</g:link></li>
				<li><g:link class="create" controller="puntaje" action="create">Nuevo puntaje</g:link></li>
			</ul>
		</div>
		<div id="list-puntaje" class="content scaffold-list" role="main">
			<h1>Puntajes para Torneo Puntuable</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th>Categoria</th>
						<th>Opciones</th>
					</tr>
				</thead>
				
				<tbody>
				<g:each in="${puntajeInstanceList}" status="i" var="puntajeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${fieldValue(bean: puntajeInstance, field: "categoria")}</td>
						<td>
							<g:link controller="puntaje" action="verDetalles" id="${ puntajeInstance.id }">Ver detalles</g:link>
							<g:link controller="puntaje" action="delete" id="${ puntajeInstance.id }">Eliminar</g:link>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${puntajeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
