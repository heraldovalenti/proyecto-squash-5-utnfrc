
<%@ page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<fieldset class="buttons">
    		<g:link controller="categoria" action="list"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		
		<div id="show-categoria" class="content scaffold-show" role="main">
			<h1>Categoria</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list categoria">
			
				<g:if test="${categoriaInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="categoria.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${categoriaInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${categoriaInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="categoria.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${categoriaInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${categoriaInstance?.modalidadCategoria}">
				<li class="fieldcontain">
					<span id="modalidadCategoria-label" class="property-label"><g:message code="categoria.modalidadCategoria.label" default="Modalidad Categoria" /></span>
					
						<span class="property-value" aria-labelledby="modalidadCategoria-label"><g:fieldValue bean="${categoriaInstance}" field="modalidadCategoria"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${categoriaInstance?.id}" />
					<g:link class="edit" action="edit" id="${categoriaInstance?.id}">Editar</g:link>
					<g:actionSubmit class="delete" action="delete" value="Eliminar" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
