<%@ page import="sgt.CategoriaJugador"%>
<%@ page import="sgt.SolicitudCategoria"%>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion">
</head>
<body>
	<div id="listadoSolicitudes" class="content scaffold-list" role="main">
		<h1>Solicitudes de categoría</h1>
		
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		
		<table>
			<thead>
				<tr >
					<td class="sortable">Usuario</td>
					<td class="sortable">Apellido</td>
					<td class="sortable">Nombre</td>
					<td class="sortable">Actual</td>
					<td class="sortable">Solicitada</td>
					<td class="sortable">Opciones</td>
				</tr>
			</thead>
			<tbody>
				<g:each in="${ solicitudInstanceList }" status="i" var="solicitud">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${ solicitud.usuario }</td>
						<td>${ solicitud.apellido }</td>
						<td>${ solicitud.nombre }</td>
						<td>${ solicitud.actual }</td>
						<td>${ solicitud.solicitada }</td>
						<td>
							<u>Ver perfil</u>
							<g:link controller="solicitudCategoria" action="denegarSolicitud" id="${ solicitud.idCategoriaJugador }" onclick="return confirm('¿Está seguro?');" >Denegar</g:link>
							<g:link controller="solicitudCategoria" action="aceptarSolicitud" id="${ solicitud.idCategoriaJugador }" onclick="return confirm('¿Está seguro?');" >Aceptar</g:link>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
</body>
</html>