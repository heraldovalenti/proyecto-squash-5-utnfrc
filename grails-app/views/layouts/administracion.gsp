<head>
	<title>Administracion</title>
    
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'administracion.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'tabla.css') }" type="text/css" rel="stylesheet"> 
   
   <r:require module="jquery" />
	<g:layoutHead/>
	<r:layoutResources />
</head>
	
	
<body>	

<!-- BARRA DE USUARIO -->
	<g:render template="/usuario/barraUsuario" />
		
	<div class="header mt20">
	    <div class="logo" style="width: 100px;">
	        <a href="/SistemaGestionTorneo">
	            <img src="${ resource(dir: 'images', file: 'acs.png') }" alt="Logo Asociación Cordobesa de Squash Raquets" 
	            	title="Logo Asociación Cordobesa de Squash Raquets"/>
	        </a>
	    </div>  			
	</div>	
	
	<!-- CUERPO GENERAL DE LA PAGINA - A llenarse desde el Layout -->
	<div class="container_16">
		<div class="slides-home raised">
			<div class="second-part mt10">
			<h3 class="title"> Panel de Administración</h3>
				
				<!-- CUERPO GENERAL DE LA PAGINA - A llenarse desde el Layout -->
				<div class="menu_jugador">
				<g:render template="/administracion/menuAdministracion" />
				</div>
				
				<div class="contenido_jugador">
				<g:layoutBody />
				</div>
			</div>
		</div>
	</div>
	<r:layoutResources />
</body>
</html>




