<!DOCTYPE html>
<html>
<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"	type="text/css" rel="stylesheet">
<meta name="layout" content="main">
</head>
<body>
	<div class="menu_jugador" style="margin-top: 0.8em;">
		<g:render template="listaClubes" model="['listadoClub':listadoClub]" />
	</div>
	<div class="grid_16 mt10 mb10">
		<div class="grid_10">
			<div class="box box-607" style="margin-left: 2em;width: 50em;">			
								
				<g:render template="clubCard" model="['club':club]"/>
				
			</div>
		</div>
		
	</div>	

</body>
</html>