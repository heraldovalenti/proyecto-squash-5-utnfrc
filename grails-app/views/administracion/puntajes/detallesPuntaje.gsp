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
				<li><g:link controller="puntaje" action="createDetalle">Nuevo detalle</g:link></li>
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
							<g:link controller="puntaje" action="deleteDetalle" id="${ detallePuntajeInstance?.id }">Eliminar</g:link>
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
