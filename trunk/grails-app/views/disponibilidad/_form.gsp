<%@ page import="sgt.Disponibilidad" %>



<div class="fieldcontain ${hasErrors(bean: disponibilidadInstance, field: 'fechaActualizacion', 'error')} ">
	<label for="fechaActualizacion">
		<g:message code="disponibilidad.fechaActualizacion.label" default="Fecha Actualizacion" />
		
	</label>
	<g:datePicker name="fechaActualizacion" precision="day"  value="${disponibilidadInstance?.fechaActualizacion}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: disponibilidadInstance, field: 'detalles', 'error')} ">
	<label for="detalles">
		<g:message code="disponibilidad.detalles.label" default="Detalles" />
		
	</label>
	<g:select name="detalles" from="${sgt.DetalleDisponibilidad.list()}" multiple="multiple" optionKey="id" size="5" value="${disponibilidadInstance?.detalles*.id}" class="many-to-many"/>
</div>

