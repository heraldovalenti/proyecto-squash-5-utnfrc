<%@ page import="sgt.Persona" %>



<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="persona.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${personaInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="persona.apellido.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${personaInstance?.apellido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'fechaNacimiento', 'error')} required">
	<label for="fechaNacimiento">
		<g:message code="persona.fechaNacimiento.label" default="Fecha Nacimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaNacimiento" precision="day"  value="${personaInstance?.fechaNacimiento}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'tipoDocumento', 'error')} required">
	<label for="tipoDocumento">
		<g:message code="persona.tipoDocumento.label" default="Tipo Documento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoDocumento" from="${personaInstance.constraints.tipoDocumento.inList}" required="" value="${personaInstance?.tipoDocumento}" valueMessagePrefix="persona.tipoDocumento"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'numeroDocumento', 'error')} required">
	<label for="numeroDocumento">
		<g:message code="persona.numeroDocumento.label" default="Numero de Documento" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numeroDocumento" type="number" value="${personaInstance.numeroDocumento}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'sexo', 'error')} required">
	<label for="sexo">
		<g:message code="persona.sexo.label" default="Sexo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sexo" from="${personaInstance.constraints.sexo.inList}" required="" value="${personaInstance?.sexo}" valueMessagePrefix="persona.sexo"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'lugarNacimiento', 'error')} required">
	<label for="lugarNacimiento">
		<g:message code="persona.lugarNacimiento.label" default="Lugar de Nacimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lugarNacimiento" type="text" value="${personaInstance.lugarNacimiento}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: personaInstance, field: 'telefono', 'error')} required">
	<label for="telefono">
		<g:message code="persona.telefono.label" default="Telefono" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" required="" value="${personaInstance?.telefono}"/>
</div>