<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"
	type="text/css" rel="stylesheet">
<meta name="layout" content="main">
</head>
<body>
	<div class="grid_100 mt10 mb10">
		<div class="grid_total">
			<div class="box box-150-Porcent h2h">
				<h3 class="title">Head to Head</h3>
				<div class="clearfix" id="head2HeadMain">
					<div class="playerColumn">
						<a class="playerName">${jugador1?.toString()}</a>
						<div id="playerBioHeadShot">
							<p id="playerBioHeadShotCopy" class="IE6pngFix">&copy; ACS</p>
							<img height="198" width="148"src="<g:imagenPerfilJugador usuario="${ jugador1 }"/>" />							
						</div>
						<div class="playerInfoRank">
							<g:each in="${jugador1?.jugador?.rankings}"
									var="ranking">
									<g:if
										test="${ranking?.categoria?.nombre == categoriaJugador1}">
										<span># ${ranking?.puesto}</span>
									</g:if>
							</g:each> 
							${categoriaJugador1}
						</div>
						<div class="playerInfoRank">
							<span>${titulosJugador1 }</span> Titulos
						</div>
						<div class="playerInfoRank">
							<span>${finalesJugador1 }</span> Finales
						</div>

					</div>
					<table cellspacing="0" cellpadding="0" id="head2HeadMainTable">
						<tbody>
							<tr>
								<th colspan="2">
									<table cellspacing="0" cellpadding="0" border="0">
										<tbody>
											<tr>
												<th width="93" class="player1Rank">${jugador1Ganados }</th>
												<th width="126">Victorias</th>
												<th width="93" class="player2Rank">${jugador2Ganados }</th>
											</tr>
										</tbody>
									</table>
								</th>
							</tr>
							<tr class="labelRow">
								<td colspan="2">Edad</td>
							</tr>
							<tr class="infoRow">
								<td class="firstCell">${edadJugador1} -  (<g:formatDate date="${jugador1?.persona?.fechaNacimiento}" format="dd-MM-yyyy"/>)</td>
								<td>${edadJugador2} -  (<g:formatDate date="${jugador2?.persona?.fechaNacimiento}" format="dd-MM-yyyy"/>)</td>
							</tr>
							<tr class="labelRow">
								<td colspan="2">Lugar de Nacimiento</td>
							</tr>
							<tr class="infoRow">
								<td class="firstCell">${jugador1?.persona?.lugarNacimiento}</td>
								<td>${jugador2?.persona?.lugarNacimiento}</td>
							</tr>
							<tr class="labelRow">
								<td colspan="2">Residencia</td>
							</tr>
							<tr class="infoRow">
								<td class="firstCell">${jugador1?.persona?.domicilio?.toString()}</td>
								<td>${jugador2?.persona?.domicilio?.toString()}</td>
							</tr>
							<tr class="labelRow">
								<td colspan="2">Altura</td>
							</tr>
							<tr class="infoRow">
								<td class="firstCell">${jugador1?.jugador?.altura} cm</td>
								<td>${jugador2?.jugador?.altura} cm</td>
							</tr>
							<tr class="labelRow">
								<td colspan="2">Peso</td>
							</tr>
							<tr class="infoRow">
								<td class="firstCell">${jugador1?.jugador?.peso} kg</td>
								<td>${jugador2?.jugador?.peso} kg</td>
							</tr>
							<tr class="labelRow">
								<td colspan="2">Brazo</td>
							</tr>
							<tr class="infoRow">
								<td class="firstCell">${jugador1?.jugador?.brazo}</td>
								<td>${jugador2?.jugador?.brazo}</td>
							</tr>
							<tr class="labelRow">
								<td colspan="2">Juega desde</td>
							</tr>
							<tr class="infoRow">
								<td class="firstCell"><g:formatDate date="${jugador1?.jugador?.juegaDesde}" format="dd-MM-yyyy"/></td>
								<td><g:formatDate date="${jugador2?.jugador?.juegaDesde}" format="dd-MM-yyyy"/></td>
							</tr>
						</tbody>
					</table>

					<div class="playerColumn">
						<a class="playerName">${jugador2?.toString()}</a>
						<div id="playerBioHeadShot">
							<p id="playerBioHeadShotCopy" class="IE6pngFix">&copy; ACS</p>
							<img height="198" width="148"src="<g:imagenPerfilJugador usuario="${ jugador2 }"/>" />	
						</div>
						<div class="playerInfoRank">
							<g:each in="${jugador2?.jugador?.rankings}" var="ranking">
								<g:if test="${ranking?.categoria?.nombre == categoriaJugador2}">
									<span># ${ranking?.puesto}</span>
								</g:if>
							</g:each>
							${categoriaJugador2}
						</div>
						<div class="playerInfoRank">
							<span>${titulosJugador2 }</span> Titulos
						</div>
						<div class="playerInfoRank">
							<span>${finalesJugador2 }</span> Finales
						</div>

					</div>
				</div>
				<div class="act h2h">
				<g:each in="${enfrentamientos}" var="partido">
					<ul class="actividad-list">					
					
					<li class="h2h_year par h2hli"><a href="#">${partido?.fecha}</a></li>
					<li class="h2h_torneo par h2hli">${partido?.torneo}</li>
					<li class="h2h_categoria par h2hli">${partido?.categoria}</li>
					<li class="h2h_ronda par h2hli">8VOS. DE FINAL</li>
					<li class="h2h_ganador par h2hli">${partido?.resultado?.ganador?.toString()}</li>
					<li class="h2h_resultado par h2hli">3/2</li>	
							
					</ul>
					
				</g:each>
						
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		
	</div>
</body>
</html>