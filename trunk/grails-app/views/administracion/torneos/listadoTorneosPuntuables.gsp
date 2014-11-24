<%@ page import="sgt.TorneoPuntuable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'torneo.label', default: 'Torneo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="torneo" action="list"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
			
		<div id="list-torneo" class="content scaffold-list" role="main">
			<h1>Nuevo Torneo</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div class="help">
				<p>Para un torneo puntuable, seleccione algun torneo puntuable de la lista. De lo contrario, 
				<g:link controller="torneo" action="create">CLICK AQUI</g:link></p>
				
				<p>
					Mostrar solo: 
					<g:link controller="torneo" action="listadoTorneosPuntuables" params="[activos: true]">Solo activos</g:link>
					<g:link controller="torneo" action="listadoTorneosPuntuables">Todos</g:link>
				</p>
			</div>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="Nombre" />
					
						<g:sortableColumn property="ordenAnual" title="Orden Anual" />
					
						<g:sortableColumn property="activo" title="Activo" />
						
						<th></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoPuntuableInstanceList}" status="i" var="torneoPuntuableInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: torneoPuntuableInstance, field: "ordenAnual")}</td>
						
						<td><g:formatBoolean boolean="${torneoPuntuableInstance.activo}" true="Si" false="No"/></td>
						
						<td><g:link controller="torneo" action="seleccionarTorneoPuntuable" id="${ torneoPuntuableInstance.id }">Seleccionar</g:link></td>
					
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
