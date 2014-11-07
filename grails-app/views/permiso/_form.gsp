<%@ page import="sgt.Permiso" %>



<div class="fieldcontain ${hasErrors(bean: permisoInstance, field: 'controller', 'error')} required">
	<label for="controller">
		Controlador
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="_controller" maxlength="25" required="" value="${permisoInstance?.controller}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: permisoInstance, field: 'action', 'error')} required">
	<label for="action">
		Accion
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="_action" maxlength="25" required="" value="${permisoInstance?.action}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: permisoInstance, field: 'mode', 'error')} required">
	<label for="mode">
		<g:message code="permiso.mode.label" default="Mode" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="mode" from="${permisoInstance.constraints.mode.inList}" required="" value="${permisoInstance?.mode}" valueMessagePrefix="permiso.mode"/>
</div>

