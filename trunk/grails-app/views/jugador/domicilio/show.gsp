<%@ page import="sgt.Domicilio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="jugador">
	</head>
	<body>		
		<div id="show-domicilio" class="content scaffold-show" >
			<h1>Datos del Domicilio</h1>
			<g:render template="/utils/messages"/>
			<ol class="property-list domicilio">
			
				<g:if test="${domicilio?.calle}">
				<li class="fieldcontain">
					<span id="calle-label" class="property-label">Calle</span>
					<span class="property-value" >
						${domicilio.calle}</span>
				</li>
				</g:if>
				
				<g:if test="${domicilio?.numero}">
				<li class="fieldcontain">
					<span id="numero-label" class="property-label">Numero</span>
					<span class="property-value" >
						${domicilio.numero}</span>
				</li>
				</g:if>
			
				<g:if test="${domicilio?.piso}">
				<li class="fieldcontain">
					<span id="piso-label" class="property-label">Piso</span>
					<span class="property-value" >
						${domicilio.piso}</span>
				</li>
				</g:if>
			
				<g:if test="${domicilio?.departamento}">
				<li class="fieldcontain">
					<span id="departamento-label" class="property-label">Departamento</span>
					<span class="property-value" >
						${domicilio.departamento}</span>
				</li>
				</g:if>
			
				<g:if test="${domicilio?.codigoPostal}">
				<li class="fieldcontain">
					<span id="codigoPostal-label" class="property-label">Codigo Postal</span>
					<span class="property-value" >
						${domicilio.codigoPostal}</span>
				</li>
				</g:if>
			
				
				
				<g:if test="${domicilio?.ciudad}">
				<li class="fieldcontain">
					<span id="ciudad-label" class="property-label">Ciudad</span>
					<span class="property-value" >
						${domicilio.ciudad}</span>
				</li>
				</g:if>
				
				<g:if test="${domicilio?.provincia}">
				<li class="fieldcontain">
					<span id="provincia-label" class="property-label">Provincia</span>
					<span class="property-value" >
						${domicilio.provincia}</span>
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
