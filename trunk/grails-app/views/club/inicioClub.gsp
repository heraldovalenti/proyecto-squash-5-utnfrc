<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>
<body>
	<div>	
	<g:if test="${ club }">
		<g:render template="clubCard" />
	</g:if>
	
	<g:else>
	<h2>Perfil publico de club no disponible</h2>
	<div>
	<p>Para generar un perfil publico deben registrarse
	<g:link controller="club" action="datosClub">los datos del club</g:link>.</p>
	</div>
	</g:else>
	</div>
</body>
</html>