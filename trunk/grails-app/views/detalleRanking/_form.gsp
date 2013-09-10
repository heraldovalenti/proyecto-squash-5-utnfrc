<%@ page import="sgt.DetalleRanking" %>



<div class="fieldcontain ${hasErrors(bean: detalleRankingInstance, field: 'desde', 'error')} required">
	<label for="desde">
		<g:message code="detalleRanking.desde.label" default="Desde" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="desde" precision="day"  value="${detalleRankingInstance?.desde}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: detalleRankingInstance, field: 'hasta', 'error')} required">
	<label for="hasta">
		<g:message code="detalleRanking.hasta.label" default="Hasta" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="hasta" precision="day"  value="${detalleRankingInstance?.hasta}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: detalleRankingInstance, field: 'posicionTorneo', 'error')} required">
	<label for="posicionTorneo">
		<g:message code="detalleRanking.posicionTorneo.label" default="Posicion Torneo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="posicionTorneo" type="number" value="${detalleRankingInstance.posicionTorneo}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleRankingInstance, field: 'puntos', 'error')} required">
	<label for="puntos">
		<g:message code="detalleRanking.puntos.label" default="Puntos" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="puntos" value="${fieldValue(bean: detalleRankingInstance, field: 'puntos')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleRankingInstance, field: 'torneo', 'error')} required">
	<label for="torneo">
		<g:message code="detalleRanking.torneo.label" default="Torneo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="torneo" name="torneo.id" from="${sgt.Torneo.list()}" optionKey="id" required="" value="${detalleRankingInstance?.torneo?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleRankingInstance, field: 'torneoPuntuable', 'error')} required">
	<label for="torneoPuntuable">
		<g:message code="detalleRanking.torneoPuntuable.label" default="Torneo Puntuable" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="torneoPuntuable" name="torneoPuntuable.id" from="${sgt.TorneoPuntuable.list()}" optionKey="id" required="" value="${detalleRankingInstance?.torneoPuntuable?.id}" class="many-to-one"/>
</div>

