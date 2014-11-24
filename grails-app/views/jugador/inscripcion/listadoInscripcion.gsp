<%@ page import="sgt.InscripcionTorneo" %>
<%@ page import="sgt.DetalleTorneo" %>

<html>
<head>
	<meta name="layout" content="jugador">
</head>
<body>
	<h3 class="title mt10">Inscripciones a torneos</h3>
	
	<g:render template="/utils/messages" />
	
	<g:if test="${ inscripciones }">
	<g:each in="${ inscripciones }" var="inscripcion">
	<div class="mt10 ml10 mr20 box-607 box odd">
		<h1 class="title-news mt10 mb10">
			${ inscripcion.detalleTorneo.torneo }
		</h1>
		<div class="fl" style="width: 100%;">
			<ol class="property-list ma00 pa00">
				<li class="fieldcontain">
					<span class="property-label">En categoria</span>
					<span class="property-value">
						${ inscripcion.detalleTorneo.categoria.nombre }
						(${ inscripcion.detalleTorneo.categoria.modalidadCategoria })
					</span>
				</li>
				
				<li class="fieldcontain">
					<span class="property-label">Cierre de inscripcion</span>
					<span class="property-value"> 
						<g:formatDate date="${ inscripcion.detalleTorneo.torneo.fechaFinInscripcion }"
							format="dd/MM/yyyy"/>
					</span>
				</li>
				
				<li class="fieldcontain">
					<span class="property-label">Inicio de torneo</span>
					<span class="property-value">
						<g:formatDate date="${ inscripcion.detalleTorneo.torneo.fechaInicioTorneo }"
							format="dd/MM/yyyy"/>
					</span>
				</li>
			</ol>
		</div>	
		<div class="fl" style="width: 100%;">
			<g:link controller="inscripcionTorneo" action="cancelarInscripcion" 
				params="[idInscripcion: inscripcion.id]"
				class="fr mb10 mr10 button_small red deletion-button">Cancelar inscripcion</g:link>
			<g:link controller="torneo" action="verTorneo" 
				params="[idTorneo: inscripcion.detalleTorneo.torneo.id]"
				class="fr mb10 mr10 button_small blue">Ver torneo</g:link>
		</div>
	</div>
	</g:each>
	</g:if>
	
	<g:else>
	<h2>No hay inscripciones activas actualmente</h2>
	</g:else>
	<r:require module="deletion"/>
</body>
</html>