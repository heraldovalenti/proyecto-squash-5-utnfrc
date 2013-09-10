<%@ page import="sgt.Torneo" %>



<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="torneo.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="150" required="" value="${torneoInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaAlta', 'error')} required">
	<label for="fechaAlta">
		<g:message code="torneo.fechaAlta.label" default="Fecha Alta" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaAlta" precision="day"  value="${torneoInstance?.fechaAlta}"  />
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

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'club', 'error')} required">
	<label for="club">
		<g:message code="torneo.club.label" default="Club" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="club" name="club.id" from="${sgt.Club.list()}" optionKey="id" required="" value="${torneoInstance?.club?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'estado', 'error')} required">
	<label for="estado">
		<g:message code="torneo.estado.label" default="Estado" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="estado" from="${torneoInstance.constraints.estado.inList}" required="" value="${torneoInstance?.estado}" valueMessagePrefix="torneo.estado"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'detalles', 'error')} ">
	<label for="detalles">
		<g:message code="torneo.detalles.label" default="Detalles" />
		
	</label>
	<g:select name="detalles" from="${sgt.DetalleTorneo.list()}" multiple="multiple" optionKey="id" size="5" value="${torneoInstance?.detalles*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'puntuable', 'error')} ">
	<label for="puntuable">
		<g:message code="torneo.puntuable.label" default="Puntuable" />
		
	</label>
	<g:checkBox name="puntuable" value="${torneoInstance?.puntuable}" />
</div>

