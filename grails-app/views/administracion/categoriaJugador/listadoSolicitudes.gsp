<%@ page import="sgt.CategoriaJugador"%>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion">
</head>
<body>
	<div id="listadoSolicitudes" class="content scaffold-list">
		<h1>Solicitudes de categoría</h1>
		
		<g:render template="/utils/messages" />
		
		<g:if test="${ solicitudes?.size()>0 }">	
		
		<table>
			<thead>
				<tr>
					<g:sortableColumn property="fechaInicio" title="Fecha de solicitud" />
					<td class="sortable">Jugador</td>
					<td class="sortable">Categoria actual</td>
					<g:sortableColumn property="categoria" title="Categoria solicitada" />
					<td class="sortable">Opciones</td>
				</tr>
			</thead>
			<tbody>
				<g:each in="${ solicitudes }" status="i" var="solicitud">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							<g:formatDate date="${ solicitud.solicitudCategoria.fechaInicio }" format="dd/MM/yyyy"/>
						</td>
						<td>${ solicitud.persona }</td>
						<td>
							${ (solicitud.categoriaActual) ? solicitud.categoriaActual.categoria : "N/A" }
						</td>
						<td>${ solicitud.solicitudCategoria.categoria }</td>
						<td>
							<g:link controller="solicitudCategoria" action="verPerfilJugador" id="${ solicitud.solicitudCategoria.id }">Ver perfil</g:link>
							<g:link controller="solicitudCategoria" action="aceptarSolicitud" id="${ solicitud.solicitudCategoria.id }">Aceptar</g:link>
							<g:link controller="solicitudCategoria" action="rechazarSolicitud" id="${ solicitud.solicitudCategoria.id }">Rechazar</g:link>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${ total }" />
		</div>
		
		</g:if>
			
		<g:else>
			
			<h2>No hay solicitudes de categorías pendientes</h2>	
	
		</g:else>
	</div>
</body>
</html>