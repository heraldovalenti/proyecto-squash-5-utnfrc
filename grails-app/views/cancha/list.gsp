
<%@ page import="sgt.Cancha" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cancha.label', default: 'Cancha')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-cancha" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="create" action="create"><g:message code="Nueva Cancha" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-cancha" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="ancho" title="${message(code: 'cancha.ancho.label', default: 'Ancho')}" />
					
						<g:sortableColumn property="largo" title="${message(code: 'cancha.largo.label', default: 'Largo')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'cancha.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="tipoSuelo" title="${message(code: 'cancha.tipoSuelo.label', default: 'Tipo Suelo')}" />
					
						<th><g:message code="cancha.disponibilidad.label" default="Disponibilidad" /></th>
					
						<g:sortableColumn property="paredes" title="${message(code: 'cancha.paredes.label', default: 'Paredes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${canchaInstanceList}" status="i" var="canchaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${canchaInstance.id}">${fieldValue(bean: canchaInstance, field: "ancho")}</g:link></td>
					
						<td>${fieldValue(bean: canchaInstance, field: "largo")}</td>
					
						<td>${fieldValue(bean: canchaInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: canchaInstance, field: "tipoSuelo")}</td>
					
						<td>${fieldValue(bean: canchaInstance, field: "disponibilidad")}</td>
					
						<td>${fieldValue(bean: canchaInstance, field: "paredes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${canchaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
