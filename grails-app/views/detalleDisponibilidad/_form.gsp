<%@ page import="sgt.DetalleDisponibilidad" %>



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
	<gestorhorarios:selectorHorarios name="desde" value="${ detalleDisponibilidadInstance?.desde }"/>
</div>

<div class="fieldcontain ${hasErrors(bean: detalleDisponibilidadInstance, field: 'hasta', 'error')} required">
	<label for="hasta">
		<g:message code="detalleDisponibilidad.hasta.label" default="Hasta" />
		<span class="required-indicator">*</span>
	</label>
	<gestorhorarios:selectorHorarios name="hasta" value="${ detalleDisponibilidadInstance?.hasta }"/>
</div>

