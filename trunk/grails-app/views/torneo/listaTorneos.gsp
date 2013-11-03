<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
</head>
<body>
	<h3>Listado de torneos de la ACS</h3>
	<div>
		<ul>
			<li>Torneos: Todos - Solo puntuables</li>
			<li>Año: 2013 2012 2011 2010</li>
		</ul>
	</div>
	<div>
		<g:render template="/torneo/torneoCard" var="torneoInstance" collection="${ torneoInstanceList }" />
	</div>
</body>
</html>
