<%@ page import="sgt.Puntaje" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'puntaje.label', default: 'Puntaje')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="puntaje" action="volverTorneo"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
    		<g:link controller="puntaje" action="create"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Nuevo puntaje</span> </g:link>
		</fieldset>
		
		<div id="list-puntaje" class="content scaffold-list" role="main">
			<h1>Puntajes para Torneo Puntuable</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:if test="${ puntajeInstanceList?.size()>0 }">
			
			<table>
				<thead>
					<tr>
						<th>Categoria</th>
						<th>Opciones</th>
					</tr>
				</thead>
				
				<tbody>
				<g:each in="${puntajeInstanceList}" status="i" var="puntajeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${fieldValue(bean: puntajeInstance, field: "categoria")}</td>
						<td>
							<g:link controller="puntaje" action="verDetalles" id="${ puntajeInstance.id }">Ver detalles</g:link>
							<g:link controller="puntaje" action="delete" id="${ puntajeInstance.id }">Eliminar</g:link>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${puntajeInstanceTotal}" />
			</div>
			
			</g:if>
			
			<g:else>
			
				<h2>No se han cargado puntajes todavia</h2>	
	
			</g:else>
		</div>
	</body>
</html>
