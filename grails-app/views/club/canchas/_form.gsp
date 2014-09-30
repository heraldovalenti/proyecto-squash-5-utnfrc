<%@ page import="sgt.Cancha" %>

<div class="fieldcontain ${hasErrors(bean: cancha, field: 'numero', 'error')} required">
	<label for="numero">
		Numero
		<span class="required-indicator">*</span>
	</label>
	<input name="numero" type="text" value="${ cancha?.numero }" required="" readonly="readonly"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cancha, field: 'nombre', 'error')} required">
	<label for="nombre">
		Nombre
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" value="${cancha?.nombre}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: cancha, field: 'tipoSuelo', 'error')} required">
	<label for="tipoSuelo">
		Tipo Suelo
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoSuelo" from="${cancha.constraints.tipoSuelo.inList}" 
		required="" value="${cancha?.tipoSuelo}" valueMessagePrefix="cancha.tipoSuelo"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cancha, field: 'techada', 'error')}">
	<label for="techada">
		Techada
		<span class="required-indicator">*</span>
	</label>
	<g:checkBox name="techada" checked="${ cancha?.techada }" />
</div>