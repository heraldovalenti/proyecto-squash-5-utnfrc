<%@ page import="sgt.Torneo"%>

<div class="box box-607 fl mt10 ml10 mb10">
	<h3 class="title">${ torneo.nombre }</h3>
	<div class="fl ml10 mb10">
		<div class="fieldcontain">
			<div class="vista-previa" 
				style="background-image: url(<g:imagenPerfilClub club="${ null }"/>);"> 
			</div>
		</div>
	</div>
	<div class="">
		<ol class="property-list torneo">
			
			<li class="fieldcontain">
				<span class="property-label">Inscripcion</span>
				<span class="property-value">
					<g:formatDate date="${ torneo.fechaInicioInscripcion }" format="dd/MM/yyyy" />
					- <g:formatDate date="${ torneo.fechaFinInscripcion }" format="dd/MM/yyyy" />
				</span>
			</li>
			
			<li class="fieldcontain">
				<span class="property-label">Duracion torneo</span>
				<span class="property-value">
					<g:formatDate date="${ torneo.fechaInicioTorneo }" format="dd/MM/yyyy" />
					- <g:formatDate date="${ torneo.fechaFinTorneo }" format="dd/MM/yyyy" />
				</span>
			</li>
			
			<li class="fieldcontain">
				<span class="property-label">Club</span>
				<span class="property-value">
					<g:if test="${ torneo.club }">
						${ torneo.club } - <g:link controller="club">VER CLUB</g:link>
					</g:if>
					<g:else>
						No asignado
					</g:else>
				</span>
			</li>
			
			<li class="fieldcontain">
				<span class="property-label">Fecha puntuable</span>
				<span class="property-value">
					<g:formatBoolean boolean="${ torneo.puntuable }" true="SI" false="NO"/>
					<g:if test="${ torneo.puntuable && torneo.torneoPuntuable.ordenAnual }">
					- ${ torneo.torneoPuntuable.ordenAnual }º Fecha anual
					</g:if>
				</span>
			</li>
			
			<li class="fieldcontain">
				<span class="property-label">Categorias a disputarse</span>
				<span class="property-value">
					<g:if test="${ torneo.detalles && torneo.detalles.size() > 0 }">
					<ul>
					<g:each in="${ torneo.detalles }" var="detalle">
						<li>${ detalle.categoria.nombre } - ${ detalle.categoria.modalidadCategoria }</li>
					</g:each>
					</ul>
					</g:if>
					
					<g:else>
					</g:else>
				</span>
			</li>
			
		</ol>
	</div>
</div>
