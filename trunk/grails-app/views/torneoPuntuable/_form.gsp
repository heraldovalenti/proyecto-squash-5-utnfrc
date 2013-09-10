<%@ page import="sgt.TorneoPuntuable" %>



<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'activo', 'error')} ">
	<label for="activo">
		<g:message code="torneoPuntuable.activo.label" default="Activo" />
		
	</label>
	<g:checkBox name="activo" value="${torneoPuntuableInstance?.activo}" />
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'fin', 'error')} required">
	<label for="fin">
		<g:message code="torneoPuntuable.fin.label" default="Fin" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fin" precision="day"  value="${torneoPuntuableInstance?.fin}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'inicio', 'error')} required">
	<label for="inicio">
		<g:message code="torneoPuntuable.inicio.label" default="Inicio" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="inicio" precision="day"  value="${torneoPuntuableInstance?.inicio}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'instanciasTorneo', 'error')} ">
	<label for="instanciasTorneo">
		<g:message code="torneoPuntuable.instanciasTorneo.label" default="Instancias Torneo" />
		
	</label>
	<g:select name="instanciasTorneo" from="${sgt.Torneo.list()}" multiple="multiple" optionKey="id" size="5" value="${torneoPuntuableInstance?.instanciasTorneo*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="torneoPuntuable.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${torneoPuntuableInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'ordenAnual', 'error')} required">
	<label for="ordenAnual">
		<g:message code="torneoPuntuable.ordenAnual.label" default="Orden Anual" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ordenAnual" type="number" value="${torneoPuntuableInstance.ordenAnual}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'puntajeTorneo', 'error')} required">
	<label for="puntajeTorneo">
		<g:message code="torneoPuntuable.puntajeTorneo.label" default="Puntaje Torneo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="puntajeTorneo" name="puntajeTorneo.id" from="${sgt.Puntaje.list()}" optionKey="id" required="" value="${torneoPuntuableInstance?.puntajeTorneo?.id}" class="many-to-one"/>
</div>

