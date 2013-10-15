
<%@ page import="sgt.ServicioClub" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
		<g:set var="entityName" value="${message(code: 'servicioClub.label', default: 'ServicioClub')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<g:link controller="servicioClub" action="list">Volver</g:link>
		<div id="show-servicioClub" class="content scaffold-show" role="main">
			<h1>Servicio ofrecido en Club</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list servicioClub">
			
				<g:if test="${servicioClubInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="servicioClub.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${servicioClubInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${servicioClubInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="servicioClub.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${servicioClubInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${servicioClubInstance?.id}" />
					<g:actionSubmit class="edit" controller="servicioClub" action="edit" id="${servicioClubInstance?.id}" value="${message(code: 'default.button.edit.label', default: 'Editar')}"/>
					
					<g:actionSubmit class="delete" controller="servicioClub" action="delete" value="${message(code: 'default.button.delete.label', default: 'Eliminar')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>