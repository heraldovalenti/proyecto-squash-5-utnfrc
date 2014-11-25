
<%@ page import="sgt.Cancha" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link controller="cancha" action="list" namespace="club"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver al listado de Canchas</span> </g:link> 	
		</fieldset>
		
		<div id="show-cancha" class="content scaffold-show" role="main">
			<h1>Datos de cancha</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list cancha">
			
				<li class="fieldcontain">
					<span id="numero-label" class="property-label">Numero</span>
					<span class="property-value" aria-labelledby="nombre-label">
						${ cancha.numero }
					</span>
					
				</li>
			
				<g:if test="${ cancha?.nombre }">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label">Nombre</span>	
					<span class="property-value" aria-labelledby="nombre-label">
						${ cancha.nombre }
					</span>
				</li>
				</g:if>
			
				<g:if test="${cancha?.tipoSuelo}">
				<li class="fieldcontain">
					<span id="tipoSuelo-label" class="property-label">Tipo Suelo</span>	
					<span class="property-value" aria-labelledby="tipoSuelo-label">
						${ cancha.tipoSuelo }
					</span>
				</li>
				</g:if>
			
				<li class="fieldcontain">
					<span id="techada-label" class="property-label">Techada</span>
					<span class="property-value" aria-labelledby="techada-label">
						<g:formatBoolean boolean="${ cancha.techada }" true="Si" false="No"/>
					</span>
				</li>
							
				<li class="fieldcontain">
					<span id="disponibilidad-label" class="property-label">Disp. Horaria</span>
					<span class="property-value" aria-labelledby="disponibilidad-label">
						 <g:link controller="disponibilidadCancha" 
							params="[idCancha: cancha.id]">Ver disponibilidad</g:link>
					</span>
				</li>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:link class="edit" controller="cancha" action="edit" 
						params="[cancha: cancha.id]">Editar</g:link>
					<g:link elementId="deletion-button" class="delete" controller="cancha" 
						action="delete"	params="[cancha: cancha.id]">Eliminar</g:link>
				</fieldset>
			</g:form>
		</div>
		<r:require modules="deletion"/>
	</body>
</html>
