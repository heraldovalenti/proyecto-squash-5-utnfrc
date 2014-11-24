<%@ page import="sgt.Puntaje" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'puntaje.label', default: 'Puntaje')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="puntaje" action="list"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
    		<g:link controller="puntaje" action="createDetalle"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Nuevo detalle</span> </g:link>
		</fieldset>
		
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
						<th>Opciones</th>
					</tr>
				</thead>
				
				<tbody>
				<g:each in="${detallePuntajeInstanceList}" status="i" var="detallePuntajeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${ detallePuntajeInstance?.puesto }</td>
						<td>${ detallePuntajeInstance?.puntos }</td>
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
