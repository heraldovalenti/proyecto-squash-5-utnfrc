<%@ page import="modelo.Disponibilidad" %>



<div class="fieldcontain ${hasErrors(bean: disponibilidadInstance, field: 'detalles', 'error')} ">
	<label for="detalles">
		<g:message code="disponibilidad.detalles.label" default="Detalles" />
		
	</label>
	<g:select name="detalles" from="${modelo.DetalleDisponibilidad.list()}" multiple="multiple" optionKey="id" size="5" value="${disponibilidadInstance?.detalles*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: disponibilidadInstance, field: 'fechaActualizacion', 'error')} required">
	<label for="fechaActualizacion">
		<g:message code="disponibilidad.fechaActualizacion.label" default="Fecha Actualizacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaActualizacion" precision="day"  value="${disponibilidadInstance?.fechaActualizacion}"  />
</div>

