<!DOCTYPE html>
<html>
<head>
<title>Clubes registrados en la ACS</title>
<meta name="layout" content="main">

<link href="${resource(dir: 'css', file: 'torneo.css') }"
	type="text/css" rel="stylesheet">

</head>
<body>
	<div class="caja_contenido">
		<div class="lista_fechas">
			<h3 class="titulo">Clubes registrados en la ACS</h3>
			
			<g:each in="listadoClub" status="i" var="club">
				
			</g:each>
			
		</div>
		<div class="proxima_fecha">
			<h3 class="titulo">Proximo torneo.</h3>
			<p>Inscripcion o informacion sobre el torneo actual o mas proximo</p>
		</div>
	</div>
</body>
</html>