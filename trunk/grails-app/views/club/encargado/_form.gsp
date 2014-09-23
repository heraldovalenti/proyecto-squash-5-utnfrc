<%@ page import="sgt.Persona" %>
<%@ page import="sgt.Usuario" %>

<div class="fieldcontain ${hasErrors(bean: usuarioEncargado, field: 'nombreUsuario', 'error')} required">
	<label for="nombreUsuario">
		Nombre de usuario
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombreUsuario" required="" value="${usuarioEncargado?.nombreUsuario}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioEncargado, field: 'password', 'error')} required">
	<label for="password">
		Password
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="password" required="" value="${usuarioEncargado?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioEncargado, field: 'correo', 'error')} required">
	<label for="correo">
		Correo
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="correo" required="" value="${usuarioEncargado?.correo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioEncargado, field: 'activo', 'error')} required">
	<label for="activo">
		Activo
		<span class="required-indicator">*</span>
	</label>
	<g:checkBox name="activo" required="" value="${usuarioEncargado?.activo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: datosEncargado, field: 'apellido', 'error')} required">
	<label for="apellido">
		Apellido
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${datosEncargado?.apellido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: datosEncargado, field: 'nombre', 'error')} required">
	<label for="nombre">
		Nombre
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${datosEncargado?.nombre}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: datosEncargado, field: 'fechaNacimiento', 'error')} required">
	<label for="fechaNacimiento">
		Fecha Nacimiento
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaNacimiento" precision="day"  value="${datosEncargado?.fechaNacimiento}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: datosEncargado, field: 'tipoDocumento', 'error')} required">
	<label for="tipoDocumento">
		Tipo Documento
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoDocumento" from="${datosEncargado.constraints.tipoDocumento.inList}" 
	required="" value="${datosEncargado?.tipoDocumento}" valueMessagePrefix="persona.tipoDocumento"/>
</div>

<div class="fieldcontain ${hasErrors(bean: datosEncargado, field: 'numeroDocumento', 'error')} required">
	<label for="numeroDocumento">
		Numero de Documento
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numeroDocumento" type="number" value="${datosEncargado.numeroDocumento}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: datosEncargado, field: 'sexo', 'error')} required">
	<label for="sexo">
		Sexo
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sexo" from="${datosEncargado.constraints.sexo.inList}" required="" 
	value="${datosEncargado?.sexo}" valueMessagePrefix="persona.sexo"/>
</div>

<div class="fieldcontain ${hasErrors(bean: datosEncargado, field: 'telefono', 'error')} required">
	<label for="telefono">
		Telefono
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" required="" value="${datosEncargado?.telefono}"/>
</div>