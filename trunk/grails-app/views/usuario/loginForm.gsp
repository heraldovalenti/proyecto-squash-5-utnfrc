<html>
<head>
	<title>Iniciar sesion</title>
	 <meta name="layout" content="main" />
	 
	 <link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	 <link href="${resource(dir: 'css', file: 'grid_16.css') }" type="text/css" rel="stylesheet">
	 <link href="${resource(dir: 'css', file: 'style2.css') }" type="text/css" rel="stylesheet">
	 <link href="${resource(dir: 'css', file: 'forms.css') }" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container_16">
		<div class="slides-home raised">
			<div class="second-part mt10">
				   <div class="grid_16 inside mt10">  
					<h3 class="title">Iniciar Sesion</h3>
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
			</div>
		</div>
	</div>
</body>
</html>