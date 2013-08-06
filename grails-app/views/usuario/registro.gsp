<html>
<head>
	<title>Registro</title>
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
					<h3 class="title">Registro</h3>
					<form action="/SistemaGestionTorneo/usuario/registrar" method="post" class="registro">
					<fieldset class="form">
						<div class="fieldcontain  required">
							<label for="nombreUsuario"> Nombre Usuario </label> 
							<input type="text" name="nombreUsuario" value="" id="nombreUsuario" required=""/>
						</div>
						<div class="fieldcontain  required">
							<label for="password"> Password </label> 
							<input type="password" name="password" value="" id="password" required=""/>
						</div>
						<div class="fieldcontain  required">
							<label for="password2"> Repita el password </label> 
							<input type="password" name="password2" value="" id="password2" required=""/>
						</div>
						<div class="fieldcontain  required">
							<label for="password2"> E-mail </label> 
							<input type="text" name="correo" value="" id=""correo"" required=""/>
						</div>
					</fieldset>
					<fieldset class="buttons">
						<input type="submit" name="create" class="" value="Enviar" />
					</fieldset>
					
					<g:hasErrors bean="${ usuario }">
					  <ul>
					   <g:eachError var="err" bean="${ usuario }">
					       <li>${err}</li>
					   </g:eachError>
					  </ul>
					</g:hasErrors>
					
				</form>
				</div>  
			</div>
		</div>
	</div>
</body>
</html>