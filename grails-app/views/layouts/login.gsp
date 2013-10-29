<%@ page import="sgt.Persona"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title><g:layoutTitle default="Grails"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    
	
	<link href="${resource(dir: 'css', file: 'login.css') }" type="text/css"	rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'grid_16.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	
        
   	<style>
   		ul.lof-main-wapper li {
  			position:relative;    
		}
	</style>  
   
	<g:layoutHead/>
	<r:layoutResources />
</head>
	
	
<body>	

<!-- BARRA DE USUARIO -->
	<g:render template="/usuario/barraUsuario" />
	
	
		
	<div class="header mt20">
	    <div class="logo" style="width: 100px;">
	        <a href="http://www.acsr.com.ar/">
	            <img src="http://www.acsr.com.ar/images/acs.png" alt="Logo Asociación Cordobesa de Squash Raquets" 
	            	title="Logo Asociación Cordobesa de Squash Raquets"/>
	        </a>	       
    					
	</div>	
		<!-- TORNEO ACTUAL -->
	    <g:render template="/secciones/torneoActual" />
				
	</div>
	
	<!-- BARRA DE NAVEGACION DEL SITIO -->
	<g:render template="/secciones/barraNavegacion" />
	
	<!-- CUERPO GENERAL DE LA PAGINA - A llenarse desde el Layout -->
		<div class="container_16">						
				<div class="contenido_login">
						<g:layoutBody />
				</div>					
				
				<!-- PIE DE PAGINA -->
				<div class="footer" role="contentinfo"></div>
				<div id="spinner" class="spinner" style="display:none;">
					<g:message code="spinner.alt" default="Loading&hellip;"/>
				</div>
					<g:javascript library="application"/>
				<r:layoutResources />
			</div>
		</div>	
</body>
</html>

