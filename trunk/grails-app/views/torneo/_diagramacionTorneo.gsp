<g:if test="${ diagramacion && !diagramacion.isEmpty() }">
<div class="box box-607 fl mt10 ml10 mb10" >
	<h3 class="title-grey">Diagramacion</h3>
	<div id="diagramacion" style="margin: 0px 0px; float: left;" class="" >
		<ul>
			<g:each in="${ diagramacion }" var="detalle" status="i">
			<li>
				<a href="#diagramacion-${ (i + 1) }"><g:formatDate date="${ detalle.fecha }" format="dd/MM"/></a>
			</li>
			</g:each>
		</ul>
		
		<g:each in="${ diagramacion }" var="detalle" status="i">
		<div id="diagramacion-${ (i + 1) }">
			<div class="orden-de-juego fl">
			
				<g:if test="${ detalle.partidos.isEmpty() }"><h1>No partidos para la fecha</h1></g:if>
				<g:each in="${ detalle.partidos }" var="partido">
				
				<div class="headerLiveScoreBox headerScoreboard1000" id="headerLiveScoreBox1">
					<div class="miniScoreBoardLinks">
						<a href="#" class="liveStream">${ partido.categoria.nombre }</a>
						<a href="#" class="liveScoresLink">${ partido.horaDesde }:00</a>
					</div>
					<table cellspacing="1" cellpadding="1" border="0" class="headerLiveScore" style="border: none;">
						<tbody>
							
							<tr height="12" style="border: none;">
								<th>${ partido.rondaPartidoString() }</th>
								<th>Gm</th>
							</tr>
							
							<tr height="18" style="border: none;">
								<td width="135">
									<span class="scoreaboardPlayerName 
									<g:if test="${ partido.resultado?.ganador && partido.resultado.ganador == partido.jugador1 }">
										scoreWin1000Bg 
									</g:if>">
										<a href="" class="miniPlayername">${ partido.jugador1?.persona }</a>
									</span>
								</td>
								<td width="25" class="scoreCell">
									${ partido.resultado?.resultadoJugador1() }
								</td>
							</tr>
							
							<tr height="13" style="border: none;">
								<td width="135">
									<span class="scoreaboardPlayerName 
									<g:if test="${ partido.resultado?.ganador && partido.resultado.ganador == partido.jugador2 }">
										scoreWin1000Bg 
									</g:if>">
										<a href="" class="miniPlayername">${ partido.jugador2?.persona }</a>
									</span>
								</td>
								<td width="25" class="scoreCell">
									${ partido.resultado?.resultadoJugador2() }
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				</g:each>
			</div>
		</div>
		</g:each>
	</div>
</div>

<g:javascript >
	$('#diagramacion').tabs();
</g:javascript>

</g:if>