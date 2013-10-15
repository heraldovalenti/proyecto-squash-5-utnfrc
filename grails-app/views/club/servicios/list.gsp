
<%@ page import="sgt.ServicioClub" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'servicioClub.label', default: 'ServicioClub')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:link controller="servicioClub" action="create" namespace="club">Nuevo servicio</g:link>
		<div id="list-servicioClub" class="content scaffold-list" role="main">
			<h1>Servicios ofrecidos en Club</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="nombre" title="${message(code: 'servicioClub.nombre.label', default: 'Nombre')}" />
						<g:sortableColumn property="descripcion" title="${message(code: 'servicioClub.descripcion.label', default: 'Descripcion')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${servicioClubInstanceList}" status="i" var="servicioClubInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${servicioClubInstance.id}">${fieldValue(bean: servicioClubInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: servicioClubInstance, field: "descripcion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${servicioClubInstanceTotal}" />
			</div>
			<div class="paginateButtons">
				<g:paginate total="${ServicioClub.count()}" /> 
			</div>

			
		</div>
	</body>
</html>
