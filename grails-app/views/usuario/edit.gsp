<%@ page import="sgt.Usuario" %>

<html>
<head>
		<meta name="layout" content="jugador">
	</head>
<body>

	<div id="edit-datosJugador" class="content scaffold-edit">
		<h1>Cuenta de usuario</h1>
		
		<g:render template="/utils/messages"/>
		
		<!-- control de visualizacion de errores en instancia -->
		
			
			
		<!-- formulario de registro -->
		<form id="form-registro-usuario" method="POST">
			
			<!-- campos del formulario -->
			<div class="camposUsuario">
			
			
			<fieldset id="form_inicio_sesion" class="form" >		
							
				<!-- field: password -->
				<div class="fieldcontain">
					<label for="password">
						<g:message code="registrousuario.password.label" />
						<span class="required-indicator">*</span>
					</label>
					<g:passwordField name="password" type="password" required="" value="${usuarioInstance?.password}"class="form-control"/>
				</div>
				
				<!-- field: password2 -->
				<div class="fieldcontain">
					<label for="password2">
						<g:message code="registrousuario.password.reingresolabel" />
						<span class="required-indicator">*</span>
					</label>
					<g:passwordField name="password2" type="password" required="" value="${usuarioInstance?.password}" class="form-control"/>
				</div>
				
				<!-- field: correo electronico -->
				<div class="fieldcontain">
					<label for="correo">
						<g:message code="registrousuario.correo.label" />
						<span class="required-indicator">*</span>
					</label>
					<g:textField name="correo" type="text" required="" class="form-control" value="${ usuarioInstance?.correo }"/>
				</div>
				
			</fieldset>
			
			<!-- botones del formulario -->
						
			<fieldset class="buttons">
				<g:actionSubmit class="save" controller="jugador" action="update" value="Guardar"/>
			</fieldset>
			
		</div>	
		</form>	
	<%--<r:require modules="dialogs, usuarios"/>
--%></body>
</html>