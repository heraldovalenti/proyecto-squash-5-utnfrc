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
		<h1>Iniciar Sesion</h1>

		<form action="/SistemaGestionTorneo/usuario/login" method="post">
			<fieldset class="form">

				<div class="fieldcontain  required">
					<label for="nombreUsuario"> Nombre Usuario </label> 
					<input type="text" name="nombreUsuario" value="" id="nombreUsuario" required=""/>
				</div>

				<div class="fieldcontain  required">
					<label for="password"> Password </label> 
					<input type="password" name="password" value="" id="password" required=""/>
				</div>
				
			</fieldset>
			<fieldset class="buttons">
				<input type="submit" name="create" class="save" value="Enviar"
					id="create" />
			</fieldset>
		</form>
	</div>

	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display: none;">Loading&hellip;</div>

	<script src="/SistemaGestionTorneo/static/js/application.js"
		type="text/javascript"></script>
</body>
</html>