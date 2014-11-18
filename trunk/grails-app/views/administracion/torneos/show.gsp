<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.DetalleTorneo" %>
<%@ page import="sgt.Categoria" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
		
		<div class="nav">
			<ul>				
				<li><g:link class="list" controller="torneo" action="list">Volver</g:link></li>
			</ul>
		</div>
		<div id="show-torneo" class="content scaffold-show" >
			<h1>Torneo</h1>
			
			<g:render template="/utils/messages" />
			
			<ol class="property-list torneo">
			
				<g:if test="${torneoInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label">Nombre</span>
					<span class="property-value" >
						<g:fieldValue bean="${torneoInstance}" field="nombre"/>
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaAlta}">
				<li class="fieldcontain">
					<span id="fechaAlta-label" class="property-label">Fecha Alta</span>
					<span class="property-value" >
						<g:formatDate date="${torneoInstance?.fechaAlta}" />
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaInicioTorneo}">
				<li class="fieldcontain">
					<span id="fechaInicioTorneo-label" class="property-label">Fecha Inicio Torneo</span>
					<span class="property-value" >
						<g:formatDate date="${torneoInstance?.fechaInicioTorneo}" />
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaFinTorneo}">
				<li class="fieldcontain">
					<span id="fechaFinTorneo-label" class="property-label">Fecha Fin Torneo</span>
					<span class="property-value" >
						<g:formatDate date="${torneoInstance?.fechaFinTorneo}" />
					</span>
				</li>
				</g:if>
				
				<g:if test="${torneoInstance?.fechaInicioInscripcion}">
				<li class="fieldcontain">
					<span id="fechaInicioInscripcion-label" class="property-label">Fecha Inicio Inscripcion</span>
					<span class="property-value" >
						<g:formatDate date="${torneoInstance?.fechaInicioInscripcion}" />
					</span>
				</li>
				</g:if>
			
				<g:if test="${torneoInstance?.fechaFinInscripcion}">
				<li class="fieldcontain">
					<span id="fechaFinInscripcion-label" class="property-label">Fecha Fin Inscripcion</span>
					<span class="property-value" >
						<g:formatDate date="${torneoInstance?.fechaFinInscripcion}" />
					</span>
				</li>
				</g:if>
			
				
				<li class="fieldcontain">
					<span id="club-label" class="property-label">Club</span>
					<g:if test="${torneoInstance?.club}">
						<span class="property-value" >${ torneoInstance?.club?.toString() }</span>
					</g:if>	
					<g:else>
						<span class="property-value">
							No asignado - <g:link controller="torneo" action="verPostulaciones" id="${ torneoInstance?.id }">Ver postulaciones</g:link>
						</span>
					</g:else>
				</li>
				
				<g:if test="${torneoInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label">Estado</span>
					<span class="property-value" >
						<g:fieldValue bean="${torneoInstance}" field="estado"/>
					</span>
				</li>
				</g:if>
			
				
				<li class="fieldcontain">
					<span id="puntuable-label" class="property-label">Puntuable</span>
					<span class="property-value" >
						<g:formatBoolean boolean="${ torneoInstance?.puntuable }" true="Si" false="No"/>
					</span>	
				</li>
				
				<li class="fieldcontain">
					<span id="puntuable-label" class="property-label">
						Categorias a disputarse
					</span>
					<span class="property-value" >
						<g:if test="${ detalleInstanceListTotal == 0 }">
							Sin asignar - 
						</g:if>
						<g:each in="${ detalleInstanceList }" var="detalle" status="i">
							${ detalle.categoria.nombre }/${ detalle.categoria.modalidadCategoria } - 
						</g:each>
						<g:link controller="torneo" action="verDetalles" id="${ torneoInstance?.id }">Editar</g:link>							
					</span>	
				</li>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${torneoInstance?.id}" />
					<g:link class="edit" controller="torneo" action="edit" id="${torneoInstance?.id}">Editar</g:link>
					<g:link class="delete deletion-button" action="delete" id="${ torneoInstance?.id }">Eliminar</g:link>
					<g:link controller="diagramacion" action="diagramacionTorneo" id="${ torneoInstance?.id }">Diagramacion</g:link>
					<g:link controller="fixture">Fixture</g:link>
					<g:link controller="partido" action="list1">Partidos</g:link>
					<g:link controller="generacionRanking" action="generarRanking" id="${ torneoInstance?.id }">Generar rankings</g:link>
					<g:link controller="torneo" action="listarPosiciones">Posiciones</g:link>
				</fieldset>
			</g:form>
		</div>
		<r:require module="deletion" />
	</body>
</html>
