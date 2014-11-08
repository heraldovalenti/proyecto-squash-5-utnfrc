<head>
<link href="${resource(dir: 'css', file: 'jugador.css') }"
	type="text/css" rel="stylesheet" />
<r:require module="menu" />
</head>

<body>
	<div class="mb10">
		<div id="news-result" class="inner-box">
			<ul id="menuCategoria">
				<li><a href="#">Masculinos</a>
					<ul>
						<g:each in="${categorias}" var="categoria">
							<g:if test="${categoria.modalidadCategoria == 'Masculino'}">
								<g:if test="${tipo == 'jugador'}">
									<li style="display:none;"><g:link controller="jugador" action="obtenerJugadores"
											params="[categoria:categoria.nombre]">
											${ categoria.nombre }
										</g:link></li>
								</g:if>
								<g:elseif test="${tipo == 'ranking'}">
									<li style="display:none;"><g:link controller="jugador"
											action="obtenerRankingJugadores"
											params="[categoria:categoria.nombre]">
											${ categoria.nombre }
										</g:link></li>
								</g:elseif>
							</g:if>
						</g:each>
					</ul>
				</li>
				<li><a href="#">Femeninos</a>
					<ul>
						<g:each in="${categorias}" var="categoria">
							<g:if test="${categoria.modalidadCategoria == 'Femenino'}">
								<g:if test="${tipo == 'jugador'}">
									<li style="display:none;"><a><g:link controller="jugador"
												action="obtenerJugadores"
												params="[categoria:categoria.nombre]">
												${ categoria.nombre }
											</g:link></a></li>
								</g:if>
								<g:elseif test="${tipo == 'ranking'}">
									<li style="display:none;"><g:link controller="jugador"
											action="obtenerRankingJugadores"
											params="[categoria:categoria.nombre]">
											${ categoria.nombre }
										</g:link></li>
								</g:elseif>
							</g:if>
						</g:each>
					</ul></li>

			</ul>
		</div>
	</div>
<body>