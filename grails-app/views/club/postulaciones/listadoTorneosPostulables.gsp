<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" controller="postulacionTorneo" action="listadoPostulaciones">Volver</g:link></li>
			</ul>
		</div>
		<div id="list-club" class="content scaffold-list" role="main">
			<h1>Torneos postulables</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>	
						<g:sortableColumn property="nombre" title="Nombre" />
					
						<g:sortableColumn property="fechaInicio" title="Fecha inicio" />
					
						<g:sortableColumn property="fechaFin" title="Fecha fin" />
						
						<g:sortableColumn property="puntuable" title="Puntuable" />
						
						<g:sortableColumn property="estado" title="Estado" />
						
						<td></td>
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoInstanceList}" status="i" var="torneoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: torneoInstance, field: "nombre")}</td>
						
						<td>
							<g:formatDate date="${ torneoInstance.fechaInicioTorneo }" format="dd/MM/yyyy"/>
						</td>
						
						<td><g:formatDate date="${ torneoInstance.fechaFinTorneo }" format="dd/MM/yyyy"/></td>
					
						<td><g:formatBoolean boolean="${ torneoInstance.puntuable }" true="Si" false="No"/></td>
						
						<td>${fieldValue(bean: torneoInstance, field: 'estado')}</td>
						
						<td><g:link controller="postulacionTorneo" action="postulacion" id="${ torneoInstance.id }">Postulacion</g:link></td>					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${torneoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>