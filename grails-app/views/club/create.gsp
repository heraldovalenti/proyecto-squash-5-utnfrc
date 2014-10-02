<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>
<body>
	<div id="create-club" class="content scaffold-create" role="main">
		<h1>Datos de Club</h1>
		<g:render template="/utils/messages"/>
		
		<g:form action="save" method="post" name="form-datos-club" enctype="multipart/form-data">
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Guardar" />
			</fieldset>
		</g:form>
	</div>
	<r:require modules="imagenes, club"/>
</body>
</html>
