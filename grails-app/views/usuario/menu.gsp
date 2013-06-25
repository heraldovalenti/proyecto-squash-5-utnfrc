<html>
<head>
<link rel="stylesheet" href="/SistemaGestionTorneo/static/css/main.css"
	type="text/css">
</head>
<body>
	<div id="grailsLogo" role="banner">
		<a href="http://grails.org"><img
			src="/SistemaGestionTorneo/static/images/grails_logo.png"
			alt="Grails" /></a>
	</div>
	<a href="#create-usuario" class="skip" tabindex="-1">Skip to
		content&hellip;</a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="/SistemaGestionTorneo/">Principal</a></li>
			<li><a href="/SistemaGestionTorneo/usuario/list" class="list">Usuario
					Lista</a></li>
		</ul>
	</div>
	<div id="create-usuario" class="content scaffold-create" role="main">
		<h1>Bienvenido</h1>

		<fieldset class="form">

			<div class="fieldcontain  ">
				<label for="nombreUsuario"> Nombre Usuario: ${user.nombreUsuario} </label>
			</div>
			<div class="fieldcontain  ">
				<label for="password"> Password: ${user.password}</label>
			</div>
		</fieldset>
		
		<fieldset class="buttons">
			<a href="/SistemaGestionTorneo/usuario/logout" class="delete">Cerrar Sesion</a>
		</fieldset>
	</div>

	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display: none;">Loading&hellip;</div>

	<script src="/SistemaGestionTorneo/static/js/application.js"
		type="text/javascript"></script>
</body>
</html>