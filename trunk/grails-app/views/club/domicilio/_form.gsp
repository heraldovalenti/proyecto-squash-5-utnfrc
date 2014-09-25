<%@ page import="sgt.Domicilio" %>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'calle', 'error')} ">
	<label for="calle">
		Calle
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="calle" value="${domicilioInstance?.calle}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'numero', 'error')} required">
	<label for="numero">
		Numero
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numero" value="${domicilioInstance?.numero}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'piso', 'error')} required">
	<label for="piso">
		Piso
	</label>
	<g:field name="piso" type="number" value="${domicilioInstance?.piso}" />
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'departamento', 'error')} required">
	<label for="departamento">
		Departamento
	</label>
	<g:textField name="departamento" value="${domicilioInstance?.departamento}" />
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'ciudad', 'error')} ">
	<label for="ciudad">
		Ciudad
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ciudad" value="${domicilioInstance?.ciudad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'codigoPostal', 'error')} required">
	<label for="codigoPostal">
		Codigo postal
		<span class="required-indicator">*</span>
	</label>
	<g:field name="codigoPostal" type="number" value="${domicilioInstance?.codigoPostal}" required="" />
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'provincia', 'error')} ">
	<label for="provincia">
		Provincia
		<span class="required-indicator">*</span>
	</label>
	<g:select name="provincia" from="${domicilioInstance.constraints.provincia.inList}" 
	value="${domicilioInstance?.provincia}" valueMessagePrefix="domicilio.provincia" required=""/>
</div>