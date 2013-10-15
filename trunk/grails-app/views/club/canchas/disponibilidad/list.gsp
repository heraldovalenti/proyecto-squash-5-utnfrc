
<%@ page import="sgt.DetalleDisponibilidad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		
	 	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	 	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	</head>
	<body>
		<ul>
			<li><g:link controller="cancha" action="show" id="${ idCancha }" >Volver a cancha</g:link></li>
			<li><g:link controller="disponibilidadCancha" action="create">Nueva disponibilidad</g:link></li>
		</ul>
		<div id="list-detalleDisponibilidad" class="content scaffold-list" role="main">
			<h1>
				Disponibilidad Horaria de Cancha
				<g:if test="${ fechaActualizacion }">
				 - Ultima actualizacion: <g:formatDate date="${ fechaActualizacion }" format="dd/MM/yyyy HH:mm" />
				</g:if>
			</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dia" title="${message(code: 'detalleDisponibilidad.dia.label', default: 'Dia')}" />
					
						<g:sortableColumn property="desde" title="${message(code: 'detalleDisponibilidad.desde.label', default: 'Desde')}" />
					
						<g:sortableColumn property="hasta" title="${message(code: 'detalleDisponibilidad.hasta.label', default: 'Hasta')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${detalleDisponibilidadInstanceList}" status="i" var="detalleDisponibilidadInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="disponibilidadCancha" action="edit" id="${detalleDisponibilidadInstance.id}" namespace="club">
							<gestorhorarios:diaCompleto dia="${ detalleDisponibilidadInstance.dia }"/>
						</g:link></td>
						
						<td><gestorhorarios:aHorasYMinutos value="${ detalleDisponibilidadInstance.desde }"/></td>
					
						<td><gestorhorarios:aHorasYMinutos value="${ detalleDisponibilidadInstance.hasta }"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${detalleDisponibilidadInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
