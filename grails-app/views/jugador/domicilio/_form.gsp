<%@ page import="sgt.Domicilio" %>

<div class="fieldcontain ${hasErrors(bean: domicilio, field: 'calle', 'error')} ">
	<label for="calle">
		Calle
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="calle" value="${domicilio?.calle}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilio, field: 'numero', 'error')} required">
	<label for="numero">
		Numero
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numero" value="${domicilio?.numero}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilio, field: 'piso', 'error')} required">
	<label for="piso">
		Piso
	</label>
	<g:field name="piso" type="number" value="${domicilio?.piso}" />
</div>

<div class="fieldcontain ${hasErrors(bean: domicilio, field: 'departamento', 'error')} required">
	<label for="departamento">
		Departamento
	</label>
	<g:textField name="departamento" value="${domicilio?.departamento}" />
</div>

<div class="fieldcontain ${hasErrors(bean: domicilio, field: 'ciudad', 'error')} ">
	<label for="ciudad">
		Ciudad
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ciudad" value="${domicilio?.ciudad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilio, field: 'codigoPostal', 'error')} required">
	<label for="codigoPostal">
		Codigo postal
		<span class="required-indicator">*</span>
	</label>
	<g:field name="codigoPostal" type="number" value="${domicilio?.codigoPostal}" required="" />
</div>

<div class="fieldcontain ${hasErrors(bean: domicilio, field: 'provincia', 'error')} ">
	<label for="provincia">
		Provincia
		<span class="required-indicator">*</span>
	</label>
	<g:select name="provincia" from="${domicilio.constraints.provincia.inList}" 
	value="${domicilio?.provincia}" valueMessagePrefix="domicilio.provincia" required=""/>
</div>