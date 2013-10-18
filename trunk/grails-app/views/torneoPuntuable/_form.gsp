<%@ page import="sgt.TorneoPuntuable" %>



<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="torneoPuntuable.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="250" required="" value="${torneoPuntuableInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'ordenAnual', 'error')} ">
	<label for="ordenAnual">
		<g:message code="torneoPuntuable.ordenAnual.label" default="Orden Anual" />
		
	</label>
	<g:field name="ordenAnual" type="number" min="0" value="${torneoPuntuableInstance.ordenAnual}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'activo', 'error')} ">
	<label for="activo">
		<g:message code="torneoPuntuable.activo.label" default="Activo" />
		
	</label>
	<g:checkBox name="activo" value="${torneoPuntuableInstance?.activo}" />
</div>

<div class="fieldcontain ${hasErrors(bean: torneoPuntuableInstance, field: 'instanciasTorneo', 'error')} ">
	<label for="instanciasTorneo">
		<g:message code="torneoPuntuable.instanciasTorneo.label" default="Instancias Torneo" />
		
	</label>
	<g:select name="instanciasTorneo" from="${sgt.Torneo.list()}" multiple="multiple" optionKey="id" size="5" value="${torneoPuntuableInstance?.instanciasTorneo*.id}" class="many-to-many"/>
</div>

