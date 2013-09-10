
<%@ page import="sgt.DetalleDisponibilidad" %>
<!DOCTYPE html>
<html>
	<head>
		<g:if test="${ layout }"> 
			<meta name="layout" content="${ layout }">
		</g:if>
		<g:else> 
			<meta name="layout" content="main">
		</g:else>
		
		
		<g:set var="entityName" value="${message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		
	 	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	 	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="scaffold-head nav" role="navigation" >
			<ul class="scaffold-nav">
				
				<li><g:link class="create" controller="${ controladorDisponibilidad }" action="create"><g:message code="Nueva" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-detalleDisponibilidad" class="content scaffold-list" role="main">
			<h1>
				Disponibilidad Horaria - Ultima actualizacion: <g:formatDate date="${ fechaActualizacion }" format="dd/MM/yyyy HH:mm" />
				
			</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dia" title="${message(code: 'detalleDisponibilidad.dia.label', default: 'Dia')}" />
					
						<g:sortableColumn property="desde" title="${message(code: 'detalleDisponibilidad.desde.label', default: 'Desde')}" />
					
						<g:sortableColumn property="hasta" title="${message(code: 'detalleDisponibilidad.hasta.label', default: 'Hasta')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${detalleDisponibilidadInstanceList}" status="i" var="detalleDisponibilidadInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="${ controladorDisponibilidad }" action="show" id="${detalleDisponibilidadInstance.id}">
							<gestorhorarios:diaCompleto dia="${ detalleDisponibilidadInstance.dia }"/>
						</g:link></td>
						
					
						
						<td><gestorhorarios:aHorasYMinutos value="${ detalleDisponibilidadInstance.desde }"/></td>
					
						<td><gestorhorarios:aHorasYMinutos value="${ detalleDisponibilidadInstance.hasta }"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${detalleDisponibilidadInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
