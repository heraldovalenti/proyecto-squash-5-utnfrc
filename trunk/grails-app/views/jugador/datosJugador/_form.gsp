<%@ page import="sgt.Jugador" %>
<head>		
<r:require module="fechas"/>
</head>

<div class="fieldcontain ${hasErrors(bean: jugador, field: 'brazo', 'error')} ">
	<label for="brazo">Brazo</label>
	<g:select name="brazo" from="${jugador.constraints.brazo.inList}" 
		value="${jugador?.brazo}" valueMessagePrefix="jugador.brazo" noSelection="['': '---']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jugador, field: 'altura', 'error')} ">
	<label for="altura">Altura (cm)</label>
	<g:field name="altura" type="number" value="${fieldValue(bean: jugador, field: 'altura')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jugador, field: 'peso', 'error')} ">
	<label for="peso">Peso (Kg)</label>
	<g:field name="peso" type="number" value="${fieldValue(bean: jugador, field: 'peso')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jugador, field: 'juegaDesde', 'error')} ">
	<label for="juegaDesde">Juega Desde</label>
	<g:textField name="juegaDesde" id="datepicker" value="${formatDate(format:"dd/MM/yyyy", date:jugador?.juegaDesde)}" placeholder="Seleccione una fecha.."/>	
</div>

<div class="fieldcontain">
	<label for="profileImage" class="vista-previa">Imagen de perfil</label>
	<input type="file" style="visibility: hidden;" id="profileImage" name="profileImage"/>
	<div class="vista-previa" 
		style="background-image: url(<g:imagenPerfilJugador jugador="${ jugador }"/>);" >
	</div>
</div>