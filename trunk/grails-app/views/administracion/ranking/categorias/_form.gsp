<%@ page import="sgt.Categoria" %>



<div class="fieldcontain ${hasErrors(bean: categoriaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="categoria.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${categoriaInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: categoriaInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="categoria.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" maxlength="250" required="" value="${categoriaInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: categoriaInstance, field: 'modalidadCategoria', 'error')} required">
	<label for="modalidadCategoria">
		<g:message code="categoria.modalidadCategoria.label" default="Modalidad Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="modalidadCategoria" from="${categoriaInstance.constraints.modalidadCategoria.inList}" required="" value="${categoriaInstance?.modalidadCategoria}" valueMessagePrefix="categoria.modalidadCategoria"/>
</div>

