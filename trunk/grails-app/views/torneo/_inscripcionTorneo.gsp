<g:if test="${ torneo.inscripcionAbierta() }">
<div class="box box-335 fr mt10 mr5">
	<h3>Inscripcion online</h3>
	<div class="mt10 ml10 mr10 mb10">
		<g:link controller="inscripcionTorneo" action="inscribirJugadorTorneo" 
		params="[idTorneo: torneo.id]" class="button green">Inscripción</g:link>
	</div>
</div>
</g:if>