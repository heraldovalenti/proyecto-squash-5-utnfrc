<%@ page import="sgt.PostulacionTorneo" %>
<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" controller="postulacionTorneo" action="listadoTorneosPostulables">Postularse a torneos</g:link></li>
			</ul>
		</div>
		<div id="list-club" class="content scaffold-list" role="main">
			<h1>Postulaciones a torneo</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>	
						<g:sortableColumn property="fecha" title="Fecha" />
					
						<g:sortableColumn property="torneo.nombre" title="Torneo" />
					
						<g:sortableColumn property="estado" title="Estado" />
						
						<td></td>
					</tr>
				</thead>
				<tbody>
				<g:each in="${postulacionInstanceList}" status="i" var="postulacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:formatDate date="${ postulacionInstance.fecha }" format="dd/MM/yyyy"/></td>
					
						<td>${fieldValue(bean: postulacionInstance, field: "torneo")}</td>
					
						<td>${fieldValue(bean: postulacionInstance, field: "estado")}</td>
						
						<td><g:link controller="postulacionTorneo" action="cancelarPostulacion" id="${ postulacionInstance.id }">Cancelar</g:link></td>					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${postulacionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>