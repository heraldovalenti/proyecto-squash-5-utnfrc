<%@ page import="sgt.Partido" %>
<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion">
</head>
<body>
	<div class="nav">
		<ul>
			<li><g:link action="verTorneo" >Volver</g:link>
			<li><g:link action="getPartidos" elementId="action-cancelar">Cancelar cambios</g:link>
			<li><g:link action="savePartidos" elementId="action-guardar">Guardar diagramacion</g:link></li>
		</ul>
	</div>
	<div id="diagramacion-table">
		<r:require modules="diagramacion, dialogs" />
	</div>
</body>
</html>