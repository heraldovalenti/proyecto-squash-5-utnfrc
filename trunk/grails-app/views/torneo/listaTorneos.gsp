<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
</head>
<body>
	<h3>Listado de torneos de la ACS</h3>
	<div id="opciones-filtro">
		Año: <g:select name="year" from="${2000..2013 }" value="${ year }" />
		<g:checkBox name="soloPuntuables" value="${ soloPuntuables }" />
		<g:link controller="listaTorneo" action="listaTorneos">Enviar</g:link>
	</div>
	<div id="resultados-filtro">
		<g:render template="/torneo/torneoCard" var="torneoInstance" collection="${ torneoInstanceList }" />
	</div>
</body>
</html>
