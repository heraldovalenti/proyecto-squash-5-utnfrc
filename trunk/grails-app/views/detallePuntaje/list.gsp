
<%@ page import="sgt.DetallePuntaje" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'detallePuntaje.label', default: 'DetallePuntaje')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-detallePuntaje" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-detallePuntaje" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'detallePuntaje.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="puesto" title="${message(code: 'detallePuntaje.puesto.label', default: 'Puesto')}" />
					
						<g:sortableColumn property="puntaje" title="${message(code: 'detallePuntaje.puntaje.label', default: 'Puntaje')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${detallePuntajeInstanceList}" status="i" var="detallePuntajeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${detallePuntajeInstance.id}">${fieldValue(bean: detallePuntajeInstance, field: "descripcion")}</g:link></td>
					
						<td>${fieldValue(bean: detallePuntajeInstance, field: "puesto")}</td>
					
						<td>${fieldValue(bean: detallePuntajeInstance, field: "puntaje")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${detallePuntajeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
