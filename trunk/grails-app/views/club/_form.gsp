<%@ page import="sgt.Club" %>



<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="club.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${clubInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'razonSocial', 'error')} required">
	<label for="razonSocial">
		<g:message code="club.razonSocial.label" default="Razon Social" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="razonSocial" maxlength="50" required="" value="${clubInstance?.razonSocial}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'telefono', 'error')} ">
	<label for="telefono">
		<g:message code="club.telefono.label" default="Telefono" />
		
	</label>
	<g:textField name="telefono" maxlength="50" value="${clubInstance?.telefono}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'domicilio', 'error')} required">
	<label for="domicilio">
		<g:message code="club.domicilio.label" default="Domicilio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="domicilio" name="domicilio.id" from="${sgt.Domicilio.list()}" optionKey="id" required="" value="${clubInstance?.domicilio?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'correo', 'error')} required">
	<label for="correo">
		<g:message code="club.correo.label" default="Correo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="correo" maxlength="100" required="" value="${clubInstance?.correo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'sitioWeb', 'error')} ">
	<label for="sitioWeb">
		<g:message code="club.sitioWeb.label" default="Sitio Web" />
		
	</label>
	<g:textField name="sitioWeb" maxlength="250" value="${clubInstance?.sitioWeb}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'activo', 'error')} ">
	<label for="activo">
		<g:message code="club.activo.label" default="Activo" />
		
	</label>
	<g:checkBox name="activo" value="${clubInstance?.activo}" />
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'canchas', 'error')} ">
	<label for="canchas">
		<g:message code="club.canchas.label" default="Canchas" />
		
	</label>
	<g:select name="canchas" from="${sgt.Cancha.list()}" multiple="multiple" optionKey="id" size="5" value="${clubInstance?.canchas*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'encargado', 'error')} required">
	<label for="encargado">
		<g:message code="club.encargado.label" default="Encargado" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="encargado" name="encargado.id" from="${sgt.Persona.list()}" optionKey="id" required="" value="${clubInstance?.encargado?.id}" class="many-to-one"/>
</div>

