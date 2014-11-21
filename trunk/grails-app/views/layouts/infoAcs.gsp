<html>
<head>
	<title>La ACS</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<r:require module="jquery"/>
	
    <link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'grid_16.css') }" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'style2.css') }" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'calendar.css')}" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'jugador.css') }" type="text/css" rel="stylesheet">
        
	<g:layoutHead/>
	<r:layoutResources />
</head>
<body>
		<!-- BARRA DE USUARIO -->
	<g:render template="/usuario/barraUsuario" />
	
	<div class="header mt20">
	    <div class="logo" style="width: 100px;">
	        <a href="/SistemaGestionTorneo">
	            <img src="/SistemaGestionTorneo/images/acs.png" alt="Logo Asociación Cordobesa de Squash Raquets" 
	            	title="Logo Asociación Cordobesa de Squash Raquets"/>
	        </a>
	    </div>
    
    	<!-- TORNEO ACTUAL -->
	    <g:render template="/secciones/torneoActual" />
	    
	    <g:render template="/secciones/sponsors" />
				
	</div>
	
	<!-- BARRA DE NAVEGACION DEL SITIO -->
	<g:render template="/secciones/barraNavegacion" />
	
	<!-- CUERPO GENERAL DE LA PAGINA - A llenarse desde el Layout -->
	<div class="container_16">
		<div class="slides-home raised">
			<div class="second-part mt10">
				<div class="menu_jugador">
					<g:render template="/acsInfo/menuInfo" />
				</div>
				<div class="contenido_jugador">
					<g:layoutBody/>
				</div>
				
				<!-- PIE DE PAGINA -->
				<r:layoutResources />
			</div>
		</div>
	</div>
</body>