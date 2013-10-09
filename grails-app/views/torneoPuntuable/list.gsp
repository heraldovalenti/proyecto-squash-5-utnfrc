
<%@ page import="sgt.TorneoPuntuable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-torneoPuntuable" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-torneoPuntuable" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'torneoPuntuable.nombre.label', default: 'Nombre')}" />
					
						<th><g:message code="torneoPuntuable.puntajeTorneo.label" default="Puntaje Torneo" /></th>
					
						<g:sortableColumn property="ordenAnual" title="${message(code: 'torneoPuntuable.ordenAnual.label', default: 'Orden Anual')}" />
					
						<g:sortableColumn property="activo" title="${message(code: 'torneoPuntuable.activo.label', default: 'Activo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoPuntuableInstanceList}" status="i" var="torneoPuntuableInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${torneoPuntuableInstance.id}">${fieldValue(bean: torneoPuntuableInstance, field: "nombre")}</g:link></td>
					
						<td>
							<g:if test="${ torneoPuntuableInstance.puntajeTorneo }">Si</g:if>
							<g:else>No</g:else>
						</td>
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "ordenAnual")}</td>
					
						<td><g:formatBoolean boolean="${torneoPuntuableInstance.activo}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${torneoPuntuableInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
