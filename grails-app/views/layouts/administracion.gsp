<%@ page import="sgt.Persona"%>
<html>
<head>
<title>Administracion</title>

<link href="${resource(dir: 'css', file: 'jugador.css') }" type="text/css"	rel="stylesheet">
<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css"	rel="stylesheet">
<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">

<g:layoutHead />
<r:layoutResources />
</head>


<body>

	<!-- CUERPO GENERAL DE LA PAGINA - A llenarse desde el Layout -->
	<div class="menu_jugador">
		<g:render template="/administracion/menuAdministracion" />
	</div>
	<div class="contenido_jugador">
		<g:layoutBody />
	</div>

</body>
</html>