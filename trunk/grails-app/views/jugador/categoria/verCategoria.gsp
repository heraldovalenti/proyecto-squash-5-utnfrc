<%@ page import="sgt.Categoria" %>

<html>
<head>
	<meta name="layout" content="jugador">
	<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
</head>
<body>
	<h3>Categoría de jugador</h3>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<div id="categoriasJugador">
		<ol class="property-list categoriaJugador">
			<li class="fieldcontain">
				<span id="categoriaActual-label" class="property-label">Categoría actual</span>
				<span class="property-value" aria-labelledby="altura-label">
					<g:if test="${ categoriaActual }">
						${ categoriaActual?.toString() }
					</g:if>
					<g:else>Sin categoría asignada</g:else>
				</span>				
			</li>
			
			<li class="fieldcontain">
				<span id="categoriaActual-label" class="property-label">Categoría solicitada</span>
				<span class="property-value" aria-labelledby="altura-label">
					<g:if test="${ categoriaSolicitada }">
						${ categoriaSolicitada?.toString() } - <g:link controller="categoriaJugador" action="cancelarSolicitud">Cancelar solicitud</g:link>
					</g:if>
					<g:else>
						<g:link controller="categoriaJugador" action="solicitarNuevaCategoria">N/A - Solicitar nueva categoría</g:link>
					</g:else>
				</span>				
			</li>
			
			<li class="fieldcontain">Ver historial de categorías</li>
		</ol>
	</div>
</body>
</html>