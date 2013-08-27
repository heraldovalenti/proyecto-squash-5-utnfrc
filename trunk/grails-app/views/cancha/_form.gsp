<%@ page import="sgt.Cancha" %>



<div class="fieldcontain ${hasErrors(bean: canchaInstance, field: 'ancho', 'error')} required">
	<label for="ancho">
		<g:message code="cancha.ancho.label" default="Ancho" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ancho" value="${fieldValue(bean: canchaInstance, field: 'ancho')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: canchaInstance, field: 'largo', 'error')} required">
	<label for="largo">
		<g:message code="cancha.largo.label" default="Largo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="largo" value="${fieldValue(bean: canchaInstance, field: 'largo')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: canchaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="cancha.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${canchaInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canchaInstance, field: 'tipoSuelo', 'error')} required">
	<label for="tipoSuelo">
		<g:message code="cancha.tipoSuelo.label" default="Tipo Suelo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoSuelo" from="${canchaInstance.constraints.tipoSuelo.inList}" required="" value="${canchaInstance?.tipoSuelo}" valueMessagePrefix="cancha.tipoSuelo"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canchaInstance, field: 'disponibilidad', 'error')} required">
	<label for="disponibilidad">
		<g:message code="cancha.disponibilidad.label" default="Disponibilidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="disponibilidad" name="disponibilidad.id" from="${sgt.Disponibilidad.list()}" optionKey="id" required="" value="${canchaInstance?.disponibilidad?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canchaInstance, field: 'paredes', 'error')} ">
	<label for="paredes">
		<g:message code="cancha.paredes.label" default="Paredes" />
		
	</label>
	<g:textField name="paredes" value="${canchaInstance?.paredes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canchaInstance, field: 'techo', 'error')} ">
	<label for="techo">
		<g:message code="cancha.techo.label" default="Techo" />
		
	</label>
	<g:checkBox name="techo" value="${canchaInstance?.techo}" />
</div>

