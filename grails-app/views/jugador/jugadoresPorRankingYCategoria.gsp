<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"	type="text/css" rel="stylesheet">
<meta name="layout" content="main">
</head>
<body>
	<div class="menu_jugador" style="margin-top: 0.8em;">
		<g:render template="menuCategoriaJugadores" model="['categorias':categorias,'tipo':tipo]" />
	</div>
	<div class="grid_16 mt10 mb10">
		<div class="grid_10">
			<div class="box box-607" style="margin-left: 2em;width: 50em;">
				<h3 class="title">Ranking de Jugadores: ${categoriaSeleccionada}</h3>
				<div class="inner-box">
					<g:each in="${jugadores}" var="usuarioInstance">
					<g:render template="rankingJugadorCard" model="['usuarioInstance':usuarioInstance, 'categoria':categoriaSeleccionada, 'tipo':tipo]"/>
					</g:each>
				</div>
			</div>
		</div>
	</div>
	<r:require module="torneos" />
</body>
</html>