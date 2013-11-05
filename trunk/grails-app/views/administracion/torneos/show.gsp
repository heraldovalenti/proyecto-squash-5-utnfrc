<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.DetalleTorneo" %>
<%@ page import="sgt.Categoria" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'torneo.label', default: 'Torneo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>				
				<li><g:link class="list" controller="torneo" action="list">Volver</g:link></li>
			</ul>
		</div>
		<div id="show-torneo" class="content scaffold-show" role="main">
			<h1>Torneo</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list torneo">
			
				<g:if test="${torneoInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="torneo.nombre.label" default="Nombre" /></span>
					<span class="property-value" aria-labelledby="nombre-label">
						<g:fieldValue bean="${torneoInstance}" field="nombre"/>
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaAlta}">
				<li class="fieldcontain">
					<span id="fechaAlta-label" class="property-label"><g:message code="torneo.fechaAlta.label" default="Fecha Alta" /></span>
					<span class="property-value" aria-labelledby="fechaAlta-label">
						<g:formatDate date="${torneoInstance?.fechaAlta}" />
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaInicioTorneo}">
				<li class="fieldcontain">
					<span id="fechaInicioTorneo-label" class="property-label"><g:message code="torneo.fechaInicioTorneo.label" default="Fecha Inicio Torneo" /></span>
					<span class="property-value" aria-labelledby="fechaInicioTorneo-label">
						<g:formatDate date="${torneoInstance?.fechaInicioTorneo}" />
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaFinTorneo}">
				<li class="fieldcontain">
					<span id="fechaFinTorneo-label" class="property-label"><g:message code="torneo.fechaFinTorneo.label" default="Fecha Fin Torneo" /></span>
					<span class="property-value" aria-labelledby="fechaFinTorneo-label">
						<g:formatDate date="${torneoInstance?.fechaFinTorneo}" />
					</span>
				</li>
				</g:if>
				
				<g:if test="${torneoInstance?.fechaInicioInscripcion}">
				<li class="fieldcontain">
					<span id="fechaInicioInscripcion-label" class="property-label"><g:message code="torneo.fechaInicioInscripcion.label" default="Fecha Inicio Inscripcion" /></span>
					<span class="property-value" aria-labelledby="fechaInicioInscripcion-label">
						<g:formatDate date="${torneoInstance?.fechaInicioInscripcion}" />
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaFinInscripcion}">
				<li class="fieldcontain">
					<span id="fechaFinInscripcion-label" class="property-label"><g:message code="torneo.fechaFinInscripcion.label" default="Fecha Fin Inscripcion" /></span>
					<span class="property-value" aria-labelledby="fechaFinInscripcion-label">
						<g:formatDate date="${torneoInstance?.fechaFinInscripcion}" />
					</span>
				</li>
				</g:if>
			
				
				<li class="fieldcontain">
					<span id="club-label" class="property-label"><g:message code="torneo.club.label" default="Club" /></span>
					<g:if test="${torneoInstance?.club}">
						<span class="property-value" aria-labelledby="club-label">${ torneoInstance?.club?.toString() }</span>
					</g:if>	
					<g:else>
						<span class="property-value" aria-labelledby="club-label">
							No asignado - <g:link controller="torneo" action="verPostulaciones" id="${ torneoInstance?.id }">Ver postulaciones</g:link>
						</span>
					</g:else>
				</li>
				
				<g:if test="${torneoInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="torneo.estado.label" default="Estado" /></span>
					<span class="property-value" aria-labelledby="estado-label">
						<g:fieldValue bean="${torneoInstance}" field="estado"/>
					</span>
				</li>
				</g:if>
			
				
				<li class="fieldcontain">
					<span id="puntuable-label" class="property-label"><g:message code="torneo.puntuable.label" default="Puntuable" /></span>
					<span class="property-value" aria-labelledby="puntuable-label">
						<g:formatBoolean boolean="${ torneoInstance?.puntuable }" true="Si" false="No"/>
					</span>	
				</li>
				
				<li class="fieldcontain">
					<span id="puntuable-label" class="property-label">
						Categorias a disputarse
					</span>
					<span class="property-value" aria-labelledby="puntuable-label">
						<g:if test="${ detalleInstanceListTotal == 0 }">
							Sin asignar - 
						</g:if>
						<g:each in="${ detalleInstanceList }" var="detalle" status="i">
							${ detalle.categoria.nombre } - 
						</g:each>
						<g:link controller="torneo" action="verDetalles" id="${ torneoInstance?.id }">Editar</g:link>							
					</span>	
				</li>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${torneoInstance?.id}" />
					<g:link class="edit" controller="torneo" action="edit" id="${torneoInstance?.id}">Editar</g:link>
					<g:actionSubmit class="delete" action="delete" value="Eliminar" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link controller="diagramacion" action="generarDiagramacion" id="${ torneoInstance?.id }">Diagramacion</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
