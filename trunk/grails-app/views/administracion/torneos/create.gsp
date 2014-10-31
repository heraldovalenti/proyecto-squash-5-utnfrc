<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
		
		<div class="nav" >
			<ul>
				<li><g:link controller="torneo" action="list">Volver</g:link></li>
			</ul>
		</div>
		<div id="create-torneo" class="content scaffold-create" >
			<h1>Nuevo Torneo</h1>
			
			<g:render template="/utils/messages" />
			
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="/administracion/torneos/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
