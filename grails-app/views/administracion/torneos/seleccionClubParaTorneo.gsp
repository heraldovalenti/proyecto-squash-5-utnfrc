<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.PostulacionTorneo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link controller="torneo" action="show" id="${ torneo.id }"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		
		<div id="seleccion-club" class="content scaffold-list">
			<h1>Asignar club a torneo</h1>
			
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="nombre" title="Club" />
						<td>Cantidad de canchas</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
				<g:each in="${ clubList }" status="i" var="club">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${ club.nombre }</td>
						<td>${ club.cantidadCanchas() }</td>
						<td>
							<g:link controller="club" action="listarClubes" params="[club: club.id]">+Info</g:link>
							<g:link controller="torneo" action="asignarClubATorneo" id="${club.id }">Asignar club</g:link>
						</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			
		</div>
		<r:require modules="torneos, dialogs" />
	</body>
</html>
