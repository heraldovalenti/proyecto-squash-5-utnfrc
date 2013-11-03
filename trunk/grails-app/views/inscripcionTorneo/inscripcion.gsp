<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
</head>
<body>
	<h3>Inscripcion a torneo</h3>
	
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>		
			
	<div>
		<ul>
			<li>Ver mi disponibilidad horaria</li>
			<li>Inscripcion</li>
		</ul>
	</div>		
	
	<div>
		<p>INFORMACION DE TORNEO</p>
		<p>(_torneoCard.gsp)</p>
	</div>
</body>
</html>
