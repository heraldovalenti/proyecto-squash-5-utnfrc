<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<r:require module="graficoInscriptosPorTorneo"/>
	</head>	
	<body>		
		<div id="list-partido" class="content scaffold-list" role="main">
			<h1>Gráfico de Jugadores Inscriptos por Torneo en 
			<g:select name="year" from="${2014..2000 }"	class="profile-year" id="calendar_year" />
			</h1>
			<div id="chart1" style="height:50%;width:100%;background-color: white;;position: relative; " class="jqplot-target"></div>
		</div>
	</body>
</html>