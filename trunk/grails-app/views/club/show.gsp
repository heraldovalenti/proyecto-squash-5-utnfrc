<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>		
		<div id="show-club" class="content scaffold-show" role="main">
			<h1>Datos de club</h1>
			<g:render template="/utils/messages"/>
			
			<ol class="property-list club">
				
				<g:if test="${clubInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label">
						<g:message code="club.nombre.label" default="Nombre" />
					</span>
					<span class="property-value" aria-labelledby="nombre-label">
						<g:fieldValue bean="${clubInstance}" field="nombre"/>
					</span>
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.correo}">
				<li class="fieldcontain">
					<span id="correo-label" class="property-label">
						<g:message code="club.correo.label" default="Correo" />
					</span>
					<span class="property-value" aria-labelledby="correo-label">
						<g:fieldValue bean="${clubInstance}" field="correo"/>
					</span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label">
						<g:message code="club.telefono.label" default="Telefono" />
					</span>
					<span class="property-value" aria-labelledby="telefono-label">
						<g:fieldValue bean="${clubInstance}" field="telefono"/>
					</span>
					
				</li>
				</g:if>
			
				<g:if test="${clubInstance?.sitioWeb}">
				<li class="fieldcontain">
					<span id="sitioWeb-label" class="property-label">
						<g:message code="club.sitioWeb.label" default="Sitio Web" />
					</span>
					<span class="property-value" aria-labelledby="sitioWeb-label">
						<g:fieldValue bean="${clubInstance}" field="sitioWeb"/>
					</span>
				</li>
				</g:if>
				
				<g:if test="${ clubLogo }">
				<li class="fieldcontain">
					<span id="clubLogo-label" class="property-label">
						Logo
					</span>
					<div class="vista-previa"
						style="background-image: url(
						<g:resource dir="${ imagesDir }" file="${ clubLogo }"/>
						);"
						>
					</div>
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:link class="edit" action="edit">
						<g:message code="default.button.edit.label" default="Edit" />
					</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
