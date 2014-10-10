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
</head>
<body>
	<h1>Perfil de jugador</h1>
	<g:render template="/jugador/perfilJugador" model="${ perfil }" var="perfil"/>
</body>
</html>