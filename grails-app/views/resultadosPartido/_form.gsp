<%@ page import="sgt.ResultadosPartido" %>



<div class="fieldcontain ${hasErrors(bean: resultadosPartidoInstance, field: 'ganador', 'error')} required">
	<label for="ganador">
		<g:message code="resultadosPartido.ganador.label" default="Ganador" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ganador" name="ganador.id" from="${sgt.Persona.list()}" optionKey="id" required="" value="${resultadosPartidoInstance?.ganador?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: resultadosPartidoInstance, field: 'detalles', 'error')} ">
	<label for="detalles">
		<g:message code="resultadosPartido.detalles.label" default="Detalles" />
		
	</label>
	<g:select name="detalles" from="${sgt.DetalleResultados.list()}" multiple="multiple" optionKey="id" size="5" value="${resultadosPartidoInstance?.detalles*.id}" class="many-to-many"/>
</div>

