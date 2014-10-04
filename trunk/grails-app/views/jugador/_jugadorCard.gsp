<%@ page import="sgt.Usuario" %>
<div class="tourSRankWrap">
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
		<div class="singlesRank">Brazo:
		<span>				
				<a href="#">${ usuarioInstance.jugador.brazo }</a>
			</span>
		
		</div>
		<div class="singlesRank">: </div>
		<%--<div class="singlesRank">CLUB: 
			<g:if test="${ torneoInstance?.clubAsignado() }">${ torneoInstance.club.toString() }</g:if>
			<g:else>No asignado</g:else>
		</div>
		--%><div class="viewFull">
			<a href="#" class="viewFull">VER MAS>></a>
		</div>
	</div>
</div>