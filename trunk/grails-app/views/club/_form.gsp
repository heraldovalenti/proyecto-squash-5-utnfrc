<%@ page import="sgt.Club" %>



<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="club.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${clubInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'correo', 'error')} ">
	<label for="correo">
		<g:message code="club.correo.label" default="Correo" />
	</label>
	<g:field type="email" name="correo" maxlength="100" value="${clubInstance?.correo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'telefono', 'error')} ">
	<label for="telefono">
		<g:message code="club.telefono.label" default="Telefono"/>
	</label>
	<g:textField name="telefono" maxlength="50" value="${clubInstance?.telefono}" />
</div>

<div class="fieldcontain ${hasErrors(bean: clubInstance, field: 'sitioWeb', 'error')} ">
	<label for="sitioWeb">
		<g:message code="club.sitioWeb.label" default="Sitio Web" />
		
	</label>
	<g:textField name="sitioWeb" maxlength="250" value="${clubInstance?.sitioWeb}"/>
</div>

