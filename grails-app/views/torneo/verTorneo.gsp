<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
</head>
<body>
	<div class="grid_16 mt10 mb10">
		<div class="grid_10">
			<div class="box box-607">
				
				<g:render template="/utils/messages" />
				
				<g:if test="${ !torneo }">
					<h2>Torneo no encontrado...</h2>
				</g:if>
				
				<g:if test="${ torneo }">
				<h3 class="title">${ torneo.nombre }</h3>
				<div class="inner-box">
					<ul>
						<li>fechaAlta: ${ torneo.fechaAlta }</li>
						<li>fechaInicioTorneo: ${ torneo.fechaInicioTorneo }</li>
						<li>fechaFinTorneo: ${ torneo.fechaFinTorneo }</li>
						<li>fechaInicioInscripcion: ${ torneo.fechaInicioInscripcion }</li>
						<li>fechaFinInscripcion: ${ torneo.fechaFinInscripcion }</li>
						<li>estado: ${ torneo.estado }</li>
						<li>club: ${ torneo.club }</li>
						<li>puntuable: ${ torneo.puntuable }</li>
						<li>imagen: ${ torneo.imagen }</li>
						<li>detalles: ${ torneo.detalles }</li>
					</ul>
					<g:link controller="inscripcionTorneo" action="inscribirJugadorTorneo" 
						params="[idTorneo: torneo.id]">Inscripcion</g:link>
				</div>
				</g:if>
			</div>
		</div>
	</div>
</body>
</html>