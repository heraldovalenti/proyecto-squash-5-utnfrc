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
				<a href="#">${ usuarioInstance.persona.apellido }</a>
				<a href="#">${ usuarioInstance.persona.nombre }</a>				
			</span>
		</div>
		<div class="singlesRank">Brazo:
		<span><a href="#">${ usuarioInstance.jugador.brazo }</a></span>		
		</div>
		<div class="singlesRank">Fecha de Nacimiento:
		<span><a href="#"><g:formatDate date="${ usuarioInstance.persona.fechaNacimiento }" format="dd-MM-yyyy"/></a></span>		
		</div>
		
		<div class="viewFull">
			<g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:usuarioInstance.id,categoria:categoria,'tipo':tipo]">VER MAS>></g:link>	
		</div>
	</div>
</div>