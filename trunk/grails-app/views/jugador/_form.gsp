<%@ page import="sgt.Jugador" %>



<div class="fieldcontain ${hasErrors(bean: jugadorInstance, field: 'brazo', 'error')} ">
	<label for="brazo">
		<g:message code="jugador.brazo.label" default="Brazo" />
		
	</label>
	<g:select name="brazo" from="${jugadorInstance.constraints.brazo.inList}" value="${jugadorInstance?.brazo}" valueMessagePrefix="jugador.brazo" noSelection="['': '']"/>
</div>



<div class="fieldcontain ${hasErrors(bean: jugadorInstance, field: 'altura', 'error')} ">
	<label for="altura">
		<g:message code="jugador.altura.label" default="Altura (cm)" />
		
	</label>
	<g:field name="altura" type="number" value="${fieldValue(bean: jugadorInstance, field: 'altura')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jugadorInstance, field: 'peso', 'error')} ">
	<label for="peso">
		<g:message code="jugador.peso.label" default="Peso (Kg)" />
		
	</label>
	<g:field name="peso" type="number" value="${fieldValue(bean: jugadorInstance, field: 'peso')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jugadorInstance, field: 'juegaDesde', 'error')} ">
	<label for="juegaDesde">
		<g:message code="jugador.juegaDesde.label" default="Juega Desde" />
		
	</label>
	<g:datePicker name="juegaDesde" precision="day"  value="${jugadorInstance?.juegaDesde}" default="none" noSelection="['': '']" />
</div>

