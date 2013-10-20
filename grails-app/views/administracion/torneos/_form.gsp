<%@ page import="sgt.Torneo" %>



<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="torneo.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="150" required="" value="${torneoInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaInicioInscripcion', 'error')} required">
	<label for="fechaInicioInscripcion">
		<g:message code="torneo.fechaInicioInscripcion.label" default="Fecha Inicio Inscripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaInicioInscripcion" precision="day"  value="${torneoInstance?.fechaInicioInscripcion}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaFinInscripcion', 'error')} required">
	<label for="fechaFinInscripcion">
		<g:message code="torneo.fechaFinInscripcion.label" default="Fecha Fin Inscripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaFinInscripcion" precision="day"  value="${torneoInstance?.fechaFinInscripcion}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaInicioTorneo', 'error')} required">
	<label for="fechaInicioTorneo">
		<g:message code="torneo.fechaInicioTorneo.label" default="Fecha Inicio Torneo" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaInicioTorneo" precision="day"  value="${torneoInstance?.fechaInicioTorneo}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaFinTorneo', 'error')} required">
	<label for="fechaFinTorneo">
		<g:message code="torneo.fechaFinTorneo.label" default="Fecha Fin Torneo" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaFinTorneo" precision="day"  value="${torneoInstance?.fechaFinTorneo}"  />
</div>

