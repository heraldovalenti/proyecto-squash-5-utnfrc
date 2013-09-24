
<%@ page import="sgt.TorneoPuntuable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-torneoPuntuable" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${ !ordenesAnualesValidos }">
				<ul class="errors" role="alert">
					<li>Los órdenes anuales asignados a los torneos activos no son válidos.</li>
				</ul>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'torneoPuntuable.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="ordenAnual" title="${message(code: 'torneoPuntuable.ordenAnual.label', default: 'Orden Anual')}" />
					
						<g:sortableColumn property="activo" title="${message(code: 'torneoPuntuable.activo.label', default: 'Activo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoPuntuableInstanceList}" status="i" var="torneoPuntuableInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${torneoPuntuableInstance.id}">${fieldValue(bean: torneoPuntuableInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "ordenAnual")}</td>
					
						<td><g:formatBoolean boolean="${torneoPuntuableInstance.activo}" true="Activo" false="No activo"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			
			<div class="pagination">
				<g:paginate total="${torneoPuntuableInstanceTotal}" />
			</div>
			<h2>*Click en algún item para más opciones</h2>
		</div>
	</body>
</html>
