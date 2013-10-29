<%@ page import="sgt.Usuario" %>

<html>
<head>
	<title><g:message code="registrousuario.titulo" /></title>
	<meta name="layout" content="registroUsuario" />
	<link href="${resource(dir: 'css', file: 'login.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- div para el formulario de registro de usuario -->
		
		<!-- titulo de registro de usuario -->
		<h3 class="title"><g:message code="registrousuario.titulo" /></h3>
		
		<!-- control de visualizacion de mensajes -->
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		
		<!-- control de visualizacion de errores en instancia -->
		<g:hasErrors bean="${usuarioInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${usuarioInstance}" var="error">
					<li>
						<g:message error="${error}"/>
					</li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		
		<div class="textoUsuario" >
			<p>			
			<b>Aclaración:</b>
			El nombre de usuario y contraseña debe tener más de seis caracteres cada uno.			
			</p>			
		</div>		
			
		<!-- formulario de registro -->
		<g:form controller="Usuario" action="save">
			
			<!-- campos del formulario -->
			<div class="camposUsuario">
			
			
			<fieldset id="form_inicio_sesion" class="form" >
				
				<!-- field: nombre de usuario -->
				<div class="filaLogin">
					<label for="nombreUsuario">
						<g:message code="registrousuario.nombreusuario.label" />
						<span class="required-indicator">*</span>
					</label>
					<g:textField name="nombreUsuario" type="text" required="" value="${ usuarioInstance?.nombreUsuario }"/>
				</div>
				
				<!-- field: password -->
				<div class="filaLogin">
					<label for="password">
						<g:message code="registrousuario.password.label" />
						<span class="required-indicator">*</span>
					</label>
					<g:passwordField name="password" type="password" required=""/>
				</div>
				
				<!-- field: password2 -->
				<div class="filaLogin">
					<label for="password2">
						<g:message code="registrousuario.password.reingresolabel" />
						<span class="required-indicator">*</span>
					</label>
					<g:passwordField name="password2" type="password" required=""/>
				</div>
				
				<!-- field: correo electronico -->
				<div class="filaLogin">
					<label for="correo">
						<g:message code="registrousuario.correo.label" />
						<span class="required-indicator">*</span>
					</label>
					<g:textField name="correo" type="text" required="" value="${ usuarioInstance?.correo }"/>
				</div>
				
			</fieldset>
			
			<!-- botones del formulario -->
			<fieldset class="buttons">
				<g:submitButton name="create" class="enviar" value="${ message(code: 'registrousuario.enviar.label') }" />
			</fieldset>
		</div>	
		</g:form>
			
</body>
</html>