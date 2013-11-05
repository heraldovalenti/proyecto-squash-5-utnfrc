<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.DetalleTorneo" %>
<%@ page import="sgt.Categoria" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" controller="torneo" action="show" id="${ torneoInstance?.id }">Volver</g:link></li>
			</ul>
		</div>
		<div id="show-torneo" class="content scaffold-show" role="main">
			<h1>Diagramacion de torneo</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<h5>Seleccione una categoria a diagramar</h5>
			
			<table>
				<thead>
					<tr>
						
						<g:sortableColumn property="categoria" title="categoria" />
					
						<td>Cantidad inscriptos</td>
						
						<td></td>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ detallesInstanceList }" status="i" var="detalleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${ detalleInstance.categoria?.toString() }</td>
					
						<td>${ detalleInstance.cantidadInscriptos() }</td>
						
						<td><g:link controller="diagramacion" action="generarSembrado" id="${ detalleInstance.id }">Seleccionar</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>