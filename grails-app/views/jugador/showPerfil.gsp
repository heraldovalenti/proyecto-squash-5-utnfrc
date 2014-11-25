<html>
<head>
	<g:if test="${ layout }">
		<meta name="layout" content="${ layout }">
	</g:if>
	<g:else>
		<meta name="layout" content="main">
	</g:else>
</head>
<body>
	<g:render template="/jugador/perfilJugador" model="${ perfil }" var="perfil"/>
</body>
</html>