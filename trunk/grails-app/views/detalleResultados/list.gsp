
<%@ page import="sgt.DetalleResultados" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'tabla.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'detalleResultados.label', default: 'DetalleResultados')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-detalleResultados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="create" action="create"><g:message code="Nuevo Set" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-detalleResultados" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="jugador1" title="${message(code: 'detalleResultados.jugador1.label', default: 'Jugador1')}" />
					
						<g:sortableColumn property="jugador2" title="${message(code: 'detalleResultados.jugador2.label', default: 'Jugador2')}" />
					
						<g:sortableColumn property="set" title="${message(code: 'detalleResultados.set.label', default: 'Set')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${detalleResultadosInstanceList}" status="i" var="detalleResultadosInstance">
					<tr class="tabla">
					
						<td class="tabla.td"><g:link action="show" id="${detalleResultadosInstance.id}">${fieldValue(bean: detalleResultadosInstance, field: "jugador1")}</g:link></td>
					
						<td class="tabla.td">${fieldValue(bean: detalleResultadosInstance, field: "jugador2")}</td>
					
						<td class="tabla.td">${fieldValue(bean: detalleResultadosInstance, field: "set")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${detalleResultadosInstanceTotal}" />
			</div>
			<g:form>
				<fieldset class="buttons">					
					<g:link controller="detalleResultado" action="create">Nuevo SET</g:link>
					<g:link controller="resultadoPartido" action="create">Finalizar</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
