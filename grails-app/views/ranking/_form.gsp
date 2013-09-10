<%@ page import="sgt.Ranking" %>



<div class="fieldcontain ${hasErrors(bean: rankingInstance, field: 'categoria', 'error')} required">
	<label for="categoria">
		<g:message code="ranking.categoria.label" default="Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categoria" name="categoria.id" from="${sgt.Categoria.list()}" optionKey="id" required="" value="${rankingInstance?.categoria?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rankingInstance, field: 'detalles', 'error')} ">
	<label for="detalles">
		<g:message code="ranking.detalles.label" default="Detalles" />
		
	</label>
	<g:select name="detalles" from="${sgt.DetalleRanking.list()}" multiple="multiple" optionKey="id" size="5" value="${rankingInstance?.detalles*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: rankingInstance, field: 'puesto', 'error')} required">
	<label for="puesto">
		<g:message code="ranking.puesto.label" default="Puesto" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="puesto" type="number" value="${rankingInstance.puesto}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: rankingInstance, field: 'puntaje', 'error')} required">
	<label for="puntaje">
		<g:message code="ranking.puntaje.label" default="Puntaje" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="puntaje" value="${fieldValue(bean: rankingInstance, field: 'puntaje')}" required=""/>
</div>

