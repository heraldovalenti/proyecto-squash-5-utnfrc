<html>
<head>
	<title><g:message code="iniciosesion.titulo" /></title>
	<meta name="layout" content="login" />
	
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'login.css') }" type="text/css" rel="stylesheet">
</head>
<body>	
	<!-- div para formulario de inicio de sesion -->		
		<!-- titulo de inicio de sesion -->
		<h3 class="title"><g:message code="iniciosesion.titulo" /></h3>		
			
			<!-- control de visualizacion de mensajes de error -->
			<g:if test="${flash.message}">
				<ul class="errors" role="alert">
					<li>${flash.message}</li>
				</ul>
			</g:if>
			
			<div class="textoUsuario" >
			<p>
			Si dispone de nombre de usuario y contraseña, ingrese los datos y haga click en "
			<b>Iniciar Sesión</b>
			".Sino dispone de un usuario presione el botón "
			<b>Crear Cuenta</b>
			"
			</p>			
			</div>
			
			
			
			<!-- formulario de inicio de sesion -->
			<g:form controller="Usuario" action="login">
			
				<!-- campos del formulario -->
				
			<div class="camposUsuario">
					
					<!-- field: nombre de usuario -->
					<div class="candado">
					</div>
					<div class="filaLogin">
						<label for="nombreUsuario">
							<g:message code="iniciosesion.nombreusuario.label" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="nombreUsuario" type="text" required=""/>
					</div>
					
					<!-- field: password -->
					<div class="filaLogin">
						<label for="password">
							<g:message code="iniciosesion.password.label" />
							<span class="required-indicator">*</span>
						</label>
						<g:passwordField name="password" type="password" required="" />
					</div>
					
						
					<!-- botones de formulario -->
				
				
					<g:submitButton name="create" class="enviar" value="${ message(code: 'iniciosesion.submit.label') }" />	
					<g:submitButton name="Crear Cuenta" class="boton_verde" controller="usuario" action="registro" />
					
					<g:link text= "Crear Cuenta" controller="usuario" action="registro" class="boton_verde" style="margin: 3px;" />
					
								
			</div>	
			</g:form>	
			
</body>
</html>