<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- Head -->
<head>
		<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css"	rel="stylesheet"/>
		<link href="${resource(dir: 'css', file: 'grid_16.css') }"	type="text/css" rel="stylesheet"/>
		<link href="${resource(dir: 'css', file: 'style2.css') }" type="text/css" rel="stylesheet"/>


			<title>Asociación Cordobesa de Squash</title>

			<script
				src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
			<script src="http://www.acsr.com.ar/js/ajax.js?1375646306"
				type="text/javascript"></script>
			<script type="text/javascript"
				src="http://www.acsr.com.ar/js/view.js"></script>
			<script type="text/javascript"
				src="http://www.acsr.com.ar/lib/ajax_framework.js"></script>
			<script type="text/javascript"
				src="http://www.acsr.com.ar/js/md5-min.js"></script>

			<link rel="shortcut icon" type="image/x-icon"
				href="http://www.acsr.com.ar/favicon.ico" />


			<script language="javascript" type="text/javascript" src="http://www.acsr.com.ar/js/news/js/jquery.easing.js"></script>
			<script language="javascript" type="text/javascript" src="http://www.acsr.com.ar/js/news/js/script.js"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					var buttons = {
						previous : $('#jslidernews2 .button-previous'),
						next : $('#jslidernews2 .button-next')
					};
					$('#jslidernews2').lofJSidernews({
						interval : 5000,
						easing : 'easeInOutQuad',
						duration : 1200,
						auto : true,
						mainWidth : 675,
						mainHeight : 300,
						navigatorHeight : 100,
						navigatorWidth : 310,
						maxItemDisplay : 3,
						buttons : buttons
					});
				});

				var dom = 'http://www.acsr.com.ar/';
				var dom = 'http://www.acsr.com.ar/';
			</script>
			<script
				src="http://www.acsr.com.ar/js/prettyphoto/js/jquery.prettyPhoto.js"
				type="text/javascript" charset="utf-8"></script>

			<link rel="image_src"
				href="http://www.acsr.com.ar/images/logoface.jpg" />
			<script type="text/javascript"
				src="http://www.acsr.com.ar/js/jquery.tools.min.js"></script>
