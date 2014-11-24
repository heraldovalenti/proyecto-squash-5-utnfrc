<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.DetalleTorneo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'puntaje.label', default: 'Puntaje')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="torneo" action="show" id="${ torneoInstance?.id }"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
    		<g:link controller="torneo" action="createDetalle"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Agregar categoria</span> </g:link>
		</fieldset>
		
		<div id="list-puntaje" class="content scaffold-list" role="main">
			<h1>Categorias de Torneo</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th>Categoria</th>
						<th>Cupo Maximo</th>
						<th>Opciones</th>
					</tr>
				</thead>
				
				<tbody>
				<g:each in="${detalleTorneoInstanceList}" status="i" var="detalleTorneoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${ detalleTorneoInstance?.categoria }</td>
						<td>${ detalleTorneoInstance?.cupoMaximo }</td>
						<td>
							<g:link controller="torneo" action="deleteDetalle" id="${ detalleTorneoInstance?.id }">Eliminar</g:link>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			
			<div class="pagination">
				<g:paginate total="${ detalleInstanceTotal }" />
			</div>
		</div>
	</body>
</html>
