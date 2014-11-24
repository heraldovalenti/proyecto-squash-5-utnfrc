<%@page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion" />	
	<r:require module="fixture" />
</head>
<body>
	
	<fieldset class="buttons">
    		<g:link controller="diagramacion" action="verTorneo"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
	</fieldset>
	
	
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
