<html>
<head>
	<title>Iniciar sesion</title>
	 <meta name="layout" content="main" />
	 
	 <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/css.css" media="all" />
	 <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar//css/grid_16.css" media="all" />
	 <link rel="stylesheet" type="text/css" href="http://www.acsr.com.ar/js/news/css/style2.css" />
	 
	 <link href="${resource(dir: 'css', file: 'forms.css') }" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="login-form" role="main" class="content scaffold-create">
		<h1>Iniciar Sesion</h1>
		<form action="/SistemaGestionTorneo/usuario/login" method="post" class="login">
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
				<input type="submit" name="create" class="" value="Enviar" />
			</fieldset>
		</form>
	</div>
</body>
</html>