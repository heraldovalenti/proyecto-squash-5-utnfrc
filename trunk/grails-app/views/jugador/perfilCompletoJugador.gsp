<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"	type="text/css" rel="stylesheet">
<meta name="layout" content="main">
<r:require module="perfilJugador"/>
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
	<input type="hidden" id="personaId" value="${usuarioInstance.persona.id}">	
	<div class="box box-607  mt10">
	
	<h3 class=title-grey>Actividad de ${usuarioInstance.persona.nombre} ${usuarioInstance.persona.apellido} en el ${year } <g:select name="year" from="${2014..2000 }" value="${ year }"
					class="profile-year" id="calendar_year" /></h3>
	<ul class="actividad-list">
	<g:if test="${ !torneos }">
			<h1 class="mt20">${usuarioInstance.persona.nombre} no ha participado en torneos el ${year }</h1>
	</g:if>
	<g:each in="${torneos}" var="torneoInstance">
	<g:if test="${torneoInstance!=null }">
	<li class="torneo par">${torneoInstance?.torneo}</li>
	<li class="categoria par">${torneoInstance?.categoria}</li>
	<li class="puesto par">${torneoInstance?.rondaPartidoString()}</li>	
	</g:if>
	
	</g:each>
	
	</ul>
	
	
	</div>
	
</div>
</body>
</html>