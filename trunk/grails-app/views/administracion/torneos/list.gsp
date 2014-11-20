
<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'torneo.label', default: 'Torneo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" >
			<ul>
				<li><g:link class="create" controller="torneo" action="nuevoTorneo">Nuevo Torneo</g:link></li>
			</ul>
		</div>
		<div id="list-torneo" class="content scaffold-list" >
			<h1>Listado de Torneos</h1>
			
			<g:render template="/utils/messages" />
			
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="Nombre" />
					
						<g:sortableColumn property="fechaInicioTorneo" title="Inicio Torneo" />
					
						<g:sortableColumn property="fechaFinTorneo" title="Fin Torneo" />
						
						<g:sortableColumn property="estado" title="Estado" />
						
						<g:sortableColumn property="puntuable" title="Puntuable" />
						
						<g:sortableColumn property="club" title="Club" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoInstanceList}" status="i" var="torneoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${torneoInstance.id}">${fieldValue(bean: torneoInstance, field: "nombre")}</g:link></td>
					
						<td><g:formatDate date="${torneoInstance.fechaInicioTorneo}" format="dd/MM/yyyy" /></td>
						
						<td><g:formatDate date="${torneoInstance.fechaFinTorneo}" format="dd/MM/yyyy" /></td>
						
						<td>${fieldValue(bean: torneoInstance, field: "estado")}</td>
						
						<td><g:formatBoolean boolean="${ torneoInstance?.puntuable }" true="Si" false="No"/></td>
						
						<td>
							<g:if test="${ torneoInstance?.club }">
								${fieldValue(bean: torneoInstance, field: "club")}		
							</g:if>
							<g:else>No asignado</g:else>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${torneoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
