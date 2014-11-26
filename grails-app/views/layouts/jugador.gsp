<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Jugador</title>
	
    <link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet"/>
 	<link href="${resource(dir: 'css', file: 'grid_16.css') }" type="text/css" rel="stylesheet"/>
 	<link href="${resource(dir: 'css', file: 'style2.css') }" type="text/css" rel="stylesheet"/>
 	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet"/>
 	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet"/>
 	<link href="${resource(dir: 'css', file: 'jugador.css') }" type="text/css" rel="stylesheet"/>
 	
	<g:layoutHead/>
	<r:require module="jquery" />
	<r:layoutResources />
</head>
	
	
<body>
	<!-- BARRA DE USUARIO -->
	<g:render template="/usuario/barraUsuario" />
	
	<div class="header mt20">
	    <div class="logo" style="width: 100px;">
	        <a href="/SistemaGestionTorneo">
	            <img src="/SistemaGestionTorneo/images/acs.png" 
	            	alt="Logo Asociación Cordobesa de Squash Raquets" 
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
					<g:render template="/jugador/menuJugador" />
				</div>
				<div class="contenido_jugador">
					<g:layoutBody/>
				</div>
			</div>
		</div>
	</div>
	<r:layoutResources />
</body>
</html>