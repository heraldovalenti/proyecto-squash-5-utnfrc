<%@ page import="sgt.Torneo" %>
<div class="tourSRankWrap">
	<div class="rankingProfileImage">
		<a href="#">
			<img width="108" height="140" 
				src="${ resource(dir: 'images', file: 'acs_afiche.JPG') }">
			<span class="overlayRankings"></span>
		</a>
	</div>
	<div class="singlesInfo">
		<div class="Singles"></div>
		<div class="singlesRankName">
			<span>
				<a href="#">${ torneoInstance.nombre }</a>
			</span>
		</div>
		<div class="singlesRank">INICIO: <g:formatDate date="${ torneoInstance?.fechaInicioTorneo }" format="dd-MM-yy"/></div>
		<div class="singlesRank">FIN: <g:formatDate date="${ torneoInstance?.fechaFinTorneo }" format="dd-MM-yy"/></div>
		<div class="singlesRank">CLUB: </div>
		<div class="viewFull">
			<a href="#" class="viewFull">VER MAS>></a>
		</div>
	</div>
</div>