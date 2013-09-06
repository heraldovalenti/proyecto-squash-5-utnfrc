<%@ page import="sgt.Usuario" %>

<html>
<head>
	<title><g:message code="registrousuario.titulo" /></title>
	<meta name="layout" content="main" />
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- div para el formulario de registro de usuario -->
	<div id="div_registro_usuario" class="content scaffold-create" role="main">
		
		<!-- titulo de registro de usuario -->
		<h1><g:message code="registrousuario.titulo" /></h1>
		
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
			
		<!-- formulario de registro -->
		<g:form controller="Usuario" action="save">
			
			<!-- campos del formulario -->
			<fieldset id="form_inicio_sesion" class="form" >
				
				<!-- field: nombre de usuario -->
				<div class="fieldcontain required">
					<label for="nombreUsuario">
						<g:message code="registrousuario.nombreusuario.label" />
						<span class="required-indicator">*</span>
					</label>
					<g:textField name="nombreUsuario" type="text" required="" value="${ usuarioInstance?.nombreUsuario }"/>
				</div>
				
				<!-- field: password -->
				<div class="fieldcontain required">
					<label for="password">
						<g:message code="registrousuario.password.label" />
						<span class="required-indicator">*</span>
					</label>
					<g:passwordField name="password" type="password" required=""/>
				</div>
				
				<!-- field: password2 -->
				<div class="fieldcontain required">
					<label for="password2">
						<g:message code="registrousuario.password.reingresolabel" />
						<span class="required-indicator">*</span>
					</label>
					<g:passwordField name="password2" type="password" required=""/>
				</div>
				
				<!-- field: correo electronico -->
				<div class="fieldcontain required">
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
		</g:form>
	</div>		
</body>
</html>