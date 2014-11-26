<head>
	<r:require module="menu" /> 
</head>

<body>
<div class="box mb10">
	<div id="news-result" class="inner-box">
		<ul class="ul-admin">
			<li><g:link controller="administracion">Panel de inicio</g:link></li>
			<li><g:link controller="torneo">Torneos</g:link>
			<ul class="menu" style="padding-left: 10px !important;">
				<li style="display:none;"><g:link controller="torneoPuntuable" title="Torneos Puntuables">Torneos Puntuables</g:link></li> 
				<li style="display:none;"><g:link controller="torneo" action="verInscriptosPorTorneo" title="Gráfico de Cantidad de Jugadores Inscriptos a Torneos por Año">Inscriptos en Torneo por Año</g:link></li>				
			</ul>		
			<li><g:link controller="categoria">Categorias</g:link></li>
			<li><g:link controller="solicitudCategoria" action="list">Solicitudes de categoria</g:link></li>
			<li><g:link controller="usuarioScaffold">Usuarios</g:link></li>	
			<li><g:link controller="club" action="listarClubes">Clubes</g:link>
			<ul class="menu" style="padding-left: 10px !important;">
				<li style="display:none;"><g:link controller="club" title="Gráfíco de Disponibilidad Horaria de Clubes" action="verClubesConMayorDisponibilidad">Clubes Mayor Disponibilidad</g:link></li>
			</ul>
			</li>	
			<li><g:link controller="jugador" action="obtenerJugadores" params="[categoria:'Primera']">Jugadores</g:link>
			<ul class="menu" style="padding-left: 10px !important;">
				<li style="display:none;"><g:link controller="jugador" title="Gráfíco de Jugadores por Categoría" action="verPorcentajeJugadoresPorCategoria">Jugadores por Categoría</g:link></li>
			</ul>
			</li>			
								
			<li><g:link controller="rol">Permisos</g:link></li>
			<li><g:link controller="usuario" action="logout">Cerrar sesión</g:link></li>					
		</ul>
	</div>
</div>
</body>

