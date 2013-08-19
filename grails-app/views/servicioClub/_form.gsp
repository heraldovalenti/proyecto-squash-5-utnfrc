<%@ page import="sgt.ServicioClub" %>



<div class="fieldcontain ${hasErrors(bean: servicioClubInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="servicioClub.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${servicioClubInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: servicioClubInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="servicioClub.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${servicioClubInstance?.nombre}"/>
</div>

