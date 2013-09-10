
<%@ page import="sgt.ResultadosPartido" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'resultadosPartido.label', default: 'ResultadosPartido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-resultadosPartido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="create" action="create"><g:message code="Nuevo Resultado" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-resultadosPartido" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="resultadosPartido.ganador.label" default="Ganador" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${resultadosPartidoInstanceList}" status="i" var="resultadosPartidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${resultadosPartidoInstance.id}">${fieldValue(bean: resultadosPartidoInstance, field: "ganador")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${resultadosPartidoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
