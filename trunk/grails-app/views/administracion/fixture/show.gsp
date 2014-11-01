<%@page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion" />	
	<r:require module="fixture" />
</head>
<body>
	
	<h3>Fixture del Torneo: ${categoria?.nombre}
	<g:select name="categoria" from='${categorias}' value="${categoria?.id }"
					class="profile-year" id="categoria" style="margin-left: 40%;"/>
	</h3>	
	
	<g:render template="/administracion/fixture/verFixtureTorneo"/>		
		
</body>
</html>
