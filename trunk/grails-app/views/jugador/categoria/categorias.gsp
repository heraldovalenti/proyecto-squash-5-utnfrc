<html>
<head>
	<meta name="layout" content="jugador">
</head>
<body>

	<h3 class="title mt10">Categorias de jugador</h3>
		
	<g:render template="/utils/messages" />
		
	<g:if test="${ solicitud }">
	<div class="mt10 ml10 mb10 mr20 box-607 box odd">
		<h1 class="title-news mt10 mb10">Solicitud de categoría</h1>
		<div class="fl" style="width: 100%;">
			<ol class="property-list ma00 pa00">
				
				<li class="fieldcontain">
					<span class="property-label">En categoría</span>
					<span class="property-value">${ solicitud.categoria }</span>
				</li>
				
				<li class="fieldcontain">
					<span class="property-label">Fecha de solicitud</span>
					<span class="property-value"> 
						<g:formatDate date="${ solicitud.fechaInicio }"
							format="dd/MM/yyyy"/>
					</span>
				</li>
				
			</ol>
		</div>	
		<div class="fl" style="width: 100%;">
			<g:link controller="jugador" action="cancelarSolicitudCategoria"
				class="fr mb10 mr10 button_small red deletion-button">Cancelar solicitud</g:link>
		</div>
	</div>
	</g:if>
	
	<div class="mt10 ml10 mb10 mr20 box-607 box odd">
		<h1 class="title-news mt10 mb10">Categoria actual</h1>
		<div class="fl" style="width: 100%;">
			<ol class="property-list ma00 pa00">
				
				<g:if test="${ categoria }">
				<li class="fieldcontain">
					<span class="property-label">Categoria</span>
					<span class="property-value">${ categoria.categoria }</span>
				</li>
				
				<li class="fieldcontain">
					<span class="property-label">Desde</span>
					<span class="property-value"> 
						<g:formatDate date="${ categoria.fechaInicio }"
							format="dd/MM/yyyy"/>
					</span>
				</li>
				</g:if>
				
				<g:else>
					<span class="property-label">No posee categoria actualmente</span>
				</g:else>
				
			</ol>
		</div>
		<div class="fl" style="width: 100%;">
			<g:link controller="jugador" action="solicitudCategoria"
				class="fr mb10 mr10 button_small blue ">Solicitar nueva categoria</g:link>
		</div>
	</div>
	
	<g:if test="${ historial.size() > 0 }">
	<div class="mt10 ml10 mb10 mr20 box-607 box odd">
		<h1 class="title-news mt10 mb10">Historial de categorias</h1>
		<div class="fl" style="width: 100%;">
			<ol class="property-list ma00 pa00">
				
				<g:each in="${ historial }" var="categoria">
				<li class="fieldcontain">
					<span class="property-label">${ categoria.categoria }</span>
					<span class="property-value">
						Desde <g:formatDate date="${ categoria.fechaInicio }"
							format="dd/MM/yyyy"/> hasta
						<g:formatDate date="${ categoria.fechaFin }"
							format="dd/MM/yyyy"/>
					</span>
				</li>
				</g:each>
				
			</ol>
		</div>
	</div>
	</g:if>
	
	<r:require module="deletion"/>
</body>
</html>