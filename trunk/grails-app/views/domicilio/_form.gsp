<%@ page import="sgt.Domicilio" %>



<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'piso', 'error')} ">
	<label for="piso">
		<g:message code="domicilio.piso.label" default="Piso" />
		
	</label>
	<g:textField name="piso" value="${domicilioInstance?.piso}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'dpto', 'error')} ">
	<label for="dpto">
		<g:message code="domicilio.dpto.label" default="Dpto" />
		
	</label>
	<g:textField name="dpto" value="${domicilioInstance?.dpto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'codPostal', 'error')} required">
	<label for="codPostal">
		<g:message code="domicilio.codPostal.label" default="Cod Postal" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="codPostal" type="number" value="${domicilioInstance.codPostal}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'ciudadOrigen', 'error')} ">
	<label for="ciudadOrigen">
		<g:message code="domicilio.ciudadOrigen.label" default="Ciudad Origen" />
		
	</label>
	<g:textField name="ciudadOrigen" value="${domicilioInstance?.ciudadOrigen}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'provincia', 'error')} ">
	<label for="provincia">
		<g:message code="domicilio.provincia.label" default="Provincia" />
		
	</label>
	<g:select name="provincia" from="${domicilioInstance.constraints.provincia.inList}" value="${domicilioInstance?.provincia}" valueMessagePrefix="domicilio.provincia" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'ciudad', 'error')} ">
	<label for="ciudad">
		<g:message code="domicilio.ciudad.label" default="Ciudad" />
		
	</label>
	<g:textField name="ciudad" value="${domicilioInstance?.ciudad}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domicilioInstance, field: 'domicilio', 'error')} ">
	<label for="domicilio">
		<g:message code="domicilio.domicilio.label" default="Domicilio" />
		
	</label>
	<g:textField name="domicilio" value="${domicilioInstance?.domicilio}"/>
</div>

