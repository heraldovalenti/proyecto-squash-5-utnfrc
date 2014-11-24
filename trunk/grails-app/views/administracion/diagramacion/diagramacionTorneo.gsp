<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion">
</head>
<body>
	<fieldset class="buttons">
    		<g:link action="verTorneo"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
    		<g:link action="getPartidos" elementId="action-cancelar"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-closethick"></span><span style="padding-left: 18px;">Cancelar cambios</span> </g:link>
    		<g:link action="savePartidos" elementId="action-guardar"><span  style="position: absolute; height: 20px" class="ui-icon ui-icon-disk"></span><span style="padding-left: 18px;">Guardar diagramacion</span> </g:link>
	</fieldset>
	
	<div id="diagramacion-table">
		<r:require modules="diagramacion, dialogs" />
	</div>
</body>
</html>