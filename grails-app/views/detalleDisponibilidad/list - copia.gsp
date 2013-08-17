
<%@ page import="modelo.DetalleDisponibilidad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-detalleDisponibilidad" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-detalleDisponibilidad" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
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
					
						<td><g:link action="show" id="${detalleDisponibilidadInstance.id}">${fieldValue(bean: detalleDisponibilidadInstance, field: "dia")}</g:link></td>
					
						<td>${fieldValue(bean: detalleDisponibilidadInstance, field: "desde")}</td>
					
						<td>${fieldValue(bean: detalleDisponibilidadInstance, field: "hasta")}</td>
					
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
