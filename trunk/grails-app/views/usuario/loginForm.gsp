<html>
<head>
	<title><g:message code="iniciosesion.titulo" /></title>
	<meta name="layout" content="login" />
	
	<link href="${resource(dir: 'css', file: 'errors.css') }" type="text/css" rel="stylesheet"><%--
	<link href="${resource(dir: 'css', file: 'login.css') }" type="text/css" rel="stylesheet">
	--%><link href="${resource(dir: 'css', file: 'bootstrap.min.css') }" type="text/css" rel="stylesheet">
	
	<%--<r:require modules="bootstrap,jquery"/>
	<r:layoutResources />
	
--%></head>
<body><%--	
	 div para formulario de inicio de sesion -->		
		--%><!-- titulo de inicio de sesion -->
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
					<div class="filaLogin">						
						<input type="text" name="nombreUsuario" class="form-control" placeholder="Nombre de usuario"/>
					</div>
					
					<!-- field: password -->
					<div class="filaLogin">						
						<input type="password" name="password"  class="form-control" placeholder="Contraseña" />
					</div>									
					<%--<div class="candado">
					</div>				
						
					--%><!-- botones de formulario -->
			<div class="filaLogin">
				<g:submitButton name="create" class="btn btn-primary"
					value="Inicar Sesión" />
				<g:actionSubmit value="Crear Cuenta" controller="usuario"
					action="registro" class="btn btn-success" />
				Olvide mi contraseña
			</div>
					
			<%--<div class="filaLogin">
				<g:link value="Olvide mi contraseña" controller="usuario"
					action="registro"/>
			</div>
					
								
			--%></div>	
			</g:form>	
</body>
</html>