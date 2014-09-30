<%@ page import="sgt.Cancha"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>

<body>
	<g:link controller="cancha" action="list">Volver</g:link>
	<div id="create-cancha" class="content scaffold-create" >
		<h1>Registro de nueva cancha</h1>
		<g:render template="/utils/messages"/>
		
		<g:form action="save">
			<fieldset class="form">
				<g:render template="/club/canchas/form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Guardar" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
