<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		
		<!-- 
		Aparentemente, estos son los CSS que usa la pagina solamente.. 
		Al menos, en la principal 
		<link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/css.css" media="all" />
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar//css/grid_16.css" media="all" />
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/js/news/css/style2.css" />
		-->    
	   	
	    <link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	 	<link href="${resource(dir: 'css', file: 'grid_16.css') }" type="text/css" rel="stylesheet">
	 	<link href="${resource(dir: 'css', file: 'style2.css') }" type="text/css" rel="stylesheet">
	    
	    <!-- CSS ORIGINALMENTE EN LA WEB...
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/common.css" media="all" />
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/css.css" media="all" />
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar//css/grid_16.css" media="all" />
	    <link rel="stylesheet" href="http://www.acsr.com.ar/js/growler/css/examples.css" type="text/css" media="screen" charset="utf-8" />
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/css/view.css" media="all"/>
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/js/lightview/css/lightview.css" />
	    <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/js/news/css/style2.css" />
	    <link rel="stylesheet" href="http://www.acsr.com.ar/js/prettyphoto/css/prettyPhoto.css" type="text/css" media="screen" charset="utf-8" />
	     -->
	         
	   <style>     
	       ul.lof-main-wapper li {
	           position:relative;    
	       }
	   </style>  
	   
	   
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
	
	<g:render template="/usuario/barraUsuario" />
	
		<div class="header mt20">
    <div class="logo" style="width: 100px;">
        <a href="http://www.acsr.com.ar/">
            <img src="http://www.acsr.com.ar/images/acs.png" alt="Logo Asociación Cordobesa de Squash Raquets" title="Logo Asociación Cordobesa de Squash Raquets"/>
        </a>
    </div>
    
    <div class="live-tour" >
    	<div id="headerLiveScoreBox1" class="headerLiveScoreBox " style="width:275px">
    		<div class="backgroundFrame">
    			</div><img class="scoreboardLogo" src="http://www.acsr.com.ar/images/img.php?src=http://www.acsr.com.ar/images/afiches/163g.jpg&h=55&zc=1">
    				<p class="headScorebrdTitle"><a href="#">10º fecha ACS 2013 - Les Courts</a></p>
    				<p class="headerScorebrdPlace">24-08 al 01-09</p><p class="headScorebrdTitle" style="margin-top: 5px;">
    				<a href="/SistemaGestionTorneo/inscripcionTorneo/list" class="button_small green">Inscribite >></a>
    				<a href="/SistemaGestionTorneo/torneo/list" class="ml10 button_small blue">Info >></a></p></div></div>    
    				
	<ul class="sponsors">				
        <li style="border: none;"><a href="#"><img src="http://www.acsr.com.ar/images/mains.png" alt="Sponsors" title="Sponsors"/></a></li>
        <li><a href="http://www.zyngra.com/" target="_blank"><img src="http://www.acsr.com.ar/images/zingra.png"  alt="Sponsors Zingra" title="Sponsors Zingra"/></a></li>
        <li><a href="http://www.movistar.com.ar/" target="_blank"><img src="http://www.acsr.com.ar/images/movistar.png"  alt="Sponsors movistar" title="Sponsors movistar"/></a></li>
        <li><a href="http://www.croquisdigital.com/" target="_blank"><img src="http://www.acsr.com.ar/images/croquis.png"  alt="Sponsors Croquis" title="Sponsors Croquis"/></a></li> 
        <li><a href="http://www.suplementosacross.com" target="_blank"><img src="http://www.acsr.com.ar/images/across.png"  alt="Across Sport Nutrition" title="Sponsors Across"/></a></li> 
    </ul>
</div>




<div class="container_16 nav mt20">
    <ul>
        <li><a href="/SistemaGestionTorneo/">Home</a></li>
        <li><a href="#">La ACS</a></li>
        <li><a href="#">Noticias</a></li>
        <li><a href="/SistemaGestionTorneo/usuario/list">Jugadores</a></li>
        <li><a href="/SistemaGestionTorneo/torneo/list">Torneos</a></li>        
        <li><a href="/SistemaGestionTorneo/club/list">Clubes</a></li>
        <li><a href="/SistemaGestionTorneo/partido/list">Diagramación</a></li>
        <li><a href="#">Contacto</a></li>
        <li>
            <form action="#" method="get" name="searchForm" id="headerSearch" onsubmit="return false;">
                <input type="text" value="Ingresar Jugador" name="search-top" class="autocomplete ac_input" id="search-top" 
                    autocomplete="off"
                    onkeypress="autosuggest_jugadores('#search-top', '#results-home', '#jug-home', 0);"
                    onblur="if (!this.value) {this.value = 'Ingresar Jugador'}" 
                    onfocus="if (this.value == 'Ingresar Jugador') {this.value = ''}" 
                >
                <input type="hidden" name="jug-home" id="jug-home" class="autoCompId"> 
                <div id="results-home" class="results results-h2h raised"></div>
                <input type="hidden" class="autoCompId">                
                <span class="lupa"></span>
            </form>
        </li>
    </ul>
    
    
</div>
  		<div class="container_16">
		<div class="slides-home raised">
		<div class="second-part mt10">
			<g:layoutBody/>
			<div class="footer" role="contentinfo"></div>
			<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
			<g:javascript library="application"/>
			<r:layoutResources />
		</div>
		</div>
		</div>
	</body>
</html>
