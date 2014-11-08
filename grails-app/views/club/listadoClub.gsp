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
	<div class="grid_16 mb10" >
		<div class="grid_10" style="border: 1px solid #BBB;">
					
								
				<g:render template="clubCard" model="['club':club]"/>	
				
				<g:render template="domicilio/mapa" model="['club':club]"/>		
				
					
		</div>		
	</div>	

</body>
</html>