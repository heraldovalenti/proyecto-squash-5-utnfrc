<%@page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion" />	
	<r:require module="fixture" />
</head>
<body>
	<div class="nav">
		<ul>
			<li><g:link controller="diagramacion" action="verTorneo" >Volver</g:link>
		</ul>
	</div>
	
	<h3>Fixture del Torneo:</h3>
	<fieldset class="buttons">	
		<div style="float: right">
			<label>Categoría: </label>
			<g:select name="categoria" from='${categorias}' value="${categoria?.id }"
			class="profile-year" id="categoria"/>
		</div>
	</fieldset>	
	
	<g:render template="/administracion/fixture/verFixtureTorneo"/>		
		
</body>
</html>
