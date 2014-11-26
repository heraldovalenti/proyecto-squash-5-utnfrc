<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"	type="text/css" rel="stylesheet">
<meta name="layout" content="main">
</head>
<body>
	<div class="menu_jugador">
		<g:render template="menuCategoriaJugadores" model="['categorias':categorias, 'tipo':tipo]" />
	</div>
	<div class="grid_16 mt10 mb10">
		<div class="grid_10">
			<div class="box box-607" style="margin-left: 2em;width: 50em;">
				<h3 class="title">Jugadores: ${categoriaSeleccionada}</h3>
				<div class="inner-box">		
					<g:if test="${ !jugadores }">
						<h2 class="mt20">No existen jugadores para la categoria seleccionada</h2>
					</g:if>	
					<g:if test="${jugadores!=null && jugadores.size()>0 }">	
					<g:each in="${jugadores}" var="usuarioInstance">					
					<g:render template="jugadorCard" model="['usuarioInstance':usuarioInstance, 'categoria':categoriaSeleccionada, 'tipo':tipo]"/>					
					</g:each>
					<div class="pagination" style="height: 50px; float:left; width:100%;position:relative">
						<g:paginate total="${total}" action="obtenerJugadores" params="[categoria:categoriaSeleccionada]"/>
					</div>
					</g:if>	
				</div>
			</div>
		</div>
		
	</div>
	
	<r:require module="torneos" />
</body>
</html>