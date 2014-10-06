<%@ page import="sgt.InscripcionTorneo" %>
<%@ page import="sgt.DetalleTorneo" %>

<html>
<head>
	<meta name="layout" content="jugador">
</head>
<body>
	<h3>Inscripciones a torneos</h3>
	
	<g:render template="/utils/messages" />
	
	<g:if test="${ inscripciones }">
	<ul>
		<g:each in="${ inscripciones }" var="inscripcion">
		<li>
			${ inscripcion.detalleTorneo } -
			<g:link controller="inscripcionTorneo" action="cancelarInscripcion" 
				params="[idInscripcion: inscripcion.id]">Cancelar inscripcion</g:link>
		</li>
		</g:each>
	</ul>
	</g:if>
	<g:else>
	<h2>No hay inscripciones activas actualmente</h2>
	</g:else>
</body>
</html>