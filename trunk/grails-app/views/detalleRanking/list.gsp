
<%@ page import="sgt.DetalleRanking" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'detalleRanking.label', default: 'DetalleRanking')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-detalleRanking" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-detalleRanking" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="desde" title="${message(code: 'detalleRanking.desde.label', default: 'Desde')}" />
					
						<g:sortableColumn property="hasta" title="${message(code: 'detalleRanking.hasta.label', default: 'Hasta')}" />
					
						<g:sortableColumn property="posicionTorneo" title="${message(code: 'detalleRanking.posicionTorneo.label', default: 'Posicion Torneo')}" />
					
						<g:sortableColumn property="puntos" title="${message(code: 'detalleRanking.puntos.label', default: 'Puntos')}" />
					
						<th><g:message code="detalleRanking.torneo.label" default="Torneo" /></th>
					
						<th><g:message code="detalleRanking.torneoPuntuable.label" default="Torneo Puntuable" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${detalleRankingInstanceList}" status="i" var="detalleRankingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${detalleRankingInstance.id}">${fieldValue(bean: detalleRankingInstance, field: "desde")}</g:link></td>
					
						<td><g:formatDate date="${detalleRankingInstance.hasta}" /></td>
					
						<td>${fieldValue(bean: detalleRankingInstance, field: "posicionTorneo")}</td>
					
						<td>${fieldValue(bean: detalleRankingInstance, field: "puntos")}</td>
					
						<td>${fieldValue(bean: detalleRankingInstance, field: "torneo")}</td>
					
						<td>${fieldValue(bean: detalleRankingInstance, field: "torneoPuntuable")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${detalleRankingInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
