<html>
<head>
	<title><g:message code="iniciosesion.titulo" /></title>
	<meta name="layout" content="main" />
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'login.css') }" type="text/css" rel="stylesheet">
</head>
<body>	
	<!-- div para formulario de inicio de sesion -->
	<div id="div_inicio_sesion" class="content scaffold-create" role="main">
		
		<!-- titulo de inicio de sesion -->
		<h1 class="h1-login"><g:message code="iniciosesion.titulo" /></h1>		
			
			<!-- control de visualizacion de mensajes de error -->
			<g:if test="${flash.message}">
				<ul class="errors" role="alert">
					<li>${flash.message}</li>
				</ul>
			</g:if>
			
			<!-- formulario de inicio de sesion -->
			<g:form controller="Usuario" action="login">
			
				<!-- campos del formulario -->
				<fieldset id="form_inicio_sesion" class="form" >
					
					<!-- field: nombre de usuario -->
					<div class="fieldcontain required">
						<label for="nombreUsuario">
							<g:message code="iniciosesion.nombreusuario.label" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="nombreUsuario" type="text" required=""/>
					</div>
					
					<!-- field: password -->
					<div class="fieldcontain required">
						<label for="password">
							<g:message code="iniciosesion.password.label" />
							<span class="required-indicator">*</span>
						</label>
						<g:passwordField name="password" type="password" required="" />
					</div>
					
					<!-- botones de formulario -->
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="enviar" value="${ message(code: 'iniciosesion.submit.label') }" />
					<g:link controller="usuario" action="loginFormClub">Inicio de Clubes</g:link>
				</fieldset>
			</g:form>
	</div>
</body>
</html>