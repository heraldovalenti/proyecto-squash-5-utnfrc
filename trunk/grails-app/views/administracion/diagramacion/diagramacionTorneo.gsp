<%@ page import="sgt.Cancha" %>

<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="administracion">
</head>
<body>
	<div id="diagramacion-table" class="">
		<div id="diagramacion-rondas" class="box ui-tabs ui-widget ui-widget-content ui-corner-all contenedor-multi">
			<div class="ronda box ui-corner-all" ronda="1">
				<div class="partido ui-widget-header ui-corner-all" ronda="1">
					<span class="info">1ra ronda</span>
					<span class="info">Primera - masculinos</span>
					<span class="jugador">Heraldo Valenti</span>
					<span class="jugador">Guillermo Fank</span>
				</div>
				<div class="partido ui-widget-header ui-corner-all" ronda="1">2</div>
				<div class="partido ui-widget-header ui-corner-all" ronda="1">3</div>
				<div class="partido ui-widget-header ui-corner-all" ronda="1">4</div>
			</div>
			<div class="ronda box ui-corner-all" ronda="2">
				<div class="partido ui-widget-header ui-corner-all" ronda="2">1</div>
			</div>
			<div class="ronda box ui-corner-all" ronda="3">
				<div class="partido ui-widget-header ui-corner-all" ronda="3">1</div>
				<div class="partido ui-widget-header ui-corner-all" ronda="3">2</div>
				<div class="partido ui-widget-header ui-corner-all" ronda="3">3</div>
				<div class="partido ui-widget-header ui-corner-all" ronda="3">1</div>
			</div>
		</div>
		
		<r:require module="diagramacion" />
		
		<%--
		<li>
			<a href="#cancha-{cancha.numero}>Cancha {cancha.numero} // N-{cancha.nombre}
		</li>
		<div id="cancha-3">
			<div class="horario-cancha ui-corner-all contenedor-single">
				<ul class="horario-cancha-fecha">
					<li>Miercoles</li>
					<li>03-01-2014</li>
					<li>09:00-10:00</li>
				</ul>
			</div>
		</div>
		--%>
	</div>
</body>
</html>