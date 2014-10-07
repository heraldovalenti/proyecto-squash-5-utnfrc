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
		<div class="singlesRankName">
			<span>
				<g:link controller="torneo" action="verTorneo" params="[idTorneo: torneoInstance.id]"
				class="viewFull" style="overflow: hidden;">${ torneoInstance.nombre }</g:link>
			</span>
		</div>
		<div class="singlesRank">INICIO: <g:formatDate date="${ torneoInstance?.fechaInicioTorneo }" format="dd-MM-yy"/></div>
		<div class="singlesRank">FIN: <g:formatDate date="${ torneoInstance?.fechaFinTorneo }" format="dd-MM-yy"/></div>
		<div class="singlesRank">CLUB: 
			<g:if test="${ torneoInstance?.clubAsignado() }">${ torneoInstance.club.toString() }</g:if>
			<g:else>No asignado</g:else>
		</div>
		<div class="viewFull">
			<g:link controller="torneo" action="verTorneo" params="[idTorneo: torneoInstance.id]"
				class="viewFull">VER MAS>></g:link>
		</div>
	</div>
</div>