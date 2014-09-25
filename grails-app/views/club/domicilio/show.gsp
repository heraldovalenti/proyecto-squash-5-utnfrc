<%@ page import="sgt.Domicilio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>		
		<div id="show-domicilio" class="content scaffold-show" role="main">
			<h1>Domicilio de club</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list domicilio">
			
				<g:if test="${domicilioInstance?.calle}">
				<li class="fieldcontain">
					<span id="calle-label" class="property-label">Calle</span>
					<span class="property-value" aria-labelledby="calle-label">
						${domicilioInstance.calle}</span>
				</li>
				</g:if>
				
				<g:if test="${domicilioInstance?.numero}">
				<li class="fieldcontain">
					<span id="numero-label" class="property-label">Numero</span>
					<span class="property-value" aria-labelledby="numero-label">
						${domicilioInstance.numero}</span>
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.piso}">
				<li class="fieldcontain">
					<span id="piso-label" class="property-label">Piso</span>
					<span class="property-value" aria-labelledby="piso-label">
						${domicilioInstance.piso}</span>
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.departamento}">
				<li class="fieldcontain">
					<span id="departamento-label" class="property-label">Departamento</span>
					<span class="property-value" aria-labelledby="departamento-label">
						${domicilioInstance.departamento}</span>
				</li>
				</g:if>
			
				<g:if test="${domicilioInstance?.codigoPostal}">
				<li class="fieldcontain">
					<span id="codigoPostal-label" class="property-label">Codigo Postal</span>
					<span class="property-value" aria-labelledby="codigoPostal-label">
						${domicilioInstance.codigoPostal}</span>
				</li>
				</g:if>
			
				
				
				<g:if test="${domicilioInstance?.ciudad}">
				<li class="fieldcontain">
					<span id="ciudad-label" class="property-label">Ciudad</span>
					<span class="property-value" aria-labelledby="ciudad-label">
						${domicilioInstance.ciudad}</span>
				</li>
				</g:if>
				
				<g:if test="${domicilioInstance?.provincia}">
				<li class="fieldcontain">
					<span id="provincia-label" class="property-label">Provincia</span>
					<span class="property-value" aria-labelledby="ciudad-provincia">
						${domicilioInstance.provincia}</span>
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:link class="edit" action="editDomicilio">Editar</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
