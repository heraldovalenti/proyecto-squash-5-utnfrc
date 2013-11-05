<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="jugador">
</head>
<body>
	<h3>Inscripcion a torneo</h3>
	
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<g:link controller="inscripciones" action="index">Ir a mis inscripciones</g:link>
</body>
</html>