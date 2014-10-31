<%@ page import="sgt.Torneo" %>

<head>		
<r:require modules="fechasTorneo"/>
</head>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		Nombre
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="150" required="" value="${torneoInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaInicioInscripcion', 'error')} required">
	<label for="fechaInicioInscripcion">
		Fecha Inicio Inscripcion
		<span class="required-indicator">*</span>
	</label>	
	<g:textField name="fechaInicioInscripcion" id="fechaInicioInscripcion" value="${formatDate(format:"dd/MM/yyyy", date:torneoInstance?.fechaInicioInscripcion)}" placeholder="Seleccione una fecha.."/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaFinInscripcion', 'error')} required">
	<label for="fechaFinInscripcion">
		Fecha Fin Inscripcion
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fechaFinInscripcion" id="fechaFinInscripcion" value="${formatDate(format:"dd/MM/yyyy", date:torneoInstance?.fechaFinInscripcion)}" placeholder="Seleccione una fecha.."/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaInicioTorneo', 'error')} required">
	<label for="fechaInicioTorneo">
		Fecha Inicio Torneo
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fechaInicioTorneo" id="fechaInicioTorneo" value="${formatDate(format:"dd/MM/yyyy", date:torneoInstance?.fechaInicioTorneo)}" placeholder="Seleccione una fecha.."/>	
</div>

<div class="fieldcontain ${hasErrors(bean: torneoInstance, field: 'fechaFinTorneo', 'error')} required">
	<label for="fechaFinTorneo">
		Fecha Fin Torneo
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fechaFinTorneo" id="fechaFinTorneo" value="${formatDate(format:"dd/MM/yyyy", date:torneoInstance?.fechaFinTorneo)}" placeholder="Seleccione una fecha.."/>
	
</div>