<g:if test="${ !torneo.detalles.isEmpty() }">
<div class="box box-607 fl mt10 ml10 mb10">
	<h3 class="title-grey">Quienes juegan</h3>
	<div id="quienes-juegan" style="margin: 0px 0px; float: left;">
		<ul>
			<g:each in="${ torneo.detalles }" var="detalle" status="i">
			<li>
				<a href="#quienes-juegan-${ (i + 1) }">${ detalle.categoria } (${ detalle.inscripciones.size() })</a>
			</li>
			</g:each>
		</ul>
		<g:each in="${ torneo.detalles }" var="detalle" status="i">
		<div id="quienes-juegan-${ (i + 1) }" class="clear-fix">
			<g:if test="${ detalle.inscripciones.isEmpty() }"><h1>No hay inscriptos para la categoria</h1></g:if>
			<g:each in="${ detalle.inscripciones }" var="inscripto">
			<ul class="qj-list">
				<li class="img">
					<img src="<g:imagenPerfilJugador usuario="${ inscripto.usuario }" jugador="${ inscripto.usuario.jugador }"/>" 
						width="50" height="50">
				</li>
				<li class="name">
					<g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario: inscripto.usuario.id]">
						${ inscripto.usuario.persona.toString() }
					</g:link>
				</li>
			</ul>
			</g:each>
		</div>
		</g:each>
	</div>
</div>

<g:javascript >
	$('#quienes-juegan').tabs();
</g:javascript>

</g:if>