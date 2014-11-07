<%@ page import="sgt.Rol" %>



<div class="fieldcontain ${hasErrors(bean: rolInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="rol.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" readonly="readonly" required="" value="${rolInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rolInstance, field: 'permisos', 'error')} ">
	<label for="permisos">
		<g:message code="rol.permisos.label" default="Permisos" />
		
	</label>
	<g:select name="permisos" from="${sgt.Permiso.list()}" multiple="multiple" optionKey="id" size="5" value="${rolInstance?.permisos*.id}" class="many-to-many"/>
</div>

