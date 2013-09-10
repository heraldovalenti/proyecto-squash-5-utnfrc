<%@ page import="sgt.DetalleResultados" %>



<div class="fieldcontain ${hasErrors(bean: detalleResultadosInstance, field: 'jugador1', 'error')} required">
	<label for="jugador1">
		<g:message code="detalleResultados.jugador1.label" default="Jugador1" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="jugador1" from="${0..20}" class="range" required="" value="${fieldValue(bean: detalleResultadosInstance, field: 'jugador1')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleResultadosInstance, field: 'jugador2', 'error')} required">
	<label for="jugador2">
		<g:message code="detalleResultados.jugador2.label" default="Jugador2" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="jugador2" from="${0..20}" class="range" required="" value="${fieldValue(bean: detalleResultadosInstance, field: 'jugador2')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleResultadosInstance, field: 'set', 'error')} ">
	<label for="set">
		<g:message code="detalleResultados.set.label" default="Set" />
		
	</label>
	<g:select name="set" from="${detalleResultadosInstance.constraints.set.inList}" value="${detalleResultadosInstance?.set}" valueMessagePrefix="detalleResultados.set" noSelection="['': '']"/>
</div>

