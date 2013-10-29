<%@ page import="sgt.Torneo" %>
<div>
	<p>--------</p>
	<p>${ torneoInstance?.nombre }</p>
	<p>Desde <g:formatDate date="${ torneoInstance?.fechaInicioTorneo }" format="dd/MM/yy"/></p>
	<p>Hasta <g:formatDate date="${ torneoInstance?.fechaFinTorneo }" format="dd/MM/yy"/></p>
	<p>club asignado</p>
	<g:if test="${ torneoInstance?.inscripcionAbierta() }">
		<p><u>>>Inscripcion</u></p>
	</g:if>
	<g:else>
		<p>>>Inscripcion abre <g:formatDate date="${ torneoInstance?.fechaInicioInscripcion }" format="dd/MM/yy"/></p>
	</g:else>
	<u>>>Info</u>
	<p>--------</p>
</div>