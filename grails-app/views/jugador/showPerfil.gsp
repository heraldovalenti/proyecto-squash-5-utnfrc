<html>
<head>
	<g:if test="${ layout }">
		<meta name="layout" content="${ layout }">
	</g:if>
	<g:else>
		<meta name="layout" content="main">
	</g:else>
</head>
<body><%--
	<h1>Perfil de jugador</h1>
	--%><g:render template="/jugador/perfilJugador" model="${ perfil }" var="perfil"/>
</body>
</html>