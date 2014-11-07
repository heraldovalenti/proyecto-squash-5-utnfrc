<%@ page import="sgt.Persona" %>
<head>		
<r:require module="fechas"/>
</head>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'nombre', 'error')} required">
	<label for="nombre">
		Nombre
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${persona?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'apellido', 'error')} required">
	<label for="apellido">
		Apellido
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${persona?.apellido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'sexo', 'error')} required">
	<label for="sexo">
		Sexo
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sexo" from="${persona.constraints.sexo.inList}" required="" 
	value="${persona?.sexo}" valueMessagePrefix="persona.sexo" />
</div>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'fechaNacimiento', 'error')} required">
	<label for="fechaNacimiento">
		Fecha Nacimiento
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fechaNacimiento" id="datepicker" value="${formatDate(format:"dd/MM/yyyy", date:persona?.fechaNacimiento)}" placeholder="Seleccione una fecha.."/>	
</div>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'lugarNacimiento', 'error')} ">
	<label for="lugarNacimiento">
		Lugar de Nacimiento
	</label>
	<g:field name="lugarNacimiento" type="text" value="${persona?.lugarNacimiento}" />
</div>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'tipoDocumento', 'error')} ">
	<label for="tipoDocumento">
		Tipo Documento
	</label>
	<g:select name="tipoDocumento" from="${persona.constraints.tipoDocumento.inList}"
	value="${persona?.tipoDocumento}" valueMessagePrefix="persona.tipoDocumento" noSelection="[ '' : '---' ]" />
</div>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'numeroDocumento', 'error')} ">
	<label for="numeroDocumento">
		Numero de Documento
	</label>
	<g:field name="numeroDocumento" type="number" value="${persona.numeroDocumento}" />
</div>

<div class="fieldcontain ${hasErrors(bean: persona, field: 'telefono', 'error')} ">
	<label for="telefono">
		Telefono
	</label>
	<g:textField name="telefono" value="${persona?.telefono}"/>
</div>