<html>
<head>
	<meta name="layout" content="administracion">
</head>
<body>
	<div id="show-torneo" class="content scaffold-show" >
		<h1>Accesos rapidos</h1>
		
		<g:render template="/utils/messages" />
		
		<ol class="property-list">
			
			<g:if test="${ !torneosEnCurso.isEmpty() }">
			<li class="fieldcontain">
				<span id="nombre-label" class="property-label">Torneos en curso</span>
				<span class="property-value" >
					<g:each in="${ torneosEnCurso }" var="torneo">
						<ul style="list-style: none; padding: 0px;">
							<li>
								<g:link controller="torneo" action="show" id="${ torneo.id }">${ torneo.nombre } (${ torneo.estado })</g:link>
							</li>
						</ul>
					</g:each>
				</span>
			</li>
			</g:if>
			
			<g:if test="${ solicitudesPendientes }">
			<li class="fieldcontain">
				<span id="nombre-label" class="property-label">Hay solicitudes</span>
				<span class="property-value" >
					<g:link controller="solicitudCategoria" action="list">de categoria pendientes</g:link>
				</span>
			</li>
			</g:if>
			
		</ol>
	</div>
</body>
</html>