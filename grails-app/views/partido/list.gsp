
<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="partido">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-partido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-partido" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="fecha" title="${message(code: 'partido.fecha.label', default: 'Fecha')}" />
					
						<th><g:message code="partido.categoria.label" default="Categoria" /></th>
						
						<th><g:message code="partido.jugador1.label" default="Jugador 1" /></th>
						
						<th><g:message code="partido.jugador2.label" default="Jugador 2" /></th>				
						
					
						<th><g:message code="partido.cancha.label" default="Cancha" /></th>				
						
					
						<g:sortableColumn property="estado" title="${message(code: 'partido.estado.label', default: 'Estado')}" />					
						
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${partidoInstanceList}" status="i" var="partidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${partidoInstance.id}">${fieldValue(bean: partidoInstance, field: "fecha")}</g:link></td>
					
						<td>${fieldValue(bean: partidoInstance, field: "categoria")}</td>
						
						<td>${fieldValue(bean: partidoInstance, field: "jugador1")}</td>
						
						<td>${fieldValue(bean: partidoInstance, field: "jugador2")}</td>
								
						<td>${fieldValue(bean: partidoInstance, field: "cancha")}</td>
						
						<td>${fieldValue(bean: partidoInstance, field: "estado")}</td>											
												
						<td><g:link controller="partido" action="cargarResultado" id="${partidoInstance.id}" >Cargar Resultado</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${partidoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
