<%@ page import="sgt.Usuario" %>
<div class="tourSRankWrap" style="margin-right: 3em;">
	<div class="rankingProfileImage">
		<a href="#">
			<img width="108" height="140" 
				src="<g:imagenPerfilJugador usuario="${ usuarioInstance }"/>" />
			<span class="overlayRankings"></span>
		</a>
	</div>
	<div class="singlesInfo">
		<div class="Singles"></div>
		<div class="singlesRankName">
			<span>				
				<a href="#">${ usuarioInstance.persona.nombre }</a>
				<a href="#">${ usuarioInstance.persona.apellido }</a>
			</span>
		</div>		
		<g:each in="${usuarioInstance.jugador.rankings}" var="ranking">
			<g:if test="${ranking.categoria.nombre == categoria}">
			<div class="singlesRank">Posición:
				<span><a href="#"> #${ ranking.puesto }</a></span>
			</div>
			<div class="singlesRank">Puntos:
				<span><a href="#">${ ranking.puntaje }</a></span>
			</div>
			</g:if>
		</g:each>		
		
		<div class="viewFull">
			<g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:usuarioInstance.id,categoria:categoria, 'tipo':tipo]">VER MAS>></g:link>	
		</div>
	</div>
</div>