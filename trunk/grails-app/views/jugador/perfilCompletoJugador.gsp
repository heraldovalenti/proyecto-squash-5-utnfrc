<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"	type="text/css" rel="stylesheet">
<meta name="layout" content="main">
</head>
<body>
	
<div class="grid_16 mt10">
	
		<div id="playerBioInfoCardMain">
			
			<div id="playerBioHeadShot">
				
				<p class="IE6pngFix" id="playerBioHeadShotCopy">&copy; ACS</p>				
				<div class="rankingProfileImage">
					<a href="#">
					<img width="180" height="170"
						src="<g:imagenPerfilJugador usuario="${ usuarioInstance }"/>" />
					<span class="overlayRankings"></span>
					</a>
				</div>
			</div>
			
			<ul id="playerBioInfoList">
				<li style="
				color:#FFFFFF; 
				font-family: inherit;
				font-size: 100%;
				font-style: inherit;
				font-size: 20px;
				margin-top:0.5em;
				margin-bottom:1em;
				">${ usuarioInstance.persona.nombre + " " + usuarioInstance.persona.apellido}</li>
					
				<g:if test="${ usuarioInstance.persona.fechaNacimiento }">
					<li>
						<span>Edad: </span> ${ edad } (<g:formatDate date="${ usuarioInstance.persona.fechaNacimiento }" format="dd-MM-yyyy"/>)
					</li>
				</g:if>
				
				<g:if test="${ usuarioInstance.persona.lugarNacimiento }">
					<li>
						<span>Lugar de Nac: </span> ${ usuarioInstance.persona.lugarNacimiento }
					</li>
				</g:if>	
				
				<g:if test="${ usuarioInstance.persona.domicilio }">
					<li>
						<span>Residencia: </span> ${ usuarioInstance.persona.domicilio.ciudad - usuarioInstance.persona.domicilio.provincia } 
					</li>
				</g:if>				
				
				<g:if test="${ usuarioInstance.jugador.altura }">
					<li><span>Altura: </span> ${ usuarioInstance.jugador.altura  } cm</li>
				</g:if>
				
				<g:if test="${ usuarioInstance.jugador.peso }">
					<li>
						<span>Peso: </span> ${ usuarioInstance.jugador.peso } Kg
					</li>
				</g:if>
				
				<g:if test="${ usuarioInstance.jugador.brazo }">
					<li>
						<span>Brazo: </span> ${ usuarioInstance.jugador.brazo }
					</li>
				</g:if>
				
				<g:if test="${ usuarioInstance.jugador.juegaDesde }">
					<li>
						<span>Juega desde: </span> <g:formatDate date="${ usuarioInstance.jugador.juegaDesde }" format="dd-MM-yyyy"/>
					</li>
				</g:if>
				
				<g:if test="${ categoriaSeleccionada }">
					<li><span>Categoria: </span>${ categoriaSeleccionada }</li>
				</g:if>
			</ul>			
			<div id="playerBioInfoExtra">
			<div id="playerBioInfoRank">
				<g:each in="${usuarioInstance.jugador.rankings}" var="ranking">
					<g:if test="${ranking.categoria.nombre == categoriaSeleccionada}">						
							<span><a style="color: white;" href="#"> #${ ranking.puesto }</a></span>									
					</g:if>
				</g:each>			
			</div>
			<div id="playerBioInfoTitulos">									
				<span><a style="color: white;" href="#"> ${ titulosJugador }</a></span> titulos					
			</div>
			<div id="playerBioInfoFinales">									
				<span><a style="color: white;" href="#"> ${ finalesJugador }</a></span> finales				
			</div>
			</div>
		</div>
	
</div>
</body>
</html>