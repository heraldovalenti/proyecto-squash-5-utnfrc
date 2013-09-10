
<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'torneo.label', default: 'Torneo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-torneo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-torneo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'torneo.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="fechaAlta" title="${message(code: 'torneo.fechaAlta.label', default: 'Fecha Alta')}" />
					
						<g:sortableColumn property="fechaInicioInscripcion" title="${message(code: 'torneo.fechaInicioInscripcion.label', default: 'Fecha Inicio Inscripcion')}" />
					
						<g:sortableColumn property="fechaFinInscripcion" title="${message(code: 'torneo.fechaFinInscripcion.label', default: 'Fecha Fin Inscripcion')}" />
					
						<g:sortableColumn property="fechaInicioTorneo" title="${message(code: 'torneo.fechaInicioTorneo.label', default: 'Fecha Inicio Torneo')}" />
					
						<g:sortableColumn property="fechaFinTorneo" title="${message(code: 'torneo.fechaFinTorneo.label', default: 'Fecha Fin Torneo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoInstanceList}" status="i" var="torneoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${torneoInstance.id}">${fieldValue(bean: torneoInstance, field: "nombre")}</g:link></td>
					
						<td><g:formatDate date="${torneoInstance.fechaAlta}" /></td>
					
						<td><g:formatDate date="${torneoInstance.fechaInicioInscripcion}" /></td>
					
						<td><g:formatDate date="${torneoInstance.fechaFinInscripcion}" /></td>
					
						<td><g:formatDate date="${torneoInstance.fechaInicioTorneo}" /></td>
					
						<td><g:formatDate date="${torneoInstance.fechaFinTorneo}" /></td>
					
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
