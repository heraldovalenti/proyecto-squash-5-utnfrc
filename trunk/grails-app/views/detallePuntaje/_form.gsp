<%@ page import="sgt.DetallePuntaje" %>



<div class="fieldcontain ${hasErrors(bean: detallePuntajeInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="detallePuntaje.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${detallePuntajeInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: detallePuntajeInstance, field: 'puesto', 'error')} required">
	<label for="puesto">
		<g:message code="detallePuntaje.puesto.label" default="Puesto" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="puesto" type="number" value="${detallePuntajeInstance.puesto}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: detallePuntajeInstance, field: 'puntaje', 'error')} required">
	<label for="puntaje">
		<g:message code="detallePuntaje.puntaje.label" default="Puntaje" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="puntaje" value="${fieldValue(bean: detallePuntajeInstance, field: 'puntaje')}" required=""/>
</div>

