
<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'club.label', default: 'Club')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-club" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="create" action="create"><g:message code="Nuevo Detalle" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-club" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'club.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="razonSocial" title="${message(code: 'club.razonSocial.label', default: 'Razon Social')}" />
					
						<g:sortableColumn property="telefono" title="${message(code: 'club.telefono.label', default: 'Telefono')}" />
					
						<th><g:message code="club.domicilio.label" default="Domicilio" /></th>
					
						<g:sortableColumn property="correo" title="${message(code: 'club.correo.label', default: 'Correo')}" />
					
						<g:sortableColumn property="sitioWeb" title="${message(code: 'club.sitioWeb.label', default: 'Sitio Web')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${clubInstanceList}" status="i" var="clubInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${clubInstance.id}">${fieldValue(bean: clubInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: clubInstance, field: "razonSocial")}</td>
					
						<td>${fieldValue(bean: clubInstance, field: "telefono")}</td>
					
						<td>${fieldValue(bean: clubInstance, field: "domicilio")}</td>
					
						<td>${fieldValue(bean: clubInstance, field: "correo")}</td>
					
						<td>${fieldValue(bean: clubInstance, field: "sitioWeb")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${clubInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
