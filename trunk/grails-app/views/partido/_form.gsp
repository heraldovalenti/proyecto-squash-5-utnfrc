<%@ page import="sgt.Partido" %>


<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'categoria', 'error')} required">
	<label for="categoria">
		<g:message code="partido.categoria.label" default="Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categoria" name="categoria.id" from="${sgt.Categoria.list()}" optionKey="id" required="" value="${partidoInstance?.categoria?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="partido.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${partidoInstance?.fecha}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'horaDesde', 'error')} ">
	<label for="horaDesde">
		<g:message code="partido.horaDesde.label" default="Hora Desde" />
		
	</label>
	<g:textField name="horaDesde" value="${partidoInstance?.horaDesde}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'horaHasta', 'error')} ">
	<label for="horaHasta">
		<g:message code="partido.horaHasta.label" default="Hora Hasta" />
		
	</label>
	<g:textField name="horaHasta" value="${partidoInstance?.horaHasta}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'jugador1', 'error')} required">
	<label for="jugador1">
		<g:message code="partido.jugador1.label" default="Jugador1" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="jugador1" name="jugador1.id" from="${sgt.Usuario.list()}" optionKey="id" required="" value="${partidoInstance?.jugador1?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'jugador2', 'error')} required">
	<label for="jugador2">
		<g:message code="partido.jugador2.label" default="Jugador2" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="jugador2" name="jugador2.id" from="${sgt.Usuario.list()}" optionKey="id" required="" value="${partidoInstance?.jugador2?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'cancha', 'error')} required">
	<label for="cancha">
		<g:message code="partido.cancha.label" default="Cancha" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cancha" name="cancha.id" from="${sgt.Cancha.list()}" optionKey="id" required="" value="${partidoInstance?.cancha?.id}" class="many-to-one"/>
</div>



<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'estado', 'error')} required">
	<label for="estado">
		<g:message code="partido.estado.label" default="Estado" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="estado" from="${partidoInstance.constraints.estado.inList}" required="" value="${partidoInstance?.estado}" valueMessagePrefix="partido.estado"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'arbitro', 'error')} ">
	<label for="arbitro">
		<g:message code="partido.arbitro.label" default="Arbitro" />
		
	</label>
	<g:select id="arbitro" name="arbitro.id" from="${sgt.Usuario.list()}" optionKey="id" value="${partidoInstance?.arbitro?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>







