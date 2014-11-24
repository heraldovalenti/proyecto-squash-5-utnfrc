<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.PostulacionTorneo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="torneo" action="show" id="${ torneoInstance.id }"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		
		<div id="list-torneo" class="content scaffold-list" role="main">
			<h1>Postulaciones a torneo</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:if test="${ !postulacionInstanceList.isEmpty() }">
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="club" title="Club" />
					
						<g:sortableColumn property="fecha" title="Fecha" />
					
						<g:sortableColumn property="estado" title="Estado" />
						
						<g:sortableColumn property="observaciones" title="Observaciones" />
						
						<td></td>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ postulacionInstanceList }" status="i" var="postulacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: postulacionInstance, field: "club")}</td>
					
						<td><g:formatDate date="${postulacionInstance.fecha}" format="dd/MM/yyyy" /></td>
						
						<td>${postulacionInstance.estado}</td>
						
						<td>${postulacionInstance.observaciones}</td>
						
						<td>
							<g:if test="${postulacionInstance.esPendiente()}">
								<g:link class="create aceptar-postulacion" controller="torneo" 
								action="aceptarPostulacionTorneo" id="${ postulacionInstance.id }">Aceptar</g:link>
								<g:link class="create rechazar-postulacion" controller="torneo" 
								action="rechazarPostulacionTorneo" id="${ postulacionInstance.id }">Rechazar</g:link>
							</g:if>
						</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			</g:if>
			
			<g:else>
			<p>No existen postulaciones de clubes para el torneo.</p>
			<g:link controller="torneo" action="seleccionarClubParaTorneo">Asignar un club al torneo</g:link>
			</g:else>
			
		</div>
		<r:require modules="torneos, dialogs" />
	</body>
</html>
