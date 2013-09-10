<%@ page import="sgt.Puntaje" %>



<div class="fieldcontain ${hasErrors(bean: puntajeInstance, field: 'categoria', 'error')} required">
	<label for="categoria">
		<g:message code="puntaje.categoria.label" default="Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categoria" name="categoria.id" from="${sgt.Categoria.list()}" optionKey="id" required="" value="${puntajeInstance?.categoria?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: puntajeInstance, field: 'detalles', 'error')} ">
	<label for="detalles">
		<g:message code="puntaje.detalles.label" default="Detalles" />
		
	</label>
	<g:select name="detalles" from="${sgt.DetallePuntaje.list()}" multiple="multiple" optionKey="id" size="5" value="${puntajeInstance?.detalles*.id}" class="many-to-many"/>
</div>

