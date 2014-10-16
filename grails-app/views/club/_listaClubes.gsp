<body>

	<div class="box mb10 box-225">
		<h3 class="title">Clubes de Córdoba</h3>
		<div id="news-result" class="inner-box">
			<g:each in="${listadoClub}" var="club">
				<li><a><g:link controller="club" action="listarClubes" params="[club:club.id]">${ club.nombre }</g:link></a></li>
			</g:each>

		</div>
	</div>
<body>