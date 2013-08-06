<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main" />
	<title>Listado de Torneos</title>
	
</head>
<body>
	<div class="container_16">
		<div class="slides-home raised">
			<div class="second-part mt10">
				<div class="grid_16 inside mt10">
				<h3 class="title">Listado de Torneos</h3>
					<g:render template="torneoCard" collection="${ torneos }" var="torneo" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>