</head>
<body>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/es_LA/all.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>



	<!-- Header -->

	<g:render template="/usuario/barraUsuario" />

	<div class="header mt20">
		<div class="logo" style="width: 100px;">

			<img src="images/acs.png"
				alt="Logo Asociación Cordobesa de Squash Raquets"
				title="Logo Asociación Cordobesa de Squash Raquets" />

		</div>

		<div class="live-tour">
			<div id="headerLiveScoreBox1" class="headerLiveScoreBox ">
				<div class="backgroundFrame"></div>
				<img class="scoreboardLogo"
					src="http://www.acsr.com.ar/images/img.php?src=http://www.acsr.com.ar/images/afiches/163g.jpg&h=55&zc=1"/>
					<p class="headScorebrdTitle">
						<a href="#">10º fecha ACS 2013 - Les Courts</a>
					</p>
					<p class="headerScorebrdPlace">24-08 al 01-09</p>
					<p class="headScorebrdTitle" style="margin-top: 5px;">
						<a href="/SistemaGestionTorneo/inscripcionTorneo/list"
							class="button_small green">Inscribite >></a> <a
							href="/SistemaGestionTorneo/torneo/list"
							class="ml10 button_small blue">Info >></a>
					</p>
			</div>
		</div>

		<ul class="sponsors">
			<li style="border: none;"><a href="#"><img
					src="http://www.acsr.com.ar/images/mains.png" alt="Sponsors"
					title="Sponsors" /></a></li>
			<li><a href="http://www.zyngra.com/" target="_blank"><img
					src="http://www.acsr.com.ar/images/zingra.png"
					alt="Sponsors Zingra" title="Sponsors Zingra" /></a></li>
			<li><a href="http://www.movistar.com.ar/" target="_blank"><img
					src="http://www.acsr.com.ar/images/movistar.png"
					alt="Sponsors movistar" title="Sponsors movistar" /></a></li>
			<li><a href="http://www.croquisdigital.com/" target="_blank"><img
					src="http://www.acsr.com.ar/images/croquis.png"
					alt="Sponsors Croquis" title="Sponsors Croquis" /></a></li>
			<li><a href="http://www.suplementosacross.com" target="_blank"><img
					src="http://www.acsr.com.ar/images/across.png"
					alt="Across Sport Nutrition" title="Sponsors Across" /></a></li>
		</ul>
	</div>


	<!-- BARRA DE NAVEGACION DEL SITIO -->
	<g:render template="/secciones/barraNavegacion" />



	<div class="container_16">
		<!-- Content -->
		<div class="slides-home raised">
			<div class="grid_16 mt10 ">
				<div id="jslidernews2" class="lof-slidecontent"
					style="width: 970px; height: 300px;">
					<div class="preload">
						<div></div>
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
									</div></li>
							<li><img src="images/noticias/5.png"
								title="Recopilacón Histórica de la ACSR"/><div
										class="slider-description">
										<div class="slider-meta">
											<a title="Historia" href="index.php?c=noticias">/
												Historia /</a> <i> — Viernes 24 de Mayo de 2013</i>
										</div>
										<h4>Recopilacón Histórica de la ACSR</h4>
										<p>
											Colecci&oacute;n de noticias y documentos de interes
											contandote como fue creciendo la Asociaci&oacute;n en la
											&uacute;ltima d&eacute;cada. ...<a class="readmore"
												href="http://www.acsr.com.ar/noticias/a240/recopilacinin-historica-de-la-acsr.html#">Leer
												Más </a>
										</p>
									</div></li>
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

			<!----------------- PANEL DE PROPAGANDAS--------------------->

			<div class="second-part mt10">
				<div class="grid_16 mt10">
					<div class="grid_10">
						<ul class="categorias-home">
							<li class=""><a class="active home-rank-item" rel="tab-1"
								href="#">1</a></li>
							<li class=""><a class=" home-rank-item" rel="tab-2" href="#">2</a></li>
							<li class=""><a class=" home-rank-item" rel="tab-3" href="#">3</a></li>
							<li class=""><a class=" home-rank-item" rel="tab-4" href="#">4</a></li>
							<li class=""><a class=" home-rank-item" rel="tab-5" href="#">5</a></li>
							<li class=""><a class=" home-rank-item" rel="tab-6" href="#">6</a></li>
							<li class=""><a class=" home-rank-item" rel="tab-7" href="#">7</a></li>
							<li class="ladys"><a class=" home-rank-item" rel="tab-D"
								href="#">D "A"</a></li>
							<li class="ladys"><a class=" home-rank-item" rel="tab-E"
								href="#">D "B"</a></li>
							<li class="ladys"><a class=" home-rank-item" rel="tab-F"
								href="#">D "C"</a></li>
						</ul>
						
						<div class="ranking-home">
							<div class="tab-1 tab-content" style="display: block;">
								<ul>
									<li class=" home-player" id="jugador_8"><span class="rank">1</span>
									<h2 class="name">
											<span class="fname">GUILLERMO</span>&nbsp;&nbsp; <span
												class="lname">EASDALE</span> <span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/8.jpg&w=111&h=149&zc=1</span>
											<span class="cat clear">PRIMERA</span><span class="age clear">27</span>
											<span class="url clear">http://www.acsr.com.ar/perfiles/j8/easdale-guillermo.html</span>
										</h2> <span class="score">1350</span> <span class="arrow"></span></li>
									<li class=" home-player" id="jugador_775"><span
										class="rank">2</span>
									<h2 class="name">
											<span class="fname">JUAN PABLO</span>&nbsp;&nbsp;<span
												class="lname">PRAMPARO</span> <span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/775.jpg&w=111&h=149&zc=1</span>
											<span class="cat clear">PRIMERA</span> <span
												class="age clear">33</span> <span class="url clear">http://www.acsr.com.ar/perfiles/j775/pramparo-juan-pablo.html</span>
										</h2> <span class="score">1100</span> <span class="arrow"></span></li>
									<li class=" home-player" id="jugador_3"><span class="rank">3</span>
									<h2 class="name">
											<span class="fname">MARTIN</span>&nbsp;&nbsp;<span
												class="lname">EASDALE</span> <span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/3.jpg&w=111&h=149&zc=1</span>
											<span class="cat clear">PRIMERA</span> <span
												class="age clear">31</span><span class="url clear">http://www.acsr.com.ar/perfiles/j3/easdale-martin.html</span>
										</h2> <span class="score">850</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_18"><span
										class="rank">4</span>
									<h2 class="name">
											<span class="fname">GUILLERMO </span>&nbsp;&nbsp; <span
												class="lname">PEDERNERA</span> <span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/18.jpg&w=111&h=149&zc=1</span>
											<span class="cat clear">PRIMERA</span><span class="age clear">33</span>
											<span class="url clear">http://www.acsr.com.ar/perfiles/j18/pedernera-guillermo-.html</span>
										</h2>
										<span class="score">825</span> <span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1"><span class="rank">5</span>
									<h2 class="name">
											<span class="fname">HERNAN JAVIER</span>&nbsp;&nbsp; <span
												class="lname">D`ARCANGELO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1.jpg&w=111&h=149&zc=1</span>
											<span class="cat clear">PRIMERA</span> <span
												class="age clear">32</span><span class="url clear">http://www.acsr.com.ar/perfiles/j1/d-arcangelo-hernan-javier.html</span>
										</h2> <span class="score">600</span><span class="arrow"></span></li>
									<li class="active home-player" id="jugador_733"><span
										class="rank">6</span>
									<h2 class="name">
											<span class="fname">DAMIAN</span>&nbsp;&nbsp;<span
												class="lname">PEREYRA</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/733.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">PRIMERA</span><span class="age clear">2013</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j733/pereyra-damian.html</span>
										</h2>
										<span class="score">425</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_307"><span
										class="rank">7</span>
									<h2 class="name">
											<span class="fname">FRANCISCO </span>&nbsp;&nbsp;<span
												class="lname">BOBADILLA</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/307.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">PRIMERA</span><span class="age clear">32</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j307/bobadilla-francisco-.html</span>
										</h2>
										<span class="score">375</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_746"><span
										class="rank">8</span>
									<h2 class="name">
											<span class="fname">CARLOS</span>&nbsp;&nbsp;<span
												class="lname">VILA</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/746.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">PRIMERA</span><span class="age clear">41</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j746/vila-carlos.html</span>
										</h2>
										<span class="score">287.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1312"><span
										class="rank">9</span>
									<h2 class="name">
											<span class="fname">ROBERTO</span>&nbsp;&nbsp;<span
												class="lname">GRASSO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1312.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">PRIMERA</span><span class="age clear">2013</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1312/grasso-roberto.html</span>
										</h2>
										<span class="score">250</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1220"><span
										class="rank">10</span>
									<h2 class="name">
											<span class="fname">MATIAS </span>&nbsp;&nbsp;<span
												class="lname">KUPFERBERG</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1220.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">PRIMERA</span><span class="age clear">14</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1220/kupferberg-matias-.html</span>
										</h2>
										<span class="score">225</span><span class="arrow"></span></li>
								</ul>
							</div>
							<div class="tab-2 tab-content" style="display: none;">
								<ul>
									<li class=" home-player" id="jugador_29"><span
										class="rank">1</span>
									<h2 class="name">
											<span class="fname">HERNAN</span>&nbsp;&nbsp;<span
												class="lname">RODRIGUEZ</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/29.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">38</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j29/rodriguez-hernan.html</span>
										</h2>
										<span class="score">950</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_109"><span
										class="rank">2</span>
									<h2 class="name">
											<span class="fname">SEBASTIAN</span>&nbsp;&nbsp;<span
												class="lname">SERENO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/109.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">37</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j109/sereno-sebastian.html</span>
										</h2>
										<span class="score">900</span><span class="arrow"></span></li>
									<li class="active home-player" id="jugador_46"><span
										class="rank">3</span>
									<h2 class="name">
											<span class="fname">FLAVIO</span>&nbsp;&nbsp;<span
												class="lname">VENTURI</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/46.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">41</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j46/venturi-flavio.html</span>
										</h2>
										<span class="score">775</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_839"><span
										class="rank">4</span>
									<h2 class="name">
											<span class="fname">RAMIRO</span>&nbsp;&nbsp;<span
												class="lname">DIAZ FALCO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/839.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">18</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j839/diaz-falco-ramiro.html</span>
										</h2>
										<span class="score">725</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_398"><span
										class="rank">5</span>
									<h2 class="name">
											<span class="fname">LEONARDO</span>&nbsp;&nbsp;<span
												class="lname">FLORIDIA</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/398.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">31</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j398/floridia-leonardo.html</span>
										</h2>
										<span class="score">550</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1220"><span
										class="rank">6</span>
									<h2 class="name">
											<span class="fname">MATIAS </span>&nbsp;&nbsp;<span
												class="lname">KUPFERBERG</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1220.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">14</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1220/kupferberg-matias-.html</span>
										</h2>
										<span class="score">512.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_12"><span
										class="rank">7</span>
									<h2 class="name">
											<span class="fname">GERMÁN</span>&nbsp;&nbsp;<span
												class="lname">JOURNÉ</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/12.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">40</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j12/journ-germ-n.html</span>
										</h2>
										<span class="score">350</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_746"><span
										class="rank">8</span>
									<h2 class="name">
											<span class="fname">CARLOS</span>&nbsp;&nbsp;<span
												class="lname">VILA</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/746.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">41</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j746/vila-carlos.html</span>
										</h2>
										<span class="score">312.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_135"><span
										class="rank">9</span>
									<h2 class="name">
											<span class="fname">SEAN</span>&nbsp;&nbsp;<span
												class="lname">TOWERS</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/135.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">27</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j135/towers-sean.html</span>
										</h2>
										<span class="score">300</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_384"><span
										class="rank">10</span>
									<h2 class="name">
											<span class="fname">LEONARDO</span>&nbsp;&nbsp;<span
												class="lname">BIANCHI</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/384.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">SEGUNDA</span><span class="age clear">2013</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j384/bianchi-leonardo.html</span>
										</h2>
										<span class="score">262.5</span><span class="arrow"></span></li>
								</ul>
							</div>
							<div class="tab-3 tab-content" style="display: none;">
								<ul>
									<li class=" home-player" id="jugador_1099"><span
										class="rank">1</span>
									<h2 class="name">
											<span class="fname">JOSE</span>&nbsp;&nbsp;<span
												class="lname">GRASSO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1099.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">49</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1099/grasso-jose.html</span>
										</h2>
										<span class="score">887.5</span><span class="arrow"></span></li>
									<li class="active home-player" id="jugador_802"><span
										class="rank">2</span>
									<h2 class="name">
											<span class="fname">MARTIN</span>&nbsp;&nbsp;<span
												class="lname">VIDELA</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/802.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">36</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j802/videla-martin.html</span>
										</h2>
										<span class="score">850</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_67"><span
										class="rank">3</span>
									<h2 class="name">
											<span class="fname">EDUARDO</span>&nbsp;&nbsp;<span
												class="lname">MARTIN</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/67.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">2013</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j67/martin-eduardo.html</span>
										</h2>
										<span class="score">687.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_380"><span
										class="rank">4</span>
									<h2 class="name">
											<span class="fname">JOSé IGNACIO</span>&nbsp;&nbsp;<span
												class="lname">GONZALEZ</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/380.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">36</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j380/gonzalez-jose-ignacio.html</span>
										</h2>
										<span class="score">575</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1466"><span
										class="rank">5</span>
									<h2 class="name">
											<span class="fname">JUAN MANUEL</span>&nbsp;&nbsp;<span
												class="lname">GONZALEZ</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1466.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">32</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1466/gonzalez-juan-manuel.html</span>
										</h2>
										<span class="score">537.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1313"><span
										class="rank">6</span>
									<h2 class="name">
											<span class="fname">MAURO</span>&nbsp;&nbsp;<span
												class="lname">KRUUSE</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1313.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">36</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1313/kruuse-mauro.html</span>
										</h2>
										<span class="score">387.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1135"><span
										class="rank">6</span>
									<h2 class="name">
											<span class="fname">CAMILA</span>&nbsp;&nbsp;<span
												class="lname">GRASSO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1135.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">2013</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1135/grasso-camila.html</span>
										</h2>
										<span class="score">387.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_930"><span
										class="rank">8</span>
									<h2 class="name">
											<span class="fname">JUAN MANUEL</span>&nbsp;&nbsp;<span
												class="lname">TEICHER</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/930.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">35</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j930/teicher-juan-manuel.html</span>
										</h2>
										<span class="score">337.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1176"><span
										class="rank">9</span>
									<h2 class="name">
											<span class="fname">SANTIAGO</span>&nbsp;&nbsp;<span
												class="lname">GORROCHATEGUI</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/0.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">27</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1176/gorrochategui-santiago.html</span>
										</h2>
										<span class="score">300</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_937"><span
										class="rank">10</span>
									<h2 class="name">
											<span class="fname">MAXIMILIANO</span>&nbsp;&nbsp;<span
												class="lname">ROGGERO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/937.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">TERCERA</span><span class="age clear">2013</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j937/roggero-maximiliano.html</span>
										</h2>
										<span class="score">281.25</span><span class="arrow"></span></li>
								</ul>
							</div>
							<div class="tab-4 tab-content" style="display: none;">
								<ul>
									<li class=" home-player" id="jugador_1299"><span
										class="rank">1</span>
									<h2 class="name">
											<span class="fname">RAFAEL</span>&nbsp;&nbsp;<span
												class="lname">TOUTAIN</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1299.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">45</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1299/toutain-rafael.html</span>
										</h2>
										<span class="score">862.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1370"><span
										class="rank">2</span>
									<h2 class="name">
											<span class="fname">PABLO</span>&nbsp;&nbsp;<span
												class="lname">LUCERO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1370.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">34</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1370/lucero-pablo.html</span>
										</h2>
										<span class="score">725</span><span class="arrow"></span></li>
									<li class="active home-player" id="jugador_214"><span
										class="rank">3</span>
									<h2 class="name">
											<span class="fname">CESAR</span>&nbsp;&nbsp;<span
												class="lname">CEBALLOS</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/214.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">48</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j214/ceballos-cesar.html</span>
										</h2>
										<span class="score">675</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1238"><span
										class="rank">4</span>
									<h2 class="name">
											<span class="fname">DIEGO</span>&nbsp;&nbsp;<span
												class="lname">ENRIETTI</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1238.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">30</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1238/enrietti-diego.html</span>
										</h2>
										<span class="score">512.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1466"><span
										class="rank">5</span>
									<h2 class="name">
											<span class="fname">JUAN MANUEL</span>&nbsp;&nbsp;<span
												class="lname">GONZALEZ</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/1466.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">32</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1466/gonzalez-juan-manuel.html</span>
										</h2>
										<span class="score">412.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_1205"><span
										class="rank">6</span>
									<h2 class="name">
											<span class="fname">JORGE</span>&nbsp;&nbsp;<span
												class="lname">CASTELLANO</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/0.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">2013</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j1205/castellano-jorge.html</span>
										</h2>
										<span class="score">350</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_903"><span
										class="rank">7</span>
									<h2 class="name">
											<span class="fname">RODRIGO </span>&nbsp;&nbsp;<span
												class="lname">DE LA VEGA</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/903.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">26</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j903/de-la-vega-rodrigo-.html</span>
										</h2>
										<span class="score">337.5</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_36"><span
										class="rank">8</span>
									<h2 class="name">
											<span class="fname">INIGO</span>&nbsp;&nbsp;<span
												class="lname">BIAIN</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/36.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">47</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j36/biain-inigo.html</span>
										</h2>
										<span class="score">275</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_45"><span
										class="rank">8</span>
									<h2 class="name">
											<span class="fname">MARTIN</span>&nbsp;&nbsp;<span
												class="lname">NAHAS</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/45.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">42</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j45/nahas-martin.html</span>
										</h2>
										<span class="score">275</span><span class="arrow"></span></li>
									<li class=" home-player" id="jugador_744"><span
										class="rank">10</span>
									<h2 class="name">
											<span class="fname">GASTON ARIEL</span>&nbsp;&nbsp;<span
												class="lname">GOMEZ</span><span class="img clear">images/img.php?src=http://www.acsr.com.ar/images/perfiles/744.jpg&w=111&h=149&zc=1</span><span
												class="cat clear">CUARTA</span><span class="age clear">35</span><span
												class="url clear">http://www.acsr.com.ar/perfiles/j744/gomez-gaston-ariel.html</span>
										</h2>
										<span class="score">250</span><span class="arrow"></span></li>
								</ul>
							</div>
							
							
							
						</div>
						
						<!-- HEAD TO HEAD -->
						<div class="h2h-home mt10">
							<h3 class="title">HEAD TO HEAD</h3>
							<div class="moduleContentOuter">
								<div class="moduleContentInner">
									<div class="head2headPremade">
										<div class="actionShot IE6pngFix">
											<a href="perfiles/j76/loson-franco.html" class="raised"><img
												width="111" height="149" alt="LOSON, FRANCO"
												title="LOSON, FRANCO" src="images/perfiles/default.jpg"></a>
										</div>
										<div class="head2headPreStats raised IE6pngFix">
											<h4>HISTORIAL DE PARTIDOS</h4>
											<a class="head2headPreName1 pb10"
												href="perfiles/j76/loson-franco.html">LOSON, FRANCO</a> <a
												class="head2headPreName2 pb10"
												href="perfiles/j384/bianchi-leonardo.html">BIANCHI,
												LEONARDO</a>
											<p class="head2headPreScore">3 - 3</p>
											<p class="head2headPreLinks mt10">
												<a
													href="http://www.acsr.com.ar/index.php?c=head2head&amp;pId=76&amp;oId=384"
													class="genericButton"><span>Ver Detalles</span></a>
											</p>
										</div>
										<div class="actionShot  IE6pngFix">
											<a href="perfiles/j384/bianchi-leonardo.html" class="raised"><img
												width="111" height="149" alt="BIANCHI, LEONARDO"
												title="BIANCHI, LEONARDO" src="images/perfiles/1.jpg"></a>
										</div>
									</div>
									<p>
										Ingrese el apellido de los jugadores y seleccionar de la lista
										para ver la comparación.<br>
									</p>
									<form action="#" method="get" class="head2headEntryFields">
										<div class="head2headEntryField1">
											<input type="text" value="Ingresar Jugador 1" id="autoComp1"
												autocomplete="off" class="ac_input"
												onkeypress="autosuggest_jugadores('#autoComp1', '#resultspId', '#pId', 1);"
												onblur="if (!this.value) {this.value = 'Ingresar Jugador 1'}"
												onfocus="if (this.value == 'Ingresar Jugador 1') {this.value = ''}"><input
												type="hidden" name="pId" id="pId" class="autoCompId"><div
														id="resultspId" class="results results-h2h raised"></div>
										</div>
										<p>VS</p>
										<div class="head2headEntryField2">
											<input type="text" value="Ingresar Jugador 2" id="autoComp2"
												autocomplete="off" class="ac_input"
												onkeypress="autosuggest_jugadores('#autoComp2', '#resultsoId', '#oId', 1);"
												onblur="if (!this.value) {this.value = 'Ingresar Jugador 2'}"
												onfocus="if (this.value == 'Ingresar Jugador 2') {this.value = ''}">
												<input type="hidden" name="oId" id="oId" class="autoCompId">
													<div id="resultsoId" class="results results-h2h raised"></div>
													<input type="hidden" name="c" id="c" value="head2head">
										</div>
										<div class="genericButton">
											<button type="button" onclick="onSearch();">Enviar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- Fin HEAD TO HEAD -->

				</div>

			</div>
    </div> 
    </div>
</body>
</html>
    
    