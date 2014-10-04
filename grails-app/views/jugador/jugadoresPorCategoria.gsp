<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"	type="text/css" rel="stylesheet">
<meta name="layout" content="main">
</head>
<body>
	<div class="menu_jugador">
		<g:render template="menuCategoriaJugadores" model="['categorias':categorias]" />
	</div>
	<div class="grid_16 mt10 mb10">
		<div class="grid_10">
			<div class="box box-607">
				<h3 class="title">Jugadores</h3>
				<div class="inner-box">
					<g:each in="${jugadores}" var="usuarioInstance">
					<g:render template="jugadorCard" model="['usuarioInstance':usuarioInstance]"/>
					</g:each>
				</div>
			</div>
		</div>
	</div>
	<r:require module="torneos" />
</body>
</html>