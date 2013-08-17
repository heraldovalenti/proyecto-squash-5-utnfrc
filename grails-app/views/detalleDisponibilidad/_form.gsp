<%@ page import="modelo.DetalleDisponibilidad" %>



<div class="fieldcontain ${hasErrors(bean: detalleDisponibilidadInstance, field: 'dia', 'error')} required">
	<label for="dia">
		<g:message code="detalleDisponibilidad.dia.label" default="Dia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="dia" from="${detalleDisponibilidadInstance.constraints.dia.inList}" required="" value="${detalleDisponibilidadInstance?.dia}" valueMessagePrefix="detalleDisponibilidad.dia"/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleDisponibilidadInstance, field: 'desde', 'error')} required">
	<label for="desde">
		<g:message code="detalleDisponibilidad.desde.label" default="Desde" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="desde" from="${0..1439}" class="range" required="" value="${fieldValue(bean: detalleDisponibilidadInstance, field: 'desde')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleDisponibilidadInstance, field: 'hasta', 'error')} required">
	<label for="hasta">
		<g:message code="detalleDisponibilidad.hasta.label" default="Hasta" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="hasta" from="${0..1439}" class="range" required="" value="${fieldValue(bean: detalleDisponibilidadInstance, field: 'hasta')}"/>
</div>

