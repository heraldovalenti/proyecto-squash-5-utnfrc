<html>
<head>
	<meta name="layout" content="jugador">
</head>
<body>
	<h3>Categoria de jugador</h3>
	
	<g:if test="${ solicitud }">
		<div>
		${ solicitud }
		<g:link controller="jugador" action="cancelarSolicitudCategoria">Cancelar solicitud</g:link>
		</div>
	</g:if>
	<g:else>
		<div>
		<g:link controller="jugador" action="solicitudCategoria">Solicitar categoria</g:link>
		</div>
	</g:else>
	
	<g:if test="${ categoria }">
		<div>
		${ categoria }
		</div>
	</g:if>
	
	<g:if test="${ historial.size() > 0 }">
	<ul>
	<g:each in="${ historial }" var="categoria">
		<li>${ categoria }</li>
	</g:each>
	</ul>
	</g:if>
	
</body>
</html>