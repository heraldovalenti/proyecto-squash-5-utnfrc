
<%@ page import="sgt.Jugador" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'jugador.label', default: 'Jugador')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-jugador" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-jugador" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="brazo" title="${message(code: 'jugador.brazo.label', default: 'Brazo')}" />
					
						<g:sortableColumn property="imagen" title="${message(code: 'jugador.imagen.label', default: 'Imagen')}" />
					
						<g:sortableColumn property="altura" title="${message(code: 'jugador.altura.label', default: 'Altura')}" />
					
						<g:sortableColumn property="peso" title="${message(code: 'jugador.peso.label', default: 'Peso')}" />
					
						<g:sortableColumn property="juegaDesde" title="${message(code: 'jugador.juegaDesde.label', default: 'Juega Desde')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${jugadorInstanceList}" status="i" var="jugadorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${jugadorInstance.id}">${fieldValue(bean: jugadorInstance, field: "brazo")}</g:link></td>
					
						<td>${fieldValue(bean: jugadorInstance, field: "imagen")}</td>
					
						<td>${fieldValue(bean: jugadorInstance, field: "altura")}</td>
					
						<td>${fieldValue(bean: jugadorInstance, field: "peso")}</td>
					
						<td><g:formatDate date="${jugadorInstance.juegaDesde}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jugadorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
