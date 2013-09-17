<html>
<head>
	<link href="${resource(dir: 'css', file: 'css.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	<title>Imagen de perfil</title>
	<meta name="layout" content="jugador">
</head>
<body>
	<g:if test="${ flash.message }">
		<div class="message" role="status">${ flash.message }</div>
	</g:if>

	<g:if test="${ flash.error }">
		<ul class="errors" role="alert">
			<li>
				${ flash.error }
			</li>
		</ul>
	</g:if>
		
	<g:form controller="jugador" action="updateImagenPerfil" method="post" enctype="multipart/form-data">
		<fieldset id="form_inicio_sesion" class="form" >
			
			<div class="fieldcontain required">
				<label for="imagenPerfilActual">
					Imagen de perfil actual
				</label>
				<img width="148" height="198" alt="Imagen de perfil" 
					src="${ resource(dir: 'images/perfiles', file: imagenPerfil) }" />
			</div>
			
			<div class="fieldcontain required">
				<label for="imagenPerfilNueva">
					Nueva imagen de perfil
				</label>
				<input type="file" name="imagenPerfil" />
			</div>
			
		</fieldset>
		
		<fieldset class="buttons">
			<g:submitButton name="create" class="enviar" value="Enviar" />
		</fieldset>
	</g:form>
</body>
</html>