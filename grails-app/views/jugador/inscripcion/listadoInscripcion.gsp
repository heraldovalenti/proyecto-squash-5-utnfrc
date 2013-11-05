<%@ page import="sgt.InscripcionTorneo" %>
<%@ page import="sgt.DetalleTorneo" %>

<html>
<head>
	
	<meta name="layout" content="jugador">
	<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
</head>
<body>
	<h3>Inscripciones a torneos</h3>
	<g:if test="${ flash.message }">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<g:if test="${ total == 0 }">
		No se han encontrado inscripciones
	</g:if>
	<g:else>
		<ul>
			<g:each in="${ inscripcionInstanceList }" status="i" var="inscripcion">
				<li>
					<g:formatDate date="${ inscripcion.fecha }" format="dd/MM/yyyy" />: Inscripto a 
					<g:link controller="listaTorneo" action="show" id="${ inscripcion.detalleTorneo.torneo.id }">
						${ inscripcion.detalleTorneo.toString() } 
					</g:link>
					[${ inscripcion.estado }] 
					<g:if test="${ inscripcion.puedeCancelar() }">
						<g:link controller="inscripcionTorneo" action="cancelarInscripcion" id="${ inscripcion.id }">Cancelar inscripcion</g:link>
					</g:if>
				</li>
			</g:each>
		</ul>
	</g:else>
	
</body>
</html>