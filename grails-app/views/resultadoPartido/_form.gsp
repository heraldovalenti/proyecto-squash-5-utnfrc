<%@ page import="sgt.ResultadoPartido" %>



<div class="fieldcontain ${hasErrors(bean: resultadoPartidoInstance, field: 'ganador', 'error')} required">
	<label for="ganador">
		<g:message code="resultadoPartido.ganador.label" default="Ganador" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ganador" name="ganador.id" from="${sgt.Persona.list()}" optionKey="id" required="" value="${resultadoPartidoInstance?.ganador?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: resultadoPartidoInstance, field: 'detalles', 'error')} ">
	<label for="detalles">
		<g:message code="resultadoPartido.detalles.label" default="Detalles" />
		
	</label>
	<g:select name="detalles" from="${sgt.DetalleResultados.list()}" multiple="multiple" optionKey="id" size="5" value="${resultadoPartidoInstance?.detalles*.id}" class="many-to-many"/>
</div>

