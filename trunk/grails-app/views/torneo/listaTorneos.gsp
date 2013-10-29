<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<title>Asociación Cordobesa de Squash</title>
</head>
<body>
	<h3>Listado de torneos de la ACS</h3>
	<div>Opciones de listado</div>
	<div>
		<g:render template="/torneo/torneoCard" var="torneoInstance" collection="${ torneoInstanceList }" />
	</div>
</body>
</html>
