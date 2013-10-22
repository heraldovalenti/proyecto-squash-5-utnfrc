
<%@ page import="sgt.ServicioClub" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'servicioClub.label', default: 'ServicioClub')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-servicioClub" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="create" action="create"><g:message code="Nuevo Servicio" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-servicioClub" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'servicioClub.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'servicioClub.nombre.label', default: 'Nombre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${servicioClubInstanceList}" status="i" var="servicioClubInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${servicioClubInstance.id}">${fieldValue(bean: servicioClubInstance, field: "descripcion")}</g:link></td>
					
						<td>${fieldValue(bean: servicioClubInstance, field: "nombre")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${servicioClubInstanceTotal}" />
			</div>
			<div class="paginateButtons">

			<g:paginate total="${ServicioClub.count()}" /> </div> <g:jasperReport jasper="all-servicioClubs" format="PDF" name="Servicio Clubes" />

			
		</div>
	</body>
</html>