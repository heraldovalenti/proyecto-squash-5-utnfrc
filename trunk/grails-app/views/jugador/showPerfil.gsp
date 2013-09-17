<html>
<head>
	<g:if test="${ layout }">
		<meta name="layout" content="${ layout }">
	</g:if>
	<g:else>
		<meta name="layout" content="main">
	</g:else>
	<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	<title>Perfil de Jugador</title>
</head>
<body>
	<g:if test="${ perfil }">
		<g:render template="/jugador/perfilJugador" model="${ perfil }" var="perfil"/>
	</g:if>
	<g:else>
		<ul class="errors" role="alert">
			<li>Perfil no encontrado</li>
		</ul>
	</g:else>
</body>
</html>