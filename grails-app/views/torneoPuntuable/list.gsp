
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
					
						<g:sortableColumn property="activo" title="${message(code: 'torneoPuntuable.activo.label', default: 'Activo')}" />
					
						<g:sortableColumn property="fin" title="${message(code: 'torneoPuntuable.fin.label', default: 'Fin')}" />
					
						<g:sortableColumn property="inicio" title="${message(code: 'torneoPuntuable.inicio.label', default: 'Inicio')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'torneoPuntuable.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="ordenAnual" title="${message(code: 'torneoPuntuable.ordenAnual.label', default: 'Orden Anual')}" />
					
						<th><g:message code="torneoPuntuable.puntajeTorneo.label" default="Puntaje Torneo" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoPuntuableInstanceList}" status="i" var="torneoPuntuableInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${torneoPuntuableInstance.id}">${fieldValue(bean: torneoPuntuableInstance, field: "activo")}</g:link></td>
					
						<td><g:formatDate date="${torneoPuntuableInstance.fin}" /></td>
					
						<td><g:formatDate date="${torneoPuntuableInstance.inicio}" /></td>
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "ordenAnual")}</td>
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "puntajeTorneo")}</td>
					
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
