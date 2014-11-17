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
				<g:if test="${ titulosJugador==null }"><span><a style="color: white;" href="#"> 0</a></span></g:if>							
				<span><a style="color: white;" href="#"> ${ titulosJugador?.size() }</a></span> titulos					
			</div>
			<div id="playerBioInfoFinales">		
				<g:if test="${ finalesJugador==null }"><span><a style="color: white;" href="#"> 0</a></span></g:if>								
				<span><a style="color: white;" href="#"> ${ finalesJugador?.size() }</a></span> finales				
			</div>
			</div>
		</div>
	<input type="hidden" id="personaId" value="${usuarioInstance.persona.id}">	
	<div class="box box-607 mt10">
	
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
	
	<div class="box box-607 mt10">
	
	<h3 class=title-grey>Titulos y Finales</h3>
	<ul class="actividad-list">
	<li style="width: 98%%;"><p class="mt10"><b>Titulos</b></p></li>
	<g:if test="${ !titulosJugador }">
			<li style="width: 98%%;"><p>${usuarioInstance?.persona?.nombre} no posee titulos</p></li>
	</g:if>
	<g:each in="${titulosJugador}" var="titulos">
	<g:if test="${titulos!=null }">
	<li style="width: 98%%;"><p>${titulos?.torneo} - ${titulos?.categoria}</p><br></li>
	</g:if>
	
	</g:each>
	</ul>
	
	<ul class="actividad-list">	
	<li style="width: 98%%;"><p class="mt10"><b>Finales</b></p></li>
	<g:if test="${ !finalesJugador }">
			<li style="width: 98%%;"><p>${usuarioInstance?.persona?.nombre} no ha participado de finales</p></li>
	</g:if>
	<g:each in="${finalesJugador}" var="finales">
	<g:if test="${finales!=null }">
	<li style="width: 98%%;"><p>${finales?.torneo} - (${finales?.categoria})</p><br></li>
	</g:if>
	
	</g:each>
	</ul>	
	
	</div>	
</div>

<div class="grid_6 adds alpha omega mt10">
	<div class="box mb10 box-335">
	<h3 class="title-grey">Comparar a ${usuarioInstance?.persona?.nombre} con ..</h3>
	<div class="inner-box">
	<input type="text" name="s-player-comp" id="buscadorContrincante" placeholder="Escribir Nombre Jugador" style="width: 100%;"/>
	<input type="hidden" id="contrincanteId" id="ply-1" name="ply-1" value="733">
	<div id= "mostrarContrincante">
	<span class="lupa" style="padding: 5px;"></span>
	</div> 
	</div>
	</div>
	
	<div class="box mb10 box-335 mt10">
	<h3 class="title-grey">Partidos en el torneo actual</h3>
	<div class="inner-box">
	<g:if test="${ !partidosTorneo }">
			<li style="width: 98%%;"><p>${usuarioInstance?.persona?.nombre} no ha participado del Torneo Actual</p></li>
	</g:if>
	<g:each in="${partidosTorneo}" var="partido">
	<g:if test="${partidosTorneo!=null }">
	<li style="width: 98%%;"><p><b>${partido?.rondaPartidoString()}:</b><g:if test="${partido?.jugador1 == usuarioInstance}">
	<g:if test="${!partido?.jugador2}">(Paso directo)</g:if>
	<g:else> vs ${partido?.jugador2}</g:else> </g:if>
	<g:elseif test="${partido?.jugador2 == usuarioInstance}">
	<g:if test="${!partido?.jugador1}">(Paso directo)</g:if><g:else>  vs ${partido?.jugador1}</g:else> </g:elseif>
	<g:if test="${ !partido?.resultado }">
			(A disputarse)</g:if>	
	<g:if test="${partido?.resultado!=null && partido?.resultado?.ganador == usuarioInstance}"> (Ganador)</g:if>
	<g:elseif test="${partido?.resultado!=null && partido?.resultado?.ganador != usuarioInstance}">(Ganó ${partido?.resultado?.ganador} )</g:elseif></p>
	
	</g:if>
	</g:each>
	</div>	
</div>

</div>
</body>
</html>