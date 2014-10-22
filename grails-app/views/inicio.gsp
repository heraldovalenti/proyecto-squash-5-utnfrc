<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'grid_16.css') }" type="text/css" rel="stylesheet">
 	<link href="${resource(dir: 'css', file: 'style2.css') }" type="text/css" rel="stylesheet">	
 	
 	<r:require module="inicio"/> 	

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
	    
	    <!-- SPONSORS -->
	    <g:render template="/secciones/sponsors" />
				

	</div>
	
	<!-- BARRA DE NAVEGACION DEL SITIO -->
	<g:render template="/secciones/barraNavegacion" />
    
	<div class="container_16">
		<div class="slides-home raised">
			<div class="grid_16 mt10 ">
				<div id="jslidernews2" class="lof-slidecontent"
					style="width: 970px; height: 300px;">
					<div class="preload">						
					</div>
					<div class="button-previous">Anterior</div>
					<!-- MAIN CONTENT -->
					<div class="main-slider-content"
						style="width: 675px; height: 300px;">
						<ul class="sliders-wrap-inner">
							<li><img src="images/noticias/1.jpg"
								title="Ya estan abiertas las incripciones online para la Fachada"/><div
										class="slider-description">
										<div class="slider-meta">
											<a title="PROXIMA FECHA" href="index.php?c=noticias">/
												PROXIMA FECHA /</a> <i> — Sábado 21 de Septiembre de 2013</i>
										</div>
										<h4>Ya estan abiertas las incripciones online para la
											Fachada</h4>
										<p>
											Del 28 de Septiembre al 6 de Octubre se juega en La Fachada
											la 12ma fecha puntable de la ACSR. Inscribite Online Ahora.
											...<a class="readmore" href="#">Leer Más </a>
										</p>
									</div></li>
							<li><img src="images/noticias/2.jpg"
								title="Argentina Vs Mexico"/><div
										class="slider-description">
										<div class="slider-meta">
											<a title="IMPERDIBLE" href="index.php?c=noticias">/
												IMPERDIBLE /</a> <i> — Viernes 20 de Septiembre de 2013</i>
										</div>
										<h4>Argentina Vs Mexico</h4>
										<p>
											Mira la final completa por equipos del torneo Panamericano
											por Equipos. El 3er Punto de la serie es imperdible. ...<a
												class="readmore"
												href="http://www.acsr.com.ar/noticias/a270/panamericano-2013-final-por-equipos.html#">Leer
												Más </a>
										</p>
									</div></li>
							<li><img src="images/noticias/3.jpg"
								title="MIGUEL ANGEL RODRIGUEZ"/><div
										class="slider-description">
										<div class="slider-meta">
											<a title="TRAINING" href="index.php?c=noticias">/
												TRAINING /</a> <i> — Jueves 19 de Septiembre de 2013</i>
										</div>
										<h4>MIGUEL ANGEL RODRIGUEZ</h4>
										<p>
											Te mostramos algunos momentos del entrenamiento de Miguel
											Angel Rodriguez, considerado el jugador mas rapido del
											circuito PSA. ...<a class="readmore"
												href="http://www.acsr.com.ar/noticias/a272/entrenamiento-miguel-angel-rodriguez.html#">Leer
												Más </a>
										</p>
									</div></li>
							<li><img src="images/noticias/4.png"
								title="Los menores cordobeses obtuvieron excelentes resultados"/><div
										class="slider-description">
										<div class="slider-meta">
											<a title="NACIONAL MENORES" href="index.php?c=noticias">/
												NACIONAL MENORES /</a> <i> — Domingo 25 de Agosto de 2013</i>
										</div>
										<h4>Los menores cordobeses obtuvieron excelentes
											resultados</h4>
										<p>
											Ramiro y Matias se destacaron en el Nacional de Puerto Madryn
											...<a class="readmore"
												href="http://www.acsr.com.ar/noticias/a269/impresionantes-conquistas-de-los-menores-cordobeses.html#">Leer
												Más </a>
										</p>
									</div>
								</li>							

						</ul>
					</div>
					<!-- END MAIN CONTENT -->
					<!-- NAVIGATOR -->
					<div class="navigator-content">
						<div class="navigator-wrapper">
							<ul class="navigator-wrap-inner">
								<li><div>
										<img src="images/noticias/1a.jpg" />
										<h3>Argentina Vs Mexico</h3>
										<span>20.09.2013</span> -Mira la final completa por equipos
										del torneo Panamericano por Equipos. E...
									</div></li>
								<li><div>
										<img src="images/noticias/2a.jpg" />
										<h3>MIGUEL ANGEL RODRIGUEZ</h3>
										<span>19.09.2013</span> -Te mostramos algunos momentos del
										entrenamiento de Miguel Angel Rodriguez...
									</div></li>
								<li><div>
										<img src="images/noticias/3a.png" />
										<h3>Los menores cordobeses obtuvieron excelentes
											resultados</h3>
										<span>25.08.2013</span> - Colecci&oacute;n de noticias y
										documentos de interes contandote como fue ...
									</div></li>
							</ul>
						</div>
					</div>
					<!----------------- END OF NAVIGATOR --------------------->
					<div class="button-next">Next</div>
					<!-- BUTTON PLAY-STOP -->
					<div class="button-control">
						<span></span>
					</div>
					<!-- END OF BUTTON PLAY-STOP -->
				</div>
			</div>

			<!----------------- PANEL DE ABAJO DEL SLIDER-------------------->

			<div class="second-part mt10">
				<div class="grid_16 mt10">
					<div class="grid_10">

												
									<%--ACÁ VA LA TABLA DE RANKING--%>			
												


				</div>
			</div>
		</div>						
<!----------------- CIERRA PANEL DE ABAJO DEL SLIDER-------------------->
	
	</div>	
</div>

<r:layoutResources />
</body> 
</html>

