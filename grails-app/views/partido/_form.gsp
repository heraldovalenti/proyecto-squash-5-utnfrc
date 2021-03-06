<%@ page import="sgt.Partido" %>
<%@ page import="sgt.Persona" %>


<head>
		
<r:require modules="fechas,jugadoresPartido"/>
</head>

<g:hiddenField name="torneo" id="torneo" value="${torneoInstance?.id}"/>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'categoria', 'error')} required">
	<label for="categoria">
		<g:message code="partido.categoria.label" default="Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categoria" name="categoria.id" from="${torneoInstance?.detalles?.categoria}" optionKey="id" required="" value="${partidoInstance?.categoria?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="partido.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fecha" id="datepicker" value="${formatDate(format:"dd/MM/yyyy", date:partidoInstance?.fecha)}" placeholder="Seleccione una fecha.."/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'horaDesde', 'error')} ">
	<label>Hora</label>
	<g:select name="horaDesde" from="${8..23}" value="${partidoInstance?.horaDesde}" style="width: 7%;"/>	
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'jugador1', 'error')} required">
	<label for="jugador1">
		<g:message code="partido.jugador1.label" default="Jugador1" />
		<span class="required-indicator">*</span>
	</label>
	<!----- Campos de Jugador1----->
	<g:hiddenField name="jugador1" id="jugador1" value="${partidoInstance?.jugador1?.id}" />	
	<g:textField name="jugador1Text" id="jugador1Text" value="${partidoInstance?.jugador1?.persona}" placeholder="Ingrese el Jugador.."/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'jugador2', 'error')} required">
	<label for="jugador2">
		<g:message code="partido.jugador2.label" default="Jugador2" />
		<span class="required-indicator">*</span>
	</label>
	<!----- Campos de Jugador2----->
	<g:hiddenField name="jugador2" id="jugador2" value="${partidoInstance?.jugador2?.id}" />
	<g:textField name="jugador2Text" id="jugador2Text" value="${partidoInstance?.jugador2?.persona}" placeholder="Ingrese el Jugador.."/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'cancha', 'error')} required">
	<label for="cancha">
		<g:message code="partido.cancha.label" default="Cancha" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cancha" name="cancha.id" from="${torneoInstance?.club?.canchas}" optionKey="id" required="" value="${partidoInstance?.cancha?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partidoInstance, field: 'arbitro', 'error')} ">
	<label for="arbitro">
		<g:message code="partido.arbitro.label" default="Arbitro" />
		
	</label>
	<!----- Campos de Arbitro----->
	<g:hiddenField name="arbitro" id="arbitro" value="${partidoInstance?.arbitro?.id}"/>
	<g:textField name="arbitroText" id="arbitroText" value="${partidoInstance?.arbitro?.persona}" placeholder="Ingrese el Arbitro.."/>
</div>

