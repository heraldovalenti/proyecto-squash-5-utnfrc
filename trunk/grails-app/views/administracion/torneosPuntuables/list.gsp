
<%@ page import="sgt.TorneoPuntuable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="torneoPuntuable" action="create"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Nuevo Torneo Puntuable</span> </g:link> 	
		</fieldset>				
		
		<div id="list-torneoPuntuable" class="content scaffold-list" role="main">
			<h1>Lista de Torneos Puntuables</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${ !ordenesAnualesValidos }">
				<ul class="message" role="status">
					<li>Los órdenes anuales asignados a los torneos activos no son válidos</li>
				</ul>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'torneoPuntuable.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="ordenAnual" title="${message(code: 'torneoPuntuable.ordenAnual.label', default: 'Orden Anual')}" />
					
						<g:sortableColumn property="activo" title="${message(code: 'torneoPuntuable.activo.label', default: 'Activo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoPuntuableInstanceList}" status="i" var="torneoPuntuableInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="torneoPuntuable" action="show" id="${torneoPuntuableInstance.id}">${fieldValue(bean: torneoPuntuableInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "ordenAnual")}</td>
					
						<td><g:formatBoolean boolean="${torneoPuntuableInstance.activo}" true="Si" false="No"/></td>
					
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
